package com.unity3d.player;

/* renamed from: com.unity3d.player.x */
/* loaded from: classes3.dex */
abstract class AbstractC2764x {
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r0 == false) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m835a(android.app.Activity r5) {
        /*
            if (r5 == 0) goto L52
            android.view.Window r0 = r5.getWindow()
            if (r0 == 0) goto L52
            boolean r0 = com.unity3d.player.PlatformSupport.PIE_SUPPORT
            if (r0 == 0) goto L52
            boolean r0 = com.unity3d.player.PlatformSupport.VANILLA_ICE_CREAM_SUPPORT
            if (r0 == 0) goto L11
            goto L32
        L11:
            boolean r0 = com.unity3d.player.PlatformSupport.RED_VELVET_CAKE_SUPPORT
            java.lang.String r1 = "unity.render-outside-safearea"
            r2 = 0
            r3 = 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L34
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Exception -> L2f
            java.lang.String r4 = r5.getPackageName()     // Catch: java.lang.Exception -> L2f
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r4, r3)     // Catch: java.lang.Exception -> L2f
            if (r0 == 0) goto L2f
            android.os.Bundle r0 = r0.metaData     // Catch: java.lang.Exception -> L2f
            boolean r0 = r0.getBoolean(r1)     // Catch: java.lang.Exception -> L2f
            goto L30
        L2f:
            r0 = r2
        L30:
            if (r0 == 0) goto L48
        L32:
            r2 = 3
            goto L48
        L34:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Exception -> L48
            java.lang.String r4 = r5.getPackageName()     // Catch: java.lang.Exception -> L48
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r4, r3)     // Catch: java.lang.Exception -> L48
            if (r0 == 0) goto L48
            android.os.Bundle r0 = r0.metaData     // Catch: java.lang.Exception -> L48
            boolean r2 = r0.getBoolean(r1)     // Catch: java.lang.Exception -> L48
        L48:
            android.view.Window r5 = r5.getWindow()
            android.view.WindowManager$LayoutParams r5 = r5.getAttributes()
            r5.layoutInDisplayCutoutMode = r2
        L52:
            return
            fill-array 0x0054: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.AbstractC2764x.m835a(android.app.Activity):void");
    }
}
