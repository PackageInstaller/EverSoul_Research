package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzew;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzjf;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzfc {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zza extends zzjf<zza, C2949zza> implements zzkt {
        private static final zza zzc;
        private static volatile zzle<zza> zzd;
        private int zze;
        private boolean zzi;
        private zzjn<zzb> zzf = zzcc();
        private zzjn<zzc> zzg = zzcc();
        private zzjn<zzf> zzh = zzcc();
        private zzjn<zzb> zzj = zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zzb extends zzjf<zzb, C2950zza> implements zzkt {
            private static final zzb zzc;
            private static volatile zzle<zzb> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
            /* renamed from: com.google.android.gms.internal.measurement.zzfc$zza$zzb$zza, reason: collision with other inner class name */
            public static final class C2950zza extends zzjf.zzb<zzb, C2950zza> implements zzkt {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private C2950zza() {
                    super(zzb.zzc);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ C2950zza(zzfb zzfbVar) {
                    this();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zzd zzb() {
                zzd zza = zzd.zza(this.zzg);
                return zza == null ? zzd.CONSENT_STATUS_UNSPECIFIED : zza;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zze zzc() {
                zze zza = zze.zza(this.zzf);
                return zza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.measurement.zzjf
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfb zzfbVar = null;
                switch (zzfb.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C2950zza(zzfbVar);
                    case 3:
                        return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zzd.zzb()});
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
        public static final class zzc extends zzjf<zzc, C2951zza> implements zzkt {
            private static final zzc zzc;
            private static volatile zzle<zzc> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
            /* renamed from: com.google.android.gms.internal.measurement.zzfc$zza$zzc$zza, reason: collision with other inner class name */
            public static final class C2951zza extends zzjf.zzb<zzc, C2951zza> implements zzkt {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private C2951zza() {
                    super(zzc.zzc);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ C2951zza(zzfb zzfbVar) {
                    this();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zze zzb() {
                zze zza = zze.zza(this.zzg);
                return zza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zze zzc() {
                zze zza = zze.zza(this.zzf);
                return zza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.measurement.zzjf
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfb zzfbVar = null;
                switch (zzfb.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new C2951zza(zzfbVar);
                    case 3:
                        return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zze.zzb()});
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
        public static final class zzf extends zzjf<zzf, C2952zza> implements zzkt {
            private static final zzf zzc;
            private static volatile zzle<zzf> zzd;
            private int zze;
            private String zzf = "";
            private String zzg = "";

            /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
            /* renamed from: com.google.android.gms.internal.measurement.zzfc$zza$zzf$zza, reason: collision with other inner class name */
            public static final class C2952zza extends zzjf.zzb<zzf, C2952zza> implements zzkt {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private C2952zza() {
                    super(zzf.zzc);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* synthetic */ C2952zza(zzfb zzfbVar) {
                    this();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.measurement.zzjf
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfb zzfbVar = null;
                switch (zzfb.zza[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C2952zza(zzfbVar);
                    case 3:
                        return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
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

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String zzb() {
                return this.zzf;
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
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        /* renamed from: com.google.android.gms.internal.measurement.zzfc$zza$zza, reason: collision with other inner class name */
        public static final class C2949zza extends zzjf.zzb<zza, C2949zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private C2949zza() {
                super(zza.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ C2949zza(zzfb zzfbVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zza zzb() {
            return zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfb zzfbVar = null;
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C2949zza(zzfbVar);
                case 3:
                    return zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", zzb.class, "zzg", zzc.class, "zzh", zzf.class, "zzi", "zzj", zzb.class});
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

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public enum zzd implements zzjk {
            CONSENT_STATUS_UNSPECIFIED(0),
            GRANTED(1),
            DENIED(2);

            private static final zzjj<zzd> zzd = new zzfd();
            private final int zzf;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.measurement.zzjk
            public final int zza() {
                return this.zzf;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zzd zza(int i) {
                if (i == 0) {
                    return CONSENT_STATUS_UNSPECIFIED;
                }
                if (i == 1) {
                    return GRANTED;
                }
                if (i != 2) {
                    return null;
                }
                return DENIED;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zzjm zzb() {
                return zzfe.zza;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            zzd(int i) {
                this.zzf = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public enum zze implements zzjk {
            CONSENT_TYPE_UNSPECIFIED(0),
            AD_STORAGE(1),
            ANALYTICS_STORAGE(2),
            AD_USER_DATA(3),
            AD_PERSONALIZATION(4);

            private static final zzjj<zze> zzf = new zzfg();
            private final int zzh;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.measurement.zzjk
            public final int zza() {
                return this.zzh;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zze zza(int i) {
                if (i == 0) {
                    return CONSENT_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return AD_STORAGE;
                }
                if (i == 2) {
                    return ANALYTICS_STORAGE;
                }
                if (i == 3) {
                    return AD_USER_DATA;
                }
                if (i != 4) {
                    return null;
                }
                return AD_PERSONALIZATION;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static zzjm zzb() {
                return zzff.zza;
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
            zze(int i) {
                this.zzh = i;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzf> zzc() {
            return this.zzh;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzb> zzd() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzc> zze() {
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

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzf() {
            return this.zzi;
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
        private String zzf = "";
        private zzjn<zzf> zzg = zzcc();
        private boolean zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzb, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzb.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfb zzfbVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfb zzfbVar = null;
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfbVar);
                case 3:
                    return zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzf.class, "zzh"});
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
        private String zzf = "";
        private boolean zzg;
        private boolean zzh;
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzc, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final int zza() {
                return ((zzc) this.zza).zza();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zza zza(String str) {
                zzaj();
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String zzb() {
                return ((zzc) this.zza).zzc();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzc.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfb zzfbVar) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final boolean zzc() {
                return ((zzc) this.zza).zzd();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final boolean zzd() {
                return ((zzc) this.zza).zze();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final boolean zze() {
                return ((zzc) this.zza).zzf();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final boolean zzf() {
                return ((zzc) this.zza).zzg();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final boolean zzg() {
                return ((zzc) this.zza).zzh();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zza() {
            return this.zzi;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfb zzfbVar = null;
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfbVar);
                case 3:
                    return zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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
        public final String zzc() {
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

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzd() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zze() {
            return this.zzh;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzf() {
            return (this.zze & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzd extends zzjf<zzd, zza> implements zzkt {
        private static final zzd zzc;
        private static volatile zzle<zzd> zzd;
        private int zze;
        private long zzf;
        private int zzh;
        private boolean zzm;
        private zza zzr;
        private zze zzs;
        private zzh zzt;
        private String zzg = "";
        private zzjn<zzg> zzi = zzcc();
        private zzjn<zzc> zzj = zzcc();
        private zzjn<zzew.zza> zzk = zzcc();
        private String zzl = "";
        private zzjn<zzfp.zzc> zzn = zzcc();
        private zzjn<zzb> zzo = zzcc();
        private String zzp = "";
        private String zzq = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzd, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final int zza() {
                return ((zzd) this.zza).zzb();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zzc zza(int i) {
                return ((zzd) this.zza).zza(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zza zzb() {
                zzaj();
                ((zzd) this.zza).zzt();
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final zza zza(int i, zzc.zza zzaVar) {
                zzaj();
                ((zzd) this.zza).zza(i, (zzc) ((zzjf) zzaVar.zzah()));
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String zzc() {
                return ((zzd) this.zza).zzj();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final List<zzew.zza> zzd() {
                return Collections.unmodifiableList(((zzd) this.zza).zzk());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final List<zzb> zze() {
                return Collections.unmodifiableList(((zzd) this.zza).zzl());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzd.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfb zzfbVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zza() {
            return this.zzn.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int zzb() {
            return this.zzj.size();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long zzc() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zza zzd() {
            zza zzaVar = this.zzr;
            return zzaVar == null ? zza.zzb() : zzaVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzc zza(int i) {
            return this.zzj.get(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zza zze() {
            return zzc.zzbx();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zzd zzg() {
            return zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzh zzh() {
            zzh zzhVar = this.zzt;
            return zzhVar == null ? zzh.zzb() : zzhVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfb zzfbVar = null;
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfbVar);
                case 3:
                    return zza(zzc, "\u0001\u000f\u0000\u0001\u0001\u0011\u000f\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzg.class, "zzj", zzc.class, "zzk", zzew.zza.class, "zzl", "zzm", "zzn", zzfp.zzc.class, "zzo", zzb.class, "zzp", "zzq", "zzr", "zzs", "zzt"});
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

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzi() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzj() {
            return this.zzp;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzew.zza> zzk() {
            return this.zzk;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzb> zzl() {
            return this.zzo;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzfp.zzc> zzm() {
            return this.zzn;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<zzg> zzn() {
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

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zzt() {
            this.zzk = zzcc();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void zza(int i, zzc zzcVar) {
            zzcVar.getClass();
            zzjn<zzc> zzjnVar = this.zzj;
            if (!zzjnVar.zzc()) {
                this.zzj = zzjf.zza(zzjnVar);
            }
            this.zzj.set(i, zzcVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzo() {
            return this.zzm;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzp() {
            return (this.zze & 128) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzq() {
            return (this.zze & 2) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzr() {
            return (this.zze & 512) != 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean zzs() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zze extends zzjf<zze, zza> implements zzkt {
        private static final zze zzc;
        private static volatile zzle<zze> zzd;
        private int zze;
        private int zzf = 14;
        private int zzg = 11;
        private int zzh = 60;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zze, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zze.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfb zzfbVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfb zzfbVar = null;
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzfbVar);
                case 3:
                    return zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
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
        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzjf.zza((Class<zze>) zze.class, zzeVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zze() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzf extends zzjf<zzf, zza> implements zzkt {
        private static final zzf zzc;
        private static volatile zzle<zzf> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzf, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzf.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfb zzfbVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfb zzfbVar = null;
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzfbVar);
                case 3:
                    return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
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

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzjf.zza((Class<zzf>) zzf.class, zzfVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zzf() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzg extends zzjf<zzg, zza> implements zzkt {
        private static final zzg zzc;
        private static volatile zzle<zzg> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzg, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzg.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfb zzfbVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfb zzfbVar = null;
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzfbVar);
                case 3:
                    return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzle<zzg> zzleVar = zzd;
                    if (zzleVar == null) {
                        synchronized (zzg.class) {
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
        public final String zzc() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zzg zzgVar = new zzg();
            zzc = zzgVar;
            zzjf.zza((Class<zzg>) zzg.class, zzgVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zzg() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public static final class zzh extends zzjf<zzh, zza> implements zzkt {
        private static final zzh zzc;
        private static volatile zzle<zzh> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
        public static final class zza extends zzjf.zzb<zzh, zza> implements zzkt {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private zza() {
                super(zzh.zzc);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ zza(zzfb zzfbVar) {
                this();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static zzh zzb() {
            return zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzjf
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfb zzfbVar = null;
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzfbVar);
                case 3:
                    return zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzle<zzh> zzleVar = zzd;
                    if (zzleVar == null) {
                        synchronized (zzh.class) {
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
        public final String zzc() {
            return this.zzg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzd() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            zzh zzhVar = new zzh();
            zzc = zzhVar;
            zzjf.zza((Class<zzh>) zzh.class, zzhVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zzh() {
        }
    }
}
