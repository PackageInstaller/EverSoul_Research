package com.kakaogame.security;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecondaryPWService.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r¨\u0006\u0017"}, m839d2 = {"Lcom/kakaogame/security/SendAuthCodeResult;", "", "isSend", "", "authType", "Lcom/kakaogame/security/SendAuthType;", "authKey", "", "(ZLcom/kakaogame/security/SendAuthType;Ljava/lang/String;)V", "getAuthKey", "()Ljava/lang/String;", "getAuthType", "()Lcom/kakaogame/security/SendAuthType;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SendAuthCodeResult {
    private final String authKey;
    private final SendAuthType authType;
    private final boolean isSend;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ SendAuthCodeResult copy$default(SendAuthCodeResult sendAuthCodeResult, boolean z, SendAuthType sendAuthType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sendAuthCodeResult.isSend;
        }
        if ((i & 2) != 0) {
            sendAuthType = sendAuthCodeResult.authType;
        }
        if ((i & 4) != 0) {
            str = sendAuthCodeResult.authKey;
        }
        return sendAuthCodeResult.copy(z, sendAuthType, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component1() {
        return this.isSend;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SendAuthType component2() {
        return this.authType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.authKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SendAuthCodeResult copy(boolean isSend, SendAuthType authType, String authKey) {
        Intrinsics.checkNotNullParameter(authType, y.ۮڭڭܬި(862463915));
        Intrinsics.checkNotNullParameter(authKey, y.دײܮڳܯ(2051058789));
        return new SendAuthCodeResult(isSend, authType, authKey);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendAuthCodeResult)) {
            return false;
        }
        SendAuthCodeResult sendAuthCodeResult = (SendAuthCodeResult) other;
        return this.isSend == sendAuthCodeResult.isSend && this.authType == sendAuthCodeResult.authType && Intrinsics.areEqual(this.authKey, sendAuthCodeResult.authKey);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((Boolean.hashCode(this.isSend) * 31) + this.authType.hashCode()) * 31) + this.authKey.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݬֲ֮ܲت(1512080839) + this.isSend + y.ٲٴݴ״ٰ(1782362152) + this.authType + y.ݮڮֲڭܩ(-628253708) + this.authKey + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SendAuthCodeResult(boolean z, SendAuthType sendAuthType, String str) {
        Intrinsics.checkNotNullParameter(sendAuthType, y.ۮڭڭܬި(862463915));
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051058789));
        this.isSend = z;
        this.authType = sendAuthType;
        this.authKey = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isSend() {
        return this.isSend;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ SendAuthCodeResult(boolean z, SendAuthType sendAuthType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? SendAuthType.TALK : sendAuthType, (i & 4) != 0 ? "" : str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SendAuthType getAuthType() {
        return this.authType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAuthKey() {
        return this.authKey;
    }
}
