package org.apache.commons.lang3;

/* loaded from: classes2.dex */
public class BitField {
    private final int _mask;
    private final int _shift_count;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitField(int i) {
        this._mask = i;
        this._shift_count = i == 0 ? 0 : Integer.numberOfTrailingZeros(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getValue(int i) {
        return getRawValue(i) >> this._shift_count;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getShortValue(short s) {
        return (short) getValue(s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getRawValue(int i) {
        return i & this._mask;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getShortRawValue(short s) {
        return (short) getRawValue(s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSet(int i) {
        return (i & this._mask) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAllSet(int i) {
        int i2 = this._mask;
        return (i & i2) == i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int setValue(int i, int i2) {
        int i3 = this._mask;
        return (i & (~i3)) | ((i2 << this._shift_count) & i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short setShortValue(short s, short s2) {
        return (short) setValue(s, s2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int clear(int i) {
        return i & (~this._mask);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short clearShort(short s) {
        return (short) clear(s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte clearByte(byte b) {
        return (byte) clear(b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int set(int i) {
        return i | this._mask;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short setShort(short s) {
        return (short) set(s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte setByte(byte b) {
        return (byte) set(b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int setBoolean(int i, boolean z) {
        return z ? set(i) : clear(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short setShortBoolean(short s, boolean z) {
        return z ? setShort(s) : clearShort(s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte setByteBoolean(byte b, boolean z) {
        return z ? setByte(b) : clearByte(b);
    }
}
