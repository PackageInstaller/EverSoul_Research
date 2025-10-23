package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgo implements zzgj {
    private static zzgo zza;

    @Nullable
    private final Context zzb;

    @Nullable
    private final ContentObserver zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzgo zza(Context context) {
        zzgo zzgoVar;
        synchronized (zzgo.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzgo(context) : new zzgo();
            }
            zzgoVar = zza;
        }
        return zzgoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzgj
    @Nullable
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        Context context = this.zzb;
        if (context != null && !zzge.zza(context)) {
            try {
                return (String) zzgm.zza(new zzgl() { // from class: com.google.android.gms.internal.measurement.zzgn
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.internal.measurement.zzgl
                    public final Object zza() {
                        return zzgo.this.zzb(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: " + str, e);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ String zzb(String str) {
        return zzfr.zza(this.zzb.getContentResolver(), str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzgo() {
        this.zzb = null;
        this.zzc = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzgo(Context context) {
        this.zzb = context;
        zzgq zzgqVar = new zzgq(this, null);
        this.zzc = zzgqVar;
        context.getContentResolver().registerContentObserver(zzfu.zza, true, zzgqVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static synchronized void zza() {
        Context context;
        synchronized (zzgo.class) {
            zzgo zzgoVar = zza;
            if (zzgoVar != null && (context = zzgoVar.zzb) != null && zzgoVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }
}
