package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* loaded from: classes3.dex */
final class AI01AndOtherAIs extends AI01decoder {
    private static final int HEADER_SIZE = 4;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AI01AndOtherAIs(BitArray bitArray) {
        super(bitArray);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException, FormatException {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(getGeneralDecoder().extractNumericValueFromBitArray(4, 4));
        encodeCompressedGtinWithoutAI(sb, 8, length);
        return getGeneralDecoder().decodeAllCodes(sb, 48);
    }
}
