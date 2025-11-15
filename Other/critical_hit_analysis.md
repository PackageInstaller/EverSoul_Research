# 暴击机制分析

## 暴击相关函数

游戏中的暴击机制主要由两个函数实现：

1. `_Battle_BattleFormula__GetCriticalValue` - 获取暴击信息的主函数
2. `_Battle_BattleFormula__GetCriticalValue_72810800` - 实际计算暴击概率和暴击伤害的核心函数

### 获取暴击信息函数

```c
System_ValueTuple_bool__double__o __fastcall _Battle_BattleFormula__GetCriticalValue(
        __Battle_BattleFormula_o *this,
        __Battle_BattleCharacter_o *offence,
        __Battle_BattleCharacter_o *defence,
        const MethodInfo *method)
{
  __Battle_BattleCharacterBuffQuery_o *BuffQuery; // x0
  const MethodInfo *v8; // x2
  double v9; // d0
  __Battle_BattleCharacterBuffQuery_o *v10; // x0
  double v11; // d8
  double v12; // d0
  __Battle_BattleCharacterStatus_o *Status; // x0
  double v14; // d9
  double CriticalRate; // d0
  __Battle_BattleCharacterStatus_o *v16; // x0
  double v17; // d10
  double CriticalPower; // d0
  const MethodInfo *v19; // x1
  __int64 v20; // x0 OVERLAPPED
  double Item2; // x1
  System_ValueTuple_bool__double__o CriticalValue_72810800; // kr00_16
  System_ValueTuple_bool__double__o result; // 0:x0.16

  if ( !defence )
    goto LABEL_8;
  BuffQuery = defence->fields.BuffQuery;
  if ( !BuffQuery )
    goto LABEL_8;
  v9 = _Battle_BattleCharacterBuffQuery__GetTotalRateChangeValue(BuffQuery, 801, (const MethodInfo *)defence);
  v10 = defence->fields.BuffQuery;
  if ( !v10
    || (v11 = v9, v12 = _Battle_BattleCharacterBuffQuery__GetTotalRateChangeValue(v10, 802, v8), !offence)
    || (Status = offence->fields.Status) == 0LL
    || (v14 = v12,
        CriticalRate = _Battle_BattleCharacterStatus__get_CriticalRate(Status, 0LL),
        (v16 = offence->fields.Status) == 0LL) )
  {
LABEL_8:
    sub_3C35658();
  }
  v17 = CriticalRate;
  CriticalPower = _Battle_BattleCharacterStatus__get_CriticalPower(v16, 0LL);
  CriticalValue_72810800 = _Battle_BattleFormula__GetCriticalValue_72810800(this, v17, CriticalPower, v11, v14, v19);
  Item2 = CriticalValue_72810800.fields.Item2;
  v20 = *(_QWORD *)&CriticalValue_72810800.fields.Item1;
  result.fields.Item2 = Item2;
  *(_QWORD *)&result.fields.Item1 = v20;
  return result;
}
```

### 暴击计算核心函数

```c
System_ValueTuple_bool__double__o __fastcall _Battle_BattleFormula__GetCriticalValue_72810800(
        __Battle_BattleFormula_o *this,
        double offenceCriticalRate,
        double offenceCriticalPower,
        double defenceCriticalRateChangeProb,
        double defenceCriticalPowerRecived,
        const MethodInfo *method)
{
  struct System_Random_o *random; // x0
  const MethodInfo_708E7D8 *v12; // x3
  __int64 v13; // x0 OVERLAPPED
  double v14; // x1
  __int64 v15; // [xsp+0h] [xbp-50h] BYREF
  double v16; // [xsp+8h] [xbp-48h]
  System_ValueTuple_bool__double__o v17; // 0:x0.16
  System_ValueTuple_bool__double__o result; // 0:x0.16

  if ( (byte_99364FE & 1) == 0 )
  {
    sub_3C353C0();
    byte_99364FE = 1;
  }
  random = this->fields._random;
  if ( !random )
    sub_3C35658();
  *(_QWORD *)&v17.fields.Item2 = (offenceCriticalRate + defenceCriticalRateChangeProb) * 100.0 >= (double)((__int64 (__fastcall *)(struct System_Random_o *, __int64, __int64, Il2CppMethodPointer))random->klass->vtable._6_Next.method)(random, 1LL, 101LL, random->klass->vtable._7_Next.methodPtr);
  *(_QWORD *)&v17.fields.Item1 = &v15;
  v15 = 0LL;
  v16 = 0.0;
  System_ValueTuple_bool__double____ctor(
    v17,
    Method_System_ValueTuple_bool__double___ctor__,
    offenceCriticalPower + 1.0 + defenceCriticalPowerRecived,
    v12);
  v13 = v15;
  v14 = v16;
  result.fields.Item2 = v14;
  *(_QWORD *)&result.fields.Item1 = v13;
  return result;
}
```

### Buff效果计算函数

```c
double __fastcall _Battle_BattleCharacterBuffQuery__GetTotalRateChangeValue(
        __Battle_BattleCharacterBuffQuery_o *this,
        int32_t type,
        const MethodInfo *method)
{
  double ResistBuffRate; // d0
  struct __Battle_BattleCharacterBuff_o *buff; // x8
  double v7; // d8
  int32_t v8; // w21
  double v9; // d9
  System_Collections_Generic_List_object__o *BuffList; // x0
  Il2CppObject *Item; // x0
  struct __Battle_BattleCharacterBuff_o *v12; // x8
  System_Collections_Generic_List_object__o *v13; // x0
  Il2CppObject *v14; // x0
  struct __Battle_BattleCharacterBuff_o *v15; // x8
  System_Collections_Generic_List_object__o *v16; // x0
  Il2CppObject *v17; // x0
  struct __Battle_BattleCharacterBuff_o *v18; // x8
  System_Collections_Generic_List_object__o *v19; // x8
  double v20; // d10
  Il2CppObject *v21; // x0

  if ( (byte_9936555 & 1) == 0 )
  {
    sub_3C353C0();
    sub_3C353C0();
    byte_9936555 = 1;
  }
  ResistBuffRate = _Battle_BattleCharacterBuffQuery__GetResistBuffRate(this, type, method);
  buff = this->fields._buff;
  if ( !buff )
LABEL_21:
    sub_3C35658();
  v7 = ResistBuffRate;
  v8 = 0;
  v9 = 0.0;
  while ( 1 )
  {
    BuffList = (System_Collections_Generic_List_object__o *)buff->fields.BuffList;
    if ( !BuffList )
      goto LABEL_21;
    if ( v8 >= BuffList->fields._size )
      return v9;
    Item = System_Collections_Generic_List_object___get_Item(
             BuffList,
             v8,
             (const MethodInfo_67B2BDC *)Method_System_Collections_Generic_List_Buff__get_Item__);
    if ( !Item )
      goto LABEL_21;
    if ( LODWORD(Item[5].monitor) != 2 )
    {
      v12 = this->fields._buff;
      if ( !v12 )
        goto LABEL_21;
      v13 = (System_Collections_Generic_List_object__o *)v12->fields.BuffList;
      if ( !v13 )
        goto LABEL_21;
      v14 = System_Collections_Generic_List_object___get_Item(
              v13,
              v8,
              (const MethodInfo_67B2BDC *)Method_System_Collections_Generic_List_Buff__get_Item__);
      if ( !v14 )
        goto LABEL_21;
      if ( HIDWORD(v14[1].klass) == type )
      {
        v15 = this->fields._buff;
        if ( !v15 )
          goto LABEL_21;
        v16 = (System_Collections_Generic_List_object__o *)v15->fields.BuffList;
        if ( !v16 )
          goto LABEL_21;
        v17 = System_Collections_Generic_List_object___get_Item(
                v16,
                v8,
                (const MethodInfo_67B2BDC *)Method_System_Collections_Generic_List_Buff__get_Item__);
        if ( !v17 )
          goto LABEL_21;
        v18 = this->fields._buff;
        if ( !v18 )
          goto LABEL_21;
        v19 = (System_Collections_Generic_List_object__o *)v18->fields.BuffList;
        if ( !v19 )
          goto LABEL_21;
        v20 = *(double *)&v17[2].klass;
        v21 = System_Collections_Generic_List_object___get_Item(
                v19,
                v8,
                (const MethodInfo_67B2BDC *)Method_System_Collections_Generic_List_Buff__get_Item__);
        if ( !v21 )
          goto LABEL_21;
        v9 = v9 + v7 * v20 * (double)SLODWORD(v21[9].monitor);
      }
    }
    buff = this->fields._buff;
    ++v8;
    if ( !buff )
      goto LABEL_21;
  }
}
```

## 函数解析

### 获取暴击信息函数

`_Battle_BattleFormula__GetCriticalValue` 函数负责收集计算暴击所需的各项数据：

1. 从防御方获取暴击相关的Buff效果：

   - `801` - 暴击率变化效果（可能是增加或减少攻击方的暴击率）
   - `802` - 暴击伤害变化效果（可能是增加或减少攻击方的暴击伤害）
2. 从攻击方获取基础暴击属性：

   - `CriticalRate` - 暴击率
   - `CriticalPower` - 暴击伤害倍率
3. 调用核心计算函数 `_Battle_BattleFormula__GetCriticalValue_72810800` 计算最终的暴击结果
4. 返回一个包含两个值的元组 `ValueTuple<bool, double>`：

   - `Item1` (bool): 是否触发暴击
   - `Item2` (double): 暴击伤害倍率

### 暴击计算核心函数

`_Battle_BattleFormula__GetCriticalValue_72810800` 函数是实际计算暴击的核心逻辑：

1. 暴击判定：

   ```c
   (offenceCriticalRate + defenceCriticalRateChangeProb) * 100.0 >= random.Next(1, 101)
   ```

   - 将攻击方的暴击率与防御方的暴击率变化效果相加
   - 将结果乘以100（转换为百分比）
   - 生成1-100的随机数
   - 如果暴击率（百分比）大于等于随机数，则触发暴击
2. 暴击伤害倍率计算：

   ```c
   offenceCriticalPower + 1.0 + defenceCriticalPowerRecived
   ```

   - 攻击方的暴击伤害倍率
   - 加上基础倍率1.0
   - 再加上防御方的暴击伤害变化效果

### Buff效果计算函数

`_Battle_BattleCharacterBuffQuery__GetTotalRateChangeValue` 函数用于计算特定类型的Buff效果总和：

1. 函数接收一个 `type`参数，用于指定要计算的Buff类型（如801表示暴击率变化，802表示暴击伤害变化）
2. 首先获取Buff抗性率：

   ```c
   ResistBuffRate = _Battle_BattleCharacterBuffQuery__GetResistBuffRate(this, type, method);
   ```

   这可能是一个用于减弱Buff效果的系数
3. 遍历角色的所有Buff：

   ```c
   while ( 1 ) {
     // 检查是否已遍历完所有Buff
     if ( v8 >= BuffList->fields._size )
       return v9;

     // 获取当前Buff
     Item = System_Collections_Generic_List_object___get_Item(...);

     // 检查Buff类型是否匹配
     if ( HIDWORD(v14[1].klass) == type ) {
       // 获取Buff的值和层数
       v20 = *(double *)&v17[2].klass;  // Buff值
       v21 = System_Collections_Generic_List_object___get_Item(...);
       // 累加Buff效果: 抗性系数 * Buff值 * Buff层数
       v9 = v9 + v7 * v20 * (double)SLODWORD(v21[9].monitor);
     }
   }
   ```
4. 关键计算逻辑：

   ```c
   v9 = v9 + v7 * v20 * (double)SLODWORD(v21[9].monitor);
   ```

   - `v9`: 累计的Buff效果总和
   - `v7`: Buff抗性系数（`ResistBuffRate`）
   - `v20`: 单个Buff的效果值
   - `SLODWORD(v21[9].monitor)`: Buff的层数
5. 最终返回所有匹配类型Buff的效果总和

## 暴击机制详解

### 暴击率计算

暴击率的计算公式为：

```
暴击率 = (攻击方基础暴击率 + 防御方暴击率变化效果) × 100%
```

其中，防御方暴击率变化效果是通过 `GetTotalRateChangeValue`函数计算的，它考虑了：

- 所有类型为801的Buff效果
- 每个Buff的效果值
- 每个Buff的层数
- Buff抗性系数

暴击判定条件：

```
暴击率(%) ≥ 随机数(1-100)
```

例如：

- 如果攻击方暴击率为0.25（25%），防御方没有暴击率变化效果
- 则暴击率为25%
- 生成1-100的随机数，如果随机数≤25，则触发暴击

### 暴击伤害倍率计算

暴击伤害倍率的计算公式为：

```
暴击伤害倍率 = 攻击方基础暴击伤害倍率 + 1.0 + 防御方暴击伤害变化效果
```

其中，防御方暴击伤害变化效果也是通过 `GetTotalRateChangeValue`函数计算的，它考虑了：

- 所有类型为802的Buff效果
- 每个Buff的效果值
- 每个Buff的层数
- Buff抗性系数

例如：

- 如果攻击方基础暴击伤害倍率为0.5，防御方暴击伤害变化效果为-0.1
- 则最终暴击伤害倍率为：0.5 + 1.0 - 0.1 = 1.4
- 意味着暴击时伤害为普通伤害的1.4倍

### Buff系统详解

Buff系统是影响暴击机制的重要组成部分：

1. **Buff类型**：

   - `801`: 暴击率变化效果
   - `802`: 暴击伤害变化效果
2. **Buff属性**：

   - **效果值**：单个Buff的基础效果大小
   - **层数**：Buff的叠加次数，可以增强效果
   - **抗性系数**：可能减弱某些Buff的效果
3. **Buff效果计算**：

   ```
   b
   ```

   对于所有匹配类型的Buff进行累加
4. **正负效果**：

   - 正值Buff增加暴击率/暴击伤害
   - 负值Buff减少暴击率/暴击伤害
5. **Buff来源**：

   - 技能效果
   - 装备特效
   - 角色特性
   - 状态效果

## 总结

游戏的暴击系统是一个复杂的机制，结合了基础属性和Buff系统：

1. **暴击触发机制**：

   - 基于攻击方的暴击率和防御方的相关Buff
   - 使用随机数与暴击率比较来决定是否触发暴击
   - Buff可以通过层数叠加来显著影响暴击率
2. **暴击伤害计算**：

   - 基于攻击方的暴击伤害倍率和防御方的相关Buff
   - 暴击时，伤害会根据计算出的倍率增加
   - Buff同样可以通过层数叠加来显著影响暴击伤害
3. **Buff系统的影响**：

   - 提供了动态调整暴击机制的能力
   - 允许通过技能和状态效果临时改变暴击表现
   - 引入了策略性元素，如何管理和利用Buff成为战斗的关键

这种设计允许通过提高角色的暴击率和暴击伤害属性来增强输出能力，同时也可以通过减少敌人的这些属性或施加负面Buff来提高生存能力。
