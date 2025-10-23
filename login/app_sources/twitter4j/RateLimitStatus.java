package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface RateLimitStatus extends Serializable {
    int getLimit();

    int getRemaining();

    int getResetTimeInSeconds();

    int getSecondsUntilReset();
}
