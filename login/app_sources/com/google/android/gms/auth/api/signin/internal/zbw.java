package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
final class zbw implements LoaderManager.LoaderCallbacks {
    final /* synthetic */ SignInHubActivity zba;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zbw(SignInHubActivity signInHubActivity, zbv zbvVar) {
        this.zba = signInHubActivity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final Loader onCreateLoader(int i, Bundle bundle) {
        return new zbc(this.zba, GoogleApiClient.getAllClients());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        int i;
        Intent intent;
        SignInHubActivity signInHubActivity = this.zba;
        i = signInHubActivity.zbe;
        intent = signInHubActivity.zbf;
        signInHubActivity.setResult(i, intent);
        this.zba.finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final void onLoaderReset(Loader loader) {
    }
}
