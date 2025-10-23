package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:review@@2.0.0 */
/* loaded from: classes2.dex */
final class zzc extends ResultReceiver {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzc(zzd zzdVar, Handler handler, TaskCompletionSource taskCompletionSource) {
        super(handler);
        this.zza = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        this.zza.trySetResult(null);
    }
}
