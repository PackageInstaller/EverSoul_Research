package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.singular.sdk.internal.Constants;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.1 */
/* loaded from: classes2.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzct {
    zzhd zza = null;
    private final Map<Integer, zzij> zzb = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.1 */
    class zza implements zzij {
        private com.google.android.gms.internal.measurement.zzda zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(com.google.android.gms.internal.measurement.zzda zzdaVar) {
            this.zza = zzdaVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.measurement.internal.zzij
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                if (AppMeasurementDynamiteService.this.zza != null) {
                    AppMeasurementDynamiteService.this.zza.zzj().zzu().zza("Event listener threw exception", e);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.1 */
    class zzb implements zzik {
        private com.google.android.gms.internal.measurement.zzda zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzb(com.google.android.gms.internal.measurement.zzda zzdaVar) {
            this.zza = zzdaVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.measurement.internal.zzik
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                if (AppMeasurementDynamiteService.this.zza != null) {
                    AppMeasurementDynamiteService.this.zza.zzj().zzu().zza("Event interceptor threw exception", e);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zze().zza(str, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @EnsuresNonNull({"scion"})
    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void clearMeasurementEnabled(long j) throws RemoteException {
        zza();
        this.zza.zzp().zza((Boolean) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zze().zzb(str, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void generateEventId(com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        long zzm = this.zza.zzt().zzm();
        zza();
        this.zza.zzt().zza(zzcvVar, zzm);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzi(this, zzcvVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        zza(zzcvVar, this.zza.zzp().zzae());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzm(this, zzcvVar, str, str2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        zza(zzcvVar, this.zza.zzp().zzaf());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        zza(zzcvVar, this.zza.zzp().zzag());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        zza(zzcvVar, this.zza.zzp().zzah());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        this.zza.zzp();
        Preconditions.checkNotEmpty(str);
        zza();
        this.zza.zzt().zza(zzcvVar, 25);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getSessionId(com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        zzio zzp = this.zza.zzp();
        zzp.zzl().zzb(new zzjq(zzp, zzcvVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcv zzcvVar, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzt().zza(zzcvVar, this.zza.zzp().zzai());
            return;
        }
        if (i == 1) {
            this.zza.zzt().zza(zzcvVar, this.zza.zzp().zzad().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzt().zza(zzcvVar, this.zza.zzp().zzac().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzt().zza(zzcvVar, this.zza.zzp().zzaa().booleanValue());
                return;
            }
        }
        zzng zzt = this.zza.zzt();
        double doubleValue = this.zza.zzp().zzab().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble(Constants.REVENUE_AMOUNT_KEY, doubleValue);
        try {
            zzcvVar.zza(bundle);
        } catch (RemoteException e) {
            zzt.zzu.zzj().zzu().zza("Error returning double value to wrapper", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzk(this, zzcvVar, str, str2, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdd zzddVar, long j) throws RemoteException {
        zzhd zzhdVar = this.zza;
        if (zzhdVar == null) {
            this.zza = zzhd.zza((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzddVar, Long.valueOf(j));
        } else {
            zzhdVar.zzj().zzu().zza("Attempting to initialize multiple times");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcv zzcvVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzl(this, zzcvVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle, z, z2, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcv zzcvVar, long j) throws RemoteException {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzl().zzb(new zzh(this, zzcvVar, new zzbe(str2, new zzaz(bundle), "app", j), str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        this.zza.zzj().zza(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzjx zzjxVar = this.zza.zzp().zza;
        if (zzjxVar != null) {
            this.zza.zzp().zzak();
            zzjxVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjxVar = this.zza.zzp().zza;
        if (zzjxVar != null) {
            this.zza.zzp().zzak();
            zzjxVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjxVar = this.zza.zzp().zza;
        if (zzjxVar != null) {
            this.zza.zzp().zzak();
            zzjxVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjxVar = this.zza.zzp().zza;
        if (zzjxVar != null) {
            this.zza.zzp().zzak();
            zzjxVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcv zzcvVar, long j) throws RemoteException {
        zza();
        zzjx zzjxVar = this.zza.zzp().zza;
        Bundle bundle = new Bundle();
        if (zzjxVar != null) {
            this.zza.zzp().zzak();
            zzjxVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcvVar.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzj().zzu().zza("Error returning bundle value to wrapper", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjxVar = this.zza.zzp().zza;
        if (zzjxVar != null) {
            this.zza.zzp().zzak();
            zzjxVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzjx zzjxVar = this.zza.zzp().zza;
        if (zzjxVar != null) {
            this.zza.zzp().zzak();
            zzjxVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcv zzcvVar, long j) throws RemoteException {
        zza();
        zzcvVar.zza(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzij zzijVar;
        zza();
        synchronized (this.zzb) {
            zzijVar = this.zzb.get(Integer.valueOf(zzdaVar.zza()));
            if (zzijVar == null) {
                zzijVar = new zza(zzdaVar);
                this.zzb.put(Integer.valueOf(zzdaVar.zza()), zzijVar);
            }
        }
        this.zza.zzp().zza(zzijVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        zzio zzp = this.zza.zzp();
        zzp.zza((String) null);
        zzp.zzl().zzb(new zzjj(zzp, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(com.google.android.gms.internal.measurement.zzcv zzcvVar, String str) {
        zza();
        this.zza.zzt().zza(zzcvVar, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzj().zzg().zza("Conditional user property must not be null");
        } else {
            this.zza.zzp().zza(bundle, j);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setConsent(final Bundle bundle, final long j) throws RemoteException {
        zza();
        final zzio zzp = this.zza.zzp();
        zzp.zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziu
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                zzio zzioVar = zzio.this;
                Bundle bundle2 = bundle;
                long j2 = j;
                if (TextUtils.isEmpty(zzioVar.zzg().zzae())) {
                    zzioVar.zza(bundle2, 0, j2);
                } else {
                    zzioVar.zzj().zzv().zza("Using developer consent only; google app id found");
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(bundle, -20, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzq().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        zzio zzp = this.zza.zzp();
        zzp.zzu();
        zzp.zzl().zzb(new zzjc(zzp, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        final zzio zzp = this.zza.zzp();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzp.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzir
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                zzio.this.zza(bundle2);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zza();
        zzb zzbVar = new zzb(zzdaVar);
        if (this.zza.zzl().zzg()) {
            this.zza.zzp().zza(zzbVar);
        } else {
            this.zza.zzl().zzb(new zzj(this, zzbVar));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdb zzdbVar) throws RemoteException {
        zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(Boolean.valueOf(z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        zzio zzp = this.zza.zzp();
        zzp.zzl().zzb(new zzje(zzp, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setUserId(final String str, long j) throws RemoteException {
        zza();
        final zzio zzp = this.zza.zzp();
        if (str != null && TextUtils.isEmpty(str)) {
            zzp.zzu.zzj().zzu().zza("User ID must be non-empty or null");
        } else {
            zzp.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziv
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    zzio zzioVar = zzio.this;
                    if (zzioVar.zzg().zzb(str)) {
                        zzioVar.zzg().zzag();
                    }
                }
            });
            zzp.zza((String) null, "_id", (Object) str, true, j);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcu
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzij remove;
        zza();
        synchronized (this.zzb) {
            remove = this.zzb.remove(Integer.valueOf(zzdaVar.zza()));
        }
        if (remove == null) {
            remove = new zza(zzdaVar);
        }
        this.zza.zzp().zzb(remove);
    }
}
