package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzga implements zzgc {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzgc
    public final String zza(ContentResolver contentResolver, String str) throws zzgb {
        Cursor query = contentResolver.query(zzfu.zza, null, null, new String[]{str}, null);
        try {
            if (query == null) {
                throw new zzgb("Failed to connect to GservicesProvider");
            }
            if (query.moveToFirst()) {
                String string = query.getString(1);
                if (query != null) {
                    query.close();
                }
                return string;
            }
            if (query == null) {
                return null;
            }
            query.close();
            return null;
        } catch (Throwable th) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzgc
    public final <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzfz<T> zzfzVar) throws zzgb {
        Cursor query = contentResolver.query(zzfu.zzb, null, null, strArr, null);
        try {
            if (query == null) {
                throw new zzgb("Failed to connect to GservicesProvider");
            }
            T zza = zzfzVar.zza(query.getCount());
            while (query.moveToNext()) {
                zza.put(query.getString(0), query.getString(1));
            }
            if (query != null) {
                query.close();
            }
            return zza;
        } catch (Throwable th) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
