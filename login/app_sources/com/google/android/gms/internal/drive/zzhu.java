package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import java.util.Collection;

/* loaded from: classes2.dex */
final class zzhu extends com.google.android.gms.drive.metadata.internal.zzm<BitmapTeleporter> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhu(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, GmsVersion.VERSION_KENAFA);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        throw new IllegalStateException("Thumbnail field is write only");
    }
}
