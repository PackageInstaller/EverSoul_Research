package com.unity3d.player;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;

/* renamed from: com.unity3d.player.o */
/* loaded from: classes3.dex */
final class C2746o extends ContentObserver {

    /* renamed from: a */
    private final InterfaceC2748p f1424a;

    /* renamed from: b */
    private final AudioManager f1425b;

    /* renamed from: c */
    private final int f1426c;

    /* renamed from: d */
    private int f1427d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2746o(Handler handler, AudioManager audioManager, InterfaceC2748p interfaceC2748p) {
        super(handler);
        this.f1425b = audioManager;
        this.f1426c = 3;
        this.f1424a = interfaceC2748p;
        this.f1427d = audioManager.getStreamVolume(3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        int streamVolume;
        AudioManager audioManager = this.f1425b;
        if (audioManager == null || this.f1424a == null || (streamVolume = audioManager.getStreamVolume(this.f1426c)) == this.f1427d) {
            return;
        }
        this.f1427d = streamVolume;
        this.f1424a.onAudioVolumeChanged(streamVolume);
    }
}
