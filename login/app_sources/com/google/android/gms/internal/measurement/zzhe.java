package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzhe implements zzgj {
    private static final Map<String, zzhe> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final Runnable zzc;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzd;
    private final Object zze;
    private volatile Map<String, ?> zzf;
    private final List<zzgh> zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static SharedPreferences zza(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!str.startsWith("direct_boot:")) {
                return context.getSharedPreferences(str, 0);
            }
            if (zzge.zza()) {
                context = context.createDeviceProtectedStorageContext();
            }
            return context.getSharedPreferences(str.substring(12), 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzhe zza(Context context, String str, Runnable runnable) {
        zzhe zzheVar;
        if (!((!zzge.zza() || str.startsWith("direct_boot:")) ? true : zzge.zzb(context))) {
            return null;
        }
        synchronized (zzhe.class) {
            Map<String, zzhe> map = zza;
            zzheVar = map.get(str);
            if (zzheVar == null) {
                zzheVar = new zzhe(zza(context, str), runnable);
                map.put(str, zzheVar);
            }
        }
        return zzheVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzgj
    public final Object zza(String str) {
        Map<String, ?> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                map = this.zzf;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zzf = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzhe(SharedPreferences sharedPreferences, Runnable runnable) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.measurement.zzhh
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                zzhe.this.zza(sharedPreferences2, str);
            }
        };
        this.zzd = onSharedPreferenceChangeListener;
        this.zze = new Object();
        this.zzg = new ArrayList();
        this.zzb = sharedPreferences;
        this.zzc = runnable;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static synchronized void zza() {
        synchronized (zzhe.class) {
            for (zzhe zzheVar : zza.values()) {
                zzheVar.zzb.unregisterOnSharedPreferenceChangeListener(zzheVar.zzd);
            }
            zza.clear();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zze) {
            this.zzf = null;
            this.zzc.run();
        }
        synchronized (this) {
            Iterator<zzgh> it = this.zzg.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }
}
