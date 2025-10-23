package com.singular.sdk.internal;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.unity.purchasing.BuildConfig;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SLRemoteConfiguration {
    private static final SingularLog logger = SingularLog.getLogger("SLRemoteConfiguration");

    @SerializedName("admon_batching")
    private SLRemoteConfigurationAdmonBatching slRemoteConfigurationAdmonBatching = new SLRemoteConfigurationAdmonBatching();

    static class SLRemoteConfigurationAdmonBatching {
        private static final SingularLog logger = SingularLog.getLogger("SLRemoteConfiguration");

        @SerializedName("AggregateAdmonEvents")
        private boolean aggregateAdmonEvents = false;

        @SerializedName(BuildConfig.BUILD_TYPE)
        private boolean debug = false;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Objects.hash(Boolean.valueOf(this.aggregateAdmonEvents), Boolean.valueOf(this.debug));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SLRemoteConfigurationAdmonBatching sLRemoteConfigurationAdmonBatching = (SLRemoteConfigurationAdmonBatching) obj;
            return this.aggregateAdmonEvents == sLRemoteConfigurationAdmonBatching.aggregateAdmonEvents && this.debug == sLRemoteConfigurationAdmonBatching.debug;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SLRemoteConfigurationAdmonBatching() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isAggregateAdmonEvents() {
            return this.aggregateAdmonEvents;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isDebug() {
            return this.debug;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hash(this.slRemoteConfigurationAdmonBatching);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.slRemoteConfigurationAdmonBatching.equals(((SLRemoteConfiguration) obj).slRemoteConfigurationAdmonBatching);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SLRemoteConfiguration() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject toJson() {
        try {
            return new JSONObject(new Gson().toJson(this));
        } catch (Throwable th) {
            logger.error(Utils.formatException(th));
            return new JSONObject();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SLRemoteConfiguration fromJson(JSONObject jSONObject) {
        try {
            return (SLRemoteConfiguration) new Gson().fromJson(jSONObject.toString(), SLRemoteConfiguration.class);
        } catch (Throwable th) {
            logger.error(Utils.formatException(th));
            return new SLRemoteConfiguration();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SLRemoteConfiguration defaultConfig() {
        return new SLRemoteConfiguration();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAggregateAdmonEvents() {
        return this.slRemoteConfigurationAdmonBatching.isAggregateAdmonEvents();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAdmonEventsDebug() {
        return this.slRemoteConfigurationAdmonBatching.isDebug();
    }
}
