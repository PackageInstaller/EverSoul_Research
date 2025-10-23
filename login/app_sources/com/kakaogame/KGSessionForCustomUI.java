package com.kakaogame;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGSessionForCustomUI.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J.\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J.\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J.\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J.\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J.\u0010\u0017\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J$\u0010\u0018\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J\u0018\u0010\u0018\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007J$\u0010\u0019\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/KGSessionForCustomUI;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "chooseIdpAccount", "", "activity", "Landroid/app/Activity;", "idpChoiceMode", "Lcom/kakaogame/KGSessionForCustomUI$KGIdpChoiceMode;", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "connect", "idpCode", "Lcom/kakaogame/KGIdpProfile$KGIdpCode;", "connectIdpAccount", "connectKakao", "authType", "Lcom/kakaogame/KGKakaoAuthType;", FirebaseAnalytics.Event.LOGIN, "loginKakao", "logout", "unregister", "KGIdpChoiceMode", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGSessionForCustomUI {
    private static final String CLASS_NAME_KEY = "KGSessionForCustomUI";
    public static final KGSessionForCustomUI INSTANCE = new KGSessionForCustomUI();
    private static final String TAG = "KGSessionForCustomUI";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGSessionForCustomUI() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void login(Activity activity, KGIdpProfile.KGIdpCode idpCode, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512712447);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.֬ڱܱײٮ(-1159504239));
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "login: Invalid Parameter! 'callback' is null.");
            return;
        }
        if (activity != null && !activity.isFinishing() && idpCode != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$login$1(activity, idpCode, callback, firebaseTrace, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.ݮڮֲڭܩ(-628664380));
        callback.onResult(result);
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void connect(Activity activity, KGIdpProfile.KGIdpCode idpCode, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392709242);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.ݮڮֲڭܩ(-628671956));
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "connect: Invalid Parameter! 'callback' is null.");
            return;
        }
        if (activity != null && !activity.isFinishing() && idpCode != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$connect$1(activity, idpCode, callback, firebaseTrace, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.ݮڮֲڭܩ(-628665340));
        callback.onResult(result);
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loginKakao(Activity activity, KGKakaoAuthType authType, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159520223);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.֬ڱܱײٮ(-1159520079));
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "login: Invalid Parameter! 'callback' is null.");
            return;
        }
        if (activity != null && !activity.isFinishing()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$loginKakao$1(activity, authType, callback, firebaseTrace, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.ݮڮֲڭܩ(-628665340));
        callback.onResult(result);
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void connectKakao(Activity activity, KGKakaoAuthType authType, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051694805);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.٬ݯح׭٩(575710998));
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "connect: Invalid Parameter! 'callback' is null.");
            return;
        }
        if (activity != null && !activity.isFinishing()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$connectKakao$1(activity, authType, callback, firebaseTrace, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        callback.onResult(result);
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void connectIdpAccount(Activity activity, KGIdpProfile.KGIdpCode idpCode, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392730426);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.دײܮڳܯ(2051694717));
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "connectIdpAccount: Invalid Parameter! 'callback' is null.");
            return;
        }
        if (activity != null && !activity.isFinishing() && idpCode != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$connectIdpAccount$1(activity, idpCode, callback, firebaseTrace, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.ݮڮֲڭܩ(-628665340));
        callback.onResult(result);
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void chooseIdpAccount(Activity activity, KGIdpChoiceMode idpChoiceMode, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1781955312);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.ݬֲ֮ܲت(1512721695));
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "chooseIdpAccount: Invalid Parameter! 'callback' is null.");
            return;
        }
        if (activity != null && !activity.isFinishing() && idpChoiceMode != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$chooseIdpAccount$1(activity, idpChoiceMode, callback, firebaseTrace, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.ۮڭڭܬި(862391843));
        callback.onResult(result);
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void logout(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862418763);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "logout: Invalid Parameter! 'callback' is null.");
        } else if (activity != null && !activity.isFinishing()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$logout$1(activity, callback, null), 3, null);
        } else {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void logout(KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862418763);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        if (callback != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$logout$2(callback, null), 3, null);
        } else {
            Logger.INSTANCE.m701e(str2, y.֬ڱܱײٮ(-1159511055));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void unregister(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575723454);
        String str2 = y.ٲٴݴ״ٰ(1781953896);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "unregister: Invalid Parameter! 'callback' is null.");
        } else if (activity != null && !activity.isFinishing()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSessionForCustomUI$unregister$1(activity, callback, null), 3, null);
        } else {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575)));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGSessionForCustomUI.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/KGSessionForCustomUI$KGIdpChoiceMode;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "CurrentAccount", "AlreadyConnectedAccount", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGIdpChoiceMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGIdpChoiceMode[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String code;
        public static final KGIdpChoiceMode CurrentAccount = new KGIdpChoiceMode(y.ݬֲ֮ܲت(1512719607), 0, y.ۮڭڭܬި(862390235));
        public static final KGIdpChoiceMode AlreadyConnectedAccount = new KGIdpChoiceMode(y.֬ڱܱײٮ(-1159514743), 1, y.دײܮڳܯ(2051698077));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGIdpChoiceMode[] $values() {
            return new KGIdpChoiceMode[]{CurrentAccount, AlreadyConnectedAccount};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGIdpChoiceMode> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGIdpChoiceMode valueOf(String str) {
            return (KGIdpChoiceMode) Enum.valueOf(KGIdpChoiceMode.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGIdpChoiceMode[] values() {
            return (KGIdpChoiceMode[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGIdpChoiceMode(String str, int i, String str2) {
            this.code = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCode() {
            return this.code;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGIdpChoiceMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        /* compiled from: KGSessionForCustomUI.kt */
        @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGSessionForCustomUI$KGIdpChoiceMode$Companion;", "", "()V", "get", "Lcom/kakaogame/KGSessionForCustomUI$KGIdpChoiceMode;", "name", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGIdpChoiceMode get(String name) {
                if (Intrinsics.areEqual(name, KGIdpChoiceMode.CurrentAccount.getCode())) {
                    return KGIdpChoiceMode.CurrentAccount;
                }
                if (Intrinsics.areEqual(name, KGIdpChoiceMode.AlreadyConnectedAccount.getCode())) {
                    return KGIdpChoiceMode.AlreadyConnectedAccount;
                }
                return null;
            }
        }
    }
}
