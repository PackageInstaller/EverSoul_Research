package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes3.dex */
final class BlockParsedResult {
    private final DecodedInformation decodedInformation;
    private final boolean finished;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BlockParsedResult(boolean z) {
        this(null, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BlockParsedResult(DecodedInformation decodedInformation, boolean z) {
        this.finished = z;
        this.decodedInformation = decodedInformation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isFinished() {
        return this.finished;
    }
}
