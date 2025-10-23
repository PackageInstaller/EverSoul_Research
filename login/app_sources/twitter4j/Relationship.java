package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface Relationship extends TwitterResponse, Serializable {
    boolean canSourceDm();

    long getSourceUserId();

    String getSourceUserScreenName();

    long getTargetUserId();

    String getTargetUserScreenName();

    boolean isSourceBlockingTarget();

    boolean isSourceFollowedByTarget();

    boolean isSourceFollowingTarget();

    boolean isSourceMutingTarget();

    boolean isSourceNotificationsEnabled();

    boolean isSourceWantRetweets();

    boolean isTargetFollowedBySource();

    boolean isTargetFollowingSource();
}
