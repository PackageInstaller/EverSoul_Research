package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface StatusDeletionNotice extends Comparable<StatusDeletionNotice>, Serializable {
    long getStatusId();

    long getUserId();
}
