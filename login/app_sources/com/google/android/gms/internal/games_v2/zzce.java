package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzce implements AchievementsClient {
    private final zzar zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzce(zzar zzarVar) {
        this.zza = zzarVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Intent> getAchievementsIntent() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzbv
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcb
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                        try {
                            taskCompletionSource.setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzg());
                        } catch (SecurityException e) {
                            GamesStatusUtils.zzb(taskCompletionSource, e);
                        }
                    }
                }).setMethodKey(6692).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final void increment(String str, int i) {
        this.zza.zzb(new zzbs(str, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Boolean> incrementImmediate(String str, int i) {
        return this.zza.zzb(new zzbs(str, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<AnnotatedData<AchievementBuffer>> load(final boolean z) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzbu
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z2 = z;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzca
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzy((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6693).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final void reveal(String str) {
        this.zza.zzb(new zzcc(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Void> revealImmediate(String str) {
        return this.zza.zzb(new zzcc(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final void setSteps(String str, int i) {
        this.zza.zzb(new zzbt(str, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Boolean> setStepsImmediate(String str, int i) {
        return this.zza.zzb(new zzbt(str, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final void unlock(String str) {
        this.zza.zzb(new zzcd(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Void> unlockImmediate(String str) {
        return this.zza.zzb(new zzcd(str));
    }
}
