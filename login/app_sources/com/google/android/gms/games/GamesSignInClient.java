package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public interface GamesSignInClient {
    Task<AuthenticationResult> isAuthenticated();

    Task<String> requestServerSideAccess(String str, boolean z);

    Task<AuthenticationResult> signIn();
}
