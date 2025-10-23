package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
abstract class zzmi<T, B> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmi() {
    }

    abstract int zza(T t);

    abstract B zza();

    abstract T zza(T t, T t2);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzhu zzhuVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzne zzneVar) throws IOException;

    abstract boolean zza(zzlk zzlkVar);

    abstract int zzb(T t);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zzne zzneVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract void zzc(Object obj, T t);

    abstract T zzd(Object obj);

    abstract T zze(B b);

    abstract void zzf(Object obj);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zza(B b, zzlk zzlkVar) throws IOException {
        int zzd = zzlkVar.zzd();
        int i = zzd >>> 3;
        int i2 = zzd & 7;
        if (i2 == 0) {
            zzb(b, i, zzlkVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zza((zzmi<T, B>) b, i, zzlkVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zza((zzmi<T, B>) b, i, zzlkVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzjq.zza();
            }
            zza((zzmi<T, B>) b, i, zzlkVar.zzf());
            return true;
        }
        B zza = zza();
        int i3 = 4 | (i << 3);
        while (zzlkVar.zzc() != Integer.MAX_VALUE && zza((zzmi<T, B>) zza, zzlkVar)) {
        }
        if (i3 != zzlkVar.zzd()) {
            throw zzjq.zzb();
        }
        zza((zzmi<T, B>) b, i, (int) zze(zza));
        return true;
    }
}
