package com.kakaogame.kakao;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.AppUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoGuildService.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J,\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007JF\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/kakao/KakaoGuildService;", "", "()V", "TAG", "", "openKakaoTalkChattingTab", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "openKakaoTalkGuildChat", "worldId", "guildId", "sendMessage", "templateId", "args", "", "showGuildChatAgreementView", "", "Settings", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoGuildService {
    public static final KakaoGuildService INSTANCE = new KakaoGuildService();
    private static final String TAG = "KakaoGuildService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGuildService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> openKakaoTalkChattingTab(Activity activity) {
        String str = y.ٲٴݴ״ٰ(1782036808);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        try {
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                return KGResult.INSTANCE.getResult(3002);
            }
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer);
            KGIdpProfile idpProfile = currentPlayer.getIdpProfile();
            Intrinsics.checkNotNull(idpProfile);
            if (idpProfile.getIdpCode() != KGIdpProfile.KGIdpCode.Kakao) {
                KGResult.Companion companion = KGResult.INSTANCE;
                StringBuilder sb = new StringBuilder(str);
                KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                Intrinsics.checkNotNull(currentPlayer2);
                KGIdpProfile idpProfile2 = currentPlayer2.getIdpProfile();
                Intrinsics.checkNotNull(idpProfile2);
                return companion.getResult(5001, sb.append(idpProfile2.getIdpCode()).toString());
            }
            if (!AppUtil.isInstalledWithPackageName(activity, "com.kakao.talk")) {
                return KGResult.INSTANCE.getResult(KGResult.KGResultCode.KAKAOTALK_NOT_INSTALLED);
            }
            if (AppUtil.isInstalledWithUrlScheme(activity, "kakaotalk://main?tab=chats")) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("kakaotalk://main?tab=chats")));
                return KGResult.INSTANCE.getSuccessResult();
            }
            return KGResult.INSTANCE.getResult(2003);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051444117), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:3:0x0011, B:5:0x001d, B:8:0x0026, B:10:0x003e, B:12:0x0068, B:14:0x0073, B:16:0x007c, B:18:0x00ab, B:23:0x00b7, B:24:0x00bc, B:26:0x00e1, B:28:0x00f6), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e1 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:3:0x0011, B:5:0x001d, B:8:0x0026, B:10:0x003e, B:12:0x0068, B:14:0x0073, B:16:0x007c, B:18:0x00ab, B:23:0x00b7, B:24:0x00bc, B:26:0x00e1, B:28:0x00f6), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f6 A[Catch: Exception -> 0x00ff, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ff, blocks: (B:3:0x0011, B:5:0x001d, B:8:0x0026, B:10:0x003e, B:12:0x0068, B:14:0x0073, B:16:0x007c, B:18:0x00ab, B:23:0x00b7, B:24:0x00bc, B:26:0x00e1, B:28:0x00f6), top: B:2:0x0011 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<java.lang.Void> openKakaoTalkGuildChat(android.app.Activity r3, java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.kakao.KakaoGuildService.openKakaoTalkGuildChat(android.app.Activity, java.lang.String, java.lang.String):com.kakaogame.KGResult");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0099 A[Catch: Exception -> 0x00d9, TryCatch #0 {Exception -> 0x00d9, blocks: (B:3:0x0007, B:5:0x0013, B:8:0x001c, B:10:0x0034, B:12:0x005e, B:14:0x008d, B:19:0x0099, B:20:0x009e, B:22:0x00aa, B:23:0x00af, B:25:0x00c4, B:27:0x00cc, B:29:0x00d2), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa A[Catch: Exception -> 0x00d9, TryCatch #0 {Exception -> 0x00d9, blocks: (B:3:0x0007, B:5:0x0013, B:8:0x001c, B:10:0x0034, B:12:0x005e, B:14:0x008d, B:19:0x0099, B:20:0x009e, B:22:0x00aa, B:23:0x00af, B:25:0x00c4, B:27:0x00cc, B:29:0x00d2), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4 A[Catch: Exception -> 0x00d9, TryCatch #0 {Exception -> 0x00d9, blocks: (B:3:0x0007, B:5:0x0013, B:8:0x001c, B:10:0x0034, B:12:0x005e, B:14:0x008d, B:19:0x0099, B:20:0x009e, B:22:0x00aa, B:23:0x00af, B:25:0x00c4, B:27:0x00cc, B:29:0x00d2), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d2 A[Catch: Exception -> 0x00d9, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d9, blocks: (B:3:0x0007, B:5:0x0013, B:8:0x001c, B:10:0x0034, B:12:0x005e, B:14:0x008d, B:19:0x0099, B:20:0x009e, B:22:0x00aa, B:23:0x00af, B:25:0x00c4, B:27:0x00cc, B:29:0x00d2), top: B:2:0x0007 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<java.lang.Void> sendMessage(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r0 = 1782036808(0x6a37b948, float:5.55271E25)
            java.lang.String r0 = com.liapp.y.ٲٴݴ״ٰ(r0)
            com.kakaogame.core.CoreManager$Companion r1 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.core.CoreManager r1 = r1.getInstance()     // Catch: java.lang.Exception -> Ld9
            boolean r1 = r1.isNotAuthorized()     // Catch: java.lang.Exception -> Ld9
            if (r1 == 0) goto L1c
            com.kakaogame.KGResult$Companion r3 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Ld9
            r4 = 3002(0xbba, float:4.207E-42)
            com.kakaogame.KGResult r3 = r3.getResult(r4)     // Catch: java.lang.Exception -> Ld9
            return r3
        L1c:
            com.kakaogame.KGLocalPlayer$Companion r1 = com.kakaogame.KGLocalPlayer.INSTANCE     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGLocalPlayer r1 = r1.getCurrentPlayer()     // Catch: java.lang.Exception -> Ld9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGIdpProfile r1 = r1.getIdpProfile()     // Catch: java.lang.Exception -> Ld9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGIdpProfile$KGIdpCode r1 = r1.getIdpCode()     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGIdpProfile$KGIdpCode r2 = com.kakaogame.KGIdpProfile.KGIdpCode.Kakao     // Catch: java.lang.Exception -> Ld9
            if (r1 == r2) goto L5e
            com.kakaogame.KGResult$Companion r3 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Ld9
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld9
            r4.<init>(r0)     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGLocalPlayer$Companion r5 = com.kakaogame.KGLocalPlayer.INSTANCE     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGLocalPlayer r5 = r5.getCurrentPlayer()     // Catch: java.lang.Exception -> Ld9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGIdpProfile r5 = r5.getIdpProfile()     // Catch: java.lang.Exception -> Ld9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGIdpProfile$KGIdpCode r5 = r5.getIdpCode()     // Catch: java.lang.Exception -> Ld9
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> Ld9
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Ld9
            r5 = 5001(0x1389, float:7.008E-42)
            com.kakaogame.KGResult r3 = r3.getResult(r5, r4)     // Catch: java.lang.Exception -> Ld9
            return r3
        L5e:
            com.kakaogame.server.ServerRequest r0 = new com.kakaogame.server.ServerRequest     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.kakao.KakaoGuildService$Settings r1 = com.kakaogame.kakao.KakaoGuildService.Settings.INSTANCE     // Catch: java.lang.Exception -> Ld9
            java.lang.String r1 = r1.getSendMessageUri()     // Catch: java.lang.Exception -> Ld9
            r0.<init>(r1)     // Catch: java.lang.Exception -> Ld9
            java.lang.String r1 = "appId"
            com.kakaogame.core.CoreManager$Companion r2 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.core.CoreManager r2 = r2.getInstance()     // Catch: java.lang.Exception -> Ld9
            java.lang.String r2 = r2.getAppId()     // Catch: java.lang.Exception -> Ld9
            r0.putBody(r1, r2)     // Catch: java.lang.Exception -> Ld9
            java.lang.String r1 = "playerId"
            com.kakaogame.core.CoreManager$Companion r2 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.core.CoreManager r2 = r2.getInstance()     // Catch: java.lang.Exception -> Ld9
            java.lang.String r2 = r2.getPlayerId()     // Catch: java.lang.Exception -> Ld9
            r0.putBody(r1, r2)     // Catch: java.lang.Exception -> Ld9
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> Ld9
            r2 = 0
            if (r1 == 0) goto L96
            int r1 = r1.length()     // Catch: java.lang.Exception -> Ld9
            if (r1 != 0) goto L94
            goto L96
        L94:
            r1 = r2
            goto L97
        L96:
            r1 = 1
        L97:
            if (r1 != 0) goto L9e
            java.lang.String r1 = "worldId"
            r0.putBody(r1, r3)     // Catch: java.lang.Exception -> Ld9
        L9e:
            java.lang.String r3 = "guildId"
            r0.putBody(r3, r4)     // Catch: java.lang.Exception -> Ld9
            java.lang.String r3 = "templateId"
            r0.putBody(r3, r5)     // Catch: java.lang.Exception -> Ld9
            if (r6 == 0) goto Laf
            java.lang.String r3 = "templateArgs"
            r0.putBody(r3, r6)     // Catch: java.lang.Exception -> Ld9
        Laf:
            r3 = 2
            r4 = 0
            com.kakaogame.server.ServerResult r3 = com.kakaogame.server.ServerService.requestServer$default(r0, r2, r3, r4)     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGResult$Companion r4 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Ld9
            r5 = r3
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGResult r4 = r4.getResult(r5)     // Catch: java.lang.Exception -> Ld9
            boolean r5 = r3.isSuccess()     // Catch: java.lang.Exception -> Ld9
            if (r5 != 0) goto Ld2
            int r3 = r3.getCode()     // Catch: java.lang.Exception -> Ld9
            r5 = 406(0x196, float:5.69E-43)
            if (r3 != r5) goto Ld1
            java.lang.String r3 = "Request not exist data."
            r4.setMessage(r3)     // Catch: java.lang.Exception -> Ld9
        Ld1:
            return r4
        Ld2:
            com.kakaogame.KGResult$Companion r3 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Ld9
            com.kakaogame.KGResult r3 = r3.getSuccessResult()     // Catch: java.lang.Exception -> Ld9
            goto Lf9
        Ld9:
            r3 = move-exception
            com.kakaogame.Logger r4 = com.kakaogame.Logger.INSTANCE
            java.lang.String r5 = r3.toString()
            r6 = r3
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r0 = 2051444117(0x7a468d95, float:2.577366E35)
            java.lang.String r0 = com.liapp.y.دײܮڳܯ(r0)
            r4.m702e(r0, r5, r6)
            com.kakaogame.KGResult$Companion r4 = com.kakaogame.KGResult.INSTANCE
            r5 = 4001(0xfa1, float:5.607E-42)
            java.lang.String r3 = r3.toString()
            com.kakaogame.KGResult r3 = r4.getResult(r5, r3)
        Lf9:
            return r3
            fill-array 0x00fa: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.kakao.KakaoGuildService.sendMessage(java.lang.String, java.lang.String, java.lang.String, java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Boolean> showGuildChatAgreementView(Activity activity) {
        String str = y.ٲٴݴ״ٰ(1782036808);
        try {
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                return KGResult.INSTANCE.getResult(3002);
            }
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer);
            KGIdpProfile idpProfile = currentPlayer.getIdpProfile();
            Intrinsics.checkNotNull(idpProfile);
            if (idpProfile.getIdpCode() != KGIdpProfile.KGIdpCode.Kakao) {
                KGResult.Companion companion = KGResult.INSTANCE;
                StringBuilder sb = new StringBuilder(str);
                KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                Intrinsics.checkNotNull(currentPlayer2);
                KGIdpProfile idpProfile2 = currentPlayer2.getIdpProfile();
                Intrinsics.checkNotNull(idpProfile2);
                return companion.getResult(5001, sb.append(idpProfile2.getIdpCode()).toString());
            }
            KGResult<String> updateScope = KGKakao2Auth.INSTANCE.updateScope(activity, CollectionsKt.listOf("talk_openchats"));
            if (updateScope.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(9001, updateScope.getDescription());
            }
            return KGResult.INSTANCE.getSuccessResult(true);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051444117), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: KakaoGuildService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/kakao/KakaoGuildService$Settings;", "", "()V", "getChatSchemeUri", "", "getGetChatSchemeUri", "()Ljava/lang/String;", "setGetChatSchemeUri", "(Ljava/lang/String;)V", "sendMessageUri", "getSendMessageUri", "setSendMessageUri", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String sendMessageUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862706307), y.ݮڮֲڭܩ(-628377364));
        private static String getChatSchemeUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512482351), y.֬ڱܱײٮ(-1158687767));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendMessageUri() {
            return sendMessageUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSendMessageUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            sendMessageUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetChatSchemeUri() {
            return getChatSchemeUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetChatSchemeUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getChatSchemeUri = str;
        }
    }
}
