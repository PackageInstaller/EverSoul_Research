package com.kakaogame.apple;

import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.auth.AuthService;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SIWAManager.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002J\u001a\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/apple/SIWAManager;", "", "()V", "TAG", "", "revokeToken", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "revokeTokenImpl", "revokeTokenInternal", "", "callback", "Lcom/kakaogame/KGResultCallback;", "idp_siwa_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SIWAManager {
    public static final SIWAManager INSTANCE = new SIWAManager();
    private static final String TAG = "KakaoManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SIWAManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> revokeToken() {
        String idpRefreshToken;
        KGResult<Void> revokeSIWA;
        KGIdpProfile idpProfile;
        if (SDKVersion.isPublishing) {
            return KGResult.INSTANCE.getResult(5001, y.ٲٴݴ״ٰ(1782162280));
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.SigninWithApple;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (kGIdpCode != ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
            return KGResult.INSTANCE.getResult(4002, y.دײܮڳܯ(2051383437));
        }
        IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
        return (authData == null || (idpRefreshToken = authData.getIdpRefreshToken()) == null || (revokeSIWA = AuthService.INSTANCE.revokeSIWA(CoreManager.INSTANCE.getInstance().getPlayerId(), idpRefreshToken)) == null) ? KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1393337242)) : revokeSIWA;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void revokeTokenInternal(KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SIWAManager$revokeTokenInternal$1(callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> revokeTokenImpl() {
        String idpRefreshToken;
        KGResult<Void> revokeSIWA;
        KGIdpProfile idpProfile;
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.SigninWithApple;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (kGIdpCode != ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
            return KGResult.INSTANCE.getResult(4002, y.دײܮڳܯ(2051383437));
        }
        IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
        return (authData == null || (idpRefreshToken = authData.getIdpRefreshToken()) == null || (revokeSIWA = AuthService.INSTANCE.revokeSIWA(CoreManager.INSTANCE.getInstance().getPlayerId(), idpRefreshToken)) == null) ? KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1393337242)) : revokeSIWA;
    }
}
