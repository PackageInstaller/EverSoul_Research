package com.kakaogame.p029ui;

import android.app.Activity;
import android.net.Uri;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeepLinkManager.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\f\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u0004J\f\u0010\r\u001a\u00020\f*\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/ui/DeepLinkManager;", "", "()V", "DEEP_LINK_SCHEME", "", "TAG", "handlePlatformDeepLink", "Lcom/kakaogame/KGResult;", "activity", "Landroid/app/Activity;", "url", "isDeepLink", "", "isPlatformDeepLink", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DeepLinkManager {
    private static final String DEEP_LINK_SCHEME = "kakaogamelink://";
    public static final DeepLinkManager INSTANCE = new DeepLinkManager();
    private static final String TAG = "DeepLinkManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DeepLinkManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPlatformDeepLink(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String str3 = parse.getScheme() + y.ݮڮֲڭܩ(-628270524) + parse.getAuthority();
        boolean hasBroker = InterfaceBrokerHandler.hasBroker(str3);
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628270772), y.ݬֲ֮ܲت(1512064423) + str3 + y.ݮڮֲڭܩ(-628756788) + hasBroker);
        return hasBroker;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isDeepLink(String str) {
        String str2 = y.ݮڮֲڭܩ(-628270772);
        String str3 = y.دײܮڳܯ(2051043285);
        String str4 = str;
        if (str4 == null || str4.length() == 0) {
            return false;
        }
        try {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            boolean startsWith$default = StringsKt.startsWith$default(lowerCase, DEEP_LINK_SCHEME, false, 2, (Object) null);
            Logger.INSTANCE.m699d(str2, str3 + lowerCase + " : " + startsWith$default);
            return startsWith$default;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> handlePlatformDeepLink(Activity activity, String url) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159122575) + url;
        String str2 = y.ݮڮֲڭܩ(-628270772);
        logger.m699d(str2, str);
        try {
            Uri parse = Uri.parse(url);
            String str3 = parse.getScheme() + "://" + parse.getAuthority();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str4 : parse.getQueryParameterNames()) {
                Intrinsics.checkNotNull(str4);
                linkedHashMap.put(str4, parse.getQueryParameter(str4));
            }
            KGResult<?> requestWithUrl = InterfaceBrokerHandler.requestWithUrl(activity, str3, linkedHashMap);
            Logger.INSTANCE.m704i(str2, "InterfaceBrokerHandler.requestWithUrl: " + requestWithUrl);
            if (requestWithUrl.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(requestWithUrl);
            }
            Object content = requestWithUrl.getContent();
            if (content instanceof String) {
                return KGResult.INSTANCE.getSuccessResult(content);
            }
            return KGResult.INSTANCE.getSuccessResult("");
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }
}
