package com.google.android.gms.drive;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.drive.zzaw;

/* loaded from: classes.dex */
public class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String zzan;
    private final boolean zzao;
    private final int zzap;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExecutionOptions(String str, boolean z, int i) {
        this.zzan = str;
        this.zzao = z;
        this.zzap = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zza(int i) {
        return i == 1;
    }

    public static class Builder {
        protected String zzaq;
        protected boolean zzar;
        protected int zzas = 0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTrackingTag(String str) {
            if (!(!TextUtils.isEmpty(str) && str.length() <= 65536)) {
                throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", 65536));
            }
            this.zzaq = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setNotifyOnCompletion(boolean z) {
            this.zzar = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConflictStrategy(int i) {
            boolean z = true;
            if (i != 0 && i != 1) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(new StringBuilder(53).append("Unrecognized value for conflict strategy: ").append(i).toString());
            }
            this.zzas = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected final void zzo() {
            if (this.zzas == 1 && !this.zzar) {
                throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ExecutionOptions build() {
            zzo();
            return new ExecutionOptions(this.zzaq, this.zzar, this.zzas);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzl() {
        return this.zzan;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzm() {
        return this.zzao;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzn() {
        return this.zzap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final void zza(GoogleApiClient googleApiClient) {
        zza((zzaw) googleApiClient.getClient(Drive.CLIENT_KEY));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzaw zzawVar) {
        if (this.zzao && !zzawVar.zzah()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            ExecutionOptions executionOptions = (ExecutionOptions) obj;
            if (Objects.equal(this.zzan, executionOptions.zzan) && this.zzap == executionOptions.zzap && this.zzao == executionOptions.zzao) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hashCode(this.zzan, Integer.valueOf(this.zzap), Boolean.valueOf(this.zzao));
    }
}
