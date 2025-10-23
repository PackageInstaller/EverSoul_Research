package com.kakaogame.util.json;

import com.kakaogame.Logger;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSONUtil.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007J\"\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\fJ$\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/util/json/JSONUtil;", "", "()V", "TAG", "", "getInt", "", "jsonObj", "Lcom/kakaogame/util/json/JSONObject;", "key", "defValue", "getLong", "", "getString", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class JSONUtil {
    public static final JSONUtil INSTANCE = new JSONUtil();
    private static final String TAG = "JSONUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private JSONUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int getInt(JSONObject jsonObj, String key, int defValue) {
        int parseInt;
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.دײܮڳܯ(2051248845)).append(key);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(defValue).append(str).append(jsonObj).toString();
        String str2 = y.دײܮڳܯ(2051249021);
        logger.m706v(str2, sb);
        try {
            if (jsonObj == null) {
                Logger.INSTANCE.m701e(str2, "object is null");
                return defValue;
            }
            if (key == null) {
                Logger.INSTANCE.m701e(str2, "key is null");
                return defValue;
            }
            if (!jsonObj.containsKey((Object) key)) {
                Logger.INSTANCE.m704i(str2, "key is not contains");
                return defValue;
            }
            Object obj = jsonObj.get((Object) key);
            if (obj instanceof Number) {
                parseInt = ((Number) obj).intValue();
            } else {
                if (!(obj instanceof String)) {
                    return defValue;
                }
                parseInt = Integer.parseInt((String) obj);
            }
            return parseInt;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return defValue;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getLong(JSONObject jsonObj, String key, long defValue) {
        long parseLong;
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.֬ڱܱײٮ(-1159014567)).append(key);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(defValue).append(str).append(jsonObj).toString();
        String str2 = y.دײܮڳܯ(2051249021);
        logger.m706v(str2, sb);
        try {
            if (jsonObj == null) {
                Logger.INSTANCE.m701e(str2, "object is null");
                return defValue;
            }
            if (key == null) {
                Logger.INSTANCE.m701e(str2, "key is null");
                return defValue;
            }
            if (!jsonObj.containsKey((Object) key)) {
                Logger.INSTANCE.m704i(str2, "key is not contains");
                return defValue;
            }
            Object obj = jsonObj.get((Object) key);
            if (obj instanceof Number) {
                parseLong = ((Number) obj).longValue();
            } else {
                if (!(obj instanceof String)) {
                    return defValue;
                }
                parseLong = Long.parseLong((String) obj);
            }
            return parseLong;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return defValue;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getString(JSONObject jsonObj, String key, String defValue) {
        Intrinsics.checkNotNullParameter(defValue, y.ݬֲ֮ܲت(1512291015));
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.֬ڱܱײٮ(-1159014567)).append(key);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(defValue).append(str).append(jsonObj).toString();
        String str2 = y.دײܮڳܯ(2051249021);
        logger.m706v(str2, sb);
        try {
            if (jsonObj == null) {
                Logger.INSTANCE.m701e(str2, "object is null");
                return defValue;
            }
            if (key == null) {
                Logger.INSTANCE.m701e(str2, "key is null");
                return defValue;
            }
            if (!jsonObj.containsKey((Object) key)) {
                Logger.INSTANCE.m704i(str2, "key is not contains");
                return defValue;
            }
            Object obj = jsonObj.get((Object) key);
            return obj instanceof String ? (String) obj : defValue;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return defValue;
        }
    }
}
