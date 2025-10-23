package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.Surface;
import com.unity3d.player.p030a.InterfaceC2705b;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class Camera2Wrapper implements InterfaceC2705b {

    /* renamed from: a */
    private Context f1154a;

    /* renamed from: b */
    private C2762w f1155b = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Camera2Wrapper(Context context) {
        this.f1154a = context;
        initCamera2Jni();
    }

    private final native void deinitCamera2Jni();

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m728a() {
        deinitCamera2Jni();
        closeCamera2();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m729a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m730a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3) {
        nativeFrameReady(byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void closeCamera2() {
        C2762w c2762w = this.f1155b;
        if (c2762w != null) {
            c2762w.m828a();
        }
        this.f1155b = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getCamera2Count() {
        return C2762w.m814a(this.f1154a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getCamera2FocalLengthEquivalent(int i) {
        return C2762w.m815a(this.f1154a, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int[] getCamera2Resolutions(int i) {
        return C2762w.m819b(this.f1154a, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getCamera2SensorOrientation(int i) {
        return C2762w.m821c(this.f1154a, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Rect getFrameSizeCamera2() {
        C2762w c2762w = this.f1155b;
        return c2762w != null ? c2762w.m831c() : new Rect();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean initializeCamera2(int i, int i2, int i3, int i4, int i5, Surface surface) {
        if (this.f1155b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        C2762w c2762w = new C2762w(this);
        this.f1155b = c2762w;
        return c2762w.m830a(this.f1154a, i, i2, i3, i4, i5, surface);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean isCamera2AutoFocusPointSupported(int i) {
        return C2762w.m823d(this.f1154a, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean isCamera2FrontFacing(int i) {
        return C2762w.m825e(this.f1154a, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void pauseCamera2() {
        C2762w c2762w = this.f1155b;
        if (c2762w != null) {
            c2762w.m832d();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean setAutoFocusPoint(float f, float f2) {
        C2762w c2762w = this.f1155b;
        if (c2762w != null) {
            return c2762w.m829a(f, f2);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void startCamera2() {
        C2762w c2762w = this.f1155b;
        if (c2762w != null) {
            c2762w.m833h();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void stopCamera2() {
        C2762w c2762w = this.f1155b;
        if (c2762w != null) {
            c2762w.m834i();
        }
    }
}
