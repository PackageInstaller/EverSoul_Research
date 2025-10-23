package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import android.view.Surface;

/* renamed from: com.unity3d.player.s */
/* loaded from: classes3.dex */
final class C2754s extends CameraCaptureSession.StateCallback {

    /* renamed from: a */
    final /* synthetic */ C2762w f1441a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2754s(C2762w c2762w) {
        this.f1441a = c2762w;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC2768z.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        CameraDevice cameraDevice;
        Object obj;
        StringBuilder append;
        CameraDevice cameraDevice2;
        CaptureRequest.Builder builder;
        Surface surface;
        CaptureRequest.Builder builder2;
        Range range;
        C2762w c2762w = this.f1441a;
        cameraDevice = c2762w.f1461b;
        if (cameraDevice == null) {
            return;
        }
        obj = c2762w.f1478s;
        synchronized (obj) {
            C2762w c2762w2 = this.f1441a;
            c2762w2.f1477r = cameraCaptureSession;
            try {
                try {
                    cameraDevice2 = c2762w2.f1461b;
                    c2762w2.f1476q = cameraDevice2.createCaptureRequest(1);
                    C2762w c2762w3 = this.f1441a;
                    builder = c2762w3.f1476q;
                    surface = c2762w3.f1481v;
                    builder.addTarget(surface);
                    C2762w c2762w4 = this.f1441a;
                    builder2 = c2762w4.f1476q;
                    CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
                    range = c2762w4.f1473n;
                    builder2.set(key, range);
                    this.f1441a.m827g();
                } catch (CameraAccessException e) {
                    append = new StringBuilder("Camera2: CameraAccessException ").append(e);
                    AbstractC2768z.Log(6, append.toString());
                }
            } catch (IllegalStateException e2) {
                append = new StringBuilder("Camera2: IllegalStateException ").append(e2);
                AbstractC2768z.Log(6, append.toString());
            }
        }
    }
}
