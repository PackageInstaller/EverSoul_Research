package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zzlk;
import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzcn {
    private boolean zza;
    private Transport zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcn(Context context) {
        try {
            TransportRuntime.initialize(context);
            this.zzb = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("PLAY_BILLING_LIBRARY", zzlk.class, Encoding.m106of("proto"), new Transformer() { // from class: com.android.billingclient.api.zzcm
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.datatransport.Transformer
                public final Object apply(Object obj) {
                    return ((zzlk) obj).zzh();
                }
            });
        } catch (Throwable unused) {
            this.zza = true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzlk zzlkVar) {
        boolean z = this.zza;
        String str = y.ݮڮֲڭܩ(-629091700);
        if (z) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.zzb.send(Event.ofData(zzlkVar));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, "logging failed.");
        }
    }
}
