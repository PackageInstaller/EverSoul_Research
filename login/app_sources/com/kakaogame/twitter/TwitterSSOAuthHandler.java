package com.kakaogame.twitter;

import android.app.Activity;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.idp.KGTwitterAuth;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/* compiled from: TwitterSSOAuthHandler.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/twitter/TwitterSSOAuthHandler;", "", "()V", "EXTRA_CONSUMER_KEY", "", "EXTRA_CONSUMER_SECRET", "EXTRA_TOKEN", "EXTRA_TOKEN_SECRET", "SSO_CLASS_NAME", "TWITTER_PACKAGE_NAME", "handleOnActivityResult", "Ltwitter4j/Twitter;", "CONSUMER_KEY", "CONSUMER_SECRET", "data", "Landroid/content/Intent;", "startAuthActivityForResult", "", "activity", "Landroid/app/Activity;", SDKConstants.PARAM_INTENT, "idp_twitter_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TwitterSSOAuthHandler {
    private static final String EXTRA_CONSUMER_KEY = "ck";
    private static final String EXTRA_CONSUMER_SECRET = "cs";
    public static final String EXTRA_TOKEN = "tk";
    public static final String EXTRA_TOKEN_SECRET = "ts";
    public static final TwitterSSOAuthHandler INSTANCE = new TwitterSSOAuthHandler();
    public static final String SSO_CLASS_NAME = "com.twitter.android.SingleSignOnActivity";
    public static final String TWITTER_PACKAGE_NAME = "com.twitter.android";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TwitterSSOAuthHandler() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Twitter handleOnActivityResult(String CONSUMER_KEY, String CONSUMER_SECRET, Intent data) {
        Intrinsics.checkNotNullParameter(data, y.دײܮڳܯ(2051550101));
        String stringExtra = data.getStringExtra(y.ٴسسݬߨ(1393105986));
        String stringExtra2 = data.getStringExtra(y.دײܮڳܯ(2051022413));
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(CONSUMER_KEY);
        configurationBuilder.setOAuthConsumerSecret(CONSUMER_SECRET);
        configurationBuilder.setOAuthAccessToken(stringExtra);
        configurationBuilder.setOAuthAccessTokenSecret(stringExtra2);
        Twitter twitterFactory = new TwitterFactory(configurationBuilder.build()).getInstance();
        Intrinsics.checkNotNullExpressionValue(twitterFactory, "getInstance(...)");
        return twitterFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void startAuthActivityForResult(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(intent, y.ݬֲ֮ܲت(1512852487));
        intent.putExtra(y.ݬֲ֮ܲت(1512060871), KGTwitterAuth.INSTANCE.getCONSUMER_KEY()).putExtra(y.ۮڭڭܬި(862811467), KGTwitterAuth.INSTANCE.getCONSUMER_SECRET());
        activity.startActivityForResult(intent, KGTwitterAuth.SSOAUTH_REQUEST_CODE);
    }
}
