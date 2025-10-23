package com.google.zxing.client.result;

/* loaded from: classes3.dex */
public final class ISBNParsedResult extends ParsedResult {
    private final String isbn;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ISBNParsedResult(String str) {
        super(ParsedResultType.ISBN);
        this.isbn = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getISBN() {
        return this.isbn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return this.isbn;
    }
}
