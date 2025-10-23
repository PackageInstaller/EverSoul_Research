package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* loaded from: classes3.dex */
final class AI013103decoder extends AI013x0xDecoder {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AI013103decoder(BitArray bitArray) {
        super(bitArray);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder sb, int i) {
        sb.append("(3103)");
    }
}
