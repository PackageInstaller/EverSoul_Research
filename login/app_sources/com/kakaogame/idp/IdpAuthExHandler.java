package com.kakaogame.idp;

import android.app.Activity;
import com.kakaogame.KGIdpProfile;
import kotlin.Metadata;

/* compiled from: IdpAuthExHandler.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/idp/IdpAuthExHandler;", "", "localIdpProfile", "Lcom/kakaogame/KGIdpProfile;", "getLocalIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "getAccessToken", "", "activity", "Landroid/app/Activity;", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface IdpAuthExHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String KEY_ACCESS_TOKEN = "idpAccessToken";
    public static final String KEY_CI = "ci";
    public static final String KEY_IDP_CODE = "idpCode";
    public static final String KEY_PLAYER_ID = "playerId";
    public static final String KEY_USER_ID = "idpUserId";

    String getAccessToken(Activity activity);

    KGIdpProfile getLocalIdpProfile();

    /* compiled from: IdpAuthExHandler.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/idp/IdpAuthExHandler$Companion;", "", "()V", "KEY_ACCESS_TOKEN", "", "KEY_CI", "KEY_IDP_CODE", "KEY_PLAYER_ID", "KEY_USER_ID", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String KEY_ACCESS_TOKEN = "idpAccessToken";
        public static final String KEY_CI = "ci";
        public static final String KEY_IDP_CODE = "idpCode";
        public static final String KEY_PLAYER_ID = "playerId";
        public static final String KEY_USER_ID = "idpUserId";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }
    }
}
