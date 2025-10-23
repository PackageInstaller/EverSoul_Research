package okhttp3.internal.http;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.FirebasePerformance;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMethod.kt */
@Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, m839d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", FirebaseAnalytics.Param.METHOD, "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, m840k = 1, m841mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpMethod() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean invalidatesCache(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return Intrinsics.areEqual(method, "POST") || Intrinsics.areEqual(method, FirebasePerformance.HttpMethod.PATCH) || Intrinsics.areEqual(method, FirebasePerformance.HttpMethod.PUT) || Intrinsics.areEqual(method, FirebasePerformance.HttpMethod.DELETE) || Intrinsics.areEqual(method, "MOVE");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean requiresRequestBody(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return Intrinsics.areEqual(method, "POST") || Intrinsics.areEqual(method, FirebasePerformance.HttpMethod.PUT) || Intrinsics.areEqual(method, FirebasePerformance.HttpMethod.PATCH) || Intrinsics.areEqual(method, "PROPPATCH") || Intrinsics.areEqual(method, "REPORT");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean permitsRequestBody(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return (Intrinsics.areEqual(method, "GET") || Intrinsics.areEqual(method, FirebasePerformance.HttpMethod.HEAD)) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean redirectsWithBody(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return Intrinsics.areEqual(method, "PROPFIND");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean redirectsToGet(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return !Intrinsics.areEqual(method, "PROPFIND");
    }
}
