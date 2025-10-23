package com.android.billingclient.api;

import com.liapp.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
@Deprecated
/* loaded from: classes.dex */
public class SkuDetailsParams {
    private String zza;
    private List zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSkuType() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<String> getSkusList() {
        return this.zzb;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class Builder {
        private String zza;
        private List zzb;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            throw null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(zzdd zzddVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setType(String str) {
            this.zza = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SkuDetailsParams build() {
            String str = this.zza;
            if (str == null) {
                throw new IllegalArgumentException(y.٬ݯح׭٩(576091758));
            }
            if (this.zzb != null) {
                SkuDetailsParams skuDetailsParams = new SkuDetailsParams();
                skuDetailsParams.zza = str;
                skuDetailsParams.zzb = this.zzb;
                return skuDetailsParams;
            }
            throw new IllegalArgumentException(y.٬ݯح׭٩(576091550));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSkusList(List<String> list) {
            this.zzb = new ArrayList(list);
            return this;
        }
    }
}
