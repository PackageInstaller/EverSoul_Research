package com.android.volley.http;

import com.liapp.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StringHttpEntity extends HttpEntity {
    public static final String CHARSET_PARAM = "; charset=";
    public static final String PLAIN_TEXT_TYPE = "text/plain";
    protected final byte[] content;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StringHttpEntity(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Source string may not be null");
        }
        str2 = str2 == null ? HttpEntity.DEFAULT_CHARSET : str2;
        this.content = str.getBytes(str2);
        setContentType(y.֬ڱܱײٮ(-1159382839) + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.http.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.content);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.http.HttpEntity
    public void writeTo(ByteArrayOutputStream byteArrayOutputStream) {
        if (byteArrayOutputStream == null) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781561776));
        }
        byteArrayOutputStream.write(this.content);
        byteArrayOutputStream.flush();
    }
}
