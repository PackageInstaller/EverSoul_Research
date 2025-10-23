package com.nostra13.universalimageloader.cache.disc.impl.ext;

import com.liapp.y;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
final class DiskLruCache implements Closeable {
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
    private int maxFileCount;
    private long maxSize;
    private int redundantOpCount;
    private final int valueCount;
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile(y.ݮڮֲڭܩ(-628224540));
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() { // from class: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private long size = 0;
    private int fileCount = 0;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> cleanupCallable = new Callable<Void>() { // from class: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.journalWriter == null) {
                    return null;
                }
                DiskLruCache.this.trimToSize();
                DiskLruCache.this.trimToFileCount();
                if (DiskLruCache.this.journalRebuildRequired()) {
                    DiskLruCache.this.rebuildJournal();
                    DiskLruCache.this.redundantOpCount = 0;
                }
                return null;
            }
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DiskLruCache(File file, int i, int i2, long j, int i3) {
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, y.֬ڱܱײٮ(-1159271047));
        this.journalFileTmp = new File(file, y.ٲٴݴ״ٰ(1781772184));
        this.journalFileBackup = new File(file, y.ݮڮֲڭܩ(-628980572));
        this.valueCount = i2;
        this.maxSize = j;
        this.maxFileCount = i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DiskLruCache open(File file, int i, int i2, long j, int i3) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
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
        DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j, i3);
        if (diskLruCache.journalFile.exists()) {
            try {
                diskLruCache.readJournal();
                diskLruCache.processJournal();
                diskLruCache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.journalFile, true), Util.US_ASCII));
                return diskLruCache;
            } catch (IOException e) {
                System.out.println(y.٬ݯح׭٩(576026070) + file + y.٬ݯح׭٩(576026222) + e.getMessage() + y.ٲٴݴ״ٰ(1781771712));
                diskLruCache.delete();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j, i3);
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
                    this.fileCount++;
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
            writer.close();
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
            bufferedWriter.close();
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } catch (Throwable th) {
            bufferedWriter.close();
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
    public synchronized Snapshot get(String str) throws IOException {
        InputStream inputStream;
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        int i = this.valueCount;
        File[] fileArr = new File[i];
        InputStream[] inputStreamArr = new InputStream[i];
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            try {
                File cleanFile = entry.getCleanFile(i2);
                fileArr[i2] = cleanFile;
                inputStreamArr[i2] = new FileInputStream(cleanFile);
            } catch (FileNotFoundException unused) {
                for (int i3 = 0; i3 < this.valueCount && (inputStream = inputStreamArr[i3]) != null; i3++) {
                    Util.closeQuietly(inputStream);
                }
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append((CharSequence) ("READ " + str + '\n'));
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new Snapshot(str, entry.sequenceNumber, fileArr, inputStreamArr, entry.lengths);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Editor edit(String str, long j) throws IOException {
        String str2 = y.֬ڱܱײٮ(-1159043207);
        synchronized (this) {
            checkNotClosed();
            validateKey(str);
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
            this.journalWriter.write(str2 + str + '\n');
            this.journalWriter.flush();
            return editor;
        }
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
    public synchronized int getMaxFileCount() {
        return this.maxFileCount;
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized long fileCount() {
        return this.fileCount;
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
                    this.fileCount++;
                }
            } else {
                deleteIfExists(dirtyFile);
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable | z) {
            entry.readable = true;
            this.journalWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.sequenceNumber = j2;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.write("REMOVE " + entry.key + '\n');
        }
        this.journalWriter.flush();
        if (this.size > this.maxSize || this.fileCount > this.maxFileCount || journalRebuildRequired()) {
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
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.currentEditor == null) {
            for (int i = 0; i < this.valueCount; i++) {
                File cleanFile = entry.getCleanFile(i);
                if (cleanFile.exists() && !cleanFile.delete()) {
                    throw new IOException("failed to delete " + cleanFile);
                }
                this.size -= entry.lengths[i];
                this.fileCount--;
                entry.lengths[i] = 0;
            }
            this.redundantOpCount++;
            this.journalWriter.append((CharSequence) ("REMOVE " + str + '\n'));
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
        trimToFileCount();
        this.journalWriter.flush();
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
        trimToFileCount();
        this.journalWriter.close();
        this.journalWriter = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void trimToFileCount() throws IOException {
        while (this.fileCount > this.maxFileCount) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1393179354) + str + y.دײܮڳܯ(2051949821));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }

    public final class Snapshot implements Closeable {
        private File[] files;
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Snapshot(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.ins = inputStreamArr;
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
        public InputStream getInputStream(int i) {
            return this.ins[i];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getString(int i) throws IOException {
            return DiskLruCache.inputStreamToString(getInputStream(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getLength(int i) {
            return this.lengths[i];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.ins) {
                Util.closeQuietly(inputStream);
            }
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        private final boolean[] written;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InputStream newInputStream(int i) throws IOException {
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
        public OutputStream newOutputStream(int i) throws IOException {
            FileOutputStream fileOutputStream;
            FaultHidingOutputStream faultHidingOutputStream;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                File dirtyFile = this.entry.getDirtyFile(i);
                try {
                    fileOutputStream = new FileOutputStream(dirtyFile);
                } catch (FileNotFoundException unused) {
                    DiskLruCache.this.directory.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException unused2) {
                        return DiskLruCache.NULL_OUTPUT_STREAM;
                    }
                }
                faultHidingOutputStream = new FaultHidingOutputStream(fileOutputStream);
            }
            return faultHidingOutputStream;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void set(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(newOutputStream(i), Util.UTF_8);
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
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.completeEdit(this, true);
            }
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

        private class FaultHidingOutputStream extends FilterOutputStream {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }
        }
    }

    private final class Entry {
        private Editor currentEditor;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
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
            return new File(DiskLruCache.this.directory, this.key + "" + i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public File getDirtyFile(int i) {
            return new File(DiskLruCache.this.directory, this.key + "" + i + y.ٲٴݴ״ٰ(1781770280));
        }
    }
}
