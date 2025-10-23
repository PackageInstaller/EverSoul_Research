package com.google.android.gms.internal.games_v2;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.Games;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zze extends GoogleApi {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zze(Context context, com.google.android.gms.games.zzn zznVar) {
        super(context, (Api<com.google.android.gms.games.zzn>) Games.zze, zznVar, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.GoogleApi
    protected final ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder createClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            String str = ((com.google.android.gms.games.zzn) getApiOptions()).zzl;
        }
        return createClientSettingsBuilder;
    }
}
