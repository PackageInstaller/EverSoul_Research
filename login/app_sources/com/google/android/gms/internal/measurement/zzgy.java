package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgy extends zzgv<Boolean> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzgv
    @Nullable
    final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzfu.zzc.matcher(str).matches()) {
                return true;
            }
            if (zzfu.zzd.matcher(str).matches()) {
                return false;
            }
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgy(zzhd zzhdVar, String str, Boolean bool, boolean z) {
        super(zzhdVar, str, bool);
    }
}
