package com.kakaogame;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: KGGoogleProfile.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t0\bH\u0016¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/KGGoogleProfile;", "Lcom/kakaogame/KGIdpProfile;", "content", "", "", "", "(Ljava/util/Map;)V", "loadFriendProfiles", "Lcom/kakaogame/KGResult;", "", "Companion", "idp_googlegame_v2_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGGoogleProfile extends KGIdpProfile {
    private static final long serialVersionUID = -2875654182578894278L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGGoogleProfile(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGIdpProfile
    public KGResult<Map<String, KGIdpProfile>> loadFriendProfiles() {
        return KGResult.INSTANCE.getResult(5001);
    }
}
