package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

/* loaded from: classes.dex */
public final class zzk implements zzj<Boolean> {
    private Boolean zzmm = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzk() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zza(Filter filter) {
        if (filter == null) {
            return false;
        }
        return ((Boolean) filter.zza(new zzk())).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zzbj() {
        return this.zzmm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zzi(String str) {
        if (!str.isEmpty()) {
            this.zzmm = true;
        }
        return this.zzmm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zzbk() {
        return this.zzmm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zza(zzx zzxVar, List<Boolean> list) {
        return this.zzmm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zza(Boolean bool) {
        return this.zzmm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zza(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return this.zzmm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zzc(MetadataField metadataField, Object obj) {
        return this.zzmm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zza(zzx zzxVar, MetadataField metadataField, Object obj) {
        return this.zzmm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zze(MetadataField metadataField) {
        return this.zzmm;
    }
}
