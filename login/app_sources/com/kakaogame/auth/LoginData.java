package com.kakaogame.auth;

import android.text.TextUtils;
import com.kakaogame.KGMarketRefundInfo;
import com.kakaogame.KGObject;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: LoginData.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bJ\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\rR!\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b!\u0010\r¨\u0006)"}, m839d2 = {"Lcom/kakaogame/auth/LoginData;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "accessToken", "Lcom/kakaogame/auth/LoginData$ZinnyAccessToken;", "getAccessToken", "()Lcom/kakaogame/auth/LoginData$ZinnyAccessToken;", "idpId", "getIdpId", "()Ljava/lang/String;", "isFirstLogin", "", "()Z", "isMarketRefund", "marketRefundInfoList", "", "Lcom/kakaogame/KGMarketRefundInfo;", "getMarketRefundInfoList", "()Ljava/util/List;", "onetimeToken", "getOnetimeToken", "player", "getPlayer", "()Ljava/util/Map;", "playerId", "getPlayerId", "siwaAccessToken", "getSiwaAccessToken", "siwaRefreshToken", "getSiwaRefreshToken", "setAccessToken", "", ServerConstants.ZAT, "update", "newData", "Companion", "ZinnyAccessToken", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LoginData extends KGObject {
    private static final long serialVersionUID = -9102519671861618637L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LoginData(Map<String, Object> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, y.ٴسسݬߨ(1392530698));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void update(LoginData newData) {
        Intrinsics.checkNotNullParameter(newData, y.ٲٴݴ״ٰ(1782170968));
        Map<String, Object> content = newData.getContent();
        Intrinsics.checkNotNull(content);
        for (String str : content.keySet()) {
            Map<String, Object> content2 = newData.getContent();
            Intrinsics.checkNotNull(content2);
            Object obj = content2.get(str);
            if (obj != null) {
                put(str, obj);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> getPlayer() {
        return TypeIntrinsics.asMutableMap(get(y.ۮڭڭܬި(862276451)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPlayerId() {
        Map<String, Object> player = getPlayer();
        if (player == null) {
            return "";
        }
        Object obj = player.get(y.ݬֲ֮ܲت(1512589743));
        Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
        return (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdpId() {
        String str = (String) get(y.٬ݯح׭٩(576653590));
        return str == null ? y.ٲٴݴ״ٰ(1782169840) : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ZinnyAccessToken getAccessToken() {
        String str = (String) get(y.ݮڮֲڭܩ(-628583628));
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        Object obj = get(y.֬ڱܱײٮ(-1158900543));
        String str3 = y.دײܮڳܯ(2051781685);
        Intrinsics.checkNotNull(obj, str3);
        long longValue = ((Long) obj).longValue();
        String str4 = y.֬ڱܱײٮ(-1158905039);
        if (containsKey(str4)) {
            Object obj2 = get(str4);
            Intrinsics.checkNotNull(obj2, y.ݬֲ֮ܲت(1512814407));
            String str5 = (String) obj2;
            Object obj3 = get(y.ٲٴݴ״ٰ(1782169720));
            Intrinsics.checkNotNull(obj3, str3);
            return new ZinnyAccessToken(str, longValue, str5, ((Long) obj3).longValue());
        }
        return new ZinnyAccessToken(str, longValue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isFirstLogin() {
        String str = y.֬ڱܱײٮ(-1158904815);
        try {
            if (!containsKey(str)) {
                return false;
            }
            Object obj = get(str);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) obj).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getOnetimeToken() {
        Object obj;
        String str = y.ٴسسݬߨ(1393350882);
        try {
            return (!containsKey(str) || (obj = get(str)) == null) ? "" : (String) obj;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSiwaAccessToken() {
        Object obj;
        String str = y.ٲٴݴ״ٰ(1782174560);
        try {
            return (!containsKey(str) || (obj = get(str)) == null) ? "" : (String) obj;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:3:0x0010, B:5:0x0016, B:7:0x0021, B:12:0x002d, B:14:0x0033), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getSiwaRefreshToken() {
        /*
            r4 = this;
            r0 = -1158898111(0xffffffffbaec9e41, float:-0.0018052534)
            java.lang.String r0 = com.liapp.y.֬ڱܱײٮ(r0)
            r1 = -628570132(0xffffffffda88c7ec, float:-1.9250207E16)
            java.lang.String r1 = com.liapp.y.ݮڮֲڭܩ(r1)
            java.lang.String r2 = ""
            boolean r3 = r4.containsKey(r1)     // Catch: java.lang.Exception -> L3f
            if (r3 == 0) goto L3f
            java.lang.Object r1 = r4.get(r1)     // Catch: java.lang.Exception -> L3f
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L3f
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> L3f
            if (r3 == 0) goto L2a
            int r3 = r3.length()     // Catch: java.lang.Exception -> L3f
            if (r3 != 0) goto L28
            goto L2a
        L28:
            r3 = 0
            goto L2b
        L2a:
            r3 = 1
        L2b:
            if (r3 == 0) goto L3e
            boolean r1 = r4.containsKey(r0)     // Catch: java.lang.Exception -> L3f
            if (r1 == 0) goto L3f
            java.lang.Object r0 = r4.get(r0)     // Catch: java.lang.Exception -> L3f
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L3f
            if (r0 != 0) goto L3c
            goto L3f
        L3c:
            r2 = r0
            goto L3f
        L3e:
            r2 = r1
        L3f:
            return r2
            fill-array 0x0040: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.auth.LoginData.getSiwaRefreshToken():java.lang.String");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isMarketRefund() {
        String str;
        String str2 = y.دײܮڳܯ(2051398653);
        return containsKey(str2) && (str = (String) get(str2)) != null && Intrinsics.areEqual(str, y.ٲٴݴ״ٰ(1782171336));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<KGMarketRefundInfo> getMarketRefundInfoList() {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = (JSONArray) get(y.ݬֲ֮ܲت(1512436663));
        if (jSONArray == null) {
            return arrayList;
        }
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new KGMarketRefundInfo((JSONObject) jSONArray.get(i)));
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setAccessToken(ZinnyAccessToken zat) {
        String str = y.ݮڮֲڭܩ(-628583628);
        Intrinsics.checkNotNullParameter(zat, str);
        put(str, zat.getZat());
        put(y.֬ڱܱײٮ(-1158900543), Long.valueOf(zat.getExpiryTime()));
    }

    /* compiled from: LoginData.kt */
    @Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\u0018\u001a\u00020\rJ\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/auth/LoginData$ZinnyAccessToken;", "", ServerConstants.ZAT, "", "expiryTime", "", "(Ljava/lang/String;J)V", ServerConstants.ZRT, "ztrExpiryTime", "(Ljava/lang/String;JLjava/lang/String;J)V", "getExpiryTime", "()J", "isExpired", "", "()Z", "isZrtExpired", "getZat", "()Ljava/lang/String;", "setZat", "(Ljava/lang/String;)V", "<set-?>", "getZrt", ServerConstants.ZRT_EXPIRY_TIME, "getZrtExpiryTime", "needRefresh", "toString", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class ZinnyAccessToken {
        private final long expiryTime;
        private String zat;
        private String zrt;
        private long zrtExpiryTime;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getZat() {
            return this.zat;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setZat(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            this.zat = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getZrt() {
            return this.zrt;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getExpiryTime() {
            return this.expiryTime;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getZrtExpiryTime() {
            return this.zrtExpiryTime;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ZinnyAccessToken(String str, long j) {
            Intrinsics.checkNotNullParameter(str, y.ݮڮֲڭܩ(-628583628));
            this.zrt = "";
            this.zat = str;
            this.expiryTime = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ZinnyAccessToken(String str, long j, String str2, long j2) {
            Intrinsics.checkNotNullParameter(str, y.ݮڮֲڭܩ(-628583628));
            Intrinsics.checkNotNullParameter(str2, y.֬ڱܱײٮ(-1158905039));
            this.zat = str;
            this.expiryTime = j;
            this.zrt = str2;
            this.zrtExpiryTime = j2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isExpired() {
            return CoreManager.INSTANCE.getInstance().currentTimeMillis() > this.expiryTime;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isZrtExpired() {
            return TextUtils.isEmpty(this.zrt) || CoreManager.INSTANCE.getInstance().currentTimeMillis() > this.zrtExpiryTime;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean needRefresh() {
            return this.expiryTime - CoreManager.INSTANCE.getInstance().currentTimeMillis() < InfodeskHelper.INSTANCE.getZatRefreshInterval();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return y.دײܮڳܯ(2051398725) + this.zat + y.ݮڮֲڭܩ(-628561244) + this.expiryTime + ']';
        }
    }
}
