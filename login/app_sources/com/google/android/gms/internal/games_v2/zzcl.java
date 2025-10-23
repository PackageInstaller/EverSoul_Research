package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.EventsClient;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzcl implements EventsClient {
    private final zzar zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzcl(zzar zzarVar) {
        this.zza = zzarVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.EventsClient
    public final void increment(final String str, final int i) {
        this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzci
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final int i2 = i;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcf
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzx(str2, i2);
                    }
                }).setMethodKey(6729).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.EventsClient
    public final Task<AnnotatedData<EventBuffer>> load(final boolean z) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcj
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z2 = z;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcg
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzA((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6727).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.EventsClient
    public final Task<AnnotatedData<EventBuffer>> loadByIds(final boolean z, final String... strArr) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzck
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z2 = z;
                final String[] strArr2 = strArr;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzch
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzB((TaskCompletionSource) obj2, z2, strArr2);
                    }
                }).setMethodKey(6728).build());
            }
        });
    }
}
