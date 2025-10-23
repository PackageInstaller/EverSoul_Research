package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjf;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzew {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zza extends zzjf<zza, C2948zza> implements zzkt {
        private static final zza zzc;
        private static volatile zzle<zza> zzd;
        private int zze;
        private int zzf;
        private zzjn<zze> zzg = zzcc();
        private zzjn<zzb> zzh = zzcc();
        private boolean zzi;
        private boolean zzj;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        /* renamed from: com.google.android.gms.internal.measurement.zzew$zza$zza, reason: collision with other inner class name */
        public static final class C2948zza extends zzjf.zzb<zza, C2948zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final int zza() {
                return ((zza) this.zza).zzb();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final int zzb() {
                return ((zza) this.zza).zzc();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final C2948zza zza(int i, zzb.zza zzaVar) {
                zzaj();
                ((zza) this.zza).zza(i, (zzb) ((zzjf) zzaVar.zzah()));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final C2948zza zza(int i, zze.zza zzaVar) {
                zzaj();
                ((zza) this.zza).zza(i, (zze) ((zzjf) zzaVar.zzah()));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zzb zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zze zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private C2948zza() {
                super(zza.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ C2948zza(zzev zzevVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zza() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zzb() {
            return this.zzh.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zzc() {
            return this.zzg.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzb zza(int i) {
            return this.zzh.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zze zzb(int i) {
            return this.zzg.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzev zzevVar = null;
            switch (zzev.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C2948zza(zzevVar);
                case 3:
                    return zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", zze.class, "zzh", zzb.class, "zzi", "zzj"});
                case 4:
                    return zzc;
                case 5:
                    zzle<zza> zzleVar = zzd;
                    if (zzleVar == null) {
                        synchronized (zza.class) {
                            zzleVar = zzd;
                            if (zzleVar == null) {
                                zzleVar = new zzjf.zza<>(zzc);
                                zzd = zzleVar;
                            }
                        }
                    }
                    return zzleVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzb> zze() {
            return this.zzh;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zze> zzf() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzjf.zza((Class<zza>) zza.class, zzaVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(int i, zzb zzbVar) {
            zzbVar.getClass();
            zzjn<zzb> zzjnVar = this.zzh;
            if (!zzjnVar.zzc()) {
                this.zzh = zzjf.zza(zzjnVar);
            }
            this.zzh.set(i, zzbVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(int i, zze zzeVar) {
            zzeVar.getClass();
            zzjn<zze> zzjnVar = this.zzg;
            if (!zzjnVar.zzc()) {
                this.zzg = zzjf.zza(zzjnVar);
            }
            this.zzg.set(i, zzeVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzb extends zzjf<zzb, zza> implements zzkt {
        private static final zzb zzc;
        private static volatile zzle<zzb> zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private zzjn<zzc> zzh = zzcc();
        private boolean zzi;
        private zzd zzj;
        private boolean zzk;
        private boolean zzl;
        private boolean zzm;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzb, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final int zza() {
                return ((zzb) this.zza).zza();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zza zza(String str) {
                zzaj();
                ((zzb) this.zza).zza(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zza zza(int i, zzc zzcVar) {
                zzaj();
                ((zzb) this.zza).zza(i, zzcVar);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String zzb() {
                return ((zzb) this.zza).zzf();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzb.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzev zzevVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zza() {
            return this.zzh.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zzb() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zza zzc() {
            return zzc.zzbx();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzc zza(int i) {
            return this.zzh.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzd zze() {
            zzd zzdVar = this.zzj;
            return zzdVar == null ? zzd.zzc() : zzdVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzev zzevVar = null;
            switch (zzev.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzevVar);
                case 3:
                    return zza(zzc, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", zzc.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzc;
                case 5:
                    zzle<zzb> zzleVar = zzd;
                    if (zzleVar == null) {
                        synchronized (zzb.class) {
                            zzleVar = zzd;
                            if (zzleVar == null) {
                                zzleVar = new zzjf.zza<>(zzc);
                                zzd = zzleVar;
                            }
                        }
                    }
                    return zzleVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzf() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzc> zzg() {
            return this.zzh;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzjf.zza((Class<zzb>) zzb.class, zzbVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(int i, zzc zzcVar) {
            zzcVar.getClass();
            zzjn<zzc> zzjnVar = this.zzh;
            if (!zzjnVar.zzc()) {
                this.zzh = zzjf.zza(zzjnVar);
            }
            this.zzh.set(i, zzcVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzh() {
            return this.zzk;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzi() {
            return this.zzl;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzj() {
            return this.zzm;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzk() {
            return (this.zze & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzl() {
            return (this.zze & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzm() {
            return (this.zze & 64) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzc extends zzjf<zzc, zza> implements zzkt {
        private static final zzc zzc;
        private static volatile zzle<zzc> zzd;
        private int zze;
        private zzf zzf;
        private zzd zzg;
        private boolean zzh;
        private String zzi = "";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zzc zzb() {
            return zzc;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzc, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zza zza(String str) {
                zzaj();
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzc.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzev zzevVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzd zzc() {
            zzd zzdVar = this.zzg;
            return zzdVar == null ? zzd.zzc() : zzdVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzf zzd() {
            zzf zzfVar = this.zzf;
            return zzfVar == null ? zzf.zzd() : zzfVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzev zzevVar = null;
            switch (zzev.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzevVar);
                case 3:
                    return zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzle<zzc> zzleVar = zzd;
                    if (zzleVar == null) {
                        synchronized (zzc.class) {
                            zzleVar = zzd;
                            if (zzleVar == null) {
                                zzleVar = new zzjf.zza<>(zzc);
                                zzd = zzleVar;
                            }
                        }
                    }
                    return zzleVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zze() {
            return this.zzi;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzjf.zza((Class<zzc>) zzc.class, zzcVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 8;
            this.zzi = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzf() {
            return this.zzh;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzh() {
            return (this.zze & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzi() {
            return (this.zze & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzd extends zzjf<zzd, zza> implements zzkt {
        private static final zzd zzc;
        private static volatile zzle<zzd> zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzb zza() {
            zzb zza2 = zzb.zza(this.zzf);
            return zza2 == null ? zzb.UNKNOWN_COMPARISON_TYPE : zza2;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzd, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzd.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzev zzevVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zzd zzc() {
            return zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzev zzevVar = null;
            switch (zzev.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzevVar);
                case 3:
                    return zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzc;
                case 5:
                    zzle<zzd> zzleVar = zzd;
                    if (zzleVar == null) {
                        synchronized (zzd.class) {
                            zzleVar = zzd;
                            if (zzleVar == null) {
                                zzleVar = new zzjf.zza<>(zzc);
                                zzd = zzleVar;
                            }
                        }
                    }
                    return zzleVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public enum zzb implements zzjk {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);

            private static final zzjj<zzb> zzf = new zzex();
            private final int zzh;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.measurement.zzjk
            public final int zza() {
                return this.zzh;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zzb zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zzjm zzb() {
                return zzey.zza;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzh);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            zzb(int i) {
                this.zzh = i;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzd() {
            return this.zzh;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zze() {
            return this.zzj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzf() {
            return this.zzi;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzjf.zza((Class<zzd>) zzd.class, zzdVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zzd() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzg() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzh() {
            return (this.zze & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzi() {
            return (this.zze & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzj() {
            return (this.zze & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzk() {
            return (this.zze & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzl() {
            return (this.zze & 8) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zze extends zzjf<zze, zza> implements zzkt {
        private static final zze zzc;
        private static volatile zzle<zze> zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private zzc zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zza() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzc zzb() {
            zzc zzcVar = this.zzh;
            return zzcVar == null ? zzc.zzb() : zzcVar;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zze, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zza zza(String str) {
                zzaj();
                ((zze) this.zza).zza(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zze.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzev zzevVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zza zzc() {
            return zzc.zzbx();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzev zzevVar = null;
            switch (zzev.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzevVar);
                case 3:
                    return zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzc;
                case 5:
                    zzle<zze> zzleVar = zzd;
                    if (zzleVar == null) {
                        synchronized (zze.class) {
                            zzleVar = zzd;
                            if (zzleVar == null) {
                                zzleVar = new zzjf.zza<>(zzc);
                                zzd = zzleVar;
                            }
                        }
                    }
                    return zzleVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zze() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzjf.zza((Class<zze>) zze.class, zzeVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzf() {
            return this.zzi;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzg() {
            return this.zzj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzh() {
            return this.zzk;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzi() {
            return (this.zze & 1) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzj() {
            return (this.zze & 32) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzf extends zzjf<zzf, zzb> implements zzkt {
        private static final zzf zzc;
        private static volatile zzle<zzf> zzd;
        private int zze;
        private int zzf;
        private boolean zzh;
        private String zzg = "";
        private zzjn<String> zzi = zzjf.zzcc();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zza() {
            return this.zzi.size();
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zzb extends zzjf.zzb<zzf, zzb> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zzb() {
                super(zzf.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zzb(zzev zzevVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zza zzb() {
            zza zza2 = zza.zza(this.zzf);
            return zza2 == null ? zza.UNKNOWN_MATCH_TYPE : zza2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zzf zzd() {
            return zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzev zzevVar = null;
            switch (zzev.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb(zzevVar);
                case 3:
                    return zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", zza.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzle<zzf> zzleVar = zzd;
                    if (zzleVar == null) {
                        synchronized (zzf.class) {
                            zzleVar = zzd;
                            if (zzleVar == null) {
                                zzleVar = new zzjf.zza<>(zzc);
                                zzd = zzleVar;
                            }
                        }
                    }
                    return zzleVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public enum zza implements zzjk {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);

            private static final zzjj<zza> zzh = new zzfa();
            private final int zzj;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.measurement.zzjk
            public final int zza() {
                return this.zzj;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zza zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zzjm zzb() {
                return zzez.zza;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzj);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            zza(int i) {
                this.zzj = i;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zze() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<String> zzf() {
            return this.zzi;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzjf.zza((Class<zzf>) zzf.class, zzfVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zzf() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzg() {
            return this.zzh;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzh() {
            return (this.zze & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzi() {
            return (this.zze & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }
}
