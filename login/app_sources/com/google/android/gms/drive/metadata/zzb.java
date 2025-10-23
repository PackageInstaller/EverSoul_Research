package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class zzb<T> extends zza<Collection<T>> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzb(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public Collection<T> zzc(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
