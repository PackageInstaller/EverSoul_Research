package com.kakaogame.web.protocol;

import android.net.Uri;
import android.webkit.WebView;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.web.WebAppHandlerManager;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebAppProtocolHandler.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH$J\b\u0010\u000e\u001a\u00020\u000fH\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "", "authority", "", "(Ljava/lang/String;)V", "getAuthority", "()Ljava/lang/String;", "handle", "Lcom/kakaogame/KGResult;", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "handleInternal", "setWebAppProtocolHandler", "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public abstract class WebAppProtocolHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SCHEME = y.٬ݯح׭٩(576322374);
    private static final String TAG = "WebAppProtocolHandler";
    private final String authority;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static final String getSCHEME() {
        return INSTANCE.getSCHEME();
    }

    protected abstract String handleInternal(WebView webView, Uri webUri);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected WebAppProtocolHandler(String str) {
        this.authority = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final String getAuthority() {
        return this.authority;
    }

    /* compiled from: WebAppProtocolHandler.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0004X\u0085D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/web/protocol/WebAppProtocolHandler$Companion;", "", "()V", "SCHEME", "", "getSCHEME$annotations", "getSCHEME", "()Ljava/lang/String;", "TAG", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        protected static /* synthetic */ void getSCHEME$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected final String getSCHEME() {
            return WebAppProtocolHandler.SCHEME;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        new CopyToClipboardHandler();
        new ShareLinkHandler();
        new ExecuteUriHandler();
        new RequestUriHandler();
        new CachedRequestUriHandler();
        new InvitationLinkShareHandler();
        new GetAdAgreementHandler();
        new SetAdAgreementHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> handle(WebView webView, Uri webUri) {
        String str;
        String str2 = y.ݮڮֲڭܩ(-628225028);
        String str3 = y.ٲٴݴ״ٰ(1782523760);
        String str4 = y.֬ڱܱײٮ(-1159044047);
        Intrinsics.checkNotNullParameter(webUri, y.ݬֲ֮ܲت(1512248047));
        try {
            String handleInternal = handleInternal(webView, webUri);
            String queryParameter = webUri.getQueryParameter("callback");
            if (queryParameter != null) {
                StringBuilder sb = new StringBuilder(str4);
                sb.append(queryParameter);
                sb.append("(");
                if (handleInternal != null) {
                    sb.append(handleInternal);
                }
                sb.append(")");
                str = sb.toString();
            } else {
                Logger.INSTANCE.m699d(str2, "callback function is not exist");
                str = null;
            }
            Logger.INSTANCE.m699d(str2, str3 + str);
            return KGResult.INSTANCE.getSuccessResult(str);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setWebAppProtocolHandler() {
        WebAppHandlerManager.INSTANCE.setWebAppProtocolHandler(SCHEME, this.authority, this);
    }
}
