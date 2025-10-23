package com.kakaogame.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.web.protocol.WebAppProtocolHandler;
import com.liapp.y;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: WebAppHandlerManager.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/web/WebAppHandlerManager;", "", "()V", "handle", "", "webView", "Landroid/webkit/WebView;", "url", "", "callback", "Lcom/kakaogame/web/WebAppHandlerManager$WebAppHandlerCallback;", "Companion", "WebAppHandlerCallback", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class WebAppHandlerManager {
    private static final String SCHEME_DELIMITER = "://";
    private static final String TAG = "WebAppHandlerManager";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, WebAppProtocolHandler> webAppProtocolHandlerList = new HashMap();

    /* compiled from: WebAppHandlerManager.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/web/WebAppHandlerManager$WebAppHandlerCallback;", "", "onHandle", "", "result", "Lcom/kakaogame/KGResult;", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface WebAppHandlerCallback {
        void onHandle(KGResult<String> result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean handle(WebView webView, String url, WebAppHandlerCallback callback) {
        Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
        Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393227450) + url;
        String str2 = y.ۮڭڭܬި(862887187);
        logger.m699d(str2, str);
        if (webView == null || TextUtils.isEmpty(url)) {
            return false;
        }
        Uri parse = Uri.parse(url);
        String key = INSTANCE.getKey(parse.getScheme(), parse.getAuthority());
        WebAppProtocolHandler webAppProtocolHandler = webAppProtocolHandlerList.get(key);
        if (webAppProtocolHandler != null) {
            Logger.INSTANCE.m699d(str2, y.٬ݯح׭٩(576271110) + webAppProtocolHandler);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WebAppHandlerManager$handle$1(webAppProtocolHandler, webView, parse, callback, null), 3, null);
            return true;
        }
        Logger.INSTANCE.m699d(str2, y.٬ݯح׭٩(576271358) + key);
        return false;
    }

    /* compiled from: WebAppHandlerManager.kt */
    @Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J$\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/web/WebAppHandlerManager$Companion;", "", "()V", "SCHEME_DELIMITER", "", "TAG", "webAppProtocolHandlerList", "", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "getKey", "scheme", "authority", "removeWebAppProtocolHandler", "", "setWebAppProtocolHandler", "handler", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWebAppProtocolHandler(String scheme, String authority, WebAppProtocolHandler handler) {
            if (scheme == null) {
                throw new IllegalArgumentException("scheme is null".toString());
            }
            if (authority == null) {
                throw new IllegalArgumentException("authority is null".toString());
            }
            if (handler == null) {
                throw new IllegalArgumentException("handler is null".toString());
            }
            String key = getKey(scheme, authority);
            Logger.INSTANCE.m706v(y.ۮڭڭܬި(862887187), y.ݬֲ֮ܲت(1512300127) + key + ')');
            synchronized (WebAppHandlerManager.webAppProtocolHandlerList) {
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void removeWebAppProtocolHandler(String scheme, String authority) {
            if (scheme == null) {
                throw new IllegalArgumentException("scheme is null".toString());
            }
            if (authority == null) {
                throw new IllegalArgumentException("authority is null".toString());
            }
            String key = getKey(scheme, authority);
            Logger.INSTANCE.m706v(y.ۮڭڭܬި(862887187), y.֬ڱܱײٮ(-1159026199) + key + ')');
            synchronized (WebAppHandlerManager.webAppProtocolHandlerList) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getKey(String scheme, String authority) {
            String str = scheme + y.ݮڮֲڭܩ(-628270524) + authority;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, y.֬ڱܱײٮ(-1158775023));
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
    }
}
