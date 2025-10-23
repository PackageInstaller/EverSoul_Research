package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzau implements Iterator<zzaq> {
    private int zza = 0;
    private final /* synthetic */ zzas zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final /* synthetic */ zzaq next() {
        String str;
        String str2;
        int i = this.zza;
        str = this.zzb.zza;
        if (i >= str.length()) {
            throw new NoSuchElementException();
        }
        str2 = this.zzb.zza;
        int i2 = this.zza;
        this.zza = i2 + 1;
        return new zzas(String.valueOf(str2.charAt(i2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzau(zzas zzasVar) {
        this.zzb = zzasVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        String str;
        int i = this.zza;
        str = this.zzb.zza;
        return i < str.length();
    }
}
