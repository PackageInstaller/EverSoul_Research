package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.util.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class ConfigurationConstants {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ConfigurationConstants() {
    }

    protected static final class CollectionDeactivated extends ConfigurationFlag<Boolean> {
        private static CollectionDeactivated instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "firebase_performance_collection_deactivated";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CollectionDeactivated() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static synchronized CollectionDeactivated getInstance() {
            CollectionDeactivated collectionDeactivated;
            synchronized (CollectionDeactivated.class) {
                if (instance == null) {
                    instance = new CollectionDeactivated();
                }
                collectionDeactivated = instance;
            }
            return collectionDeactivated;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return false;
        }
    }

    protected static final class CollectionEnabled extends ConfigurationFlag<Boolean> {
        private static CollectionEnabled instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return Constants.ENABLE_DISABLE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "firebase_performance_collection_enabled";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CollectionEnabled() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static synchronized CollectionEnabled getInstance() {
            CollectionEnabled collectionEnabled;
            synchronized (CollectionEnabled.class) {
                if (instance == null) {
                    instance = new CollectionEnabled();
                }
                collectionEnabled = instance;
            }
            return collectionEnabled;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return true;
        }
    }

    protected static final class SdkEnabled extends ConfigurationFlag<Boolean> {
        private static SdkEnabled instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkEnabled";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_enabled";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected SdkEnabled() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static synchronized SdkEnabled getInstance() {
            SdkEnabled sdkEnabled;
            synchronized (SdkEnabled.class) {
                if (instance == null) {
                    instance = new SdkEnabled();
                }
                sdkEnabled = instance;
            }
            return sdkEnabled;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return true;
        }
    }

    protected static final class SdkDisabledVersions extends ConfigurationFlag<String> {
        private static SdkDisabledVersions instance;

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDefault() {
            return "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkDisabledVersions";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_disabled_android_versions";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected SdkDisabledVersions() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static synchronized SdkDisabledVersions getInstance() {
            SdkDisabledVersions sdkDisabledVersions;
            synchronized (SdkDisabledVersions.class) {
                if (instance == null) {
                    instance = new SdkDisabledVersions();
                }
                sdkDisabledVersions = instance;
            }
            return sdkDisabledVersions;
        }
    }

    protected static final class TraceSamplingRate extends ConfigurationFlag<Double> {
        private static TraceSamplingRate instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceSamplingRate";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_trace_sampling_rate";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private TraceSamplingRate() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static synchronized TraceSamplingRate getInstance() {
            TraceSamplingRate traceSamplingRate;
            synchronized (TraceSamplingRate.class) {
                if (instance == null) {
                    instance = new TraceSamplingRate();
                }
                traceSamplingRate = instance;
            }
            return traceSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(1.0d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }
    }

    protected static final class NetworkRequestSamplingRate extends ConfigurationFlag<Double> {
        private static NetworkRequestSamplingRate instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkRequestSamplingRate";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_network_request_sampling_rate";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private NetworkRequestSamplingRate() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static synchronized NetworkRequestSamplingRate getInstance() {
            NetworkRequestSamplingRate networkRequestSamplingRate;
            synchronized (NetworkRequestSamplingRate.class) {
                if (instance == null) {
                    instance = new NetworkRequestSamplingRate();
                }
                networkRequestSamplingRate = instance;
            }
            return networkRequestSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(1.0d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }
    }

    protected static final class SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyForegroundMs instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_fg_ms";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SessionsCpuCaptureFrequencyForegroundMs() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized SessionsCpuCaptureFrequencyForegroundMs getInstance() {
            SessionsCpuCaptureFrequencyForegroundMs sessionsCpuCaptureFrequencyForegroundMs;
            synchronized (SessionsCpuCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyForegroundMs();
                }
                sessionsCpuCaptureFrequencyForegroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyForegroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 100L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefaultOnRcFetchFail() {
            return Long.valueOf(getDefault().longValue() * 3);
        }
    }

    protected static final class SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyBackgroundMs instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_bg_ms";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SessionsCpuCaptureFrequencyBackgroundMs() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
            SessionsCpuCaptureFrequencyBackgroundMs sessionsCpuCaptureFrequencyBackgroundMs;
            synchronized (SessionsCpuCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyBackgroundMs();
                }
                sessionsCpuCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyBackgroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 0L;
        }
    }

    protected static final class SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyForegroundMs instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_memory_capture_frequency_fg_ms";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_fg_ms";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SessionsMemoryCaptureFrequencyForegroundMs() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
            SessionsMemoryCaptureFrequencyForegroundMs sessionsMemoryCaptureFrequencyForegroundMs;
            synchronized (SessionsMemoryCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyForegroundMs();
                }
                sessionsMemoryCaptureFrequencyForegroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyForegroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 100L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefaultOnRcFetchFail() {
            return Long.valueOf(getDefault().longValue() * 3);
        }
    }

    protected static final class SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyBackgroundMs instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_memory_capture_frequency_bg_ms";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_bg_ms";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SessionsMemoryCaptureFrequencyBackgroundMs() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
            SessionsMemoryCaptureFrequencyBackgroundMs sessionsMemoryCaptureFrequencyBackgroundMs;
            synchronized (SessionsMemoryCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyBackgroundMs();
                }
                sessionsMemoryCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyBackgroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 0L;
        }
    }

    protected static final class SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {
        private static SessionsMaxDurationMinutes instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMaxDurationMinutes";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_max_length_minutes";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_max_duration_min";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SessionsMaxDurationMinutes() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized SessionsMaxDurationMinutes getInstance() {
            SessionsMaxDurationMinutes sessionsMaxDurationMinutes;
            synchronized (SessionsMaxDurationMinutes.class) {
                if (instance == null) {
                    instance = new SessionsMaxDurationMinutes();
                }
                sessionsMaxDurationMinutes = instance;
            }
            return sessionsMaxDurationMinutes;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 240L;
        }
    }

    protected static final class TraceEventCountForeground extends ConfigurationFlag<Long> {
        private static TraceEventCountForeground instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountForeground";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_fg";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private TraceEventCountForeground() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized TraceEventCountForeground getInstance() {
            TraceEventCountForeground traceEventCountForeground;
            synchronized (TraceEventCountForeground.class) {
                if (instance == null) {
                    instance = new TraceEventCountForeground();
                }
                traceEventCountForeground = instance;
            }
            return traceEventCountForeground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 300L;
        }
    }

    protected static final class TraceEventCountBackground extends ConfigurationFlag<Long> {
        private static TraceEventCountBackground instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountBackground";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_bg";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private TraceEventCountBackground() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized TraceEventCountBackground getInstance() {
            TraceEventCountBackground traceEventCountBackground;
            synchronized (TraceEventCountBackground.class) {
                if (instance == null) {
                    instance = new TraceEventCountBackground();
                }
                traceEventCountBackground = instance;
            }
            return traceEventCountBackground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 30L;
        }
    }

    protected static final class NetworkEventCountForeground extends ConfigurationFlag<Long> {
        private static NetworkEventCountForeground instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountForeground";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_fg";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private NetworkEventCountForeground() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized NetworkEventCountForeground getInstance() {
            NetworkEventCountForeground networkEventCountForeground;
            synchronized (NetworkEventCountForeground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountForeground();
                }
                networkEventCountForeground = instance;
            }
            return networkEventCountForeground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 700L;
        }
    }

    protected static final class NetworkEventCountBackground extends ConfigurationFlag<Long> {
        private static NetworkEventCountBackground instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountBackground";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_bg";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private NetworkEventCountBackground() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized NetworkEventCountBackground getInstance() {
            NetworkEventCountBackground networkEventCountBackground;
            synchronized (NetworkEventCountBackground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountBackground();
                }
                networkEventCountBackground = instance;
            }
            return networkEventCountBackground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 70L;
        }
    }

    protected static final class RateLimitSec extends ConfigurationFlag<Long> {
        private static RateLimitSec instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TimeLimitSec";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_time_limit_sec";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private RateLimitSec() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized RateLimitSec getInstance() {
            RateLimitSec rateLimitSec;
            synchronized (RateLimitSec.class) {
                if (instance == null) {
                    instance = new RateLimitSec();
                }
                rateLimitSec = instance;
            }
            return rateLimitSec;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 600L;
        }
    }

    protected static final class SessionsSamplingRate extends ConfigurationFlag<Double> {
        private static SessionsSamplingRate instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionSamplingRate";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_sampling_percentage";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_session_sampling_rate";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SessionsSamplingRate() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized SessionsSamplingRate getInstance() {
            SessionsSamplingRate sessionsSamplingRate;
            synchronized (SessionsSamplingRate.class) {
                if (instance == null) {
                    instance = new SessionsSamplingRate();
                }
                sessionsSamplingRate = instance;
            }
            return sessionsSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(0.01d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }
    }

    protected static final class LogSourceName extends ConfigurationFlag<String> {
        private static final Map<Long, String> LOG_SOURCE_MAP = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants.LogSourceName.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                put(461L, "FIREPERF_AUTOPUSH");
                put(462L, "FIREPERF");
                put(675L, "FIREPERF_INTERNAL_LOW");
                put(676L, "FIREPERF_INTERNAL_HIGH");
            }
        });
        private static LogSourceName instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.LogSourceName";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_log_source";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LogSourceName() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static synchronized LogSourceName getInstance() {
            LogSourceName logSourceName;
            synchronized (LogSourceName.class) {
                if (instance == null) {
                    instance = new LogSourceName();
                }
                logSourceName = instance;
            }
            return logSourceName;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static String getLogSourceName(long j) {
            return LOG_SOURCE_MAP.get(Long.valueOf(j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static boolean isLogSourceKnown(long j) {
            return LOG_SOURCE_MAP.containsKey(Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDefault() {
            return BuildConfig.TRANSPORT_LOG_SRC;
        }
    }

    protected static final class FragmentSamplingRate extends ConfigurationFlag<Double> {
        private static FragmentSamplingRate instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.FragmentSamplingRate";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "fragment_sampling_percentage";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_fragment_sampling_rate";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FragmentSamplingRate() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static synchronized FragmentSamplingRate getInstance() {
            FragmentSamplingRate fragmentSamplingRate;
            synchronized (FragmentSamplingRate.class) {
                if (instance == null) {
                    instance = new FragmentSamplingRate();
                }
                fragmentSamplingRate = instance;
            }
            return fragmentSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(0.0d);
        }
    }

    protected static final class ExperimentTTID extends ConfigurationFlag<Boolean> {
        private static ExperimentTTID instance;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.ExperimentTTID";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "experiment_app_start_ttid";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_experiment_app_start_ttid";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ExperimentTTID() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected static synchronized ExperimentTTID getInstance() {
            ExperimentTTID experimentTTID;
            synchronized (ExperimentTTID.class) {
                if (instance == null) {
                    instance = new ExperimentTTID();
                }
                experimentTTID = instance;
            }
            return experimentTTID;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return false;
        }
    }
}
