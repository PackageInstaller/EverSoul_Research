package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import bolts.MeasurementEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzew;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzjf;
import com.google.android.gms.internal.measurement.zznm;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zznx;
import com.google.android.gms.internal.measurement.zzph;
import com.google.android.gms.internal.measurement.zzqa;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzal extends zzmo {
    private static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;"};
    private static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;"};
    private static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzar zzl;
    private final zzmi zzm;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            return m176e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzfp.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzmo
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        try {
            return m176e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zze().zzb(str, zzbg.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzfp.zza(str), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b_ */
    public final long m173b_() {
        Cursor cursor = null;
        try {
            try {
                cursor = m176e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                }
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying raw events", e);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zza(zzfi.zzj zzjVar) throws IOException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzx());
        byte[] zzbv = zzjVar.zzbv();
        long zza2 = mo178g_().zza(zzbv);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza2));
        contentValues.put("metadata", zzbv);
        try {
            m176e_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza2;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzfp.zza(zzjVar.zzx()), e);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final long zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        SQLiteDatabase m176e_ = m176e_();
        m176e_.beginTransaction();
        long j = 0;
        try {
            try {
                long zza2 = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (zza2 == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (m176e_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().zzg().zza("Failed to insert column (got -1). appId", zzfp.zza(str), str2);
                        return -1L;
                    }
                    zza2 = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + zza2));
                    if (m176e_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        zzj().zzg().zza("Failed to update column (got 0). appId", zzfp.zza(str), str2);
                        return -1L;
                    }
                    m176e_.setTransactionSuccessful();
                    return zza2;
                } catch (SQLiteException e) {
                    e = e;
                    j = zza2;
                    zzj().zzg().zza("Error inserting column. appId", zzfp.zza(str), str2, e);
                    m176e_.endTransaction();
                    return j;
                }
            } finally {
                m176e_.endTransaction();
            }
        } catch (SQLiteException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c_ */
    public final long m174c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d_ */
    public final long m175d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = m176e_().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = m176e_().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e_ */
    final SQLiteDatabase m176e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzu().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0089: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0089 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzc(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzt()
            r5.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.m176e_()     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r2 != 0) goto L30
            com.google.android.gms.measurement.internal.zzfp r6 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L2f
            r1.close()
        L2f:
            return r0
        L30:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzfi$zze$zza r3 = com.google.android.gms.internal.measurement.zzfi.zze.zze()     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzku r2 = com.google.android.gms.measurement.internal.zzmz.zza(r3, r2)     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzfi$zze$zza r2 = (com.google.android.gms.internal.measurement.zzfi.zze.zza) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzkr r2 = r2.zzah()     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzjf r2 = (com.google.android.gms.internal.measurement.zzjf) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzfi$zze r2 = (com.google.android.gms.internal.measurement.zzfi.zze) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            r5.mo178g_()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.util.List r6 = r2.zzh()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zzmz.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L56
            r1.close()
        L56:
            return r6
        L57:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfp r3 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfp.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            r3.zza(r4, r6, r2)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L6e
            r1.close()
        L6e:
            return r0
        L6f:
            r6 = move-exception
            goto L75
        L71:
            r6 = move-exception
            goto L8a
        L73:
            r6 = move-exception
            r1 = r0
        L75:
            com.google.android.gms.measurement.internal.zzfp r2 = r5.zzj()     // Catch: java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzg()     // Catch: java.lang.Throwable -> L88
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch: java.lang.Throwable -> L88
            if (r1 == 0) goto L87
            r1.close()
        L87:
            return r0
        L88:
            r6 = move-exception
            r0 = r1
        L8a:
            if (r0 == 0) goto L8f
            r0.close()
        L8f:
            throw r6
            fill-array 0x0090: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0091: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0091 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzfi.zze, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzt()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.m176e_()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzfp r8 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzp()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzfi$zze$zza r4 = com.google.android.gms.internal.measurement.zzfi.zze.zze()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzku r2 = com.google.android.gms.measurement.internal.zzmz.zza(r4, r2)     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzfi$zze$zza r2 = (com.google.android.gms.internal.measurement.zzfi.zze.zza) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzkr r2 = r2.zzah()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzjf r2 = (com.google.android.gms.internal.measurement.zzjf) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzfi$zze r2 = (com.google.android.gms.internal.measurement.zzfi.zze) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            return r8
        L5f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfp r3 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfp.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r0
        L77:
            r8 = move-exception
            goto L7d
        L79:
            r8 = move-exception
            goto L92
        L7b:
            r8 = move-exception
            r1 = r0
        L7d:
            com.google.android.gms.measurement.internal.zzfp r9 = r7.zzj()     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzfr r9 = r9.zzg()     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8f
            r1.close()
        L8f:
            return r0
        L90:
            r8 = move-exception
            r0 = r1
        L92:
            if (r0 == 0) goto L97
            r0.close()
        L97:
            throw r8
            fill-array 0x0098: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0193 A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ab A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01d2 A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01fe A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021f A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0243 A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0269 A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027f A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0297 A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TRY_LEAVE, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0184 A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x012f A[Catch: SQLiteException -> 0x02ae, all -> 0x02d7, TryCatch #2 {all -> 0x02d7, blocks: (B:14:0x007f, B:16:0x00e0, B:20:0x00ea, B:23:0x0134, B:25:0x0163, B:29:0x016d, B:32:0x0188, B:34:0x0193, B:35:0x01a5, B:37:0x01ab, B:39:0x01b7, B:41:0x01c3, B:42:0x01cc, B:44:0x01d2, B:46:0x01de, B:48:0x01e6, B:51:0x01ef, B:53:0x01fe, B:55:0x0207, B:57:0x021f, B:59:0x022b, B:60:0x023d, B:62:0x0243, B:64:0x024f, B:66:0x0257, B:69:0x0260, B:71:0x0263, B:73:0x0269, B:75:0x0275, B:78:0x028b, B:79:0x027f, B:82:0x0287, B:84:0x028e, B:86:0x0297, B:91:0x0184, B:93:0x012f, B:96:0x02c0), top: B:2:0x000c }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzg zzd(java.lang.String r43) {
        /*
            Method dump skipped, instructions count: 740
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzd(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x012b  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzae zzc(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzae");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x008a */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzan zze(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzt()
            r11.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.m176e_()     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            java.lang.String r4 = "app_id=?"
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            r10 = 0
            r5[r10] = r12     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            if (r2 != 0) goto L35
            if (r1 == 0) goto L34
            r1.close()
        L34:
            return r0
        L35:
            byte[] r2 = r1.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            java.lang.String r3 = r1.getString(r9)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            boolean r5 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            if (r5 == 0) goto L59
            com.google.android.gms.measurement.internal.zzfp r5 = r11.zzj()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzg()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfp.zza(r12)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            r5.zza(r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
        L59:
            if (r2 != 0) goto L61
            if (r1 == 0) goto L60
            r1.close()
        L60:
            return r0
        L61:
            com.google.android.gms.measurement.internal.zzan r5 = new com.google.android.gms.measurement.internal.zzan     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            r5.<init>(r2, r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            if (r1 == 0) goto L6b
            r1.close()
        L6b:
            return r5
        L6c:
            r2 = move-exception
            goto L72
        L6e:
            r12 = move-exception
            goto L8b
        L70:
            r2 = move-exception
            r1 = r0
        L72:
            com.google.android.gms.measurement.internal.zzfp r3 = r11.zzj()     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzg()     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfp.zza(r12)     // Catch: java.lang.Throwable -> L89
            r3.zza(r4, r12, r2)     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L88
            r1.close()
        L88:
            return r0
        L89:
            r12 = move-exception
            r0 = r1
        L8b:
            if (r0 == 0) goto L90
            r0.close()
        L90:
            throw r12
            fill-array 0x0092: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String):com.google.android.gms.measurement.internal.zzan");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzaq zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1L, false, false, z3, false, z5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzaq zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        String[] strArr = {str};
        zzaq zzaqVar = new zzaq();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase m176e_ = m176e_();
                Cursor query = m176e_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    zzj().zzu().zza("Not updating daily counts, app is not known. appId", zzfp.zza(str));
                    if (query != null) {
                        query.close();
                    }
                    return zzaqVar;
                }
                if (query.getLong(0) == j) {
                    zzaqVar.zzb = query.getLong(1);
                    zzaqVar.zza = query.getLong(2);
                    zzaqVar.zzc = query.getLong(3);
                    zzaqVar.zzd = query.getLong(4);
                    zzaqVar.zze = query.getLong(5);
                }
                if (z) {
                    zzaqVar.zzb += j2;
                }
                if (z2) {
                    zzaqVar.zza += j2;
                }
                if (z3) {
                    zzaqVar.zzc += j2;
                }
                if (z4) {
                    zzaqVar.zzd += j2;
                }
                if (z5) {
                    zzaqVar.zze += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzaqVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzaqVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzaqVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzaqVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzaqVar.zze));
                m176e_.update("apps", contentValues, "app_id=?", strArr);
                if (query != null) {
                    query.close();
                }
                return zzaqVar;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error updating daily counts. appId", zzfp.zza(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return zzaqVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzav zzf(String str) {
        if (!zzns.zza() || !zze().zza(zzbg.zzcm)) {
            return zzav.zza;
        }
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        return zzav.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x014c: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:71:0x014c */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0147  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzba zzd(java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzba");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzif zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        if (zzns.zza() && zze().zza(zzbg.zzcm)) {
            zzif zzifVar = (zzif) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzas() { // from class: com.google.android.gms.measurement.internal.zzao
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.measurement.internal.zzas
                public final Object zza(Cursor cursor) {
                    zzif zza2;
                    zza2 = zzif.zza(cursor.getString(0), cursor.getInt(1));
                    return zza2;
                }
            });
            return zzifVar == null ? zzif.zza : zzifVar;
        }
        return zzif.zza(zza("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zznd zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzt()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.m176e_()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            if (r3 != 0) goto L3f
            if (r10 == 0) goto L3e
            r10.close()
        L3e:
            return r9
        L3f:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            if (r7 != 0) goto L51
            if (r10 == 0) goto L50
            r10.close()
        L50:
            return r9
        L51:
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            com.google.android.gms.measurement.internal.zznd r0 = new com.google.android.gms.measurement.internal.zznd     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            if (r1 == 0) goto L76
            com.google.android.gms.measurement.internal.zzfp r1 = r18.zzj()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzg()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfp.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
        L76:
            if (r10 == 0) goto L7b
            r10.close()
        L7b:
            return r0
        L7c:
            r0 = move-exception
            goto L8e
        L7e:
            r0 = move-exception
            r11 = r18
            goto Lae
        L82:
            r0 = move-exception
            r11 = r18
            goto L8e
        L86:
            r0 = move-exception
            r11 = r18
            goto Laf
        L8a:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L8e:
            com.google.android.gms.measurement.internal.zzfp r1 = r18.zzj()     // Catch: java.lang.Throwable -> Lad
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzg()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfp.zza(r19)     // Catch: java.lang.Throwable -> Lad
            com.google.android.gms.measurement.internal.zzfo r4 = r18.zzi()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> Lad
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lad
            if (r10 == 0) goto Lac
            r10.close()
        Lac:
            return r9
        Lad:
            r0 = move-exception
        Lae:
            r9 = r10
        Laf:
            if (r9 == 0) goto Lb4
            r9.close()
        Lb4:
            throw r0
            fill-array 0x00b6: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zznd");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzas<T> r5) {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.m176e_()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30
            boolean r4 = r3.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r4 != 0) goto L22
            com.google.android.gms.measurement.internal.zzfp r4 = r2.zzj()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzp()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r3 == 0) goto L21
            r3.close()
        L21:
            return r0
        L22:
            java.lang.Object r4 = r5.zza(r3)     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r3 == 0) goto L2b
            r3.close()
        L2b:
            return r4
        L2c:
            r4 = move-exception
            goto L32
        L2e:
            r4 = move-exception
            goto L47
        L30:
            r4 = move-exception
            r3 = r0
        L32:
            com.google.android.gms.measurement.internal.zzfp r5 = r2.zzj()     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzg()     // Catch: java.lang.Throwable -> L45
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L44
            r3.close()
        L44:
            return r0
        L45:
            r4 = move-exception
            r0 = r3
        L47:
            if (r0 == 0) goto L4c
            r0.close()
        L4c:
            throw r4
            fill-array 0x004e: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzas):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzt()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.m176e_()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzfp r6 = r4.zzj()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L44
        L40:
            r6 = move-exception
            goto L59
        L42:
            r6 = move-exception
            r5 = r0
        L44:
            com.google.android.gms.measurement.internal.zzfp r1 = r4.zzj()     // Catch: java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzg()     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L56
            r5.close()
        L56:
            return r0
        L57:
            r6 = move-exception
            r0 = r5
        L59:
            if (r0 == 0) goto L5e
            r0.close()
        L5e:
            throw r6
            fill-array 0x0060: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: f_ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m177f_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.m176e_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            com.google.android.gms.measurement.internal.zzfp r3 = r6.zzj()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzg()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
            fill-array 0x0046: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.m177f_():java.lang.String");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = m176e_().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getString(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return str2;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0183 A[EDGE_INSN: B:65:0x0183->B:26:0x0183 BREAK  A[LOOP:0: B:17:0x0056->B:78:0x0180], SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzfi.zzj, java.lang.Long>> zza(java.lang.String r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<zzae> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzae> zza(java.lang.String r25, java.lang.String[] r26) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<zzmh> zzh(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = m176e_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzmh(string, cursor.getLong(1), cursor.getInt(2)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzfp.zza(str), e);
                List<zzmh> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<zznd> zzi(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = m176e_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = cursor.getLong(2);
                    Object zza2 = zza(cursor, 3);
                    if (zza2 == null) {
                        zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzfp.zza(str));
                    } else {
                        arrayList.add(new zznd(str, str2, string, j, zza2));
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying user properties. appId", zzfp.zza(str), e);
                List<zznd> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x009b, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0128  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zznd> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Map<Integer, zzfi.zzl> zzj(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = m176e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, zzfi.zzl> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = query.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (zzfi.zzl) ((com.google.android.gms.internal.measurement.zzjf) ((zzfi.zzl.zza) zzmz.zza(zzfi.zzl.zze(), query.getBlob(1))).zzah()));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzfp.zza(str), Integer.valueOf(i), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filter results. appId", zzfp.zza(str), e2);
                Map<Integer, zzfi.zzl> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Map<Integer, List<zzew.zzb>> zzk(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = m176e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzew.zzb>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzew.zzb zzbVar = (zzew.zzb) ((com.google.android.gms.internal.measurement.zzjf) ((zzew.zzb.zza) zzmz.zza(zzew.zzb.zzc(), query.getBlob(1))).zzah());
                        if (zzbVar.zzk()) {
                            int i = query.getInt(0);
                            List list = (List) arrayMap.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), list);
                            }
                            list.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzfp.zza(str), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzfp.zza(str), e2);
                Map<Integer, List<zzew.zzb>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Map<Integer, List<zzew.zzb>> zzf(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = m176e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzew.zzb>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzew.zzb zzbVar = (zzew.zzb) ((com.google.android.gms.internal.measurement.zzjf) ((zzew.zzb.zza) zzmz.zza(zzew.zzb.zzc(), query.getBlob(1))).zzah());
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzbVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzfp.zza(str), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzfp.zza(str), e2);
                Map<Integer, List<zzew.zzb>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Map<Integer, List<zzew.zze>> zzg(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = m176e_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzew.zze>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzew.zze zzeVar = (zzew.zze) ((com.google.android.gms.internal.measurement.zzjf) ((zzew.zze.zza) zzmz.zza(zzew.zze.zzc(), query.getBlob(1))).zzah());
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzeVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter", zzfp.zza(str), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzfp.zza(str), e2);
                Map<Integer, List<zzew.zze>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Map<Integer, List<Integer>> zzl(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = m176e_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!rawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return emptyMap;
                }
                do {
                    int i = rawQuery.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(Integer.valueOf(rawQuery.getInt(1)));
                } while (rawQuery.moveToNext());
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzfp.zza(str), e);
                Map<Integer, List<Integer>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzal(zzmp zzmpVar) {
        super(zzmpVar);
        this.zzm = new zzmi(zzb());
        this.zzl = new zzar(this, zza(), "google_app_measurement.db");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzp() {
        zzak();
        m176e_().beginTransaction();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzu() {
        zzak();
        m176e_().endTransaction();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(List<Long> list) {
        zzt();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzan()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                m176e_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzv() {
        int delete;
        zzt();
        zzak();
        if (zzan()) {
            long zza2 = zzn().zza.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzbg.zzy.zza(null).longValue()) {
                zzn().zza.zza(elapsedRealtime);
                zzt();
                zzak();
                if (!zzan() || (delete = m176e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzag.zzm())})) <= 0) {
                    return;
                }
                zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            m176e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzfp.zza(str), zzi().zzc(str2), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(String str, List<zzew.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzew.zza.C2948zza zzby = list.get(i).zzby();
            if (zzby.zza() != 0) {
                for (int i2 = 0; i2 < zzby.zza(); i2++) {
                    zzew.zzb.zza zzby2 = zzby.zza(i2).zzby();
                    zzew.zzb.zza zzaVar = (zzew.zzb.zza) ((zzjf.zzb) zzby2.clone());
                    String zzb2 = zzig.zzb(zzby2.zzb());
                    if (zzb2 != null) {
                        zzaVar.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzby2.zza(); i3++) {
                        zzew.zzc zza2 = zzby2.zza(i3);
                        String zza3 = zzii.zza(zza2.zze());
                        if (zza3 != null) {
                            zzaVar.zza(i3, (zzew.zzc) ((com.google.android.gms.internal.measurement.zzjf) zza2.zzby().zza(zza3).zzah()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zzby = zzby.zza(i2, zzaVar);
                        list.set(i, (zzew.zza) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah()));
                    }
                }
            }
            if (zzby.zzb() != 0) {
                for (int i4 = 0; i4 < zzby.zzb(); i4++) {
                    zzew.zze zzb3 = zzby.zzb(i4);
                    String zza4 = zzih.zza(zzb3.zze());
                    if (zza4 != null) {
                        zzby = zzby.zza(i4, zzb3.zzby().zza(zza4));
                        list.set(i, (zzew.zza) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah()));
                    }
                }
            }
        }
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase m176e_ = m176e_();
        m176e_.beginTransaction();
        try {
            zzak();
            zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase m176e_2 = m176e_();
            m176e_2.delete("property_filters", "app_id=?", new String[]{str});
            m176e_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzew.zza zzaVar2 : list) {
                zzak();
                zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zzg()) {
                    zzj().zzu().zza("Audience with no ID. appId", zzfp.zza(str));
                } else {
                    int zza5 = zzaVar2.zza();
                    Iterator<zzew.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfp.zza(str), Integer.valueOf(zza5));
                                break;
                            }
                        } else {
                            Iterator<zzew.zze> it2 = zzaVar2.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfp.zza(str), Integer.valueOf(zza5));
                                        break;
                                    }
                                } else {
                                    Iterator<zzew.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, zza5, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzew.zze> it4 = zzaVar2.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, zza5, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase m176e_3 = m176e_();
                                        m176e_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zza5)});
                                        m176e_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zza5)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzew.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zzg() ? Integer.valueOf(zzaVar3.zza()) : null);
            }
            zzb(str, arrayList);
            m176e_.setTransactionSuccessful();
        } finally {
            m176e_.endTransaction();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzw() {
        zzak();
        m176e_().setTransactionSuccessful();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzg zzgVar) {
        Preconditions.checkNotNull(zzgVar);
        zzt();
        zzak();
        String zzx = zzgVar.zzx();
        Preconditions.checkNotNull(zzx);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzx);
        contentValues.put("app_instance_id", zzgVar.zzy());
        contentValues.put("gmp_app_id", zzgVar.zzac());
        contentValues.put("resettable_device_id_hash", zzgVar.zzae());
        contentValues.put("last_bundle_index", Long.valueOf(zzgVar.zzq()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzgVar.zzr()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzgVar.zzp()));
        contentValues.put("app_version", zzgVar.zzaa());
        contentValues.put("app_store", zzgVar.zzz());
        contentValues.put("gmp_version", Long.valueOf(zzgVar.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzgVar.zzl()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzgVar.zzal()));
        contentValues.put("day", Long.valueOf(zzgVar.zzk()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzgVar.zzi()));
        contentValues.put("daily_events_count", Long.valueOf(zzgVar.zzh()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzgVar.zzf()));
        contentValues.put("config_fetched_time", Long.valueOf(zzgVar.zze()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzgVar.zzn()));
        contentValues.put("app_version_int", Long.valueOf(zzgVar.zzc()));
        contentValues.put("firebase_instance_id", zzgVar.zzab());
        contentValues.put("daily_error_events_count", Long.valueOf(zzgVar.zzg()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzgVar.zzj()));
        contentValues.put("health_monitor_sample", zzgVar.zzad());
        contentValues.put("android_id", Long.valueOf(zzgVar.zzb()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzgVar.zzak()));
        contentValues.put("admob_app_id", zzgVar.zzv());
        contentValues.put("dynamite_version", Long.valueOf(zzgVar.zzm()));
        contentValues.put("session_stitching_token", zzgVar.zzaf());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzgVar.zzan()));
        contentValues.put("target_os_version", Long.valueOf(zzgVar.zzt()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzgVar.zzs()));
        if (zzph.zza() && zze().zze(zzx, zzbg.zzce)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzgVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzgVar.zzd()));
        }
        if (zznm.zza() && zze().zze(zzx, zzbg.zzcr)) {
            contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzgVar.zzao()));
        }
        if (zzqa.zza() && zze().zze(zzx, zzbg.zzbt)) {
            contentValues.put("sgtm_preview_key", zzgVar.zzag());
        }
        List<String> zzah = zzgVar.zzah();
        if (zzah != null) {
            if (zzah.isEmpty()) {
                zzj().zzu().zza("Safelisted events should not be an empty list. appId", zzx);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzah));
            }
        }
        if (zznx.zza() && zze().zza(zzbg.zzbn) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        if (zzns.zza() && zze().zze(zzx, zzbg.zzcm)) {
            contentValues.put("npa_metadata_value", zzgVar.zzu());
        }
        try {
            SQLiteDatabase m176e_ = m176e_();
            if (m176e_.update("apps", contentValues, "app_id = ?", new String[]{zzx}) == 0 && m176e_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzfp.zza(zzx));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing app. appId", zzfp.zza(zzx), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, zzif zzifVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzifVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzifVar.zze());
        if (zzns.zza() && zze().zza(zzbg.zzcm)) {
            contentValues.put("consent_source", Integer.valueOf(zzifVar.zza()));
            zza("consent_settings", "app_id", contentValues);
            return;
        }
        try {
            if (m176e_().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update consent setting (got -1). appId", zzfp.zza(str));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing consent setting. appId, error", zzfp.zza(str), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, zzav zzavVar) {
        if (zzns.zza() && zze().zza(zzbg.zzcm)) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(zzavVar);
            zzt();
            zzak();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("dma_consent_settings", zzavVar.zzf());
            zza("consent_settings", "app_id", contentValues);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzba zzbaVar) {
        Preconditions.checkNotNull(zzbaVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbaVar.zza);
        contentValues.put("name", zzbaVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbaVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbaVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbaVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbaVar.zzg));
        contentValues.put("last_bundled_day", zzbaVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbaVar.zzi);
        contentValues.put("last_sampling_rate", zzbaVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbaVar.zze));
        contentValues.put("last_exempt_from_sampling", (zzbaVar.zzk == null || !zzbaVar.zzk.booleanValue()) ? null : 1L);
        try {
            if (m176e_().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzfp.zza(zzbaVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzfp.zza(zzbaVar.zza), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase m176e_ = m176e_();
            if (contentValues.getAsString(str2) == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzfp.zza(str2));
            } else if (m176e_.update(str, contentValues, str2 + " = ?", new String[]{r1}) == 0 && m176e_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzfp.zza(str), zzfp.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzfp.zza(str), zzfp.zza(str2), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzt();
        SQLiteDatabase m176e_ = m176e_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zze().zzb(str, zzbg.zzaf)));
            if (zzb2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            return m176e_.delete("audience_filter_values", new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(new StringBuilder("(").append(TextUtils.join(",", arrayList)).append(")").toString()).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzfp.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(zzfi.zzj zzjVar, boolean z) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzx());
        Preconditions.checkState(zzjVar.zzbe());
        zzv();
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzjVar.zzl() < currentTimeMillis - zzag.zzm() || zzjVar.zzl() > zzag.zzm() + currentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfp.zza(zzjVar.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzjVar.zzl()));
        }
        try {
            byte[] zzb2 = mo178g_().zzb(zzjVar.zzbv());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(zzb2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzjVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzjVar.zzl()));
            contentValues.put("data", zzb2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzjVar.zzbl()) {
                contentValues.put("retry_count", Integer.valueOf(zzjVar.zzf()));
            }
            try {
                if (m176e_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzfp.zza(zzjVar.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzfp.zza(zzjVar.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzfp.zza(zzjVar.zzx()), e2);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zza(String str, int i, zzew.zzb zzbVar) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzu().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfp.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] zzbv = zzbVar.zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put(MeasurementEvent.MEASUREMENT_EVENT_NAME_KEY, zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", zzbv);
        try {
            if (m176e_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzfp.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzfp.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zza(String str, int i, zzew.zze zzeVar) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzu().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfp.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] zzbv = zzeVar.zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", zzbv);
        try {
            if (m176e_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzfp.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzfp.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(zzax zzaxVar, long j, boolean z) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzaxVar);
        Preconditions.checkNotEmpty(zzaxVar.zza);
        byte[] zzbv = mo178g_().zza(zzaxVar).zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaxVar.zza);
        contentValues.put("name", zzaxVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzaxVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbv);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (m176e_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzfp.zza(zzaxVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzfp.zza(zzaxVar.zza), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(String str, zzmh zzmhVar) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzmhVar);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzmhVar.zzb < currentTimeMillis - zzag.zzm() || zzmhVar.zzb > zzag.zzm() + currentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzfp.zza(str), Long.valueOf(currentTimeMillis), Long.valueOf(zzmhVar.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmhVar.zza);
        contentValues.put("source", Integer.valueOf(zzmhVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzmhVar.zzb));
        try {
            if (m176e_().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzfp.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzfp.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzan() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(String str, Long l, long j, zzfi.zze zzeVar) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzeVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbv = zzeVar.zzbv();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(zzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbv);
        try {
            if (m176e_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzfp.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzfp.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(zzae zzaeVar) {
        Preconditions.checkNotNull(zzaeVar);
        zzt();
        zzak();
        String str = zzaeVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzaeVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaeVar.zzb);
        contentValues.put("name", zzaeVar.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzaeVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzaeVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaeVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaeVar.zzh));
        zzq();
        contentValues.put("timed_out_event", zzng.zza((Parcelable) zzaeVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaeVar.zzd));
        zzq();
        contentValues.put("triggered_event", zzng.zza((Parcelable) zzaeVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaeVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaeVar.zzj));
        zzq();
        contentValues.put("expired_event", zzng.zza((Parcelable) zzaeVar.zzk));
        try {
            if (m176e_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzfp.zza(str));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzfp.zza(str), e);
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zza(String str, Bundle bundle) {
        zzt();
        zzak();
        byte[] zzbv = mo178g_().zza(new zzax(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzbv();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(zzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbv);
        try {
            if (m176e_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzfp.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzfp.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(zznd zzndVar) {
        Preconditions.checkNotNull(zzndVar);
        zzt();
        zzak();
        if (zze(zzndVar.zza, zzndVar.zzc) == null) {
            if (zzng.zzh(zzndVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzndVar.zza}) >= zze().zza(zzndVar.zza, zzbg.zzag, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzndVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzndVar.zza, zzndVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzndVar.zza);
        contentValues.put("origin", zzndVar.zzb);
        contentValues.put("name", zzndVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzndVar.zzd));
        zza(contentValues, "value", zzndVar.zze);
        try {
            if (m176e_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzfp.zza(zzndVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzfp.zza(zzndVar.zza), e);
        }
        return true;
    }
}
