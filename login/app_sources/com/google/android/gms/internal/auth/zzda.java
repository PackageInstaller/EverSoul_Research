package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public final class zzda implements zzck {
    private static final Map<String, zzda> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzda zza(Context context, String str) {
        zzda zzdaVar;
        if (zzcc.zza()) {
            throw null;
        }
        synchronized (zzda.class) {
            zzdaVar = zza.get(null);
            if (zzdaVar == null) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    throw null;
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw th;
                }
            }
        }
        return zzdaVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static synchronized void zzc() {
        synchronized (zzda.class) {
            Map<String, zzda> map = zza;
            Iterator<zzda> it = map.values().iterator();
            if (it.hasNext()) {
                zzda next = it.next();
                SharedPreferences sharedPreferences = next.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = next.zzc;
                throw null;
            }
            map.clear();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzck
    public final Object zzb(String str) {
        throw null;
    }
}
