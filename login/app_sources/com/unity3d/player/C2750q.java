package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* renamed from: com.unity3d.player.q */
/* loaded from: classes3.dex */
final class C2750q {

    /* renamed from: a */
    private final Context f1430a;

    /* renamed from: b */
    private final AudioManager f1431b;

    /* renamed from: c */
    private C2746o f1432c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2750q(Context context) {
        this.f1430a = context;
        this.f1431b = (AudioManager) context.getSystemService("audio");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m812a() {
        if (this.f1432c != null) {
            this.f1430a.getContentResolver().unregisterContentObserver(this.f1432c);
            this.f1432c = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m813a(InterfaceC2748p interfaceC2748p) {
        this.f1432c = new C2746o(new Handler(Looper.getMainLooper()), this.f1431b, interfaceC2748p);
        this.f1430a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f1432c);
    }
}
