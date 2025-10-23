package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(Activity activity, int i, int i2, Intent intent);

        boolean requestPermissions(Activity activity, String[] strArr, int i);
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ActivityCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setPermissionCompatDelegate(PermissionCompatDelegate permissionCompatDelegate) {
        sDelegate = permissionCompatDelegate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        Api16Impl.startActivityForResult(activity, intent, i, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Api16Impl.startIntentSenderForResult(activity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void finishAffinity(Activity activity) {
        Api16Impl.finishAffinity(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void finishAfterTransition(Activity activity) {
        Api21Impl.finishAfterTransition(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri getReferrer(Activity activity) {
        return Api22Impl.getReferrer(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends View> T requireViewById(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) Api28Impl.requireViewById(activity, i);
        }
        T t = (T) activity.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        Api21Impl.setEnterSharedElementCallback(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        Api21Impl.setExitSharedElementCallback(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void postponeEnterTransition(Activity activity) {
        Api21Impl.postponeEnterTransition(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void startPostponedEnterTransition(Activity activity) {
        Api21Impl.startPostponedEnterTransition(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        PermissionCompatDelegate permissionCompatDelegate = sDelegate;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.requestPermissions(activity, strArr, i)) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (TextUtils.isEmpty(strArr[i2])) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
                if (!BuildCompat.isAtLeastT() && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i2));
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
            if (size > 0) {
                if (size == strArr.length) {
                    return;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    if (!hashSet.contains(Integer.valueOf(i4))) {
                        strArr2[i3] = strArr[i4];
                        i3++;
                    }
                }
            }
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
            }
            Api23Impl.requestPermissions(activity, strArr, i);
        }
    }

    /* renamed from: androidx.core.app.ActivityCompat$1 */
    class RunnableC02131 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String[] val$permissionsArray;
        final /* synthetic */ int val$requestCode;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RunnableC02131(String[] strArr, Activity activity, int i) {
            this.val$permissionsArray = strArr;
            this.val$activity = activity;
            this.val$requestCode = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.val$permissionsArray.length];
            PackageManager packageManager = this.val$activity.getPackageManager();
            String packageName = this.val$activity.getPackageName();
            int length = this.val$permissionsArray.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.val$permissionsArray[i], packageName);
            }
            ((OnRequestPermissionsResultCallback) this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissionsArray, iArr);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        if (!BuildCompat.isAtLeastT() && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 32) {
            return Api32Impl.shouldShowRequestPermissionRationale(activity, str);
        }
        if (Build.VERSION.SDK_INT == 31) {
            return Api31Impl.shouldShowRequestPermissionRationale(activity, str);
        }
        return Api23Impl.shouldShowRequestPermissionRationale(activity, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isLaunchedFromBubble(Activity activity) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.isLaunchedFromBubble(activity);
        }
        if (Build.VERSION.SDK_INT == 30) {
            return (Api30Impl.getDisplay(activity) == null || Api30Impl.getDisplay(activity).getDisplayId() == 0) ? false : true;
        }
        if (Build.VERSION.SDK_INT == 29) {
            return (activity.getWindowManager().getDefaultDisplay() == null || activity.getWindowManager().getDefaultDisplay().getDisplayId() == 0) ? false : true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void recreate(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityCompat.lambda$recreate$0(activity);
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void lambda$recreate$0(Activity activity) {
        if (activity.isFinishing() || ActivityRecreator.recreate(activity)) {
            return;
        }
        activity.recreate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setLocusContext(Activity activity, LocusIdCompat locusIdCompat, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setLocusContext(activity, locusIdCompat, bundle);
        }
    }

    static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.mCallback = sharedElementCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementStart(list, list2, list3);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementEnd(list, list2, list3);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.mCallback.onRejectSharedElements(list);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.mCallback.onMapSharedElements(list, map);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.mCallback.onCreateSnapshotView(context, parcelable);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.mCallback.onSharedElementsArrived(list, list2, new SharedElementCallback.OnSharedElementsReadyListener() { // from class: androidx.core.app.ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
                public final void onSharedElementsReady() {
                    ActivityCompat.Api23Impl.onSharedElementsReady(onSharedElementsReadyListener);
                }
            });
        }
    }

    static class Api30Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api30Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setLocusContext(Activity activity, LocusIdCompat locusIdCompat, Bundle bundle) {
            activity.setLocusContext(locusIdCompat == null ? null : locusIdCompat.toLocusId(), bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Display getDisplay(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }
    }

    static class Api31Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api31Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isLaunchedFromBubble(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    static class Api32Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api32Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
            activity.startActivityForResult(intent, i, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void finishAffinity(Activity activity) {
            activity.finishAffinity();
        }
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void finishAfterTransition(Activity activity) {
            activity.finishAfterTransition();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setEnterSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setExitSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void postponeEnterTransition(Activity activity) {
            activity.postponeEnterTransition();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void startPostponedEnterTransition(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class Api22Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api22Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Uri getReferrer(Activity activity) {
            return activity.getReferrer();
        }
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> T requireViewById(Activity activity, int i) {
            return (T) activity.requireViewById(i);
        }
    }

    static class Api23Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api23Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void requestPermissions(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void onSharedElementsReady(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }
    }
}
