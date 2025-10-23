package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.liapp.y;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class BaseDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NULL = " argument must be not null";
    private static final String TEMP_IMAGE_POSTFIX = ".tmp";
    protected int bufferSize;
    protected final File cacheDir;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    protected final File reserveCacheDir;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public void close() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BaseDiskCache(File file) {
        this(file, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BaseDiskCache(File file, File file2) {
        this(file, file2, DefaultConfigurationFactory.createFileNameGenerator());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BaseDiskCache(File file, File file2, FileNameGenerator fileNameGenerator) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        this.cacheDir = file;
        this.reserveCacheDir = file2;
        this.fileNameGenerator = fileNameGenerator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cacheDir;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public File get(String str) {
        return getFile(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) throws IOException {
        boolean z;
        File file = getFile(str);
        File file2 = new File(file.getAbsolutePath() + y.ٲٴݴ״ٰ(1781770280));
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), this.bufferSize);
            try {
                z = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
                try {
                    boolean z2 = (!z || file2.renameTo(file)) ? z : false;
                    if (!z2) {
                        file2.delete();
                    }
                    return z2;
                } catch (Throwable th) {
                    th = th;
                    if (!((!z || file2.renameTo(file)) ? z : false)) {
                        file2.delete();
                    }
                    throw th;
                }
            } finally {
                IoUtils.closeSilently(bufferedOutputStream);
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) throws IOException {
        File file = getFile(str);
        File file2 = new File(file.getAbsolutePath() + y.ٲٴݴ״ٰ(1781770280));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            IoUtils.closeSilently(bufferedOutputStream);
            if (compress && !file2.renameTo(file)) {
                compress = false;
            }
            if (!compress) {
                file2.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            IoUtils.closeSilently(bufferedOutputStream);
            file2.delete();
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        return getFile(str).delete();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public void clear() {
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected File getFile(String str) {
        File file;
        String generate = this.fileNameGenerator.generate(str);
        File file2 = this.cacheDir;
        if (!file2.exists() && !this.cacheDir.mkdirs() && (file = this.reserveCacheDir) != null && (file.exists() || this.reserveCacheDir.mkdirs())) {
            file2 = this.reserveCacheDir;
        }
        return new File(file2, generate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCompressQuality(int i) {
        this.compressQuality = i;
    }
}
