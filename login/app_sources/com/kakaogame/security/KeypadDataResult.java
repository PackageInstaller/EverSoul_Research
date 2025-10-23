package com.kakaogame.security;

import com.liapp.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecondaryPWService.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/security/KeypadDataResult;", "", "publicKeyString", "", "keypadRawDataList", "", "Lcom/kakaogame/security/KeypadRawData;", "(Ljava/lang/String;Ljava/util/List;)V", "getKeypadRawDataList", "()Ljava/util/List;", "getPublicKeyString", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class KeypadDataResult {
    private final List<KeypadRawData> keypadRawDataList;
    private final String publicKeyString;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KeypadDataResult copy$default(KeypadDataResult keypadDataResult, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = keypadDataResult.publicKeyString;
        }
        if ((i & 2) != 0) {
            list = keypadDataResult.keypadRawDataList;
        }
        return keypadDataResult.copy(str, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.publicKeyString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<KeypadRawData> component2() {
        return this.keypadRawDataList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KeypadDataResult copy(String publicKeyString, List<KeypadRawData> keypadRawDataList) {
        Intrinsics.checkNotNullParameter(publicKeyString, y.ٴسسݬߨ(1393065042));
        Intrinsics.checkNotNullParameter(keypadRawDataList, y.ݬֲ֮ܲت(1512134415));
        return new KeypadDataResult(publicKeyString, keypadRawDataList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeypadDataResult)) {
            return false;
        }
        KeypadDataResult keypadDataResult = (KeypadDataResult) other;
        return Intrinsics.areEqual(this.publicKeyString, keypadDataResult.publicKeyString) && Intrinsics.areEqual(this.keypadRawDataList, keypadDataResult.keypadRawDataList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.publicKeyString.hashCode() * 31) + this.keypadRawDataList.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576436510) + this.publicKeyString + y.ݮڮֲڭܩ(-628340204) + this.keypadRawDataList + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KeypadDataResult(String str, List<KeypadRawData> list) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1393065042));
        Intrinsics.checkNotNullParameter(list, y.ݬֲ֮ܲت(1512134415));
        this.publicKeyString = str;
        this.keypadRawDataList = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPublicKeyString() {
        return this.publicKeyString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<KeypadRawData> getKeypadRawDataList() {
        return this.keypadRawDataList;
    }
}
