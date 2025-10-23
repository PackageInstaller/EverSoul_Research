package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzhg;
import com.google.android.gms.internal.play_billing.zzhk;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public class zzhg<MessageType extends zzhk<MessageType, BuilderType>, BuilderType extends zzhg<MessageType, BuilderType>> extends zzfu<MessageType, BuilderType> {
    protected zzhk zza;
    private final zzhk zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzhg(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzA()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzp();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(Object obj, Object obj2) {
        zziu.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzfu
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzhg clone() {
        zzhg zzhgVar = (zzhg) this.zzb.zzd(5, null, null);
        zzhgVar.zza = zzh();
        return zzhgVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzhg zze(zzhk zzhkVar) {
        if (!this.zzb.equals(zzhkVar)) {
            if (!this.zza.zzA()) {
                zzk();
            }
            zza(this.zza, zzhkVar);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final MessageType zzf() {
        MessageType zzh = zzh();
        if (zzhk.zzz(zzh, true)) {
            return zzh;
        }
        throw new zzji(zzh);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzil
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public MessageType zzh() {
        if (!this.zza.zzA()) {
            return (MessageType) this.zza;
        }
        this.zza.zzv();
        return (MessageType) this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzin
    public final /* bridge */ /* synthetic */ zzim zzi() {
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzj() {
        if (this.zza.zzA()) {
            return;
        }
        zzk();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void zzk() {
        zzhk zzp = this.zzb.zzp();
        zza(zzp, this.zza);
        this.zza = zzp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzin
    public final boolean zzl() {
        return zzhk.zzz(this.zza, false);
    }
}
