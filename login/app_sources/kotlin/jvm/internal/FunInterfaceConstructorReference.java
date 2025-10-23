package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KFunction;

/* loaded from: classes3.dex */
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class funInterface;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FunInterfaceConstructorReference(Class cls) {
        super(1);
        this.funInterface = cls;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FunInterfaceConstructorReference) {
            return this.funInterface.equals(((FunInterfaceConstructorReference) obj).funInterface);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.internal.FunctionReference
    public String toString() {
        return "fun interface " + this.funInterface.getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}
