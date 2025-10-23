package com.kakaogame;

import com.kakaogame.idp.KGTwitterAuth;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: KGTwitterProfile.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e0\rH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/KGTwitterProfile;", "Lcom/kakaogame/KGIdpProfile;", "content", "", "", "", "(Ljava/util/Map;)V", "profileImageUrl", "getProfileImageUrl", "()Ljava/lang/String;", KGTwitterAuth.KEY_SCREEN_NAME, "getScreenName", "loadFriendProfiles", "Lcom/kakaogame/KGResult;", "", "Companion", "idp_twitter_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGTwitterProfile extends KGIdpProfile {
    private static final long serialVersionUID = -2875654182578894278L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGTwitterProfile(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGIdpProfile
    public KGResult<Map<String, KGIdpProfile>> loadFriendProfiles() {
        return KGResult.INSTANCE.getResult(5001);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getScreenName() {
        return (String) get(y.ٴسسݬߨ(1392727170));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileImageUrl() {
        return (String) get(y.٬ݯح׭٩(575735166));
    }
}
