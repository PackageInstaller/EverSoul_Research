package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzco implements GamesSignInClient {
    private final zzav zza;
    private final zzar zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzco(zzav zzavVar, zzar zzarVar) {
        this.zza = zzavVar;
        this.zzb = zzarVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task<AuthenticationResult> isAuthenticated() {
        return this.zza.zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task<String> requestServerSideAccess(final String str, final boolean z) {
        return this.zzb.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcn
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final boolean z2 = z;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcm
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzM((TaskCompletionSource) obj2, str2, z2);
                    }
                }).setMethodKey(6699).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task<AuthenticationResult> signIn() {
        return this.zza.zzb();
    }
}
