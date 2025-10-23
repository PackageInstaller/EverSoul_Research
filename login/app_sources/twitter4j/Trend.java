package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface Trend extends Serializable {
    String getName();

    String getQuery();

    int getTweetVolume();

    String getURL();
}
