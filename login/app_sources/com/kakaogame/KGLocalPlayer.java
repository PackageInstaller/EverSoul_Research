package com.kakaogame;

import android.app.Activity;
import android.text.TextUtils;
import com.kakao.sdk.user.Constants;
import com.kakaogame.auth.agreement.AgreementManager;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.player.LocalPlayer;
import com.kakaogame.player.LocalPlayerService;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGLocalPlayer.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\b\u0000\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000fH\u0002J\u0018\u0010\u000e\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0012J.\u0010\u0013\u001a\u00020\u00102\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00152\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0012J(\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0002J(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0012J \u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000f2\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/KGLocalPlayer;", "Lcom/kakaogame/KGPlayer;", "m", "", "", "", "(Ljava/util/Map;)V", "memberKey", "getMemberKey", "()Ljava/lang/String;", "registTime", "", "getRegistTime", "()J", "getPaymentUserId", "Lcom/kakaogame/KGResult;", "", "callback", "Lcom/kakaogame/KGResultCallback;", "saveCustomProperties", Constants.PROPERTIES, "", "Ljava/lang/Void;", "saveCustomProperty", "key", "value", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGLocalPlayer extends KGPlayer {
    private static final String CLASS_NAME_KEY = "KGLocalPlayer";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "KGLocalPlayer";
    private static final long serialVersionUID = 2212447869967575942L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGLocalPlayer getCurrentPlayer() {
        return INSTANCE.getCurrentPlayer();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGLocalPlayer(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMemberKey() {
        try {
            return (String) get("memberKey");
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159581143), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getRegistTime() {
        long j = 0;
        try {
            Object obj = get(LocalPlayerService.FIELD_KEY_FIRST_LOGIN_TIME);
            if (obj != null) {
                if (obj instanceof Long) {
                    j = ((Number) obj).longValue();
                } else if (obj instanceof String) {
                    j = Long.parseLong((String) obj);
                }
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159581143), e.toString(), e);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> getPaymentUserId() {
        KGResult<String> result;
        KGResult<String> kGResult;
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٴسسݬߨ(1392672258));
        try {
            try {
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    result = KGResult.INSTANCE.getResult(3002, "Not Authorized");
                    kGResult = result;
                } else {
                    kGResult = null;
                    result = LocalPlayerService.INSTANCE.getPaymentUserId();
                }
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), kGResult, start.getDurationMs());
            } catch (Exception e) {
                Logger.INSTANCE.m702e("KGLocalPlayer", e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
            }
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void getPaymentUserId(KGResultCallback<String> callback) {
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159581143), y.֬ڱܱײٮ(-1159583903));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLocalPlayer$getPaymentUserId$3(this, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> saveCustomProperty(String key, String value) {
        KGResult<Void> result;
        String name;
        KGResult<Void> result2;
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٲٴݴ״ٰ(1782016776));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e("KGLocalPlayer", e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                result2 = KGResult.INSTANCE.getResult(3002, "Not Authorized");
            } else if (TextUtils.isEmpty(key)) {
                result2 = KGResult.INSTANCE.getResult(4000, "key is null");
            } else {
                if (value != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(key, value);
                    result = KGResult.INSTANCE.getResult(saveCustomProperties(linkedHashMap));
                    start.stop();
                    name = start.getName();
                    KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                    return result;
                }
                result2 = KGResult.INSTANCE.getResult(4000, "value is null");
            }
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
            return result2;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void saveCustomProperty(String key, String value, KGResultCallback<Void> callback) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Intrinsics.checkNotNullParameter(value, y.ݬֲ֮ܲت(1512942783));
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159581143), y.ٴسسݬߨ(1392671490) + key + y.ݮڮֲڭܩ(-628756788) + value);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLocalPlayer$saveCustomProperty$6(this, key, value, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: all -> 0x00af, Exception -> 0x00b1, TryCatch #0 {Exception -> 0x00b1, blocks: (B:4:0x003b, B:6:0x0047, B:11:0x0062, B:16:0x006e, B:17:0x0084, B:19:0x008e, B:21:0x0098, B:22:0x009c, B:23:0x009f), top: B:3:0x003b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084 A[Catch: all -> 0x00af, Exception -> 0x00b1, TryCatch #0 {Exception -> 0x00b1, blocks: (B:4:0x003b, B:6:0x0047, B:11:0x0062, B:16:0x006e, B:17:0x0084, B:19:0x008e, B:21:0x0098, B:22:0x009c, B:23:0x009f), top: B:3:0x003b, outer: #1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Void> saveCustomProperties(java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r5 = this;
            r0 = -1159585167(0xffffffffbae22271, float:-0.0017252696)
            java.lang.String r0 = com.liapp.y.֬ڱܱײٮ(r0)
            r1 = 862328571(0x336616fb, float:5.357195E-8)
            java.lang.String r1 = com.liapp.y.ۮڭڭܬި(r1)
            com.kakaogame.Logger r2 = com.kakaogame.Logger.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 1512788967(0x5a2b53e7, float:1.2056118E16)
            java.lang.String r4 = com.liapp.y.ݬֲ֮ܲت(r4)
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r3 = r3.toString()
            r4 = -1159581143(0xffffffffbae23229, float:-0.001725738)
            java.lang.String r4 = com.liapp.y.֬ڱܱײٮ(r4)
            r2.m699d(r4, r3)
            com.kakaogame.util.Stopwatch$Companion r2 = com.kakaogame.util.Stopwatch.INSTANCE
            r3 = -1159584767(0xffffffffbae22401, float:-0.0017253162)
            java.lang.String r3 = com.liapp.y.֬ڱܱײٮ(r3)
            com.kakaogame.util.Stopwatch r2 = r2.start(r3)
            com.kakaogame.core.CoreManager$Companion r3 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            com.kakaogame.core.CoreManager r3 = r3.getInstance()     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            boolean r3 = r3.isNotAuthorized()     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            if (r3 == 0) goto L60
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            java.lang.String r0 = "Not Authorized"
            r1 = 3002(0xbba, float:4.207E-42)
            com.kakaogame.KGResult r6 = r6.getResult(r1, r0)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
        L51:
            r2.stop()
            java.lang.String r0 = r2.getName()
            long r1 = r2.getDurationMs()
            com.kakaogame.core.KGResultUtil.writeClientApiCall(r0, r6, r1)
            return r6
        L60:
            if (r6 == 0) goto L6b
            boolean r3 = r6.isEmpty()     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            if (r3 == 0) goto L69
            goto L6b
        L69:
            r3 = 0
            goto L6c
        L6b:
            r3 = 1
        L6c:
            if (r3 == 0) goto L84
            com.kakaogame.KGResult$Companion r0 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            r3.<init>(r1)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            java.lang.StringBuilder r6 = r3.append(r6)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            r1 = 4000(0xfa0, float:5.605E-42)
            com.kakaogame.KGResult r6 = r0.getResult(r1, r6)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            goto L51
        L84:
            com.kakaogame.KGResult r1 = com.kakaogame.player.LocalPlayerService.updateCustomProperty(r6)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            boolean r3 = r1.isSuccess()     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            if (r3 == 0) goto L9f
            java.lang.Object r3 = r5.get(r0)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            java.util.Map r3 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r3)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            if (r3 == 0) goto L9c
            r3.putAll(r6)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            goto L9f
        L9c:
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
        L9f:
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            com.kakaogame.KGResult r6 = r6.getResult(r1)     // Catch: java.lang.Throwable -> Laf java.lang.Exception -> Lb1
            r2.stop()
            java.lang.String r0 = r2.getName()
            goto Ld4
        Laf:
            r6 = move-exception
            goto Ldc
        Lb1:
            r6 = move-exception
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> Laf
            r3 = r6
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch: java.lang.Throwable -> Laf
            r0.m702e(r4, r1, r3)     // Catch: java.lang.Throwable -> Laf
            com.kakaogame.KGResult$Companion r0 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Laf
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Laf
            r1 = 4001(0xfa1, float:5.607E-42)
            com.kakaogame.KGResult r6 = r0.getResult(r1, r6)     // Catch: java.lang.Throwable -> Laf
            r2.stop()
            java.lang.String r0 = r2.getName()
            r1 = r6
            com.kakaogame.KGResult r1 = (com.kakaogame.KGResult) r1
        Ld4:
            long r1 = r2.getDurationMs()
            com.kakaogame.core.KGResultUtil.writeClientApiCall(r0, r6, r1)
            return r6
        Ldc:
            r2.stop()
            java.lang.String r0 = r2.getName()
            r1 = 0
            r3 = r1
            com.kakaogame.KGResult r3 = (com.kakaogame.KGResult) r3
            long r2 = r2.getDurationMs()
            com.kakaogame.core.KGResultUtil.writeClientApiCall(r0, r1, r2)
            throw r6
            fill-array 0x00f0: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGLocalPlayer.saveCustomProperties(java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void saveCustomProperties(Map<String, String> properties, KGResultCallback<Void> callback) {
        Intrinsics.checkNotNullParameter(properties, y.دײܮڳܯ(2051766413));
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159581143), y.ٴسسݬߨ(1392671490) + properties);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLocalPlayer$saveCustomProperties$5(this, properties, callback, null), 3, null);
    }

    /* compiled from: KGLocalPlayer.kt */
    @Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J.\u0010\u0017\u001a\u00020\u00122\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/KGLocalPlayer$Companion;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "agreements", "", "getAgreements", "()Ljava/util/Map;", "currentPlayer", "Lcom/kakaogame/KGLocalPlayer;", "getCurrentPlayer$annotations", "getCurrentPlayer", "()Lcom/kakaogame/KGLocalPlayer;", "serialVersionUID", "", "initInterfaceBroker", "", "initialize", "setAgreement", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "setAgreements", "callback", "Lcom/kakaogame/KGResultCallback;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getCurrentPlayer$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGLocalPlayer getCurrentPlayer() {
            try {
                LocalPlayer player = CoreManager.INSTANCE.getInstance().getPlayer();
                if (player == null) {
                    return null;
                }
                KGLocalPlayer kGLocalPlayer = new KGLocalPlayer(player.getObject());
                KGIdpProfile localIdpProfile = KGIdpProfile.INSTANCE.getLocalIdpProfile();
                Intrinsics.checkNotNull(localIdpProfile);
                localIdpProfile.put("playerId", kGLocalPlayer.getPlayerId());
                kGLocalPlayer.put(KGPlayer.KEY_IDP_PROFILE, localIdpProfile);
                kGLocalPlayer.put("online", true);
                kGLocalPlayer.put(KGPlayer.KEY_IS_ONLINE_UNITY, true);
                return kGLocalPlayer;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159581143), e.toString(), e);
                return null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, String> getAgreements() {
            HashMap hashMap = new HashMap();
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                return hashMap;
            }
            try {
                LocalPlayer player = CoreManager.INSTANCE.getInstance().getPlayer();
                if (player == null) {
                    return hashMap;
                }
                Map<String, String> agreement = player.getAgreement();
                return agreement == null ? hashMap : agreement;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159581143), e.toString(), e);
                return hashMap;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setAgreements(Map<String, String> agreements, KGResultCallback<Void> callback) {
            String str = y.֬ڱܱײٮ(-1159581143);
            if (callback == null) {
                Logger.INSTANCE.m701e(str, "setAgreements: Invalid Parameter! 'callback' is null.");
            } else if (agreements != null && !agreements.isEmpty()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLocalPlayer$Companion$setAgreements$1(agreements, callback, null), 3, null);
            } else {
                Logger.INSTANCE.m701e(str, y.٬ݯح׭٩(575775990));
                callback.onResult(KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159577687)));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<Void> setAgreement(Map<String, String> agreements) {
            KGResult<Void> result;
            String name;
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                return KGResult.INSTANCE.getResult(3002);
            }
            Stopwatch start = Stopwatch.INSTANCE.start(y.ۮڭڭܬި(862326483));
            try {
                try {
                    result = AgreementManager.saveAgreement(agreements);
                    if (result.isSuccess()) {
                        KGResult.INSTANCE.getSuccessResult();
                    } else {
                        KGResult.INSTANCE.getResult(result);
                    }
                    start.stop();
                    name = start.getName();
                } catch (Exception e) {
                    Logger.INSTANCE.m702e("KGLocalPlayer", e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                }
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            } catch (Throwable th) {
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392667066), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLocalPlayer$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.ۮڭڭܬި(862276451), currentPlayer != null ? currentPlayer.getObject() : null);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782019072), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLocalPlayer$Companion$initInterfaceBroker$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Intrinsics.checkNotNull(currentPlayer);
                    String memberKey = currentPlayer.getMemberKey();
                    if (memberKey == null) {
                        memberKey = "";
                    }
                    linkedHashMap.put(y.ٲٴݴ״ٰ(1782046688), memberKey);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512787903), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLocalPlayer$Companion$initInterfaceBroker$3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> paymentUserId;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    if (KGLocalPlayer.INSTANCE.getCurrentPlayer() == null) {
                        return KGResult.INSTANCE.getResult(3002, y.٬ݯح׭٩(575777366));
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                    Intrinsics.checkNotNull(currentPlayer);
                    paymentUserId = currentPlayer.getPaymentUserId();
                    FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159581143), y.ݮڮֲڭܩ(-628728868), paymentUserId);
                    if (paymentUserId.isSuccess()) {
                        String str = (String) paymentUserId.getContent();
                        if (str == null) {
                            str = "";
                        }
                        linkedHashMap.put(y.ٲٴݴ״ٰ(1782019848), str);
                        return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                    }
                    return KGResult.INSTANCE.getResult(paymentUserId);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628731644), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLocalPlayer$Companion$initInterfaceBroker$4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    if (KGLocalPlayer.INSTANCE.getCurrentPlayer() == null) {
                        return KGResult.INSTANCE.getResult(3002, y.٬ݯح׭٩(575777366));
                    }
                    Object parameter = request.getParameter("key");
                    Intrinsics.checkNotNull(parameter, y.ݬֲ֮ܲت(1512814407));
                    String str = (String) request.getParameter(y.ݬֲ֮ܲت(1512942783));
                    KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                    Intrinsics.checkNotNull(currentPlayer);
                    KGResult<Void> saveCustomProperty = currentPlayer.saveCustomProperty((String) parameter, str);
                    FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159581143), y.ۮڭڭܬި(862323107), saveCustomProperty);
                    return saveCustomProperty;
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051761381), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLocalPlayer$Companion$initInterfaceBroker$5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> saveCustomProperties;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    if (KGLocalPlayer.INSTANCE.getCurrentPlayer() == null) {
                        return KGResult.INSTANCE.getResult(3002, y.٬ݯح׭٩(575777366));
                    }
                    Map asMutableMap = TypeIntrinsics.asMutableMap(request.getParameter(Constants.PROPERTIES));
                    KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                    Intrinsics.checkNotNull(currentPlayer);
                    saveCustomProperties = currentPlayer.saveCustomProperties(asMutableMap);
                    FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159581143), y.ݮڮֲڭܩ(-628728476), saveCustomProperties);
                    return saveCustomProperties;
                }
            });
        }
    }
}
