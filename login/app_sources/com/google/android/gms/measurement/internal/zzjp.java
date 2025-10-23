package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjp implements zznf {
    private final /* synthetic */ zzio zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjp(zzio zzioVar) {
        this.zza = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zznf
    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzb(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, bundle);
        } else {
            this.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, bundle, str);
        }
    }
}
