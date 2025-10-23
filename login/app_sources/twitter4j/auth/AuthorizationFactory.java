package twitter4j.auth;

import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
public final class AuthorizationFactory {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [twitter4j.auth.OAuthAuthorization] */
    /* JADX WARN: Type inference failed for: r0v8, types: [twitter4j.auth.OAuth2Authorization] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Authorization getInstance(Configuration configuration) {
        BasicAuthorization basicAuthorization;
        String oAuthConsumerKey = configuration.getOAuthConsumerKey();
        String oAuthConsumerSecret = configuration.getOAuthConsumerSecret();
        if (oAuthConsumerKey != null && oAuthConsumerSecret != null) {
            if (configuration.isApplicationOnlyAuthEnabled()) {
                ?? oAuth2Authorization = new OAuth2Authorization(configuration);
                String oAuth2TokenType = configuration.getOAuth2TokenType();
                String oAuth2AccessToken = configuration.getOAuth2AccessToken();
                basicAuthorization = oAuth2Authorization;
                basicAuthorization = oAuth2Authorization;
                if (oAuth2TokenType != null && oAuth2AccessToken != null) {
                    oAuth2Authorization.setOAuth2Token(new OAuth2Token(oAuth2TokenType, oAuth2AccessToken));
                    basicAuthorization = oAuth2Authorization;
                }
            } else {
                ?? oAuthAuthorization = new OAuthAuthorization(configuration);
                String oAuthAccessToken = configuration.getOAuthAccessToken();
                String oAuthAccessTokenSecret = configuration.getOAuthAccessTokenSecret();
                basicAuthorization = oAuthAuthorization;
                basicAuthorization = oAuthAuthorization;
                if (oAuthAccessToken != null && oAuthAccessTokenSecret != null) {
                    oAuthAuthorization.setOAuthAccessToken(new AccessToken(oAuthAccessToken, oAuthAccessTokenSecret));
                    basicAuthorization = oAuthAuthorization;
                }
            }
        } else {
            String user = configuration.getUser();
            String password = configuration.getPassword();
            basicAuthorization = (user == null || password == null) ? null : new BasicAuthorization(user, password);
        }
        return basicAuthorization == null ? NullAuthorization.getInstance() : basicAuthorization;
    }
}
