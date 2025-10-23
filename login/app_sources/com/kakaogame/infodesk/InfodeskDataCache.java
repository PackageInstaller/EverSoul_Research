package com.kakaogame.infodesk;

import android.content.Context;
import com.kakaogame.config.Configuration;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InfodeskDataCache.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskDataCache;", "", "()V", "PREF_KEY", "", "TAG", "getCachedData", "Lcom/kakaogame/infodesk/InfodeskData;", "context", "Landroid/content/Context;", "config", "Lcom/kakaogame/config/Configuration;", "savedCache", "", "data", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InfodeskDataCache {
    public static final InfodeskDataCache INSTANCE = new InfodeskDataCache();
    private static final String PREF_KEY = "cachedInfodesk";
    private static final String TAG = "InfodeskDataCache";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InfodeskDataCache() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.infodesk.InfodeskData getCachedData(android.content.Context r11, com.kakaogame.config.Configuration r12) {
        /*
            r0 = 576582958(0x225df52e, float:3.0080882E-18)
            java.lang.String r0 = com.liapp.y.٬ݯح׭٩(r0)
            r1 = 1512979991(0x5a2e3e17, float:1.2261229E16)
            java.lang.String r1 = com.liapp.y.ݬֲ֮ܲت(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            r1 = -628584492(0xffffffffda888fd4, float:-1.9219369E16)
            java.lang.String r1 = com.liapp.y.ݮڮֲڭܩ(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            boolean r1 = com.kakaogame.version.SDKVersion.isPublishing
            r2 = 0
            if (r1 == 0) goto L21
            return r2
        L21:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 2051486701(0x7a4733ed, float:2.5858006E35)
            java.lang.String r3 = com.liapp.y.دײܮڳܯ(r3)
            r1.<init>(r3)
            java.lang.String r3 = r12.getAppId()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r12 = r12.getServerTypeString()
            com.kakaogame.config.Configuration$KGServerType r3 = com.kakaogame.config.Configuration.KGServerType.LIVE
            java.lang.String r3 = r3.getValue()
            r4 = 1
            boolean r3 = kotlin.text.StringsKt.equals(r3, r12, r4)
            if (r3 != 0) goto L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r1 = r3.append(r1)
            r3 = 45
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r12 = r1.append(r12)
            java.lang.String r1 = r12.toString()
        L61:
            boolean r12 = com.kakaogame.util.PreferenceUtil.contains(r11, r1, r0)     // Catch: java.lang.Exception -> L7b
            if (r12 == 0) goto L7b
            java.lang.String r11 = com.kakaogame.util.PreferenceUtil.getString(r11, r1, r0)     // Catch: java.lang.Exception -> L7b
            java.lang.Object r11 = com.kakaogame.util.json.JSONValue.parse(r11)     // Catch: java.lang.Exception -> L7b
            boolean r12 = r11 instanceof com.kakaogame.util.json.JSONObject     // Catch: java.lang.Exception -> L7b
            if (r12 == 0) goto L7b
            com.kakaogame.infodesk.InfodeskData r12 = new com.kakaogame.infodesk.InfodeskData     // Catch: java.lang.Exception -> L7b
            java.util.Map r11 = (java.util.Map) r11     // Catch: java.lang.Exception -> L7b
            r12.<init>(r11)     // Catch: java.lang.Exception -> L7b
            goto L7c
        L7b:
            r12 = r2
        L7c:
            if (r12 == 0) goto Lf9
            com.kakaogame.infodesk.InfodeskHelper r11 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE
            long r0 = r11.getInfodeskCacheHour(r12)
            com.kakaogame.server.SNTPClient r11 = new com.kakaogame.server.SNTPClient
            r11.<init>()
            long r3 = android.os.SystemClock.uptimeMillis()
            r5 = 1512511903(0x5a27199f, float:1.1758623E16)
            java.lang.String r5 = com.liapp.y.ݬֲ֮ܲت(r5)
            r6 = 5000(0x1388, float:7.006E-42)
            boolean r5 = r11.requestTime(r5, r6)
            if (r5 == 0) goto Lf9
            long r5 = r11.getNtpTime()
            long r7 = android.os.SystemClock.uptimeMillis()
            com.kakaogame.Logger r11 = com.kakaogame.Logger.INSTANCE
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r10 = 862608315(0x336a5bbb, float:5.45658E-8)
            java.lang.String r10 = com.liapp.y.ۮڭڭܬި(r10)
            r9.<init>(r10)
            java.lang.StringBuilder r9 = r9.append(r5)
            r10 = 1393439418(0x530e32ba, float:6.107364E11)
            java.lang.String r10 = com.liapp.y.ٴسسݬߨ(r10)
            java.lang.StringBuilder r9 = r9.append(r10)
            long r7 = r7 - r3
            java.lang.StringBuilder r3 = r9.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = -1158779383(0xffffffffbaee6e09, float:-0.0018190752)
            java.lang.String r4 = com.liapp.y.֬ڱܱײٮ(r4)
            r11.m699d(r4, r3)
            r3 = 0
            int r11 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r11 != 0) goto Ldb
            goto Lf9
        Ldb:
            r3 = -1
            int r11 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r11 != 0) goto Le2
            goto Lf8
        Le2:
            com.kakaogame.infodesk.InfodeskHelper r11 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE
            long r3 = r11.getInfodeskDataTime(r12)
            long r3 = r5 - r3
            int r11 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r11 <= 0) goto Lef
            goto Lf9
        Lef:
            com.kakaogame.core.CoreManager$Companion r11 = com.kakaogame.core.CoreManager.INSTANCE
            com.kakaogame.core.CoreManager r11 = r11.getInstance()
            r11.setServerTimeStamp(r5)
        Lf8:
            r2 = r12
        Lf9:
            return r2
            fill-array 0x00fa: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.infodesk.InfodeskDataCache.getCachedData(android.content.Context, com.kakaogame.config.Configuration):com.kakaogame.infodesk.InfodeskData");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void savedCache(Context context, Configuration config, InfodeskData data) {
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        String str = y.دײܮڳܯ(2051486701) + config.getAppId();
        String serverTypeString = config.getServerTypeString();
        if (!StringsKt.equals(Configuration.KGServerType.LIVE.getValue(), serverTypeString, true)) {
            str = str + '-' + serverTypeString;
        }
        PreferenceUtil.setString(context, str, PREF_KEY, new JSONObject(data).toJSONString());
    }
}
