package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* loaded from: classes3.dex */
public abstract class AbstractExpandedDecoder {
    private final GeneralAppIdDecoder generalDecoder;
    private final BitArray information;

    public abstract String parseInformation() throws NotFoundException, FormatException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AbstractExpandedDecoder(BitArray bitArray) {
        this.information = bitArray;
        this.generalDecoder = new GeneralAppIdDecoder(bitArray);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final BitArray getInformation() {
        return this.information;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        if (bitArray.get(1)) {
            return new AI01AndOtherAIs(bitArray);
        }
        if (!bitArray.get(2)) {
            return new AnyAIDecoder(bitArray);
        }
        int extractNumericValueFromBitArray = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 4);
        if (extractNumericValueFromBitArray == 4) {
            return new AI013103decoder(bitArray);
        }
        if (extractNumericValueFromBitArray == 5) {
            return new AI01320xDecoder(bitArray);
        }
        int extractNumericValueFromBitArray2 = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 5);
        if (extractNumericValueFromBitArray2 == 12) {
            return new AI01392xDecoder(bitArray);
        }
        if (extractNumericValueFromBitArray2 == 13) {
            return new AI01393xDecoder(bitArray);
        }
        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 7)) {
            case 56:
                return new AI013x0x1xDecoder(bitArray, "310", "11");
            case 57:
                return new AI013x0x1xDecoder(bitArray, "320", "11");
            case 58:
                return new AI013x0x1xDecoder(bitArray, "310", "13");
            case 59:
                return new AI013x0x1xDecoder(bitArray, "320", "13");
            case 60:
                return new AI013x0x1xDecoder(bitArray, "310", "15");
            case 61:
                return new AI013x0x1xDecoder(bitArray, "320", "15");
            case 62:
                return new AI013x0x1xDecoder(bitArray, "310", "17");
            case 63:
                return new AI013x0x1xDecoder(bitArray, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(bitArray)));
        }
    }
}
