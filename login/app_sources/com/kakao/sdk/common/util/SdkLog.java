package com.kakao.sdk.common.util;

import com.kakao.sdk.common.Constants;
import com.kakao.sdk.common.KakaoSdk;
import com.kakaogame.game.StringSet;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.SingularParamsBase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

/* compiled from: SdkLog.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m839d2 = {"Lcom/kakao/sdk/common/util/SdkLog;", "", StringSet.enabled, "", "(Z)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat$delegate", "Lkotlin/Lazy;", "logs", "Ljava/util/LinkedList;", "", "log", "", "logged", "logLevel", "Lcom/kakao/sdk/common/util/SdkLogLevel;", "Companion", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SdkLog {
    public static final int MAX_SIZE = 100;

    /* renamed from: dateFormat$delegate, reason: from kotlin metadata */
    private final Lazy dateFormat;
    private final boolean enabled;
    private LinkedList<String> logs;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<SdkLog> instance$delegate = LazyKt.lazy(new Function0<SdkLog>() { // from class: com.kakao.sdk.common.util.SdkLog$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final SdkLog invoke() {
            return new SdkLog(false, 1, null);
        }
    });

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SdkLog() {
        this(false, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final SdkLog getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String log() {
        return INSTANCE.log();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SdkLog(boolean z) {
        this.enabled = z;
        this.logs = new LinkedList<>();
        this.dateFormat = LazyKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.kakao.sdk.common.util.SdkLog$dateFormat$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ SdkLog(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getLoggingEnabled() : z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final SimpleDateFormat getDateFormat() {
        return (SimpleDateFormat) this.dateFormat.getValue();
    }

    /* compiled from: SdkLog.kt */
    @Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, m839d2 = {"Lcom/kakao/sdk/common/util/SdkLog$Companion;", "", "()V", "MAX_SIZE", "", "instance", "Lcom/kakao/sdk/common/util/SdkLog;", "getInstance$annotations", Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/common/util/SdkLog;", "instance$delegate", "Lkotlin/Lazy;", "clear", "", "d", "logged", Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, SingularParamsBase.Constants.PACKAGE_NAME_KEY, "log", "", "v", "w", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final String log() {
            return Intrinsics.stringPlus(StringsKt.trimIndent("\n                ==== sdk version: 2.17.0\n                ==== app version: " + KakaoSdk.INSTANCE.getApplicationContextInfo().getAppVer() + "\n            "), CollectionsKt.joinToString$default(getInstance().logs, StringUtils.f1524LF, StringUtils.f1524LF, null, 0, null, null, 60, null));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: v */
        public final void m472v(Object logged) {
            getInstance().log(logged, SdkLogLevel.V);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: d */
        public final void m469d(Object logged) {
            getInstance().log(logged, SdkLogLevel.D);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: i */
        public final void m471i(Object logged) {
            getInstance().log(logged, SdkLogLevel.I);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: w */
        public final void m473w(Object logged) {
            getInstance().log(logged, SdkLogLevel.W);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: e */
        public final void m470e(Object logged) {
            getInstance().log(logged, SdkLogLevel.E);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final SdkLog getInstance() {
            return (SdkLog) SdkLog.instance$delegate.getValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void clear() {
            getInstance().logs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void log(Object logged, SdkLogLevel logLevel) {
        String str = logLevel.getSymbol() + ' ' + logged;
        if (!this.enabled || logLevel.compareTo(SdkLogLevel.I) < 0) {
            return;
        }
        this.logs.add(((Object) getDateFormat().format(new Date())) + ' ' + str);
        if (this.logs.size() > 100) {
            this.logs.poll();
        }
    }
}
