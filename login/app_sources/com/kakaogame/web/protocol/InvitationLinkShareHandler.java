package com.kakaogame.web.protocol;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebView;
import com.kakaogame.KGResult;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.ChannelConnectHelper;
import com.kakaogame.log.service.BasicLogService;
import com.kakaogame.promotion.PromotionService;
import com.kakaogame.promotion.SNSShareData;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvitationLinkShareHandler.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/web/protocol/InvitationLinkShareHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "()V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InvitationLinkShareHandler extends WebAppProtocolHandler {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvitationLinkShareHandler() {
        super(y.٬ݯح׭٩(576316646));
        setWebAppProtocolHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
    protected String handleInternal(WebView webView, Uri webUri) {
        Intrinsics.checkNotNull(webUri);
        webUri.getQueryParameter("channel");
        Activity activity = CoreManager.INSTANCE.getInstance().getActivity();
        SNSShareData snsShareData = CoreManager.INSTANCE.getInstance().getSnsShareData();
        Intrinsics.checkNotNull(snsShareData);
        SNSShareData.ShareInfo shareData = snsShareData.getShareData(SNSShareData.SNSShareType.linkInvite);
        if (shareData == null) {
            return KGResult.INSTANCE.getResult(4002).toJSONString();
        }
        long seq = snsShareData.getSeq();
        String linkUrl = shareData.getLinkUrl();
        String firstHashtag = shareData.getFirstHashtag();
        Activity activity2 = activity;
        BasicLogService.writeBasicActionLog(activity2, y.٬ݯح׭٩(575673646), y.֬ڱܱײٮ(-1159491839), y.ٴسسݬߨ(1393172770), y.ݬֲ֮ܲت(1512765831), null, null, null);
        Intrinsics.checkNotNull(linkUrl);
        KGResult<Void> facebookShareLink = ChannelConnectHelper.facebookShareLink(activity, linkUrl, firstHashtag);
        if (facebookShareLink.isSuccess()) {
            KGResult<Void> sendRequestSNSShareReward = PromotionService.sendRequestSNSShareReward(seq, SNSShareData.SNSShareType.linkInvite, null);
            if (sendRequestSNSShareReward.isSuccess()) {
                BasicLogService.writeBasicActionLog(activity2, y.٬ݯح׭٩(575673646), y.֬ڱܱײٮ(-1159492431), y.ٴسسݬߨ(1393172770), y.ݬֲ֮ܲت(1512765831), null, null, null);
            } else {
                return sendRequestSNSShareReward.toJSONString();
            }
        }
        return facebookShareLink.toJSONString();
    }
}
