package com.google.android.gms.internal.games_v2;

import android.app.Application;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzau {
    private static final AtomicReference zza = new AtomicReference();
    private final zzat zzb;
    private final zzav zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzau(Application application, zzav zzavVar) {
        this.zzb = new zzat(this, application, null);
        this.zzc = zzavVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzau zza(Application application) {
        AtomicReference atomicReference = zza;
        zzau zzauVar = (zzau) atomicReference.get();
        if (zzauVar != null) {
            return zzauVar;
        }
        zzau zzauVar2 = new zzau(application, zzax.zza(application));
        while (!UByte$$ExternalSyntheticBackport0.m850m(atomicReference, null, zzauVar2) && atomicReference.get() == null) {
        }
        return (zzau) Preconditions.checkNotNull((zzau) zza.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc() {
        zzez.zza("AutomaticGamesAuthenticator", "startWatching()");
        zzat.zza(this.zzb);
    }
}
