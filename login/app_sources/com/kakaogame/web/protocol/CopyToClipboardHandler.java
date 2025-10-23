package com.kakaogame.web.protocol;

import android.net.Uri;
import android.webkit.WebView;
import com.liapp.y;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CopyToClipboardHandler.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/web/protocol/CopyToClipboardHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "()V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CopyToClipboardHandler extends WebAppProtocolHandler {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CopyToClipboardHandler() {
        super(y.ݮڮֲڭܩ(-628223236));
        setWebAppProtocolHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
    protected String handleInternal(WebView webView, Uri webUri) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CopyToClipboardHandler$handleInternal$1(webUri, webView, null), 3, null);
        return null;
    }
}
