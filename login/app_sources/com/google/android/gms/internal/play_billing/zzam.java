package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public abstract class zzam extends zzar implements zzan {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzan zzu(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        return queryLocalInterface instanceof zzan ? (zzan) queryLocalInterface : new zzal(iBinder);
    }
}
