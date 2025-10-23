package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zaw extends zaa {
    final /* synthetic */ TaskCompletionSource zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zaw(zay zayVar, TaskCompletionSource taskCompletionSource) {
        this.zaa = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zac(Status status, ModuleInstallIntentResponse moduleInstallIntentResponse) {
        TaskUtil.trySetResultOrApiException(status, moduleInstallIntentResponse, this.zaa);
    }
}
