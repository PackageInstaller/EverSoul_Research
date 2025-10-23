package com.kakaogame;

import android.app.Activity;
import android.text.TextUtils;
import com.kakaogame.core.CoreManager;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* compiled from: KGCustomUI.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/KGCustomUI;", "", "()V", "ACTION_CLOSE", "", "registerShowCustomAlertHandler", "", "type", "Lcom/kakaogame/KGCustomUI$KGCustomAlertType;", "handler", "Lcom/kakaogame/KGCustomUI$KGShowCustomAlertHandler;", "KGCustomAlert", "KGCustomAlertCallback", "KGCustomAlertType", "KGShowCustomAlertHandler", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGCustomUI {
    public static final String ACTION_CLOSE = "customUI_close";
    public static final KGCustomUI INSTANCE = new KGCustomUI();

    /* compiled from: KGCustomUI.kt */
    @Metadata(m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/KGCustomUI$KGCustomAlertCallback;", "", "onClick", "", "action", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface KGCustomAlertCallback {
        void onClick(String action);
    }

    /* compiled from: KGCustomUI.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/KGCustomUI$KGShowCustomAlertHandler;", "", "onShow", "", "activity", "Landroid/app/Activity;", "alert", "Lcom/kakaogame/KGCustomUI$KGCustomAlert;", "callback", "Lcom/kakaogame/KGCustomUI$KGCustomAlertCallback;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface KGShowCustomAlertHandler {
        void onShow(Activity activity, KGCustomAlert alert, KGCustomAlertCallback callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGCustomUI() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void registerShowCustomAlertHandler(KGCustomAlertType type, KGShowCustomAlertHandler handler) {
        CoreManager.INSTANCE.getInstance().registerShowCustomAlertHandler(type, handler);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGCustomUI.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/KGCustomUI$KGCustomAlertType;", "", "(Ljava/lang/String;I)V", "MAINTENANCE", "NOTICE", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGCustomAlertType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGCustomAlertType[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final KGCustomAlertType MAINTENANCE = new KGCustomAlertType(y.ٲٴݴ״ٰ(1781805712), 0);
        public static final KGCustomAlertType NOTICE = new KGCustomAlertType(y.دײܮڳܯ(2051551133), 1);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGCustomAlertType[] $values() {
            return new KGCustomAlertType[]{MAINTENANCE, NOTICE};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGCustomAlertType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGCustomAlertType valueOf(String str) {
            return (KGCustomAlertType) Enum.valueOf(KGCustomAlertType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGCustomAlertType[] values() {
            return (KGCustomAlertType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGCustomAlertType(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGCustomAlertType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        /* compiled from: KGCustomUI.kt */
        @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGCustomUI$KGCustomAlertType$Companion;", "", "()V", "getType", "Lcom/kakaogame/KGCustomUI$KGCustomAlertType;", "name", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGCustomAlertType getType(String name) {
                if (StringsKt.equals(name, y.ٲٴݴ״ٰ(1781805712), true)) {
                    return KGCustomAlertType.MAINTENANCE;
                }
                return KGCustomAlertType.NOTICE;
            }
        }
    }

    /* compiled from: KGCustomUI.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BM\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/KGCustomUI$KGCustomAlert;", "Lcom/kakaogame/KGObject;", "type", "Lcom/kakaogame/KGCustomUI$KGCustomAlertType;", "title", "", "message", "linkBtnLabel", "linkBtnAction", "closeBtnLabel", "closeBtnAction", "(Lcom/kakaogame/KGCustomUI$KGCustomAlertType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", KGCustomAlert.KEY_CLOSE_BTN_ACTION, "getCloseAction", "()Ljava/lang/String;", KGCustomAlert.KEY_CLOSE_BTN_LABEL, "getCloseLabel", KGCustomAlert.KEY_LINK_BTN_ACTION, "getLinkAction", KGCustomAlert.KEY_LINK_BTN_LABEL, "getLinkLabel", "getMessage", "getTitle", "getType", "()Lcom/kakaogame/KGCustomUI$KGCustomAlertType;", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGCustomAlert extends KGObject {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String KEY_ALERT_TYPE = "type";
        private static final String KEY_CLOSE_BTN_ACTION = "closeAction";
        private static final String KEY_CLOSE_BTN_LABEL = "closeLabel";
        private static final String KEY_LINK_BTN_ACTION = "linkAction";
        private static final String KEY_LINK_BTN_LABEL = "linkLabel";
        private static final String KEY_MESSAGE = "message";
        private static final String KEY_TITLE = "title";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ KGCustomAlert(KGCustomAlertType kGCustomAlertType, String str, String str2, String str3, String str4, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
            this(kGCustomAlertType, str, str2, str3, str4, str5, str6);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static final KGCustomAlert makeAlert(KGCustomAlertType kGCustomAlertType, String str, String str2, String str3, String str4, String str5, String str6) {
            return INSTANCE.makeAlert(kGCustomAlertType, str, str2, str3, str4, str5, str6);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGCustomAlert(KGCustomAlertType kGCustomAlertType, String str, String str2, String str3, String str4, String str5, String str6) {
            super(null, 1, null);
            if (kGCustomAlertType != null) {
                put(y.ٲٴݴ״ٰ(1781623144), kGCustomAlertType.name());
            }
            if (!TextUtils.isEmpty(str)) {
                put("title", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                put("message", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                put(KEY_LINK_BTN_LABEL, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                put(KEY_LINK_BTN_ACTION, str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                put(KEY_CLOSE_BTN_LABEL, str5);
            }
            if (TextUtils.isEmpty(str6)) {
                return;
            }
            put(KEY_CLOSE_BTN_ACTION, str6);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGCustomAlertType getType() {
            String str = y.ٲٴݴ״ٰ(1781623144);
            if (containsKey(str)) {
                return KGCustomAlertType.INSTANCE.getType((String) get(str));
            }
            return KGCustomAlertType.NOTICE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getTitle() {
            String str = y.ٲٴݴ״ٰ(1781623336);
            return containsKey(str) ? (String) get(str) : "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getMessage() {
            String str = y.دײܮڳܯ(2051551053);
            return containsKey(str) ? (String) get(str) : "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLinkLabel() {
            String str = y.ݮڮֲڭܩ(-628811596);
            return containsKey(str) ? (String) get(str) : "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLinkAction() {
            String str = y.֬ڱܱײٮ(-1159630407);
            return containsKey(str) ? (String) get(str) : "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCloseLabel() {
            String str = y.ۮڭڭܬި(862274835);
            return containsKey(str) ? (String) get(str) : "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCloseAction() {
            String str = y.ۮڭڭܬި(862304907);
            return containsKey(str) ? (String) get(str) : "";
        }

        /* compiled from: KGCustomUI.kt */
        @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/KGCustomUI$KGCustomAlert$Companion;", "", "()V", "KEY_ALERT_TYPE", "", "KEY_CLOSE_BTN_ACTION", "KEY_CLOSE_BTN_LABEL", "KEY_LINK_BTN_ACTION", "KEY_LINK_BTN_LABEL", "KEY_MESSAGE", "KEY_TITLE", "makeAlert", "Lcom/kakaogame/KGCustomUI$KGCustomAlert;", "type", "Lcom/kakaogame/KGCustomUI$KGCustomAlertType;", "title", "message", "linkBtnLabel", "linkBtnAction", "closeBtnLabel", "closeBtnAction", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @JvmStatic
            public final KGCustomAlert makeAlert(KGCustomAlertType type, String title, String message, String linkBtnLabel, String linkBtnAction, String closeBtnLabel, String closeBtnAction) {
                return new KGCustomAlert(type, title, message, linkBtnLabel, linkBtnAction, closeBtnLabel, closeBtnAction, null);
            }
        }
    }
}
