### Defense Calculation

**Defense Value Calculation:**

Defense value is calculated via the `GetDefense` function, considering penetration effects:

```
double GetDefense(penetration, penetrationRate, defence):
  if (penetration == 2 || penetration == 4):  // Penetration flag is 2 or 4, penetration rate takes effect
    return max((1.0 - penetrationRate) * defence->Status->Defence, 0.0)
  else:  // Default penetration flag is 1, penetration rate has no effect
    return max(defence->Status->Defence, 0.0)
```

The penetration mechanism can reduce the target's effective defense value. The penetration rate only takes effect when the penetration flag is 2 or 4.

The effect of defense value on damage:

$$
\text{Post-Defense Damage} = 
\begin{cases} 
\text{Base Damage} - \frac{\text{Defense Value}}{\text{Defense Value} + \text{0.3} \times \text{Base Damage}} \times \text{Base Damage}, & \text{if Defense Value} \geq 0 \\
\text{Base Damage} & \text{if Defense Value} < 0
\end{cases}
$$

### Attribute Matchup and Resistance

**Resistance Value Calculation:**

Resistance value is calculated via the `GetResist` function, based on attack type and penetration effects:

```
double GetResist(statType, penetration, penetrationRate, defence):
  // Select resistance based on attack type
  if (statType == 110044):  // Magic attack
    resist = defence->Status->MagicResist
  else:  // Physical attack
    resist = defence->Status->PhysicalResist
    
  if ((penetration - 3) < 2)::
    return (1.0 - penetrationRate) * resist
  else:
    return resist
```

Resistance is divided into magic resistance and physical resistance based on the attack type. The penetration mechanism also affects resistance values, but only when the penetration flag is 3 or 4 will the penetration rate be applied to resistance calculation.

The effect of resistance value on damage:

$$
\text{Post-Resistance Damage} = \text{Matchup Coefficient} \times \text{Post-Defense Damage} \times \max(1 - \text{Resistance Value}, \text{0.1})
$$

### Critical Hit Calculation

When a critical hit occurs:

$$
\text{Post-Critical Damage} = \text{Post-Resistance Damage} \times \text{Critical Multiplier}
$$

### Damage Rate

If a damage rate is applied:

$$
\text{Post-Damage-Rate Damage} = (1 + \text{Damage Rate}) \times \text{Post-Critical Damage}
$$

### Skill Type Multiplier

Different multipliers are applied based on skill type:

- Normal Attack (7): Uses BaseAttackRate
- Passive Skill (8): Uses SubSkillRate
- Active Skill (9): Uses ActiveSkillRate
- Ultimate Skill (10): Uses UltimateSkillRate

$$
\text{Post-Skill-Rate Damage} = (1 + \text{Skill Rate}) \times \text{Post-Damage-Rate Damage}
$$

### Final Damage

$$
\text{Final Damage} = \max(\text{Post-Skill-Rate Damage}, \text{1})
$$ 