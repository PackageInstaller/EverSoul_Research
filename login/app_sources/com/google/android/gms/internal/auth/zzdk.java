package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public final class zzdk {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> zzdg<T> zza(zzdg<T> zzdgVar) {
        return ((zzdgVar instanceof zzdi) || (zzdgVar instanceof zzdh)) ? zzdgVar : zzdgVar instanceof Serializable ? new zzdh(zzdgVar) : new zzdi(zzdgVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> zzdg<T> zzb(T t) {
        return new zzdj(t);
    }
}
