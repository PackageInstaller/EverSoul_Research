package twitter4j.auth;

import twitter4j.TwitterException;

/* loaded from: classes4.dex */
public interface OAuth2Support {
    OAuth2Token getOAuth2Token() throws TwitterException;

    void invalidateOAuth2Token() throws TwitterException;

    void setOAuth2Token(OAuth2Token oAuth2Token);

    void setOAuthConsumer(String str, String str2);
}
