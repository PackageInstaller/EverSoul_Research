package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class SizeConfigStrategy implements LruPoolStrategy {
    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS;
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS;
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] RGBA_F16_IN_CONFIGS;
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS;
    private final KeyPool keyPool = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        ARGB_8888_IN_CONFIGS = configArr;
        RGBA_F16_IN_CONFIGS = configArr;
        RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.groupedMap.put(key, bitmap);
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num = (Integer) sizesForConfig.get(Integer.valueOf(key.size));
        sizesForConfig.put(Integer.valueOf(key.size), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Key findBestKey = findBestKey(Util.getBitmapByteSize(i, i2, config), config);
        Bitmap bitmap = this.groupedMap.get(findBestKey);
        if (bitmap != null) {
            decrementBitmapOfSize(Integer.valueOf(findBestKey.size), bitmap);
            bitmap.reconfigure(i, i2, config);
        }
        return bitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Key findBestKey(int i, Bitmap.Config config) {
        Key key = this.keyPool.get(i, config);
        for (Bitmap.Config config2 : getInConfigs(config)) {
            Integer ceilingKey = getSizesForConfig(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return key;
                        }
                    } else if (config2.equals(config)) {
                        return key;
                    }
                }
                this.keyPool.offer(key);
                return this.keyPool.get(ceilingKey.intValue(), config2);
            }
        }
        return key;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(removeLast)), removeLast);
        }
        return removeLast;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void decrementBitmapOfSize(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num2 = (Integer) sizesForConfig.get(num);
        if (num2 == null) {
            throw new NullPointerException(y.֬ڱܱײٮ(-1159295743) + num + y.֬ڱܱײٮ(-1159299327) + logBitmap(bitmap) + ", this: " + this);
        }
        if (num2.intValue() == 1) {
            sizesForConfig.remove(num);
        } else {
            sizesForConfig.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(config, treeMap);
        return treeMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return getBitmapString(Util.getBitmapByteSize(i, i2, config), config);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder().append(y.ٲٴݴ״ٰ(1781743056)).append(this.groupedMap).append(y.ۮڭڭܬި(862079731));
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.sortedSizes.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append(y.ݬֲ֮ܲت(1513035735));
        }
        if (!this.sortedSizes.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        return append.append(y.֬ڱܱײٮ(-1159306935)).toString();
    }

    static class KeyPool extends BaseKeyPool<Key> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        KeyPool() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Key get(int i, Bitmap.Config config) {
            Key key = get();
            key.init(i, config);
            return key;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    static final class Key implements Poolable {
        private Bitmap.Config config;
        private final KeyPool pool;
        int size;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Key(KeyPool keyPool, int i, Bitmap.Config config) {
            this(keyPool);
            init(i, config);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void init(int i, Bitmap.Config config) {
            this.size = i;
            this.config = config;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.size, this.config);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.size == key.size && Util.bothNullOrEqual(this.config, key.config);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            int i = this.size * 31;
            Bitmap.Config config = this.config;
            return i + (config != null ? config.hashCode() : 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getBitmapString(int i, Bitmap.Config config) {
        return y.ٴسسݬߨ(1392956562) + i + y.ݬֲ֮ܲت(1513031999) + config + ")";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Bitmap.Config[] getInConfigs(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return RGBA_F16_IN_CONFIGS;
        }
        int i = C07471.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1) {
            return ARGB_8888_IN_CONFIGS;
        }
        if (i == 2) {
            return RGB_565_IN_CONFIGS;
        }
        if (i != 3) {
            return i != 4 ? new Bitmap.Config[]{config} : ALPHA_8_IN_CONFIGS;
        }
        return ARGB_4444_IN_CONFIGS;
    }

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1 */
    static /* synthetic */ class C07471 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
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
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
