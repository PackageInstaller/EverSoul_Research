package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* compiled from: SystemProps.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, m839d2 = {"AVAILABLE_PROCESSORS", "", "getAVAILABLE_PROCESSORS", "()I", "systemProp", "", "propertyName", "kotlinx-coroutines-core"}, m840k = 5, m841mv = {1, 8, 0}, m843xi = 48, m844xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* loaded from: classes3.dex */
final /* synthetic */ class SystemPropsKt__SystemPropsKt {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final int getAVAILABLE_PROCESSORS() {
        return AVAILABLE_PROCESSORS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String systemProp(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
