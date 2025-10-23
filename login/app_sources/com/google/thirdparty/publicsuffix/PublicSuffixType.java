package com.google.thirdparty.publicsuffix;

/* loaded from: classes3.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PublicSuffixType(char c, char c2) {
        this.innerNodeCode = c;
        this.leafNodeCode = c2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    char getLeafNodeCode() {
        return this.leafNodeCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static PublicSuffixType fromCode(char c) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c || publicSuffixType.getLeafNodeCode() == c) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException(new StringBuilder(38).append("No enum corresponding to given code: ").append(c).toString());
    }
}
