## Eversoul 伤害计算公式完整解析

### 伤害计算总流程

根据逆向工程分析，完整的伤害计算流程如下：

1. **获取种族相克系数** - 计算攻击方与防御方的种族相克关系
2. **获取抗性值** - 根据攻击类型（物理/魔法）和穿透效果计算有效抗性
3. **获取防御值** - 根据穿透效果计算有效防御
4. **计算防御减伤** - 应用防御值对伤害的减免
5. **应用种族相克和抗性** - 将种族相克和抗性效果应用到伤害上
6. **应用暴击** - 如果触发暴击，乘以暴击威力
7. **应用伤害倍率** - 应用额外的伤害倍率修正
8. **应用技能类型倍率** - 根据技能类型应用对应的倍率
9. **确保最小伤害** - 最终伤害不低于1

### 种族相克系统

**种族相克值计算:**

```cpp
double GetMatchupValue(attackerStatus, defenceRaceType):
    // 从种族相克表获取基础相克系数
    baseMatchup = RaceCounterTable[attackerStatus->RaceType][defenceRaceType]
  
    // 如果是优势相克（系数>1.0），加上额外的优势加成
    if (baseMatchup > 1.0):
        baseMatchup += attackerStatus->SpecialAttackValues[0x1ADE3]
  
    // 加上针对特定种族的特殊攻击加成
    specialAttack = attackerStatus->SpecialAttackValues[defenceRaceType]
    if (specialAttack != 0):
        return max(baseMatchup + specialAttack, 0.0)
    else:
        return max(baseMatchup, 0.0)
```

种族相克默认系数为1.0，特定的种族组合会有不同的相克系数。

### 防御计算

**防御值计算:**

防御值通过 `GetDefense`函数计算，考虑了穿透效果:

```cpp
double GetDefense(penetration, penetrationRate, defence):
    // 穿透类型枚举值：
    // PenetrationType_All = 4
    // PenetrationType_Defence = 2
  
    if (penetration == 2 || penetration == 4):  // 防御穿透生效
        return max((1.0 - penetrationRate) * defence->Status->Defence, 0.0)
    else:  // 穿透率不影响防御
        return max(defence->Status->Defence, 0.0)
```

穿透机制可以降低目标的有效防御值。只有当穿透类型为Defence(2)或All(4)时，穿透率才会对防御生效。

防御值对伤害的影响:

$$
\text{防御后伤害} = 
\begin{cases} 
\text{原始伤害} - \frac{\text{防御值}}{\text{防御值} + \text{0.3} \times \text{原始伤害}} \times \text{原始伤害}, & \text{如果防御值} \geq 0 \\
\text{原始伤害} & \text{如果防御值} < 0
\end{cases}
$$

### 属性抗性

**抗性值计算:**

抗性值通过 `GetResist` 函数计算，基于攻击类型和穿透效果:

```cpp
double GetResist(statType, penetration, penetrationRate, defence):
    // 根据攻击类型选择对应的抗性
    // StatType_Intelligence = 110044 (魔法攻击)
    if (statType == 110044):  // 魔法攻击
        resist = defence->Status->MagicResist
    else:  // 物理攻击
        resist = defence->Status->PhysicalResist

    // 当(penetration - 3) < 2，即penetration为3或4时，穿透率对抗性生效(这里默认uint32_t)
    if ((penetration - 3) < 2):
        return (1.0 - penetrationRate) * resist
    else:
        return resist
```

抗性根据攻击类型分为魔法抗性和物理抗性。穿透机制也影响抗性值，但只有当穿透类型为3或4时，穿透率才会对抗性产生影响。

### 伤害公式整合

**基础伤害计算:**

将种族相克、防御减伤和抗性整合后：

$$
\text{减免后伤害} = \text{种族相克系数} \times \text{防御后伤害} \times \max(1 - \text{有效抗性}, 0.1)
$$

其中：

- 种族相克系数：通过 `GetMatchupValue`计算得出
- 防御后伤害：应用防御减伤公式后的伤害
- 有效抗性：考虑穿透效果后的抗性值
- 0.1：最小伤害抵抗系数（_damageResistMin）

### 暴击计算

当发生暴击时:

$$
\text{暴击后伤害} = \text{抗性后伤害} \times \text{暴击威力}
$$

### 伤害倍率

如果有伤害倍率:

$$
\text{伤害倍率后伤害} = (1 + \text{伤害倍率}) \times \text{暴击后伤害}
$$

### 技能类型倍率

根据不同的技能类型，应用不同的倍率：

- 普通攻击 (7): 使用 BaseAttackRate
- 被动技能 (8): 使用 SubSkillRate
- 主动技能 (9): 使用 ActiveSkillRate
- 终极技能 (10): 使用 UltimateSkillRate

$$
\text{技能倍率后伤害} = (1 + \text{技能倍率}) \times \text{伤害倍率后伤害}
$$

### 最终伤害

$$
\text{最终伤害} = \max(\text{技能倍率后伤害}, 1)
$$

### 完整伤害计算公式

将所有步骤整合，完整的伤害计算公式为：

$$
\text{最终伤害} = \max\Bigg((1 + \text{技能倍率}) \times (1 + \text{伤害倍率}) \times \text{暴击系数} \times \text{种族相克} \times \text{防御减伤} \times \max(1 - \text{有效抗性}, 0.1), 1\Bigg)
$$

其中各项计算如下：

**防御减伤:**

$$
\text{防御减伤} = 
\begin{cases} 
\text{原始伤害} - \frac{\text{有效防御}}{\text{有效防御} + 0.3 \times \text{原始伤害}} \times \text{原始伤害}, & \text{如果有效防御} \geq 0 \\
\text{原始伤害}, & \text{如果有效防御} < 0
\end{cases}
$$

**有效防御:**

$$
\text{有效防御} = 
\begin{cases} 
(1 - \text{穿透率}) \times \text{防御值}, & \text{穿透类型为2或4} \\
\text{防御值}, & \text{其他情况}
\end{cases}
$$

**有效抗性:**

$$
\text{有效抗性} = 
\begin{cases} 
(1 - \text{穿透率}) \times \text{抗性值}, & \text{穿透类型为3或4} \\
\text{抗性值}, & \text{其他情况}
\end{cases}
$$

**暴击系数:**

$$
\text{暴击系数} = 
\begin{cases} 
\text{暴击威力}, & \text{发生暴击} \\
1, & \text{未暴击}
\end{cases}
$$

### 重要常数

- **DamageFormulaKeyValue**: 0.3 (用于防御减伤公式)
- **最小伤害抵抗系数**: 0.1 (确保伤害不会被完全抵抗)
- **最小伤害值**: 1 (确保至少造成1点伤害)
