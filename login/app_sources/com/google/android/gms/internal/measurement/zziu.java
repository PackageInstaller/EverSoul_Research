package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzja;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
abstract class zziu<T extends zzja<T>> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zziu() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract zziy<T> zza(Object obj);

    abstract Object zza(zzis zzisVar, zzkr zzkrVar, int i);

    abstract <UT, UB> UB zza(Object obj, zzlk zzlkVar, Object obj2, zzis zzisVar, zziy<T> zziyVar, UB ub, zzmi<UT, UB> zzmiVar) throws IOException;

    abstract void zza(zzhu zzhuVar, Object obj, zzis zzisVar, zziy<T> zziyVar) throws IOException;

    abstract void zza(zzlk zzlkVar, Object obj, zzis zzisVar, zziy<T> zziyVar) throws IOException;

    abstract void zza(zzne zzneVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zza(zzkr zzkrVar);

    abstract zziy<T> zzb(Object obj);

    abstract void zzc(Object obj);
}
