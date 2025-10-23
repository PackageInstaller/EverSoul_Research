package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzjx {
    private static volatile boolean zzol;
    private static volatile zzjx zzon;
    private final Map<zza, zzkk.zzd<?, ?>> zzop;
    private static final Class<?> zzom = zzch();
    static final zzjx zzoo = new zzjx(true);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Class<?> zzch() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    static final class zza {
        private final int number;
        private final Object object;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.object == zzaVar.object && this.number == zzaVar.number;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzjx zzci() {
        return zzjw.zzcf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzjx zzcj() {
        zzjx zzjxVar = zzon;
        if (zzjxVar == null) {
            synchronized (zzjx.class) {
                zzjxVar = zzon;
                if (zzjxVar == null) {
                    zzjxVar = zzjw.zzcg();
                    zzon = zzjxVar;
                }
            }
        }
        return zzjxVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjx zzcg() {
        return zzki.zza(zzjx.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <ContainingType extends zzlq> zzkk.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzkk.zzd) this.zzop.get(new zza(containingtype, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjx() {
        this.zzop = new HashMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzjx(boolean z) {
        this.zzop = Collections.emptyMap();
    }
}
