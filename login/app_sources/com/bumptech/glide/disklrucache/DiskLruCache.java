package com.bumptech.glide.disklrucache;

import android.os.Build;
import android.os.StrictMode;
import com.liapp.y;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final File directory;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private long maxSize;
    private int redundantOpCount;
    private final int valueCount;
    private long size = 0;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());
    private final Callable<Void> cleanupCallable = new Callable<Void>() { // from class: com.bumptech.glide.disklrucache.DiskLruCache.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.journalWriter == null) {
                    return null;
                }
                DiskLruCache.this.trimToSize();
                if (DiskLruCache.this.journalRebuildRequired()) {
                    DiskLruCache.this.rebuildJournal();
                    DiskLruCache.this.redundantOpCount = 0;
                }
                return null;
            }
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DiskLruCache(File file, int i, int i2, long j) {
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, y.֬ڱܱײٮ(-1159271047));
        this.journalFileTmp = new File(file, y.ٲٴݴ״ٰ(1781772184));
        this.journalFileBackup = new File(file, y.ݮڮֲڭܩ(-628980572));
        this.valueCount = i2;
        this.maxSize = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, y.ݮڮֲڭܩ(-628980572));
        if (file2.exists()) {
            File file3 = new File(file, y.֬ڱܱײٮ(-1159271047));
            if (file3.exists()) {
                file2.delete();
            } else {
                renameTo(file2, file3, false);
            }
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
        if (diskLruCache.journalFile.exists()) {
            try {
                diskLruCache.readJournal();
                diskLruCache.processJournal();
                return diskLruCache;
            } catch (IOException e) {
                System.out.println(y.٬ݯح׭٩(576026070) + file + y.٬ݯح׭٩(576026222) + e.getMessage() + y.ٲٴݴ״ٰ(1781771712));
                diskLruCache.delete();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
        diskLruCache2.rebuildJournal();
        return diskLruCache2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void readJournal() throws IOException {
        String str = y.ݬֲ֮ܲت(1513068719);
        String str2 = y.ݮڮֲڭܩ(-628979964);
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            String readLine = strictLineReader.readLine();
            String readLine2 = strictLineReader.readLine();
            String readLine3 = strictLineReader.readLine();
            String readLine4 = strictLineReader.readLine();
            String readLine5 = strictLineReader.readLine();
            if (!MAGIC.equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.appVersion).equals(readLine3) || !Integer.toString(this.valueCount).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException(str2 + readLine + str + readLine2 + str + readLine4 + str + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(strictLineReader.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (strictLineReader.hasUnterminatedLine()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
                    }
                    Util.closeQuietly(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(strictLineReader);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void readJournalLine(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        String str2 = y.ۮڭڭܬި(862117467);
        if (indexOf == -1) {
            throw new IOException(str2 + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith(y.ݮڮֲڭܩ(-628967404))) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(y.ݬֲ֮ܲت(1513072415))) {
            String[] split = str.substring(indexOf2 + 1).split(y.دײܮڳܯ(2051829469));
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
            return;
        }
        if (indexOf2 != -1 || indexOf != 5 || !str.startsWith(y.ٲٴݴ״ٰ(1781765032))) {
            if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(y.ݬֲ֮ܲت(1513072495))) {
                throw new IOException(str2 + str);
            }
            return;
        }
        entry.currentEditor = new Editor(entry);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    deleteIfExists(next.getCleanFile(i));
                    deleteIfExists(next.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void rebuildJournal() throws IOException {
        Writer writer = this.journalWriter;
        if (writer != null) {
            closeWriter(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        try {
            bufferedWriter.write(MAGIC);
            bufferedWriter.write(StringUtils.f1524LF);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtils.f1524LF);
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write(StringUtils.f1524LF);
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write(StringUtils.f1524LF);
            bufferedWriter.write(StringUtils.f1524LF);
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    bufferedWriter.write("DIRTY " + entry.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                }
            }
            closeWriter(bufferedWriter);
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } catch (Throwable th) {
            closeWriter(bufferedWriter);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void renameTo(File file, File file2, boolean z) throws IOException {
        if (z) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Value get(String str) throws IOException {
        checkNotClosed();
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        for (File file : entry.cleanFiles) {
            if (!file.exists()) {
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append((CharSequence) READ);
        this.journalWriter.append(' ');
        this.journalWriter.append((CharSequence) str);
        this.journalWriter.append('\n');
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new Value(str, entry.sequenceNumber, entry.cleanFiles, entry.lengths);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Editor edit(String str, long j) throws IOException {
        checkNotClosed();
        Entry entry = this.lruEntries.get(str);
        if (j != -1 && (entry == null || entry.sequenceNumber != j)) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(str);
            this.lruEntries.put(str, entry);
        } else if (entry.currentEditor != null) {
            return null;
        }
        Editor editor = new Editor(entry);
        entry.currentEditor = editor;
        this.journalWriter.append((CharSequence) DIRTY);
        this.journalWriter.append(' ');
        this.journalWriter.append((CharSequence) str);
        this.journalWriter.append('\n');
        flushWriter(this.journalWriter);
        return editor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public File getDirectory() {
        return this.directory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executorService.submit(this.cleanupCallable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized long size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new IllegalStateException();
        }
        if (z && !entry.readable) {
            for (int i = 0; i < this.valueCount; i++) {
                if (!editor.written[i]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!entry.getDirtyFile(i).exists()) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            File dirtyFile = entry.getDirtyFile(i2);
            if (z) {
                if (dirtyFile.exists()) {
                    File cleanFile = entry.getCleanFile(i2);
                    dirtyFile.renameTo(cleanFile);
                    long j = entry.lengths[i2];
                    long length = cleanFile.length();
                    entry.lengths[i2] = length;
                    this.size = (this.size - j) + length;
                }
            } else {
                deleteIfExists(dirtyFile);
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable | z) {
            entry.readable = true;
            this.journalWriter.append((CharSequence) CLEAN);
            this.journalWriter.append(' ');
            this.journalWriter.append((CharSequence) entry.key);
            this.journalWriter.append((CharSequence) entry.getLengths());
            this.journalWriter.append('\n');
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.sequenceNumber = j2;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.append((CharSequence) REMOVE);
            this.journalWriter.append(' ');
            this.journalWriter.append((CharSequence) entry.key);
            this.journalWriter.append('\n');
        }
        flushWriter(this.journalWriter);
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean remove(String str) throws IOException {
        checkNotClosed();
        Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.currentEditor == null) {
            for (int i = 0; i < this.valueCount; i++) {
                File cleanFile = entry.getCleanFile(i);
                if (cleanFile.exists() && !cleanFile.delete()) {
                    throw new IOException("failed to delete " + cleanFile);
                }
                this.size -= entry.lengths[i];
                entry.lengths[i] = 0;
            }
            this.redundantOpCount++;
            this.journalWriter.append((CharSequence) REMOVE);
            this.journalWriter.append(' ');
            this.journalWriter.append((CharSequence) str);
            this.journalWriter.append('\n');
            this.lruEntries.remove(str);
            if (journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException(y.ݮڮֲڭܩ(-628980468));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        flushWriter(this.journalWriter);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.journalWriter == null) {
            return;
        }
        Iterator it = new ArrayList(this.lruEntries.values()).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (entry.currentEditor != null) {
                entry.currentEditor.abort();
            }
        }
        trimToSize();
        closeWriter(this.journalWriter);
        this.journalWriter = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void closeWriter(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void flushWriter(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final class Value {
        private final File[] files;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Value(String str, long j, File[] fileArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.lengths = jArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public File getFile(int i) {
            return this.files[i];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getString(int i) throws IOException {
            return DiskLruCache.inputStreamToString(new FileInputStream(this.files[i]));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getLength(int i) {
            return this.lengths[i];
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private final boolean[] written;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InputStream newInputStream(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    return null;
                }
                try {
                    return new FileInputStream(this.entry.getCleanFile(i));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getString(int i) throws IOException {
            InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return DiskLruCache.inputStreamToString(newInputStream);
            }
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public File getFile(int i) throws IOException {
            File dirtyFile;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                dirtyFile = this.entry.getDirtyFile(i);
                if (!DiskLruCache.this.directory.exists()) {
                    DiskLruCache.this.directory.mkdirs();
                }
            }
            return dirtyFile;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void set(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(getFile(i)), Util.UTF_8);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                Util.closeQuietly(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                Util.closeQuietly(outputStreamWriter2);
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void commit() throws IOException {
            DiskLruCache.this.completeEdit(this, true);
            this.committed = true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void abortUnlessCommitted() {
            if (this.committed) {
                return;
            }
            try {
                abort();
            } catch (IOException unused) {
            }
        }
    }

    private final class Entry {
        File[] cleanFiles;
        private Editor currentEditor;
        File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder append = new StringBuilder(str).append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = append.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                append.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, append.toString());
                append.append(y.ٲٴݴ״ٰ(1781770280));
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, append.toString());
                append.setLength(length);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getLengths() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.lengths) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException(y.ۮڭڭܬި(862117467) + Arrays.toString(strArr));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public File getCleanFile(int i) {
            return this.cleanFiles[i];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public File getDirtyFile(int i) {
            return this.dirtyFiles[i];
        }
    }

    private static final class DiskLruCacheThreadFactory implements ThreadFactory {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DiskLruCacheThreadFactory() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }
}
