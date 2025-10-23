package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;

/* loaded from: classes2.dex */
public class ConfigMetadataClient {
    private static final String BACKOFF_END_TIME_IN_MILLIS_KEY = "backoff_end_time_in_millis";
    private static final String FETCH_TIMEOUT_IN_SECONDS_KEY = "fetch_timeout_in_seconds";
    private static final String LAST_FETCH_ETAG_KEY = "last_fetch_etag";
    private static final String LAST_FETCH_STATUS_KEY = "last_fetch_status";
    public static final long LAST_FETCH_TIME_IN_MILLIS_NO_FETCH_YET = -1;
    private static final String LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY = "last_fetch_time_in_millis";
    private static final String LAST_TEMPLATE_VERSION = "last_template_version";
    private static final String MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY = "minimum_fetch_interval_in_seconds";
    private static final long NO_BACKOFF_TIME_IN_MILLIS = -1;
    static final int NO_FAILED_FETCHES = 0;
    static final int NO_FAILED_REALTIME_STREAMS = 0;
    private static final String NUM_FAILED_FETCHES_KEY = "num_failed_fetches";
    private static final String NUM_FAILED_REALTIME_STREAMS_KEY = "num_failed_realtime_streams";
    private static final String REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY = "realtime_backoff_end_time_in_millis";
    private final SharedPreferences frcMetadata;
    static final Date LAST_FETCH_TIME_NO_FETCH_YET = new Date(-1);
    static final Date NO_BACKOFF_TIME = new Date(-1);
    private final Object frcInfoLock = new Object();
    private final Object backoffMetadataLock = new Object();
    private final Object realtimeBackoffMetadataLock = new Object();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        this.frcMetadata = sharedPreferences;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getFetchTimeoutInSeconds() {
        return this.frcMetadata.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, 60L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getMinimumFetchIntervalInSeconds() {
        return this.frcMetadata.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getLastFetchStatus() {
        return this.frcMetadata.getInt(LAST_FETCH_STATUS_KEY, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Date getLastSuccessfulFetchTime() {
        return new Date(this.frcMetadata.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, -1L));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getLastFetchETag() {
        return this.frcMetadata.getString(LAST_FETCH_ETAG_KEY, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    long getLastTemplateVersion() {
        return this.frcMetadata.getLong(LAST_TEMPLATE_VERSION, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfoImpl build;
        synchronized (this.frcInfoLock) {
            long j = this.frcMetadata.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, -1L);
            int i = this.frcMetadata.getInt(LAST_FETCH_STATUS_KEY, 0);
            build = FirebaseRemoteConfigInfoImpl.newBuilder().withLastFetchStatus(i).withLastSuccessfulFetchTimeInMillis(j).withConfigSettings(new FirebaseRemoteConfigSettings.Builder().setFetchTimeoutInSeconds(this.frcMetadata.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, 60L)).setMinimumFetchIntervalInSeconds(this.frcMetadata.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build()).build();
        }
        return build;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().clear().commit();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putLong(FETCH_TIMEOUT_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).commit();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setConfigSettingsWithoutWaitingOnDiskWrite(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putLong(FETCH_TIMEOUT_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateLastFetchAsSuccessfulAt(Date date) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt(LAST_FETCH_STATUS_KEY, -1).putLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateLastFetchAsFailed() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt(LAST_FETCH_STATUS_KEY, 1).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateLastFetchAsThrottled() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt(LAST_FETCH_STATUS_KEY, 2).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setLastFetchETag(String str) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putString(LAST_FETCH_ETAG_KEY, str).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setLastTemplateVersion(long j) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putLong(LAST_TEMPLATE_VERSION, j).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BackoffMetadata getBackoffMetadata() {
        BackoffMetadata backoffMetadata;
        synchronized (this.backoffMetadataLock) {
            backoffMetadata = new BackoffMetadata(this.frcMetadata.getInt(NUM_FAILED_FETCHES_KEY, 0), new Date(this.frcMetadata.getLong(BACKOFF_END_TIME_IN_MILLIS_KEY, -1L)));
        }
        return backoffMetadata;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setBackoffMetadata(int i, Date date) {
        synchronized (this.backoffMetadataLock) {
            this.frcMetadata.edit().putInt(NUM_FAILED_FETCHES_KEY, i).putLong(BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void resetBackoff() {
        setBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    static class BackoffMetadata {
        private Date backoffEndTime;
        private int numFailedFetches;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        BackoffMetadata(int i, Date date) {
            this.numFailedFetches = i;
            this.backoffEndTime = date;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getNumFailedFetches() {
            return this.numFailedFetches;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Date getBackoffEndTime() {
            return this.backoffEndTime;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RealtimeBackoffMetadata getRealtimeBackoffMetadata() {
        RealtimeBackoffMetadata realtimeBackoffMetadata;
        synchronized (this.realtimeBackoffMetadataLock) {
            realtimeBackoffMetadata = new RealtimeBackoffMetadata(this.frcMetadata.getInt(NUM_FAILED_REALTIME_STREAMS_KEY, 0), new Date(this.frcMetadata.getLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, -1L)));
        }
        return realtimeBackoffMetadata;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setRealtimeBackoffMetadata(int i, Date date) {
        synchronized (this.realtimeBackoffMetadataLock) {
            this.frcMetadata.edit().putInt(NUM_FAILED_REALTIME_STREAMS_KEY, i).putLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void resetRealtimeBackoff() {
        setRealtimeBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    static class RealtimeBackoffMetadata {
        private Date backoffEndTime;
        private int numFailedStreams;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RealtimeBackoffMetadata(int i, Date date) {
            this.numFailedStreams = i;
            this.backoffEndTime = date;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getNumFailedStreams() {
            return this.numFailedStreams;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Date getBackoffEndTime() {
            return this.backoffEndTime;
        }
    }
}
