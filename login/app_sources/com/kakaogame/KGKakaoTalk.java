package com.kakaogame;

import android.app.Activity;
import android.text.TextUtils;
import com.facebook.share.internal.ShareInternalUtility;
import com.kakao.sdk.user.UserApiClient;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.kakao.KakaoGameAPI;
import com.kakaogame.kakao.KakaoManager;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.server.InhouseGWService;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoTalk.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\"\u0010\n\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0006\u0010\u0013\u001a\u00020\u000fJ\u001a\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J$\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\u0006\u0010\t¨\u0006\u0017"}, m839d2 = {"Lcom/kakaogame/KGKakaoTalk;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "isKakaoTalkInstalled", "", "isKakaoTalkInstalled$annotations", "()Z", "addPlusFriend", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "plusFriendId", "", "", "callback", "Lcom/kakaogame/KGResultCallback;", "initInterfaceBroker", "initialize", "uploadGameImage", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoTalk {
    private static final String CLASS_NAME_KEY = "KGKakaoTalk";
    public static final KGKakaoTalk INSTANCE = new KGKakaoTalk();
    private static final String TAG = "KGKakaoTalk";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isKakaoTalkInstalled$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoTalk() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void addPlusFriend(int plusFriendId, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575741302) + plusFriendId;
        String str2 = y.دײܮڳܯ(2051785029);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ۮڭڭܬި(862367979));
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalk$addPlusFriend$1(plusFriendId, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void uploadGameImage(File file, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159558431) + (file != null ? file.getName() : y.ݮڮֲڭܩ(-628841308));
        String str2 = y.دײܮڳܯ(2051785029);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.دײܮڳܯ(2051789557));
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalk$uploadGameImage$1(file, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isKakaoTalkInstalled() {
        if (KGKakao2Auth.INSTANCE.initializeKakaoSdk(CoreManager.INSTANCE.getInstance().getContext())) {
            return UserApiClient.INSTANCE.getInstance().isKakaoTalkLoginAvailable(CoreManager.INSTANCE.getInstance().getContext());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> addPlusFriend(int plusFriendId) {
        KGResult<Void> result;
        String name;
        KGIdpProfile idpProfile;
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Kakao;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (kGIdpCode != ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
            return KGResult.INSTANCE.getResult(5001, y.دײܮڳܯ(2051792293));
        }
        if (!KakaoManager.isTalkUser()) {
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_KAKAOTALK_USER, y.ۮڭڭܬި(862270011));
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1159559855));
        try {
            try {
                if (CoreManager.INSTANCE.getInstance().isKakaoCacheMode()) {
                    CoreManager.INSTANCE.getInstance().tryKakaoReConnect();
                }
                KGResult<Void> addPlusFriend = InhouseGWService.addPlusFriend(plusFriendId);
                if (addPlusFriend.isNotSuccess()) {
                    result = KGResult.INSTANCE.getResult(addPlusFriend);
                } else {
                    result = KGResult.INSTANCE.getSuccessResult();
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e("KGKakaoTalk", e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> uploadGameImage(File file) {
        KGResult<String> result;
        String name;
        KGResult<String> requestGameImageUpload;
        Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1159558199));
        try {
            try {
                if (CoreManager.INSTANCE.getInstance().isKakaoCacheMode()) {
                    CoreManager.INSTANCE.getInstance().tryKakaoReConnect();
                }
                requestGameImageUpload = KakaoGameAPI.requestGameImageUpload(file);
            } catch (Exception e) {
                Logger.INSTANCE.m702e("KGKakaoTalk", e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (requestGameImageUpload.isNotSuccess()) {
                KGResult<String> result2 = KGResult.INSTANCE.getResult(requestGameImageUpload);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            }
            result = KGResult.INSTANCE.getSuccessResult(requestGameImageUpload.getContent());
            start.stop();
            name = start.getName();
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512828943), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalk$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> addPlusFriend;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Number number = (Number) request.getParameter("plusFriendId");
                Intrinsics.checkNotNull(number);
                addPlusFriend = KGKakaoTalk.INSTANCE.addPlusFriend(number.intValue());
                FirebaseEvent.INSTANCE.sendEvent(y.دײܮڳܯ(2051785029), y.ݬֲ֮ܲت(1512826887), addPlusFriend);
                if (addPlusFriend.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(addPlusFriend);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862371243), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalk$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> uploadGameImage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("image");
                Logger logger = Logger.INSTANCE;
                String str2 = y.ݮڮֲڭܩ(-628692924) + str;
                String str3 = y.دײܮڳܯ(2051785029);
                logger.m699d(str3, str2);
                if (TextUtils.isEmpty(str)) {
                    return KGResult.INSTANCE.getResult(9999, y.֬ڱܱײٮ(-1159560895) + str);
                }
                File file = new File(str);
                Logger.INSTANCE.m706v(str3, y.ٲٴݴ״ٰ(1782039088) + file);
                uploadGameImage = KGKakaoTalk.INSTANCE.uploadGameImage(file);
                FirebaseEvent.INSTANCE.sendEvent(str3, y.֬ڱܱײٮ(-1159561127), uploadGameImage);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ۮڭڭܬި(862368987), uploadGameImage.getContent());
                if (uploadGameImage.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(uploadGameImage);
                }
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862370947), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalk$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                boolean isKakaoTalkInstalled = KGKakaoTalk.isKakaoTalkInstalled();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݬֲ֮ܲت(1512830375), Boolean.valueOf(isKakaoTalkInstalled));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }
}
