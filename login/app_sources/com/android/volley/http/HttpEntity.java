package com.android.volley.http;

import com.liapp.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class HttpEntity {
    public static final String APPLICATION_ATOM_XML = "application/atom+xml";
    public static final String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    public static final String APPLICATION_SVG_XML = "application/svg+xml";
    public static final String APPLICATION_XHTML_XML = "application/xhtml+xml";
    public static final String APPLICATION_XML = "application/xml";
    protected static String DEFAULT_CHARSET = "UTF-8";
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    public static final String TEXT_HTML = "text/html";
    public static final String TEXT_PLAIN = "text/plain";
    public static final String TEXT_XML = "text/xml";
    public static final String WILDCARD = "*/*";
    private String contentEncoding;
    private int contentLength;
    private String contentType;
    private InputStream inputStream;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String createContentType(String str, String str2) {
        return str + y.ݮڮֲڭܩ(-629059132) + str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void consumeContent() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputStream getContent() {
        return this.inputStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getContentEncoding() {
        return this.contentEncoding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getContentLength() {
        return this.contentLength;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getContentType() {
        return this.contentType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputStream getInputStream() {
        return this.inputStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContent(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContentLength(int i) {
        this.contentLength = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContentType(String str) {
        this.contentType = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void writeTo(ByteArrayOutputStream byteArrayOutputStream) {
        InputStream content = getContent();
        if (byteArrayOutputStream == null || content == null) {
            return;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    return;
                } else {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
        } finally {
            content.close();
        }
    }
}
