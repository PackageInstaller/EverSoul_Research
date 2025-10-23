package com.facebook.unity;

import android.os.Bundle;
import android.util.Log;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UnityParams {
    JSONObject json;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnityParams(String str) throws JSONException {
        this.json = new JSONObject(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnityParams(JSONObject jSONObject) {
        this.json = jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnityParams(Map<String, Serializable> map) {
        this.json = new JSONObject(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnityParams parse(String str, String str2) {
        try {
            return new UnityParams(str);
        } catch (JSONException unused) {
            Log.e(C0848FB.TAG, str2);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnityParams parse(String str) {
        return parse(str, "couldn't parse params: " + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getString(String str) {
        try {
            return this.json.getString(str);
        } catch (JSONException unused) {
            Log.e(C0848FB.TAG, "cannot get string " + str + " from " + toString());
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double getDouble(String str) {
        try {
            return this.json.getDouble(str);
        } catch (JSONException unused) {
            Log.e(C0848FB.TAG, "cannot get double " + str + " from " + toString());
            return 0.0d;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnityParams getParamsObject(String str) {
        try {
            return new UnityParams(this.json.getJSONObject(str));
        } catch (JSONException unused) {
            Log.e(C0848FB.TAG, "cannot get object " + str + " from " + toString());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void put(String str, Object obj) {
        try {
            this.json.put(str, obj);
        } catch (JSONException unused) {
            Log.e(C0848FB.TAG, "couldn't add key " + str + " to " + toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean has(String str) {
        return this.json.has(str) && !this.json.isNull(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean hasString(String str) {
        return Boolean.valueOf(has(str) && getString(str) != "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle getStringParams() {
        Bundle bundle = new Bundle();
        Iterator<String> keys = this.json.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string = this.json.getString(next);
                if (string != null) {
                    bundle.putString(next, string);
                }
            } catch (JSONException unused) {
            }
        }
        return bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.json.toString();
    }
}
