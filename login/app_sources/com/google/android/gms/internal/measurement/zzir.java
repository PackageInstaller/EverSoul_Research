package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzir implements zzne {
    private final zzio zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzir zza(zzio zzioVar) {
        return zzioVar.zza != null ? zzioVar.zza : new zzir(zzioVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final int zza() {
        return zznh.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzir(zzio zzioVar) {
        zzio zzioVar2 = (zzio) zzjh.zza(zzioVar, "output");
        this.zza = zzioVar2;
        zzioVar2.zza = this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, boolean z) throws IOException {
        this.zza.zza(i, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zza(list.get(i4).booleanValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, zzhu zzhuVar) throws IOException {
        this.zza.zza(i, zzhuVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, List<zzhu> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zza(i, list.get(i2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zza(list.get(i4).doubleValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzc(i, 4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzd(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzb(int i, int i2) throws IOException {
        this.zza.zza(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zze(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzc(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zza(list.get(i4).floatValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).floatValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, Object obj, zzlj zzljVar) throws IOException {
        zzio zzioVar = this.zza;
        zzioVar.zzc(i, 3);
        zzljVar.zza((zzlj) obj, (zzne) zzioVar.zza);
        zzioVar.zzc(i, 4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, List<?> list, zzlj zzljVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzljVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzf(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzb(int i, long j) throws IOException {
        this.zza.zzb(i, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzd(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final <K, V> void zza(int i, zzkm<K, V> zzkmVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzc(i, 2);
            this.zza.zzc(zzkj.zza(zzkmVar, entry.getKey(), entry.getValue()));
            zzkj.zza(this.zza, zzkmVar, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzb(int i, Object obj, zzlj zzljVar) throws IOException {
        this.zza.zza(i, (zzkr) obj, zzljVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzb(int i, List<?> list, zzlj zzljVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzljVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzhu) {
            this.zza.zzb(i, (zzhu) obj);
        } else {
            this.zza.zza(i, (zzkr) obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzd(int i, int i2) throws IOException {
        this.zza.zza(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzg(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzc(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zze(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zze(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzh(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzk(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzd(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzf(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzc(i, 3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zza(int i, String str) throws IOException {
        this.zza.zza(i, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzjx) {
            zzjx zzjxVar = (zzjx) list;
            while (i2 < list.size()) {
                Object zzb = zzjxVar.zzb(i2);
                if (zzb instanceof String) {
                    this.zza.zza(i, (String) zzb);
                } else {
                    this.zza.zza(i, (zzhu) zzb);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2));
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzj(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zze(int i, long j) throws IOException {
        this.zza.zzb(i, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzne
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzio.zzg(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }
}
