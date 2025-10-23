package com.google.android.gms.internal.measurement;

import com.kakao.sdk.common.Constants;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkf implements zzlm {
    private static final zzks zza = new zzki();
    private final zzks zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzks zza() {
        try {
            return (zzks) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod(Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zza;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzlm
    public final <T> zzlj<T> zza(Class<T> cls) {
        zzll.zza((Class<?>) cls);
        zzkp zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            if (zzjf.class.isAssignableFrom(cls)) {
                return zzkx.zza(zzll.zzb(), zziv.zzb(), zza2.zza());
            }
            return zzkx.zza(zzll.zza(), zziv.zza(), zza2.zza());
        }
        if (zzjf.class.isAssignableFrom(cls)) {
            if (zza(zza2)) {
                return zzkv.zza(cls, zza2, zzlb.zzb(), zzka.zzb(), zzll.zzb(), zziv.zzb(), zzkq.zzb());
            }
            return zzkv.zza(cls, zza2, zzlb.zzb(), zzka.zzb(), zzll.zzb(), (zziu<?>) null, zzkq.zzb());
        }
        if (zza(zza2)) {
            return zzkv.zza(cls, zza2, zzlb.zza(), zzka.zza(), zzll.zza(), zziv.zza(), zzkq.zza());
        }
        return zzkv.zza(cls, zza2, zzlb.zza(), zzka.zza(), zzll.zza(), (zziu<?>) null, zzkq.zza());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzkf() {
        this(new zzkk(zzjg.zza(), zza()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzkf(zzks zzksVar) {
        this.zzb = (zzks) zzjh.zza(zzksVar, "messageInfoFactory");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zza(zzkp zzkpVar) {
        return zzkh.zza[zzkpVar.zzb().ordinal()] != 1;
    }
}
