package com.kakaogame.web.protocol;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.kakaogame.Logger;
import com.kakaogame.log.KGSelectorReceiver;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareLinkHandler.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/web/protocol/ShareLinkHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "()V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ShareLinkHandler extends WebAppProtocolHandler {
    private static final String TAG = "ShareLinkHandler";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShareLinkHandler() {
        super(y.ۮڭڭܬި(862644331));
        setWebAppProtocolHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
    protected String handleInternal(WebView webView, Uri webUri) {
        Intrinsics.checkNotNull(webUri);
        String queryParameter = webUri.getQueryParameter(y.ݮڮֲڭܩ(-628442580));
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051227261), y.دײܮڳܯ(2051219925) + queryParameter);
        Intent intent = new Intent();
        intent.setAction(y.ݬֲ֮ܲت(1512249095));
        intent.putExtra(y.֬ڱܱײٮ(-1159045055), queryParameter);
        intent.setType("text/plain");
        Intrinsics.checkNotNull(webView);
        webView.getContext().startActivity(Intent.createChooser(intent, ResourceUtil.getString(webView.getContext(), y.ݬֲ֮ܲت(1512248783)), PendingIntent.getBroadcast(webView.getContext(), 1, new Intent(webView.getContext(), (Class<?>) KGSelectorReceiver.class), 201326592).getIntentSender()));
        return null;
    }
}
