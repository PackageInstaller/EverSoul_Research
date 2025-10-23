package com.google.zxing.client.result;

/* loaded from: classes3.dex */
public final class TextParsedResult extends ParsedResult {
    private final String language;
    private final String text;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextParsedResult(String str, String str2) {
        super(ParsedResultType.TEXT);
        this.text = str;
        this.language = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getText() {
        return this.text;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getLanguage() {
        return this.language;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return this.text;
    }
}
