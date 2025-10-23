package com.google.android.gms.internal.games_v2;

import android.os.Bundle;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzam {
    public final int zzb;
    public int zzc = -1;
    public int zzd = 0;
    public int zze = 0;
    public int zzf = 0;
    public int zzg = 0;
    public IBinder zza = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzam(int i, IBinder iBinder) {
        this.zzb = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putInt("popupLocationInfo.gravity", this.zzb);
        bundle.putInt("popupLocationInfo.displayId", this.zzc);
        bundle.putInt("popupLocationInfo.left", this.zzd);
        bundle.putInt("popupLocationInfo.top", this.zze);
        bundle.putInt("popupLocationInfo.right", this.zzf);
        bundle.putInt("popupLocationInfo.bottom", this.zzg);
        return bundle;
    }
}
