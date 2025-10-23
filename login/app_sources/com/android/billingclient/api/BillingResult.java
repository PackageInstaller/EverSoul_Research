package com.android.billingclient.api;

import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class BillingResult {
    private int zza;
    private String zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDebugMessage() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getResponseCode() {
        return this.zza;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class Builder {
        private int zza;
        private String zzb = "";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(zzci zzciVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDebugMessage(String str) {
            this.zzb = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setResponseCode(int i) {
            this.zza = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            billingResult.zza = this.zza;
            billingResult.zzb = this.zzb;
            return billingResult;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٲٴݴ״ٰ(1781626664) + com.google.android.gms.internal.play_billing.zze.zzi(this.zza) + y.֬ڱܱײٮ(-1159449095) + this.zzb;
    }
}
