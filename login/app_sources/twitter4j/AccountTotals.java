package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface AccountTotals extends TwitterResponse, Serializable {
    int getFavorites();

    int getFollowers();

    int getFriends();

    int getUpdates();
}
