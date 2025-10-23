package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface HashtagEntity extends TweetEntity, Serializable {
    @Override // twitter4j.TweetEntity
    int getEnd();

    @Override // twitter4j.TweetEntity
    int getStart();

    @Override // twitter4j.TweetEntity
    String getText();
}
