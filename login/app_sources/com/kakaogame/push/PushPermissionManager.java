package com.kakaogame.push;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.drive.DriveFile;
import com.kakaogame.C2382R;
import com.kakaogame.KGResult;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.p029ui.PermissionManager;
import com.kakaogame.util.DeviceUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushPermissionManager.kt */
@Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/push/PushPermissionManager;", "", "()V", "PUSH_PERMISSION", "", "enablePush", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "goToNotificationSettings", "", "isAndroid13", "", "requestPushPermission", "goToSettings", "showPopup", "msgResId", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PushPermissionManager {
    public static final PushPermissionManager INSTANCE = new PushPermissionManager();
    private static final String PUSH_PERMISSION = y.ۮڭڭܬި(862758963);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PushPermissionManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isAndroid13(Activity activity) {
        return Build.VERSION.SDK_INT >= 33 && activity.getApplicationContext().getApplicationInfo().targetSdkVersion >= 33;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> requestPushPermission(Activity activity, boolean goToSettings) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (!isAndroid13(activity)) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        String str = PUSH_PERMISSION;
        KGResult<Boolean> checkPermission = PermissionManager.checkPermission(activity, str);
        if (!checkPermission.isSuccess()) {
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.DEVICE_NOTIFICATION_SETTING_OFF);
        }
        Boolean content = checkPermission.getContent();
        Intrinsics.checkNotNull(content);
        if (content.booleanValue()) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        KGResult<Boolean> requestPermissionWithDeniedCheck = PermissionManager.INSTANCE.requestPermissionWithDeniedCheck(activity, str);
        if (!requestPermissionWithDeniedCheck.isSuccess()) {
            if (goToSettings && requestPermissionWithDeniedCheck.getCode() == 4002) {
                showPopup(activity, C2382R.string.zinny_sdk_push_setting_warning);
            }
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.DEVICE_NOTIFICATION_SETTING_OFF);
        }
        Boolean content2 = requestPermissionWithDeniedCheck.getContent();
        Intrinsics.checkNotNull(content2);
        if (content2.booleanValue()) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.DEVICE_NOTIFICATION_SETTING_OFF);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> enablePush(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        if (!DeviceUtil.isNotificationEnable(applicationContext, y.ݮڮֲڭܩ(-628621444))) {
            if (isAndroid13(activity)) {
                return KGResult.INSTANCE.getResult(requestPushPermission(activity, true));
            }
            showPopup(activity, C2382R.string.zinny_sdk_push_setting_warning);
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.DEVICE_NOTIFICATION_SETTING_OFF);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showPopup(final Activity activity, int msgResId) {
        if (msgResId == -1) {
            return;
        }
        DialogManager.Settings settings = new DialogManager.Settings(null, null, null, Integer.valueOf(msgResId), null, null, null, null, false, null, null, null, null, 8183, null);
        settings.setPositiveButton(C2382R.string.zinny_sdk_push_setting_button_go, new DialogInterface.OnClickListener() { // from class: com.kakaogame.push.PushPermissionManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PushPermissionManager.showPopup$lambda$0(activity, dialogInterface, i);
            }
        });
        settings.setNegativeButton(C2382R.string.zinny_sdk_common_button_cancel, new DialogInterface.OnClickListener() { // from class: com.kakaogame.push.PushPermissionManager$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        DialogManager.INSTANCE.showAlertDialog(activity, settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPopup$lambda$0(Activity activity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        INSTANCE.goToNotificationSettings(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void goToNotificationSettings(Activity activity) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = new Intent(y.ٴسسݬߨ(1393082978)).addFlags(DriveFile.MODE_READ_ONLY).putExtra(y.֬ڱܱײٮ(-1159160159), activity.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent, y.֬ڱܱײٮ(-1159167615));
        } else {
            intent = new Intent(y.ٴسسݬߨ(1393089898), Uri.fromParts(y.ݬֲ֮ܲت(1512932399), activity.getPackageName(), null));
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        activity.startActivity(intent);
    }
}
