package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
@Deprecated
/* loaded from: classes.dex */
public class Credentials {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CredentialsClient getClient(Activity activity) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) CredentialsOptions.DEFAULT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CredentialsClient getClient(Activity activity, CredentialsOptions credentialsOptions) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) credentialsOptions);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CredentialsClient getClient(Context context) {
        return new CredentialsClient(context, CredentialsOptions.DEFAULT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CredentialsClient getClient(Context context, CredentialsOptions credentialsOptions) {
        return new CredentialsClient(context, credentialsOptions);
    }
}
