package com.unity3d.player;

import android.hardware.camera2.CameraDevice;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.t */
/* loaded from: classes3.dex */
final class C2756t extends CameraDevice.StateCallback {

    /* renamed from: a */
    final /* synthetic */ C2762w f1444a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2756t(C2762w c2762w) {
        this.f1444a = c2762w;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        Semaphore semaphore;
        semaphore = C2762w.f1458D;
        semaphore.release();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        Semaphore semaphore;
        AbstractC2768z.Log(5, "Camera2: CameraDevice disconnected.");
        this.f1444a.m816a(cameraDevice);
        semaphore = C2762w.f1458D;
        semaphore.release();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        Semaphore semaphore;
        AbstractC2768z.Log(6, "Camera2: Error opeining CameraDevice " + i);
        this.f1444a.m816a(cameraDevice);
        semaphore = C2762w.f1458D;
        semaphore.release();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        Semaphore semaphore;
        this.f1444a.f1461b = cameraDevice;
        semaphore = C2762w.f1458D;
        semaphore.release();
    }
}
