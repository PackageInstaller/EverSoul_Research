package com.kakaogame.idp;

import android.app.Activity;
import com.kakaogame.KGResult;
import kotlin.Metadata;

/* compiled from: IdpAuthHandler.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\tH&J*\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0003H&J\u0010\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0003H&¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/idp/IdpAuthHandler;", "", "checkAuth", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/idp/IdpAccount;", "activity", "Landroid/app/Activity;", "authData", "traceJobId", "", "idpLogin", "extras", "", "initialize", "Ljava/lang/Void;", "logout", "unregister", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface IdpAuthHandler {
    KGResult<IdpAccount> checkAuth(Activity activity, IdpAccount authData, int traceJobId);

    KGResult<IdpAccount> idpLogin(Activity activity, String extras, int traceJobId);

    KGResult<Void> initialize(Activity activity);

    KGResult<Void> logout() throws Exception;

    KGResult<Void> unregister() throws Exception;

    /* compiled from: IdpAuthHandler.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ KGResult checkAuth$default(IdpAuthHandler idpAuthHandler, Activity activity, IdpAccount idpAccount, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkAuth");
            }
            if ((i2 & 4) != 0) {
                i = -1;
            }
            return idpAuthHandler.checkAuth(activity, idpAccount, i);
        }
    }
}
