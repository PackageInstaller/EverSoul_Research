package com.kakaogame.util.json.parser;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParseException.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, m839d2 = {"Lcom/kakaogame/util/json/parser/ParseException;", "Ljava/lang/Exception;", "errorType", "", "(I)V", "unexpectedObject", "", "(ILjava/lang/Object;)V", "position", "(IILjava/lang/Object;)V", "getErrorType", "()I", "setErrorType", "message", "", "getMessage", "()Ljava/lang/String;", "getPosition", "setPosition", "getUnexpectedObject", "()Ljava/lang/Object;", "setUnexpectedObject", "(Ljava/lang/Object;)V", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ParseException extends Exception {
    public static final int ERROR_UNEXPECTED_CHAR = 0;
    public static final int ERROR_UNEXPECTED_EXCEPTION = 2;
    public static final int ERROR_UNEXPECTED_TOKEN = 1;
    private static final long serialVersionUID = -7880698968187728547L;
    private int errorType;
    private int position;
    private Object unexpectedObject;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ParseException(int i, int i2, Object obj) {
        this.position = i;
        this.errorType = i2;
        this.unexpectedObject = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getErrorType() {
        return this.errorType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPosition() {
        return this.position;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object getUnexpectedObject() {
        return this.unexpectedObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setErrorType(int i) {
        this.errorType = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setPosition(int i) {
        this.position = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setUnexpectedObject(Object obj) {
        this.unexpectedObject = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ParseException(int i) {
        this(-1, i, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ParseException(int i, Object obj) {
        this(-1, i, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = this.errorType;
        String str = y.ݮڮֲڭܩ(-629059348);
        if (i == 0) {
            stringBuffer.append(y.٬ݯح׭٩(576270038)).append(this.unexpectedObject).append(y.֬ڱܱײٮ(-1159022951)).append(this.position).append(str);
        } else if (i == 1) {
            stringBuffer.append(y.ٴسسݬߨ(1393224074)).append(this.unexpectedObject).append(y.دײܮڳܯ(2051270685)).append(this.position).append(str);
        } else if (i == 2) {
            stringBuffer.append(y.ݮڮֲڭܩ(-628171540)).append(this.position).append(y.ݬֲ֮ܲت(1512932847)).append(this.unexpectedObject);
        } else {
            stringBuffer.append(y.٬ݯح׭٩(576269270)).append(this.position).append(str);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
        return stringBuffer2;
    }
}
