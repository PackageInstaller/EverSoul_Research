package com.kakaogame.secondpw;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PasswordViewType.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/secondpw/PasswordViewType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GUIDE_CENTER", "GUIDE_3_LINE", "GUIDE_2_LINE", "INPUT_CODE", "INPUT_PHONE", "INPUT_EMAIL", "SET_PASSWORD", "INPUT_PASSWORD", "POPUP", "POPUP_RESTRICT", "RESET_DIGIT_CODE", "RESULT", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PasswordViewType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PasswordViewType[] $VALUES;
    private final String value;
    public static final PasswordViewType GUIDE_CENTER = new PasswordViewType(y.֬ڱܱײٮ(-1159179655), 0, y.ٴسسݬߨ(1393036938));
    public static final PasswordViewType GUIDE_3_LINE = new PasswordViewType(y.ٲٴݴ״ٰ(1782388488), 1, y.ݮڮֲڭܩ(-628343836));
    public static final PasswordViewType GUIDE_2_LINE = new PasswordViewType(y.ݬֲ֮ܲت(1512121199), 2, y.֬ڱܱײٮ(-1159178831));
    public static final PasswordViewType INPUT_CODE = new PasswordViewType(y.ݬֲ֮ܲت(1512120927), 3, y.ݮڮֲڭܩ(-628343500));
    public static final PasswordViewType INPUT_PHONE = new PasswordViewType(y.ٴسسݬߨ(1393035986), 4, y.ۮڭڭܬި(862741267));
    public static final PasswordViewType INPUT_EMAIL = new PasswordViewType(y.ݬֲ֮ܲت(1512120519), 5, y.٬ݯح׭٩(576442054));
    public static final PasswordViewType SET_PASSWORD = new PasswordViewType(y.دײܮڳܯ(2051095309), 6, y.ݬֲ֮ܲت(1512116887));
    public static final PasswordViewType INPUT_PASSWORD = new PasswordViewType(y.ٴسسݬߨ(1393034266), 7, y.ݬֲ֮ܲت(1512120415));
    public static final PasswordViewType POPUP = new PasswordViewType(y.دײܮڳܯ(2051081909), 8, y.ݬֲ֮ܲت(1512165471));
    public static final PasswordViewType POPUP_RESTRICT = new PasswordViewType(y.֬ڱܱײٮ(-1159178175), 9, y.ٴسسݬߨ(1393034402));
    public static final PasswordViewType RESET_DIGIT_CODE = new PasswordViewType(y.٬ݯح׭٩(576438974), 10, y.٬ݯح׭٩(576438734));
    public static final PasswordViewType RESULT = new PasswordViewType(y.٬ݯح׭٩(576439086), 11, y.ٴسسݬߨ(1392585418));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ PasswordViewType[] $values() {
        return new PasswordViewType[]{GUIDE_CENTER, GUIDE_3_LINE, GUIDE_2_LINE, INPUT_CODE, INPUT_PHONE, INPUT_EMAIL, SET_PASSWORD, INPUT_PASSWORD, POPUP, POPUP_RESTRICT, RESET_DIGIT_CODE, RESULT};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<PasswordViewType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PasswordViewType valueOf(String str) {
        return (PasswordViewType) Enum.valueOf(PasswordViewType.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PasswordViewType[] values() {
        return (PasswordViewType[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PasswordViewType(String str, int i, String str2) {
        this.value = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        PasswordViewType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
