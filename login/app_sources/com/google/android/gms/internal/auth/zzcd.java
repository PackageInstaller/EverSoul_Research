package com.google.android.gms.internal.auth;

import android.content.Context;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzcd extends zzcy {
    private final Context zza;
    private final zzdg<zzde<zzco>> zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcd(Context context, @Nullable zzdg<zzde<zzco>> zzdgVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = zzdgVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        zzdg<zzde<zzco>> zzdgVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcy) {
            zzcy zzcyVar = (zzcy) obj;
            if (this.zza.equals(zzcyVar.zza()) && ((zzdgVar = this.zzb) != null ? zzdgVar.equals(zzcyVar.zzb()) : zzcyVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzdg<zzde<zzco>> zzdgVar = this.zzb;
        return hashCode ^ (zzdgVar == null ? 0 : zzdgVar.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(valueOf2).length());
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzcy
    final Context zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzcy
    @Nullable
    final zzdg<zzde<zzco>> zzb() {
        return this.zzb;
    }
}
