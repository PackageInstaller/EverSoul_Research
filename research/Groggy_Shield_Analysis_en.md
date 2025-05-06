# Shield Reduction Mechanism Analysis

## Shield Reduction Trigger Conditions

Shield reduction is mainly triggered by crowd control (CC) effects, with the specific trigger logic as follows:

```c
void __fastcall _Battle_BattleCharacterEvent__TriggerAddCCBuff(
        __Battle_BattleCharacterEvent_o *this,
        int32_t buffType,
        double duration,
        const MethodInfo *method)
{
  if ( (unsigned int)(buffType - 201) <= 6 && ((0x63u >> (buffType + 55)) & 1) != 0 )
    _Battle_BattleCharacterEvent__DecreaseGroggy(this, dword_1908624[buffType - 201], duration, method);
}
```

- Only specific buff types (201-207) will trigger shield reduction
- Each buff type is mapped to a specific reduction type (1-4) through the `dword_1908624` array
- The content of the dword_1908624 array is: [1, 2, 1, 1, 1, 3, 4]

## Source of Reduction Coefficients

Reduction coefficients come from the game configuration table `SingleRaidBossGroggyTrigger`, with each boss having its own configuration:

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

The configuration contains different types of triggers and their corresponding reduction coefficients:
such as:
- type1: 1, value1: 75.0
- type2: 2, value2: 125.0
- type3: 3, value3: 25.0
- type4: 4, value4: 25.0

## Reduction Calculation Formula

The shield reduction amount is calculated using the formula:

```
Reduction Amount = Trigger Coefficient × Duration
```

For example, a stun effect (buff_effect: 201) lasting 8 seconds:
- Maps to reduction type 1 (dword_1908624[0] = 1)
- Uses value1 as the coefficient: 75.0
- Reduction amount = 75.0 × 8 = 600

## Reduction Application Process

The complete process of applying reduction is as follows:

1. **Control Effect Trigger**:
   - Add a control effect buff (type 201-207)
   - Map to a reduction type (1-4) through the `dword_1908624` array

2. **Find Reduction Coefficient**:
   - Iterate through the trigger list in the `_Battle_BattleCharacterEvent__DecreaseGroggy` function
   - Find the trigger item that matches the current reduction type
   - Extract the value as the reduction coefficient

3. **Calculate Reduction Amount**:
   ```c
   v31 = (__int64)(v28 * duration);
   if ( v28 * duration == INFINITY )
     v31 = 0x8000000000000000LL;
   if ( (unsigned int)(type - 1) >= 4 )
     v31 = 0LL;
   ```
   - Reduction amount = Coefficient × Duration
   - Only types 1-4 are effective; other types have a reduction amount of 0

4. **Apply Reduction**:
   ```c
   _Battle_BattleCharacterStatus__set_Groggy(Status, Status->fields._groggy - v31, 0LL);
   ```
   - Subtract the calculated reduction amount from the current shield value

## Immunity Mechanism

Certain specific buffs can make a character immune to Groggy shield reduction:

```c
if ( _Battle_BattleCharacterBuffQuery__HasFlagBuffEffect(BuffQuery, 903, 0LL) )
  return;

if ( _Battle_BattleCharacterBuffQuery__HasFlagBuffEffect(v12, 901, 0LL) )
  return;
```

- Buff ID 903: Immune to shield reduction
- Buff ID 901: Also immune to shield reduction

## Groggy Trigger Effects

When the shield value drops below 0, the Groggy state is triggered:

```c
if ( v38->fields._groggy >= 1 )
  return;
v39 = this->fields._groggyEvent;
if ( v39 )
{
  v39->fields.RemainingCoolTime.fields.Tick = v39->fields.RecoveryDuration.fields.Tick;
  // Apply skill effects
  _Battle_BattleCharacterEvent__AppllySkillCode(
    this,
    v40->fields.SourceNo,
    v40->fields.CodeList,
    v36);
  // Reset total damage during Groggy
  this->fields._totalDamageWhenGroggy = 0LL;
  // Display UI text and play sound effect
  _Battle_BattleUIUtility__PopupText(
    CharacterData->fields.BasicInfo.fields.NO,
    v43->fields.EventTextNo,
    v43->fields.SoundPath,
    0LL);
}
```