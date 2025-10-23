package com.kakaogame.secondpw.viewdata;

import com.kakaogame.security.C2558R;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PopupViewData.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/PopupType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT_ERROR", "EXIT_PROCESS_ERROR", "INVALID_AUTH_CODE_ERROR", "AUTH_CODE_LIMIT_ERROR", "AUTH_CODE_TIME_ERROR", "INVALID_PHONE_NUMBER_ERROR", "INVALID_EMAIL_ERROR", "SET_PASSWORD_INVALID", "CONFIRM_PASSWORD_INVALID", "PASSWORD_NOT_MACHED", "SAME_PASSWORD_USED", "SET_PASSWORD_COMPLETE", "RESET_PASSWORD_COMPLETE", "REMOVE_PASSWORD_COMPLETE", "KEYPAD_TIME_LIMIT", "INPUT_PASSWORD_PLEASE", "INPUT_PASSWORD_NOT_MATCHED", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PopupType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PopupType[] $VALUES;
    private final int value;
    public static final PopupType DEFAULT_ERROR = new PopupType(y.ۮڭڭܬި(862747115), 0, C2558R.string.kg_2nd_pw_default_error);
    public static final PopupType EXIT_PROCESS_ERROR = new PopupType(y.ݮڮֲڭܩ(-628349692), 1, C2558R.string.kg_2nd_pw_default_error);
    public static final PopupType INVALID_AUTH_CODE_ERROR = new PopupType(y.ۮڭڭܬި(862746819), 2, C2558R.string.kg_2nd_pw_invalid_auth_code_error);
    public static final PopupType AUTH_CODE_LIMIT_ERROR = new PopupType(y.ݮڮֲڭܩ(-628349204), 3, C2558R.string.kg_2nd_pw_invalid_auth_code_limit_error);
    public static final PopupType AUTH_CODE_TIME_ERROR = new PopupType(y.ٴسسݬߨ(1393038122), 4, C2558R.string.kg_2nd_pw_code_time_error);
    public static final PopupType INVALID_PHONE_NUMBER_ERROR = new PopupType(y.ٴسسݬߨ(1393060986), 5, C2558R.string.kg_2nd_pw_invalid_phone_number_error);
    public static final PopupType INVALID_EMAIL_ERROR = new PopupType(y.دײܮڳܯ(2051108725), 6, C2558R.string.kg_2nd_pw_invalid_email_error);
    public static final PopupType SET_PASSWORD_INVALID = new PopupType(y.ݬֲ֮ܲت(1512130103), 7, C2558R.string.kg_2nd_pw_set_password_invalid);
    public static final PopupType CONFIRM_PASSWORD_INVALID = new PopupType(y.دײܮڳܯ(2051107885), 8, C2558R.string.kg_2nd_pw_confirm_password_invalid);
    public static final PopupType PASSWORD_NOT_MACHED = new PopupType(y.٬ݯح׭٩(576432926), 9, C2558R.string.kg_2nd_pw_password_not_matched);
    public static final PopupType SAME_PASSWORD_USED = new PopupType(y.ݬֲ֮ܲت(1512129615), 10, C2558R.string.kg_2nd_pw_password_already_used);
    public static final PopupType SET_PASSWORD_COMPLETE = new PopupType(y.ٴسسݬߨ(1393059882), 11, C2558R.string.kg_2nd_pw_set_complete_text);
    public static final PopupType RESET_PASSWORD_COMPLETE = new PopupType(y.دײܮڳܯ(2051107677), 12, C2558R.string.kg_2nd_pw_reset_complete_text);
    public static final PopupType REMOVE_PASSWORD_COMPLETE = new PopupType(y.٬ݯح׭٩(576433606), 13, C2558R.string.kg_2nd_pw_unregister_complete_text);
    public static final PopupType KEYPAD_TIME_LIMIT = new PopupType(y.دײܮڳܯ(2051096485), 14, C2558R.string.kg_2nd_pw_password_time_limit);
    public static final PopupType INPUT_PASSWORD_PLEASE = new PopupType(y.ݬֲ֮ܲت(1512128863), 15, C2558R.string.kg_2nd_pw_enter_no_text_error_text);
    public static final PopupType INPUT_PASSWORD_NOT_MATCHED = new PopupType(y.٬ݯح׭٩(576433998), 16, C2558R.string.kg_2nd_pw_enter_no_match_error_text);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ PopupType[] $values() {
        return new PopupType[]{DEFAULT_ERROR, EXIT_PROCESS_ERROR, INVALID_AUTH_CODE_ERROR, AUTH_CODE_LIMIT_ERROR, AUTH_CODE_TIME_ERROR, INVALID_PHONE_NUMBER_ERROR, INVALID_EMAIL_ERROR, SET_PASSWORD_INVALID, CONFIRM_PASSWORD_INVALID, PASSWORD_NOT_MACHED, SAME_PASSWORD_USED, SET_PASSWORD_COMPLETE, RESET_PASSWORD_COMPLETE, REMOVE_PASSWORD_COMPLETE, KEYPAD_TIME_LIMIT, INPUT_PASSWORD_PLEASE, INPUT_PASSWORD_NOT_MATCHED};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<PopupType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PopupType valueOf(String str) {
        return (PopupType) Enum.valueOf(PopupType.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PopupType[] values() {
        return (PopupType[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PopupType(String str, int i, int i2) {
        this.value = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        PopupType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
