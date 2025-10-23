package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes3.dex */
final class CurrentParsingState {
    private int position = 0;
    private State encoding = State.NUMERIC;

    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CurrentParsingState() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getPosition() {
        return this.position;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setPosition(int i) {
        this.position = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void incrementPosition(int i) {
        this.position += i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isAlpha() {
        return this.encoding == State.ALPHA;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isNumeric() {
        return this.encoding == State.NUMERIC;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isIsoIec646() {
        return this.encoding == State.ISO_IEC_646;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setAlpha() {
        this.encoding = State.ALPHA;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }
}
