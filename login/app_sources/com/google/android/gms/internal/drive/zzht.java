package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import java.util.Collection;

/* loaded from: classes2.dex */
final class zzht extends com.google.android.gms.drive.metadata.internal.zzb {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzht(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, GmsVersion.VERSION_ORLA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.internal.zzb
    /* renamed from: zze */
    public final Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getInteger("trashed", i, i2) == 2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return zzc(dataHolder, i, i2);
    }
}
