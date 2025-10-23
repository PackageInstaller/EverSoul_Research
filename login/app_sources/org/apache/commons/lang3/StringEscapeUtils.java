package org.apache.commons.lang3;

import com.liapp.y;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.text.translate.AggregateTranslator;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.EntityArrays;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import org.apache.commons.lang3.text.translate.NumericEntityEscaper;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.apache.commons.lang3.text.translate.OctalUnescaper;
import org.apache.commons.lang3.text.translate.UnicodeUnescaper;
import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;

@Deprecated
/* loaded from: classes2.dex */
public class StringEscapeUtils {
    public static final CharSequenceTranslator ESCAPE_CSV;
    public static final CharSequenceTranslator ESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator ESCAPE_HTML3;
    public static final CharSequenceTranslator ESCAPE_HTML4;
    public static final CharSequenceTranslator ESCAPE_JAVA;
    public static final CharSequenceTranslator ESCAPE_JSON;

    @Deprecated
    public static final CharSequenceTranslator ESCAPE_XML;
    public static final CharSequenceTranslator ESCAPE_XML10;
    public static final CharSequenceTranslator ESCAPE_XML11;
    public static final CharSequenceTranslator UNESCAPE_CSV;
    public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator UNESCAPE_HTML3;
    public static final CharSequenceTranslator UNESCAPE_HTML4;
    public static final CharSequenceTranslator UNESCAPE_JAVA;
    public static final CharSequenceTranslator UNESCAPE_JSON;
    public static final CharSequenceTranslator UNESCAPE_XML;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String str = y.دײܮڳܯ(2051949821);
        String str2 = y.ݮڮֲڭܩ(-628919564);
        String str3 = y.ۮڭڭܬި(862138355);
        String str4 = y.ٴسسݬߨ(1392985730);
        ESCAPE_JAVA = new LookupTranslator(new String[]{str, str2}, new String[]{str3, str4}).with(new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE())).with(JavaUnicodeEscaper.outsideOf(32, 127));
        String str5 = y.دײܮڳܯ(2051806557);
        String str6 = y.دײܮڳܯ(2051949709);
        String str7 = y.ۮڭڭܬި(861981587);
        String str8 = y.ݬֲ֮ܲت(1512991879);
        ESCAPE_ECMASCRIPT = new AggregateTranslator(new LookupTranslator(new String[]{str5, str6}, new String[]{str, str2}, new String[]{str3, str4}, new String[]{str7, str8}), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()), JavaUnicodeEscaper.outsideOf(32, 127));
        ESCAPE_JSON = new AggregateTranslator(new LookupTranslator(new String[]{str, str2}, new String[]{str3, str4}, new String[]{str7, str8}), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()), JavaUnicodeEscaper.outsideOf(32, 127));
        ESCAPE_XML = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE()));
        ESCAPE_XML10 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE()), new LookupTranslator(new String[]{"\u0000", ""}, new String[]{"\u0001", ""}, new String[]{"\u0002", ""}, new String[]{"\u0003", ""}, new String[]{"\u0004", ""}, new String[]{"\u0005", ""}, new String[]{"\u0006", ""}, new String[]{"\u0007", ""}, new String[]{"\b", ""}, new String[]{"\u000b", ""}, new String[]{"\f", ""}, new String[]{"\u000e", ""}, new String[]{"\u000f", ""}, new String[]{"\u0010", ""}, new String[]{"\u0011", ""}, new String[]{"\u0012", ""}, new String[]{"\u0013", ""}, new String[]{"\u0014", ""}, new String[]{"\u0015", ""}, new String[]{"\u0016", ""}, new String[]{"\u0017", ""}, new String[]{"\u0018", ""}, new String[]{"\u0019", ""}, new String[]{"\u001a", ""}, new String[]{"\u001b", ""}, new String[]{"\u001c", ""}, new String[]{"\u001d", ""}, new String[]{"\u001e", ""}, new String[]{"\u001f", ""}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover());
        ESCAPE_XML11 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE()), new LookupTranslator(new String[]{"\u0000", ""}, new String[]{"\u000b", y.ٲٴݴ״ٰ(1781684264)}, new String[]{"\f", y.ٴسسݬߨ(1392985898)}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), NumericEntityEscaper.between(1, 8), NumericEntityEscaper.between(14, 31), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover());
        ESCAPE_HTML3 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE()));
        ESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE()), new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE()));
        ESCAPE_CSV = new CsvEscaper();
        AggregateTranslator aggregateTranslator = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE()), new LookupTranslator(new String[]{str4, str3}, new String[]{str2, str}, new String[]{str6, str5}, new String[]{str3, ""}));
        UNESCAPE_JAVA = aggregateTranslator;
        UNESCAPE_ECMASCRIPT = aggregateTranslator;
        UNESCAPE_JSON = aggregateTranslator;
        UNESCAPE_HTML3 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE()), new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_XML = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.APOS_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_CSV = new CsvUnescaper();
    }

    static class CsvEscaper extends CharSequenceTranslator {
        private static final char CSV_QUOTE = '\"';
        private static final String CSV_QUOTE_STR = String.valueOf('\"');
        private static final char CSV_DELIMITER = ',';
        private static final char[] CSV_SEARCH_CHARS = {CSV_DELIMITER, '\"', CharUtils.f1521CR, '\n'};

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CsvEscaper() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
        public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i != 0) {
                throw new IllegalStateException("CsvEscaper should never reach the [1] index");
            }
            if (StringUtils.containsNone(charSequence.toString(), CSV_SEARCH_CHARS)) {
                writer.write(charSequence.toString());
            } else {
                writer.write(34);
                String obj = charSequence.toString();
                String str = CSV_QUOTE_STR;
                writer.write(StringUtils.replace(obj, str, str + str));
                writer.write(34);
            }
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    static class CsvUnescaper extends CharSequenceTranslator {
        private static final char CSV_QUOTE = '\"';
        private static final String CSV_QUOTE_STR = String.valueOf('\"');
        private static final char CSV_DELIMITER = ',';
        private static final char[] CSV_SEARCH_CHARS = {CSV_DELIMITER, '\"', CharUtils.f1521CR, '\n'};

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CsvUnescaper() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
        public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i != 0) {
                throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
            }
            if (charSequence.charAt(0) != '\"' || charSequence.charAt(charSequence.length() - 1) != '\"') {
                writer.write(charSequence.toString());
                return Character.codePointCount(charSequence, 0, charSequence.length());
            }
            String obj = charSequence.subSequence(1, charSequence.length() - 1).toString();
            if (StringUtils.containsAny(obj, CSV_SEARCH_CHARS)) {
                StringBuilder sb = new StringBuilder();
                String str = CSV_QUOTE_STR;
                writer.write(StringUtils.replace(obj, sb.append(str).append(str).toString(), str));
            } else {
                writer.write(charSequence.toString());
            }
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String escapeJava(String str) {
        return ESCAPE_JAVA.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String escapeEcmaScript(String str) {
        return ESCAPE_ECMASCRIPT.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String escapeJson(String str) {
        return ESCAPE_JSON.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String unescapeJava(String str) {
        return UNESCAPE_JAVA.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String unescapeEcmaScript(String str) {
        return UNESCAPE_ECMASCRIPT.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String unescapeJson(String str) {
        return UNESCAPE_JSON.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String escapeHtml4(String str) {
        return ESCAPE_HTML4.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String escapeHtml3(String str) {
        return ESCAPE_HTML3.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String unescapeHtml4(String str) {
        return UNESCAPE_HTML4.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String unescapeHtml3(String str) {
        return UNESCAPE_HTML3.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static final String escapeXml(String str) {
        return ESCAPE_XML.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String escapeXml10(String str) {
        return ESCAPE_XML10.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String escapeXml11(String str) {
        return ESCAPE_XML11.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String unescapeXml(String str) {
        return UNESCAPE_XML.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String escapeCsv(String str) {
        return ESCAPE_CSV.translate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String unescapeCsv(String str) {
        return UNESCAPE_CSV.translate(str);
    }
}
