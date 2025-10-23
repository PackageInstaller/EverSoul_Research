package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.common.zzag;
import com.kakaogame.util.json.JSONArray;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class SafeParcelableSerializer {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SafeParcelableSerializer() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> T deserializeFromBytes(byte[] bArr, Parcelable.Creator<T> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) deserializeFromBytes(byteArrayExtra, creator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> T deserializeFromString(String str, Parcelable.Creator<T> creator) {
        return (T) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        JSONArray jSONArray = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            jSONArray.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
        }
        return jSONArray;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundleSafe(Bundle bundle, String str, Parcelable.Creator<T> creator) {
        return deserializeIterableFromBytes(bundle.getByteArray(str), creator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBytes(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            ArrayList<T> arrayList = new ArrayList<>();
            obtain.readTypedList(arrayList, creator);
            return arrayList;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        JSONArray jSONArray = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            jSONArray.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
        }
        return jSONArray;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtraSafe(Intent intent, String str, Parcelable.Creator<T> creator) {
        return deserializeIterableFromBytes(intent.getByteArrayExtra(str), creator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> iterable, Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> void serializeIterableToBundleSafe(Iterable<T> iterable, Bundle bundle, String str) {
        bundle.putByteArray(str, zza(iterable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> iterable, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        intent.putExtra(str, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> void serializeIterableToIntentExtraSafe(Iterable<T> iterable, Intent intent, String str) {
        intent.putExtra(str, zza(iterable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> byte[] serializeToBytes(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> void serializeToIntentExtra(T t, Intent intent, String str) {
        intent.putExtra(str, serializeToBytes(t));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends SafeParcelable> String serializeToString(T t) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(t));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] zza(Iterable iterable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeTypedList(zzag.zzj(iterable));
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }
}
