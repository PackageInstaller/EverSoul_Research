package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.PlayerStatsClient;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzdm implements PlayerStatsClient {
    private final zzar zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzdm(zzar zzarVar) {
        this.zza = zzarVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.PlayerStatsClient
    public final Task<AnnotatedData<PlayerStats>> loadPlayerStats(final boolean z) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzdl
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z2 = z;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdk
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzH((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6708).build());
            }
        });
    }
}
