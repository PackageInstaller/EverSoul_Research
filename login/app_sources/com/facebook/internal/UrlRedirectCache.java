package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* compiled from: UrlRedirectCache.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m839d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "()V", "redirectContentTag", "", "tag", "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "cacheUriRedirect", "", "fromUri", "Landroid/net/Uri;", "toUri", "clearCache", "getCache", "getRedirectedUri", "uri", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class UrlRedirectCache {
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    private static final String redirectContentTag;
    private static final String tag;
    private static FileLruCache urlRedirectFileLruCache;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UrlRedirectCache() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String simpleName = Reflection.getOrCreateKotlinClass(UrlRedirectCache.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "UrlRedirectCache";
        }
        tag = simpleName;
        redirectContentTag = Intrinsics.stringPlus(simpleName, "_Redirect");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            fileLruCache = urlRedirectFileLruCache;
            if (fileLruCache == null) {
                fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
            }
            urlRedirectFileLruCache = fileLruCache;
        }
        return fileLruCache;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r10) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        r5 = r6;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        com.facebook.internal.Logger.INSTANCE.log(com.facebook.LoggingBehavior.CACHE, 6, com.facebook.internal.UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
    
        r10 = com.facebook.internal.Utility.INSTANCE;
        com.facebook.internal.Utility.closeQuietly(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
    
        return null;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.net.Uri getRedirectedUri(android.net.Uri r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            java.lang.String r10 = r10.toString()
            java.lang.String r1 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r1.add(r10)
            com.facebook.internal.FileLruCache r2 = getCache()     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La4
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La4
            java.io.InputStream r3 = r2.get(r10, r3)     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La4
            r4 = 0
            r5 = r0
            r6 = r4
        L22:
            if (r3 == 0) goto L8c
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L8a java.lang.Throwable -> Lbc
            r6.<init>(r3)     // Catch: java.io.IOException -> L8a java.lang.Throwable -> Lbc
            r3 = 128(0x80, float:1.8E-43)
            char[] r5 = new char[r3]     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            r7.<init>()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            int r8 = r6.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
        L36:
            if (r8 <= 0) goto L40
            r7.append(r5, r4, r8)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            int r8 = r6.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            goto L36
        L40:
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            r3 = r6
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            com.facebook.internal.Utility.closeQuietly(r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.lang.String r3 = r7.toString()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.lang.String r5 = "urlBuilder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            boolean r5 = r1.contains(r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            r7 = 1
            if (r5 == 0) goto L75
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r10)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            if (r1 == 0) goto L61
            r5 = r6
            r6 = r7
            goto L8c
        L61:
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.INSTANCE     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.lang.String r2 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.lang.String r3 = "A loop detected in UrlRedirectCache"
            r4 = 6
            r10.log(r1, r4, r2, r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            com.facebook.internal.Utility r10 = com.facebook.internal.Utility.INSTANCE
            java.io.Closeable r6 = (java.io.Closeable) r6
            com.facebook.internal.Utility.closeQuietly(r6)
            return r0
        L75:
            r1.add(r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.lang.String r10 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.io.InputStream r10 = r2.get(r3, r10)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            r5 = r6
            r6 = r7
            r9 = r3
            r3 = r10
            r10 = r9
            goto L22
        L84:
            r10 = move-exception
            r0 = r6
            goto Lbe
        L87:
            r10 = move-exception
            r5 = r6
            goto La6
        L8a:
            r10 = move-exception
            goto La6
        L8c:
            if (r6 == 0) goto L9a
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch: java.io.IOException -> L8a java.lang.Throwable -> Lbc
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE
            java.io.Closeable r5 = (java.io.Closeable) r5
            com.facebook.internal.Utility.closeQuietly(r5)
            return r10
        L9a:
            com.facebook.internal.Utility r10 = com.facebook.internal.Utility.INSTANCE
            java.io.Closeable r5 = (java.io.Closeable) r5
            com.facebook.internal.Utility.closeQuietly(r5)
            goto Lbb
        La2:
            r10 = move-exception
            goto Lbe
        La4:
            r10 = move-exception
            r5 = r0
        La6:
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.INSTANCE     // Catch: java.lang.Throwable -> Lbc
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r4 = "IOException when accessing cache: "
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r10)     // Catch: java.lang.Throwable -> Lbc
            r4 = 4
            r1.log(r2, r4, r3, r10)     // Catch: java.lang.Throwable -> Lbc
            goto L9a
        Lbb:
            return r0
        Lbc:
            r10 = move-exception
            r0 = r5
        Lbe:
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            java.io.Closeable r0 = (java.io.Closeable) r0
            com.facebook.internal.Utility.closeQuietly(r0)
            throw r10
            fill-array 0x00c6: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.getRedirectedUri(android.net.Uri):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void cacheUriRedirect(Uri fromUri, Uri toUri) {
        Object obj;
        if (fromUri == null || toUri == null) {
            return;
        }
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                FileLruCache cache = getCache();
                String uri = fromUri.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "fromUri.toString()");
                r0 = cache.openPutStream(uri, redirectContentTag);
                String uri2 = toUri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "toUri.toString()");
                byte[] bytes = uri2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                r0.write(bytes);
                obj = r0;
            } catch (IOException e) {
                Logger.INSTANCE.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e.getMessage()));
                obj = r0;
            }
        } finally {
            Utility utility = Utility.INSTANCE;
            Utility.closeQuietly((Closeable) r0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.INSTANCE.log(LoggingBehavior.CACHE, 5, tag, Intrinsics.stringPlus("clearCache failed ", e.getMessage()));
        }
    }
}
