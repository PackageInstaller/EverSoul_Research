package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public final class LazilyParsedNumber extends Number {
    private final String value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LazilyParsedNumber(String str) {
        this.value = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.value);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.value).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.value);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.value);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.value).longValue();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.value.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazilyParsedNumber)) {
            return false;
        }
        String str = this.value;
        String str2 = ((LazilyParsedNumber) obj).value;
        return str == str2 || str.equals(str2);
    }
}
