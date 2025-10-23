package com.kakao.sdk.common.util;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: SdkLog.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m839d2 = {"Lcom/kakao/sdk/common/util/SdkLogLevel;", "", FirebaseAnalytics.Param.LEVEL, "", "symbol", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getLevel", "()I", "getSymbol", "()Ljava/lang/String;", "V", "D", "I", "W", "E", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public enum SdkLogLevel {
    V(0, "[💬]"),
    D(1, "[ℹ️]"),
    I(2, "[🔬]"),
    W(3, "[⚠️]"),
    E(4, "[‼️]");

    private final int level;
    private final String symbol;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SdkLogLevel(int i, String str) {
        this.level = i;
        this.symbol = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getLevel() {
        return this.level;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSymbol() {
        return this.symbol;
    }
}
