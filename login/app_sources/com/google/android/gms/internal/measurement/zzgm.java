package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzgm {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <V> V zza(zzgl<V> zzglVar) {
        try {
            return zzglVar.zza();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzglVar.zza();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
