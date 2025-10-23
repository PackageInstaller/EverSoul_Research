package com.kakaogame.addon;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.util.json.parser.ParseException;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddOnManager.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J(\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u0006H\u0007J:\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m839d2 = {"Lcom/kakaogame/addon/AddOnManager;", "", "()V", "TAG", "", "completeOrder", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "transactionID", SDKConstants.PARAM_PURCHASE_TOKEN, "consume", "gispPaymentUrl", "convertErrorCode", "", "code", "createCommonHeader", "", "createConsumeBody", "createPendingPurchasesBody", "getPendingPurchases", "loadIncompleteOrders", "", "Lcom/kakaogame/addon/KGService;", "requestOpenApi", "openApiUri", KeyBaseResult.KEY_HEADER, SDKConstants.PARAM_A2U_BODY, "Settings", "StoreResultCode", "kakaogame_addon_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AddOnManager {
    public static final AddOnManager INSTANCE = new AddOnManager();
    private static final String TAG = "AddOnManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AddOnManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<List<KGService>> loadIncompleteOrders() {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862317499);
        String str2 = y.ٲٴݴ״ٰ(1782168488);
        logger.m699d(str2, str);
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        String getKBSHostUrl = InfodeskHelper.INSTANCE.getGetKBSHostUrl();
        Logger.INSTANCE.m699d(str2, y.ٲٴݴ״ٰ(1782169408) + getKBSHostUrl);
        String str3 = getKBSHostUrl;
        if (str3 == null || str3.length() == 0) {
            return KGResult.INSTANCE.getResult(4001, y.ݬֲ֮ܲت(1512410663));
        }
        KGResult<String> pendingPurchases = INSTANCE.getPendingPurchases(getKBSHostUrl);
        Logger.INSTANCE.m699d(str2, y.ۮڭڭܬި(862505363) + pendingPurchases);
        if (pendingPurchases.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(pendingPurchases);
        }
        try {
            Object parse = JSONValue.parse(pendingPurchases.getContent());
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONArray");
            JSONArray jSONArray = (JSONArray) parse;
            ArrayList arrayList = new ArrayList();
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                Intrinsics.checkNotNull(jSONObject);
                arrayList.add(new KGService(jSONObject));
            }
            return KGResult.INSTANCE.getSuccessResult(arrayList);
        } catch (ParseException e) {
            e.printStackTrace();
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> getPendingPurchases(String gispPaymentUrl) {
        return requestOpenApi(gispPaymentUrl + y.دײܮڳܯ(2051384773), createCommonHeader(), createPendingPurchasesBody());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String createPendingPurchasesBody() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getAppId());
        linkedHashMap.put(y.ݬֲ֮ܲت(1512589743), CoreManager.INSTANCE.getInstance().getPlayerId());
        return JSONValue.toJSONString(linkedHashMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> completeOrder(String transactionID, String purchaseToken) {
        Intrinsics.checkNotNullParameter(transactionID, y.ٴسسݬߨ(1393339362));
        Intrinsics.checkNotNullParameter(purchaseToken, y.دײܮڳܯ(2051845477));
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051384901) + transactionID + y.ݬֲ֮ܲت(1513068719) + purchaseToken;
        String str2 = y.ٲٴݴ״ٰ(1782168488);
        logger.m699d(str2, str);
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        String getKBSHostUrl = InfodeskHelper.INSTANCE.getGetKBSHostUrl();
        Logger.INSTANCE.m699d(str2, y.ݮڮֲڭܩ(-628584068) + getKBSHostUrl);
        String str3 = getKBSHostUrl;
        if (str3 == null || str3.length() == 0) {
            return KGResult.INSTANCE.getResult(4001, y.ݬֲ֮ܲت(1512410663));
        }
        KGResult<String> consume = INSTANCE.consume(getKBSHostUrl, transactionID, purchaseToken);
        Logger.INSTANCE.m699d(str2, y.ٴسسݬߨ(1393337962) + consume);
        if (consume.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(consume);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> consume(String gispPaymentUrl, String transactionID, String purchaseToken) {
        return requestOpenApi(gispPaymentUrl + y.֬ڱܱײٮ(-1158874191), createCommonHeader(), createConsumeBody(transactionID, purchaseToken));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String createConsumeBody(String transactionID, String purchaseToken) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getAppId());
        linkedHashMap.put(y.ݬֲ֮ܲت(1512589743), CoreManager.INSTANCE.getInstance().getPlayerId());
        linkedHashMap.put(y.دײܮڳܯ(2051384829), transactionID);
        linkedHashMap.put(Settings.SERVER_PT, purchaseToken);
        return JSONValue.toJSONString(linkedHashMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, String> createCommonHeader() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.ۮڭڭܬި(862506555), CoreManager.INSTANCE.getInstance().getAppSecret());
        linkedHashMap.put(y.ݮڮֲڭܩ(-628583628), CoreManager.INSTANCE.getInstance().getAccessToken());
        return linkedHashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> requestOpenApi(String openApiUri, Map<String, String> header, String body) {
        if (header != null) {
            try {
                header.put("Content-Type", ServerConstants.CONTENT_TYPE_VALUE_JSON_UTF8);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782168488), e.toString(), e);
                return KGResult.INSTANCE.getResult(4001, e.toString());
            }
        }
        KeyBaseResult<Object> requestPOST = HttpService.requestPOST(openApiUri, header, body, HttpService.HttpContentType.STRING);
        return KGResult.INSTANCE.getResult(requestPOST).convertErrorCode(convertErrorCode(requestPOST.getCode()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int convertErrorCode(int code) {
        int i = 200;
        if (code != 200) {
            if (code == 470) {
                i = KGResult.KGResultCode.INVALID_SUB_ID;
            } else if (code == 500) {
                i = 2002;
            } else if (code == 400) {
                i = 4000;
            } else if (code != 401 && code != 460 && code != 461) {
                switch (code) {
                    case StoreResultCode.INVALID_TRANSACTION_ID /* 480 */:
                        i = KGResult.KGResultCode.INVALID_KEY_ID;
                        break;
                    case StoreResultCode.INVALID_PURCHASE_TOKEN /* 481 */:
                        i = KGResult.KGResultCode.INVALID_CODE;
                        break;
                    case StoreResultCode.INCOMPLETE_PAYMENT /* 482 */:
                        i = KGResult.KGResultCode.INCOMPLETE_ADDON_SERVICE;
                        break;
                    case 483:
                        i = KGResult.KGResultCode.ALREADY_COMPLETE_SERVICE;
                        break;
                    default:
                        i = code;
                        break;
                }
            } else {
                i = KGResult.KGResultCode.INVALID_AUTHORIZED;
            }
        }
        Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782168488), y.ٴسسݬߨ(1393336578) + code + y.ݮڮֲڭܩ(-628954020) + i);
        return i;
    }

    /* compiled from: AddOnManager.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/addon/AddOnManager$StoreResultCode;", "", "()V", "ALREADY_COMPLETE_ORDER", "", "AUTHENTICATION_FAILED_TOKEN", "INCOMPLETE_PAYMENT", "INVALID_APP_ID", "INVALID_ITEM_ID", "INVALID_PARAMETER", "INVALID_PLAYER_ID", "INVALID_PURCHASE_TOKEN", "INVALID_TRANSACTION_ID", "SERVER_ERROR", "SUCCESS", "kakaogame_addon_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private static final class StoreResultCode {
        public static final int ALREADY_COMPLETE_ORDER = 483;
        public static final int AUTHENTICATION_FAILED_TOKEN = 401;
        public static final int INCOMPLETE_PAYMENT = 482;
        public static final StoreResultCode INSTANCE = new StoreResultCode();
        public static final int INVALID_APP_ID = 460;
        public static final int INVALID_ITEM_ID = 470;
        public static final int INVALID_PARAMETER = 400;
        public static final int INVALID_PLAYER_ID = 461;
        public static final int INVALID_PURCHASE_TOKEN = 481;
        public static final int INVALID_TRANSACTION_ID = 480;
        public static final int SERVER_ERROR = 500;
        public static final int SUCCESS = 200;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private StoreResultCode() {
        }
    }

    /* compiled from: AddOnManager.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/addon/AddOnManager$Settings;", "", "()V", "SERVER_PT", "", "SERVER_TID", "endUri", "getListUri", "kakaogame_addon_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private static final class Settings {
        public static final Settings INSTANCE = new Settings();
        public static final String SERVER_PT = "pt";
        public static final String SERVER_TID = "tid";
        public static final String endUri = "/v2/client/end";
        public static final String getListUri = "/v2/client/getList";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }
    }
}
