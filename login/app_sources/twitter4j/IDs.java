package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface IDs extends TwitterResponse, CursorSupport, Serializable {
    long[] getIDs();

    @Override // twitter4j.CursorSupport
    long getNextCursor();

    @Override // twitter4j.CursorSupport
    long getPreviousCursor();

    @Override // twitter4j.CursorSupport
    boolean hasNext();

    @Override // twitter4j.CursorSupport
    boolean hasPrevious();
}
