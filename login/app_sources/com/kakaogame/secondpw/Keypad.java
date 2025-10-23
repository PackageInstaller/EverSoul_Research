package com.kakaogame.secondpw;

import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecondPWViewManager.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/secondpw/Keypad;", "", Base2ndPWViewData.KEY_PATH, "", "values", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getValues", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Keypad {
    private final String path;
    private final String values;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Keypad copy$default(Keypad keypad, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = keypad.path;
        }
        if ((i & 2) != 0) {
            str2 = keypad.values;
        }
        return keypad.copy(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.path;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.values;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Keypad copy(String path, String values) {
        Intrinsics.checkNotNullParameter(path, y.دײܮڳܯ(2051509965));
        Intrinsics.checkNotNullParameter(values, y.ٴسسݬߨ(1393036690));
        return new Keypad(path, values);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Keypad)) {
            return false;
        }
        Keypad keypad = (Keypad) other;
        return Intrinsics.areEqual(this.path, keypad.path) && Intrinsics.areEqual(this.values, keypad.values);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.path.hashCode() * 31) + this.values.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576440894) + this.path + y.دײܮڳܯ(2051083277) + this.values + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Keypad(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051509965));
        Intrinsics.checkNotNullParameter(str2, y.ٴسسݬߨ(1393036690));
        this.path = str;
        this.values = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPath() {
        return this.path;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getValues() {
        return this.values;
    }
}
