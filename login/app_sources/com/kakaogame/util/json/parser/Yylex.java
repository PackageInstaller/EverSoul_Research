package com.kakaogame.util.json.parser;

import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import java.io.IOException;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Yylex.kt */
@Metadata(m838d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u0006J\b\u0010!\u001a\u0004\u0018\u00010\"J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0006J\u0010\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u0006\u0010'\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0006H\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m839d2 = {"Lcom/kakaogame/util/json/parser/Yylex;", "", "zzReader", "Ljava/io/Reader;", "(Ljava/io/Reader;)V", "<set-?>", "", "position", "getPosition", "()I", "sb", "Ljava/lang/StringBuffer;", "yycolumn", "yyline", "zzAtBOL", "", "zzAtEOF", "zzBuffer", "", "zzCurrentPos", "zzEndRead", "zzLexicalState", "zzMarkedPos", "zzStartRead", "zzState", "yybegin", "", "newState", "yycharat", "", "pos", "yyclose", "yylength", "yylex", "Lcom/kakaogame/util/json/parser/Yytoken;", "yypushback", Base2ndPWViewData.KEY_NUMBER, "yyreset", "reader", "yystate", "yytext", "", "zzRefill", "zzScanError", "errorCode", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Yylex {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int STRING_BEGIN = 2;
    public static final int YYEOF = -1;
    public static final int YYINITIAL = 0;
    private static final int[] ZZ_ACTION;
    private static final String ZZ_ACTION_PACKED_0 = "\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018";
    private static final int[] ZZ_ATTRIBUTE;
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t";
    private static final int ZZ_BUFFERSIZE = 16384;
    private static final char[] ZZ_CMAP;
    private static final String ZZ_CMAP_PACKED = "\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016ﾂ\u0000";
    private static final String[] ZZ_ERROR_MSG;
    private static final int[] ZZ_LEXSTATE;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final int[] ZZ_ROWMAP;
    private static final String ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000¢\u0000½\u0000Ø\u00006\u00006\u00006\u00006\u00006\u00006\u0000ó\u0000Ď\u00006\u0000ĩ\u0000ń\u0000ş\u0000ź\u0000ƕ\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000ư\u0000ǋ\u0000Ǧ\u0000Ǧ\u0000ȁ\u0000Ȝ\u0000ȷ\u0000ɒ\u00006\u00006\u0000ɭ\u0000ʈ\u00006";
    private static final int[] ZZ_TRANS;
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private int position;
    private int yycolumn;
    private int yyline;
    private boolean zzAtEOF;
    private int zzCurrentPos;
    private int zzEndRead;
    private int zzLexicalState;
    private int zzMarkedPos;
    private Reader zzReader;
    private int zzStartRead;
    private int zzState;
    private char[] zzBuffer = new char[16384];
    private boolean zzAtBOL = true;
    private StringBuffer sb = new StringBuffer();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Yylex(Reader reader) {
        this.zzReader = reader;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPosition() {
        return this.position;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzRefill() throws IOException {
        int i = this.zzStartRead;
        if (i > 0) {
            char[] cArr = this.zzBuffer;
            System.arraycopy(cArr, i, cArr, 0, this.zzEndRead - i);
            int i2 = this.zzEndRead;
            int i3 = this.zzStartRead;
            this.zzEndRead = i2 - i3;
            this.zzCurrentPos -= i3;
            this.zzMarkedPos -= i3;
            this.zzStartRead = 0;
        }
        int i4 = this.zzCurrentPos;
        char[] cArr2 = this.zzBuffer;
        if (i4 >= cArr2.length) {
            char[] cArr3 = new char[i4 * 2];
            System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
            this.zzBuffer = cArr3;
        }
        Reader reader = this.zzReader;
        Intrinsics.checkNotNull(reader);
        char[] cArr4 = this.zzBuffer;
        int i5 = this.zzEndRead;
        int read = reader.read(cArr4, i5, cArr4.length - i5);
        if (read > 0) {
            this.zzEndRead += read;
            return false;
        }
        if (read != 0) {
            return true;
        }
        Reader reader2 = this.zzReader;
        Intrinsics.checkNotNull(reader2);
        int read2 = reader2.read();
        if (read2 == -1) {
            return true;
        }
        char[] cArr5 = this.zzBuffer;
        int i6 = this.zzEndRead;
        this.zzEndRead = i6 + 1;
        cArr5[i6] = (char) read2;
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void yyclose() throws IOException {
        this.zzAtEOF = true;
        this.zzEndRead = this.zzStartRead;
        Reader reader = this.zzReader;
        if (reader != null) {
            Intrinsics.checkNotNull(reader);
            reader.close();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void yyreset(Reader reader) {
        this.zzReader = reader;
        this.zzAtBOL = true;
        this.zzAtEOF = false;
        this.zzStartRead = 0;
        this.zzEndRead = 0;
        this.zzMarkedPos = 0;
        this.zzCurrentPos = 0;
        this.yycolumn = 0;
        this.position = 0;
        this.yyline = 0;
        this.zzLexicalState = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int yystate() {
        return this.zzLexicalState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void yybegin(int newState) {
        this.zzLexicalState = newState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String yytext() {
        char[] cArr = this.zzBuffer;
        int i = this.zzStartRead;
        return new String(cArr, i, this.zzMarkedPos - i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final char yycharat(int pos) {
        return this.zzBuffer[this.zzStartRead + pos];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int yylength() {
        return this.zzMarkedPos - this.zzStartRead;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzScanError(int errorCode) {
        String str;
        try {
            str = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException unused) {
            str = ZZ_ERROR_MSG[0];
        }
        throw new Error(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void yypushback(int number) {
        if (number > yylength()) {
            zzScanError(2);
        }
        this.zzMarkedPos -= number;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Yytoken yylex() throws IOException, ParseException {
        char c;
        int i;
        int i2 = this.zzEndRead;
        char[] cArr = this.zzBuffer;
        char[] cArr2 = ZZ_CMAP;
        int[] iArr = ZZ_TRANS;
        int[] iArr2 = ZZ_ROWMAP;
        int[] iArr3 = ZZ_ATTRIBUTE;
        while (true) {
            int i3 = this.zzMarkedPos;
            this.position += i3 - this.zzStartRead;
            this.zzStartRead = i3;
            this.zzCurrentPos = i3;
            this.zzState = ZZ_LEXSTATE[this.zzLexicalState];
            char c2 = 65535;
            int i4 = i3;
            int i5 = -1;
            while (true) {
                if (i3 < i2) {
                    int i6 = i3 + 1;
                    c = cArr[i3];
                    i = i4;
                    i4 = i6;
                } else if (this.zzAtEOF) {
                    c = c2;
                } else {
                    this.zzCurrentPos = i3;
                    this.zzMarkedPos = i4;
                    boolean zzRefill = zzRefill();
                    int i7 = this.zzCurrentPos;
                    i4 = this.zzMarkedPos;
                    char[] cArr3 = this.zzBuffer;
                    int i8 = this.zzEndRead;
                    if (zzRefill) {
                        cArr = cArr3;
                        c = c2;
                        i2 = i8;
                    } else {
                        i4 = i7 + 1;
                        i2 = i8;
                        i = i4;
                        c = cArr3[i7];
                        cArr = cArr3;
                    }
                }
                int i9 = iArr[iArr2[this.zzState] + cArr2[c]];
                if (i9 != c2) {
                    this.zzState = i9;
                    int i10 = iArr3[i9];
                    if ((i10 & 1) != 1) {
                        i3 = i4;
                        i4 = i;
                    } else if ((i10 & 8) == 8) {
                        i5 = i9;
                    } else {
                        i3 = i4;
                        i5 = i9;
                    }
                    c2 = 65535;
                } else {
                    i4 = i;
                }
            }
            this.zzMarkedPos = i4;
            if (i5 >= 0) {
                i5 = ZZ_ACTION[i5];
            }
            switch (i5) {
                case 1:
                    throw new ParseException(this.position, 0, Character.valueOf(yycharat(0)));
                case 2:
                    return new Yytoken(0, Long.valueOf(yytext()));
                case 3:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                    break;
                case 4:
                    this.sb = null;
                    this.sb = new StringBuffer();
                    yybegin(2);
                    break;
                case 5:
                    return new Yytoken(1, null);
                case 6:
                    return new Yytoken(2, null);
                case 7:
                    return new Yytoken(3, null);
                case 8:
                    return new Yytoken(4, null);
                case 9:
                    return new Yytoken(5, null);
                case 10:
                    return new Yytoken(6, null);
                case 11:
                    StringBuffer stringBuffer = this.sb;
                    Intrinsics.checkNotNull(stringBuffer);
                    stringBuffer.append(yytext());
                    break;
                case 12:
                    StringBuffer stringBuffer2 = this.sb;
                    Intrinsics.checkNotNull(stringBuffer2);
                    stringBuffer2.append('\\');
                    break;
                case 13:
                    yybegin(0);
                    return new Yytoken(0, String.valueOf(this.sb));
                case 14:
                    StringBuffer stringBuffer3 = this.sb;
                    Intrinsics.checkNotNull(stringBuffer3);
                    stringBuffer3.append(Typography.quote);
                    break;
                case 15:
                    StringBuffer stringBuffer4 = this.sb;
                    Intrinsics.checkNotNull(stringBuffer4);
                    stringBuffer4.append('/');
                    break;
                case 16:
                    StringBuffer stringBuffer5 = this.sb;
                    Intrinsics.checkNotNull(stringBuffer5);
                    stringBuffer5.append('\b');
                    break;
                case 17:
                    StringBuffer stringBuffer6 = this.sb;
                    Intrinsics.checkNotNull(stringBuffer6);
                    stringBuffer6.append('\f');
                    break;
                case 18:
                    StringBuffer stringBuffer7 = this.sb;
                    Intrinsics.checkNotNull(stringBuffer7);
                    stringBuffer7.append('\n');
                    break;
                case 19:
                    StringBuffer stringBuffer8 = this.sb;
                    Intrinsics.checkNotNull(stringBuffer8);
                    stringBuffer8.append(CharUtils.f1521CR);
                    break;
                case 20:
                    StringBuffer stringBuffer9 = this.sb;
                    Intrinsics.checkNotNull(stringBuffer9);
                    stringBuffer9.append('\t');
                    break;
                case 21:
                    return new Yytoken(0, Double.valueOf(yytext()));
                case 22:
                    return new Yytoken(0, null);
                case 23:
                    return new Yytoken(0, Boolean.valueOf(yytext()));
                case 24:
                    try {
                        String substring = yytext().substring(2);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        int parseInt = Integer.parseInt(substring, CharsKt.checkRadix(16));
                        StringBuffer stringBuffer10 = this.sb;
                        Intrinsics.checkNotNull(stringBuffer10);
                        stringBuffer10.append((char) parseInt);
                        break;
                    } catch (Exception e) {
                        throw new ParseException(this.position, 2, e);
                    }
                default:
                    if (c == 65535 && this.zzStartRead == this.zzCurrentPos) {
                        this.zzAtEOF = true;
                        return null;
                    }
                    zzScanError(1);
                    break;
                    break;
            }
        }
    }

    /* compiled from: Yylex.kt */
    @Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J \u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\bH\u0002J \u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m839d2 = {"Lcom/kakaogame/util/json/parser/Yylex$Companion;", "", "()V", "STRING_BEGIN", "", "YYEOF", "YYINITIAL", "ZZ_ACTION", "", "ZZ_ACTION_PACKED_0", "", "ZZ_ATTRIBUTE", "ZZ_ATTRIBUTE_PACKED_0", "ZZ_BUFFERSIZE", "ZZ_CMAP", "", "ZZ_CMAP_PACKED", "ZZ_ERROR_MSG", "", "[Ljava/lang/String;", "ZZ_LEXSTATE", "ZZ_NO_MATCH", "ZZ_PUSHBACK_2BIG", "ZZ_ROWMAP", "ZZ_ROWMAP_PACKED_0", "ZZ_TRANS", "ZZ_UNKNOWN_ERROR", "zzUnpackAction", "packed", "offset", "result", "zzUnpackAttribute", "zzUnpackCMap", "zzUnpackRowMap", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int[] zzUnpackAction() {
            int[] iArr = new int[45];
            zzUnpackAction(Yylex.ZZ_ACTION_PACKED_0, 0, iArr);
            return iArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final int zzUnpackAction(String packed, int offset, int[] result) {
            int i;
            int length = packed.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                int charAt = packed.charAt(i2);
                int i4 = i3 + 1;
                char charAt2 = packed.charAt(i3);
                while (true) {
                    i = offset + 1;
                    result[offset] = charAt2;
                    charAt--;
                    if (charAt <= 0) {
                        break;
                    }
                    offset = i;
                }
                i2 = i4;
                offset = i;
            }
            return offset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int[] zzUnpackRowMap() {
            int[] iArr = new int[45];
            zzUnpackRowMap(Yylex.ZZ_ROWMAP_PACKED_0, 0, iArr);
            return iArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final int zzUnpackRowMap(String packed, int offset, int[] result) {
            int length = packed.length();
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                result[offset] = (packed.charAt(i) << 16) | packed.charAt(i2);
                offset++;
                i = i2 + 1;
            }
            return offset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int[] zzUnpackAttribute() {
            int[] iArr = new int[45];
            zzUnpackAttribute(Yylex.ZZ_ATTRIBUTE_PACKED_0, 0, iArr);
            return iArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final int zzUnpackAttribute(String packed, int offset, int[] result) {
            int i;
            int length = packed.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                int charAt = packed.charAt(i2);
                int i4 = i3 + 1;
                char charAt2 = packed.charAt(i3);
                while (true) {
                    i = offset + 1;
                    result[offset] = charAt2;
                    charAt--;
                    if (charAt <= 0) {
                        break;
                    }
                    offset = i;
                }
                i2 = i4;
                offset = i;
            }
            return offset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final char[] zzUnpackCMap(String packed) {
            int i;
            char[] cArr = new char[65536];
            int i2 = 0;
            int i3 = 0;
            while (i2 < 90) {
                int i4 = i2 + 1;
                int charAt = packed.charAt(i2);
                int i5 = i4 + 1;
                char charAt2 = packed.charAt(i4);
                while (true) {
                    i = i3 + 1;
                    cArr[i3] = charAt2;
                    charAt--;
                    if (charAt <= 0) {
                        break;
                    }
                    i3 = i;
                }
                i2 = i5;
                i3 = i;
            }
            return cArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        ZZ_LEXSTATE = new int[]{0, 0, 1, 1};
        ZZ_CMAP = companion.zzUnpackCMap(ZZ_CMAP_PACKED);
        ZZ_ACTION = companion.zzUnpackAction();
        ZZ_ROWMAP = companion.zzUnpackRowMap();
        ZZ_TRANS = new int[]{2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
        ZZ_ERROR_MSG = new String[]{y.ٲٴݴ״ٰ(1782577448), y.دײܮڳܯ(2051270229), y.ݬֲ֮ܲت(1512296079)};
        ZZ_ATTRIBUTE = companion.zzUnpackAttribute();
    }
}
