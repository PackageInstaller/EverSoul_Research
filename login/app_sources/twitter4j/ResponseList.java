package twitter4j;

import java.util.List;

/* loaded from: classes4.dex */
public interface ResponseList<T> extends TwitterResponse, List<T> {
    @Override // twitter4j.TwitterResponse
    RateLimitStatus getRateLimitStatus();
}
