package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ManifestParser(Context context) {
        this.context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<GlideModule> parse() {
        String str = y.֬ڱܱײٮ(-1159221671);
        String str2 = y.ݬֲ֮ܲت(1513023415);
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, y.ݮڮֲڭܩ(-628885252));
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable(str2, 2)) {
                Log.v(str2, str + applicationInfo.metaData);
            }
            for (String str3 : applicationInfo.metaData.keySet()) {
                if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str3))) {
                    arrayList.add(parseModule(str3));
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "Loaded Glide module: " + str3);
                    }
                }
            }
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, y.ݮڮֲڭܩ(-628885196));
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(y.ۮڭڭܬި(862168915), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bumptech.glide.module.GlideModule parseModule(java.lang.String r3) {
        /*
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L47
            r0 = 0
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch: java.lang.reflect.InvocationTargetException -> L12 java.lang.NoSuchMethodException -> L17 java.lang.IllegalAccessException -> L1c java.lang.InstantiationException -> L21
            java.lang.reflect.Constructor r1 = r3.getDeclaredConstructor(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L12 java.lang.NoSuchMethodException -> L17 java.lang.IllegalAccessException -> L1c java.lang.InstantiationException -> L21
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.reflect.InvocationTargetException -> L12 java.lang.NoSuchMethodException -> L17 java.lang.IllegalAccessException -> L1c java.lang.InstantiationException -> L21
            java.lang.Object r3 = r1.newInstance(r0)     // Catch: java.lang.reflect.InvocationTargetException -> L12 java.lang.NoSuchMethodException -> L17 java.lang.IllegalAccessException -> L1c java.lang.InstantiationException -> L21
            goto L26
        L12:
            r0 = move-exception
            throwInstantiateGlideModuleException(r3, r0)
            goto L25
        L17:
            r0 = move-exception
            throwInstantiateGlideModuleException(r3, r0)
            goto L25
        L1c:
            r0 = move-exception
            throwInstantiateGlideModuleException(r3, r0)
            goto L25
        L21:
            r0 = move-exception
            throwInstantiateGlideModuleException(r3, r0)
        L25:
            r3 = 0
        L26:
            boolean r0 = r3 instanceof com.bumptech.glide.module.GlideModule
            if (r0 == 0) goto L2d
            com.bumptech.glide.module.GlideModule r3 = (com.bumptech.glide.module.GlideModule) r3
            return r3
        L2d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = -628899148(0xffffffffda83c2b4, float:-1.854365E16)
            java.lang.String r2 = com.liapp.y.ݮڮֲڭܩ(r2)
            r1.<init>(r2)
            java.lang.StringBuilder r3 = r1.append(r3)
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            throw r0
        L47:
            r3 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 2051994149(0x7a4ef225, float:2.686311E35)
            java.lang.String r1 = com.liapp.y.دײܮڳܯ(r1)
            r0.<init>(r1, r3)
            throw r0
            fill-array 0x0056: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.module.ManifestParser.parseModule(java.lang.String):com.bumptech.glide.module.GlideModule");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException(y.ٲٴݴ״ٰ(1781722808) + cls, exc);
    }
}
