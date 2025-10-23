package com.kakaogame.util.json.parser;

import com.kakao.sdk.partner.talk.Constants;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: JSONParser.kt */
@Metadata(m838d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J \u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J$\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J\u001e\u0010\u0017\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J$\u0010\u0017\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J\u0016\u0010\u001f\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u0006\u0010!\u001a\u00020\u0016J\u0010\u0010!\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m839d2 = {"Lcom/kakaogame/util/json/parser/JSONParser;", "", "()V", "handlerStatusStack", "Ljava/util/LinkedList;", "lexer", "Lcom/kakaogame/util/json/parser/Yylex;", "position", "", "getPosition", "()I", "status", Constants.TOKEN, "Lcom/kakaogame/util/json/parser/Yytoken;", "createArrayContainer", "", "containerFactory", "Lcom/kakaogame/util/json/parser/ContainerFactory;", "createObjectContainer", "", "", "nextToken", "", "parse", "in", "Ljava/io/Reader;", "contentHandler", "Lcom/kakaogame/util/json/parser/ContentHandler;", "isResume", "", "s", "peekStatus", "statusStack", Base2ndPWViewData.KEY_RESET, "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class JSONParser {
    public static final int S_END = 6;
    public static final int S_INIT = 0;
    public static final int S_IN_ARRAY = 3;
    public static final int S_IN_ERROR = -1;
    public static final int S_IN_FINISHED_VALUE = 1;
    public static final int S_IN_OBJECT = 2;
    public static final int S_IN_PAIR_VALUE = 5;
    public static final int S_PASSED_PAIR_KEY = 4;
    private LinkedList<Object> handlerStatusStack;
    private final Yylex lexer = new Yylex(null);
    private int status;
    private Yytoken token;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object parse(Reader reader) throws IOException, ParseException {
        return parse$default(this, reader, (ContainerFactory) null, 2, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object parse(String str) throws ParseException {
        return parse$default(this, str, (ContainerFactory) null, 2, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void parse(Reader reader, ContentHandler contentHandler) throws IOException, ParseException {
        Intrinsics.checkNotNullParameter(contentHandler, y.دײܮڳܯ(2051271957));
        parse$default(this, reader, contentHandler, false, 4, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void parse(String str, ContentHandler contentHandler) throws ParseException {
        Intrinsics.checkNotNullParameter(contentHandler, y.دײܮڳܯ(2051271957));
        parse$default(this, str, contentHandler, false, 4, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int peekStatus(LinkedList<Object> statusStack) {
        if (statusStack.size() == 0) {
            return -1;
        }
        Object first = statusStack.getFirst();
        Intrinsics.checkNotNull(first, y.ۮڭڭܬި(862379403));
        return ((Integer) first).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void reset() {
        this.token = null;
        this.status = 0;
        this.handlerStatusStack = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void reset(Reader in) {
        this.lexer.yyreset(in);
        reset();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPosition() {
        return this.lexer.getPosition();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Object parse$default(JSONParser jSONParser, String str, ContainerFactory containerFactory, int i, Object obj) throws ParseException {
        if ((i & 2) != 0) {
            containerFactory = null;
        }
        return jSONParser.parse(str, containerFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object parse(String s, ContainerFactory containerFactory) throws ParseException {
        try {
            return parse(new StringReader(s), containerFactory);
        } catch (IOException e) {
            throw new ParseException(-1, 2, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Object parse$default(JSONParser jSONParser, Reader reader, ContainerFactory containerFactory, int i, Object obj) throws IOException, ParseException {
        if ((i & 2) != 0) {
            containerFactory = null;
        }
        return jSONParser.parse(reader, containerFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object parse(Reader in, ContainerFactory containerFactory) throws IOException, ParseException {
        Yytoken yytoken;
        int i;
        int i2;
        reset(in);
        LinkedList<Object> linkedList = new LinkedList<>();
        LinkedList linkedList2 = new LinkedList();
        do {
            try {
                nextToken();
                int i3 = this.status;
                if (i3 == -1) {
                    throw new ParseException(getPosition(), 1, this.token);
                }
                if (i3 == 0) {
                    Yytoken yytoken2 = this.token;
                    Intrinsics.checkNotNull(yytoken2);
                    int i4 = yytoken2.type;
                    if (i4 == 0) {
                        this.status = 1;
                        linkedList.addFirst(1);
                        Yytoken yytoken3 = this.token;
                        Intrinsics.checkNotNull(yytoken3);
                        linkedList2.addFirst(yytoken3.value);
                    } else if (i4 == 1) {
                        this.status = 2;
                        linkedList.addFirst(2);
                        linkedList2.addFirst(createObjectContainer(containerFactory));
                    } else if (i4 == 3) {
                        this.status = 3;
                        linkedList.addFirst(3);
                        linkedList2.addFirst(createArrayContainer(containerFactory));
                    } else {
                        this.status = -1;
                    }
                } else {
                    if (i3 == 1) {
                        Yytoken yytoken4 = this.token;
                        Intrinsics.checkNotNull(yytoken4);
                        if (yytoken4.type != -1) {
                            throw new ParseException(getPosition(), 1, this.token);
                        }
                        Object removeFirst = linkedList2.removeFirst();
                        Intrinsics.checkNotNull(removeFirst);
                        return removeFirst;
                    }
                    if (i3 == 2) {
                        Yytoken yytoken5 = this.token;
                        Intrinsics.checkNotNull(yytoken5);
                        int i5 = yytoken5.type;
                        if (i5 == 0) {
                            Yytoken yytoken6 = this.token;
                            Intrinsics.checkNotNull(yytoken6);
                            if (yytoken6.value instanceof String) {
                                Yytoken yytoken7 = this.token;
                                Intrinsics.checkNotNull(yytoken7);
                                linkedList2.addFirst((String) yytoken7.value);
                                this.status = 4;
                                linkedList.addFirst(4);
                            } else {
                                this.status = -1;
                            }
                        } else if (i5 == 2) {
                            if (linkedList2.size() > 1) {
                                linkedList.removeFirst();
                                linkedList2.removeFirst();
                                i = peekStatus(linkedList);
                            } else {
                                i = 1;
                            }
                            this.status = i;
                        } else if (i5 != 5) {
                            this.status = -1;
                        }
                    } else if (i3 == 3) {
                        Yytoken yytoken8 = this.token;
                        Intrinsics.checkNotNull(yytoken8);
                        int i6 = yytoken8.type;
                        String str = y.ٴسسݬߨ(1393224842);
                        if (i6 == 0) {
                            Object first = linkedList2.getFirst();
                            Intrinsics.checkNotNull(first, str);
                            List asMutableList = TypeIntrinsics.asMutableList(first);
                            Yytoken yytoken9 = this.token;
                            Intrinsics.checkNotNull(yytoken9);
                            asMutableList.add(yytoken9.value);
                        } else if (i6 == 1) {
                            Object first2 = linkedList2.getFirst();
                            Intrinsics.checkNotNull(first2, str);
                            List asMutableList2 = TypeIntrinsics.asMutableList(first2);
                            Map<String, Object> createObjectContainer = createObjectContainer(containerFactory);
                            asMutableList2.add(createObjectContainer);
                            this.status = 2;
                            linkedList.addFirst(2);
                            linkedList2.addFirst(createObjectContainer);
                        } else if (i6 == 3) {
                            Object first3 = linkedList2.getFirst();
                            Intrinsics.checkNotNull(first3, str);
                            List asMutableList3 = TypeIntrinsics.asMutableList(first3);
                            List<Object> createArrayContainer = createArrayContainer(containerFactory);
                            asMutableList3.add(createArrayContainer);
                            this.status = 3;
                            linkedList.addFirst(3);
                            linkedList2.addFirst(createArrayContainer);
                        } else if (i6 == 4) {
                            if (linkedList2.size() > 1) {
                                linkedList.removeFirst();
                                linkedList2.removeFirst();
                                i2 = peekStatus(linkedList);
                            } else {
                                i2 = 1;
                            }
                            this.status = i2;
                        } else if (i6 != 5) {
                            this.status = -1;
                        }
                    } else if (i3 == 4) {
                        Yytoken yytoken10 = this.token;
                        Intrinsics.checkNotNull(yytoken10);
                        int i7 = yytoken10.type;
                        String str2 = y.ݬֲ֮ܲت(1512814407);
                        if (i7 != 0) {
                            String str3 = y.٬ݯح׭٩(576280062);
                            if (i7 == 1) {
                                linkedList.removeFirst();
                                Object removeFirst2 = linkedList2.removeFirst();
                                Intrinsics.checkNotNull(removeFirst2, str2);
                                Object first4 = linkedList2.getFirst();
                                Intrinsics.checkNotNull(first4, str3);
                                Map asMutableMap = TypeIntrinsics.asMutableMap(first4);
                                Map<String, Object> createObjectContainer2 = createObjectContainer(containerFactory);
                                asMutableMap.put((String) removeFirst2, createObjectContainer2);
                                this.status = 2;
                                linkedList.addFirst(2);
                                linkedList2.addFirst(createObjectContainer2);
                            } else if (i7 == 3) {
                                linkedList.removeFirst();
                                Object removeFirst3 = linkedList2.removeFirst();
                                Intrinsics.checkNotNull(removeFirst3, str2);
                                Object first5 = linkedList2.getFirst();
                                Intrinsics.checkNotNull(first5, str3);
                                Map asMutableMap2 = TypeIntrinsics.asMutableMap(first5);
                                List<Object> createArrayContainer2 = createArrayContainer(containerFactory);
                                asMutableMap2.put((String) removeFirst3, createArrayContainer2);
                                this.status = 3;
                                linkedList.addFirst(3);
                                linkedList2.addFirst(createArrayContainer2);
                            } else if (i7 != 6) {
                                this.status = -1;
                            }
                        } else {
                            linkedList.removeFirst();
                            Object removeFirst4 = linkedList2.removeFirst();
                            Intrinsics.checkNotNull(removeFirst4, str2);
                            Object first6 = linkedList2.getFirst();
                            Intrinsics.checkNotNull(first6, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                            Map asMutableMap3 = TypeIntrinsics.asMutableMap(first6);
                            Yytoken yytoken11 = this.token;
                            Intrinsics.checkNotNull(yytoken11);
                            asMutableMap3.put((String) removeFirst4, yytoken11.value);
                            this.status = peekStatus(linkedList);
                        }
                    }
                }
                if (this.status == -1) {
                    throw new ParseException(getPosition(), 1, this.token);
                }
                yytoken = this.token;
                Intrinsics.checkNotNull(yytoken);
            } catch (IOException e) {
                throw e;
            }
        } while (yytoken.type != -1);
        throw new ParseException(getPosition(), 1, this.token);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void nextToken() throws ParseException, IOException {
        Yytoken yylex = this.lexer.yylex();
        this.token = yylex;
        if (yylex == null) {
            this.token = new Yytoken(-1, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, Object> createObjectContainer(ContainerFactory containerFactory) {
        if (containerFactory == null) {
            return new JSONObject();
        }
        Map<String, Object> createObjectContainer = containerFactory.createObjectContainer();
        return createObjectContainer == null ? new JSONObject() : createObjectContainer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final List<Object> createArrayContainer(ContainerFactory containerFactory) {
        if (containerFactory == null) {
            return new JSONArray();
        }
        List<Object> creatArrayContainer = containerFactory.creatArrayContainer();
        return creatArrayContainer == null ? new JSONArray() : creatArrayContainer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void parse$default(JSONParser jSONParser, String str, ContentHandler contentHandler, boolean z, int i, Object obj) throws ParseException {
        if ((i & 4) != 0) {
            z = false;
        }
        jSONParser.parse(str, contentHandler, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void parse(String s, ContentHandler contentHandler, boolean isResume) throws ParseException {
        Intrinsics.checkNotNullParameter(contentHandler, y.دײܮڳܯ(2051271957));
        try {
            parse(new StringReader(s), contentHandler, isResume);
        } catch (IOException e) {
            throw new ParseException(-1, 2, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void parse$default(JSONParser jSONParser, Reader reader, ContentHandler contentHandler, boolean z, int i, Object obj) throws IOException, ParseException {
        if ((i & 4) != 0) {
            z = false;
        }
        jSONParser.parse(reader, contentHandler, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void parse(Reader in, ContentHandler contentHandler, boolean isResume) throws IOException, ParseException {
        int i;
        int i2;
        Yytoken yytoken;
        Intrinsics.checkNotNullParameter(contentHandler, y.دײܮڳܯ(2051271957));
        if (!isResume) {
            reset(in);
            this.handlerStatusStack = new LinkedList<>();
        } else if (this.handlerStatusStack == null) {
            reset(in);
            this.handlerStatusStack = new LinkedList<>();
        }
        LinkedList<Object> linkedList = this.handlerStatusStack;
        Intrinsics.checkNotNull(linkedList);
        do {
            try {
                switch (this.status) {
                    case -1:
                        throw new ParseException(getPosition(), 1, this.token);
                    case 0:
                        contentHandler.startJSON();
                        nextToken();
                        Yytoken yytoken2 = this.token;
                        Intrinsics.checkNotNull(yytoken2);
                        int i3 = yytoken2.type;
                        if (i3 == 0) {
                            this.status = 1;
                            linkedList.addFirst(1);
                            Yytoken yytoken3 = this.token;
                            Intrinsics.checkNotNull(yytoken3);
                            if (!contentHandler.primitive(yytoken3.value)) {
                                return;
                            }
                        } else if (i3 == 1) {
                            this.status = 2;
                            linkedList.addFirst(2);
                            if (!contentHandler.startObject()) {
                                return;
                            }
                        } else if (i3 == 3) {
                            this.status = 3;
                            linkedList.addFirst(3);
                            if (!contentHandler.startArray()) {
                                return;
                            }
                        } else {
                            this.status = -1;
                            break;
                        }
                        break;
                    case 1:
                        nextToken();
                        Yytoken yytoken4 = this.token;
                        Intrinsics.checkNotNull(yytoken4);
                        if (yytoken4.type == -1) {
                            contentHandler.endJSON();
                            this.status = 6;
                            return;
                        } else {
                            this.status = -1;
                            throw new ParseException(getPosition(), 1, this.token);
                        }
                    case 2:
                        nextToken();
                        Yytoken yytoken5 = this.token;
                        Intrinsics.checkNotNull(yytoken5);
                        int i4 = yytoken5.type;
                        if (i4 == 0) {
                            Yytoken yytoken6 = this.token;
                            Intrinsics.checkNotNull(yytoken6);
                            if (yytoken6.value instanceof String) {
                                Yytoken yytoken7 = this.token;
                                Intrinsics.checkNotNull(yytoken7);
                                String str = (String) yytoken7.value;
                                this.status = 4;
                                linkedList.addFirst(4);
                                if (!contentHandler.startObjectEntry(str)) {
                                    return;
                                }
                            } else {
                                this.status = -1;
                                break;
                            }
                        } else if (i4 == 2) {
                            if (linkedList.size() > 1) {
                                linkedList.removeFirst();
                                i = peekStatus(linkedList);
                            } else {
                                i = 1;
                            }
                            this.status = i;
                            if (!contentHandler.endObject()) {
                                return;
                            }
                        } else if (i4 != 5) {
                            this.status = -1;
                            break;
                        }
                        break;
                    case 3:
                        nextToken();
                        Yytoken yytoken8 = this.token;
                        Intrinsics.checkNotNull(yytoken8);
                        int i5 = yytoken8.type;
                        if (i5 == 0) {
                            Yytoken yytoken9 = this.token;
                            Intrinsics.checkNotNull(yytoken9);
                            if (!contentHandler.primitive(yytoken9.value)) {
                                return;
                            }
                        } else if (i5 == 1) {
                            this.status = 2;
                            linkedList.addFirst(2);
                            if (!contentHandler.startObject()) {
                                return;
                            }
                        } else if (i5 == 3) {
                            this.status = 3;
                            linkedList.addFirst(3);
                            if (!contentHandler.startArray()) {
                                return;
                            }
                        } else if (i5 == 4) {
                            if (linkedList.size() > 1) {
                                linkedList.removeFirst();
                                i2 = peekStatus(linkedList);
                            } else {
                                i2 = 1;
                            }
                            this.status = i2;
                            if (!contentHandler.endArray()) {
                                return;
                            }
                        } else if (i5 != 5) {
                            this.status = -1;
                            break;
                        }
                        break;
                    case 4:
                        nextToken();
                        Yytoken yytoken10 = this.token;
                        Intrinsics.checkNotNull(yytoken10);
                        int i6 = yytoken10.type;
                        if (i6 == 0) {
                            linkedList.removeFirst();
                            this.status = peekStatus(linkedList);
                            Yytoken yytoken11 = this.token;
                            Intrinsics.checkNotNull(yytoken11);
                            if (!contentHandler.primitive(yytoken11.value) || !contentHandler.endObjectEntry()) {
                                return;
                            }
                        } else if (i6 == 1) {
                            linkedList.removeFirst();
                            linkedList.addFirst(5);
                            this.status = 2;
                            linkedList.addFirst(2);
                            if (!contentHandler.startObject()) {
                                return;
                            }
                        } else if (i6 == 3) {
                            linkedList.removeFirst();
                            linkedList.addFirst(5);
                            this.status = 3;
                            linkedList.addFirst(3);
                            if (!contentHandler.startArray()) {
                                return;
                            }
                        } else if (i6 != 6) {
                            this.status = -1;
                            break;
                        }
                        break;
                    case 5:
                        linkedList.removeFirst();
                        this.status = peekStatus(linkedList);
                        if (!contentHandler.endObjectEntry()) {
                            return;
                        }
                        break;
                    case 6:
                        return;
                }
                if (this.status == -1) {
                    throw new ParseException(getPosition(), 1, this.token);
                }
                yytoken = this.token;
                Intrinsics.checkNotNull(yytoken);
            } catch (ParseException e) {
                this.status = -1;
                throw e;
            } catch (IOException e2) {
                this.status = -1;
                throw e2;
            } catch (Error e3) {
                this.status = -1;
                throw e3;
            } catch (RuntimeException e4) {
                this.status = -1;
                throw e4;
            }
        } while (yytoken.type != -1);
        this.status = -1;
        throw new ParseException(getPosition(), 1, this.token);
    }
}
