package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class AuthProxyOptions implements Api.ApiOptions.Optional {
    public static final AuthProxyOptions zza = new AuthProxyOptions(new Bundle(), null);
    private final Bundle zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ AuthProxyOptions(Bundle bundle, zzb zzbVar) {
        this.zzb = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuthProxyOptions) {
            return Objects.checkBundlesEquality(this.zzb, ((AuthProxyOptions) obj).zzb);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zza() {
        return new Bundle(this.zzb);
    }
}
