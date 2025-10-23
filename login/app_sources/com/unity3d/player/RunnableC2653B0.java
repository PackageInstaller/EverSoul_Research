package com.unity3d.player;

/* renamed from: com.unity3d.player.B0 */
/* loaded from: classes3.dex */
final class RunnableC2653B0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1149a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2653B0(UnityPlayer unityPlayer) {
        this.f1149a = unityPlayer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r1 = (r0 = r2.f1149a).mActivity;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r2 = this;
            com.unity3d.player.UnityPlayer r0 = r2.f1149a
            boolean r0 = com.unity3d.player.UnityPlayer.m1381$$Nest$mnativeIsAutorotationOn(r0)
            if (r0 == 0) goto L17
            com.unity3d.player.UnityPlayer r0 = r2.f1149a
            android.app.Activity r1 = com.unity3d.player.UnityPlayer.m1363$$Nest$fgetmActivity(r0)
            if (r1 == 0) goto L17
            int r0 = com.unity3d.player.UnityPlayer.m1366$$Nest$fgetmInitialScreenOrientation(r0)
            r1.setRequestedOrientation(r0)
        L17:
            return
            fill-array 0x0018: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.RunnableC2653B0.run():void");
    }
}
