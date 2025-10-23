package com.bumptech.glide.load;

import com.liapp.y;
import java.io.IOException;

/* loaded from: classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpException(int i) {
        this(y.ٲٴݴ״ٰ(1781760192) + i, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpException(String str) {
        this(str, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpException(String str, int i) {
        this(str, i, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpException(String str, int i, Throwable th) {
        super(str, th);
        this.statusCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStatusCode() {
        return this.statusCode;
    }
}
