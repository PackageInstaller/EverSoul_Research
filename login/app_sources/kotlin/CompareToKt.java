package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: compareTo.kt */
@Metadata(m838d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m839d2 = {"compareTo", "", "T", "", "other", "(Ljava/lang/Comparable;Ljava/lang/Object;)I", "kotlin-stdlib"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CompareToKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final <T> int compareTo(Comparable<? super T> comparable, T t) {
        Intrinsics.checkNotNullParameter(comparable, "<this>");
        return comparable.compareTo(t);
    }
}
