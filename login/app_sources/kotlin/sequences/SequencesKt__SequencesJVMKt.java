package kotlin.sequences;

import java.util.Enumeration;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SequencesJVM.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b¨\u0006\u0004"}, m839d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, m840k = 5, m841mv = {1, 8, 0}, m843xi = 49, m844xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes3.dex */
class SequencesKt__SequencesJVMKt extends SequencesKt__SequenceBuilderKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final <T> Sequence<T> asSequence(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return SequencesKt.asSequence(CollectionsKt.iterator(enumeration));
    }
}
