package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.liapp.y;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class ApplicationVersionSignature {
    private static final ConcurrentMap<String, Key> PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();
    private static final String TAG = "AppVersionSignature";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Key obtain(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, Key> concurrentMap = PACKAGE_NAME_TO_KEY;
        Key key = concurrentMap.get(packageName);
        if (key != null) {
            return key;
        }
        Key obtainVersionSignature = obtainVersionSignature(context);
        Key putIfAbsent = concurrentMap.putIfAbsent(packageName, obtainVersionSignature);
        return putIfAbsent == null ? obtainVersionSignature : putIfAbsent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Key obtainVersionSignature(Context context) {
        return new ObjectKey(getVersionCode(getPackageInfo(context)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getVersionCode(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(y.ۮڭڭܬި(862145443), y.٬ݯح׭٩(575989246) + context.getPackageName(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ApplicationVersionSignature() {
    }
}
