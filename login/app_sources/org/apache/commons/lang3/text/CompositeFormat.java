package org.apache.commons.lang3.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

@Deprecated
/* loaded from: classes2.dex */
public class CompositeFormat extends Format {
    private static final long serialVersionUID = -4329119827877627683L;
    private final Format formatter;
    private final Format parser;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CompositeFormat(Format format, Format format2) {
        this.parser = format;
        this.formatter = format2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.formatter.format(obj, stringBuffer, fieldPosition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Format getParser() {
        return this.parser;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Format getFormatter() {
        return this.formatter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String reformat(String str) throws ParseException {
        return format(parseObject(str));
    }
}
