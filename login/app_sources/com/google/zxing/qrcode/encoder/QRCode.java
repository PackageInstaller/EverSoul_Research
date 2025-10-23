package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

/* loaded from: classes3.dex */
public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;
    private ErrorCorrectionLevel ecLevel;
    private int maskPattern = -1;
    private ByteMatrix matrix;
    private Mode mode;
    private Version version;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isValidMaskPattern(int i) {
        return i >= 0 && i < 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Mode getMode() {
        return this.mode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ErrorCorrectionLevel getECLevel() {
        return this.ecLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Version getVersion() {
        return this.version;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaskPattern() {
        return this.maskPattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ByteMatrix getMatrix() {
        return this.matrix;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n mode: ");
        sb.append(this.mode);
        sb.append("\n ecLevel: ");
        sb.append(this.ecLevel);
        sb.append("\n version: ");
        sb.append(this.version);
        sb.append("\n maskPattern: ");
        sb.append(this.maskPattern);
        if (this.matrix == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.matrix);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.ecLevel = errorCorrectionLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVersion(Version version) {
        this.version = version;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaskPattern(int i) {
        this.maskPattern = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMatrix(ByteMatrix byteMatrix) {
        this.matrix = byteMatrix;
    }
}
