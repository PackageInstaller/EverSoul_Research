package com.kakaogame.web.protocol;

import android.net.Uri;
import android.webkit.WebView;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.player.PlayerService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetAdAgreementHandler.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/web/protocol/GetAdAgreementHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "()V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "makeResponseString", "code", "", "enable", "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class GetAdAgreementHandler extends WebAppProtocolHandler {
    private static final String TAG = "GetAdAgreementHandler";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GetAdAgreementHandler() {
        super(y.ٴسسݬߨ(1393522026));
        setWebAppProtocolHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
    protected String handleInternal(WebView webView, Uri webUri) {
        boolean z;
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393522026);
        String str2 = y.دײܮڳܯ(2051220077);
        logger.m699d(str2, str);
        try {
            KGResult<Boolean> adAgreement = PlayerService.getAdAgreement();
            if (adAgreement.isSuccess()) {
                Boolean content = adAgreement.getContent();
                Intrinsics.checkNotNull(content);
                z = content.booleanValue();
            } else {
                z = false;
            }
            String makeResponseString = makeResponseString(adAgreement.getCode(), z);
            Logger.INSTANCE.m699d(str2, "getAdAgreement: " + makeResponseString);
            return makeResponseString;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return makeResponseString(4001, false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String makeResponseString(int code, boolean enable) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put(y.دײܮڳܯ(2051571757), Integer.valueOf(code));
        if (code == 200) {
            jSONObject2.put("enable", Boolean.valueOf(enable));
        }
        return jSONObject.toJSONString();
    }
}
