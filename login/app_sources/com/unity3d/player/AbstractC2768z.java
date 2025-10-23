package com.unity3d.player;

import android.util.Log;

/* renamed from: com.unity3d.player.z */
/* loaded from: classes3.dex */
abstract class AbstractC2768z {

    /* renamed from: a */
    protected static boolean f1492a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static void Log(int i, String str) {
        if (f1492a) {
            return;
        }
        if (i == 6) {
            Log.e("Unity", str);
        }
        if (i == 5) {
            Log.w("Unity", str);
        }
    }
}
