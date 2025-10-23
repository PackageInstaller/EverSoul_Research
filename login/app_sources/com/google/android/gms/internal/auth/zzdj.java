package com.google.android.gms.internal.auth;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzdj<T> implements Serializable, zzdg {
    final T zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdj(T t) {
        this.zza = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof zzdj)) {
            return false;
        }
        T t = this.zza;
        T t2 = ((zzdj) obj).zza;
        return t == t2 || t.equals(t2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzdg
    public final T zza() {
        return this.zza;
    }
}
