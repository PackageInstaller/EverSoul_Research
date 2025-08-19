# Eversoul 伤害计算公式详细分析

## 伪代码与现有文档对比分析

### 1. 主要伤害计算流程 (GetDamage函数)

根据伪代码，完整的伤害计算流程如下：

```cpp
int64_t GetDamage(damage, attackerStatus, defence, penetration, penetrationRate, 
                  isCritical, criticalValue, source, damageRate)
{
    // 1. 获取种族相克系数
    MatchupValue = GetMatchupValue(attackerStatus, defence->RaceType)
    
    // 2. 获取抗性值
    Resist = GetResist(attackerStatus->StatType, penetration, penetrationRate, defence)
    
    // 3. 获取防御值
    Defense = GetDefense(penetration, penetrationRate, defence)
    
    // 4. 计算防御减伤后的伤害
    if (Defense >= 0):
        damageAfterDefense = damage - (Defense / (Defense + 0.3 * damage)) * damage
    else:
        damageAfterDefense = damage
    
    // 5. 应用种族相克和抗性
    damageAfterResist = MatchupValue * damageAfterDefense * Max(1.0 - Resist, 0.1)
    
    // 6. 应用暴击
    if (isCritical):
        damageAfterCrit = damageAfterResist * criticalValue
    else:
        damageAfterCrit = damageAfterResist
    
    // 7. 应用伤害倍率
    if (damageRate != 0):
        damageWithRate = (damageRate + 1.0) * damageAfterCrit
    else:
        damageWithRate = damageAfterCrit
    
    // 8. 应用技能类型倍率
    switch (source):
        case BaseAttack (7):
            skillRate = attackerStatus->BaseAttackRate
        case NormalSkill (8):
            skillRate = attackerStatus->SubSkillRate
        case ActiveSkill (9):
            skillRate = attackerStatus->ActiveSkillRate
        case UltimateSkill (10):
            skillRate = attackerStatus->UltimateSkillRate
    
    if (skillRate != 0):
        finalDamage = (skillRate + 1.0) * damageWithRate
    else:
        finalDamage = damageWithRate
    
    // 9. 确保最小伤害
    return Max(finalDamage, 1)
}
```

### 2. 与现有文档的差异

#### 2.1 缺失的种族相克计算

现有文档中完全没有提到种族相克(Race Matchup)的计算，但伪代码显示这是伤害计算的重要部分：

```cpp
double GetMatchupValue(attackerStatus, defenceRaceType)
{
    // 基础相克值从种族相克表中获取
    baseMatchup = RaceCounterInfos->GetMatchupValue(attackerStatus->RaceType, defenceRaceType)
    
    // 如果相克值大于1.0（优势），额外增加特殊攻击值
    if (baseMatchup > 1.0):
        baseMatchup += attackerStatus->SpecialAttackValues[0x1ADE3]
    
    // 加上针对特定种族的特殊攻击值
    specialAttack = attackerStatus->SpecialAttackValues[defenceRaceType]
    if (specialAttack != 0):
        result = baseMatchup + specialAttack
    else:
        result = baseMatchup
    
    return Max(result, 0.0)
}
```

种族相克表默认返回1.0，特定的种族组合会有不同的相克系数。

#### 2.2 穿透机制的详细说明

伪代码显示穿透类型(PenetrationType)的枚举值：
- All = 4
- Defence = 2
- 其他值（可能包括3, 5等）

**防御穿透**：
- 当penetration为2(Defence)或4(All)时，穿透率对防御值生效
- 否则穿透率不影响防御值

**抗性穿透**：
- 当(penetration - 3) < 2，即penetration为3或4时，穿透率对抗性生效
- 否则穿透率不影响抗性

现有文档的描述不够准确，需要更新。

#### 2.3 最小伤害抵抗值

伪代码确认了最小伤害抵抗系数为0.1（通过_damageResistMin变量），这与现有文档一致。

#### 2.4 DamageFormulaKeyValue

伪代码确认了这个值为0.3，用于防御减伤公式，与现有文档一致。

### 3. 完整的伤害计算公式

综合伪代码分析，完整的伤害计算公式应该是：

$$
\text{最终伤害} = \max\left(\left(1 + \text{技能倍率}\right) \times \left(1 + \text{伤害倍率}\right) \times \text{暴击系数} \times \text{种族相克} \times \text{防御后伤害} \times \max(1 - \text{抗性}, 0.1), 1\right)
$$

其中：

$$
\text{防御后伤害} = 
\begin{cases} 
\text{原始伤害} - \frac{\text{有效防御}}{\text{有效防御} + 0.3 \times \text{原始伤害}} \times \text{原始伤害}, & \text{如果有效防御} \geq 0 \\
\text{原始伤害}, & \text{如果有效防御} < 0
\end{cases}
$$

$$
\text{有效防御} = 
\begin{cases} 
(1 - \text{穿透率}) \times \text{防御值}, & \text{如果穿透类型为2或4} \\
\text{防御值}, & \text{其他情况}
\end{cases}
$$

$$
\text{有效抗性} = 
\begin{cases} 
(1 - \text{穿透率}) \times \text{抗性值}, & \text{如果穿透类型为3或4} \\
\text{抗性值}, & \text{其他情况}
\end{cases}
$$

$$
\text{暴击系数} = 
\begin{cases} 
\text{暴击威力}, & \text{如果发生暴击} \\
1, & \text{否则}
\end{cases}
$$

### 4. 其他重要发现

#### 4.1 攻击力计算

伪代码中的`BattleCharacterStatus::Get`函数显示，攻击力有特殊的计算方式：

```cpp
if (type == Status__Enum_Attack):
    finalAtkRateMin = GetFinalAtkRateMin()
    baseAttack = status[0x65]  // Status 101
    return Max((finalAtkRateMin + 1.0) * baseAttack, calculatedValue)
```

这表明攻击力有一个最终倍率下限的保护机制。

#### 4.2 状态值计算

角色的各项状态值由多个部分组成：
1. 基础值 (_status)
2. 外部加成 (_externalValue)
3. Buff加成 (_buffValue) - 固定值
4. Buff倍率加成 (_afterBuffRateValue) - 百分比

最终值 = 基础值 + 外部加成 + Buff固定值 + 基础值 × Buff百分比

### 5. 建议的文档更新

1. 添加种族相克系统的详细说明
2. 更正穿透机制的描述，明确不同穿透类型的效果
3. 补充攻击力特殊计算机制
4. 添加完整的伤害计算流程图
5. 补充各个枚举值的具体含义
