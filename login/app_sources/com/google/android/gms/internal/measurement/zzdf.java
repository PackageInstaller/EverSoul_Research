package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
/* loaded from: classes2.dex */
public class zzdf {
    private static volatile zzdf zzb;
    protected final Clock zza;
    private final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<com.google.android.gms.measurement.internal.zzij, zzb>> zzf;
    private int zzg;
    private boolean zzh;
    private String zzi;
    private volatile zzcu zzj;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
    static class zzb extends zzcz {
        private final com.google.android.gms.measurement.internal.zzij zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzda
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzb(com.google.android.gms.measurement.internal.zzij zzijVar) {
            this.zza = zzijVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzda
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
    static class zzc extends zzcz {
        private final com.google.android.gms.measurement.internal.zzik zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzda
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzc(com.google.android.gms.measurement.internal.zzik zzikVar) {
            this.zza = zzikVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzda
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
    class zzd implements Application.ActivityLifecycleCallbacks {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzd() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzdf.this.zza(new zzeo(this, bundle, activity));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzdf.this.zza(new zzet(this, activity));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzdf.this.zza(new zzes(this, activity));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzdf.this.zza(new zzep(this, activity));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzcs zzcsVar = new zzcs();
            zzdf.this.zza(new zzeu(this, activity, zzcsVar));
            Bundle zza = zzcsVar.zza(50L);
            if (zza != null) {
                bundle.putAll(zza);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzdf.this.zza(new zzeq(this, activity));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzdf.this.zza(new zzer(this, activity));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza(String str) {
        zzcs zzcsVar = new zzcs();
        zza(new zzed(this, str, zzcsVar));
        Integer num = (Integer) zzcs.zza(zzcsVar.zza(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
    abstract class zza implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(zzdf zzdfVar) {
            this(true);
        }

        abstract void zza() throws RemoteException;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void zzb() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(boolean z) {
            this.zza = zzdf.this.zza.currentTimeMillis();
            this.zzb = zzdf.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (zzdf.this.zzh) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzdf.this.zza(e, false, this.zzc);
                zzb();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zza() {
        zzcs zzcsVar = new zzcs();
        zza(new zzdy(this, zzcsVar));
        Long zzb2 = zzcsVar.zzb(500L);
        if (zzb2 == null) {
            long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i = this.zzg + 1;
            this.zzg = i;
            return nextLong + i;
        }
        return zzb2.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zza(Bundle bundle, boolean z) {
        zzcs zzcsVar = new zzcs();
        zza(new zzeb(this, bundle, zzcsVar));
        if (z) {
            return zzcsVar.zza(5000L);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final zzcu zza(Context context, boolean z) {
        try {
            return zzct.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zza((Exception) e, true, false);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzdf zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzdf zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzdf.class) {
                if (zzb == null) {
                    zzb = new zzdf(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long zzc() {
        zzcs zzcsVar = new zzcs();
        zza(new zzef(this, zzcsVar));
        return zzcsVar.zzb(120000L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object zza(int i) {
        zzcs zzcsVar = new zzcs();
        zza(new zzei(this, zzcsVar, i));
        return zzcs.zza(zzcsVar.zza(15000L), Object.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzd() {
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zze() {
        zzcs zzcsVar = new zzcs();
        zza(new zzeg(this, zzcsVar));
        return zzcsVar.zzc(120000L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzf() {
        zzcs zzcsVar = new zzcs();
        zza(new zzdv(this, zzcsVar));
        return zzcsVar.zzc(50L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzg() {
        zzcs zzcsVar = new zzcs();
        zza(new zzea(this, zzcsVar));
        return zzcsVar.zzc(500L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzh() {
        zzcs zzcsVar = new zzcs();
        zza(new zzdx(this, zzcsVar));
        return zzcsVar.zzc(500L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzi() {
        zzcs zzcsVar = new zzcs();
        zza(new zzdw(this, zzcsVar));
        return zzcsVar.zzc(500L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Bundle> zza(String str, String str2) {
        zzcs zzcsVar = new zzcs();
        zza(new zzdj(this, str, str2, zzcsVar));
        List<Bundle> list = (List) zzcs.zza(zzcsVar.zza(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzcs zzcsVar = new zzcs();
        zza(new zzdz(this, str, str2, z, zzcsVar));
        Bundle zza2 = zzcsVar.zza(5000L);
        if (zza2 == null || zza2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zza2.size());
        for (String str3 : zza2.keySet()) {
            Object obj = zza2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzdf(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzch.zza().zza(new zzdr(this), zzcq.zza);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        if (!(!zzb(context) || zzk())) {
            this.zzi = null;
            this.zzh = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        } else {
            this.zzi = str2;
        }
        zza(new zzdi(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzd());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(String str) {
        zza(new zzdu(this, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, String str2, Bundle bundle) {
        zza(new zzdk(this, str, str2, bundle));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(String str) {
        zza(new zzdt(this, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza(new zzel(this, l, str, str2, bundle, z, z2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza(new zzec(this, false, 5, str, obj, null, null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(com.google.android.gms.measurement.internal.zzij zzijVar) {
        Preconditions.checkNotNull(zzijVar);
        synchronized (this.zzf) {
            for (int i = 0; i < this.zzf.size(); i++) {
                if (zzijVar.equals(this.zzf.get(i).first)) {
                    Log.w(this.zzc, "OnEventListener already registered.");
                    return;
                }
            }
            zzb zzbVar = new zzb(zzijVar);
            this.zzf.add(new Pair<>(zzijVar, zzbVar));
            if (this.zzj != null) {
                try {
                    this.zzj.registerOnMeasurementEventListener(zzbVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzc, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza(new zzej(this, zzbVar));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzj() {
        zza(new zzdp(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zza zzaVar) {
        this.zzd.execute(zzaVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Bundle bundle) {
        zza(new zzdh(this, bundle));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(Bundle bundle) {
        zza(new zzdn(this, bundle));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(Bundle bundle) {
        zza(new zzdq(this, bundle));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Activity activity, String str, String str2) {
        zza(new zzdl(this, activity, str, str2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(boolean z) {
        zza(new zzeh(this, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd(Bundle bundle) {
        zza(new zzek(this, bundle));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(com.google.android.gms.measurement.internal.zzik zzikVar) {
        zzc zzcVar = new zzc(zzikVar);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzcVar);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzc, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zza(new zzee(this, zzcVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Boolean bool) {
        zza(new zzdo(this, bool));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(long j) {
        zza(new zzds(this, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd(String str) {
        zza(new zzdm(this, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(new zzen(this, str, str2, obj, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(com.google.android.gms.measurement.internal.zzij zzijVar) {
        Pair<com.google.android.gms.measurement.internal.zzij, zzb> pair;
        Preconditions.checkNotNull(zzijVar);
        synchronized (this.zzf) {
            int i = 0;
            while (true) {
                if (i >= this.zzf.size()) {
                    pair = null;
                    break;
                } else {
                    if (zzijVar.equals(this.zzf.get(i).first)) {
                        pair = this.zzf.get(i);
                        break;
                    }
                    i++;
                }
            }
            if (pair == null) {
                Log.w(this.zzc, "OnEventListener had not been registered.");
                return;
            }
            this.zzf.remove(pair);
            zzb zzbVar = (zzb) pair.second;
            if (this.zzj != null) {
                try {
                    this.zzj.unregisterOnMeasurementEventListener(zzbVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzc, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza(new zzem(this, zzbVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzb(Context context) {
        return new com.google.android.gms.measurement.internal.zzgx(context, com.google.android.gms.measurement.internal.zzgx.zza(context)).zza("google_app_id") != null;
    }
}
