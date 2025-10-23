package com.kakaogame.web.protocol;

import android.net.Uri;
import android.webkit.WebView;
import com.facebook.internal.ServerProtocol;
import com.kakaogame.Logger;
import com.kakaogame.player.PlayerService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SetAdAgreementHandler.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/web/protocol/SetAdAgreementHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "()V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "makeResponseString", "code", "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SetAdAgreementHandler extends WebAppProtocolHandler {
    private static final String TAG = "SetAdAgreementHandler";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SetAdAgreementHandler() {
        super(y.ۮڭڭܬި(862502859));
        setWebAppProtocolHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
    protected String handleInternal(WebView webView, Uri webUri) {
        Intrinsics.checkNotNull(webUri);
        String queryParameter = webUri.getQueryParameter(y.ٲٴݴ״ٰ(1781966448));
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862502859) + queryParameter;
        String str2 = y.ݮڮֲڭܩ(-628222276);
        logger.m699d(str2, str);
        try {
            String makeResponseString = makeResponseString(PlayerService.setAdAgreement(StringsKt.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, queryParameter, true)).getCode());
            Logger.INSTANCE.m699d(str2, "setAdAgreement: " + makeResponseString);
            return makeResponseString;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return makeResponseString(4001);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String makeResponseString(int code) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(y.دײܮڳܯ(2051571757), Integer.valueOf(code));
        return jSONObject.toJSONString();
    }
}
