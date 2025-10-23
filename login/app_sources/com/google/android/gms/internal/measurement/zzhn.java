package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhn;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzhn<MessageType extends zzhl<MessageType, BuilderType>, BuilderType extends zzhn<MessageType, BuilderType>> implements zzku {
    @Override // 
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzb(zzij zzijVar, zzis zzisVar) throws IOException;

    @Override // 
    /* renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BuilderType zza(byte[] bArr, int i, int i2) throws zzjq {
        try {
            zzij zza = zzij.zza(bArr, 0, i2, false);
            zzb(zza, zzis.zza);
            zza.zzb(0);
            return this;
        } catch (zzjq e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BuilderType zza(byte[] bArr, int i, int i2, zzis zzisVar) throws zzjq {
        try {
            zzij zza = zzij.zza(bArr, 0, i2, false);
            zzb(zza, zzisVar);
            zza.zzb(0);
            return this;
        } catch (zzjq e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzku
    public final /* synthetic */ zzku zza(byte[] bArr) throws zzjq {
        return zza(bArr, 0, bArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzku
    public final /* synthetic */ zzku zza(byte[] bArr, zzis zzisVar) throws zzjq {
        return zza(bArr, 0, bArr.length, zzisVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zza(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }
}
