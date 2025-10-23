package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import java.util.Collection;

/* loaded from: classes.dex */
public class zzb extends com.google.android.gms.drive.metadata.zza<Boolean> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzb(String str, int i) {
        super(str, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzb(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, GmsVersion.VERSION_ORLA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getBoolean(getName(), i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ void zza(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Boolean zzb(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
