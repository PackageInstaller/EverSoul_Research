package com.kakaogame;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGMarketRefundInfo.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, m839d2 = {"Lcom/kakaogame/KGMarketRefundInfo;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", FirebaseAnalytics.Param.CURRENCY, "getCurrency", "()Ljava/lang/String;", "market", "getMarket", "marketOrderId", "getMarketOrderId", "marketProductId", "getMarketProductId", "marketPurchaseTime", "", "getMarketPurchaseTime", "()J", "marketRefundSeq", "getMarketRefundSeq", "marketRefundTime", "getMarketRefundTime", "os", "getOs", "playerId", "getPlayerId", FirebaseAnalytics.Param.PRICE, "", "getPrice", "()I", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGMarketRefundInfo extends KGObject {
    private static final String TAG = "KGMarketRefundInfo";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String getListUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1392664490), y.ݮڮֲڭܩ(-628724412));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadMarketRefundInfoList(KGResultCallback<List<KGMarketRefundInfo>> kGResultCallback) {
        INSTANCE.loadMarketRefundInfoList(kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGMarketRefundInfo(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getMarketRefundSeq() {
        try {
            Number number = (Number) get("marketRefundSeq");
            Intrinsics.checkNotNull(number);
            return number.longValue();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862336339), e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPlayerId() {
        return (String) get(y.ݬֲ֮ܲت(1512589743));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMarketProductId() {
        return (String) get(y.ۮڭڭܬި(862335955));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMarketOrderId() {
        return (String) get(y.ٴسسݬߨ(1392663090));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCurrency() {
        return (String) get(y.٬ݯح׭٩(575774190));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPrice() {
        try {
            Number number = (Number) get(FirebaseAnalytics.Param.PRICE);
            Intrinsics.checkNotNull(number);
            return number.intValue();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862336339), e.toString(), e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getMarketPurchaseTime() {
        try {
            Number number = (Number) get("marketPurchaseTime");
            Intrinsics.checkNotNull(number);
            return number.longValue();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862336339), e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getMarketRefundTime() {
        try {
            Number number = (Number) get("marketRefundTime");
            Intrinsics.checkNotNull(number);
            return number.longValue();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862336339), e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getOs() {
        return (String) get(y.ݮڮֲڭܩ(-628723908));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMarket() {
        return (String) get(y.دײܮڳܯ(2051758173));
    }

    /* compiled from: KGMarketRefundInfo.kt */
    @Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000eH\u0002J \u0010\r\u001a\u00020\u000b2\u0016\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0018\u00010\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/KGMarketRefundInfo$Companion;", "", "()V", "TAG", "", "getListUri", "getGetListUri", "()Ljava/lang/String;", "setGetListUri", "(Ljava/lang/String;)V", "initInterfaceBroker", "", "initialize", "loadMarketRefundInfoList", "Lcom/kakaogame/KGResult;", "", "Lcom/kakaogame/KGMarketRefundInfo;", "callback", "Lcom/kakaogame/KGResultCallback;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetListUri() {
            return KGMarketRefundInfo.getListUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetListUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            KGMarketRefundInfo.getListUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862333947), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGMarketRefundInfo$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult loadMarketRefundInfoList;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    loadMarketRefundInfoList = KGMarketRefundInfo.INSTANCE.loadMarketRefundInfoList();
                    if (loadMarketRefundInfoList.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(loadMarketRefundInfoList);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Object content = loadMarketRefundInfoList.getContent();
                    Intrinsics.checkNotNull(content);
                    linkedHashMap.put(y.٬ݯح׭٩(575768070), content);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void loadMarketRefundInfoList(KGResultCallback<List<KGMarketRefundInfo>> callback) {
            Logger logger = Logger.INSTANCE;
            String str = y.٬ݯح׭٩(575772982);
            String str2 = y.ۮڭڭܬި(862336339);
            logger.m704i(str2, str);
            if (callback != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGMarketRefundInfo$Companion$loadMarketRefundInfoList$1(callback, null), 3, null);
            } else {
                Logger.INSTANCE.m701e(str2, y.ݮڮֲڭܩ(-628725324));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<List<KGMarketRefundInfo>> loadMarketRefundInfoList() {
            ArrayList arrayList;
            try {
                ServerRequest serverRequest = new ServerRequest(getGetListUri());
                serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
                serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
                ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
                if (requestServer$default.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(requestServer$default);
                }
                JSONObject content = requestServer$default.getContent();
                Intrinsics.checkNotNull(content);
                JSONArray jSONArray = (JSONArray) content.get((Object) "marketRefundList");
                if (jSONArray != null) {
                    JSONArray jSONArray2 = jSONArray;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONArray2, 10));
                    Iterator<Object> it = jSONArray2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new KGMarketRefundInfo((JSONObject) it.next()));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = new ArrayList();
                }
                return KGResult.INSTANCE.getSuccessResult(arrayList);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ۮڭڭܬި(862336339), e.toString(), e);
                return KGResult.INSTANCE.getResult(4001, e.toString());
            }
        }
    }
}
