package com.kakao.sdk.friend.p024m;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.SparseArray;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.m.w */
/* loaded from: classes3.dex */
public final class C2220w {

    /* renamed from: a */
    public static final SparseArray<Path> f914a = new SparseArray<>();

    /* renamed from: b */
    public static final PointF[] f915b = {new PointF(5.0295334f, 29.660559f), new PointF(7.855174f, 27.023523f), new PointF(9.0f, 22.659832f), new PointF(9.0f, 16.0f), new PointF(9.0f, 9.340168f), new PointF(7.855174f, 4.9764776f), new PointF(5.0295334f, 2.3394415f), new PointF(7.543037f, 0.6952579f), new PointF(11.115303f, 0.0f), new PointF(16.0f, 0.0f), new PointF(27.884445f, 0.0f), new PointF(32.0f, 4.115556f), new PointF(32.0f, 16.0f), new PointF(32.0f, 27.884445f), new PointF(27.884445f, 32.0f), new PointF(16.0f, 32.0f), new PointF(11.115303f, 32.0f), new PointF(7.543037f, 31.304743f), new PointF(5.0295334f, 29.660559f)};

    /* renamed from: c */
    public static final PointF[] f916c = {new PointF(383.816f, 206.345f), new PointF(270.335f, 215.99f), new PointF(215.891f, 271.217f), new PointF(206.341f, 383.816f), new PointF(201.668f, 383.939f), new PointF(196.888f, 383.999f), new PointF(192.0f, 383.999f), new PointF(50.667f, 383.999f), new PointF(0.0f, 333.332f), new PointF(0.0f, 191.999f), new PointF(0.0f, 55.999f), new PointF(50.6667f, -0.001f), new PointF(192.0f, -0.001f), new PointF(333.333f, -0.001f), new PointF(384.0f, 50.6657f), new PointF(384.0f, 191.999f), new PointF(384.0f, 196.889f), new PointF(383.939f, 201.67f), new PointF(383.816f, 206.344f)};

    /* renamed from: d */
    public static final PointF[] f917d = {new PointF(189.123f, 0.0f), new PointF(221.469f, 38.9616f), new PointF(273.006f, 58.1043f), new PointF(347.337f, 61.0344f), new PointF(330.268f, 94.6682f), new PointF(322.234f, 138.05f), new PointF(322.234f, 191.997f), new PointF(322.234f, 250.41f), new PointF(330.997f, 296.041f), new PointF(350.0f, 330.369f), new PointF(320.604f, 368.401f), new PointF(270.148f, 384.001f), new PointF(191.806f, 384.001f), new PointF(50.616f, 384.001f), new PointF(0.0f, 333.333f), new PointF(0.0f, 191.998f), new PointF(0.0f, 56.86f), new PointF(49.9738f, 0.71f), new PointF(189.123f, 0.001f)};

    /* renamed from: e */
    public static final PointF[] f918e = {new PointF(384.0f, 191.997f)};

    /* renamed from: f */
    public static final PointF[] f919f = {new PointF(194.686f, 0.0f), new PointF(333.976f, 0.642036f), new PointF(384.0f, 51.5603f), new PointF(384.0f, 191.997f), new PointF(384.0f, 333.333f), new PointF(333.333f, 384.0f), new PointF(192.0f, 384.0f), new PointF(50.667f, 384.0f), new PointF(0.0f, 333.333f), new PointF(0.0f, 191.997f), new PointF(0.0f, 134.912f), new PointF(8.92644f, 91.921f), new PointF(29.7373f, 61.25f), new PointF(107.69f, 59.2053f), new PointF(161.362f, 40.0991f), new PointF(194.686f, -2.0E-4f)};

    /* renamed from: g */
    public static final PointF[] f920g = {new PointF(270.0f, 540.0f), new PointF(71.251f, 540.0f), new PointF(0.0f, 468.754f), new PointF(0.0f, 270.0f), new PointF(0.0f, 71.2511f), new PointF(71.2511f, 0.0f), new PointF(270.0f, 0.0f), new PointF(468.754f, 0.0f), new PointF(540.0f, 71.2511f), new PointF(540.0f, 270.0f), new PointF(540.0f, 468.754f), new PointF(468.754f, 540.0f), new PointF(270.0f, 540.0f)};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: a */
    public static final Path m599a(Path path, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(path, "path");
        RectF rectF = new RectF();
        Matrix matrix = new Matrix();
        float min = Math.min(f, f2);
        path.computeBounds(rectF, true);
        float f4 = 100;
        matrix.setScale(((min / rectF.width()) * f4) / 100.0f, ((min / rectF.height()) * f4) / 100.0f);
        matrix.postTranslate(f3, f3);
        path.transform(matrix);
        return path;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: a */
    public static final Path m598a(int i) {
        PointF[] pointFArr;
        SparseArray<Path> sparseArray = f914a;
        Path path = sparseArray.get(i);
        if (path == null) {
            int i2 = 1;
            if (i == 1) {
                pointFArr = f916c;
            } else if (i == 2) {
                pointFArr = f917d;
            } else if (i != 3) {
                pointFArr = i != 4 ? f920g : f915b;
            } else {
                pointFArr = f919f;
            }
            Path path2 = new Path();
            path2.moveTo(pointFArr[0].x, pointFArr[0].y);
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(1, ArraysKt.getLastIndex(pointFArr), 3);
            if (1 <= progressionLastElement) {
                while (true) {
                    int i3 = i2 + 3;
                    PointF pointF = pointFArr[i2];
                    PointF pointF2 = pointFArr[i2 + 1];
                    PointF pointF3 = pointFArr[i2 + 2];
                    path2.cubicTo(pointF.x, pointF.y, pointF2.x, pointF2.y, pointF3.x, pointF3.y);
                    if (i2 == progressionLastElement) {
                        break;
                    }
                    i2 = i3;
                }
            }
            if (i == 2) {
                PointF[] pointFArr2 = f918e;
                path2.moveTo(pointFArr2[0].x, pointFArr2[0].y);
                path2.lineTo(pointFArr2[0].x, pointFArr2[0].y);
            }
            if (i == 4) {
                path2.moveTo(0.0f, 16.0f);
                path2.lineTo(0.0f, 16.0f);
            }
            path2.close();
            sparseArray.put(i, path2);
            path = path2;
        }
        return path;
    }
}
