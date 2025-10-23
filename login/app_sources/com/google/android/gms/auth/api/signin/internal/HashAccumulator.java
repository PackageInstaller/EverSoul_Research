package com.google.android.gms.auth.api.signin.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public class HashAccumulator {
    private int zaa = 1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashAccumulator addObject(Object obj) {
        this.zaa = (this.zaa * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hash() {
        return this.zaa;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final HashAccumulator zaa(boolean z) {
        this.zaa = (this.zaa * 31) + (z ? 1 : 0);
        return this;
    }
}
