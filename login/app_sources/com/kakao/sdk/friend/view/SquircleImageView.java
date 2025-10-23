package com.kakao.sdk.friend.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p024m.C2220w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0012"}, m839d2 = {"Lcom/kakao/sdk/friend/view/SquircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", TypedValues.Custom.S_COLOR, "", "setBorderColor", "setFillColor", "", "getDensity", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class SquircleImageView extends AppCompatImageView {

    /* renamed from: a */
    public Paint f1034a;

    /* renamed from: b */
    public Paint f1035b;

    /* renamed from: c */
    public final Path f1036c;

    /* renamed from: d */
    public final Path f1037d;

    /* renamed from: e */
    public final Path f1038e;

    /* renamed from: f */
    public float f1039f;

    /* renamed from: g */
    public int f1040g;

    /* renamed from: h */
    public Paint f1041h;

    /* renamed from: i */
    public int f1042i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SquircleImageView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SquircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SquircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1034a = new Paint();
        this.f1035b = new Paint();
        this.f1036c = new Path();
        this.f1037d = new Path();
        this.f1038e = new Path();
        this.f1039f = 0.5f;
        this.f1041h = new Paint();
        m689a(attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m689a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C2110R.styleable.SquircleBorderImageView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….SquircleBorderImageView)");
            this.f1040g = obtainStyledAttributes.getColor(C2110R.styleable.SquircleBorderImageView_squircle_fillColor, 0);
            this.f1042i = obtainStyledAttributes.getColor(C2110R.styleable.SquircleBorderImageView_squircle_borderColor, 0);
            this.f1039f = obtainStyledAttributes.getDimension(C2110R.styleable.SquircleBorderImageView_squircle_borderWidth, this.f1039f);
            obtainStyledAttributes.recycle();
        }
        if (this.f1040g != 0) {
            Paint paint = this.f1041h;
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(this.f1040g);
        }
        Paint paint2 = this.f1034a;
        paint2.setAntiAlias(true);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setXfermode(new PorterDuffXfermode(Build.VERSION.SDK_INT < 28 ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.DST_OUT));
        Paint paint3 = this.f1035b;
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.STROKE);
        int i = this.f1042i;
        if (i == 0) {
            i = ContextCompat.getColor(getContext(), C2110R.color.daynight_gray150a);
        }
        paint3.setColor(i);
        this.f1035b.setStrokeWidth(this.f1039f * getDensity());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float getDensity() {
        return getContext().getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int width = getWidth();
        int height = getHeight();
        if (this.f1040g != 0) {
            canvas.drawPath(this.f1037d, this.f1041h);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, width, height, null);
        super.onDraw(canvas);
        canvas.drawPath(this.f1036c, this.f1034a);
        canvas.restoreToCount(saveLayer);
        canvas.drawPath(this.f1038e, this.f1035b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setBorderColor(int color) {
        this.f1042i = color;
        this.f1035b.setColor(color);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setFillColor(int color) {
        this.f1040g = color;
        this.f1041h.setColor(color);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i == 0 || i2 == 0) {
            return;
        }
        Path m598a = C2220w.m598a(0);
        Path path = this.f1036c;
        path.reset();
        path.set(m598a);
        Path path2 = this.f1038e;
        path2.reset();
        path2.set(m598a);
        if (this.f1040g != 0) {
            Path path3 = this.f1037d;
            path3.reset();
            path3.set(m598a);
        }
        float f = i;
        float f2 = i2;
        C2220w.m599a(this.f1036c, f, f2, 0.0f);
        if (this.f1040g != 0) {
            C2220w.m599a(this.f1037d, f, f2, 0.0f);
        }
        float density = this.f1039f * getDensity();
        C2220w.m599a(this.f1038e, f - density, f2 - density, density / 2.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1036c.setFillType(Path.FillType.EVEN_ODD);
            this.f1036c.addRect(new RectF(0.0f, 0.0f, f, f2), Path.Direction.CW);
        }
    }
}
