package com.kakaogame.log.service;

import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayerSDKLogService.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/log/service/PlayerSDKLogService;", "", "()V", "TAG", "", "writePlayerSDKLog", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "logBody", "", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PlayerSDKLogService {
    public static final PlayerSDKLogService INSTANCE = new PlayerSDKLogService();
    private static final String TAG = "PlayerSDKLogService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PlayerSDKLogService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> writePlayerSDKLog(Map<String, ? extends Object> logBody) {
        boolean containsKey = InfodeskHelper.INSTANCE.containsKey(y.ٴسسݬߨ(1393505418));
        String str = y.ٲٴݴ״ٰ(1782196800);
        if (containsKey) {
            Logger.INSTANCE.m699d(str, y.دײܮڳܯ(2051422093));
            return KGResult.INSTANCE.getResult(5001);
        }
        Logger.INSTANCE.m699d(str, y.ۮڭڭܬި(862697907) + logBody);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWritePlayerSDKLogUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("logBody", logBody);
            serverRequest.setIgnoreTimeout(true);
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: PlayerSDKLogService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/log/service/PlayerSDKLogService$Settings;", "", "()V", "writePlayerSDKLogUri", "", "getWritePlayerSDKLogUri", "()Ljava/lang/String;", "setWritePlayerSDKLogUri", "(Ljava/lang/String;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String writePlayerSDKLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862671819), y.دײܮڳܯ(2051422605));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWritePlayerSDKLogUri() {
            return writePlayerSDKLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWritePlayerSDKLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writePlayerSDKLogUri = str;
        }
    }
}
