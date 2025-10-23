package com.google.common.p009io;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Resources {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Resources() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteSource asByteSource(URL url) {
        return new UrlByteSource(url);
    }

    private static final class UrlByteSource extends ByteSource {
        private final URL url;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private UrlByteSource(URL url) {
            this.url = (URL) Preconditions.checkNotNull(url);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.ByteSource
        public InputStream openStream() throws IOException {
            return this.url.openStream();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.url);
            return new StringBuilder(String.valueOf(valueOf).length() + 24).append("Resources.asByteSource(").append(valueOf).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSource asCharSource(URL url, Charset charset) {
        return asByteSource(url).asCharSource(charset);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] toByteArray(URL url) throws IOException {
        return asByteSource(url).read();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(URL url, Charset charset) throws IOException {
        return asCharSource(url, charset).read();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    public static <T> T readLines(URL url, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return (T) asCharSource(url, charset).readLines(lineProcessor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<String> readLines(URL url, Charset charset) throws IOException {
        return (List) readLines(url, charset, new LineProcessor<List<String>>() { // from class: com.google.common.io.Resources.1
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
    public static void copy(URL url, OutputStream outputStream) throws IOException {
        asByteSource(url).copyTo(outputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static URL getResource(String str) {
        URL resource = ((ClassLoader) MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s not found.", str);
        return resource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static URL getResource(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }
}
