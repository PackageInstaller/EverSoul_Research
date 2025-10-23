package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class zzl<T extends Parcelable> extends com.google.android.gms.drive.metadata.zzb<T> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzl(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public Collection<T> zzb(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ void zza(Bundle bundle, Object obj) {
        Collection collection = (Collection) obj;
        bundle.putParcelableArrayList(getName(), collection instanceof ArrayList ? (ArrayList) collection : new ArrayList<>(collection));
    }
}
