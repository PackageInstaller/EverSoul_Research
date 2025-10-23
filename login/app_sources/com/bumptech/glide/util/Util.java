package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import com.liapp.y;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public final class Util {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 31;
    private static final char[] HEX_CHAR_ARRAY = y.ݬֲ֮ܲت(1512968423).toCharArray();
    private static final char[] SHA_256_CHARS = new char[64];

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(int i, int i2) {
        return (i2 * 31) + i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isValidDimension(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Util() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String sha256BytesToHex(byte[] bArr) {
        String bytesToHex;
        char[] cArr = SHA_256_CHARS;
        synchronized (cArr) {
            bytesToHex = bytesToHex(bArr, cArr);
        }
        return bytesToHex;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String bytesToHex(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = HEX_CHAR_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static int getSize(Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getBitmapByteSize(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalStateException(y.ٲٴݴ״ٰ(1781671960) + bitmap + y.ٴسسݬߨ(1392956562) + bitmap.getWidth() + y.ٴسسݬߨ(1392956602) + bitmap.getHeight() + y.٬ݯح׭٩(576045974) + bitmap.getConfig());
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getBitmapByteSize(int i, int i2, Bitmap.Config config) {
        return i * i2 * getBytesPerPixel(config);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getBytesPerPixel(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = C07801.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    /* renamed from: com.bumptech.glide.util.Util$1 */
    static /* synthetic */ class C07801 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isValidDimensions(int i, int i2) {
        return isValidDimension(i) && isValidDimension(i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void assertMainThread() {
        if (!isOnMainThread()) {
            throw new IllegalArgumentException(y.ݮڮֲڭܩ(-628948532));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void assertBackgroundThread() {
        if (!isOnBackgroundThread()) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781672728));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Queue<T> createQueue(int i) {
        return new ArrayDeque(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> List<T> getSnapshot(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean bothNullOrEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean bothModelsNullEquivalentOrEquals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof Model) {
            return ((Model) obj).isEquivalentTo(obj2);
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(int i) {
        return hashCode(i, 17);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(float f) {
        return hashCode(f, 17);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(float f, int i) {
        return hashCode(Float.floatToIntBits(f), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(Object obj, int i) {
        return hashCode(obj == null ? 0 : obj.hashCode(), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(boolean z, int i) {
        return hashCode(z ? 1 : 0, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(boolean z) {
        return hashCode(z, 17);
    }
}
