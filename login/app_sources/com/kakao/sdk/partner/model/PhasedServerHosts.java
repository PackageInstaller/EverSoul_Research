package com.kakao.sdk.partner.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kakao.sdk.common.model.ServerHosts;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhasedServerHosts.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, m839d2 = {"Lcom/kakao/sdk/partner/model/PhasedServerHosts;", "Lcom/kakao/sdk/common/model/ServerHosts;", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/kakao/sdk/partner/model/KakaoPhase;", "(Lcom/kakao/sdk/partner/model/KakaoPhase;)V", "account", "", "getAccount", "()Ljava/lang/String;", "channel", "getChannel", "kapi", "getKapi", "kauth", "getKauth", "mobileAccount", "getMobileAccount", "navi", "getNavi", "getPhase", "()Lcom/kakao/sdk/partner/model/KakaoPhase;", "sharer", "getSharer", "partner-common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PhasedServerHosts extends ServerHosts {
    private final String account;
    private final String channel;
    private final String kapi;
    private final String kauth;
    private final String mobileAccount;
    private final String navi;
    private final KakaoPhase phase;
    private final String sharer;

    /* compiled from: PhasedServerHosts.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[KakaoPhase.values().length];
            iArr[KakaoPhase.DEV.ordinal()] = 1;
            iArr[KakaoPhase.OMEGA.ordinal()] = 2;
            iArr[KakaoPhase.SANDBOX.ordinal()] = 3;
            iArr[KakaoPhase.CBT.ordinal()] = 4;
            iArr[KakaoPhase.PRODUCTION.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PhasedServerHosts(KakaoPhase phase) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(phase, "phase");
        this.phase = phase;
        int i = WhenMappings.$EnumSwitchMapping$0[phase.ordinal()];
        if (i == 1) {
            str = "alpha-kauth.kakao.com";
        } else if (i == 2) {
            str = "omega-kauth.kakao.com";
        } else if (i == 3) {
            str = "sandbox-kauth.kakao.com";
        } else if (i == 4) {
            str = "beta-kauth.kakao.com";
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str = "kauth.kakao.com";
        }
        this.kauth = str;
        int i2 = WhenMappings.$EnumSwitchMapping$0[phase.ordinal()];
        if (i2 == 1) {
            str2 = "alpha-kapi.kakao.com";
        } else if (i2 == 2) {
            str2 = "omega-kapi.kakao.com";
        } else if (i2 == 3) {
            str2 = "sandbox-kapi.kakao.com";
        } else if (i2 == 4) {
            str2 = "beta-kapi.kakao.com";
        } else {
            if (i2 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str2 = "kapi.kakao.com";
        }
        this.kapi = str2;
        int i3 = WhenMappings.$EnumSwitchMapping$0[phase.ordinal()];
        if (i3 == 1 || i3 == 2) {
            str3 = "alpha-accounts.kakao.com";
        } else if (i3 == 3) {
            str3 = "sandbox-accounts.kakao.com";
        } else if (i3 == 4) {
            str3 = "beta-accounts.kakao.com";
        } else {
            if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str3 = "accounts.kakao.com";
        }
        this.account = str3;
        int i4 = WhenMappings.$EnumSwitchMapping$0[phase.ordinal()];
        if (i4 == 1 || i4 == 2) {
            str4 = "alpha-auth.kakao.com";
        } else if (i4 == 3) {
            str4 = "sandbox-auth.kakao.com";
        } else if (i4 == 4) {
            str4 = "beta-auth.kakao.com";
        } else {
            if (i4 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str4 = "auth.kakao.com";
        }
        this.mobileAccount = str4;
        int i5 = WhenMappings.$EnumSwitchMapping$0[phase.ordinal()];
        if (i5 == 1 || i5 == 2) {
            str5 = "alpha-sharer.devel.kakao.com";
        } else if (i5 == 3) {
            str5 = "sandbox-sharer.devel.kakao.com";
        } else if (i5 == 4) {
            str5 = "beta-sharer.kakao.com";
        } else {
            if (i5 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str5 = "sharer.kakao.com";
        }
        this.sharer = str5;
        int i6 = WhenMappings.$EnumSwitchMapping$0[phase.ordinal()];
        if (i6 == 1 || i6 == 2 || i6 == 3) {
            str6 = "sandbox-kakaonavi-wguide.kakao.com";
        } else {
            if (i6 != 4 && i6 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str6 = "kakaonavi-wguide.kakao.com";
        }
        this.navi = str6;
        int i7 = WhenMappings.$EnumSwitchMapping$0[phase.ordinal()];
        if (i7 == 1 || i7 == 2 || i7 == 3) {
            str7 = "sandbox-pf.kakao.com";
        } else if (i7 == 4) {
            str7 = "beta-pf.kakao.com";
        } else {
            if (i7 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str7 = "pf.kakao.com";
        }
        this.channel = str7;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KakaoPhase getPhase() {
        return this.phase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ServerHosts
    public String getKauth() {
        return this.kauth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ServerHosts
    public String getKapi() {
        return this.kapi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ServerHosts
    public String getAccount() {
        return this.account;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ServerHosts
    public String getMobileAccount() {
        return this.mobileAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ServerHosts
    public String getSharer() {
        return this.sharer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ServerHosts
    public String getNavi() {
        return this.navi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ServerHosts
    public String getChannel() {
        return this.channel;
    }
}
