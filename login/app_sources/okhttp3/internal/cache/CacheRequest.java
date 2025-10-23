package okhttp3.internal.cache;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.IOException;
import kotlin.Metadata;
import okio.Sink;

/* compiled from: CacheRequest.kt */
@Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m839d2 = {"Lokhttp3/internal/cache/CacheRequest;", "", "abort", "", SDKConstants.PARAM_A2U_BODY, "Lokio/Sink;", "okhttp"}, m840k = 1, m841mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
