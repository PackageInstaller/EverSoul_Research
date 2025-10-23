package com.unity3d.player;

import android.media.Image;
import android.media.ImageReader;
import com.unity3d.player.p030a.InterfaceC2705b;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.u */
/* loaded from: classes3.dex */
final class C2758u implements ImageReader.OnImageAvailableListener {

    /* renamed from: a */
    final /* synthetic */ C2762w f1447a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2758u(C2762w c2762w) {
        this.f1447a = c2762w;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Semaphore semaphore;
        Semaphore semaphore2;
        Image image;
        InterfaceC2705b interfaceC2705b;
        semaphore = C2762w.f1458D;
        if (semaphore.tryAcquire()) {
            Image acquireNextImage = imageReader.acquireNextImage();
            if (acquireNextImage != null) {
                Image.Plane[] planes = acquireNextImage.getPlanes();
                if (acquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                    interfaceC2705b = this.f1447a.f1460a;
                    ((Camera2Wrapper) interfaceC2705b).m730a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                } else {
                    AbstractC2768z.Log(6, "Camera2: Wrong image format.");
                }
                image = this.f1447a.f1475p;
                if (image != null) {
                    image.close();
                }
                this.f1447a.f1475p = acquireNextImage;
            }
            semaphore2 = C2762w.f1458D;
            semaphore2.release();
        }
    }
}
