package com.bumptech.glide.util;

import com.liapp.y;

/* loaded from: classes.dex */
public class MultiClassKey {
    private Class<?> first;
    private Class<?> second;
    private Class<?> third;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MultiClassKey() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MultiClassKey(Class<?> cls, Class<?> cls2) {
        set(cls, cls2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        set(cls, cls2, cls3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void set(Class<?> cls, Class<?> cls2) {
        set(cls, cls2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void set(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.first = cls;
        this.second = cls2;
        this.third = cls3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ۮڭڭܬި(862146835) + this.first + y.٬ݯح׭٩(575995110) + this.second + '}';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second) && Util.bothNullOrEqual(this.third, multiClassKey.third);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((this.first.hashCode() * 31) + this.second.hashCode()) * 31;
        Class<?> cls = this.third;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }
}
