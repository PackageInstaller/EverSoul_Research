package com.kakaogame.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewUtil.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/util/ViewUtil;", "", "()V", "convertViewToDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "recycle", "", "iv", "Landroid/widget/ImageView;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ViewUtil {
    public static final ViewUtil INSTANCE = new ViewUtil();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ViewUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Drawable convertViewToDrawable(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(view, y.ٲٴݴ״ٰ(1782079424));
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        Intrinsics.checkNotNullExpressionValue(createBitmap, y.֬ڱܱײٮ(-1159153303));
        view.setDrawingCacheEnabled(false);
        return new BitmapDrawable(context.getResources(), createBitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void recycle(ImageView iv) {
        Bitmap bitmap;
        if (iv == null) {
            return;
        }
        Drawable drawable = iv.getDrawable();
        if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmap.recycle();
        }
        iv.setImageBitmap(null);
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }
}
