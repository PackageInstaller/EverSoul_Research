package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface SymbolEntity extends TweetEntity, Serializable {
    @Override // twitter4j.TweetEntity
    int getEnd();

    @Override // twitter4j.TweetEntity
    int getStart();
}
