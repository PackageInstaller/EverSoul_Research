package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjf;
import com.google.android.gms.internal.measurement.zzjf.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzjf<MessageType extends zzjf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzhl<MessageType, BuilderType> {
    private static Map<Object, zzjf<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzmh zzb = zzmh.zzc();

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    protected static class zza<T extends zzjf<T, ?>> extends zzhp<T> {
        private final T zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public zza(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    public static abstract class zzb<MessageType extends zzjf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzhn<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzhn
        /* renamed from: zzae */
        public final /* synthetic */ zzhn clone() {
            return (zzb) clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzhn
        /* renamed from: zza */
        public final /* synthetic */ zzhn zzb(zzij zzijVar, zzis zzisVar) throws IOException {
            return (zzb) zzb(zzijVar, zzisVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzhn
        public final /* synthetic */ zzhn zza(byte[] bArr, int i, int i2) throws zzjq {
            return zzb(bArr, 0, i2, zzis.zza);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzhn
        public final /* synthetic */ zzhn zza(byte[] bArr, int i, int i2, zzis zzisVar) throws zzjq {
            return zzb(bArr, 0, i2, zzisVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzcj()) {
                zzak();
            }
            zza(this.zza, messagetype);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzhn
        /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final BuilderType zzb(zzij zzijVar, zzis zzisVar) throws IOException {
            if (!this.zza.zzcj()) {
                zzak();
            }
            try {
                zzlf.zza().zza((zzlf) this.zza).zza(this.zza, zzin.zza(zzijVar), zzisVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final BuilderType zzb(byte[] bArr, int i, int i2, zzis zzisVar) throws zzjq {
            if (!this.zza.zzcj()) {
                zzak();
            }
            try {
                zzlf.zza().zza((zzlf) this.zza).zza(this.zza, bArr, 0, i2, new zzht(zzisVar));
                return this;
            } catch (zzjq e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzjq.zzh();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzku
        /* renamed from: zzaf, reason: merged with bridge method [inline-methods] */
        public final MessageType zzah() {
            MessageType messagetype = (MessageType) zzai();
            if (messagetype.zzci()) {
                return messagetype;
            }
            throw new zzmf(messagetype);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzku
        /* renamed from: zzag, reason: merged with bridge method [inline-methods] */
        public MessageType zzai() {
            if (!this.zza.zzcj()) {
                return this.zza;
            }
            this.zza.zzcg();
            return this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzkt
        public final /* synthetic */ zzkr zzcf() {
            return this.zzb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzhn
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzb.zza(zze.zze, null, null);
            zzbVar.zza = (MessageType) zzai();
            return zzbVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzcj()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzbz();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected final void zzaj() {
            if (this.zza.zzcj()) {
                return;
            }
            zzak();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void zzak() {
            MessageType messagetype = (MessageType) this.zzb.zzbz();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzlf.zza().zza((zzlf) messagetype).zza(messagetype, messagetype2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzkt
        public final boolean zzci() {
            return zzjf.zza(this.zza, false);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    static final class zzc implements zzja<zzc> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzja
        public final int zza() {
            throw new NoSuchMethodError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzja
        public final zzku zza(zzku zzkuVar, zzkr zzkrVar) {
            throw new NoSuchMethodError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzja
        public final zzla zza(zzla zzlaVar, zzla zzlaVar2) {
            throw new NoSuchMethodError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzja
        public final zzmv zzb() {
            throw new NoSuchMethodError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzja
        public final zznf zzc() {
            throw new NoSuchMethodError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzja
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzja
        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzjf<MessageType, BuilderType> implements zzkt {
        protected zziy<zzc> zzc = zziy.zzb();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        final zziy<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zziy) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    public static class zzf<ContainingType extends zzkr, Type> extends zzit<ContainingType, Type> {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zza() {
        return zzlf.zza().zza((zzlf) this).zzb(this);
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzb(zzlj<?> zzljVar) {
        if (zzljVar == null) {
            return zzlf.zza().zza((zzlf) this).zza(this);
        }
        return zzljVar.zza(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhl
    final int zzbt() {
        return this.zzd & Integer.MAX_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkr
    public final int zzbw() {
        return zza((zzlj) null);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhl
    final int zza(zzlj zzljVar) {
        if (zzcj()) {
            int zzb2 = zzb(zzljVar);
            if (zzb2 >= 0) {
                return zzb2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzb2);
        }
        if (zzbt() != Integer.MAX_VALUE) {
            return zzbt();
        }
        int zzb3 = zzb(zzljVar);
        zzc(zzb3);
        return zzb3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        if (zzcj()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final <MessageType extends zzjf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbx() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final BuilderType zzby() {
        return (BuilderType) ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza((zzb) this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T extends zzjf<?, ?>> T zza(Class<T> cls) {
        zzjf<?, ?> zzjfVar = zzc.get(cls);
        if (zzjfVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzjfVar = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzjfVar == null) {
            zzjfVar = (T) ((zzjf) zzmo.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (zzjfVar == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, zzjfVar);
        }
        return (T) zzjfVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final MessageType zzbz() {
        return (MessageType) zza(zze.zzd, (Object) null, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static zzjl zzca() {
        return zzji.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static zzjo zzcb() {
        return zzkg.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static zzjo zza(zzjo zzjoVar) {
        int size = zzjoVar.size();
        return zzjoVar.zza(size == 0 ? 10 : size << 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static <E> zzjn<E> zzcc() {
        return zzli.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static <E> zzjn<E> zza(zzjn<E> zzjnVar) {
        int size = zzjnVar.size();
        return zzjnVar.zza(size == 0 ? 10 : size << 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkr
    public final /* synthetic */ zzku zzcd() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkr
    public final /* synthetic */ zzku zzce() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza((zzb) this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ zzkr zzcf() {
        return (zzjf) zza(zze.zzf, (Object) null, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Object zza(zzkr zzkrVar, String str, Object[] objArr) {
        return new zzlh(zzkrVar, str, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return zzkw.zza(this, super.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzcg() {
        zzlf.zza().zza((zzlf) this).zzc(this);
        zzch();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzch() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static <T extends zzjf<?, ?>> void zza(Class<T> cls, T t) {
        t.zzch();
        zzc.put(cls, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhl
    final void zzc(int i) {
        if (i < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
        this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkr
    public final void zza(zzio zzioVar) throws IOException {
        zzlf.zza().zza((zzlf) this).zza((zzlj) this, (zzne) zzir.zza(zzioVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlf.zza().zza((zzlf) this).zzb(this, (zzjf) obj);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final boolean zzci() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static final <T extends zzjf<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzlf.zza().zza((zzlf) t).zzd(t);
        if (z) {
            t.zza(zze.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzcj() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
