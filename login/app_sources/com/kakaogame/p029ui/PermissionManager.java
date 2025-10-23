package com.kakaogame.p029ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.drive.DriveFile;
import com.kakao.sdk.template.Constants;
import com.kakaogame.C2382R;
import com.kakaogame.KGApplication;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PermissionManager.kt */
@Metadata(m838d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001<B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\"\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J*\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007J\"\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0002J&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010 \u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0004H\u0002J \u0010%\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0007J \u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0004J \u0010)\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0002J\"\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J@\u0010+\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002J*\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007J\"\u0010/\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0002J.\u00100\u001a\u00020$2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010\u0017\u001a\u00020\u00182\f\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0002J \u0010.\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0012H\u0002J@\u0010:\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010;\u001a\u00020\u00122\u0006\u00103\u001a\u000204H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006="}, m839d2 = {"Lcom/kakaogame/ui/PermissionManager;", "", "()V", "PREF_KEY_FIRST_LAUNCH", "", "PREF_NAME", "REQUEST_CODE", "", "TAG", "appendPermissionDescBody", "obj", "Lorg/json/JSONObject;", "permissions", "", "optionalPermissions", "prefixEssential", "prefixOptional", "checkGrantResult", "", "grantResults", "", "checkPermission", "Lcom/kakaogame/KGResult;", "activity", "Landroid/app/Activity;", "permission", "checkPermissions", "checkPermissionsImpl", "context", "Landroid/content/Context;", "getNotGrantedPermissions", "getPermissionDescriptions", "getPermissionList", "", "Lcom/kakaogame/ui/PermissionManager$PermissionDesc;", "goToSettings", "", "isForeverDenied", "notGrantedPermission", "notGrantedPermissions", "requestPermission", "requestPermissionImpl", "requestPermissionWithDeniedCheck", "requestPermissions", "essentialPermissions", "forceExit", "showPopup", "requestPermissionsImpl", "showPermissionAlertDialog", "builder", "Landroid/app/AlertDialog$Builder;", "theme", "Lcom/kakaogame/KGApplication$KGPermissionTheme;", "uiLock", "Lcom/kakaogame/util/MutexLock;", "Ljava/lang/Void;", "msgResId", "finish", "showUsePermissionsNotification", "OptionGuarantee", "PermissionDesc", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PermissionManager {
    public static final PermissionManager INSTANCE = new PermissionManager();
    private static final String PREF_KEY_FIRST_LAUNCH = "isLaunched";
    private static final String PREF_NAME = "KG_Permissions";
    private static final int REQUEST_CODE = 11;
    private static final String TAG = "PermissionManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PermissionManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, PermissionDesc> getPermissionList(JSONObject obj) {
        String str = y.دײܮڳܯ(2051041469);
        String str2 = y.دײܮڳܯ(2051039861);
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = obj.getJSONArray(Constants.TYPE_LIST);
            Logger.INSTANCE.m699d(str, str2 + jSONArray.length());
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                PermissionDesc permissionDesc = new PermissionDesc(jSONObject);
                if (!TextUtils.isEmpty(permissionDesc.getKey())) {
                    hashMap.put(permissionDesc.getKey(), permissionDesc);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Logger.INSTANCE.m699d(str, y.٬ݯح׭٩(576365726) + hashMap.size());
        return hashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String appendPermissionDescBody(JSONObject obj, List<String> permissions, List<String> optionalPermissions, String prefixEssential, String prefixOptional) {
        if (obj == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Map<String, PermissionDesc> permissionList = getPermissionList(obj);
        String str = y.ٲٴݴ״ٰ(1781641888);
        String str2 = y.ٲٴݴ״ٰ(1782346864);
        if (permissions != null) {
            boolean z = (optionalPermissions == null || optionalPermissions.isEmpty()) ? false : true;
            Intrinsics.checkNotNull(permissionList);
            for (String str3 : permissionList.keySet()) {
                for (String str4 : permissions) {
                    PermissionDesc permissionDesc = permissionList.get(str3);
                    Intrinsics.checkNotNull(permissionDesc);
                    if (permissionDesc.contains(str4, z ? prefixEssential : null, 1)) {
                        break;
                    }
                }
            }
            for (String str5 : permissionList.keySet()) {
                PermissionDesc permissionDesc2 = permissionList.get(str5);
                Intrinsics.checkNotNull(permissionDesc2);
                if (permissionDesc2.getContains() == 1) {
                    stringBuffer.append(str2);
                    PermissionDesc permissionDesc3 = permissionList.get(str5);
                    Intrinsics.checkNotNull(permissionDesc3);
                    stringBuffer.append(permissionDesc3.getName());
                    stringBuffer.append(str);
                    PermissionDesc permissionDesc4 = permissionList.get(str5);
                    Intrinsics.checkNotNull(permissionDesc4);
                    stringBuffer.append(permissionDesc4.getDesc());
                }
            }
        }
        if (optionalPermissions != null) {
            boolean z2 = (permissions == null || permissions.isEmpty()) ? false : true;
            Intrinsics.checkNotNull(permissionList);
            for (String str6 : permissionList.keySet()) {
                for (String str7 : optionalPermissions) {
                    PermissionDesc permissionDesc5 = permissionList.get(str6);
                    Intrinsics.checkNotNull(permissionDesc5);
                    if (permissionDesc5.contains(str7, z2 ? prefixOptional : null, 2)) {
                        break;
                    }
                }
            }
            for (String str8 : permissionList.keySet()) {
                PermissionDesc permissionDesc6 = permissionList.get(str8);
                Intrinsics.checkNotNull(permissionDesc6);
                if (permissionDesc6.getContains() == 2) {
                    stringBuffer.append(str2);
                    PermissionDesc permissionDesc7 = permissionList.get(str8);
                    Intrinsics.checkNotNull(permissionDesc7);
                    stringBuffer.append(permissionDesc7.getName());
                    stringBuffer.append(str);
                    PermissionDesc permissionDesc8 = permissionList.get(str8);
                    Intrinsics.checkNotNull(permissionDesc8);
                    stringBuffer.append(permissionDesc8.getDesc());
                }
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
        return stringBuffer2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final JSONObject getPermissionDescriptions(Activity activity) throws JSONException {
        Resources resources = activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, y.دײܮڳܯ(2051040541));
        return new JSONObject(ResourceUtil.readJSONResource(resources, C2382R.raw.usepermission));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean showUsePermissionsNotification(final Activity activity, List<String> permissions, List<String> optionalPermissions, boolean OptionGuarantee, final KGApplication.KGPermissionTheme theme) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(theme, y.ݬֲ֮ܲت(1512396567));
        Activity activity2 = activity;
        boolean z = PreferenceUtil.getBoolean(activity2, y.ݮڮֲڭܩ(-628271380), y.ٲٴݴ״ٰ(1782343152));
        Logger logger = Logger.INSTANCE;
        String concat = y.ٴسسݬߨ(1393130266).concat(z ? y.دײܮڳܯ(2051939573) : y.ٲٴݴ״ٰ(1781635312));
        String str = y.دײܮڳܯ(2051041469);
        logger.m704i(str, concat);
        if (!OptionGuarantee && z) {
            if (permissions != null && !permissions.isEmpty()) {
                if (INSTANCE.getNotGrantedPermissions(activity2, permissions).isEmpty()) {
                    Logger.INSTANCE.m704i(str, y.ۮڭڭܬި(862786267));
                }
            }
            return true;
        }
        PermissionManager permissionManager = INSTANCE;
        List<String> notGrantedPermissions = permissionManager.getNotGrantedPermissions(activity2, permissions);
        List<String> notGrantedPermissions2 = permissionManager.getNotGrantedPermissions(activity2, optionalPermissions);
        ArrayList arrayList = new ArrayList();
        for (String str2 : notGrantedPermissions2) {
            if (!INSTANCE.isForeverDenied(activity, str2)) {
                arrayList.add(str2);
            }
        }
        if (notGrantedPermissions.isEmpty() && arrayList.isEmpty()) {
            return true;
        }
        Object systemService = activity.getApplicationContext().getSystemService(y.دײܮڳܯ(2051526165));
        Intrinsics.checkNotNull(systemService, y.ݬֲ֮ܲت(1512564599));
        View inflate = ((LayoutInflater) systemService).inflate(C2382R.layout.zinny_sdk_permission_noti, (ViewGroup) null);
        View findViewById = inflate.findViewById(C2382R.id.zinny_sdk_permission_noti_icon);
        Intrinsics.checkNotNull(findViewById, y.ݬֲ֮ܲت(1512437799));
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(C2382R.id.zinny_sdk_permission_noti_title);
        String str3 = y.֬ڱܱײٮ(-1158769727);
        Intrinsics.checkNotNull(findViewById2, str3);
        TextView textView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(C2382R.id.zinny_sdk_permission_noti_scrollview);
        Intrinsics.checkNotNull(findViewById3, y.֬ڱܱײٮ(-1159124951));
        ScrollView scrollView = (ScrollView) findViewById3;
        View findViewById4 = inflate.findViewById(C2382R.id.zinny_sdk_permission_noti_content);
        Intrinsics.checkNotNull(findViewById4, str3);
        TextView textView2 = (TextView) findViewById4;
        Drawable iconResource = theme.getIconResource();
        if (iconResource == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(iconResource);
        }
        int titleTextColor = theme.getTitleTextColor();
        if (titleTextColor != Integer.MAX_VALUE) {
            textView.setTextColor(titleTextColor);
        }
        int contentTextColor = theme.getContentTextColor();
        if (contentTextColor != Integer.MAX_VALUE) {
            textView2.setTextColor(contentTextColor);
        }
        final AlertDialog.Builder createAlertDialogBuilder = DialogManager.createAlertDialogBuilder(activity);
        createAlertDialogBuilder.setView(inflate);
        try {
            PermissionManager permissionManager2 = INSTANCE;
            JSONObject permissionDescriptions = permissionManager2.getPermissionDescriptions(activity);
            textView.setText(permissionDescriptions.getString("title"));
            String string = permissionDescriptions.getString("prefix_essential");
            String string2 = permissionDescriptions.getString("prefix_optional");
            String string3 = permissionDescriptions.getString("summary");
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(string2);
            String appendPermissionDescBody = permissionManager2.appendPermissionDescBody(permissionDescriptions, notGrantedPermissions, arrayList, string, string2);
            Logger.INSTANCE.m699d(str, "permissions contents: " + appendPermissionDescBody);
            textView2.setText(string3 + appendPermissionDescBody);
            scrollView.requestLayout();
            createAlertDialogBuilder.setCancelable(false);
            createAlertDialogBuilder.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.PermissionManager$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.ui.PermissionManager$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    PermissionManager.showUsePermissionsNotification$lambda$1(createAlertDialogBuilder, theme, activity, createLock);
                }
            });
            MutexLock.lock$default(createLock, 0L, 1, null);
            return permissionManager2.requestPermissions(activity, notGrantedPermissions, arrayList, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showUsePermissionsNotification$lambda$1(AlertDialog.Builder builder, KGApplication.KGPermissionTheme kGPermissionTheme, Activity activity, MutexLock mutexLock) {
        Intrinsics.checkNotNullParameter(builder, y.ۮڭڭܬި(862783083));
        Intrinsics.checkNotNullParameter(kGPermissionTheme, y.ٲٴݴ״ٰ(1782343680));
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Intrinsics.checkNotNullParameter(mutexLock, y.ٴسسݬߨ(1393129226));
        INSTANCE.showPermissionAlertDialog(builder, kGPermissionTheme, activity, mutexLock);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showPermissionAlertDialog(AlertDialog.Builder builder, final KGApplication.KGPermissionTheme theme, final Activity activity, final MutexLock<Void> uiLock) {
        Drawable drawable;
        Activity activity2 = activity;
        final boolean z = PreferenceUtil.getBoolean(activity2, y.ݮڮֲڭܩ(-628271380), y.ٲٴݴ״ٰ(1782343152));
        final AlertDialog create = builder.create();
        if (theme.getConfirmTextColor() != -1) {
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.kakaogame.ui.PermissionManager$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    PermissionManager.showPermissionAlertDialog$lambda$2(create, theme, dialogInterface);
                }
            });
        }
        KGApplication.KGThemeColor themeColor = theme.getThemeColor();
        if (themeColor == KGApplication.KGThemeColor.CUSTOM) {
            Drawable backgroundResource = theme.getBackgroundResource();
            if (backgroundResource != null) {
                y.٬خݮ۳ݯ(create);
                Window window = create.getWindow();
                Intrinsics.checkNotNull(window);
                window.setBackgroundDrawable(backgroundResource);
            }
            if (theme.getBackgroundColor() != Integer.MAX_VALUE) {
                Drawable drawable2 = ResourceUtil.getDrawable(activity2, C2382R.drawable.login_bg_popup_google);
                Intrinsics.checkNotNull(drawable2);
                drawable2.setColorFilter(theme.getBackgroundColor(), PorterDuff.Mode.MULTIPLY);
                y.٬خݮ۳ݯ(create);
                Window window2 = create.getWindow();
                Intrinsics.checkNotNull(window2);
                window2.setBackgroundDrawable(drawable2);
            }
        } else {
            if (themeColor == KGApplication.KGThemeColor.GRAY) {
                drawable = ResourceUtil.getDrawable(activity2, C2382R.drawable.login_bg_popup_guest);
            } else if (themeColor == KGApplication.KGThemeColor.BLACK) {
                drawable = ResourceUtil.getDrawable(activity2, C2382R.drawable.login_bg_popup_guest);
                Intrinsics.checkNotNull(drawable);
                drawable.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.MULTIPLY);
            } else {
                drawable = ResourceUtil.getDrawable(activity2, C2382R.drawable.login_bg_popup_google);
            }
            y.٬خݮ۳ݯ(create);
            Window window3 = create.getWindow();
            Intrinsics.checkNotNull(window3);
            window3.setBackgroundDrawable(drawable);
        }
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.ui.PermissionManager$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PermissionManager.showPermissionAlertDialog$lambda$3(z, activity, uiLock, dialogInterface);
            }
        });
        y.٬خݮ۳ݯ(create);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPermissionAlertDialog$lambda$2(AlertDialog alertDialog, KGApplication.KGPermissionTheme theme, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(theme, "$theme");
        alertDialog.getButton(-1).setTextColor(theme.getConfirmTextColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPermissionAlertDialog$lambda$3(boolean z, Activity activity, MutexLock uiLock, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(uiLock, "$uiLock");
        if (!z) {
            PreferenceUtil.setBoolean(activity, y.ݮڮֲڭܩ(-628271380), PREF_KEY_FIRST_LAUNCH, true);
        }
        uiLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Boolean> requestPermissionWithDeniedCheck(Activity activity, String permission) {
        if (activity == null) {
            return KGResult.INSTANCE.getResult(4000, "activitiy is null");
        }
        if (TextUtils.isEmpty(permission)) {
            return KGResult.INSTANCE.getResult(4000, "permission is null");
        }
        Intrinsics.checkNotNull(permission);
        if (isForeverDenied(activity, permission)) {
            return KGResult.INSTANCE.getResult(4002);
        }
        return requestPermission(activity, permission);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Boolean> requestPermission(Activity activity, String permission) {
        KGResult<Boolean> result;
        String name;
        KGResult<Boolean> result2;
        Intrinsics.checkNotNullParameter(permission, y.֬ڱܱײٮ(-1159616063));
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862789291) + activity + y.ݮڮֲڭܩ(-628756788) + permission;
        String str2 = y.دײܮڳܯ(2051041469);
        logger.m704i(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.دײܮڳܯ(2051043893));
        try {
            try {
                try {
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str2, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                    KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                    return result;
                }
            } catch (IllegalArgumentException e2) {
                Logger.INSTANCE.m702e(str2, e2.toString(), e2);
                result = KGResult.INSTANCE.getResult(4000, e2.toString());
                start.stop();
                name = start.getName();
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            }
            if (activity == null) {
                result2 = KGResult.INSTANCE.getResult(4000, "activitiy is null");
            } else {
                if (!TextUtils.isEmpty(permission)) {
                    result = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(requestPermissionsImpl(activity, CollectionsKt.listOf(permission))));
                    start.stop();
                    name = start.getName();
                    KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                    return result;
                }
                result2 = KGResult.INSTANCE.getResult(4000, "permission is null");
            }
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
            return result2;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Boolean> requestPermissions(Activity activity, List<String> permissions) {
        KGResult<Boolean> result;
        String name;
        KGResult<Boolean> result2;
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576371558) + activity + y.ݮڮֲڭܩ(-628756788) + permissions;
        String str2 = y.دײܮڳܯ(2051041469);
        logger.m704i(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(576371766));
        try {
            try {
            } catch (IllegalArgumentException e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4000, e.toString());
                start.stop();
                name = start.getName();
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            } catch (Exception e2) {
                Logger.INSTANCE.m702e(str2, e2.toString(), e2);
                result = KGResult.INSTANCE.getResult(4001, e2.toString());
                start.stop();
                name = start.getName();
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            }
            if (activity == null) {
                result2 = KGResult.INSTANCE.getResult(4000, "activitiy is null");
            } else {
                if (permissions != null) {
                    result = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(INSTANCE.requestPermissionsImpl(activity, permissions)));
                    start.stop();
                    name = start.getName();
                    KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                    return result;
                }
                result2 = KGResult.INSTANCE.getResult(4000, "permissions is null");
            }
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
            return result2;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Boolean> checkPermission(Activity activity, String permission) {
        KGResult<Boolean> result;
        String name;
        KGResult<Boolean> result2;
        Intrinsics.checkNotNullParameter(permission, y.֬ڱܱײٮ(-1159616063));
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862782131) + activity + y.ݮڮֲڭܩ(-628756788) + permission;
        String str2 = y.دײܮڳܯ(2051041469);
        logger.m704i(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ۮڭڭܬި(862784811));
        try {
            try {
                try {
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str2, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                    KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                    return result;
                }
            } catch (IllegalArgumentException e2) {
                Logger.INSTANCE.m702e(str2, e2.toString(), e2);
                result = KGResult.INSTANCE.getResult(4000, e2.toString());
                start.stop();
                name = start.getName();
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            }
            if (activity == null) {
                result2 = KGResult.INSTANCE.getResult(4000, "activitiy is null");
            } else {
                if (!TextUtils.isEmpty(permission)) {
                    result = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(INSTANCE.checkPermissionsImpl(activity, CollectionsKt.listOf(permission))));
                    start.stop();
                    name = start.getName();
                    KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                    return result;
                }
                result2 = KGResult.INSTANCE.getResult(4000, "permission is null");
            }
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
            return result2;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Boolean> checkPermissions(Activity activity, List<String> permissions) {
        KGResult<Boolean> result;
        String name;
        KGResult<Boolean> result2;
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159120855) + activity + y.ݮڮֲڭܩ(-628756788) + permissions;
        String str2 = y.دײܮڳܯ(2051041469);
        logger.m704i(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٴسسݬߨ(1393124842));
        try {
            try {
            } catch (IllegalArgumentException e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4000, e.toString());
                start.stop();
                name = start.getName();
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            } catch (Exception e2) {
                Logger.INSTANCE.m702e(str2, e2.toString(), e2);
                result = KGResult.INSTANCE.getResult(4001, e2.toString());
                start.stop();
                name = start.getName();
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            }
            if (activity == null) {
                result2 = KGResult.INSTANCE.getResult(4000, "activitiy is null");
            } else {
                if (permissions != null) {
                    result = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(INSTANCE.checkPermissionsImpl(activity, permissions)));
                    start.stop();
                    name = start.getName();
                    KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                    return result;
                }
                result2 = KGResult.INSTANCE.getResult(4000, "permissions is null");
            }
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
            return result2;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean requestPermissionsImpl(Activity activity, List<String> permissions) {
        if (activity == null || permissions == null) {
            return false;
        }
        return requestPermissions(activity, null, permissions, false, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean checkPermissionsImpl(Context context, List<String> permissions) {
        if (context == null || permissions == null) {
            return false;
        }
        return getNotGrantedPermissions(context, permissions).isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean requestPermissions(Activity activity, List<String> essentialPermissions, List<String> optionalPermissions, boolean forceExit, boolean showPopup) {
        int i;
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159120855) + essentialPermissions + y.دײܮڳܯ(2051046245) + optionalPermissions;
        String str2 = y.دײܮڳܯ(2051041469);
        logger.m704i(str2, str);
        ArrayList arrayList = new ArrayList();
        if (essentialPermissions != null) {
            arrayList.addAll(essentialPermissions);
        }
        if (optionalPermissions != null) {
            arrayList.addAll(optionalPermissions);
        }
        Activity activity2 = activity;
        List<String> notGrantedPermissions = getNotGrantedPermissions(activity2, arrayList);
        if (notGrantedPermissions.isEmpty()) {
            return true;
        }
        Logger.INSTANCE.m704i(str2, y.ۮڭڭܬި(862785603) + notGrantedPermissions);
        if (showPopup) {
            showPopup(activity, C2382R.string.zinny_sdk_permission_guide, false);
        }
        boolean requestPermissionImpl = requestPermissionImpl(activity, notGrantedPermissions);
        Logger.INSTANCE.m704i(str2, y.ݬֲ֮ܲت(1512067495) + requestPermissionImpl);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            PreferenceUtil.setBoolean(activity2, y.ݮڮֲڭܩ(-628271380), it.next(), true);
        }
        if (essentialPermissions == null) {
            return requestPermissionImpl;
        }
        List<String> notGrantedPermissions2 = getNotGrantedPermissions(activity2, essentialPermissions);
        if (notGrantedPermissions2.isEmpty()) {
            return requestPermissionImpl;
        }
        if (isForeverDenied(activity, notGrantedPermissions2)) {
            i = C2382R.string.zinny_sdk_permission_denied_forever;
        } else {
            i = C2382R.string.zinny_sdk_permission_denied;
        }
        showPopup(activity, i, true);
        return requestPermissionImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isForeverDenied(Activity activity, List<String> notGrantedPermissions) {
        Intrinsics.checkNotNullParameter(notGrantedPermissions, y.֬ڱܱײٮ(-1159119119));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159126599) + notGrantedPermissions;
        String str2 = y.دײܮڳܯ(2051041469);
        logger.m704i(str2, str);
        Iterator<String> it = notGrantedPermissions.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            String next = it.next();
            Intrinsics.checkNotNull(activity);
            Activity activity2 = activity;
            if (!(ContextCompat.checkSelfPermission(activity2, next) == 0)) {
                boolean shouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(activity, next);
                Logger.INSTANCE.m704i(str2, y.٬ݯح׭٩(576365902) + shouldShowRequestPermissionRationale);
                boolean z = PreferenceUtil.getBoolean(activity2, y.ݮڮֲڭܩ(-628271380), next);
                Logger.INSTANCE.m704i(str2, y.֬ڱܱײٮ(-1159119359) + z);
                if (!shouldShowRequestPermissionRationale && z) {
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isForeverDenied(Activity activity, String notGrantedPermission) {
        Activity activity2 = activity;
        if (!(ContextCompat.checkSelfPermission(activity2, notGrantedPermission) == 0)) {
            boolean shouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(activity, notGrantedPermission);
            Logger logger = Logger.INSTANCE;
            String str = y.٬ݯح׭٩(576365902) + shouldShowRequestPermissionRationale;
            String str2 = y.دײܮڳܯ(2051041469);
            logger.m704i(str2, str);
            boolean z = PreferenceUtil.getBoolean(activity2, y.ݮڮֲڭܩ(-628271380), notGrantedPermission);
            Logger.INSTANCE.m704i(str2, y.֬ڱܱײٮ(-1159119359) + z);
            if (!shouldShowRequestPermissionRationale && z) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final List<String> getNotGrantedPermissions(Context context, List<String> permissions) {
        ArrayList arrayList = new ArrayList();
        if (permissions == null) {
            return arrayList;
        }
        for (String str : permissions) {
            boolean z = ContextCompat.checkSelfPermission(context, str) == 0;
            Logger.INSTANCE.m704i(y.دײܮڳܯ(2051041469), y.ݬֲ֮ܲت(1512066351) + z);
            if (!z) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean requestPermissionImpl(Activity activity, List<String> permissions) {
        Logger.INSTANCE.m704i(y.دײܮڳܯ(2051041469), y.֬ڱܱײٮ(-1159126935) + permissions);
        if (permissions == null || permissions.isEmpty()) {
            return true;
        }
        final String[] strArr = (String[]) permissions.toArray(new String[0]);
        final MutexLock createLock = MutexLock.INSTANCE.createLock();
        long start = KGAuthActivity.INSTANCE.start(activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.ui.PermissionManager$requestPermissionImpl$eventListener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onDestroy() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityStart(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                ActivityCompat.requestPermissions(activity2, strArr, 11);
            }
        }, new ActivityCompat.OnRequestPermissionsResultCallback() { // from class: com.kakaogame.ui.PermissionManager$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
            public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                PermissionManager.requestPermissionImpl$lambda$24(MutexLock.this, i, strArr2, iArr);
            }
        });
        MutexLock.lock$default(createLock, 0L, 1, null);
        AuthActivityManager.INSTANCE.getInstance().finishActivity(start);
        if (createLock.getContent() != null) {
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            return ((Boolean) content).booleanValue();
        }
        return requestPermissionImpl(activity, permissions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void requestPermissionImpl$lambda$24(MutexLock mutexLock, int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(mutexLock, y.ٴسسݬߨ(1393131074));
        Intrinsics.checkNotNullParameter(strArr, y.دײܮڳܯ(2051593325));
        Intrinsics.checkNotNullParameter(iArr, y.ۮڭڭܬި(862306227));
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.ۮڭڭܬި(862306243)).append(i);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(strArr).append(str).append(iArr).toString();
        String str2 = y.دײܮڳܯ(2051041469);
        logger.m704i(str2, sb);
        if (i == 11) {
            Logger logger2 = Logger.INSTANCE;
            StringBuilder sb2 = new StringBuilder(y.֬ڱܱײٮ(-1158758935));
            String arrays = Arrays.toString(strArr);
            String str3 = y.ٲٴݴ״ٰ(1781855688);
            Intrinsics.checkNotNullExpressionValue(arrays, str3);
            logger2.m704i(str2, sb2.append(arrays).toString());
            Logger logger3 = Logger.INSTANCE;
            StringBuilder sb3 = new StringBuilder(y.دײܮڳܯ(2051046565));
            String arrays2 = Arrays.toString(iArr);
            Intrinsics.checkNotNullExpressionValue(arrays2, str3);
            logger3.m704i(str2, sb3.append(arrays2).toString());
            mutexLock.setContent(Boolean.valueOf(INSTANCE.checkGrantResult(iArr)));
            mutexLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean checkGrantResult(int[] grantResults) {
        if (grantResults == null) {
            return false;
        }
        if (grantResults.length == 0) {
            return false;
        }
        for (int i : grantResults) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void goToSettings(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intent intent = new Intent(y.ٴسسݬߨ(1393089898), Uri.fromParts(y.ݬֲ֮ܲت(1512932399), activity.getPackageName(), null));
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        activity.startActivity(intent);
        AppUtil.terminateApp(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showPopup(final Activity activity, final int msgResId, final boolean finish) {
        if (msgResId == -1) {
            return;
        }
        final MutexLock createLock = MutexLock.INSTANCE.createLock();
        DialogManager.Settings settings = new DialogManager.Settings(null, null, null, Integer.valueOf(msgResId), null, null, null, null, false, null, null, null, null, 8183, null);
        settings.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.PermissionManager$$ExternalSyntheticLambda5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PermissionManager.showPopup$lambda$25(finish, msgResId, activity, dialogInterface, i);
            }
        });
        if (!finish) {
            settings.setCancelable(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.ui.PermissionManager$$ExternalSyntheticLambda6
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    PermissionManager.showPopup$lambda$26(MutexLock.this, dialogInterface);
                }
            });
        }
        DialogManager.INSTANCE.showAlertDialog(activity, settings);
        MutexLock.lock$default(createLock, 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPopup$lambda$25(boolean z, int i, Activity activity, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (z) {
            if (i == C2382R.string.zinny_sdk_permission_denied_forever) {
                goToSettings(activity);
                return;
            } else {
                AppUtil.terminateApp(activity);
                return;
            }
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPopup$lambda$26(MutexLock uiLock, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(uiLock, "$uiLock");
        uiLock.unlock();
    }

    /* compiled from: PermissionManager.kt */
    @Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, m839d2 = {"Lcom/kakaogame/ui/PermissionManager$PermissionDesc;", "", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "contains", "", "getContains", "()I", "setContains", "(I)V", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "key", "getKey", "setKey", "name", "getName", "setName", "permissions", "", "getPermissions", "()Ljava/util/List;", "setPermissions", "(Ljava/util/List;)V", "", "permission", "prefix", "type", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private static final class PermissionDesc {
        private int contains;
        private String desc;
        private String key;
        private String name;
        public List<String> permissions;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PermissionDesc(JSONObject jSONObject) {
            String str = y.ݬֲ֮ܲت(1512063743);
            Intrinsics.checkNotNullParameter(jSONObject, y.ٴسسݬߨ(1393125978));
            this.contains = -1;
            try {
                this.key = jSONObject.getString("key");
                this.name = jSONObject.getString("name");
                this.desc = jSONObject.getString("desc");
                this.contains = -1;
                JSONArray jSONArray = jSONObject.getJSONArray("permissions");
                setPermissions(new ArrayList());
                if (jSONArray != null) {
                    Logger.INSTANCE.m699d(PermissionManager.TAG, str + jSONArray);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        List<String> permissions = getPermissions();
                        Intrinsics.checkNotNull(permissions);
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        permissions.add(string);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getKey() {
            return this.key;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setKey(String str) {
            this.key = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<String> getPermissions() {
            List<String> list = this.permissions;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException(y.دײܮڳܯ(2051593325));
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, y.ٴسسݬߨ(1392633402));
            this.permissions = list;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getName() {
            return this.name;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setName(String str) {
            this.name = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getDesc() {
            return this.desc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setDesc(String str) {
            this.desc = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getContains() {
            return this.contains;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setContains(int i) {
            this.contains = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean contains(String permission, String prefix, int type) {
            Intrinsics.checkNotNullParameter(permission, y.֬ڱܱײٮ(-1159616063));
            if (this.contains == type) {
                return true;
            }
            Logger.INSTANCE.m699d(y.دײܮڳܯ(2051041469), y.دײܮڳܯ(2051041373) + permission + y.ݮڮֲڭܩ(-628756788) + getPermissions());
            List<String> permissions = getPermissions();
            Intrinsics.checkNotNull(permissions);
            int i = permissions.contains(permission) ? type : this.contains;
            this.contains = i;
            if (i == type && prefix != null) {
                this.name = y.٬ݯح׭٩(575982094) + prefix + ") " + this.name;
            }
            return this.contains == type;
        }
    }
}
