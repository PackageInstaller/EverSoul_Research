package com.kakao.sdk.partner.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kakao.sdk.common.model.ServerHosts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhasedServerHosts.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m839d2 = {"withPhase", "Lcom/kakao/sdk/common/model/ServerHosts;", "Lcom/kakao/sdk/common/model/ServerHosts$Companion;", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/kakao/sdk/partner/model/KakaoPhase;", "partner-common_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ServerHostsKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final ServerHosts withPhase(ServerHosts.Companion companion, KakaoPhase phase) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(phase, "phase");
        return new PhasedServerHosts(phase);
    }
}
