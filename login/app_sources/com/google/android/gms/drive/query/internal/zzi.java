package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

/* loaded from: classes.dex */
final class zzi {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static MetadataField<?> zza(MetadataBundle metadataBundle) {
        Set<MetadataField<?>> zzbg = metadataBundle.zzbg();
        if (zzbg.size() == 1) {
            return zzbg.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
