package com.google.android.gms.common.data;

import com.kakaogame.util.json.JSONArray;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public final class FreezableUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        JSONArray jSONArray = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            jSONArray.add(arrayList.get(i).freeze());
        }
        return jSONArray;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        JSONArray jSONArray = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            jSONArray.add(it.next().freeze());
        }
        return jSONArray;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        JSONArray jSONArray = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            jSONArray.add(e.freeze());
        }
        return jSONArray;
    }
}
