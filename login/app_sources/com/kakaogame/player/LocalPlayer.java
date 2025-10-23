package com.kakaogame.player;

import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.liapp.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: LocalPlayer.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J&\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003J&\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\bJ&\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\bR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/player/LocalPlayer;", "Lcom/kakaogame/player/Player;", "m", "", "", "", "(Ljava/util/Map;)V", LocalPlayerService.FIELD_KEY_AGREEMENT, "", "getAgreement", "()Ljava/util/Map;", "updateCustomProperty", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "updateCustomPropertyMap", "updatePlayer", "fieldMap", "updateSecureProperty", "updateSecurePropertyMap", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LocalPlayer extends Player {
    private static final String TAG = "LocalPlayer";
    private static final long serialVersionUID = 6107289818113726925L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocalPlayer(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getAgreement() {
        String str = y.ݬֲ֮ܲت(1512616079);
        HashMap hashMap = new HashMap();
        try {
            if (containsKey(str)) {
                Object obj = get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                hashMap.putAll((Map) obj);
            }
        } catch (Exception unused) {
            Logger.INSTANCE.m701e(y.ۮڭڭܬި(862681139), y.٬ݯح׭٩(576509278));
        }
        return hashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> updatePlayer(Map<String, ? extends Object> fieldMap) {
        String str = y.ۮڭڭܬި(862681139);
        String str2 = y.ݬֲ֮ܲت(1512454207);
        try {
            KGResult<Void> updatePlayer = LocalPlayerService.updatePlayer(fieldMap);
            Logger.INSTANCE.m699d(str, str2 + updatePlayer);
            if (!updatePlayer.isSuccess()) {
                return updatePlayer;
            }
            putAll(fieldMap);
            return updatePlayer;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> updateCustomProperty(Map<String, String> updateCustomPropertyMap) {
        String str = y.֬ڱܱײٮ(-1159585167);
        String str2 = y.ۮڭڭܬި(862681139);
        String str3 = y.֬ڱܱײٮ(-1158721575);
        try {
            KGResult<Void> updateCustomProperty = LocalPlayerService.updateCustomProperty(updateCustomPropertyMap);
            Logger.INSTANCE.m699d(str2, str3 + updateCustomProperty);
            if (!updateCustomProperty.isSuccess()) {
                return updateCustomProperty;
            }
            Map asMutableMap = TypeIntrinsics.asMutableMap(get(str));
            if (asMutableMap != null) {
                Intrinsics.checkNotNull(updateCustomPropertyMap);
                asMutableMap.putAll(updateCustomPropertyMap);
                return updateCustomProperty;
            }
            put(str, updateCustomPropertyMap);
            return updateCustomProperty;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> updateSecureProperty(Map<String, String> updateSecurePropertyMap) {
        String str = y.دײܮڳܯ(2051436117);
        String str2 = y.ۮڭڭܬި(862681139);
        String str3 = y.ٴسسݬߨ(1393519866);
        try {
            KGResult<Void> updateSecureProperty = LocalPlayerService.updateSecureProperty(updateSecurePropertyMap);
            Logger.INSTANCE.m699d(str2, str3 + updateSecureProperty);
            if (!updateSecureProperty.isSuccess()) {
                return updateSecureProperty;
            }
            Map asMutableMap = TypeIntrinsics.asMutableMap(get(str));
            if (asMutableMap != null) {
                Intrinsics.checkNotNull(updateSecurePropertyMap);
                asMutableMap.putAll(updateSecurePropertyMap);
                return updateSecureProperty;
            }
            put(str, updateSecurePropertyMap);
            return updateSecureProperty;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }
}
