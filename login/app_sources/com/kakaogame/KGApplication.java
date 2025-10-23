package com.kakaogame;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.p029ui.ImageDownloader;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGApplication.kt */
@Metadata(m838d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003()*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004J*\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J,\u0010\u0013\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00042\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0016H\u0007J4\u0010\u0017\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0016H\u0007J8\u0010\u001a\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u0016H\u0007J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J,\u0010\u001f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00042\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0016H\u0007J4\u0010 \u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0016H\u0007JV\u0010!\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010%2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0016H\u0007JL\u0010!\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0006\u0010&\u001a\u00020'2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\u0005\u0010\b¨\u0006+"}, m839d2 = {"Lcom/kakaogame/KGApplication;", "", "()V", "TAG", "", "isEvaluationState", "", "isEvaluationState$annotations", "()Z", "addShortcut", "", "activity", "Landroid/app/Activity;", "scheme", "shortcutName", "imageUri", "addShortcutV26", "theBitmap", "Landroid/graphics/Bitmap;", "checkPermission", "permission", "callback", "Lcom/kakaogame/KGResultCallback;", "checkPermissions", "permissions", "", "loadGameServerMaintenance", "showUI", ServerConstants.SERVER_ID, "Lcom/kakaogame/KGApplication$KGGameServerMaintenanceResponse;", "requestMarketReviewPopup", "requestPermission", "requestPermissions", "requestPermissionsWithDescriptionPopup", "optionalPermissions", "optionalGuarantee", "theme", "Lcom/kakaogame/KGApplication$KGPermissionTheme;", "iconResourceId", "", "KGGameServerMaintenanceResponse", "KGPermissionTheme", "KGThemeColor", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGApplication {
    public static final KGApplication INSTANCE = new KGApplication();
    private static final String TAG = "KGApplication";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isEvaluationState$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGApplication() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isEvaluationState() {
        return StringsKt.equals(y.ٲٴݴ״ٰ(1781853632), InfodeskHelper.INSTANCE.getValue(y.٬ݯح׭٩(575813246), ""), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void checkPermission(Activity activity, String permission, KGResultCallback<Boolean> callback) {
        Intrinsics.checkNotNullParameter(permission, y.֬ڱܱײٮ(-1159616063));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1781852744) + permission;
        String str2 = y.ݬֲ֮ܲت(1512625815);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ݬֲ֮ܲت(1512627615));
        }
        if (activity == null) {
            KGResult<Boolean> result = KGResult.INSTANCE.getResult(4000, "'activity' is null.", false);
            if (callback != null) {
                callback.onResult(result);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(permission)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGApplication$checkPermission$1(activity, permission, callback, null), 3, null);
            return;
        }
        KGResult<Boolean> result2 = KGResult.INSTANCE.getResult(4000, "'permission' is null.", false);
        if (callback != null) {
            callback.onResult(result2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void checkPermissions(Activity activity, List<String> permissions, KGResultCallback<Boolean> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392637842) + permissions;
        String str2 = y.ݬֲ֮ܲت(1512625815);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ۮڭڭܬި(862296395));
        }
        if (activity == null) {
            KGResult<Boolean> result = KGResult.INSTANCE.getResult(4000, "'activity' is null.", false);
            if (callback != null) {
                callback.onResult(result);
                return;
            }
            return;
        }
        List<String> list = permissions;
        if (!(list == null || list.isEmpty())) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGApplication$checkPermissions$1(activity, permissions, callback, null), 3, null);
            return;
        }
        KGResult<Boolean> result2 = KGResult.INSTANCE.getResult(4000, "'permissions' is empty.", false);
        if (callback != null) {
            callback.onResult(result2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestPermission(Activity activity, String permission, KGResultCallback<Boolean> callback) {
        Intrinsics.checkNotNullParameter(permission, y.֬ڱܱײٮ(-1159616063));
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575802734) + permission;
        String str2 = y.ݬֲ֮ܲت(1512625815);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.֬ڱܱײٮ(-1159620823));
        }
        if (activity == null) {
            KGResult<Boolean> result = KGResult.INSTANCE.getResult(4000, "'activity' is null.", false);
            if (callback != null) {
                callback.onResult(result);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(permission)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGApplication$requestPermission$1(activity, permission, callback, null), 3, null);
            return;
        }
        KGResult<Boolean> result2 = KGResult.INSTANCE.getResult(4000, "'permission' is null.", false);
        if (callback != null) {
            callback.onResult(result2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestPermissions(Activity activity, List<String> permissions, KGResultCallback<Boolean> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862298843) + permissions;
        String str2 = y.ݬֲ֮ܲت(1512625815);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ݬֲ֮ܲت(1512632119));
        }
        if (activity == null) {
            KGResult<Boolean> result = KGResult.INSTANCE.getResult(4000, "'activity' is null.", false);
            if (callback != null) {
                callback.onResult(result);
                return;
            }
            return;
        }
        List<String> list = permissions;
        if (!(list == null || list.isEmpty())) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGApplication$requestPermissions$1(activity, permissions, callback, null), 3, null);
            return;
        }
        KGResult<Boolean> result2 = KGResult.INSTANCE.getResult(4000, "'permissions' is empty.", false);
        if (callback != null) {
            callback.onResult(result2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestPermissionsWithDescriptionPopup(Activity activity, List<String> permissions, List<String> optionalPermissions, int iconResourceId, KGResultCallback<Boolean> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392625362) + activity + y.֬ڱܱײٮ(-1159619887) + permissions + y.֬ڱܱײٮ(-1159619239) + optionalPermissions;
        String str2 = y.ݬֲ֮ܲت(1512625815);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.֬ڱܱײٮ(-1159619095));
        }
        if (activity == null) {
            KGResult<Boolean> result = KGResult.INSTANCE.getResult(4000, "Activiti is null.");
            if (callback != null) {
                callback.onResult(result);
                return;
            }
            return;
        }
        List<String> list = permissions;
        if (list == null || list.isEmpty()) {
            List<String> list2 = optionalPermissions;
            if (list2 == null || list2.isEmpty()) {
                KGResult<Boolean> result2 = KGResult.INSTANCE.getResult(4000, "Required permission lists are empty.");
                if (callback != null) {
                    callback.onResult(result2);
                    return;
                }
                return;
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGApplication$requestPermissionsWithDescriptionPopup$1(iconResourceId, activity, permissions, optionalPermissions, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestPermissionsWithDescriptionPopup(Activity activity, List<String> permissions, List<String> optionalPermissions, boolean optionalGuarantee, KGPermissionTheme theme, KGResultCallback<Boolean> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512630479) + activity + y.֬ڱܱײٮ(-1159619887) + permissions + y.֬ڱܱײٮ(-1159619239) + optionalPermissions;
        String str2 = y.ݬֲ֮ܲت(1512625815);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ٲٴݴ״ٰ(1781842888));
        }
        if (activity == null) {
            KGResult<Boolean> result = KGResult.INSTANCE.getResult(4000, y.ۮڭڭܬި(862303923));
            if (callback != null) {
                callback.onResult(result);
                return;
            }
            return;
        }
        List<String> list = permissions;
        if (list == null || list.isEmpty()) {
            List<String> list2 = optionalPermissions;
            if (list2 == null || list2.isEmpty()) {
                KGResult<Boolean> result2 = KGResult.INSTANCE.getResult(4000, y.ݬֲ֮ܲت(1512633223));
                if (callback != null) {
                    callback.onResult(result2);
                    return;
                }
                return;
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGApplication$requestPermissionsWithDescriptionPopup$2(theme, activity, permissions, optionalPermissions, optionalGuarantee, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestMarketReviewPopup(final Activity activity) {
        Intrinsics.checkNotNull(activity);
        final ReviewManager create = ReviewManagerFactory.create(activity);
        Intrinsics.checkNotNullExpressionValue(create, y.ݮڮֲڭܩ(-628754148));
        Task<ReviewInfo> requestReviewFlow = create.requestReviewFlow();
        Intrinsics.checkNotNullExpressionValue(requestReviewFlow, y.٬ݯح׭٩(575801734));
        requestReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: com.kakaogame.KGApplication$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                KGApplication.requestMarketReviewPopup$lambda$1(ReviewManager.this, activity, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void requestMarketReviewPopup$lambda$1(ReviewManager reviewManager, Activity activity, Task task) {
        Intrinsics.checkNotNullParameter(reviewManager, y.٬ݯح׭٩(575801926));
        Intrinsics.checkNotNullParameter(task, y.ݮڮֲڭܩ(-628753772));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159621695);
        String str2 = y.ݬֲ֮ܲت(1512625815);
        logger.m699d(str2, str);
        if (task.isSuccessful()) {
            ReviewInfo reviewInfo = (ReviewInfo) task.getResult();
            Intrinsics.checkNotNull(reviewInfo);
            Task<Void> launchReviewFlow = reviewManager.launchReviewFlow(activity, reviewInfo);
            Intrinsics.checkNotNullExpressionValue(launchReviewFlow, "launchReviewFlow(...)");
            launchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: com.kakaogame.KGApplication$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    KGApplication.requestMarketReviewPopup$lambda$1$lambda$0(task2);
                }
            });
            return;
        }
        ReviewException reviewException = (ReviewException) task.getException();
        Intrinsics.checkNotNull(reviewException);
        Logger.INSTANCE.m701e(str2, y.دײܮڳܯ(2051591613) + reviewException.getErrorCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void requestMarketReviewPopup$lambda$1$lambda$0(Task task) {
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512625815), y.֬ڱܱײٮ(-1159621207));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void loadGameServerMaintenance$default(Activity activity, boolean z, String str, KGResultCallback kGResultCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        loadGameServerMaintenance(activity, z, str, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadGameServerMaintenance(Activity activity, boolean showUI, String serverId, KGResultCallback<KGGameServerMaintenanceResponse> callback) {
        if (callback == null) {
            Logger.INSTANCE.m708w(y.ݬֲ֮ܲت(1512625815), y.دײܮڳܯ(2051600709));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGApplication$loadGameServerMaintenance$1(activity, showUI, serverId, callback, null), 3, null);
            return;
        }
        KGResult<KGGameServerMaintenanceResponse> result = KGResult.INSTANCE.getResult(4000, "Activity is null.");
        if (callback != null) {
            callback.onResult(result);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addShortcut(final Activity activity, final String scheme, final String shortcutName, String imageUri) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(scheme, y.ٲٴݴ״ٰ(1781843544));
        Intrinsics.checkNotNullParameter(imageUri, y.ۮڭڭܬި(862302395));
        ImageDownloader.downloadImage(imageUri, new ImageLoadingListener() { // from class: com.kakaogame.KGApplication$addShortcut$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingCancelled(String arg0, View arg1) {
                Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
                Intrinsics.checkNotNullParameter(arg1, "arg1");
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String arg0, View arg1) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String arg0, View arg1, Bitmap theBitmap) {
                if (Build.VERSION.SDK_INT < 26) {
                    Intent intent = new Intent(y.ٲٴݴ״ٰ(1781642640), Uri.parse(scheme));
                    Intent intent2 = new Intent();
                    intent2.putExtra(y.ݬֲ֮ܲت(1512622463), intent);
                    intent2.putExtra("android.intent.extra.shortcut.NAME", shortcutName);
                    Intrinsics.checkNotNull(theBitmap);
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(theBitmap, 144, 144, true);
                    Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
                    intent2.putExtra("android.intent.extra.shortcut.ICON", createScaledBitmap);
                    intent2.putExtra("duplicate", false);
                    intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
                    activity.sendBroadcast(intent2);
                    return;
                }
                KGApplication kGApplication = KGApplication.INSTANCE;
                Activity activity2 = activity;
                String str = scheme;
                String str2 = shortcutName;
                Intrinsics.checkNotNull(theBitmap);
                kGApplication.addShortcutV26(activity2, str, str2, theBitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addShortcutV26(Activity activity, String scheme, String shortcutName, Bitmap theBitmap) {
        ShortcutManager shortcutManager = (ShortcutManager) activity.getSystemService(ShortcutManager.class);
        if (shortcutManager.isRequestPinShortcutSupported()) {
            Activity activity2 = activity;
            ShortcutInfo.Builder icon = new ShortcutInfo.Builder(activity2, shortcutName).setIcon(Icon.createWithBitmap(theBitmap));
            Intrinsics.checkNotNull(shortcutName);
            String str = shortcutName;
            ShortcutInfo build = icon.setShortLabel(str).setLongLabel(str).setIntent(new Intent(y.ٲٴݴ״ٰ(1781642640), Uri.parse(scheme))).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(activity2, 0, shortcutManager.createShortcutResultIntent(build), 201326592).getIntentSender());
        }
    }

    /* compiled from: KGApplication.kt */
    @Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u001f\b\u0016\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u0007\b\u0014¢\u0006\u0002\u0010\u0007B\u000f\b\u0014\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000e¨\u0006 "}, m839d2 = {"Lcom/kakaogame/KGApplication$KGPermissionTheme;", "Lcom/kakaogame/KGObject;", "content", "", "", "", "(Ljava/util/Map;)V", "()V", TypedValues.Custom.S_COLOR, "Lcom/kakaogame/KGApplication$KGThemeColor;", "(Lcom/kakaogame/KGApplication$KGThemeColor;)V", KGPermissionTheme.KEY_BACKGROUND_COLOR, "", "getBackgroundColor", "()I", "backgroundResource", "Landroid/graphics/drawable/Drawable;", "getBackgroundResource", "()Landroid/graphics/drawable/Drawable;", KGPermissionTheme.KEY_CONFIRM_TEXT_COLOR, "getConfirmTextColor", KGPermissionTheme.KEY_CONTENT_TEXT_COLOR, "getContentTextColor", "iconResource", "getIconResource", KGPermissionTheme.KEY_THEME_COLOR, "getThemeColor", "()Lcom/kakaogame/KGApplication$KGThemeColor;", KGPermissionTheme.KEY_TITLE_TEXT_COLOR, "getTitleTextColor", "Builder", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGPermissionTheme extends KGObject {
        private static final String KEY_BACKGROUND_COLOR = "backgroundColor";
        private static final String KEY_BACKGROUND_RESOURCE_ID = "backgroundResourceId";
        private static final String KEY_CONFIRM_TEXT_COLOR = "confirmTextColor";
        private static final String KEY_CONTENT_TEXT_COLOR = "contentTextColor";
        private static final String KEY_ICON_RESOURCE_ID = "iconResourceId";
        private static final String KEY_THEME_COLOR = "themeColor";
        private static final String KEY_TITLE_TEXT_COLOR = "titleTextColor";
        private static final String TAG = "KGPermissionTheme";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGPermissionTheme(Map<String, ? extends Object> map) {
            super(TypeIntrinsics.asMutableMap(map));
            String str = (String) get(KEY_THEME_COLOR);
            boolean areEqual = Intrinsics.areEqual(str, KGThemeColor.WHITE.getCode());
            String str2 = y.ۮڭڭܬި(862293491);
            String str3 = y.٬ݯح׭٩(575807846);
            String str4 = y.٬ݯح׭٩(575808158);
            if (areEqual) {
                put(str4, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
                put(str3, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
                put(str2, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
            } else if (Intrinsics.areEqual(str, KGThemeColor.BLACK.getCode()) || Intrinsics.areEqual(str, KGThemeColor.GRAY.getCode())) {
                put(str4, -1);
                put(str3, -1);
                put(str2, -1);
            }
        }

        /* compiled from: KGApplication.kt */
        @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m839d2 = {"Lcom/kakaogame/KGApplication$KGPermissionTheme$Builder;", "", "()V", TypedValues.Custom.S_COLOR, "Lcom/kakaogame/KGApplication$KGThemeColor;", "(Lcom/kakaogame/KGApplication$KGThemeColor;)V", "theme", "Lcom/kakaogame/KGApplication$KGPermissionTheme;", "getTheme", "()Lcom/kakaogame/KGApplication$KGPermissionTheme;", "setTheme", "(Lcom/kakaogame/KGApplication$KGPermissionTheme;)V", "build", "setBackgroundColor", "", "setBackgroundResourceId", "resourceId", "setConfirmTextColor", "setContentTextColor", "setIconResourceId", "setTitleTextColor", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Builder {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private KGPermissionTheme theme;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @JvmStatic
            public static final Builder createTheme(KGThemeColor kGThemeColor) {
                return INSTANCE.createTheme(kGThemeColor);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGPermissionTheme getTheme() {
                return this.theme;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final void setTheme(KGPermissionTheme kGPermissionTheme) {
                Intrinsics.checkNotNullParameter(kGPermissionTheme, y.ٴسسݬߨ(1392633402));
                this.theme = kGPermissionTheme;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder() {
                this.theme = new KGPermissionTheme();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder(KGThemeColor kGThemeColor) {
                Intrinsics.checkNotNullParameter(kGThemeColor, y.ݮڮֲڭܩ(-628760828));
                this.theme = new KGPermissionTheme(kGThemeColor);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setBackgroundResourceId(int resourceId) {
                this.theme.put(y.֬ڱܱײٮ(-1159612119), Integer.valueOf(resourceId));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setIconResourceId(int resourceId) {
                this.theme.put(y.٬ݯح׭٩(575807958), Integer.valueOf(resourceId));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setBackgroundColor(int color) {
                this.theme.put(y.ۮڭڭܬި(862290619), Integer.valueOf(color));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setTitleTextColor(int color) {
                this.theme.put(y.٬ݯح׭٩(575808158), Integer.valueOf(color));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setContentTextColor(int color) {
                this.theme.put(y.٬ݯح׭٩(575807846), Integer.valueOf(color));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setConfirmTextColor(int color) {
                this.theme.put(y.ۮڭڭܬި(862293491), Integer.valueOf(color));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGPermissionTheme build() {
                return this.theme;
            }

            /* compiled from: KGApplication.kt */
            @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGApplication$KGPermissionTheme$Builder$Companion;", "", "()V", "createTheme", "Lcom/kakaogame/KGApplication$KGPermissionTheme$Builder;", TypedValues.Custom.S_COLOR, "Lcom/kakaogame/KGApplication$KGThemeColor;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
            public static final class Companion {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Companion() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public final Builder createTheme() {
                    return new Builder();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @JvmStatic
                public final Builder createTheme(KGThemeColor color) {
                    Intrinsics.checkNotNullParameter(color, y.ݮڮֲڭܩ(-628760828));
                    return new Builder(color);
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGThemeColor getThemeColor() {
            String str = (String) get(y.٬ݯح׭٩(575808286));
            Intrinsics.checkNotNull(str);
            if (str.length() == 0) {
                return KGThemeColor.CUSTOM;
            }
            return KGThemeColor.INSTANCE.get(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Drawable getBackgroundResource() {
            Object obj = get(y.֬ڱܱײٮ(-1159612119));
            if (obj == null) {
                return null;
            }
            if (obj instanceof String) {
                Drawable createFromPath = Drawable.createFromPath((String) obj);
                Logger.INSTANCE.m699d(y.ٴسسݬߨ(1392631810), y.ٲٴݴ״ٰ(1781856408) + obj + y.ٲٴݴ״ٰ(1781856480) + createFromPath);
                return createFromPath;
            }
            if (obj instanceof Integer) {
                return CoreManager.INSTANCE.getInstance().getActivity().getResources().getDrawable(((Number) obj).intValue());
            }
            return (Drawable) obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Drawable getIconResource() {
            Object obj = get(y.٬ݯح׭٩(575807958));
            if (obj == null) {
                return null;
            }
            if (obj instanceof String) {
                return Drawable.createFromPath((String) obj);
            }
            if (obj instanceof Integer) {
                Activity activity = CoreManager.INSTANCE.getInstance().getActivity();
                int intValue = ((Number) obj).intValue();
                if (intValue == -1) {
                    return null;
                }
                return activity.getResources().getDrawable(intValue);
            }
            return (Drawable) obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getBackgroundColor() {
            Object obj = get(y.ۮڭڭܬި(862290619));
            if (obj == null) {
                return Integer.MAX_VALUE;
            }
            if (obj instanceof Long) {
                return (int) ((Number) obj).longValue();
            }
            return ((Integer) obj).intValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTitleTextColor() {
            Object obj = get(y.٬ݯح׭٩(575807846));
            if (obj == null) {
                return Integer.MAX_VALUE;
            }
            if (obj instanceof Long) {
                return (int) ((Number) obj).longValue();
            }
            return ((Integer) obj).intValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getContentTextColor() {
            Object obj = get(y.٬ݯح׭٩(575808158));
            if (obj == null) {
                return Integer.MAX_VALUE;
            }
            if (obj instanceof Long) {
                return (int) ((Number) obj).longValue();
            }
            return ((Integer) obj).intValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getConfirmTextColor() {
            Object obj = get(y.ۮڭڭܬި(862293491));
            if (obj == null) {
                return Integer.MAX_VALUE;
            }
            if (obj instanceof Long) {
                return (int) ((Number) obj).longValue();
            }
            return ((Integer) obj).intValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected KGPermissionTheme() {
            super(null, 1, null);
            put(y.٬ݯح׭٩(575808286), KGThemeColor.CUSTOM.getCode());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected KGPermissionTheme(KGThemeColor kGThemeColor) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(kGThemeColor, y.ݮڮֲڭܩ(-628760828));
            put(y.٬ݯح׭٩(575808286), kGThemeColor.getCode());
            KGThemeColor kGThemeColor2 = KGThemeColor.WHITE;
            String str = y.ۮڭڭܬި(862293491);
            String str2 = y.٬ݯح׭٩(575807846);
            String str3 = y.٬ݯح׭٩(575808158);
            if (kGThemeColor == kGThemeColor2) {
                put(str3, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
                put(str2, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
                put(str, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
            } else if (kGThemeColor == KGThemeColor.BLACK || kGThemeColor == KGThemeColor.GRAY) {
                put(str3, -1);
                put(str2, -1);
                put(str, -1);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGApplication.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/KGApplication$KGThemeColor;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "WHITE", "BLACK", "GRAY", "CUSTOM", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGThemeColor {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGThemeColor[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private String code;
        public static final KGThemeColor WHITE = new KGThemeColor(y.دײܮڳܯ(2051597149), 0, y.ݬֲ֮ܲت(1512622959));
        public static final KGThemeColor BLACK = new KGThemeColor(y.ݮڮֲڭܩ(-628763188), 1, y.دײܮڳܯ(2051597077));
        public static final KGThemeColor GRAY = new KGThemeColor(y.֬ڱܱײٮ(-1159610567), 2, y.ٴسسݬߨ(1392632202));
        public static final KGThemeColor CUSTOM = new KGThemeColor(y.دײܮڳܯ(2051596293), 3, y.ٲٴݴ״ٰ(1781857568));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGThemeColor[] $values() {
            return new KGThemeColor[]{WHITE, BLACK, GRAY, CUSTOM};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGThemeColor> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGThemeColor valueOf(String str) {
            return (KGThemeColor) Enum.valueOf(KGThemeColor.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGThemeColor[] values() {
            return (KGThemeColor[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGThemeColor(String str, int i, String str2) {
            this.code = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCode() {
            return this.code;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCode(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            this.code = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGThemeColor[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        /* compiled from: KGApplication.kt */
        @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGApplication$KGThemeColor$Companion;", "", "()V", "get", "Lcom/kakaogame/KGApplication$KGThemeColor;", "code", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGThemeColor get(String code) {
                if (StringsKt.equals(code, KGThemeColor.WHITE.getCode(), true)) {
                    return KGThemeColor.WHITE;
                }
                if (StringsKt.equals(code, KGThemeColor.BLACK.getCode(), true)) {
                    return KGThemeColor.BLACK;
                }
                if (StringsKt.equals(code, KGThemeColor.GRAY.getCode(), true)) {
                    return KGThemeColor.GRAY;
                }
                return KGThemeColor.CUSTOM;
            }
        }
    }

    /* compiled from: KGApplication.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/KGApplication$KGGameServerMaintenanceResponse;", "", "notices", "", "Lcom/kakaogame/KGGameNoticeInfo;", "isWhitelist", "", "(Ljava/util/List;Z)V", "()Z", "getNotices", "()Ljava/util/List;", "toString", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGGameServerMaintenanceResponse {
        private final boolean isWhitelist;
        private final List<KGGameNoticeInfo> notices;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGGameServerMaintenanceResponse(List<KGGameNoticeInfo> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, y.֬ڱܱײٮ(-1159613431));
            this.notices = list;
            this.isWhitelist = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<KGGameNoticeInfo> getNotices() {
            return this.notices;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isWhitelist() {
            return this.isWhitelist;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (!this.notices.isEmpty()) {
                stringBuffer.append(y.ݬֲ֮ܲت(1512620775) + this.notices);
            } else {
                stringBuffer.append(y.ݮڮֲڭܩ(-628761212));
            }
            stringBuffer.append(y.ݮڮֲڭܩ(-628761084) + this.isWhitelist);
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
            return stringBuffer2;
        }
    }
}
