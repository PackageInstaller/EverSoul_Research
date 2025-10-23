package com.google.android.gms.internal.auth;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzdc<T> extends zzde<T> {
    static final zzdc<Object> zza = new zzdc<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzdc() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return 2040732332;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "Optional.absent()";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzde
    public final T zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzde
    public final boolean zzb() {
        return false;
    }
}
