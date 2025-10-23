package com.kakao.sdk.partner.model;

import com.kakao.sdk.common.util.KakaoJson;
import com.kakaogame.game.GameServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoPhase.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, m839d2 = {"Lcom/kakao/sdk/partner/model/KakaoPhase;", "", "phaseName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPhaseName", "()Ljava/lang/String;", "DEV", "OMEGA", "SANDBOX", "CBT", "PRODUCTION", "Companion", "partner-common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public enum KakaoPhase {
    DEV(GameServerProtocol.Alpha),
    OMEGA("omega"),
    SANDBOX(GameServerProtocol.Sandbox),
    CBT("cbt"),
    PRODUCTION(GameServerProtocol.Release);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String phaseName;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KakaoPhase(String str) {
        this.phaseName = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPhaseName() {
        return this.phaseName;
    }

    /* compiled from: KakaoPhase.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakao/sdk/partner/model/KakaoPhase$Companion;", "", "()V", "fromName", "Lcom/kakao/sdk/partner/model/KakaoPhase;", "value", "", "partner-common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KakaoPhase fromName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (KakaoPhase) KakaoJson.INSTANCE.fromJson(value, KakaoPhase.class);
        }
    }
}
