package twitter4j;

import com.liapp.y;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import twitter4j.JSONStringer;

/* loaded from: classes4.dex */
public class JSONArray {
    private final List<Object> values;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray() {
        this.values = new ArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray(Collection collection) {
        this();
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                put(JSONObject.wrap(it.next()));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray(JSONTokener jSONTokener) throws JSONException {
        Object nextValue = jSONTokener.nextValue();
        if (nextValue instanceof JSONArray) {
            this.values = ((JSONArray) nextValue).values;
            return;
        }
        throw JSON.typeMismatch(nextValue, y.ٴسسݬߨ(1393279570));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray(Object obj) throws JSONException {
        if (!obj.getClass().isArray()) {
            throw new JSONException(y.ݬֲ֮ܲت(1512237791) + obj.getClass());
        }
        int length = Array.getLength(obj);
        this.values = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            put(JSONObject.wrap(Array.get(obj, i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int length() {
        return this.values.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(boolean z) {
        this.values.add(Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(double d) throws JSONException {
        this.values.add(Double.valueOf(JSON.checkDouble(d)));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(int i) {
        this.values.add(Integer.valueOf(i));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(long j) {
        this.values.add(Long.valueOf(j));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(Object obj) {
        this.values.add(obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void checkedPut(Object obj) throws JSONException {
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        put(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(int i, boolean z) throws JSONException {
        return put(i, Boolean.valueOf(z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(int i, double d) throws JSONException {
        return put(i, Double.valueOf(d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(int i, int i2) throws JSONException {
        return put(i, Integer.valueOf(i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(int i, long j) throws JSONException {
        return put(i, Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray put(int i, Object obj) throws JSONException {
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        while (this.values.size() <= i) {
            this.values.add(null);
        }
        this.values.set(i, obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isNull(int i) {
        Object opt = opt(i);
        return opt == null || opt == JSONObject.NULL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object get(int i) throws JSONException {
        String str = y.ݮڮֲڭܩ(-628100348);
        try {
            Object obj = this.values.get(i);
            if (obj != null) {
                return obj;
            }
            throw new JSONException(str + i + " is null.");
        } catch (IndexOutOfBoundsException unused) {
            throw new JSONException(y.֬ڱܱײٮ(-1158963367) + i + y.دײܮڳܯ(2051195093) + this.values.size() + y.ٴسسݬߨ(1392959042));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object opt(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object remove(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getBoolean(int i) throws JSONException {
        Object obj = get(i);
        Boolean bool = JSON.toBoolean(obj);
        if (bool == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, y.ٴسسݬߨ(1392973754));
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean optBoolean(int i) {
        return optBoolean(i, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean optBoolean(int i, boolean z) {
        Boolean bool = JSON.toBoolean(opt(i));
        return bool != null ? bool.booleanValue() : z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double getDouble(int i) throws JSONException {
        Object obj = get(i);
        Double d = JSON.toDouble(obj);
        if (d == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, y.ݮڮֲڭܩ(-628939444));
        }
        return d.doubleValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double optDouble(int i) {
        return optDouble(i, Double.NaN);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double optDouble(int i, double d) {
        Double d2 = JSON.toDouble(opt(i));
        return d2 != null ? d2.doubleValue() : d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getInt(int i) throws JSONException {
        Object obj = get(i);
        Integer integer = JSON.toInteger(obj);
        if (integer == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, y.ۮڭڭܬި(862157299));
        }
        return integer.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int optInt(int i) {
        return optInt(i, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int optInt(int i, int i2) {
        Integer integer = JSON.toInteger(opt(i));
        return integer != null ? integer.intValue() : i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getLong(int i) throws JSONException {
        Object obj = get(i);
        Long l = JSON.toLong(obj);
        if (l == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, y.֬ڱܱײٮ(-1159246383));
        }
        return l.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long optLong(int i) {
        return optLong(i, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long optLong(int i, long j) {
        Long l = JSON.toLong(opt(i));
        return l != null ? l.longValue() : j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getString(int i) throws JSONException {
        Object obj = get(i);
        String json = JSON.toString(obj);
        if (json != null) {
            return json;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, y.ٲٴݴ״ٰ(1782504624));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String optString(int i) {
        return optString(i, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String optString(int i, String str) {
        String json = JSON.toString(opt(i));
        return json != null ? json : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray getJSONArray(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, y.ٴسسݬߨ(1393279570));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray optJSONArray(int i) {
        Object opt = opt(i);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject getJSONObject(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, y.دײܮڳܯ(2051195189));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject optJSONObject(int i) {
        Object opt = opt(i);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int min = Math.min(jSONArray.length(), this.values.size());
        if (min == 0) {
            return null;
        }
        for (int i = 0; i < min; i++) {
            jSONObject.put(JSON.toString(jSONArray.opt(i)), opt(i));
        }
        return jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String join(String str) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer();
        jSONStringer.open(JSONStringer.Scope.NULL, "");
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                jSONStringer.out.append(str);
            }
            jSONStringer.value(this.values.get(i));
        }
        jSONStringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
        return jSONStringer.out.toString();
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
        jSONStringer.array();
        Iterator<Object> it = this.values.iterator();
        while (it.hasNext()) {
            jSONStringer.value(it.next());
        }
        jSONStringer.endArray();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof JSONArray) && ((JSONArray) obj).values.equals(this.values);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.values.hashCode();
    }
}
