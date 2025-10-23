package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgt extends LruCache<String, com.google.android.gms.internal.measurement.zzb> {
    private final /* synthetic */ zzgn zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.collection.LruCache
    protected final /* synthetic */ com.google.android.gms.internal.measurement.zzb create(String str) {
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        return zzgn.zza(this.zza, str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgt(zzgn zzgnVar, int i) {
        super(20);
        this.zza = zzgnVar;
    }
}
