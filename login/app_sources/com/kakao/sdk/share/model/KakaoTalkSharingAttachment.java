package com.kakao.sdk.share.model;

import com.google.gson.JsonObject;
import com.kakao.sdk.share.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoTalkSharingAttachment.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m839d2 = {"Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment;", "", "lv", "", "av", "ak", "P", "Lcom/google/gson/JsonObject;", "C", "ti", "", "ta", "extras", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;JLcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;)V", "getC", "()Lcom/google/gson/JsonObject;", "getP", "getAk", "()Ljava/lang/String;", "getAv", "getExtras", "getLv", "getTa", "getTi", "()J", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoTalkSharingAttachment {
    private final JsonObject C;
    private final JsonObject P;
    private final String ak;
    private final String av;
    private final JsonObject extras;
    private final String lv;
    private final JsonObject ta;
    private final long ti;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KakaoTalkSharingAttachment(String lv, String av, String ak, JsonObject jsonObject, JsonObject jsonObject2, long j, JsonObject jsonObject3, JsonObject extras) {
        Intrinsics.checkNotNullParameter(lv, "lv");
        Intrinsics.checkNotNullParameter(av, "av");
        Intrinsics.checkNotNullParameter(ak, "ak");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.lv = lv;
        this.av = av;
        this.ak = ak;
        this.P = jsonObject;
        this.C = jsonObject2;
        this.ti = j;
        this.ta = jsonObject3;
        this.extras = extras;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KakaoTalkSharingAttachment(String str, String str2, String str3, JsonObject jsonObject, JsonObject jsonObject2, long j, JsonObject jsonObject3, JsonObject jsonObject4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Constants.LINKVER_40 : str, (i & 2) != 0 ? Constants.LINKVER_40 : str2, str3, (i & 8) != 0 ? null : jsonObject, (i & 16) != 0 ? null : jsonObject2, j, (i & 64) != 0 ? null : jsonObject3, jsonObject4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLv() {
        return this.lv;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAv() {
        return this.av;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAk() {
        return this.ak;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getP() {
        return this.P;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getC() {
        return this.C;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getTi() {
        return this.ti;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getTa() {
        return this.ta;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getExtras() {
        return this.extras;
    }
}
