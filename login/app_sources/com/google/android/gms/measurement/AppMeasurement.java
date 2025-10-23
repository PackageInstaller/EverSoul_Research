package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhd;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzij;
import com.google.android.gms.measurement.internal.zzik;
import com.google.android.gms.measurement.internal.zzjz;
import com.google.android.gms.measurement.internal.zzkf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
@Deprecated
/* loaded from: classes2.dex */
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zza;
    private final zza zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
    public static class ConditionalUserProperty {
        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ConditionalUserProperty() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzic.zza(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzic.zza(bundle, "origin", String.class, null);
            this.mName = (String) zzic.zza(bundle, "name", String.class, null);
            this.mValue = zzic.zza(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
            this.mTriggerTimeout = ((Long) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
            this.mTimedOutEventParams = (Bundle) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            this.mTriggeredEventName = (String) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
            this.mTriggeredEventParams = (Bundle) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            this.mTimeToLive = ((Long) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
            this.mExpiredEventParams = (Bundle) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
            this.mActive = ((Boolean) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, false)).booleanValue();
            this.mCreationTimestamp = ((Long) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzic.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object zza = zzkf.zza(obj);
                this.mValue = zza;
                if (zza == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
    public interface EventInterceptor extends zzik {
        @Override // com.google.android.gms.measurement.internal.zzik
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
    public interface OnEventListener extends zzij {
        @Override // com.google.android.gms.measurement.internal.zzij
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
    static abstract class zza implements zzjz {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zza() {
        }

        abstract Map<String, Object> zza(boolean z);

        abstract Boolean zzb();

        abstract Double zzc();

        abstract Integer zzd();

        abstract Long zze();

        abstract String zzj();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxUserProperties(String str) {
        return this.zzb.zza(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long generateEventId() {
        return this.zzb.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zza(context, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static AppMeasurement zza(Context context, String str, String str2) {
        if (zza == null) {
            synchronized (AppMeasurement.class) {
                if (zza == null) {
                    zzjz zza2 = zza(context, null);
                    if (zza2 != null) {
                        zza = new AppMeasurement(zza2);
                    } else {
                        zza = new AppMeasurement(zzhd.zza(context, new zzdd(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzjz zza(Context context, Bundle bundle) {
        try {
            return (zzjz) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
        } catch (ClassNotFoundException | Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getBoolean() {
        return this.zzb.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Double getDouble() {
        return this.zzb.zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Integer getInteger() {
        return this.zzb.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Long getLong() {
        return this.zzb.zze();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAppInstanceId() {
        return this.zzb.zzf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getCurrentScreenClass() {
        return this.zzb.zzg();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getCurrentScreenName() {
        return this.zzb.zzh();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getGmpAppId() {
        return this.zzb.zzi();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getString() {
        return this.zzb.zzj();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> zza2 = this.zzb.zza(str, str2);
        ArrayList arrayList = new ArrayList(zza2 == null ? 0 : zza2.size());
        Iterator<Bundle> it = zza2.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzb.zza(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzb.zza(str, str2, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AppMeasurement(zzhd zzhdVar) {
        this.zzb = new com.google.android.gms.measurement.zza(zzhdVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AppMeasurement(zzjz zzjzVar) {
        this.zzb = new zzc(zzjzVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void beginAdUnitExposure(String str) {
        this.zzb.zzb(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzb.zza(str, str2, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void endAdUnitExposure(String str) {
        this.zzb.zzc(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.zzb.zzb(str, str2, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzb.zza(str, str2, bundle, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzb.zza(onEventListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zza zzaVar = this.zzb;
        Bundle bundle = new Bundle();
        if (conditionalUserProperty.mAppId != null) {
            bundle.putString("app_id", conditionalUserProperty.mAppId);
        }
        if (conditionalUserProperty.mOrigin != null) {
            bundle.putString("origin", conditionalUserProperty.mOrigin);
        }
        if (conditionalUserProperty.mName != null) {
            bundle.putString("name", conditionalUserProperty.mName);
        }
        if (conditionalUserProperty.mValue != null) {
            zzic.zza(bundle, conditionalUserProperty.mValue);
        }
        if (conditionalUserProperty.mTriggerEventName != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, conditionalUserProperty.mTriggerEventName);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.mTriggerTimeout);
        if (conditionalUserProperty.mTimedOutEventName != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, conditionalUserProperty.mTimedOutEventName);
        }
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, conditionalUserProperty.mTimedOutEventParams);
        }
        if (conditionalUserProperty.mTriggeredEventName != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, conditionalUserProperty.mTriggeredEventName);
        }
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, conditionalUserProperty.mTriggeredEventParams);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.mTimeToLive);
        if (conditionalUserProperty.mExpiredEventName != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, conditionalUserProperty.mExpiredEventName);
        }
        if (conditionalUserProperty.mExpiredEventParams != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, conditionalUserProperty.mExpiredEventParams);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, conditionalUserProperty.mActive);
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.mTriggeredTimestamp);
        zzaVar.zza(bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zzb.zza(eventInterceptor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzb.zzb(onEventListener);
    }
}
