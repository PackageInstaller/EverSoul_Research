package com.google.android.gms.games;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public class AnnotatedData<T> {
    private final Object zza;
    private final boolean zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AnnotatedData(Object obj, boolean z) {
        this.zza = obj;
        this.zzb = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T get() {
        return (T) this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isStale() {
        return this.zzb;
    }
}
