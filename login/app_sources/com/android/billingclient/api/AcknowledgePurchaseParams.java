package com.android.billingclient.api;

import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class AcknowledgePurchaseParams {
    private String zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AcknowledgePurchaseParams() {
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ AcknowledgePurchaseParams(zza zzaVar) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPurchaseToken() {
        return this.zza;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static final class Builder {
        private String zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            throw null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(zza zzaVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AcknowledgePurchaseParams build() {
            String str = this.zza;
            if (str == null) {
                throw new IllegalArgumentException(y.ۮڭڭܬި(861988915));
            }
            AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams(null);
            acknowledgePurchaseParams.zza = str;
            return acknowledgePurchaseParams;
        }
    }
}
