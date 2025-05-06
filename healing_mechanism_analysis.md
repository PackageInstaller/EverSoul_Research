# 治疗机制分析

## 治疗相关函数

游戏中的治疗机制主要由两个关键函数实现：
1. `_Battle_BattleFormula__GetHealRateChange` - 计算治疗效果修正系数
2. `_Battle_BattleSkillCode__InteractHeal` - 执行实际的治疗操作

### 治疗效果修正函数

```c
double __fastcall _Battle_BattleFormula__GetHealRateChange(
        __Battle_BattleFormula_o *this,
        double rateChange,
        double reinforceDotHeal,
        const MethodInfo *method)
{
  if ( (byte_9936500 & 1) == 0 )
  {
    sub_3C353C0();
    byte_9936500 = 1;
  }
  if ( !System_Math_TypeInfo->_2.cctor_finished )
    j_il2cpp_runtime_class_init_0((__int64)System_Math_TypeInfo);
  return System_Math__Max_137418400(0.0, rateChange + 1.0 + reinforceDotHeal, 0LL);
}
```

### 治疗执行函数

```c
void __fastcall _Battle_BattleSkillCode__InteractHeal(
        int32_t source,
        System_String_o *influencerID,
        __Battle_BattleCharacter_o *affected,
        int64_t healAmount,
        const MethodInfo *method)
{
  bool v9; // w0
  __Battle_BattleCharacterBuffQuery_o *BuffQuery; // x0
  double v11; // d8
  double v12; // d9
  __Battle_BattleCharacterBuffQuery_o *v13; // x0
  Il2CppObject *instance; // x0
  __Battle_BattleFormula_o *Formula; // x0
  double v16; // d0
  int64_t v17; // x21
  int64_t v18; // x0
  const MethodInfo *v19; // x2

  if ( (byte_99365A9 & 1) == 0 )
  {
    sub_3C353C0();
    sub_3C353C0();
    byte_99365A9 = 1;
  }
  if ( !UnityEngine_Object_TypeInfo->_2.cctor_finished )
    j_il2cpp_runtime_class_init_0((__int64)UnityEngine_Object_TypeInfo);
  v9 = UnityEngine_Object__op_Equality((UnityEngine_Object_o *)affected, 0LL, 0LL);
  if ( healAmount >= 1 && !v9 )
  {
    if ( affected )
    {
      BuffQuery = affected->fields.BuffQuery;
      if ( BuffQuery )
      {
        v11 = _Battle_BattleCharacterBuffQuery__GetTotalRateChangeValue(BuffQuery, 1001, 0LL);
        v12 = 0.0;
        if ( source == 3 )
        {
          v13 = affected->fields.BuffQuery;
          if ( !v13 )
            goto LABEL_19;
          v12 = _Battle_BattleCharacterBuffQuery__GetTotalRateChangeValue(v13, 1202, 0LL);
        }
        instance = MonoSingleton_object___get_instance((const MethodInfo_6AADEE8 *)Method_MonoSingleton_Battle__get_instance__);
        if ( instance )
        {
          Formula = Battle__get_Formula((Battle_o *)instance, 0LL);
          if ( Formula )
          {
            v16 = _Battle_BattleFormula__GetHealRateChange(Formula, v11, v12, 0LL) * (double)healAmount;
            if ( v16 == INFINITY )
              v17 = 0x8000000000000000LL;
            else
              v17 = (__int64)v16;
            v18 = _Battle_BattleCharacter__OnBeHealed(affected, v17, 0LL);
            _Battle_BattleSkillCode__SetBattleStaticsHeal(influencerID, v18, v19);
            _Battle_BattleUIUtility__UIShowHealLabel(affected, v17, 0LL);
            return;
          }
        }
      }
    }
LABEL_19:
    sub_3C35658();
  }
}
```

## 函数解析

### 治疗效果修正函数

`_Battle_BattleFormula__GetHealRateChange` 函数用于计算治疗效果的最终修正系数：

1. 函数接收三个主要参数：
   - `this`: 战斗公式对象
   - `rateChange`: 基础治疗效果修正值
   - `reinforceDotHeal`: 持续治疗（DoT）增强系数

2. 计算逻辑非常简单：
   ```c
   return System_Math__Max_137418400(0.0, rateChange + 1.0 + reinforceDotHeal, 0LL);
   ```
   - 将基础治疗修正值`rateChange`加上基础值`1.0`
   - 再加上持续治疗增强系数`reinforceDotHeal`
   - 使用`Math.Max`确保结果不小于0（治疗效果不会变为负数）

3. 这个函数确保了即使在有负面修正的情况下，治疗效果也不会变成伤害

### 治疗执行函数

`_Battle_BattleSkillCode__InteractHeal` 函数是实际执行治疗操作的核心函数：

1. 函数接收四个主要参数：
   - `source`: 治疗来源类型
   - `influencerID`: 治疗者的ID
   - `affected`: 被治疗的角色
   - `healAmount`: 基础治疗量

2. 函数首先进行一系列有效性检查：
   ```c
   if ( healAmount >= 1 && !v9 )  // 确保治疗量大于等于1且目标有效
   ```

3. 获取目标的治疗相关Buff效果：
   ```c
   v11 = _Battle_BattleCharacterBuffQuery__GetTotalRateChangeValue(BuffQuery, 1001, 0LL);
   ```
   - `1001`: 表示通用治疗效果修正的Buff类型ID

4. 如果治疗来源是持续治疗（`source == 3`），还会获取持续治疗增强效果：
   ```c
   if ( source == 3 )
   {
     v12 = _Battle_BattleCharacterBuffQuery__GetTotalRateChangeValue(v13, 1202, 0LL);
   }
   ```
   - `1202`: 表示持续治疗效果增强的Buff类型ID

5. 计算最终治疗量：
   ```c
   v16 = _Battle_BattleFormula__GetHealRateChange(Formula, v11, v12, 0LL) * (double)healAmount;
   ```
   - 调用`GetHealRateChange`获取治疗效果修正系数
   - 将修正系数乘以基础治疗量

6. 处理无穷大情况并转换为整数：
   ```c
   if ( v16 == INFINITY )
     v17 = 0x8000000000000000LL;  // 最小整数值
   else
     v17 = (__int64)v16;  // 转换为整数
   ```

7. 应用治疗效果并更新UI：
   ```c
   v18 = _Battle_BattleCharacter__OnBeHealed(affected, v17, 0LL);  // 应用治疗
   _Battle_BattleSkillCode__SetBattleStaticsHeal(influencerID, v18, v19);  // 更新战斗统计
   _Battle_BattleUIUtility__UIShowHealLabel(affected, v17, 0LL);  // 显示治疗数值
   ```

## 治疗机制详解

### 治疗效果计算公式

基于上述函数，我们可以推导出游戏中的治疗效果计算公式：

```
最终治疗量 = 基础治疗量 × (1.0 + 治疗效果修正 + 持续治疗增强)
```

其中：
- **基础治疗量**：技能或效果指定的初始治疗数值
- **治疗效果修正**：来自Buff ID 1001的效果总和
- **持续治疗增强**：仅适用于持续治疗(DoT)，来自Buff ID 1202的效果总和

### 治疗来源类型

函数中的`source`参数表示治疗的来源类型，其中：
- `source == 3`: 表示持续治疗(DoT)，会额外考虑持续治疗增强效果(Buff ID 1202)
- 其他值: 表示普通治疗，不考虑持续治疗增强效果

### Buff类型编号

从代码中可以看出，游戏使用特定的编号来表示不同类型的治疗相关Buff：
- `1001`: 通用治疗效果修正
- `1202`: 持续治疗效果增强

这些Buff可以是正值（增益）或负值（减益），分别增加或减少治疗效果。

### 治疗流程

完整的治疗流程如下：

1. **初始检查**：
   - 确认治疗量大于等于1
   - 确认目标角色有效

2. **获取Buff效果**：
   - 获取目标角色的治疗效果修正Buff(1001)
   - 如果是持续治疗，还获取持续治疗增强Buff(1202)

3. **计算修正系数**：
   - 基础值1.0
   - 加上治疗效果修正值
   - 如果是持续治疗，再加上持续治疗增强值
   - 确保结果不小于0

4. **计算最终治疗量**：
   - 修正系数乘以基础治疗量
   - 处理可能的溢出情况

5. **应用治疗**：
   - 对目标角色应用治疗效果
   - 更新战斗统计数据
   - 显示治疗数值UI

## 战略意义

游戏的治疗机制设计具有以下战略意义：

### 1. 角色定位

- **治疗师角色**：可以通过提高治疗效果修正来增强治疗能力
- **持续治疗专精**：可以通过特殊的持续治疗增强效果来强化DoT治疗

### 2. 装备与技能设计

- 可以设计增加治疗效果的装备和技能
- 可以设计特化于持续治疗的装备和技能
- 可以设计降低敌人治疗效果的负面效果

### 3. 战斗策略

- 玩家可以通过组合不同的治疗效果增益来最大化治疗输出
- 在面对强力治疗的敌人时，可以考虑使用降低治疗效果的技能
- 可以根据情况选择即时治疗或持续治疗策略

### 4. 平衡性考量

- 治疗效果不会变为负数，确保治疗始终是有益的
- 通过分离通用治疗和持续治疗的增益效果，可以更精细地调整游戏平衡

## 总结

游戏的治疗机制是一个设计精巧的系统，它具有以下特点：

1. **灵活性**：
   - 支持不同类型的治疗（普通治疗和持续治疗）
   - 通过Buff系统实现动态调整治疗效果

2. **可扩展性**：
   - Buff系统允许轻松添加新的治疗效果修正
   - 源码结构清晰，便于扩展新的治疗类型

3. **平衡性**：
   - 确保治疗效果不会变为负数
   - 分离不同类型的治疗增益，便于精细调整

4. **战略深度**：
   - 为玩家提供多种治疗策略选择
   - 增加了角色构建和团队配合的深度

通过这种设计，游戏为玩家提供了丰富的治疗策略选择，同时也为开发者提供了灵活的平衡调整手段。 