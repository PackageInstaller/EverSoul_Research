package com.kakaogame.secondpw;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ActionType.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006'"}, m839d2 = {"Lcom/kakaogame/secondpw/ActionType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ENTER_IS_ALLOWED_ACCESS", "ENTER_SHOW_PASSWORD_SETTING_VIEW", "SHOW_RESTRICT_POPUP", "EXIT", "CLOSE_POPUP", "RESTRICT_ACCESS", "SHOW_PUT_PASSWORD", "SET_REQUEST_CODE", "SET_CODE_TALK", "SET_CODE_SMS", "SET_CODE_EMAIL", "SET_AGREE", "SET_PHONE_NUMBER", "SET_EMAIL", "RESET_DIGIT_CODE_1", "RESET_DIGIT_CODE_2", "KEYPAD_TIME_LIMIT", "KEYPAD_TIME_LIMIT_1", "KEYPAD_TIME_LIMIT_2", "SET_PASSWORD", "SET_COMPLETE", "REQUEST_RESET", "REQUEST_REMOVE", "PUT_PASSWORD", "RESET_REQUEST_CODE", "RESET_CODE", "RESET_PASSWORD", "RESET_COMPLETE", "REMOVE_CONFIRM", "REMOVE_REQUEST_CODE", "REMOVE_CODE", "REMOVE_COMPLETE", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ActionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActionType[] $VALUES;
    private final String value;
    public static final ActionType ENTER_IS_ALLOWED_ACCESS = new ActionType(y.دײܮڳܯ(2051092133), 0, y.ٲٴݴ״ٰ(1782395688));
    public static final ActionType ENTER_SHOW_PASSWORD_SETTING_VIEW = new ActionType(y.٬ݯح׭٩(576449102), 1, y.ݬֲ֮ܲت(1512113671));
    public static final ActionType SHOW_RESTRICT_POPUP = new ActionType(y.ٴسسݬߨ(1393043562), 2, y.ٴسسݬߨ(1393045458));
    public static final ActionType EXIT = new ActionType(y.ٴسسݬߨ(1393043794), 3, y.ٴسسݬߨ(1393043586));
    public static final ActionType CLOSE_POPUP = new ActionType(y.ݮڮֲڭܩ(-628351500), 4, y.دײܮڳܯ(2051091277));
    public static final ActionType RESTRICT_ACCESS = new ActionType(y.٬ݯح׭٩(576450214), 5, y.ۮڭڭܬި(862733115));
    public static final ActionType SHOW_PUT_PASSWORD = new ActionType(y.֬ڱܱײٮ(-1159170423), 6, y.٬ݯح׭٩(576450350));
    public static final ActionType SET_REQUEST_CODE = new ActionType(y.֬ڱܱײٮ(-1159169567), 7, y.ٴسسݬߨ(1393042450));
    public static final ActionType SET_CODE_TALK = new ActionType(y.ݬֲ֮ܲت(1512115839), 8, y.ٲٴݴ״ٰ(1782397560));
    public static final ActionType SET_CODE_SMS = new ActionType(y.ٴسسݬߨ(1393043090), 9, y.ݮڮֲڭܩ(-628354548));
    public static final ActionType SET_CODE_EMAIL = new ActionType(y.ݮڮֲڭܩ(-628354068), 10, y.دײܮڳܯ(2051089741));
    public static final ActionType SET_AGREE = new ActionType(y.ٴسسݬߨ(1393041610), 11, y.ٴسسݬߨ(1393041506));
    public static final ActionType SET_PHONE_NUMBER = new ActionType(y.ٲٴݴ״ٰ(1782398568), 12, y.دײܮڳܯ(2051089053));
    public static final ActionType SET_EMAIL = new ActionType(y.֬ڱܱײٮ(-1159168167), 13, y.ۮڭڭܬި(862735163));
    public static final ActionType RESET_DIGIT_CODE_1 = new ActionType(y.٬ݯح׭٩(576448366), 14, y.ٴسسݬߨ(1393042146));
    public static final ActionType RESET_DIGIT_CODE_2 = new ActionType(y.ٴسسݬߨ(1393048770), 15, y.٬ݯح׭٩(576448462));
    public static final ActionType KEYPAD_TIME_LIMIT = new ActionType(y.دײܮڳܯ(2051096485), 16, y.ۮڭڭܬި(862737419));
    public static final ActionType KEYPAD_TIME_LIMIT_1 = new ActionType(y.دײܮڳܯ(2051095909), 17, y.ٲٴݴ״ٰ(1782391160));
    public static final ActionType KEYPAD_TIME_LIMIT_2 = new ActionType(y.ۮڭڭܬި(862736723), 18, y.ٲٴݴ״ٰ(1782390952));
    public static final ActionType SET_PASSWORD = new ActionType(y.دײܮڳܯ(2051095309), 19, y.ݬֲ֮ܲت(1512116887));
    public static final ActionType SET_COMPLETE = new ActionType(y.ٴسسݬߨ(1393048066), 20, y.ݬֲ֮ܲت(1512116855));
    public static final ActionType REQUEST_RESET = new ActionType(y.٬ݯح׭٩(576454518), 21, y.ݮڮֲڭܩ(-628355428));
    public static final ActionType REQUEST_REMOVE = new ActionType(y.٬ݯح׭٩(576450574), 22, y.ݮڮֲڭܩ(-628355092));
    public static final ActionType PUT_PASSWORD = new ActionType(y.ݮڮֲڭܩ(-628358788), 23, y.ݬֲ֮ܲت(1512120103));
    public static final ActionType RESET_REQUEST_CODE = new ActionType(y.ۮڭڭܬި(862740235), 24, y.دײܮڳܯ(2051094509));
    public static final ActionType RESET_CODE = new ActionType(y.ٴسسݬߨ(1393047394), 25, y.٬ݯح׭٩(576451310));
    public static final ActionType RESET_PASSWORD = new ActionType(y.ٲٴݴ״ٰ(1782394632), 26, y.ݬֲ֮ܲت(1512119303));
    public static final ActionType RESET_COMPLETE = new ActionType(y.دײܮڳܯ(2051093357), 27, y.ݮڮֲڭܩ(-628357940));
    public static final ActionType REMOVE_CONFIRM = new ActionType(y.ݬֲ֮ܲت(1512118663), 28, y.֬ڱܱײٮ(-1159172959));
    public static final ActionType REMOVE_REQUEST_CODE = new ActionType(y.ۮڭڭܬި(862739059), 29, y.٬ݯح׭٩(576452270));
    public static final ActionType REMOVE_CODE = new ActionType(y.دײܮڳܯ(2051083813), 30, y.دײܮڳܯ(2051092893));
    public static final ActionType REMOVE_COMPLETE = new ActionType(y.ٲٴݴ״ٰ(1782387280), 31, y.٬ݯح׭٩(576440462));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ ActionType[] $values() {
        return new ActionType[]{ENTER_IS_ALLOWED_ACCESS, ENTER_SHOW_PASSWORD_SETTING_VIEW, SHOW_RESTRICT_POPUP, EXIT, CLOSE_POPUP, RESTRICT_ACCESS, SHOW_PUT_PASSWORD, SET_REQUEST_CODE, SET_CODE_TALK, SET_CODE_SMS, SET_CODE_EMAIL, SET_AGREE, SET_PHONE_NUMBER, SET_EMAIL, RESET_DIGIT_CODE_1, RESET_DIGIT_CODE_2, KEYPAD_TIME_LIMIT, KEYPAD_TIME_LIMIT_1, KEYPAD_TIME_LIMIT_2, SET_PASSWORD, SET_COMPLETE, REQUEST_RESET, REQUEST_REMOVE, PUT_PASSWORD, RESET_REQUEST_CODE, RESET_CODE, RESET_PASSWORD, RESET_COMPLETE, REMOVE_CONFIRM, REMOVE_REQUEST_CODE, REMOVE_CODE, REMOVE_COMPLETE};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<ActionType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActionType valueOf(String str) {
        return (ActionType) Enum.valueOf(ActionType.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActionType[] values() {
        return (ActionType[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ActionType(String str, int i, String str2) {
        this.value = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        ActionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
