package twitter4j;

import com.liapp.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import twitter4j.JSONStringer;

/* loaded from: classes4.dex */
public class JSONObject {
    private static final Double NEGATIVE_ZERO = Double.valueOf(-0.0d);
    public static final Object NULL = new Object() { // from class: twitter4j.JSONObject.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            return obj == this || obj == null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return y.ݮڮֲڭܩ(-628841308);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Objects.hashCode(null);
        }
    };
    private final LinkedHashMap<String, Object> nameValuePairs;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject() {
        this.nameValuePairs = new LinkedHashMap<>();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject(Map map) {
        this();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new NullPointerException(y.ݬֲ֮ܲت(1512250767));
            }
            this.nameValuePairs.put(str, wrap(entry.getValue()));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject(JSONTokener jSONTokener) throws JSONException {
        Object nextValue = jSONTokener.nextValue();
        if (nextValue instanceof JSONObject) {
            this.nameValuePairs = ((JSONObject) nextValue).nameValuePairs;
            return;
        }
        throw JSON.typeMismatch(nextValue, y.دײܮڳܯ(2051195189));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject(JSONObject jSONObject, String[] strArr) throws JSONException {
        this();
        for (String str : strArr) {
            Object opt = jSONObject.opt(str);
            if (opt != null) {
                this.nameValuePairs.put(str, opt);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int length() {
        return this.nameValuePairs.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject put(String str, boolean z) throws JSONException {
        this.nameValuePairs.put(checkName(str), Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject put(String str, double d) throws JSONException {
        this.nameValuePairs.put(checkName(str), Double.valueOf(JSON.checkDouble(d)));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject put(String str, int i) throws JSONException {
        this.nameValuePairs.put(checkName(str), Integer.valueOf(i));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject put(String str, long j) throws JSONException {
        this.nameValuePairs.put(checkName(str), Long.valueOf(j));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject put(String str, Object obj) throws JSONException {
        if (obj == null) {
            this.nameValuePairs.remove(str);
            return this;
        }
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        this.nameValuePairs.put(checkName(str), obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject putOpt(String str, Object obj) throws JSONException {
        return (str == null || obj == null) ? this : put(str, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject accumulate(String str, Object obj) throws JSONException {
        Object obj2 = this.nameValuePairs.get(checkName(str));
        if (obj2 == null) {
            return put(str, obj);
        }
        if (obj2 instanceof JSONArray) {
            ((JSONArray) obj2).checkedPut(obj);
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.checkedPut(obj2);
            jSONArray.checkedPut(obj);
            this.nameValuePairs.put(str, jSONArray);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject append(String str, Object obj) throws JSONException {
        JSONArray jSONArray;
        Object obj2 = this.nameValuePairs.get(checkName(str));
        if (obj2 instanceof JSONArray) {
            jSONArray = (JSONArray) obj2;
        } else if (obj2 == null) {
            jSONArray = new JSONArray();
            this.nameValuePairs.put(str, jSONArray);
        } else {
            throw new JSONException(y.دײܮڳܯ(2051935701) + str + y.٬ݯح׭٩(576199166));
        }
        jSONArray.checkedPut(obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String checkName(String str) throws JSONException {
        if (str != null) {
            return str;
        }
        throw new JSONException(y.֬ڱܱײٮ(-1158970551));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object remove(String str) {
        return this.nameValuePairs.remove(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isNull(String str) {
        Object obj = this.nameValuePairs.get(str);
        return obj == null || obj == NULL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean has(String str) {
        return this.nameValuePairs.containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object get(String str) throws JSONException {
        Object obj = this.nameValuePairs.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException(y.ٴسسݬߨ(1393287018) + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object opt(String str) {
        return this.nameValuePairs.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getBoolean(String str) throws JSONException {
        Object obj = get(str);
        Boolean bool = JSON.toBoolean(obj);
        if (bool == null) {
            throw JSON.typeMismatch(str, obj, y.ٴسسݬߨ(1392973754));
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean optBoolean(String str, boolean z) {
        Boolean bool = JSON.toBoolean(opt(str));
        return bool != null ? bool.booleanValue() : z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double getDouble(String str) throws JSONException {
        Object obj = get(str);
        Double d = JSON.toDouble(obj);
        if (d == null) {
            throw JSON.typeMismatch(str, obj, y.ݮڮֲڭܩ(-628939444));
        }
        return d.doubleValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double optDouble(String str, double d) {
        Double d2 = JSON.toDouble(opt(str));
        return d2 != null ? d2.doubleValue() : d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getInt(String str) throws JSONException {
        Object obj = get(str);
        Integer integer = JSON.toInteger(obj);
        if (integer == null) {
            throw JSON.typeMismatch(str, obj, y.ۮڭڭܬި(862157299));
        }
        return integer.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int optInt(String str) {
        return optInt(str, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int optInt(String str, int i) {
        Integer integer = JSON.toInteger(opt(str));
        return integer != null ? integer.intValue() : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getLong(String str) throws JSONException {
        Object obj = get(str);
        Long l = JSON.toLong(obj);
        if (l == null) {
            throw JSON.typeMismatch(str, obj, y.֬ڱܱײٮ(-1159246383));
        }
        return l.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long optLong(String str) {
        return optLong(str, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long optLong(String str, long j) {
        Long l = JSON.toLong(opt(str));
        return l != null ? l.longValue() : j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getString(String str) throws JSONException {
        Object obj = get(str);
        String json = JSON.toString(obj);
        if (json != null) {
            return json;
        }
        throw JSON.typeMismatch(str, obj, y.ٲٴݴ״ٰ(1782504624));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String optString(String str) {
        return optString(str, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String optString(String str, String str2) {
        String json = JSON.toString(opt(str));
        return json != null ? json : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray getJSONArray(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(str, obj, y.ٴسسݬߨ(1393279570));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray optJSONArray(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject getJSONObject(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(str, obj, y.دײܮڳܯ(2051195189));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject optJSONObject(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray toJSONArray(JSONArray jSONArray) throws JSONException {
        int length;
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            jSONArray2.put(opt(JSON.toString(jSONArray.opt(i))));
        }
        return jSONArray2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Iterator<String> keys() {
        return this.nameValuePairs.keySet().iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<String> keySet() {
        return this.nameValuePairs.keySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray names() {
        if (this.nameValuePairs.isEmpty()) {
            return null;
        }
        return new JSONArray((Collection) new ArrayList(this.nameValuePairs.keySet()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            writeTo(jSONStringer);
            return jSONStringer.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString(int i) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer(i);
        writeTo(jSONStringer);
        return jSONStringer.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void writeTo(JSONStringer jSONStringer) throws JSONException {
        jSONStringer.object();
        for (Map.Entry<String, Object> entry : this.nameValuePairs.entrySet()) {
            jSONStringer.key(entry.getKey()).value(entry.getValue());
        }
        jSONStringer.endObject();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String numberToString(Number number) throws JSONException {
        if (number == null) {
            throw new JSONException(y.ݬֲ֮ܲت(1512240799));
        }
        double doubleValue = number.doubleValue();
        JSON.checkDouble(doubleValue);
        if (number.equals(NEGATIVE_ZERO)) {
            return "-0";
        }
        long longValue = number.longValue();
        if (doubleValue == longValue) {
            return Long.toString(longValue);
        }
        return number.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String quote(String str) {
        if (str == null) {
            return "\"\"";
        }
        try {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.open(JSONStringer.Scope.NULL, "");
            jSONStringer.value(str);
            jSONStringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
            return jSONStringer.toString();
        } catch (JSONException unused) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object wrap(Object obj) {
        if (obj == null) {
            return NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(NULL)) {
            return obj;
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj);
        }
        if (obj.getClass().isArray()) {
            return new JSONArray(obj);
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj);
        }
        if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        }
        return obj;
    }
}
