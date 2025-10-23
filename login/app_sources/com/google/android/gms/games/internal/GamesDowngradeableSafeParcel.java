package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.util.GmsVersion;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static boolean zzo(Integer num) {
        if (num == null) {
            return false;
        }
        return GmsVersion.isAtLeastFenacho(num.intValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.internal.DowngradeableSafeParcel
    public final boolean prepareForClientVersion(int i) {
        setShouldDowngrade(!zzo(Integer.valueOf(i)));
        return true;
    }
}
