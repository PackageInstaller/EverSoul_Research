package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

/* loaded from: classes3.dex */
public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PropertyReference0() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PropertyReference0(Object obj) {
        super(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.property0(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.reflect.KProperty
    public KProperty0.Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }
}
