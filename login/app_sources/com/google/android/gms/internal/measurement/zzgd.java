package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgd extends zzhc {
    private final Context zza;

    @Nullable
    private final Supplier<Optional<zzgp>> zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        Supplier<Optional<zzgp>> supplier = this.zzb;
        return hashCode ^ (supplier == null ? 0 : supplier.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhc
    final Context zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhc
    @Nullable
    final Supplier<Optional<zzgp>> zzb() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.zza) + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgd(Context context, @Nullable Supplier<Optional<zzgp>> supplier) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = supplier;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        Supplier<Optional<zzgp>> supplier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhc) {
            zzhc zzhcVar = (zzhc) obj;
            if (this.zza.equals(zzhcVar.zza()) && ((supplier = this.zzb) != null ? supplier.equals(zzhcVar.zzb()) : zzhcVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }
}
