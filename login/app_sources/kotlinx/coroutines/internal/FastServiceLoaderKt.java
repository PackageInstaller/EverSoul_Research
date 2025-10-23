package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: FastServiceLoader.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m839d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Object m1440constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1440constructorimpl = Result.m1440constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m1440constructorimpl = Result.m1440constructorimpl(ResultKt.createFailure(th));
        }
        ANDROID_DETECTED = Result.m1447isSuccessimpl(m1440constructorimpl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }
}
