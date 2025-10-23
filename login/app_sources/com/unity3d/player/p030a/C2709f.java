package com.unity3d.player.p030a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;

/* renamed from: com.unity3d.player.a.f */
/* loaded from: classes3.dex */
public final class C2709f extends View {

    /* renamed from: a */
    final int f1304a;

    /* renamed from: b */
    final int f1305b;

    /* renamed from: c */
    int f1306c;

    /* renamed from: d */
    Bitmap f1307d;

    /* renamed from: e */
    Bitmap f1308e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2709f(Context context, int i) {
        super(context);
        this.f1306c = ViewCompat.MEASURED_STATE_MASK;
        this.f1304a = i;
        int identifier = getResources().getIdentifier("unity_static_splash", "drawable", getContext().getPackageName());
        this.f1305b = identifier;
        if (identifier != 0) {
            forceLayout();
        }
        int identifier2 = getResources().getIdentifier("staticSplashScreenBackgroundColor", TypedValues.Custom.S_COLOR, getContext().getPackageName());
        if (identifier2 != 0) {
            this.f1306c = getResources().getColor(identifier2);
        }
        setBackgroundColor(this.f1306c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f1307d;
        if (bitmap != null) {
            bitmap.recycle();
            this.f1307d = null;
        }
        Bitmap bitmap2 = this.f1308e;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f1308e = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0068, code lost:
    
        if (r12 < r10) goto L31;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            int r8 = r7.f1305b
            if (r8 != 0) goto L5
            return
        L5:
            android.graphics.Bitmap r8 = r7.f1307d
            r9 = 0
            if (r8 != 0) goto L1d
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options
            r8.<init>()
            r8.inScaled = r9
            android.content.res.Resources r10 = r7.getResources()
            int r11 = r7.f1305b
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeResource(r10, r11, r8)
            r7.f1307d = r8
        L1d:
            android.graphics.Bitmap r8 = r7.f1307d
            int r8 = r8.getWidth()
            android.graphics.Bitmap r10 = r7.f1307d
            int r10 = r10.getHeight()
            int r11 = r7.getWidth()
            int r12 = r7.getHeight()
            if (r11 == 0) goto Lc6
            if (r12 != 0) goto L37
            goto Lc6
        L37:
            float r0 = (float) r8
            float r1 = (float) r10
            float r0 = r0 / r1
            float r1 = (float) r11
            float r2 = (float) r12
            float r3 = r1 / r2
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            r4 = 1
            if (r3 > 0) goto L45
            r3 = r4
            goto L46
        L45:
            r3 = r9
        L46:
            int r5 = r7.f1304a
            int r5 = com.unity3d.player.p030a.AbstractC2704a.m773a(r5)
            r6 = 2
            if (r5 == 0) goto L63
            if (r5 == r4) goto L54
            if (r5 == r6) goto L54
            goto L6d
        L54:
            int r8 = r7.f1304a
            r10 = 3
            if (r8 != r10) goto L5b
            r8 = r4
            goto L5c
        L5b:
            r8 = r9
        L5c:
            r8 = r8 ^ r3
            if (r8 == 0) goto L6a
            float r1 = r1 / r0
            int r10 = (int) r1
            r8 = r11
            goto L6d
        L63:
            if (r11 >= r8) goto L68
            float r1 = r1 / r0
            int r10 = (int) r1
            r8 = r11
        L68:
            if (r12 >= r10) goto L6d
        L6a:
            float r2 = r2 * r0
            int r8 = (int) r2
            r10 = r12
        L6d:
            android.graphics.Bitmap r11 = r7.f1308e
            if (r11 == 0) goto L8c
            int r11 = r11.getWidth()
            if (r11 != r8) goto L80
            android.graphics.Bitmap r11 = r7.f1308e
            int r11 = r11.getHeight()
            if (r11 != r10) goto L80
            return
        L80:
            android.graphics.Bitmap r11 = r7.f1308e
            android.graphics.Bitmap r12 = r7.f1307d
            if (r11 == r12) goto L8c
            r11.recycle()
            r11 = 0
            r7.f1308e = r11
        L8c:
            android.graphics.Bitmap r11 = r7.f1307d
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createScaledBitmap(r11, r8, r10, r4)
            r7.f1308e = r8
            android.content.res.Resources r10 = r7.getResources()
            android.util.DisplayMetrics r10 = r10.getDisplayMetrics()
            int r10 = r10.densityDpi
            r8.setDensity(r10)
            android.graphics.drawable.ColorDrawable r8 = new android.graphics.drawable.ColorDrawable
            int r10 = r7.f1306c
            r8.<init>(r10)
            android.graphics.drawable.BitmapDrawable r10 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r11 = r7.getResources()
            android.graphics.Bitmap r12 = r7.f1308e
            r10.<init>(r11, r12)
            r11 = 17
            r10.setGravity(r11)
            android.graphics.drawable.LayerDrawable r11 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r12 = new android.graphics.drawable.Drawable[r6]
            r12[r9] = r8
            r12[r4] = r10
            r11.<init>(r12)
            r7.setBackground(r11)
        Lc6:
            return
            fill-array 0x00c8: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.p030a.C2709f.onLayout(boolean, int, int, int, int):void");
    }
}
