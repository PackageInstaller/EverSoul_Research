package twitter4j;

import twitter4j.TwitterResponse;

/* loaded from: classes4.dex */
public interface PagableResponseList<T extends TwitterResponse> extends ResponseList<T>, CursorSupport {
    @Override // twitter4j.CursorSupport
    long getNextCursor();

    @Override // twitter4j.CursorSupport
    long getPreviousCursor();

    @Override // twitter4j.CursorSupport
    boolean hasNext();

    @Override // twitter4j.CursorSupport
    boolean hasPrevious();
}
