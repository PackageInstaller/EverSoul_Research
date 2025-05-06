# 伤害计算函数对比分析

## 函数签名对比

**旧版本 (未混淆):**
```c
int64_t __fastcall _Battle_BattleFormula__GetDamage(
    __Battle_BattleFormula_o *this,
    int64_t damage,
    __Battle_CapturedStatus_o *attackerStatus,
    __Battle_BattleCharacter_o *defence,
    int32_t penetration,
    double penetrationRate,
    bool isCritical,
    double criticalValue,
    int32_t source,
    double damageRate,
    const MethodInfo *method)
```

**新版本 (混淆):**
```c
__int64 __fastcall sub_4719114(
    __int64 a1,
    __int64 a2,
    __int64 a3,
    __int64 a4,
    unsigned int a5,
    char a6,
    int a7,
    long double a8,
    double a9,
    double a10)
```

## 参数映射

| 旧版本参数 | 新版本参数 | 说明 |
|-----------|-----------|------|
| this | a1 | 战斗公式对象 |
| damage | a2 | 原始伤害值 |
| attackerStatus | a3 | 攻击者状态 |
| defence | a4 | 防御者状态 |
| penetration | a5 | 穿透标志位 |
| isCritical | a6 | 是否暴击 |
| source | a7 | 技能类型 |
| penetrationRate | a8 | 穿透率 |
| criticalValue | a9 | 暴击倍率 |
| damageRate | a10 | 伤害倍率 |

## 计算流程对比

### 1. 初始化检查

两个版本都有初始化检查，格式略有不同但功能相同：
- 旧版本: `if ((byte_99364FA & 1) == 0)`
- 新版本: `if ((unk_9C8EC1F & 1) == 0)`

### 2. 防御者有效性检查

两个版本都检查防御者是否有效：
- 旧版本: `if (!defence)` 和 `OverrideStatus = defence->fields.OverrideStatus; if (!OverrideStatus)`
- 新版本: `if (!a4)` 和 `v20 = *(_QWORD *)(a4 + 120); if (!v20)`

### 3. 种族相克系数计算

两个版本都计算种族相克系数：
- 旧版本: `MatchupValue = _Battle_BattleFormula__GetMatchupValue(...)`
- 新版本: `v22 = sub_4719368(...); v24 = v23;` (v24存储相克系数)

### 4. 抗性计算

两个版本都计算抗性：
- 旧版本: `Resist = _Battle_BattleFormula__GetResist(...)`
- 新版本: `v25 = sub_4719484(...); v27 = v26;` (v27存储抗性值)

### 5. 防御值计算

两个版本都计算防御值：
- 旧版本: `Defense = _Battle_BattleFormula__GetDefense(...)`
- 新版本: `v28 = sub_47194EC(...); v29 = ...` (v29存储防御后伤害)

### 6. 防御公式应用

两个版本使用相同的防御公式：
```c
// 旧版本
v32 = Defense >= 0.0
    ? (double)damage - Defense / (Defense + _Battle_BattleFormula__get_DamageFormulaKeyValue(this, v30) * (double)damage) * (double)damage
    : (double)damage;

// 新版本
v29 = v28 >= 0.0 
    ? (double)a2 - v28 / (v28 + sub_471847C(a1) * (double)a2) * (double)a2 
    : (double)a2;
```

### 7. 抗性下限获取

两个版本都获取抗性下限：
- 旧版本: `v34 = SecuredFloat__Get(damageResistMin, 0LL);`
- 新版本: `v31 = sub_4D6D618(v30, 0LL); v32 = *(float *)&v31;`

### 8. 应用抗性和种族相克

两个版本使用相同的公式：
```c
// 旧版本
v35 = MatchupValue * (v32 * System_Math__Max_137418400(1.0 - Resist, v34, 0LL));

// 新版本
*(double *)&v33 = v24 * (v29 * sub_8634240(0LL, 1.0 - v27, v32));
```

### 9. 暴击计算

两个版本都有暴击计算：
```c
// 旧版本
if (isCritical)
  v35 = v35 * criticalValue;

// 新版本
if ((a6 & 1) != 0)
  *(double *)&v33 = *(double *)&v33 * a9;
```

### 10. 处理无穷大情况

两个版本都处理无穷大情况：
```c
// 旧版本
if (v35 == INFINITY)
  v36 = 0x8000000000000000LL;
else
  v36 = (__int64)v35;

// 新版本
if (*(double *)&v33 == INFINITY)
  v34 = 0x8000000000000000LL;
else
  v34 = (__int64)*(double *)&v33;
```

### 11. 应用伤害倍率

两个版本都应用伤害倍率：
```c
// 旧版本
if (damageRate != 0.0) {
  v37 = (damageRate + 1.0) * (double)v36;
  if (v37 == INFINITY)
    v36 = 0x8000000000000000LL;
  else
    v36 = (__int64)v37;
}

// 新版本
if (a10 != 0.0) {
  *(double *)&v33 = (a10 + 1.0) * (double)v34;
  if (*(double *)&v33 == INFINITY)
    v34 = 0x8000000000000000LL;
  else
    v34 = (__int64)*(double *)&v33;
}
```

### 12. 技能类型倍率

两个版本都根据技能类型应用不同倍率：
```c
// 旧版本
switch (source) {
  case 7: p_BaseAttackRate = &attackerStatus->fields.BaseAttackRate; break;
  case 8: p_BaseAttackRate = &attackerStatus->fields.SubSkillRate; break;
  case 9: p_BaseAttackRate = &attackerStatus->fields.ActiveSkillRate; break;
  case 10: p_BaseAttackRate = &attackerStatus->fields.UltimateSkillRate; break;
}

// 新版本
switch (a7) {
  case 7: v35 = (_QWORD *)(a3 + 192); break;
  case 8: v35 = (_QWORD *)(a3 + 208); break;
  case 9: v35 = (_QWORD *)(a3 + 200); break;
  case 10: v35 = (_QWORD *)(a3 + 216); break;
}
```

### 13. 应用技能倍率

两个版本都应用技能倍率：
```c
// 旧版本
if (*p_BaseAttackRate != 0.0) {
  v39 = (*p_BaseAttackRate + 1.0) * (double)v36;
  if (v39 == INFINITY)
    v36 = 0x8000000000000000LL;
  else
    v36 = (__int64)v39;
}

// 新版本
if (*(double *)v35 != 0.0) {
  *(double *)&v33 = (*(double *)&v33 + 1.0) * (double)v34;
  if (*(double *)&v33 == INFINITY)
    v34 = 0x8000000000000000LL;
  else
    v34 = (__int64)*(double *)&v33;
}
```

### 14. 获取最小伤害

两个版本都获取最小伤害：
- 旧版本: `v41 = SecuredInt__Get(minDamage, 0LL);`
- 新版本: `v37 = sub_4D6D7D4(v36, 0LL, v33);`

### 15. 返回最终伤害

两个版本都返回最大值：
- 旧版本: `return System_Math__Max_137418460(v36, v41, 0LL);`
- 新版本: `return sub_863427C(v34, v37, 0LL);`

## 结论

尽管新版本的代码经过了混淆处理，变量名和函数名都被替换，但通过分析两个函数的计算流程和公式，可以确认它们在数值处理上是完全一致的。主要区别在于：

1. 变量和函数名被混淆
2. 某些参数的顺序被调整
3. 内存偏移量发生了变化（如技能倍率的内存位置）
4. 某些类型声明从`double`变为`long double`

但核心的伤害计算逻辑、公式和流程完全相同，包括：
- 防御公式
- 抗性计算
- 暴击处理
- 伤害倍率应用
- 技能类型倍率
- 最小伤害限制

因此，新旧版本在数值处理上是一致的，不会导致游戏平衡性变化。 