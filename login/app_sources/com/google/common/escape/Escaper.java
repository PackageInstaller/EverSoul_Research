package com.google.common.escape;

import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class Escaper {
    private final Function<String, String> asFunction = new Function() { // from class: com.google.common.escape.Escaper$$ExternalSyntheticLambda0
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return Escaper.this.escape((String) obj);
        }
    };

    public abstract String escape(String str);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Escaper() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Function<String, String> asFunction() {
        return this.asFunction;
    }
}
