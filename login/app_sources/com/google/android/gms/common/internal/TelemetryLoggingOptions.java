package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public class TelemetryLoggingOptions implements Api.ApiOptions.Optional {
    public static final TelemetryLoggingOptions zaa = builder().build();
    private final String zab;

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    public static class Builder {
        private String zaa;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(zaac zaacVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public TelemetryLoggingOptions build() {
            return new TelemetryLoggingOptions(this.zaa, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setApi(String str) {
            this.zaa = str;
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ TelemetryLoggingOptions(String str, zaad zaadVar) {
        this.zab = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new Builder(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TelemetryLoggingOptions) {
            return Objects.equal(this.zab, ((TelemetryLoggingOptions) obj).zab);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(this.zab);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zaa() {
        Bundle bundle = new Bundle();
        String str = this.zab;
        if (str != null) {
            bundle.putString(com.kakao.sdk.partner.user.Constants.API_TYPE, str);
        }
        return bundle;
    }
}
