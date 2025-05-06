### 防御计算

**防御值计算:**

防御值通过 `GetDefense`函数计算，考虑了穿透效果:

```
double GetDefense(penetration, penetrationRate, defence):
  if (penetration == 2 || penetration == 4):  // 穿透标志位为2或4时，穿透率生效
    return max((1.0 - penetrationRate) * defence->Status->Defence, 0.0)
  else:  // 默认穿透标志位为1，穿透率无效
    return max(defence->Status->Defence, 0.0)
```

穿透机制可以降低目标的有效防御值。只有当穿透标志位为2或4时，穿透率才会生效。

防御值对伤害的影响:

$$
\text{防御后伤害} = 
\begin{cases} 
\text{原始伤害} - \frac{\text{防御值}}{\text{防御值} + \text{0.3} \times \text{原始伤害}} \times \text{原始伤害}, & \text{如果防御值} \geq 0 \\
\text{原始伤害} & \text{如果防御值} < 0
\end{cases}
$$

### 属性相克和抗性

**抗性值计算:**

抗性值通过 `GetResist` 函数计算，基于攻击类型和穿透效果:

```
double GetResist(statType, penetration, penetrationRate, defence):
  // 根据攻击类型选择对应的抗性
  if (statType == 110044):  // 魔法攻击
    resist = defence->Status->MagicResist
  else:  // 物理攻击
    resist = defence->Status->PhysicalResist

  // 穿透标志位小于5时，穿透率生效
  if ((penetration - 3) < 2):
    return (1.0 - penetrationRate) * resist
  else:
    return resist
```

抗性根据攻击类型分为魔法抗性和物理抗性。穿透机制也影响抗性值，但只有当穿透标志位小于5时，穿透率才会应用于抗性计算。

抗性值对伤害的影响:

$$
\text{抗性后伤害} = \text{相克系数} \times \text{防御后伤害} \times \max(1 - \text{抗性值}, \text{0.1})
$$

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
\text{最终伤害} = \max(\text{技能倍率后伤害}, \text{1})
$$
