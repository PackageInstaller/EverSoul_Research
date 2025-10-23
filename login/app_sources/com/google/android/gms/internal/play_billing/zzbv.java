package com.google.android.gms.internal.play_billing;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzbv {
    private static final Collector zza = Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzbj
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.function.Supplier
        public final Object get() {
            return new zzck(4);
        }
    }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzbm
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((zzck) obj).zzd(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzbn
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            zzck zzckVar = (zzck) obj;
            zzck zzckVar2 = (zzck) obj2;
            zzckVar.zzb(zzckVar2.zza, zzckVar2.zzb);
            return zzckVar;
        }
    }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzbo
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((zzck) obj).zze();
        }
    }, new Collector.Characteristics[0]);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzbp
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.Supplier
            public final Object get() {
                return new zzcu();
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzbq
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((zzcu) obj).zzd(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzbr
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                zzcu zzcuVar = (zzcu) obj;
                zzcu zzcuVar2 = (zzcu) obj2;
                zzcuVar.zzb(zzcuVar2.zza, zzcuVar2.zzb);
                return zzcuVar;
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzbs
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzcv zzl;
                zzcu zzcuVar = (zzcu) obj;
                int i = zzcuVar.zzb;
                if (i == 0) {
                    return zzdq.zza;
                }
                if (i == 1) {
                    return new zzdt(Objects.requireNonNull(zzcuVar.zza[0]));
                }
                zzl = zzcv.zzl(i, zzcuVar.zza);
                zzcuVar.zzb = zzl.size();
                zzcuVar.zzc = true;
                return zzl;
            }
        }, new Collector.Characteristics[0]);
        Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzbt
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.Supplier
            public final Object get() {
                return new zzcs();
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzbu
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((zzcs) obj).zza((zzdh) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzbk
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                zzcs zzcsVar = (zzcs) obj;
                zzcsVar.zzb((zzcs) obj2);
                return zzcsVar;
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzbl
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((zzcs) obj).zzc();
            }
        }, new Collector.Characteristics[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Collector zza() {
        return zza;
    }
}
