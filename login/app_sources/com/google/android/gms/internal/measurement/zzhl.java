package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzhl<MessageType extends zzhl<MessageType, BuilderType>, BuilderType extends zzhn<MessageType, BuilderType>> implements zzkr {
    protected int zza = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int zzbt() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int zza(zzlj zzljVar) {
        int zzbt = zzbt();
        if (zzbt != -1) {
            return zzbt;
        }
        int zza = zzljVar.zza(this);
        zzc(zza);
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkr
    public final zzhu zzbu() {
        try {
            zzid zzc = zzhu.zzc(zzbw());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzjh.zza(iterable);
        if (iterable instanceof zzjx) {
            List<?> zzb = ((zzjx) iterable).zzb();
            zzjx zzjxVar = (zzjx) list;
            int size = list.size();
            for (Object obj : zzb) {
                if (obj == null) {
                    String str = "Element at index " + (zzjxVar.size() - size) + " is null.";
                    for (int size2 = zzjxVar.size() - 1; size2 >= size; size2--) {
                        zzjxVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof zzhu) {
                    zzjxVar.zza((zzhu) obj);
                } else {
                    zzjxVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzld) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size3 = list.size();
        for (T t : iterable) {
            if (t == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            list.add(t);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] zzbv() {
        try {
            byte[] bArr = new byte[zzbw()];
            zzio zzb = zzio.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
