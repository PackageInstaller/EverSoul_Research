package com.android.billingclient.api;

import com.liapp.y;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class zzc {
    private final String zza;
    private final String zzb;
    private final String zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzc(JSONObject jSONObject, zzd zzdVar) {
        this.zza = jSONObject.optString("productId");
        this.zzb = jSONObject.optString("productType");
        String optString = jSONObject.optString("offerToken");
        this.zzc = true == optString.isEmpty() ? null : optString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        return this.zza.equals(zzcVar.zza) && this.zzb.equals(zzcVar.zzb) && Objects.equals(this.zzc, zzcVar.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb, this.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return String.format(y.٬ݯح׭٩(576092134), this.zza, this.zzb, this.zzc);
    }
}
