package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzgk {
    final zzhd zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Bundle zza(String str, com.google.android.gms.internal.measurement.zzby zzbyVar) {
        this.zza.zzl().zzt();
        if (zzbyVar == null) {
            this.zza.zzj().zzu().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle zza = zzbyVar.zza(bundle);
            if (zza != null) {
                return zza;
            }
            this.zza.zzj().zzg().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zza.zzj().zzg().zza("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgk(zzmp zzmpVar) {
        this.zza = zzmpVar.zzk();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zza());
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.zza.zzj().zzp().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.zza.zzj().zzp().zza("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
