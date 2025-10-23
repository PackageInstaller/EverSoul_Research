package com.kakaogame;

import android.app.Activity;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.kakao.KakaoGuildService;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoGuildChat.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J$\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J8\u0010\u000f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007JP\u0010\u0012\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00152\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007J$\u0010\u0016\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m839d2 = {"Lcom/kakaogame/KGKakaoGuildChat;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "initInterfaceBroker", "", "initialize", "openKakaoTalkChattingTab", "activity", "Landroid/app/Activity;", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "openKakaoTalkGuildChat", "worldId", "guildId", "sendGuildChatMessage", "templateId", "args", "", "showGuildChatAgreementView", "", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoGuildChat {
    private static final String CLASS_NAME_KEY = "KGKakaoGuildChat";
    public static final KGKakaoGuildChat INSTANCE = new KGKakaoGuildChat();
    private static final String TAG = "KGKakaoGuildChat";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoGuildChat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void openKakaoTalkChattingTab(Activity activity, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoGuildChat$openKakaoTalkChattingTab$1(activity, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void openKakaoTalkGuildChat(Activity activity, String worldId, String guildId, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoGuildChat$openKakaoTalkGuildChat$1(activity, worldId, guildId, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendGuildChatMessage(String worldId, String guildId, String templateId, Map<String, String> args, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoGuildChat$sendGuildChatMessage$1(worldId, guildId, templateId, args, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showGuildChatAgreementView(Activity activity, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoGuildChat$showGuildChatAgreementView$1(activity, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512596023), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoGuildChat$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGResult<Void> openKakaoTalkChattingTab = KakaoGuildService.openKakaoTalkChattingTab(activity);
                Intrinsics.checkNotNull(openKakaoTalkChattingTab);
                if (openKakaoTalkChattingTab.isSuccess()) {
                    return KGResult.INSTANCE.getSuccessResult();
                }
                return KGResult.INSTANCE.getResult(openKakaoTalkChattingTab);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512595631), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoGuildChat$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGResult<Void> openKakaoTalkGuildChat = KakaoGuildService.openKakaoTalkGuildChat(activity, (String) request.getParameter(y.ݬֲ֮ܲت(1512597455)), (String) request.getParameter(y.دײܮڳܯ(2051559149)));
                if (openKakaoTalkGuildChat.isSuccess()) {
                    return KGResult.INSTANCE.getSuccessResult();
                }
                return KGResult.INSTANCE.getResult(openKakaoTalkGuildChat);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575832222), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoGuildChat$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                KGResult<Void> sendMessage = KakaoGuildService.sendMessage((String) request.getParameter("worldId"), (String) request.getParameter(y.دײܮڳܯ(2051559149)), (String) request.getParameter(y.ۮڭڭܬި(862266835)), (Map) request.getParameter(y.ۮڭڭܬި(862266483)));
                Intrinsics.checkNotNull(sendMessage);
                if (sendMessage.isSuccess()) {
                    return KGResult.INSTANCE.getSuccessResult();
                }
                return KGResult.INSTANCE.getResult(sendMessage);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159652567), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoGuildChat$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGResult<Boolean> showGuildChatAgreementView = KakaoGuildService.showGuildChatAgreementView(activity);
                Intrinsics.checkNotNull(showGuildChatAgreementView);
                if (showGuildChatAgreementView.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(showGuildChatAgreementView);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݬֲ֮ܲت(1512597047), showGuildChatAgreementView.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }
}
