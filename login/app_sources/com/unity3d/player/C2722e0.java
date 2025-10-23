package com.unity3d.player;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.unity3d.player.e0 */
/* loaded from: classes3.dex */
final class C2722e0 extends ContentObserver {

    /* renamed from: a */
    private InterfaceC2719d0 f1355a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2722e0(Handler handler, InterfaceC2719d0 interfaceC2719d0) {
        super(handler);
        this.f1355a = interfaceC2719d0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        InterfaceC2719d0 interfaceC2719d0 = this.f1355a;
        if (interfaceC2719d0 != null) {
            ((OrientationLockListener) interfaceC2719d0).m739b();
        }
    }
}
