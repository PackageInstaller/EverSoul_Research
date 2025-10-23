package com.google.firebase.perf.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public class URLWrapper {
    private final URL url;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public URLWrapper(URL url) {
        this.url = url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public URLConnection openConnection() throws IOException {
        return this.url.openConnection();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.url.toString();
    }
}
