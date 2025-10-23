package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public abstract class zzc {
    private Object zza;
    private boolean zzb = false;
    final /* synthetic */ BaseGmsClient zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.zzd = baseGmsClient;
        this.zza = obj;
    }

    protected abstract void zza(Object obj);

    protected abstract void zzc();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zze() {
        Object obj;
        synchronized (this) {
            obj = this.zza;
            if (this.zzb) {
                Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                zza(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzb = true;
        }
        zzg();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzf() {
        synchronized (this) {
            this.zza = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzg() {
        ArrayList arrayList;
        ArrayList arrayList2;
        zzf();
        arrayList = this.zzd.zzt;
        synchronized (arrayList) {
            arrayList2 = this.zzd.zzt;
            arrayList2.remove(this);
        }
    }
}
