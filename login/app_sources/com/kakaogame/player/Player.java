package com.kakaogame.player;

import com.kakaogame.KGObject;
import com.kakaogame.Logger;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Player.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/player/Player;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "playerId", "getPlayerId", "()Ljava/lang/String;", "getCustomProperty", "key", "getSecureProperty", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class Player extends KGObject {
    public static final String FIELD_KEY_ID = "playerId";
    private static final String TAG = "Player";
    private static final long serialVersionUID = 1509065419721815783L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Player(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPlayerId() {
        Object obj = get(y.ݬֲ֮ܲت(1512589743));
        Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
        return (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCustomProperty(String key) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        try {
            Map map = (Map) get(PlayerService.FIELD_KEY_CUSTOM_PROPERTY);
            if (map != null) {
                return (String) map.get(key);
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393517450), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSecureProperty(String key) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        try {
            Map map = (Map) get(PlayerService.FIELD_KEY_SECURE_PROPERTY);
            if (map != null) {
                return (String) map.get(key);
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393517450), e.toString(), e);
            return null;
        }
    }
}
