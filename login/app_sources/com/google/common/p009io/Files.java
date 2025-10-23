package com.google.common.p009io;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.singular.sdk.internal.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Files {
    private static final SuccessorsFunction<File> FILE_TREE = new SuccessorsFunction<File>() { // from class: com.google.common.io.Files.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Iterable<File> successors(File file) {
            File[] listFiles;
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                return Collections.unmodifiableList(Arrays.asList(listFiles));
            }
            return ImmutableList.m215of();
        }
    };
    private static final int TEMP_DIR_ATTEMPTS = 10000;

    private enum FilePredicate implements Predicate<File> {
        IS_DIRECTORY { // from class: com.google.common.io.Files.FilePredicate.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public String toString() {
                return "Files.isDirectory()";
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Predicate
            public boolean apply(File file) {
                return file.isDirectory();
            }
        },
        IS_FILE { // from class: com.google.common.io.Files.FilePredicate.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public String toString() {
                return "Files.isFile()";
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Predicate
            public boolean apply(File file) {
                return file.isFile();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Files() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BufferedReader newReader(File file, Charset charset) throws FileNotFoundException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BufferedWriter newWriter(File file, Charset charset) throws FileNotFoundException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteSource asByteSource(File file) {
        return new FileByteSource(file);
    }

    private static final class FileByteSource extends ByteSource {
        private final File file;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FileByteSource(File file) {
            this.file = (File) Preconditions.checkNotNull(file);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.ByteSource
        public FileInputStream openStream() throws IOException {
            return new FileInputStream(this.file);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.ByteSource
        public Optional<Long> sizeIfKnown() {
            if (this.file.isFile()) {
                return Optional.m188of(Long.valueOf(this.file.length()));
            }
            return Optional.absent();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.ByteSource
        public long size() throws IOException {
            if (!this.file.isFile()) {
                throw new FileNotFoundException(this.file.toString());
            }
            return this.file.length();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.ByteSource
        public byte[] read() throws IOException {
            try {
                FileInputStream fileInputStream = (FileInputStream) Closer.create().register(openStream());
                return ByteStreams.toByteArray(fileInputStream, fileInputStream.getChannel().size());
            } finally {
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.file);
            return new StringBuilder(String.valueOf(valueOf).length() + 20).append("Files.asByteSource(").append(valueOf).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteSink asByteSink(File file, FileWriteMode... fileWriteModeArr) {
        return new FileByteSink(file, fileWriteModeArr);
    }

    private static final class FileByteSink extends ByteSink {
        private final File file;
        private final ImmutableSet<FileWriteMode> modes;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FileByteSink(File file, FileWriteMode... fileWriteModeArr) {
            this.file = (File) Preconditions.checkNotNull(file);
            this.modes = ImmutableSet.copyOf(fileWriteModeArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.ByteSink
        public FileOutputStream openStream() throws IOException {
            return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.file);
            String valueOf2 = String.valueOf(this.modes);
            return new StringBuilder(String.valueOf(valueOf).length() + 20 + String.valueOf(valueOf2).length()).append("Files.asByteSink(").append(valueOf).append(", ").append(valueOf2).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSource asCharSource(File file, Charset charset) {
        return asByteSource(file).asCharSource(charset);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSink asCharSink(File file, Charset charset, FileWriteMode... fileWriteModeArr) {
        return asByteSink(file, fileWriteModeArr).asCharSink(charset);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] toByteArray(File file) throws IOException {
        return asByteSource(file).read();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static String toString(File file, Charset charset) throws IOException {
        return asCharSource(file, charset).read();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void write(byte[] bArr, File file) throws IOException {
        asByteSink(file, new FileWriteMode[0]).write(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void write(CharSequence charSequence, File file, Charset charset) throws IOException {
        asCharSink(file, charset, new FileWriteMode[0]).write(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void copy(File file, OutputStream outputStream) throws IOException {
        asByteSource(file).copyTo(outputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void copy(File file, File file2) throws IOException {
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        asByteSource(file).copyTo(asByteSink(file2, new FileWriteMode[0]));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void copy(File file, Charset charset, Appendable appendable) throws IOException {
        asCharSource(file, charset).copyTo(appendable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void append(CharSequence charSequence, File file, Charset charset) throws IOException {
        asCharSink(file, charset, FileWriteMode.APPEND).write(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean equal(File file, File file2) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return asByteSource(file).contentEquals(asByteSource(file2));
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static File createTempDir() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        String sb = new StringBuilder(21).append(System.currentTimeMillis()).append("-").toString();
        for (int i = 0; i < 10000; i++) {
            File file2 = new File(file, new StringBuilder(String.valueOf(sb).length() + 11).append(sb).append(i).toString());
            if (file2.mkdir()) {
                return file2;
            }
        }
        throw new IllegalStateException(new StringBuilder(String.valueOf(sb).length() + 66 + String.valueOf(sb).length()).append("Failed to create directory within 10000 attempts (tried ").append(sb).append("0 to ").append(sb).append("9999)").toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void touch(File file) throws IOException {
        Preconditions.checkNotNull(file);
        if (file.createNewFile() || file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        String valueOf = String.valueOf(file);
        throw new IOException(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Unable to update modification time of ").append(valueOf).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void createParentDirs(File file) throws IOException {
        Preconditions.checkNotNull(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return;
        }
        String valueOf = String.valueOf(file);
        throw new IOException(new StringBuilder(String.valueOf(valueOf).length() + 39).append("Unable to create parent directories of ").append(valueOf).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void move(File file, File file2) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (file.renameTo(file2)) {
            return;
        }
        copy(file, file2);
        if (file.delete()) {
            return;
        }
        if (!file2.delete()) {
            String valueOf = String.valueOf(file2);
            throw new IOException(new StringBuilder(String.valueOf(valueOf).length() + 17).append("Unable to delete ").append(valueOf).toString());
        }
        String valueOf2 = String.valueOf(file);
        throw new IOException(new StringBuilder(String.valueOf(valueOf2).length() + 17).append("Unable to delete ").append(valueOf2).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    @Deprecated
    public static String readFirstLine(File file, Charset charset) throws IOException {
        return asCharSource(file, charset).readFirstLine();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<String> readLines(File file, Charset charset) throws IOException {
        return (List) asCharSource(file, charset).readLines(new LineProcessor<List<String>>() { // from class: com.google.common.io.Files.1
            final List<String> result = Lists.newArrayList();

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.p009io.LineProcessor
            public boolean processLine(String str) {
                this.result.add(str);
                return true;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.p009io.LineProcessor
            public List<String> getResult() {
                return this.result;
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    @Deprecated
    public static <T> T readLines(File file, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return (T) asCharSource(file, charset).readLines(lineProcessor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    @Deprecated
    public static <T> T readBytes(File file, ByteProcessor<T> byteProcessor) throws IOException {
        return (T) asByteSource(file).read(byteProcessor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static HashCode hash(File file, HashFunction hashFunction) throws IOException {
        return asByteSource(file).hash(hashFunction);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MappedByteBuffer map(File file) throws IOException {
        Preconditions.checkNotNull(file);
        return map(file, FileChannel.MapMode.READ_ONLY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode) throws IOException {
        return mapInternal(file, mapMode, -1L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode, long j) throws IOException {
        Preconditions.checkArgument(j >= 0, "size (%s) may not be negative", j);
        return mapInternal(file, mapMode, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static MappedByteBuffer mapInternal(File file, FileChannel.MapMode mapMode, long j) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        Closer create = Closer.create();
        try {
            FileChannel fileChannel = (FileChannel) create.register(((RandomAccessFile) create.register(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? Constants.REVENUE_AMOUNT_KEY : "rw"))).getChannel());
            if (j == -1) {
                j = fileChannel.size();
            }
            return fileChannel.map(mapMode, 0L, j);
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String simplifyPath(String str) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            return ".";
        }
        Iterable<String> split = Splitter.m193on('/').omitEmptyStrings().split(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            str2.hashCode();
            if (!str2.equals(".")) {
                if (str2.equals("..")) {
                    if (arrayList.size() > 0 && !((String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                        arrayList.remove(arrayList.size() - 1);
                    } else {
                        arrayList.add("..");
                    }
                } else {
                    arrayList.add(str2);
                }
            }
        }
        String join = Joiner.m186on('/').join(arrayList);
        if (str.charAt(0) == '/') {
            String valueOf = String.valueOf(join);
            join = valueOf.length() != 0 ? RemoteSettings.FORWARD_SLASH_STRING.concat(valueOf) : new String(RemoteSettings.FORWARD_SLASH_STRING);
        }
        while (join.startsWith("/../")) {
            join = join.substring(3);
        }
        return join.equals("/..") ? RemoteSettings.FORWARD_SLASH_STRING : "".equals(join) ? "." : join;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getFileExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getNameWithoutExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Traverser<File> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Predicate<File> isDirectory() {
        return FilePredicate.IS_DIRECTORY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Predicate<File> isFile() {
        return FilePredicate.IS_FILE;
    }
}
