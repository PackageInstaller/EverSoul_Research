package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: com.unity3d.player.J */
/* loaded from: classes3.dex */
final class PixelCopyOnPixelCopyFinishedListenerC2669J extends View implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a */
    Bitmap f1180a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PixelCopyOnPixelCopyFinishedListenerC2669J(Context context) {
        super(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m734a(SurfaceView surfaceView) {
        Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        this.f1180a = createBitmap;
        PixelCopy.request(surfaceView, createBitmap, this, new Handler(Looper.getMainLooper()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        if (i == 0) {
            setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(ViewCompat.MEASURED_STATE_MASK), new BitmapDrawable(getResources(), this.f1180a)}));
        }
    }
}
