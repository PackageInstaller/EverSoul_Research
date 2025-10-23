package com.kakao.sdk.talk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.network.ApiCallback;
import com.kakao.sdk.talk.TalkApi;
import com.kakao.sdk.talk.model.Channels;
import com.kakao.sdk.talk.model.Friend;
import com.kakao.sdk.talk.model.FriendOrder;
import com.kakao.sdk.talk.model.Friends;
import com.kakao.sdk.talk.model.FriendsContext;
import com.kakao.sdk.talk.model.MessageSendResult;
import com.kakao.sdk.talk.model.Order;
import com.kakao.sdk.talk.model.TalkProfile;
import com.kakao.sdk.template.model.DefaultTemplate;
import com.kakao.sdk.user.UserApiClient;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TalkApiClient.kt */
@Metadata(m838d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u0001:\u0001HB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ;\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007JV\u0010\u001e\u001a\u00020\f2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010 2:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0!H\u0007J;\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010JR\u0010&\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010'2@\u0010\u0011\u001a<\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020)\u0018\u00010(¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0!J\u007f\u0010&\u001a\u00020\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002@\u0010\u0011\u001a<\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020)\u0018\u00010(¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0!H\u0007¢\u0006\u0002\u00101JB\u00102\u001a\u00020\f2:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0!JM\u00104\u001a\u00020\f2\u0006\u00105\u001a\u0002062\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001082#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012H\u0007Jr\u00109\u001a\u00020\f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100 2\u0006\u00105\u001a\u0002062\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001082:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0!H\u0007J3\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020?2#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012JX\u0010@\u001a\u00020\f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100 2\u0006\u0010>\u001a\u00020?2:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0!J^\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u00102\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001082#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012H\u0007¢\u0006\u0002\u0010CJ\u0083\u0001\u0010D\u001a\u00020\f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100 2\u0006\u0010B\u001a\u00020\u00102\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001082:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0!H\u0007¢\u0006\u0002\u0010EJ=\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, m839d2 = {"Lcom/kakao/sdk/talk/TalkApiClient;", "", "talkApi", "Lcom/kakao/sdk/talk/TalkApi;", "appKeyTalkApi", "Lcom/kakao/sdk/talk/AppKeyTalkApi;", "applicationInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "(Lcom/kakao/sdk/talk/TalkApi;Lcom/kakao/sdk/talk/AppKeyTalkApi;Lcom/kakao/sdk/common/model/ApplicationInfo;Lcom/kakao/sdk/common/model/ContextInfo;)V", "addChannel", "", "context", "Landroid/content/Context;", "channelPublicId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "error", "addChannelUrl", "Landroid/net/Uri;", "baseUri", "Landroid/net/Uri$Builder;", "appKey", "kaHeader", "channelChatUrl", Constants.CHANNELS, "publicIds", "", "Lkotlin/Function2;", "Lcom/kakao/sdk/talk/model/Channels;", "relations", "chatChannel", "chatChannelUrl", NativeProtocol.AUDIENCE_FRIENDS, "Lcom/kakao/sdk/talk/model/FriendsContext;", "Lcom/kakao/sdk/talk/model/Friends;", "Lcom/kakao/sdk/talk/model/Friend;", "offset", "", "limit", Constants.ORDER, "Lcom/kakao/sdk/talk/model/Order;", "friendOrder", "Lcom/kakao/sdk/talk/model/FriendOrder;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Lcom/kakao/sdk/talk/model/FriendOrder;Lkotlin/jvm/functions/Function2;)V", "profile", "Lcom/kakao/sdk/talk/model/TalkProfile;", "sendCustomMemo", "templateId", "", "templateArgs", "", "sendCustomMessage", "receiverUuids", "Lcom/kakao/sdk/talk/model/MessageSendResult;", "result", "sendDefaultMemo", SDKConstants.PARAM_UPDATE_TEMPLATE, "Lcom/kakao/sdk/template/model/DefaultTemplate;", "sendDefaultMessage", "sendScrapMemo", "requestUrl", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "sendScrapMessage", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "validate", Base2ndPWViewData.KEY_PATH, "Companion", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TalkApiClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<TalkApiClient> instance$delegate = LazyKt.lazy(new Function0<TalkApiClient>() { // from class: com.kakao.sdk.talk.TalkApiClient$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final TalkApiClient invoke() {
            return new TalkApiClient(null, null, null, null, 15, null);
        }
    });
    private final AppKeyTalkApi appKeyTalkApi;
    private final ApplicationInfo applicationInfo;
    private final ContextInfo contextInfo;
    private final TalkApi talkApi;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TalkApiClient() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final TalkApiClient getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void channels(Function2<? super Channels, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        channels$default(this, null, callback, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void friends(Integer num, Integer num2, Order order, Function2<? super Friends<Friend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        friends$default(this, num, num2, order, null, callback, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void friends(Integer num, Integer num2, Function2<? super Friends<Friend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        friends$default(this, num, num2, null, null, callback, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void friends(Integer num, Function2<? super Friends<Friend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        friends$default(this, num, null, null, null, callback, 14, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void friends(Function2<? super Friends<Friend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        friends$default(this, null, null, null, null, callback, 15, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendCustomMemo(long j, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendCustomMemo$default(this, j, null, callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendCustomMessage(List<String> receiverUuids, long j, Function2<? super MessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendCustomMessage$default(this, receiverUuids, j, null, callback, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendScrapMemo(String requestUrl, Long l, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendScrapMemo$default(this, requestUrl, l, null, callback, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendScrapMemo(String requestUrl, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendScrapMemo$default(this, requestUrl, null, null, callback, 6, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendScrapMessage(List<String> receiverUuids, String requestUrl, Long l, Function2<? super MessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendScrapMessage$default(this, receiverUuids, requestUrl, l, null, callback, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendScrapMessage(List<String> receiverUuids, String requestUrl, Function2<? super MessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendScrapMessage$default(this, receiverUuids, requestUrl, null, null, callback, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TalkApiClient(TalkApi talkApi, AppKeyTalkApi appKeyTalkApi, ApplicationInfo applicationInfo, ContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(talkApi, "talkApi");
        Intrinsics.checkNotNullParameter(appKeyTalkApi, "appKeyTalkApi");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        this.talkApi = talkApi;
        this.appKeyTalkApi = appKeyTalkApi;
        this.applicationInfo = applicationInfo;
        this.contextInfo = contextInfo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ TalkApiClient(com.kakao.sdk.talk.TalkApi r1, com.kakao.sdk.talk.AppKeyTalkApi r2, com.kakao.sdk.common.model.ApplicationContextInfo r3, com.kakao.sdk.common.model.ApplicationContextInfo r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L17
            com.kakao.sdk.network.ApiFactory r1 = com.kakao.sdk.network.ApiFactory.INSTANCE
            retrofit2.Retrofit r1 = com.kakao.sdk.auth.network.ApiFactoryKt.getKapiWithOAuth(r1)
            java.lang.Class<com.kakao.sdk.talk.TalkApi> r6 = com.kakao.sdk.talk.TalkApi.class
            java.lang.Object r1 = r1.create(r6)
            java.lang.String r6 = "ApiFactory.kapiWithOAuth…eate(TalkApi::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            com.kakao.sdk.talk.TalkApi r1 = (com.kakao.sdk.talk.TalkApi) r1
        L17:
            r6 = r5 & 2
            if (r6 == 0) goto L2e
            com.kakao.sdk.network.ApiFactory r2 = com.kakao.sdk.network.ApiFactory.INSTANCE
            retrofit2.Retrofit r2 = r2.getKapi()
            java.lang.Class<com.kakao.sdk.talk.AppKeyTalkApi> r6 = com.kakao.sdk.talk.AppKeyTalkApi.class
            java.lang.Object r2 = r2.create(r6)
            java.lang.String r6 = "ApiFactory.kapi.create(AppKeyTalkApi::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            com.kakao.sdk.talk.AppKeyTalkApi r2 = (com.kakao.sdk.talk.AppKeyTalkApi) r2
        L2e:
            r6 = r5 & 4
            if (r6 == 0) goto L3a
            com.kakao.sdk.common.KakaoSdk r3 = com.kakao.sdk.common.KakaoSdk.INSTANCE
            com.kakao.sdk.common.model.ApplicationContextInfo r3 = r3.getApplicationContextInfo()
            com.kakao.sdk.common.model.ApplicationInfo r3 = (com.kakao.sdk.common.model.ApplicationInfo) r3
        L3a:
            r5 = r5 & 8
            if (r5 == 0) goto L46
            com.kakao.sdk.common.KakaoSdk r4 = com.kakao.sdk.common.KakaoSdk.INSTANCE
            com.kakao.sdk.common.model.ApplicationContextInfo r4 = r4.getApplicationContextInfo()
            com.kakao.sdk.common.model.ContextInfo r4 = (com.kakao.sdk.common.model.ContextInfo) r4
        L46:
            r0.<init>(r1, r2, r3, r4)
            return
            fill-array 0x004a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.talk.TalkApiClient.<init>(com.kakao.sdk.talk.TalkApi, com.kakao.sdk.talk.AppKeyTalkApi, com.kakao.sdk.common.model.ApplicationInfo, com.kakao.sdk.common.model.ContextInfo, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void profile(final Function2<? super TalkProfile, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.profile().enqueue(new ApiCallback<TalkProfile>() { // from class: com.kakao.sdk.talk.TalkApiClient$profile$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(TalkProfile model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void friends$default(TalkApiClient talkApiClient, Integer num, Integer num2, Order order, FriendOrder friendOrder, Function2 function2, int i, Object obj) {
        talkApiClient.friends((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : order, (i & 8) != 0 ? null : friendOrder, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void friends(Integer offset, Integer limit, Order order, FriendOrder friendOrder, final Function2<? super Friends<Friend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.friends(offset, limit, order, friendOrder).enqueue(new ApiCallback<Friends<Friend>>() { // from class: com.kakao.sdk.talk.TalkApiClient$friends$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Friends<Friend> model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void friends(FriendsContext context, final Function2<? super Friends<Friend>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.friends(context == null ? null : context.getOffset(), context == null ? null : context.getLimit(), context == null ? null : context.getOrder(), context != null ? context.getFriendOrder() : null).enqueue(new ApiCallback<Friends<Friend>>() { // from class: com.kakao.sdk.talk.TalkApiClient$friends$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Friends<Friend> model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void sendCustomMemo$default(TalkApiClient talkApiClient, long j, Map map, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        talkApiClient.sendCustomMemo(j, map, function1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendCustomMemo(long templateId, Map<String, String> templateArgs, final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.sendCustomMemo(templateId, templateArgs).enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.talk.TalkApiClient$sendCustomMemo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Unit model, Throwable error) {
                callback.invoke(error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendDefaultMemo(DefaultTemplate template, final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.sendDefaultMemo(template).enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.talk.TalkApiClient$sendDefaultMemo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Unit model, Throwable error) {
                callback.invoke(error);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void sendScrapMemo$default(TalkApiClient talkApiClient, String str, Long l, Map map, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        talkApiClient.sendScrapMemo(str, l, map, function1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendScrapMemo(String requestUrl, Long templateId, Map<String, String> templateArgs, final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.sendScrapMemo(requestUrl, templateId, templateArgs).enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.talk.TalkApiClient$sendScrapMemo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Unit model, Throwable error) {
                callback.invoke(error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void sendCustomMessage$default(TalkApiClient talkApiClient, List list, long j, Map map, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        talkApiClient.sendCustomMessage(list, j, map, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendCustomMessage(List<String> receiverUuids, long templateId, Map<String, String> templateArgs, final Function2<? super MessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.sendCustomMessage(KakaoJson.INSTANCE.toJson(receiverUuids), templateId, templateArgs).enqueue(new ApiCallback<MessageSendResult>() { // from class: com.kakao.sdk.talk.TalkApiClient$sendCustomMessage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(MessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendDefaultMessage(List<String> receiverUuids, DefaultTemplate template, final Function2<? super MessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.sendDefaultMessage(KakaoJson.INSTANCE.toJson(receiverUuids), template).enqueue(new ApiCallback<MessageSendResult>() { // from class: com.kakao.sdk.talk.TalkApiClient$sendDefaultMessage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(MessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void sendScrapMessage$default(TalkApiClient talkApiClient, List list, String str, Long l, Map map, Function2 function2, int i, Object obj) {
        talkApiClient.sendScrapMessage(list, str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : map, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendScrapMessage(List<String> receiverUuids, String requestUrl, Long templateId, Map<String, String> templateArgs, final Function2<? super MessageSendResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(receiverUuids, "receiverUuids");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.talkApi.sendScrapMessage(KakaoJson.INSTANCE.toJson(receiverUuids), requestUrl, templateId, templateArgs).enqueue(new ApiCallback<MessageSendResult>() { // from class: com.kakao.sdk.talk.TalkApiClient$sendScrapMessage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(MessageSendResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void channels$default(TalkApiClient talkApiClient, List list, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        talkApiClient.channels(list, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void channels(List<String> publicIds, final Function2<? super Channels, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TalkApi.DefaultImpls.channels$default(this.talkApi, publicIds == null ? null : CollectionsKt.joinToString$default(publicIds, ",", null, null, 0, null, null, 62, null), null, 2, null).enqueue(new ApiCallback<Channels>() { // from class: com.kakao.sdk.talk.TalkApiClient$channels$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Channels model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addChannel(final Context context, final String channelPublicId, final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelPublicId, "channelPublicId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ClientError clientError = new ClientError(ClientErrorCause.NotSupported, "KakaoTalk is not installed");
        if (!UserApiClient.INSTANCE.getInstance().isKakaoTalkLoginAvailable(context)) {
            SdkLog.INSTANCE.m470e(clientError);
            callback.invoke(clientError);
        } else {
            validate(Constants.VALIDATE_ADD, channelPublicId, new Function1<Throwable, Unit>() { // from class: com.kakao.sdk.talk.TalkApiClient$addChannel$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(1);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (th != null) {
                        callback.invoke(th);
                        return;
                    }
                    try {
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("kakaoplus://plusfriend/home/" + channelPublicId + "/add")));
                    } catch (ActivityNotFoundException unused) {
                        SdkLog.INSTANCE.m470e(clientError);
                        callback.invoke(clientError);
                    }
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void chatChannel(final Context context, final String channelPublicId, final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelPublicId, "channelPublicId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ClientError clientError = new ClientError(ClientErrorCause.NotSupported, "KakaoTalk is not installed");
        if (!UserApiClient.INSTANCE.getInstance().isKakaoTalkLoginAvailable(context)) {
            SdkLog.INSTANCE.m470e(clientError);
            callback.invoke(clientError);
        } else {
            validate(Constants.VALIDATE_CHAT, channelPublicId, new Function1<Throwable, Unit>() { // from class: com.kakao.sdk.talk.TalkApiClient$chatChannel$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(1);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (th != null) {
                        callback.invoke(th);
                        return;
                    }
                    try {
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Intrinsics.stringPlus("kakaoplus://plusfriend//talk/chat/", channelPublicId))));
                    } catch (ActivityNotFoundException unused) {
                        SdkLog.INSTANCE.m470e(clientError);
                        callback.invoke(clientError);
                    }
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri addChannelUrl(String channelPublicId) {
        Intrinsics.checkNotNullParameter(channelPublicId, "channelPublicId");
        Uri build = baseUri(this.applicationInfo.getAppKey(), this.contextInfo.getKaHeader()).path(Intrinsics.stringPlus(channelPublicId, "/friend")).build();
        Intrinsics.checkNotNullExpressionValue(build, "baseUri(appKey = applica…nstants.FRIEND}\").build()");
        return build;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri chatChannelUrl(String channelPublicId) {
        Intrinsics.checkNotNullParameter(channelPublicId, "channelPublicId");
        Uri build = baseUri(this.applicationInfo.getAppKey(), this.contextInfo.getKaHeader()).path(Intrinsics.stringPlus(channelPublicId, "/chat")).build();
        Intrinsics.checkNotNullExpressionValue(build, "baseUri(appKey = applica…Constants.CHAT}\").build()");
        return build;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "chatChannelUrl()로 대체되었습니다", replaceWith = @ReplaceWith(expression = "chatChannelUrl(channelPublicId)", imports = {}))
    public final Uri channelChatUrl(String channelPublicId) {
        Intrinsics.checkNotNullParameter(channelPublicId, "channelPublicId");
        return chatChannelUrl(channelPublicId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Uri.Builder baseUri(String appKey, String kaHeader) {
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority(KakaoSdk.INSTANCE.getHosts().getChannel()).appendQueryParameter("app_key", appKey).appendQueryParameter(Constants.KAKAO_AGENT, kaHeader).appendQueryParameter(Constants.API_VER, "1.0");
        Intrinsics.checkNotNullExpressionValue(appendQueryParameter, "Builder().scheme(com.kak…ER, Constants.API_VER_10)");
        return appendQueryParameter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void validate(String path, String channelPublicId, final Function1<? super Throwable, Unit> callback) {
        this.appKeyTalkApi.validate(MapsKt.mapOf(TuplesKt.m846to("uri", path), TuplesKt.m846to("channel_public_id", channelPublicId))).enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.talk.TalkApiClient$validate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Unit model, Throwable error) {
                Function1<Throwable, Unit> function1 = callback;
                if (error == null) {
                    error = null;
                }
                function1.invoke(error);
            }
        });
    }

    /* compiled from: TalkApiClient.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m839d2 = {"Lcom/kakao/sdk/talk/TalkApiClient$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/talk/TalkApiClient;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/talk/TalkApiClient;", "instance$delegate", "Lkotlin/Lazy;", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final TalkApiClient getInstance() {
            return (TalkApiClient) TalkApiClient.instance$delegate.getValue();
        }
    }
}
