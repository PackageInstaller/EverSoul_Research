package com.google.android.gms.auth.api.credentials;

import android.accounts.Account;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
@Deprecated
/* loaded from: classes.dex */
public final class IdentityProviders {
    public static final String FACEBOOK = "https://www.facebook.com";
    public static final String GOOGLE = "https://accounts.google.com";
    public static final String LINKEDIN = "https://www.linkedin.com";
    public static final String MICROSOFT = "https://login.live.com";
    public static final String PAYPAL = "https://www.paypal.com";
    public static final String TWITTER = "https://twitter.com";
    public static final String YAHOO = "https://login.yahoo.com";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private IdentityProviders() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getIdentityProviderForAccount(Account account) {
        Preconditions.checkNotNull(account, "account cannot be null");
        if ("com.google".equals(account.type)) {
            return GOOGLE;
        }
        if ("com.facebook.auth.login".equals(account.type)) {
            return FACEBOOK;
        }
        return null;
    }
}
