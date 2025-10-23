package androidx.constraintlayout.core.parser;

import com.facebook.internal.ServerProtocol;

/* loaded from: classes.dex */
public class CLToken extends CLElement {
    int index;
    char[] tokenFalse;
    char[] tokenNull;
    char[] tokenTrue;
    Type type;

    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getBoolean() throws CLParsingException {
        if (this.type == Type.TRUE) {
            return true;
        }
        if (this.type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isNull() throws CLParsingException {
        if (this.type == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CLToken(char[] cArr) {
        super(cArr);
        this.index = 0;
        this.type = Type.UNKNOWN;
        this.tokenTrue = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.toCharArray();
        this.tokenFalse = "false".toCharArray();
        this.tokenNull = "null".toCharArray();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (CLParser.DEBUG) {
            return "<" + content() + ">";
        }
        return content();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Type getType() {
        return this.type;
    }

    /* renamed from: androidx.constraintlayout.core.parser.CLToken$1 */
    static /* synthetic */ class C01721 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = iArr;
            try {
                iArr[Type.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean validate(char c, long j) {
        int i = C01721.$SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[this.type.ordinal()];
        if (i == 1) {
            char[] cArr = this.tokenTrue;
            int i2 = this.index;
            r2 = cArr[i2] == c;
            if (r2 && i2 + 1 == cArr.length) {
                setEnd(j);
            }
        } else if (i == 2) {
            char[] cArr2 = this.tokenFalse;
            int i3 = this.index;
            r2 = cArr2[i3] == c;
            if (r2 && i3 + 1 == cArr2.length) {
                setEnd(j);
            }
        } else if (i == 3) {
            char[] cArr3 = this.tokenNull;
            int i4 = this.index;
            r2 = cArr3[i4] == c;
            if (r2 && i4 + 1 == cArr3.length) {
                setEnd(j);
            }
        } else if (i == 4) {
            char[] cArr4 = this.tokenTrue;
            int i5 = this.index;
            if (cArr4[i5] == c) {
                this.type = Type.TRUE;
            } else if (this.tokenFalse[i5] == c) {
                this.type = Type.FALSE;
            } else if (this.tokenNull[i5] == c) {
                this.type = Type.NULL;
            }
            r2 = true;
        }
        this.index++;
        return r2;
    }
}
