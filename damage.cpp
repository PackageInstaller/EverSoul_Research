// 旧版伤害函数
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
{
  __Battle_BattleCharacterOverrideStatus_o *OverrideStatus; // x0
  __Battle_BattleFormula_o *RaceType; // x0
  const MethodInfo *v23; // x3
  double MatchupValue; // d10
  __Battle_BattleFormula_o *v25; // x0
  const MethodInfo *v26; // x4
  double Resist; // d11
  __Battle_BattleFormula_o *v28; // x0
  const MethodInfo *v29; // x3
  const MethodInfo *v30; // x1
  double Defense; // d0
  double v32; // d13
  SecuredFloat_o *damageResistMin; // x0
  float v34; // s12
  double v35; // d0
  int64_t v36; // x22
  double v37; // d0
  double *p_BaseAttackRate; // x8
  double v39; // d0
  SecuredInt_o *minDamage; // x0
  int32_t v41; // w19

  if ( (byte_99364FA & 1) == 0 )
  {
    sub_3C353C0();
    byte_99364FA = 1;
  }
  if ( !defence )
    goto LABEL_33;
  OverrideStatus = defence->fields.OverrideStatus;
  if ( !OverrideStatus )
    goto LABEL_33;
  RaceType = (__Battle_BattleFormula_o *)_Battle_BattleCharacterOverrideStatus__get_RaceType(OverrideStatus, 0LL);
  MatchupValue = _Battle_BattleFormula__GetMatchupValue(RaceType, attackerStatus, (int32_t)RaceType, v23);
  Resist = _Battle_BattleFormula__GetResist(
             v25,
             attackerStatus->fields.StatType,
             penetration,
             penetrationRate,
             defence,
             v26);
  Defense = _Battle_BattleFormula__GetDefense(v28, penetration, penetrationRate, defence, v29);
  v32 = Defense >= 0.0
      ? (double)damage
      - Defense
      / (Defense + _Battle_BattleFormula__get_DamageFormulaKeyValue(this, v30) * (double)damage)
      * (double)damage
      : (double)damage;
  damageResistMin = this->fields._damageResistMin;
  if ( !damageResistMin )
    goto LABEL_33;
  v34 = SecuredFloat__Get(damageResistMin, 0LL);
  if ( !System_Math_TypeInfo->_2.cctor_finished )
    j_il2cpp_runtime_class_init_0((__int64)System_Math_TypeInfo);
  v35 = MatchupValue * (v32 * System_Math__Max_137418400(1.0 - Resist, v34, 0LL));
  if ( isCritical )
    v35 = v35 * criticalValue;
  if ( v35 == INFINITY )
    v36 = 0x8000000000000000LL;
  else
    v36 = (__int64)v35;
  if ( damageRate != 0.0 )
  {
    v37 = (damageRate + 1.0) * (double)v36;
    if ( v37 == INFINITY )
      v36 = 0x8000000000000000LL;
    else
      v36 = (__int64)v37;
  }
  switch ( source )
  {
    case 7:
      p_BaseAttackRate = &attackerStatus->fields.BaseAttackRate;
      goto LABEL_25;
    case 8:
      p_BaseAttackRate = &attackerStatus->fields.SubSkillRate;
      goto LABEL_25;
    case 9:
      p_BaseAttackRate = &attackerStatus->fields.ActiveSkillRate;
      goto LABEL_25;
    case 10:
      p_BaseAttackRate = &attackerStatus->fields.UltimateSkillRate;
LABEL_25:
      if ( *p_BaseAttackRate != 0.0 )
      {
        v39 = (*p_BaseAttackRate + 1.0) * (double)v36;
        if ( v39 == INFINITY )
          v36 = 0x8000000000000000LL;
        else
          v36 = (__int64)v39;
      }
      break;
    default:
      break;
  }
  minDamage = this->fields._minDamage;
  if ( !minDamage )
LABEL_33:
    sub_3C35658();
  v41 = SecuredInt__Get(minDamage, 0LL);
  if ( !System_Math_TypeInfo->_2.cctor_finished )
    j_il2cpp_runtime_class_init_0((__int64)System_Math_TypeInfo);
  return System_Math__Max_137418460(v36, v41, 0LL);
}



// 2025年5月6日伤害函数，1.20.111
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
{
  __int64 v20; // x0
  __int64 v21; // x0
  __int64 v22; // x0
  double v23; // d0
  double v24; // d10
  __int64 v25; // x0
  double v26; // d0
  double v27; // d11
  double v28; // d0
  double v29; // d13
  __int64 v30; // x0
  long double v31; // q0
  float v32; // s12
  long double v33; // q0
  __int64 v34; // x22
  _QWORD *v35; // x8
  __int64 v36; // x0
  int v37; // w19

  if ( (unk_9C8EC1F & 1) == 0 )
  {
    sub_3D90744(qword_99A9650);
    unk_9C8EC1F = 1;
  }
  if ( !a4 )
    goto LABEL_33;
  v20 = *(_QWORD *)(a4 + 120);
  if ( !v20 )
    goto LABEL_33;
  v21 = sub_477B9A8(v20, 0LL);
  v22 = sub_4719368(v21, a3, (unsigned int)v21);
  v24 = v23;
  v25 = sub_4719484(v22, *(unsigned int *)(a3 + 16), a5, a4, a8);
  v27 = v26;
  v28 = sub_47194EC(v25, a5, a4, a8);
  v29 = v28 >= 0.0 ? (double)a2 - v28 / (v28 + sub_471847C(a1) * (double)a2) * (double)a2 : (double)a2;
  v30 = *(_QWORD *)(a1 + 128);
  if ( !v30 )
    goto LABEL_33;
  v31 = sub_4D6D618(v30, 0LL);
  v32 = *(float *)&v31;
  if ( !*(_DWORD *)(qword_99A9650[0] + 224LL) )
    ((void (*)(void))j_il2cpp_runtime_class_init_0)();
  *(double *)&v33 = v24 * (v29 * sub_8634240(0LL, 1.0 - v27, v32));
  if ( (a6 & 1) != 0 )
    *(double *)&v33 = *(double *)&v33 * a9;
  if ( *(double *)&v33 == INFINITY )
    v34 = 0x8000000000000000LL;
  else
    v34 = (__int64)*(double *)&v33;
  if ( a10 != 0.0 )
  {
    *(double *)&v33 = (a10 + 1.0) * (double)v34;
    if ( *(double *)&v33 == INFINITY )
      v34 = 0x8000000000000000LL;
    else
      v34 = (__int64)*(double *)&v33;
  }
  switch ( a7 )
  {
    case 7:
      v35 = (_QWORD *)(a3 + 192);
      goto LABEL_25;
    case 8:
      v35 = (_QWORD *)(a3 + 208);
      goto LABEL_25;
    case 9:
      v35 = (_QWORD *)(a3 + 200);
      goto LABEL_25;
    case 10:
      v35 = (_QWORD *)(a3 + 216);
LABEL_25:
      *(_QWORD *)&v33 = *v35;
      if ( *(double *)v35 != 0.0 )
      {
        *(double *)&v33 = (*(double *)&v33 + 1.0) * (double)v34;
        if ( *(double *)&v33 == INFINITY )
          v34 = 0x8000000000000000LL;
        else
          v34 = (__int64)*(double *)&v33;
      }
      break;
    default:
      break;
  }
  v36 = *(_QWORD *)(a1 + 144);
  if ( !v36 )
LABEL_33:
    sub_3D909DC();
  v37 = sub_4D6D7D4(v36, 0LL, v33);
  if ( !*(_DWORD *)(qword_99A9650[0] + 224LL) )
    j_il2cpp_runtime_class_init_0(qword_99A9650[0]);
  return sub_863427C(v34, v37, 0LL);
}

