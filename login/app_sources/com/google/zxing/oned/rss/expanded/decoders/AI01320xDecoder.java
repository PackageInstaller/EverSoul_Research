package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* loaded from: classes3.dex */
final class AI01320xDecoder extends AI013x0xDecoder {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i) {
        return i < 10000 ? i : i - 10000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
