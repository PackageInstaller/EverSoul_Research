package com.android.billingclient.api;

import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class ConsumeParams {
    private String zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConsumeParams() {
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ ConsumeParams(zzck zzckVar) {
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
        /* synthetic */ Builder(zzck zzckVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ConsumeParams build() {
            String str = this.zza;
            if (str == null) {
                throw new IllegalArgumentException(y.ۮڭڭܬި(861988915));
            }
            ConsumeParams consumeParams = new ConsumeParams(null);
            consumeParams.zza = str;
            return consumeParams;
        }
    }
}
