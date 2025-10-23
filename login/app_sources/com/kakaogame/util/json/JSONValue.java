package com.kakaogame.util.json;

import com.kakaogame.util.json.parser.ContainerFactory;
import com.kakaogame.util.json.parser.JSONParser;
import com.kakaogame.util.json.parser.ParseException;
import com.liapp.y;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSONValue.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\t\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/util/json/JSONValue;", "", "()V", "escape", "", "s", "", "sb", "Ljava/lang/StringBuffer;", "parse", "reader", "Ljava/io/Reader;", "toJSONString", "value", "writeJSONString", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class JSONValue {
    public static final JSONValue INSTANCE = new JSONValue();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private JSONValue() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object parse(Reader reader) throws IOException, ParseException {
        return JSONParser.parse$default(new JSONParser(), reader, (ContainerFactory) null, 2, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Object parse(String s) throws ParseException {
        return JSONParser.parse$default(new JSONParser(), s, (ContainerFactory) null, 2, (Object) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String writeJSONString(Object value) throws IOException {
        StringWriter stringWriter = new StringWriter();
        String str = y.ݮڮֲڭܩ(-628841308);
        if (value == null) {
            stringWriter.write(str);
        } else if (value instanceof String) {
            stringWriter.write(34);
            stringWriter.write(escape((String) value));
            stringWriter.write(34);
        } else if (value instanceof Double) {
            Number number = (Number) value;
            if (Double.isInfinite(number.doubleValue()) || Double.isNaN(number.doubleValue())) {
                stringWriter.write(str);
            } else {
                stringWriter.write(String.valueOf(number.doubleValue()));
            }
        } else if (value instanceof Float) {
            Number number2 = (Number) value;
            if (Float.isInfinite(number2.floatValue()) || Float.isNaN(number2.floatValue())) {
                stringWriter.write(str);
            } else {
                stringWriter.write(String.valueOf(number2.floatValue()));
            }
        } else if (value instanceof Number) {
            stringWriter.write(((Number) value).toString());
        } else if (value instanceof Boolean) {
            stringWriter.write(String.valueOf(((Boolean) value).booleanValue()));
        } else if (value instanceof Map) {
            stringWriter.write(JSONObject.INSTANCE.writeJSONString((Map) value));
        } else if (value instanceof Collection) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((Collection<? extends Object>) value));
        } else if (value instanceof byte[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((byte[]) value));
        } else if (value instanceof short[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((short[]) value));
        } else if (value instanceof int[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((int[]) value));
        } else if (value instanceof long[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((long[]) value));
        } else if (value instanceof float[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((float[]) value));
        } else if (value instanceof double[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((double[]) value));
        } else if (value instanceof boolean[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((boolean[]) value));
        } else if (value instanceof char[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((char[]) value));
        } else if (value instanceof Object[]) {
            stringWriter.write(JSONArray.INSTANCE.writeJSONString((Object[]) value));
        } else if (value instanceof JSONStreamAware) {
            stringWriter.write(((JSONStreamAware) value).writeJSONString());
        } else if (value instanceof JSONAware) {
            stringWriter.write(((JSONAware) value).toJSONString());
        } else if (value instanceof Enum) {
            stringWriter.write(((Enum) value).name());
        } else {
            stringWriter.write(value.toString());
        }
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
        return stringWriter2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String toJSONString(Object value) {
        try {
            return writeJSONString(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String escape(String s) {
        if (s == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        escape(s, stringBuffer);
        return stringBuffer.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void escape(String s, StringBuffer sb) {
        Intrinsics.checkNotNullParameter(s, y.ٲٴݴ״ٰ(1781877368));
        Intrinsics.checkNotNullParameter(sb, y.ٲٴݴ״ٰ(1782550200));
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (charAt == '\"') {
                sb.append(y.ݮڮֲڭܩ(-628919564));
            } else if (charAt == '\\') {
                sb.append(y.ٴسسݬߨ(1392985730));
            } else if (charAt == '\b') {
                sb.append(y.دײܮڳܯ(2051623837));
            } else if (charAt == '\f') {
                sb.append(y.ۮڭڭܬި(862200659));
            } else if (charAt == '\n') {
                sb.append(y.ݬֲ֮ܲت(1512661399));
            } else if (charAt == '\r') {
                sb.append(y.٬ݯح׭٩(575901358));
            } else if (charAt == '\t') {
                sb.append(y.֬ڱܱײٮ(-1159719047));
            } else if (charAt == '/') {
                sb.append(y.ݬֲ֮ܲت(1512991879));
            } else {
                if (!(charAt >= 0 && charAt < ' ')) {
                    if (!(127 <= charAt && charAt < 160)) {
                        if (!(8192 <= charAt && charAt < 8448)) {
                            sb.append(charAt);
                        }
                    }
                }
                String hexString = Integer.toHexString(charAt);
                sb.append(y.ݮڮֲڭܩ(-628940484));
                for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
                    sb.append('0');
                }
                Intrinsics.checkNotNull(hexString);
                String upperCase = hexString.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, y.ٲٴݴ״ٰ(1782555280));
                sb.append(upperCase);
            }
        }
    }
}
