# 护盾削减机制分析

## 护盾削减触发条件

护盾削减主要由控制效果(CC)触发，具体触发逻辑如下：

```c
void __fastcall _Battle_BattleCharacterEvent__TriggerAddCCBuff(
        __Battle_BattleCharacterEvent_o *this,
        int32_t buffType,
        double duration,
        const MethodInfo *method)
{
  if ( (unsigned int)(buffType - 201) <= 6 && ((99u >> (buffType + 55)) & 1) != 0 )
    _Battle_BattleCharacterEvent__DecreaseGroggy(this, dword_1908624[buffType - 201], duration, method);
}
```

- 只有特定范围的Buff类型(201-207)才会触发护盾削减
- 每种Buff类型通过 `dword_1908624`数组映射到特定的削减类型(1-4)
- dword_1908624数组内容为：[1, 2, 1, 1, 1, 3, 4]

## 削减系数来源

削减系数来自游戏配置表 `SingleRaidBossGroggyTrigger`，每个Boss有自己的配置：

```json
{
  "single_raid_boss_no": 4020,
  "groggy_skill_code1": 9912901,
  "groggy_skill_code2": 9912902,
  "groggy_skill_code3": 9912903,
  "groggy_skill_code4": 9912906,
  "groggy_skill_code5": 9912907,
  "groggy_skill_code6": 9912908,
  "type1": 1,
  "value1": 75.0,
  "type2": 2,
  "value2": 125.0,
  "type3": 3,
  "value3": 25.0,
  "type4": 4,
  "value4": 25.0,
  "recovery_duration": 12,
  "sound_path": "AiraRaid_Groggy01"
}
```

配置包含了不同类型的触发器及其对应的削减系数：
例如

- type1: 1, value1: 75.0
- type2: 2, value2: 125.0
- type3: 3, value3: 25.0
- type4: 4, value4: 25.0

## 削减计算公式

护盾削减量的计算公式为：

```
削减量 = 触发器系数 × 持续时间
```

例如，一个持续8秒的眩晕效果(buff_effect: 201)：

- 映射到削减类型1（dword_1908624[0] = 1）
- 使用value1作为系数：75.0
- 削减量 = 75.0 × 8 = 600

## 削减应用流程

削减应用的完整流程如下：

1. **控制效果触发**：

   - 添加控制效果Buff(类型201-207)
   - 通过 `dword_1908624`数组映射到削减类型(1-4)
2. **查找削减系数**：

   - 在 _Battle_BattleCharacterEvent__TriggerAddCCBuff函数中遍历触发器列表
   - 找到与当前削减类型匹配的触发器项
   - 提取该项的值作为削减系数
3. **计算削减量**：

   ```c
   v31 = (__int64)(v28 * duration);
   if ( v28 * duration == INFINITY )
     v31 = 0x8000000000000000LL;
   if ( (unsigned int)(type - 1) >= 4 )
     v31 = 0LL;
   ```

   - 削减量 = 系数 × 持续时间
   - 类型1-4才有效，其他类型削减量为0
4. **应用削减**：

   ```c
   _Battle_BattleCharacterStatus__set_Groggy(Status, Status->fields._groggy - v31, 0LL);
   ```

   - 从当前护盾值中减去计算出的削减量

## 免疫机制

某些特定Buff可以使角色免疫Groggy护盾削减：

```c
if ( _Battle_BattleCharacterBuffQuery__HasFlagBuffEffect(BuffQuery, 903, 0LL) )
  return;

if ( _Battle_BattleCharacterBuffQuery__HasFlagBuffEffect(v12, 901, 0LL) )
  return;
```

- Buff ID 903: 免疫护盾削减
- Buff ID 901: 同样免疫护盾削减

## 触发效果

当护盾值降至0以下时，会触发Groggy状态：

```c
if ( v38->fields._groggy >= 1 )
  return;
v39 = this->fields._groggyEvent;
if ( v39 )
{
  v39->fields.RemainingCoolTime.fields.Tick = v39->fields.RecoveryDuration.fields.Tick;
  // 应用技能效果
  _Battle_BattleCharacterEvent__AppllySkillCode(
    this,
    v40->fields.SourceNo,
    v40->fields.CodeList,
    v36);
  // 重置Groggy期间的总伤害
  this->fields._totalDamageWhenGroggy = 0LL;
  // 显示UI文本和播放音效
  _Battle_BattleUIUtility__PopupText(
    CharacterData->fields.BasicInfo.fields.NO,
    v43->fields.EventTextNo,
    v43->fields.SoundPath,
    0LL);
}
```
