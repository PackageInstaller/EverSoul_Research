package com.kakaogame.log;

import com.kakaogame.KGResult;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseEvent.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\u0014\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017J\u0012\u0010\u0018\u001a\u00020\u00132\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/log/FirebaseEvent;", "", "className", "", "function", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "getFunction", "setFunction", ServerConstants.HEADER_TRACE_ID, "", "getTraceId", "()I", "setTraceId", "(I)V", "addMetric", "", "name", "setResult", "result", "Lcom/kakaogame/KGResult;", "setTraceResult", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class FirebaseEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String className;
    private String function;
    private int traceId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final FirebaseEvent getFirebaseEvent(String str, String str2) {
        return INSTANCE.getFirebaseEvent(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final FirebaseEvent getFirebaseTrace(String str, String str2) {
        return INSTANCE.getFirebaseTrace(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendEvent(String str, String str2, KGResult<?> kGResult) {
        INSTANCE.sendEvent(str, str2, kGResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected FirebaseEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051472421));
        Intrinsics.checkNotNullParameter(str2, y.ۮڭڭܬި(862549675));
        this.className = str;
        this.function = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getClassName() {
        return this.className;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getFunction() {
        return this.function;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setClassName(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        this.className = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setFunction(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        this.function = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTraceId() {
        return this.traceId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTraceId(int i) {
        this.traceId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setResult(KGResult<?> result) {
        if (result != null) {
            CoreManager.INSTANCE.getInstance().sendLogFirebase(this.className, this.function, result);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTraceResult(KGResult<?> result) {
        Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
        CoreManager.INSTANCE.getInstance().stopFirebaseTrace(this.traceId, KeyBaseResult.INSTANCE.getResult(result.getCode()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addMetric(String name) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        CoreManager.INSTANCE.getInstance().addTraceMetric(this.traceId, name);
    }

    /* compiled from: FirebaseEvent.kt */
    @Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J&\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0007¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/log/FirebaseEvent$Companion;", "", "()V", "getFirebaseEvent", "Lcom/kakaogame/log/FirebaseEvent;", "className", "", "function", "getFirebaseTrace", "sendEvent", "", "result", "Lcom/kakaogame/KGResult;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final FirebaseEvent getFirebaseEvent(String className, String function) {
            Intrinsics.checkNotNullParameter(className, y.دײܮڳܯ(2051472421));
            Intrinsics.checkNotNullParameter(function, y.ۮڭڭܬި(862549675));
            return new FirebaseEvent(className, function);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final FirebaseEvent getFirebaseTrace(String className, String function) {
            Intrinsics.checkNotNullParameter(className, y.دײܮڳܯ(2051472421));
            Intrinsics.checkNotNullParameter(function, y.ۮڭڭܬި(862549675));
            FirebaseEvent firebaseEvent = new FirebaseEvent(className, function);
            firebaseEvent.setTraceId(CoreManager.INSTANCE.getInstance().startFirebaseTrace(className + '_' + function));
            return firebaseEvent;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void sendEvent(String className, String function, KGResult<?> result) {
            Intrinsics.checkNotNullParameter(className, y.دײܮڳܯ(2051472421));
            Intrinsics.checkNotNullParameter(function, y.ۮڭڭܬި(862549675));
            if (result != null) {
                CoreManager.INSTANCE.getInstance().sendLogFirebase(className, function, result);
            }
        }
    }
}
