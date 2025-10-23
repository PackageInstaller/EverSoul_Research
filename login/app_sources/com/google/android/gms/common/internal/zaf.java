package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zaf extends zag {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ LifecycleFragment zab;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zaf(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.zaa = intent;
        this.zab = lifecycleFragment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, 2);
        }
    }
}
