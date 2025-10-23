package com.kakaogame.addon;

import com.kakaogame.KGObject;
import com.kakaogame.Logger;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGService.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/addon/KGService;", "Lcom/kakaogame/KGObject;", "data", "Lcom/kakaogame/util/json/JSONObject;", "(Lcom/kakaogame/util/json/JSONObject;)V", "code", "", "getCode", "()Ljava/lang/String;", KGService.COUNT, "", "getCount", "()I", KGService.KEY_ID, "getKeyId", KGService.SUB_ID, "getSubId", "checkNull", "obj", "", "Companion", "kakaogame_addon_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGService extends KGObject {
    public static final String CODE = "code";
    public static final String COUNT = "count";
    public static final String KEY_ID = "keyId";
    public static final String SUB_ID = "subId";
    private static final String TAG = "KGService";
    private static final long serialVersionUID = -5684282654915236764L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGService(JSONObject jSONObject) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(jSONObject, y.دײܮڳܯ(2051550101));
        put(y.ٲٴݴ״ٰ(1782168888), checkNull(jSONObject.get((Object) y.ۮڭڭܬި(862505163))));
        put(y.٬ݯح׭٩(575838374), jSONObject.get((Object) y.֬ڱܱײٮ(-1158873255)));
        put(y.دײܮڳܯ(2051572045), checkNull(jSONObject.get((Object) y.دײܮڳܯ(2051384829))));
        put(y.دײܮڳܯ(2051571757), checkNull(jSONObject.get((Object) y.ݬֲ֮ܲت(1512409375))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String checkNull(Object obj) {
        return obj == null ? "" : (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSubId() {
        return (String) get(y.ٲٴݴ״ٰ(1782168888));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getCount() {
        try {
            Number number = (Number) get(COUNT);
            Intrinsics.checkNotNull(number);
            return number.intValue();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051383509), e.toString(), e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKeyId() {
        return (String) get(y.دײܮڳܯ(2051572045));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCode() {
        return (String) get(y.دײܮڳܯ(2051571757));
    }
}
