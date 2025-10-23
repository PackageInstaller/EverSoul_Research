package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.VolleyLog;
import com.liapp.y;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    static class CacheHeader {
        public String etag;
        public String key;
        public long lastModified;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CacheHeader() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CacheHeader(String str, Cache.Entry entry) {
            this.key = str;
            this.size = entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.lastModified = entry.lastModified;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CacheHeader readHeader(InputStream inputStream) {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.readInt(inputStream) != DiskBasedCache.CACHE_MAGIC) {
                throw new IOException();
            }
            cacheHeader.key = DiskBasedCache.readString(inputStream);
            String readString = DiskBasedCache.readString(inputStream);
            cacheHeader.etag = readString;
            if (readString.equals("")) {
                cacheHeader.etag = null;
            }
            cacheHeader.serverDate = DiskBasedCache.readLong(inputStream);
            cacheHeader.lastModified = DiskBasedCache.readLong(inputStream);
            cacheHeader.ttl = DiskBasedCache.readLong(inputStream);
            cacheHeader.softTtl = DiskBasedCache.readLong(inputStream);
            cacheHeader.responseHeaders = DiskBasedCache.readStringStringMap(inputStream);
            return cacheHeader;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.lastModified = this.lastModified;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.key);
                String str = this.etag;
                if (str == null) {
                    str = "";
                }
                DiskBasedCache.writeString(outputStream, str);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.lastModified);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeStringStringMap(this.responseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.m62d("%s", e.toString());
                return false;
            }
        }
    }

    private static class CountingInputStream extends FilterInputStream {
        private int bytesRead;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.bytesRead = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.bytesRead++;
            }
            return read;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.bytesRead += read;
            }
            return read;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DiskBasedCache(File file) {
        this(file, DEFAULT_DISK_USAGE_BYTES);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DiskBasedCache(File file, int i) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void pruneIfNeeded(int i) {
        long j;
        long j2 = i;
        if (this.mTotalSize + j2 < this.mMaxCacheSizeInBytes) {
            return;
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.m65v(y.٬ݯح׭٩(576109742), new Object[0]);
        }
        long j3 = this.mTotalSize;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, CacheHeader>> it = this.mEntries.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            CacheHeader value = it.next().getValue();
            if (getFileForKey(value.key).delete()) {
                j = j2;
                this.mTotalSize -= value.size;
            } else {
                j = j2;
                String str = value.key;
                VolleyLog.m62d(y.٬ݯح׭٩(576109902), str, getFilenameForKey(str));
            }
            it.remove();
            i2++;
            if (this.mTotalSize + j < this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR) {
                break;
            } else {
                j2 = j;
            }
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.m65v(y.دײܮڳܯ(2051832157), Integer.valueOf(i2), Long.valueOf(this.mTotalSize - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void putEntry(String str, CacheHeader cacheHeader) {
        if (this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size - this.mEntries.get(str).size;
        } else {
            this.mTotalSize += cacheHeader.size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int read(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int readInt(InputStream inputStream) {
        return (read(inputStream) << 24) | (read(inputStream) << 0) | 0 | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long readLong(InputStream inputStream) {
        return ((read(inputStream) & 255) << 0) | 0 | ((read(inputStream) & 255) << 8) | ((read(inputStream) & 255) << 16) | ((read(inputStream) & 255) << 24) | ((read(inputStream) & 255) << 32) | ((read(inputStream) & 255) << 40) | ((read(inputStream) & 255) << 48) | ((255 & read(inputStream)) << 56);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String readString(InputStream inputStream) {
        return new String(streamToBytes(inputStream, (int) readLong(inputStream)), y.٬ݯح׭٩(576116366));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Map<String, String> readStringStringMap(InputStream inputStream) {
        int readInt = readInt(inputStream);
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < readInt; i++) {
            treeMap.put(readString(inputStream).intern(), readString(inputStream).intern());
        }
        return treeMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void removeEntry(String str) {
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.size;
            this.mEntries.remove(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] streamToBytes(InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return bArr;
            }
            throw new IOException(y.ٲٴݴ״ٰ(1781558056) + i + y.ݮڮֲڭܩ(-629063484) + i2 + y.ٲٴݴ״ٰ(1781557784));
        } catch (OutOfMemoryError unused) {
            throw new IOException(y.ٴسسݬߨ(1392866578) + i + y.ݮڮֲڭܩ(-629063236));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void writeInt(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void writeLong(OutputStream outputStream, long j) {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void writeString(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes(y.٬ݯح׭٩(576116366));
        writeLong(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) {
        if (map == null) {
            writeInt(outputStream, 0);
            return;
        }
        writeInt(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            writeString(outputStream, entry.getKey());
            writeString(outputStream, entry.getValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Cache
    public synchronized void clear() {
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0L;
        VolleyLog.m62d("Cache cleared.", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.android.volley.Cache.Entry get(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.Map<java.lang.String, com.android.volley.toolbox.DiskBasedCache$CacheHeader> r0 = r11.mEntries     // Catch: java.lang.Throwable -> L97
            java.lang.Object r0 = r0.get(r12)     // Catch: java.lang.Throwable -> L97
            com.android.volley.toolbox.DiskBasedCache$CacheHeader r0 = (com.android.volley.toolbox.DiskBasedCache.CacheHeader) r0     // Catch: java.lang.Throwable -> L97
            r1 = 0
            if (r0 != 0) goto Le
            monitor-exit(r11)
            return r1
        Le:
            java.io.File r2 = r11.getFileForKey(r12)     // Catch: java.lang.Throwable -> L97
            r3 = 1
            r4 = 0
            r5 = 2
            com.android.volley.toolbox.DiskBasedCache$CountingInputStream r6 = new com.android.volley.toolbox.DiskBasedCache$CountingInputStream     // Catch: java.lang.Throwable -> L47 java.lang.NegativeArraySizeException -> L4a java.io.IOException -> L6c
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L47 java.lang.NegativeArraySizeException -> L4a java.io.IOException -> L6c
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L47 java.lang.NegativeArraySizeException -> L4a java.io.IOException -> L6c
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L47 java.lang.NegativeArraySizeException -> L4a java.io.IOException -> L6c
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L47 java.lang.NegativeArraySizeException -> L4a java.io.IOException -> L6c
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L47 java.lang.NegativeArraySizeException -> L4a java.io.IOException -> L6c
            com.android.volley.toolbox.DiskBasedCache.CacheHeader.readHeader(r6)     // Catch: java.lang.Throwable -> L41 java.lang.NegativeArraySizeException -> L43 java.io.IOException -> L45
            long r7 = r2.length()     // Catch: java.lang.Throwable -> L41 java.lang.NegativeArraySizeException -> L43 java.io.IOException -> L45
            int r9 = com.android.volley.toolbox.DiskBasedCache.CountingInputStream.access$100(r6)     // Catch: java.lang.Throwable -> L41 java.lang.NegativeArraySizeException -> L43 java.io.IOException -> L45
            long r9 = (long) r9     // Catch: java.lang.Throwable -> L41 java.lang.NegativeArraySizeException -> L43 java.io.IOException -> L45
            long r7 = r7 - r9
            int r7 = (int) r7     // Catch: java.lang.Throwable -> L41 java.lang.NegativeArraySizeException -> L43 java.io.IOException -> L45
            byte[] r7 = streamToBytes(r6, r7)     // Catch: java.lang.Throwable -> L41 java.lang.NegativeArraySizeException -> L43 java.io.IOException -> L45
            com.android.volley.Cache$Entry r12 = r0.toCacheEntry(r7)     // Catch: java.lang.Throwable -> L41 java.lang.NegativeArraySizeException -> L43 java.io.IOException -> L45
            r6.close()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L97
            monitor-exit(r11)
            return r12
        L3f:
            monitor-exit(r11)
            return r1
        L41:
            r12 = move-exception
            goto L8e
        L43:
            r0 = move-exception
            goto L4c
        L45:
            r0 = move-exception
            goto L6e
        L47:
            r12 = move-exception
            r6 = r1
            goto L8e
        L4a:
            r0 = move-exception
            r6 = r1
        L4c:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L41
            r5[r4] = r2     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L41
            r5[r3] = r0     // Catch: java.lang.Throwable -> L41
            com.android.volley.VolleyLog.m62d(r7, r5)     // Catch: java.lang.Throwable -> L41
            r11.remove(r12)     // Catch: java.lang.Throwable -> L41
            if (r6 == 0) goto L6a
            r6.close()     // Catch: java.io.IOException -> L68 java.lang.Throwable -> L97
            goto L6a
        L68:
            monitor-exit(r11)
            return r1
        L6a:
            monitor-exit(r11)
            return r1
        L6c:
            r0 = move-exception
            r6 = r1
        L6e:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L41
            r5[r4] = r2     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L41
            r5[r3] = r0     // Catch: java.lang.Throwable -> L41
            com.android.volley.VolleyLog.m62d(r7, r5)     // Catch: java.lang.Throwable -> L41
            r11.remove(r12)     // Catch: java.lang.Throwable -> L41
            if (r6 == 0) goto L8c
            r6.close()     // Catch: java.io.IOException -> L8a java.lang.Throwable -> L97
            goto L8c
        L8a:
            monitor-exit(r11)
            return r1
        L8c:
            monitor-exit(r11)
            return r1
        L8e:
            if (r6 == 0) goto L96
            r6.close()     // Catch: java.io.IOException -> L94 java.lang.Throwable -> L97
            goto L96
        L94:
            monitor-exit(r11)
            return r1
        L96:
            throw r12     // Catch: java.lang.Throwable -> L97
        L97:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
            fill-array 0x009a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.get(java.lang.String):com.android.volley.Cache$Entry");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        if (!this.mRootDirectory.exists()) {
            if (!this.mRootDirectory.mkdirs()) {
                VolleyLog.m63e("Unable to create cache dir %s", this.mRootDirectory.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        CacheHeader readHeader = CacheHeader.readHeader(bufferedInputStream2);
                        readHeader.size = file.length();
                        putEntry(readHeader.key, readHeader);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        bufferedInputStream = bufferedInputStream2;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused4) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Cache
    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        pruneIfNeeded(entry.data.length);
        File fileForKey = getFileForKey(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileForKey));
            CacheHeader cacheHeader = new CacheHeader(str, entry);
            if (!cacheHeader.writeHeader(bufferedOutputStream)) {
                bufferedOutputStream.close();
                VolleyLog.m62d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(entry.data);
            bufferedOutputStream.close();
            putEntry(str, cacheHeader);
        } catch (IOException unused) {
            if (fileForKey.delete()) {
                return;
            }
            VolleyLog.m62d("Could not clean up file %s", fileForKey.getAbsolutePath());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Cache
    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        removeEntry(str);
        if (!delete) {
            VolleyLog.m62d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }
}
