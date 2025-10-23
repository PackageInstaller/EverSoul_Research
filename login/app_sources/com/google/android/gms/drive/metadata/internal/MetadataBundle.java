package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class MetadataBundle extends AbstractSafeParcelable implements ReflectedParcelable {
    private final Bundle zzjh;
    private static final GmsLogger zzbz = new GmsLogger("MetadataBundle", "");
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzj();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MetadataBundle(Bundle bundle) {
        int i;
        Bundle bundle2 = (Bundle) Preconditions.checkNotNull(bundle);
        this.zzjh = bundle2;
        bundle2.setClassLoader(getClass().getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = bundle2.keySet().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (zzf.zzf(next) == null) {
                arrayList.add(next);
                zzbz.wfmt("MetadataBundle", "Ignored unknown metadata field in bundle: %s", next);
            }
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            this.zzjh.remove((String) obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetadataBundle zzbe() {
        return new MetadataBundle(new Bundle());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzbe = zzbe();
        zzbe.zzb(metadataField, t);
        return zzbe;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final MetadataBundle zzbf() {
        return new MetadataBundle(new Bundle(this.zzjh));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zzf.zzf(metadataField.getName()) == null) {
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unregistered field: ".concat(valueOf) : new String("Unregistered field: "));
        }
        metadataField.zza(t, this.zzjh);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zza(this.zzjh);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> T zzc(MetadataField<T> metadataField) {
        T t = (T) zza(metadataField);
        this.zzjh.remove(metadataField.getName());
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzd(MetadataField<?> metadataField) {
        return this.zzjh.containsKey(metadataField.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Set<MetadataField<?>> zzbg() {
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.zzjh.keySet().iterator();
        while (it.hasNext()) {
            hashSet.add(zzf.zzf(it.next()));
        }
        return hashSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzhs.zzkq);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.setTempDir(context.getCacheDir());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        Iterator<String> it = this.zzjh.keySet().iterator();
        int i = 1;
        while (it.hasNext()) {
            i = (i * 31) + this.zzjh.get(it.next()).hashCode();
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzjh.keySet();
        if (!keySet.equals(metadataBundle.zzjh.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!Objects.equal(this.zzjh.get(str), metadataBundle.zzjh.get(str))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzjh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
