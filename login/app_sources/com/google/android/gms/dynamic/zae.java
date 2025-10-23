package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zae implements View.OnClickListener {
    final /* synthetic */ Context zaa;
    final /* synthetic */ Intent zab;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zae(Context context, Intent intent) {
        this.zaa = context;
        this.zab = intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.zaa.startActivity(this.zab);
        } catch (ActivityNotFoundException e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
