# 闪避机制分析

## 闪避判定函数

```c
bool __fastcall _Battle_BattleFormula__IsDodgeSuccess_72810528(
        __Battle_BattleFormula_o *this,
        int32_t offenceHit,
        int32_t defenceDodge,
        const MethodInfo *method)
{
  struct System_Random_o *random; // x0

  random = this->fields._random;
  if ( !random )
    sub_3C35658();
  return ((__int64 (__fastcall *)(struct System_Random_o *, __int64, __int64, Il2CppMethodPointer))random->klass->vtable._6_Next.method)(
           random,
           1LL,
           101LL,
           random->klass->vtable._7_Next.methodPtr) > offenceHit - defenceDodge + 100;
}
```

## 函数解析

这个函数用于判断防御方是否成功闪避了攻击方的攻击。函数接收以下参数：

- `this`: 战斗公式对象
- `offenceHit`: 攻击方的命中值
- `defenceDodge`: 防御方的闪避值
- `method`: 方法信息（IL2CPP运行时需要）

## 闪避判定机制

闪避判定的核心逻辑如下：

1. 获取战斗公式对象中的随机数生成器 `this->fields._random`
2. 生成一个1到100之间的随机整数（包括1，不包括101）
3. 将这个随机数与 `offenceHit - defenceDodge + 100` 进行比较
4. 如果随机数大于该值，则判定为闪避成功；否则判定为闪避失败

## 闪避公式

闪避成功的条件可以表示为：

```
随机数(1-100) > 命中值 - 闪避值 + 100
```

这个公式可以重写为：

```
随机数(1-100) > 100 + (命中值 - 闪避值)
```

## 闪避概率分析

根据上述公式，我们可以分析不同情况下的闪避概率：

1. **命中值等于闪避值**：

   - 闪避条件：随机数 > 100
   - 由于随机数范围是1-100，这个条件永远不会满足
   - 闪避概率：0%
2. **闪避值大于命中值**：

   - 闪避条件：随机数 > 100 - (闪避值 - 命中值)
   - 闪避概率随着闪避值与命中值的差值增加而增加
3. **闪避值比命中值高出100或更多**：

   - 闪避条件：随机数 > 0
   - 由于随机数范围是1-100，这个条件总是满足
   - 闪避概率：100%
4. **命中值大于闪避值**：

   - 闪避条件：随机数 > 100 + (命中值 - 闪避值)
   - 由于随机数最大为100，当命中值比闪避值高出1或更多时，闪避概率为0%

## 闪避概率计算公式

基于以上分析，闪避概率可以简化为：

```
闪避概率 = max(0, min(100, 闪避值 - 命中值 + 1))%
```

## 总结

闪避系统是一个基于命中值和闪避值差值的概率机制：

- 闪避值与命中值的差值决定了闪避的基础概率
- 闪避值每比命中值高1点，闪避概率增加1%
- 命中值每比闪避值高1点，闪避概率降低1%
- 闪避值比命中值高出99或更多时，闪避必定成功
- 命中值比闪避值高出1或更多时，闪避必定失败
