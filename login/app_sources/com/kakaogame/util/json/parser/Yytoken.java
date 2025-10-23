package com.kakaogame.util.json.parser;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Yytoken.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/util/json/parser/Yytoken;", "", "type", "", "value", "(ILjava/lang/Object;)V", "toString", "", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Yytoken {
    public static final int TYPE_COLON = 6;
    public static final int TYPE_COMMA = 5;
    public static final int TYPE_EOF = -1;
    public static final int TYPE_LEFT_BRACE = 1;
    public static final int TYPE_LEFT_SQUARE = 3;
    public static final int TYPE_RIGHT_BRACE = 2;
    public static final int TYPE_RIGHT_SQUARE = 4;
    public static final int TYPE_VALUE = 0;
    public int type;
    public Object value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Yytoken(int i, Object obj) {
        this.type = i;
        this.value = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.type) {
            case -1:
                stringBuffer.append(y.֬ڱܱײٮ(-1159020759));
                break;
            case 0:
                stringBuffer.append(y.ݮڮֲڭܩ(-628173436)).append(this.value).append(y.ٴسسݬߨ(1392959042));
                break;
            case 1:
                stringBuffer.append(y.دײܮڳܯ(2051269421));
                break;
            case 2:
                stringBuffer.append(y.֬ڱܱײٮ(-1159021087));
                break;
            case 3:
                stringBuffer.append(y.٬ݯح׭٩(576267374));
                break;
            case 4:
                stringBuffer.append(y.ٴسسݬߨ(1393223562));
                break;
            case 5:
                stringBuffer.append(y.ۮڭڭܬި(862883507));
                break;
            case 6:
                stringBuffer.append(y.ݬֲ֮ܲت(1512295599));
                break;
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
        return stringBuffer2;
    }
}
