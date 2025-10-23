package com.unity3d.player;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* loaded from: classes3.dex */
public class UnityPermissions {
    private static final String SKIP_DIALOG_METADATA_NAME = "unityplayer.SkipPermissionsDialog";

    public static class ModalWaitForPermissionResponse implements IPermissionRequestCallbacks {
        private boolean haveResponse = false;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.unity3d.player.IPermissionRequestCallbacks
        public synchronized void onPermissionDenied(String str) {
            this.haveResponse = true;
            notify();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.unity3d.player.IPermissionRequestCallbacks
        public synchronized void onPermissionDeniedAndDontAskAgain(String str) {
            this.haveResponse = true;
            notify();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.unity3d.player.IPermissionRequestCallbacks
        public synchronized void onPermissionGranted(String str) {
            this.haveResponse = true;
            notify();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized void waitForResponse() {
            if (this.haveResponse) {
                return;
            }
            wait();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean checkInfoForMetadata(PackageItemInfo packageItemInfo) {
        try {
            return packageItemInfo.metaData.getBoolean(SKIP_DIALOG_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasUserAuthorizedPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void requestUserPermissions(Activity activity, String[] strArr, IPermissionRequestCallbacks iPermissionRequestCallbacks) {
        if (!PlatformSupport.MARSHMALLOW_SUPPORT || activity == null || strArr == null) {
            return;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        String valueOf = String.valueOf(PermissionFragment.UNITY_PERMISSION_REQUEST_CODE);
        if (fragmentManager.findFragmentByTag(valueOf) == null) {
            PermissionFragment permissionFragment = new PermissionFragment(activity, iPermissionRequestCallbacks);
            Bundle bundle = new Bundle();
            bundle.putStringArray(PermissionFragment.PERMISSION_NAMES, strArr);
            permissionFragment.setArguments(bundle);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(0, permissionFragment, valueOf);
            beginTransaction.commit();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean skipPermissionsDialog(Activity activity) {
        ActivityInfo activityInfo;
        ApplicationInfo applicationInfo;
        if (!PlatformSupport.MARSHMALLOW_SUPPORT) {
            return false;
        }
        try {
            PackageManager packageManager = activity.getPackageManager();
            activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 128);
            applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 128);
        } catch (Exception unused) {
        }
        if (checkInfoForMetadata(activityInfo)) {
            return true;
        }
        return checkInfoForMetadata(applicationInfo);
    }
}
