package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface URLEntity extends TweetEntity, Serializable {
    String getDisplayURL();

    @Override // twitter4j.TweetEntity
    int getEnd();

    String getExpandedURL();

    @Override // twitter4j.TweetEntity
    int getStart();

    @Override // twitter4j.TweetEntity
    String getText();

    String getURL();
}
