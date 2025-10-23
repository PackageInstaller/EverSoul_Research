package com.google.android.gms.internal.games_v2;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
final class zzw extends GoogleApi implements zzs {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzc = new Api("GamesConnect.API", zzuVar, clientKey);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzw(Context context, zzq zzqVar) {
        super(context, (Api<zzq>) zzc, zzqVar, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzs
    public final Task zza(final zzy zzyVar, boolean z) {
        TaskApiCall build = TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzt
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzw zzwVar = zzw.this;
                ((zzae) ((zzx) obj).getService()).zzd(new zzv(zzwVar, (TaskCompletionSource) obj2), zzyVar);
            }
        }).setMethodKey(6737).setAutoResolveMissingFeatures(z).build();
        return z ? doWrite(build) : doBestEffortWrite(build);
    }
}
