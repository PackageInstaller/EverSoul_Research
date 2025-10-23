package com.google.android.gms.games.internal.p008v2.resolution;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import com.google.android.gms.internal.games_v2.zzfa;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zza extends ResultReceiver {
    private final TaskCompletionSource zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zza() {
        super(new zzfa(Looper.getMainLooper()));
        this.zza = new TaskCompletionSource();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.ResultReceiver
    protected final void onReceiveResult(int i, Bundle bundle) {
        Intent intent;
        super.onReceiveResult(i, bundle);
        Boolean valueOf = Boolean.valueOf(i == -1);
        if (bundle == null) {
            intent = new Intent();
        } else {
            intent = (Intent) bundle.getParcelable("resultData");
            if (intent == null) {
                intent = new Intent();
            }
        }
        this.zza.trySetResult(valueOf.booleanValue() ? zzc.zzc(intent) : zzc.zzb(intent));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Task zza() {
        return this.zza.getTask();
    }
}
