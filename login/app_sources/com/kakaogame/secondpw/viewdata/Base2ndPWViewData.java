package com.kakaogame.secondpw.viewdata;

import android.text.SpannableStringBuilder;
import com.kakaogame.KGObject;
import com.kakaogame.KGSystem;
import com.kakaogame.p029ui.font.StyleTextKt;
import com.kakaogame.secondpw.PasswordViewType;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.json.JSONArray;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Base2ndPWViewData.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b3\b\u0016\u0018\u0000 W2\u00020\u0001:\u0001WB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010V\u001a\u00020\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b \u0010\fR\u0011\u0010!\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\"\u0010\fR\u0011\u0010#\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b)\u0010\u0006R\u0011\u0010*\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b+\u0010\fR\u0011\u0010,\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b-\u0010\fR\u0011\u0010.\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b/\u0010\u0006R\u0011\u00100\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b1\u0010\u0006R\u0011\u00102\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b3\u0010\fR\u0011\u00104\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b5\u0010\u0006R\u0011\u00106\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b7\u0010\fR\u0011\u00108\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b9\u0010\u0006R\u0011\u0010:\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b;\u0010\fR\u0011\u0010<\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b=\u0010'R\u0011\u0010>\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b?\u0010'R\u0011\u0010@\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bA\u0010\u0006R\u0011\u0010B\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bC\u0010\u0006R\u0011\u0010D\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bE\u0010\u0006R\u0011\u0010F\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bG\u0010\fR\u0011\u0010H\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bI\u0010\fR\u0011\u0010J\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\bK\u0010'R\u0011\u0010L\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bM\u0010\u0006R\u0011\u0010N\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bO\u0010\fR\u0011\u0010P\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bQ\u0010\fR\u0011\u0010R\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bS\u0010\u0006R\u0011\u0010T\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bU\u0010\f¨\u0006X"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "Lcom/kakaogame/KGObject;", "()V", Base2ndPWViewData.KEY_ACCESS_KEY, "", "getAccessKey", "()Ljava/lang/String;", "cancelAction", "getCancelAction", "cancelButtonText", "Landroid/text/SpannableStringBuilder;", "getCancelButtonText", "()Landroid/text/SpannableStringBuilder;", "confirmAction", "getConfirmAction", "confirmButtonText", "getConfirmButtonText", Base2ndPWViewData.KEY_DETAIL, "getDetail", ServerConstants.EMAIL_ADDRESS, "getEmailAddress", "exitAction", "getExitAction", "firstVirtualKeypadImage", "getFirstVirtualKeypadImage", "firstVirtualKeypadKeys", "getFirstVirtualKeypadKeys", "hasPassive", "", "getHasPassive", "()Z", Base2ndPWViewData.KEY_INPUT, "getInput", "inputConfirm", "getInputConfirm", "isResult", Base2ndPWViewData.KEY_MIN, "", "getMin", "()I", "minLabel", "getMinLabel", Base2ndPWViewData.KEY_PASSIVE, "getPassive", "passiveDesc", "getPassiveDesc", ServerConstants.PHONE_NUMBER, "getPhoneNumber", "removePasswordAction", "getRemovePasswordAction", "removePasswordButtonText", "getRemovePasswordButtonText", "resetAction", "getResetAction", "resetButtonText", "getResetButtonText", "resetPasswordAction", "getResetPasswordAction", "resetPasswordButtonText", "getResetPasswordButtonText", ServerConstants.TRACE_RESULT_CODE, "getResultCode", Base2ndPWViewData.KEY_SEC, "getSec", "secLabel", "getSecLabel", "secondVirtualKeypadImage", "getSecondVirtualKeypadImage", "secondVirtualKeypadKeys", "getSecondVirtualKeypadKeys", "subContent", "getSubContent", "timeGuide", "getTimeGuide", "timeLimit", "getTimeLimit", "timeLimitAction", "getTimeLimitAction", "title", "getTitle", "titleBar", "getTitleBar", "type", "getType", "viewContent", "getViewContent", "getDisplayLanguage", "Companion", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class Base2ndPWViewData extends KGObject {
    public static final String KEY_ACCESS_KEY = "accessKey";
    public static final String KEY_ACTION = "action";
    public static final String KEY_CANCEL = "cancel";
    public static final String KEY_CONFIRM = "confirm";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DETAIL = "detail";
    public static final String KEY_EMAIL_ADDRESS = "email_address";
    public static final String KEY_EXIT = "exit";
    public static final String KEY_HAS_PASSIVE = "has_passive";
    public static final String KEY_INPUT = "input";
    public static final String KEY_INPUT_CONFIRM = "input_confirm";
    public static final String KEY_KEY = "key";
    public static final String KEY_KEYPAD = "keypad";
    public static final String KEY_KEYPAD_LIMIT = "keypad_limit";
    public static final String KEY_LANG = "lang";
    public static final String KEY_MIN = "min";
    public static final String KEY_MIN_LABEL = "min_label";
    public static final String KEY_NUMBER = "number";
    public static final String KEY_PASSIVE = "passive";
    public static final String KEY_PASSIVE_DESC = "passive_desc";
    public static final String KEY_PASSWORD_REMOVE = "password_remove";
    public static final String KEY_PASSWORD_RESET = "password_reset";
    public static final String KEY_PATH = "path";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_RESET = "reset";
    public static final String KEY_RESULT = "result";
    public static final String KEY_SEC = "sec";
    public static final String KEY_SEC_LABEL = "sec_label";
    public static final String KEY_SUB_CONTENT = "sub_content";
    public static final String KEY_TEXT = "text";
    public static final String KEY_TIME = "time";
    public static final String KEY_TIME_GUIDE = "time_guide";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TITLE_BAR = "title_bar";
    public static final String KEY_TYPE = "type";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Base2ndPWViewData() {
        super(null, 1, null);
        put(y.٬ݯح׭٩(576655054), getDisplayLanguage());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getDisplayLanguage() {
        String languageCode = KGSystem.getLanguageCode();
        if (languageCode != null) {
            int hashCode = languageCode.hashCode();
            if (hashCode == -371515458) {
                String str = y.ٲٴݴ״ٰ(1782148128);
                if (languageCode.equals(str)) {
                    return str;
                }
            } else if (hashCode == 3383) {
                String str2 = y.ݮڮֲڭܩ(-628777260);
                if (languageCode.equals(str2)) {
                    return str2;
                }
            } else if (hashCode == 3428) {
                String str3 = y.٬ݯح׭٩(576716582);
                if (languageCode.equals(str3)) {
                    return str3;
                }
            }
        }
        return y.ۮڭڭܬި(862746203);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isResult() {
        String str = (String) get(y.ٲٴݴ״ٰ(1781623144));
        if (str == null) {
            str = "";
        }
        return Intrinsics.areEqual(str, PasswordViewType.RESULT.getValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getResultCode() {
        Integer num = (Integer) get(y.ٴسسݬߨ(1392585418));
        if (num != null) {
            return num.intValue();
        }
        return 9001;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAccessKey() {
        String str = (String) get(y.֬ڱܱײٮ(-1159480759));
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getType() {
        String str = (String) get(y.ٲٴݴ״ٰ(1781623144));
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPhoneNumber() {
        String str = (String) get(y.֬ڱܱײٮ(-1159182271));
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEmailAddress() {
        String str = (String) get(y.ݬֲ֮ܲت(1512124815));
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getExitAction() {
        Map map = (Map) get(y.ٴسسݬߨ(1393043586));
        String str = (String) (map != null ? map.get(y.֬ڱܱײٮ(-1159583711)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getTitleBar() {
        Object obj = get(y.ݮڮֲڭܩ(-628349740));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getTitle() {
        Object obj = get(y.ٲٴݴ״ٰ(1781623336));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getViewContent() {
        Object obj = get(y.֬ڱܱײٮ(-1159406207));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getSubContent() {
        Object obj = get(y.ݮڮֲڭܩ(-628349956));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getTimeGuide() {
        Object obj = get(y.٬ݯح׭٩(576446422));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getMin() {
        Object obj = get(y.٬ݯح׭٩(576446422));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Number number = (Number) ((Map) obj).get(y.ٴسسݬߨ(1393038362));
        if (number != null) {
            return number.intValue();
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getSec() {
        Object obj = get(y.٬ݯح׭٩(576446422));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Number number = (Number) ((Map) obj).get(y.٬ݯح׭٩(576443166));
        if (number != null) {
            return number.intValue();
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMinLabel() {
        Object obj = get(y.٬ݯح׭٩(576446422));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        String str = (String) ((Map) obj).get(y.ٴسسݬߨ(1393038386));
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSecLabel() {
        Object obj = get(y.٬ݯح׭٩(576446422));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        String str = (String) ((Map) obj).get(y.ٲٴݴ״ٰ(1782384704));
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getInput() {
        Object obj = get(y.֬ڱܱײٮ(-1159182839));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getInputConfirm() {
        Object obj = get(y.ݮڮֲڭܩ(-628347076));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getHasPassive() {
        Boolean bool = (Boolean) get(y.ݮڮֲڭܩ(-628347236));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getPassiveDesc() {
        Object obj = get(y.֬ڱܱײٮ(-1159182287));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getPassive() {
        Object obj = get(y.دײܮڳܯ(2051086005));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getDetail() {
        Object obj = get(y.دײܮڳܯ(2051087269));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getResetButtonText() {
        Object obj = get(y.٬ݯح׭٩(576442950));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getResetAction() {
        Map map = (Map) get(y.٬ݯح׭٩(576442950));
        String str = (String) (map != null ? map.get(y.֬ڱܱײٮ(-1159583711)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getCancelButtonText() {
        Object obj = get(y.֬ڱܱײٮ(-1158781631));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCancelAction() {
        Map map = (Map) get(y.֬ڱܱײٮ(-1158781631));
        String str = (String) (map != null ? map.get(y.֬ڱܱײٮ(-1159583711)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getConfirmButtonText() {
        Object obj = get(y.ۮڭڭܬި(862392731));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getConfirmAction() {
        Map map = (Map) get(y.ۮڭڭܬި(862392731));
        String str = (String) (map != null ? map.get(y.֬ڱܱײٮ(-1159583711)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getResetPasswordButtonText() {
        Object obj = get(y.ݮڮֲڭܩ(-628350212));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getResetPasswordAction() {
        Map map = (Map) get(y.ݮڮֲڭܩ(-628350212));
        String str = (String) (map != null ? map.get(y.֬ڱܱײٮ(-1159583711)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SpannableStringBuilder getRemovePasswordButtonText() {
        Object obj = get(y.ۮڭڭܬި(862747867));
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782382744));
        Object obj2 = ((Map) obj).get(y.ٲٴݴ״ٰ(1782384304));
        Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
        return StyleTextKt.getString((JSONArray) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRemovePasswordAction() {
        Map map = (Map) get(y.ۮڭڭܬި(862747867));
        String str = (String) (map != null ? map.get(y.֬ڱܱײٮ(-1159583711)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTimeLimit() {
        Map map = (Map) get(y.ٴسسݬߨ(1393037386));
        Number number = (Number) (map != null ? map.get(y.٬ݯح׭٩(575818342)) : null);
        if (number != null) {
            return number.intValue();
        }
        return 5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTimeLimitAction() {
        Map map = (Map) get(y.ٴسسݬߨ(1393037386));
        String str = (String) (map != null ? map.get(y.֬ڱܱײٮ(-1159583711)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getFirstVirtualKeypadImage() {
        JSONArray jSONArray = (JSONArray) get(y.ݬֲ֮ܲت(1512124695));
        Map map = (Map) (jSONArray != null ? jSONArray.get(0) : null);
        String str = (String) (map != null ? map.get(y.دײܮڳܯ(2051509965)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getFirstVirtualKeypadKeys() {
        JSONArray jSONArray = (JSONArray) get(y.ݬֲ֮ܲت(1512124695));
        Map map = (Map) (jSONArray != null ? jSONArray.get(0) : null);
        String str = (String) (map != null ? map.get(y.٬ݯح׭٩(575939726)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSecondVirtualKeypadImage() {
        JSONArray jSONArray = (JSONArray) get(y.ݬֲ֮ܲت(1512124695));
        Map map = (Map) (jSONArray != null ? jSONArray.get(1) : null);
        String str = (String) (map != null ? map.get(y.دײܮڳܯ(2051509965)) : null);
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSecondVirtualKeypadKeys() {
        JSONArray jSONArray = (JSONArray) get(y.ݬֲ֮ܲت(1512124695));
        Map map = (Map) (jSONArray != null ? jSONArray.get(1) : null);
        String str = (String) (map != null ? map.get(y.٬ݯح׭٩(575939726)) : null);
        return str == null ? "" : str;
    }
}
