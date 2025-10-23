package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes3.dex */
public final class AztecCode {
    private int codeWords;
    private boolean compact;
    private int layers;
    private BitMatrix matrix;
    private int size;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCompact() {
        return this.compact;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCompact(boolean z) {
        this.compact = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSize() {
        return this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSize(int i) {
        this.size = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLayers() {
        return this.layers;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLayers(int i) {
        this.layers = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCodeWords() {
        return this.codeWords;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCodeWords(int i) {
        this.codeWords = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitMatrix getMatrix() {
        return this.matrix;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMatrix(BitMatrix bitMatrix) {
        this.matrix = bitMatrix;
    }
}
