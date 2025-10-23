package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Regex.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Regex$findAll$2() {
        super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public final MatchResult invoke(MatchResult p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.next();
    }
}
