package com.google.android.gms.internal.auth;

import com.kakao.sdk.common.Constants;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzfi implements zzgc {
    private static final zzfo zza = new zzfg();
    private final zzfo zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzfi() {
        zzfo zzfoVar;
        zzfo[] zzfoVarArr = new zzfo[2];
        zzfoVarArr[0] = zzen.zza();
        try {
            zzfoVar = (zzfo) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod(Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzfoVar = zza;
        }
        zzfoVarArr[1] = zzfoVar;
        zzfh zzfhVar = new zzfh(zzfoVarArr);
        zzev.zzf(zzfhVar, "messageInfoFactory");
        this.zzb = zzfhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzb(zzfn zzfnVar) {
        return zzfnVar.zzc() == 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgc
    public final <T> zzgb<T> zza(Class<T> cls) {
        zzgd.zzg(cls);
        zzfn zzb = this.zzb.zzb(cls);
        return zzb.zzb() ? zzeq.class.isAssignableFrom(cls) ? zzfu.zzb(zzgd.zzc(), zzej.zzb(), zzb.zza()) : zzfu.zzb(zzgd.zza(), zzej.zza(), zzb.zza()) : zzeq.class.isAssignableFrom(cls) ? zzb(zzb) ? zzft.zzj(cls, zzb, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), zzej.zzb(), zzfm.zzb()) : zzft.zzj(cls, zzb, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), null, zzfm.zzb()) : zzb(zzb) ? zzft.zzj(cls, zzb, zzfw.zza(), zzfe.zzc(), zzgd.zza(), zzej.zza(), zzfm.zza()) : zzft.zzj(cls, zzb, zzfw.zza(), zzfe.zzc(), zzgd.zzb(), null, zzfm.zza());
    }
}
