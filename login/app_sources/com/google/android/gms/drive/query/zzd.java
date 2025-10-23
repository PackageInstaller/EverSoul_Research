package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.zzj;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.List;

/* loaded from: classes.dex */
public final class zzd implements zzj<String> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zzbj() {
        return "ownedByMe()";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zzbk() {
        return "all()";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zzi(String str) {
        return String.format("fullTextSearch(%s)", str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zza(zzx zzxVar, List<String> list) {
        StringBuilder sb = new StringBuilder(String.valueOf(zzxVar.getTag()).concat("("));
        String str = "";
        for (String str2 : list) {
            sb.append(str);
            sb.append(str2);
            str = ",";
        }
        return sb.append(")").toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zza(String str) {
        return String.format("not(%s)", str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zza(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return String.format("contains(%s,%s)", zzbVar.getName(), obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zzc(MetadataField metadataField, Object obj) {
        return String.format("has(%s,%s)", metadataField.getName(), obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zza(zzx zzxVar, MetadataField metadataField, Object obj) {
        return String.format("cmp(%s,%s,%s)", zzxVar.getTag(), metadataField.getName(), obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zze(MetadataField metadataField) {
        return String.format("fieldOnly(%s)", metadataField.getName());
    }
}
