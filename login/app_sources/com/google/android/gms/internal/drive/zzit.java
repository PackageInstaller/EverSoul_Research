package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzit;
import com.google.android.gms.internal.drive.zziu;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzit<MessageType extends zzit<MessageType, BuilderType>, BuilderType extends zziu<MessageType, BuilderType>> implements zzlq {
    private static boolean zznf;
    protected int zzne = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzlq
    public final zzjc zzbl() {
        try {
            zzjk zzu = zzjc.zzu(zzcx());
            zzb(zzu.zzby());
            return zzu.zzbx();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length()).append("Serializing ").append(name).append(" to a ByteString threw an IOException (should never happen).").toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzcx()];
            zzjr zzb = zzjr.zzb(bArr);
            zzb(zzb);
            zzb.zzcb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length()).append("Serializing ").append(name).append(" to a byte array threw an IOException (should never happen).").toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int zzbm() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void zzo(int i) {
        throw new UnsupportedOperationException();
    }
}
