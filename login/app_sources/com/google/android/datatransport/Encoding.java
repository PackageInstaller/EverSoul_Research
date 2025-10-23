package com.google.android.datatransport;

/* loaded from: classes.dex */
public final class Encoding {
    private final String name;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static Encoding m106of(String str) {
        return new Encoding(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Encoding(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.name = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Encoding) {
            return this.name.equals(((Encoding) obj).name);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Encoding{name=\"" + this.name + "\"}";
    }
}
