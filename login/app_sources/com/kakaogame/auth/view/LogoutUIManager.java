package com.kakaogame.auth.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.util.MutexLock;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: LogoutUIManager.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/auth/view/LogoutUIManager;", "", "()V", "TAG", "", "showLogoutPopup", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "idpCode", "requestType", "Lcom/kakaogame/auth/view/LogoutUIManager$RequestType;", "LogoutPopupDialog", "RequestType", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LogoutUIManager {
    public static final LogoutUIManager INSTANCE = new LogoutUIManager();
    private static final String TAG = "LogoutUIManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LogoutUIManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> showLogoutPopup(Activity activity, String idpCode, RequestType requestType) {
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        Intrinsics.checkNotNullParameter(requestType, y.ۮڭڭܬި(862479371));
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862486395) + idpCode;
        String str2 = y.ݮڮֲڭܩ(-628612716);
        logger.m699d(str2, str);
        try {
            MutexLock createLock = MutexLock.INSTANCE.createLock();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LogoutUIManager$showLogoutPopup$1(activity, idpCode, requestType, createLock, null), 3, null);
            MutexLock.lock$default(createLock, 0L, 1, null);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            return (KGResult) content;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, y.ۮڭڭܬި(862486483) + e, e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: LogoutUIManager.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/auth/view/LogoutUIManager$RequestType;", "", "(Ljava/lang/String;I)V", "LOGOUT", "UNREGISTER", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class RequestType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RequestType[] $VALUES;
        public static final RequestType LOGOUT = new RequestType(y.ٲٴݴ״ٰ(1782123272), 0);
        public static final RequestType UNREGISTER = new RequestType(y.ݬֲ֮ܲت(1512390599), 1);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ RequestType[] $values() {
            return new RequestType[]{LOGOUT, UNREGISTER};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<RequestType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static RequestType valueOf(String str) {
            return (RequestType) Enum.valueOf(RequestType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static RequestType[] values() {
            return (RequestType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private RequestType(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            RequestType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LogoutUIManager.kt */
    @Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\t¢\u0006\u0002\u0010\fR\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/auth/view/LogoutUIManager$LogoutPopupDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "idpCode", "", "requestType", "Lcom/kakaogame/auth/view/LogoutUIManager$RequestType;", "uiLock", "Lcom/kakaogame/util/MutexLock;", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/kakaogame/auth/view/LogoutUIManager$RequestType;Lcom/kakaogame/util/MutexLock;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    static final class LogoutPopupDialog extends Dialog {
        private final MutexLock<KGResult<Void>> uiLock;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public LogoutPopupDialog(android.app.Activity r8, java.lang.String r9, com.kakaogame.auth.view.LogoutUIManager.RequestType r10, com.kakaogame.util.MutexLock<com.kakaogame.KGResult<java.lang.Void>> r11) {
            /*
                Method dump skipped, instructions count: 506
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.auth.view.LogoutUIManager.LogoutPopupDialog.<init>(android.app.Activity, java.lang.String, com.kakaogame.auth.view.LogoutUIManager$RequestType, com.kakaogame.util.MutexLock):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final boolean _init_$lambda$0(LogoutPopupDialog this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            this$0.uiLock.setContent(KGResult.INSTANCE.getResult(9001));
            this$0.uiLock.unlock();
            this$0.dismiss();
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static final void lambda$3$lambda$1(LogoutPopupDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.uiLock.setContent(KGResult.INSTANCE.getSuccessResult());
            this$0.uiLock.unlock();
            this$0.dismiss();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static final void lambda$3$lambda$2(LogoutPopupDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.uiLock.setContent(KGResult.INSTANCE.getResult(9001));
            this$0.uiLock.unlock();
            this$0.dismiss();
        }
    }
}
