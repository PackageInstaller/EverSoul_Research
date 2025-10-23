package com.kakao.sdk.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ServerHosts.kt */
@Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0014"}, m839d2 = {"Lcom/kakao/sdk/common/model/ServerHosts;", "", "()V", "account", "", "getAccount", "()Ljava/lang/String;", "channel", "getChannel", "kapi", "getKapi", "kauth", "getKauth", "mobileAccount", "getMobileAccount", "navi", "getNavi", "sharer", "getSharer", "Companion", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class ServerHosts {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String kauth = "kauth.kakao.com";
    private final String kapi = "kapi.kakao.com";
    private final String account = "accounts.kakao.com";
    private final String mobileAccount = "auth.kakao.com";
    private final String sharer = "sharer.kakao.com";
    private final String navi = "kakaonavi-wguide.kakao.com";
    private final String channel = "pf.kakao.com";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getKauth() {
        return this.kauth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getKapi() {
        return this.kapi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAccount() {
        return this.account;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getMobileAccount() {
        return this.mobileAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSharer() {
        return this.sharer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getNavi() {
        return this.navi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getChannel() {
        return this.channel;
    }

    /* compiled from: ServerHosts.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m839d2 = {"Lcom/kakao/sdk/common/model/ServerHosts$Companion;", "", "()V", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }
    }
}
