package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.ArrayUtils;

@Deprecated
/* loaded from: classes2.dex */
public class AggregateTranslator extends CharSequenceTranslator {
    private final CharSequenceTranslator[] translators;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AggregateTranslator(CharSequenceTranslator... charSequenceTranslatorArr) {
        this.translators = (CharSequenceTranslator[]) ArrayUtils.clone(charSequenceTranslatorArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        for (CharSequenceTranslator charSequenceTranslator : this.translators) {
            int translate = charSequenceTranslator.translate(charSequence, i, writer);
            if (translate != 0) {
                return translate;
            }
        }
        return 0;
    }
}
