package com.google.zxing.common;

import java.util.List;

/* loaded from: classes3.dex */
public final class DecoderResult {
    private final List<byte[]> byteSegments;
    private final String ecLevel;
    private Integer erasures;
    private Integer errorsCorrected;
    private int numBits;
    private Object other;
    private final byte[] rawBytes;
    private final int structuredAppendParity;
    private final int structuredAppendSequenceNumber;
    private final String text;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.rawBytes = bArr;
        this.numBits = bArr == null ? 0 : bArr.length * 8;
        this.text = str;
        this.byteSegments = list;
        this.ecLevel = str2;
        this.structuredAppendParity = i2;
        this.structuredAppendSequenceNumber = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getNumBits() {
        return this.numBits;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNumBits(int i) {
        this.numBits = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getText() {
        return this.text;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<byte[]> getByteSegments() {
        return this.byteSegments;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getECLevel() {
        return this.ecLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Integer getErrorsCorrected() {
        return this.errorsCorrected;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setErrorsCorrected(Integer num) {
        this.errorsCorrected = num;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Integer getErasures() {
        return this.erasures;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setErasures(Integer num) {
        this.erasures = num;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getOther() {
        return this.other;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOther(Object obj) {
        this.other = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasStructuredAppend() {
        return this.structuredAppendParity >= 0 && this.structuredAppendSequenceNumber >= 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStructuredAppendParity() {
        return this.structuredAppendParity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStructuredAppendSequenceNumber() {
        return this.structuredAppendSequenceNumber;
    }
}
