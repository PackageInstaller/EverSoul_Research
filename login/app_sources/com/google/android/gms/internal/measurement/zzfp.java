package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjf;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzfp {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zza extends zzjf<zza, C2954zza> implements zzkt {
        private static final zza zzc;
        private static volatile zzle<zza> zzd;
        private zzjn<zzb> zze = zzcc();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zza() {
            return this.zze.size();
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        /* renamed from: com.google.android.gms.internal.measurement.zzfp$zza$zza, reason: collision with other inner class name */
        public static final class C2954zza extends zzjf.zzb<zza, C2954zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private C2954zza() {
                super(zza.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ C2954zza(zzfo zzfoVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zza zzc() {
            return zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfo zzfoVar = null;
            switch (zzfo.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C2954zza(zzfoVar);
                case 3:
                    return zza(zzc, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzb.class});
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
        public final List<zzb> zzd() {
            return this.zze;
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
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzb extends zzjf<zzb, zza> implements zzkt {
        private static final zzb zzc;
        private static volatile zzle<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzjn<zzd> zzg = zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzb, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzb.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfo zzfoVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfo zzfoVar = null;
            switch (zzfo.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfoVar);
                case 3:
                    return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzd.class});
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
        public final String zzb() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzd> zzc() {
            return this.zzg;
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
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzc extends zzjf<zzc, zza> implements zzkt {
        private static final zzc zzc;
        private static volatile zzle<zzc> zzd;
        private int zze;
        private zzjn<zzd> zzf = zzcc();
        private zza zzg;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zza zza() {
            zza zzaVar = this.zzg;
            return zzaVar == null ? zza.zzc() : zzaVar;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzc, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzc.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfo zzfoVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfo zzfoVar = null;
            switch (zzfo.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfoVar);
                case 3:
                    return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzd.class, "zzg"});
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
        public final List<zzd> zzc() {
            return this.zzf;
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
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzd extends zzjf<zzd, zza> implements zzkt {
        private static final zzd zzc;
        private static volatile zzle<zzd> zzd;
        private int zze;
        private int zzf;
        private zzjn<zzd> zzg = zzcc();
        private String zzh = "";
        private String zzi = "";
        private boolean zzj;
        private double zzk;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final double zza() {
            return this.zzk;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzd, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzd.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfo zzfoVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzb zzb() {
            zzb zza2 = zzb.zza(this.zzf);
            return zza2 == null ? zzb.UNKNOWN : zza2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfo zzfoVar = null;
            switch (zzfo.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfoVar);
                case 3:
                    return zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", zzd.class, "zzh", "zzi", "zzj", "zzk"});
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
            UNKNOWN(0),
            STRING(1),
            NUMBER(2),
            BOOLEAN(3),
            STATEMENT(4);

            private static final zzjj<zzb> zzf = new zzfq();
            private final int zzh;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.measurement.zzjk
            public final int zza() {
                return this.zzh;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zzb zza(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return STRING;
                }
                if (i == 2) {
                    return NUMBER;
                }
                if (i == 3) {
                    return BOOLEAN;
                }
                if (i != 4) {
                    return null;
                }
                return STATEMENT;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zzjm zzb() {
                return zzfs.zza;
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
            return this.zzi;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzd> zzf() {
            return this.zzg;
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
            return this.zzj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzi() {
            return (this.zze & 16) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzj() {
            return (this.zze & 4) != 0;
        }
    }
}
