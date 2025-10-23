package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzgv<T> {

    @Nullable
    private static volatile zzhc zzb;
    private static volatile boolean zzc;
    private final zzhd zzg;
    private final String zzh;
    private final T zzi;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzgv<?>>> zzd = new AtomicReference<>();
    private static zzhg zze = new zzhg(new zzhj() { // from class: com.google.android.gms.internal.measurement.zzgw
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzhj
        public final boolean zza() {
            return zzgv.zzd();
        }
    });
    private static final AtomicInteger zzf = new AtomicInteger();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean zzd() {
        return true;
    }

    abstract T zza(Object obj);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ zzgv zza(zzhd zzhdVar, String str, Boolean bool, boolean z) {
        return new zzgy(zzhdVar, str, bool, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ zzgv zza(zzhd zzhdVar, String str, Double d, boolean z) {
        return new zzhb(zzhdVar, str, d, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ zzgv zza(zzhd zzhdVar, String str, Long l, boolean z) {
        return new zzgz(zzhdVar, str, l, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ zzgv zza(zzhd zzhdVar, String str, String str2, boolean z) {
        return new zzha(zzhdVar, str, str2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final T zza() {
        T zzb2;
        if (!this.zzl) {
            Preconditions.checkState(zze.zza(this.zzh), "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        }
        int i = zzf.get();
        if (this.zzj < i) {
            synchronized (this) {
                if (this.zzj < i) {
                    zzhc zzhcVar = zzb;
                    Optional<zzgp> absent = Optional.absent();
                    String str = null;
                    if (zzhcVar != null) {
                        absent = zzhcVar.zzb().get();
                        if (absent.isPresent()) {
                            str = absent.get().zza(this.zzg.zzb, this.zzg.zza, this.zzg.zzd, this.zzh);
                        }
                    }
                    Preconditions.checkState(zzhcVar != null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                    if (!this.zzg.zzf ? (zzb2 = zzb(zzhcVar)) == null && (zzb2 = zza(zzhcVar)) == null : (zzb2 = zza(zzhcVar)) == null && (zzb2 = zzb(zzhcVar)) == null) {
                        zzb2 = this.zzi;
                    }
                    if (absent.isPresent()) {
                        zzb2 = str == null ? this.zzi : zza((Object) str);
                    }
                    this.zzk = zzb2;
                    this.zzj = i;
                }
            }
        }
        return this.zzk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Nullable
    private final T zza(zzhc zzhcVar) {
        if (!this.zzg.zze && (this.zzg.zzh == null || this.zzg.zzh.apply(zzhcVar.zza()).booleanValue())) {
            Object zza2 = zzgo.zza(zzhcVar.zza()).zza(this.zzg.zze ? null : zza(this.zzg.zzc));
            if (zza2 != null) {
                return zza(zza2);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Nullable
    private final T zzb(zzhc zzhcVar) {
        zzgj zza2;
        Object zza3;
        if (this.zzg.zzb != null) {
            if (!zzgt.zza(zzhcVar.zza(), this.zzg.zzb)) {
                zza2 = null;
            } else if (this.zzg.zzg) {
                zza2 = zzgg.zza(zzhcVar.zza().getContentResolver(), zzgs.zza(zzgs.zza(zzhcVar.zza(), this.zzg.zzb.getLastPathSegment())), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzgu
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzgv.zzc();
                    }
                });
            } else {
                zza2 = zzgg.zza(zzhcVar.zza().getContentResolver(), this.zzg.zzb, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzgu
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzgv.zzc();
                    }
                });
            }
        } else {
            zza2 = zzhe.zza(zzhcVar.zza(), this.zzg.zza, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzgu
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    zzgv.zzc();
                }
            });
        }
        if (zza2 == null || (zza3 = zza2.zza(zzb())) == null) {
            return null;
        }
        return zza(zza3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzb() {
        return zza(this.zzg.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzh;
        }
        return str + this.zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzgv(zzhd zzhdVar, String str, T t, boolean z) {
        this.zzj = -1;
        if (zzhdVar.zza == null && zzhdVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (zzhdVar.zza != null && zzhdVar.zzb != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzg = zzhdVar;
        this.zzh = str;
        this.zzi = t;
        this.zzl = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzc() {
        zzf.incrementAndGet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb(final Context context) {
        if (zzb != null || context == null) {
            return;
        }
        Object obj = zza;
        synchronized (obj) {
            if (zzb == null && context != null) {
                synchronized (obj) {
                    zzhc zzhcVar = zzb;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (zzhcVar == null || zzhcVar.zza() != context) {
                        zzgg.zzc();
                        zzhe.zza();
                        zzgo.zza();
                        zzb = new zzgd(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzgx
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                Optional zza2;
                                zza2 = zzgr.zza.zza(context);
                                return zza2;
                            }
                        }));
                        zzf.incrementAndGet();
                    }
                }
            }
        }
    }
}
