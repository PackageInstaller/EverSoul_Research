package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import com.kakao.sdk.common.Constants;

/* loaded from: classes2.dex */
final class zzlf implements zzmg {
    private static final zzlp zzts = new zzlg();
    private final zzlp zztr;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzlf() {
        this(new zzlh(zzkj.zzcv(), zzdv()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzlf(zzlp zzlpVar) {
        this.zztr = (zzlp) zzkm.zza(zzlpVar, "messageInfoFactory");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzmg
    public final <T> zzmf<T> zze(Class<T> cls) {
        zzmh.zzg((Class<?>) cls);
        zzlo zzc = this.zztr.zzc(cls);
        if (zzc.zzed()) {
            if (zzkk.class.isAssignableFrom(cls)) {
                return zzlw.zza(zzmh.zzeo(), zzka.zzcl(), zzc.zzee());
            }
            return zzlw.zza(zzmh.zzem(), zzka.zzcm(), zzc.zzee());
        }
        if (zzkk.class.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzlu.zza(cls, zzc, zzma.zzeh(), zzla.zzdu(), zzmh.zzeo(), zzka.zzcl(), zzln.zzea());
            }
            return zzlu.zza(cls, zzc, zzma.zzeh(), zzla.zzdu(), zzmh.zzeo(), (zzjy<?>) null, zzln.zzea());
        }
        if (zza(zzc)) {
            return zzlu.zza(cls, zzc, zzma.zzeg(), zzla.zzdt(), zzmh.zzem(), zzka.zzcm(), zzln.zzdz());
        }
        return zzlu.zza(cls, zzc, zzma.zzeg(), zzla.zzdt(), zzmh.zzen(), (zzjy<?>) null, zzln.zzdz());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zza(zzlo zzloVar) {
        return zzloVar.zzec() == zzkk.zze.zzsf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzlp zzdv() {
        try {
            return (zzlp) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod(Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzts;
        }
    }
}
