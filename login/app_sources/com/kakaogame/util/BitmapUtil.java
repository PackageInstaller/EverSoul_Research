package com.kakaogame.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakaogame.Logger;
import com.liapp.y;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BitmapUtil.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/util/BitmapUtil;", "", "()V", "TAG", "", "bitmapToByteArray", "", "bitmap", "Landroid/graphics/Bitmap;", "convertBitmapFromView", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "convertStreamToBitmap", "is", "Ljava/io/InputStream;", "getByteSize", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class BitmapUtil {
    public static final BitmapUtil INSTANCE = new BitmapUtil();
    private static final String TAG = "BitmapUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BitmapUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int getByteSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] bitmapToByteArray(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, y.֬ڱܱײٮ(-1159127543));
        ByteBuffer allocate = ByteBuffer.allocate(getByteSize(bitmap));
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        Intrinsics.checkNotNullExpressionValue(array, y.دײܮڳܯ(2051031301));
        return array;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bitmap convertBitmapFromView(View view) {
        if (view == null || view.getMeasuredHeight() > 0) {
            return null;
        }
        view.measure(-2, -2);
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, y.֬ڱܱײٮ(-1159153303));
        Canvas canvas = new Canvas(createBitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return createBitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bitmap convertStreamToBitmap(InputStream is) {
        if (is == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeStream(is);
        } catch (Throwable th) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159127319), th.toString(), th);
            return null;
        }
    }
}
