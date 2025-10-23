package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class zzm<T extends ReflectedParcelable> extends com.google.android.gms.drive.metadata.zza<T> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzm(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ void zza(Bundle bundle, Object obj) {
        bundle.putParcelable(getName(), (ReflectedParcelable) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object zzb(Bundle bundle) {
        return (ReflectedParcelable) bundle.getParcelable(getName());
    }
}
