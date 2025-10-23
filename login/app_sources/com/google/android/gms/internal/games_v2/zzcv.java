package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzcv implements zzaq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ zzcv(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzaq
    public final Task zza(GoogleApi googleApi) {
        final String str = this.zza;
        final long j = this.zzb;
        return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzde
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzak) obj).zzR((TaskCompletionSource) obj2, str, j, null);
            }
        }).setMethodKey(6707).build());
    }
}
