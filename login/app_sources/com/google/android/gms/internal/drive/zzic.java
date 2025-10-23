package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.metadata.SearchableMetadataField;

/* loaded from: classes2.dex */
public final class zzic extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzic(String str, int i) {
        super(str, GmsVersion.VERSION_HALLOUMI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.internal.zzb
    /* renamed from: zze */
    public final Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getInteger(getName(), i, i2) != 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return zzc(dataHolder, i, i2);
    }
}
