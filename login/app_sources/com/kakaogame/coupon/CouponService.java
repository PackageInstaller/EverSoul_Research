package com.kakaogame.coupon;

import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CouponService.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/coupon/CouponService;", "", "()V", "TAG", "", "useCoupon", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "couponCode", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CouponService {
    public static final CouponService INSTANCE = new CouponService();
    private static final String TAG = "CouponService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CouponService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> useCoupon(String couponCode) {
        KGResult<Void> successResult;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getUseForAppUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("couponCode", couponCode);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                successResult = KGResult.INSTANCE.getResult(requestServer$default);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1158861991), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: CouponService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/coupon/CouponService$Settings;", "", "()V", "useForAppUri", "", "getUseForAppUri", "()Ljava/lang/String;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static final String useForAppUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782082536), y.ٴسسݬߨ(1393391026));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getUseForAppUri() {
            return useForAppUri;
        }
    }
}
