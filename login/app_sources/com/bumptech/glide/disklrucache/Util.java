package com.bumptech.glide.disklrucache;

import com.liapp.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
final class Util {
    static final Charset US_ASCII = Charset.forName(y.دײܮڳܯ(2052034389));
    static final Charset UTF_8 = Charset.forName(y.٬ݯح׭٩(576116366));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Util() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String readFully(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    return stringWriter.toString();
                }
            }
        } finally {
            reader.close();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void deleteContents(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException(y.٬ݯح׭٩(576014862) + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            if (!file2.delete()) {
                throw new IOException(y.دײܮڳܯ(2052034309) + file2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
