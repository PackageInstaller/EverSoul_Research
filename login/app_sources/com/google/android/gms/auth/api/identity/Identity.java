package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p035authapi.zbao;
import com.google.android.gms.internal.p035authapi.zbay;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public final class Identity {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Identity() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CredentialSavingClient getCredentialSavingClient(Activity activity) {
        return new zbao((Activity) Preconditions.checkNotNull(activity), new zbc());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SignInClient getSignInClient(Activity activity) {
        return new zbay((Activity) Preconditions.checkNotNull(activity), new zbn());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CredentialSavingClient getCredentialSavingClient(Context context) {
        return new zbao((Context) Preconditions.checkNotNull(context), new zbc());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SignInClient getSignInClient(Context context) {
        return new zbay((Context) Preconditions.checkNotNull(context), new zbn());
    }
}
