package com.kakaogame;

import android.app.Activity;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.kakaogame.KGPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.auth.view.DatePickerDialog;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.player.Player;
import com.kakaogame.player.PlayerService;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGPlayer.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0004R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/KGPlayer;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "customProperties", "", "getCustomProperties", "()Ljava/util/Map;", KGPlayer.KEY_IDP_PROFILE, "Lcom/kakaogame/KGIdpProfile;", "getIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "setIdpProfile", "(Lcom/kakaogame/KGIdpProfile;)V", KGPlayer.KEY_IS_ONLINE_UNITY, "", "()Z", "playerId", "getPlayerId", "()Ljava/lang/String;", "getCustomProperty", "key", "Companion", "KGDate", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class KGPlayer extends KGObject {
    private static final String CLASS_NAME_KEY = "KGPlayer";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_IDP_PROFILE = "idpProfile";
    public static final String KEY_IS_ONLINE = "online";
    public static final String KEY_IS_ONLINE_UNITY = "isOnline";
    public static final String KEY_PLAYER_ID = "playerId";
    private static final String TAG = "KGPlayer";
    private static final long serialVersionUID = 6094436585478755491L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void enablePersonalizedAds(boolean z, KGResultCallback<Void> kGResultCallback) {
        INSTANCE.enablePersonalizedAds(z, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void isEnablePersonalizedAds(KGResultCallback<Boolean> kGResultCallback) {
        INSTANCE.isEnablePersonalizedAds(kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadFriendPlayers(KGResultCallback<List<KGPlayer>> kGResultCallback) {
        INSTANCE.loadFriendPlayers(kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<KGPlayer> loadPlayer(String str, String str2) {
        return INSTANCE.loadPlayer(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadPlayers(List<String> list, KGResultCallback<Map<String, KGPlayer>> kGResultCallback) {
        INSTANCE.loadPlayers(list, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showDatePickerDialog(Activity activity, String str, String str2, KGResultCallback<KGDate> kGResultCallback) {
        INSTANCE.showDatePickerDialog(activity, str, str2, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGPlayer(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPlayerId() {
        try {
            Object obj = get("playerId");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return (String) obj;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862442395), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGIdpProfile getIdpProfile() {
        return (KGIdpProfile) get(y.ݮڮֲڭܩ(-628793764));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setIdpProfile(KGIdpProfile kGIdpProfile) {
        if (kGIdpProfile != null) {
            put(y.ݬֲ֮ܲت(1512589743), getPlayerId());
            put(y.ݮڮֲڭܩ(-628793764), kGIdpProfile);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCustomProperty(String key) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        try {
            Map<String, Object> content = getContent();
            Intrinsics.checkNotNull(content);
            Map map = (Map) content.get(PlayerService.FIELD_KEY_CUSTOM_PROPERTY);
            if (map != null) {
                return (String) map.get(key);
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862442395), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getCustomProperties() {
        try {
            Map<String, Object> content = getContent();
            Intrinsics.checkNotNull(content);
            return (Map) content.get(PlayerService.FIELD_KEY_CUSTOM_PROPERTY);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862442395), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isOnline() {
        try {
            Object obj = get("online");
            if (obj == null) {
                obj = false;
            }
            return ((Boolean) obj).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* compiled from: KGPlayer.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/KGPlayer$KGDate;", "Lcom/kakaogame/KGObject;", KGDate.KEY_DATE_YEAR, "", KGDate.KEY_DATE_MONTH, KGDate.KEY_DATE_DAY, "(III)V", "getDay", "()I", "getMonth", "getYear", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGDate extends KGObject {
        private static final String KEY_DATE_DAY = "day";
        private static final String KEY_DATE_MONTH = "month";
        private static final String KEY_DATE_YEAR = "year";
        private static final String TAG = "NZDate";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGDate(int i, int i2, int i3) {
            super(null, 1, 0 == true ? 1 : 0);
            put(y.ۮڭڭܬި(862449467), Integer.valueOf(i));
            put(KEY_DATE_MONTH, Integer.valueOf(i2));
            put(KEY_DATE_DAY, Integer.valueOf(i3));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getYear() {
            Number number = (Number) get(y.ۮڭڭܬި(862449467));
            Intrinsics.checkNotNull(number);
            return number.intValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getMonth() {
            Number number = (Number) get(y.ۮڭڭܬި(862449491));
            Intrinsics.checkNotNull(number);
            return number.intValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getDay() {
            Number number = (Number) get(y.٬ݯح׭٩(575685134));
            Intrinsics.checkNotNull(number);
            return number.intValue();
        }
    }

    /* compiled from: KGPlayer.kt */
    @Metadata(m838d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000f2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\"\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00102\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0006\u0010\u001b\u001a\u00020\u0017J\u001a\u0010\u000e\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0019H\u0007J\u0014\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d0\u000fJ \u0010\u001c\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0018\u00010\u0019H\u0007J$\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010\"\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u00010#0\u000f2\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001dJ8\u0010\"\u001a\u00020\u00172\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001d2\u001c\u0010\u0018\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u00010#\u0018\u00010\u0019H\u0007J4\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, m839d2 = {"Lcom/kakaogame/KGPlayer$Companion;", "", "()V", "CLASS_NAME_KEY", "", "KEY_IDP_PROFILE", "KEY_IS_ONLINE", "KEY_IS_ONLINE_UNITY", "KEY_PLAYER_ID", "TAG", "fields", "", "getFields", "()Ljava/util/List;", "isEnablePersonalizedAds", "Lcom/kakaogame/KGResult;", "", "()Lcom/kakaogame/KGResult;", "serialVersionUID", "", "enablePersonalizedAds", "Ljava/lang/Void;", "enable", "", "callback", "Lcom/kakaogame/KGResultCallback;", "initInterfaceBroker", "initialize", "loadFriendPlayers", "", "Lcom/kakaogame/KGPlayer;", "loadPlayer", "idpCode", "idpId", "loadPlayers", "", NativeProtocol.WEB_DIALOG_PARAMS, "playerIds", "showDatePickerDialog", "activity", "Landroid/app/Activity;", "title", "subTitle", "Lcom/kakaogame/KGPlayer$KGDate;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<List<KGPlayer>> loadFriendPlayers() {
            KGResult<List<KGPlayer>> result;
            String name;
            KGResult<List<KGPlayer>> result2;
            Stopwatch start = Stopwatch.INSTANCE.start(y.ݬֲ֮ܲت(1512743687));
            try {
                try {
                } catch (Exception e) {
                    Logger.INSTANCE.m702e("KGPlayer", e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                }
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    result2 = KGResult.INSTANCE.getResult(3002, "Not Authorized");
                } else {
                    IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
                    Intrinsics.checkNotNull(authData);
                    String idpCode = authData.getIdpCode();
                    KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                    Intrinsics.checkNotNull(currentPlayer);
                    KGIdpProfile idpProfile = currentPlayer.getIdpProfile();
                    Intrinsics.checkNotNull(idpProfile);
                    KGResult<Map<String, KGIdpProfile>> loadFriendProfiles = idpProfile.loadFriendProfiles();
                    if (!loadFriendProfiles.isNotSuccess()) {
                        Map<String, KGIdpProfile> content = loadFriendProfiles.getContent();
                        ArrayList arrayList = new ArrayList();
                        Intrinsics.checkNotNull(content);
                        if (!content.isEmpty()) {
                            KGResult<Map<String, Player>> listWithIdpId = PlayerService.getListWithIdpId(idpCode, new ArrayList(content.keySet()), getFields());
                            if (listWithIdpId.isNotSuccess()) {
                                result2 = KGResult.INSTANCE.getResult(listWithIdpId);
                            } else {
                                Map<String, Player> content2 = listWithIdpId.getContent();
                                Intrinsics.checkNotNull(content2);
                                for (Map.Entry<String, Player> entry : content2.entrySet()) {
                                    String key = entry.getKey();
                                    Player value = entry.getValue();
                                    KGIdpProfile kGIdpProfile = content.get(key);
                                    if (kGIdpProfile != null) {
                                        KGPlayer kGPlayer = new KGPlayer(value.getObject());
                                        if (!TextUtils.isEmpty(kGPlayer.getPlayerId())) {
                                            kGIdpProfile.put("playerId", kGPlayer.getPlayerId());
                                            kGPlayer.put(KGPlayer.KEY_IDP_PROFILE, kGIdpProfile);
                                            arrayList.add(kGPlayer);
                                        }
                                    }
                                }
                            }
                        }
                        result = KGResult.INSTANCE.getSuccessResult(arrayList);
                        start.stop();
                        name = start.getName();
                        KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                        return result;
                    }
                    result2 = KGResult.INSTANCE.getResult(loadFriendProfiles);
                }
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            } catch (Throwable th) {
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final KGResult<KGPlayer> loadPlayer(String idpCode, String idpId) {
            try {
                List asList = Arrays.asList(idpId);
                Intrinsics.checkNotNull(idpCode);
                KGResult<Map<String, Player>> listWithIdpId = PlayerService.getListWithIdpId(idpCode, asList, getFields());
                if (!listWithIdpId.isSuccess()) {
                    return KGResult.INSTANCE.getResult(listWithIdpId);
                }
                Map<String, Player> content = listWithIdpId.getContent();
                Intrinsics.checkNotNull(content);
                Player player = content.get(idpId);
                return player == null ? KGResult.INSTANCE.getSuccessResult(null) : KGResult.INSTANCE.getSuccessResult(new KGPlayer(player.getObject()));
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ۮڭڭܬި(862442395), e.toString(), e);
                return KGResult.INSTANCE.getResult(4001, e.toString());
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<Map<String, KGPlayer>> loadPlayers(List<String> params) {
            KGResult<Map<String, KGPlayer>> result;
            String name;
            KGResult<Map<String, KGPlayer>> result2;
            if (params == null) {
                return KGResult.INSTANCE.getResult(4000, y.ݮڮֲڭܩ(-628638140));
            }
            ArrayList arrayList = new ArrayList();
            for (String str : params) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() == 0) {
                return KGResult.INSTANCE.getSuccessResult(new HashMap());
            }
            Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575688422));
            try {
                try {
                } catch (Exception e) {
                    Logger.INSTANCE.m702e("KGPlayer", e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                }
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    result2 = KGResult.INSTANCE.getResult(3002, "Not Authorized");
                } else {
                    KGResult<List<Player>> players = PlayerService.getPlayers(arrayList, getFields());
                    if (!players.isNotSuccess()) {
                        HashMap hashMap = new HashMap();
                        List<Player> content = players.getContent();
                        Intrinsics.checkNotNull(content);
                        for (Player player : content) {
                            hashMap.put(player.getPlayerId(), new KGPlayer(player.getObject()));
                        }
                        result = KGResult.INSTANCE.getSuccessResult(hashMap);
                        start.stop();
                        name = start.getName();
                        KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                        return result;
                    }
                    result2 = KGResult.INSTANCE.getResult(players);
                }
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            } catch (Throwable th) {
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void loadFriendPlayers(KGResultCallback<List<KGPlayer>> callback) {
            Logger.INSTANCE.m704i(y.ۮڭڭܬި(862442395), y.֬ڱܱײٮ(-1159474095));
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGPlayer$Companion$loadFriendPlayers$6(callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void loadPlayers(List<String> playerIds, KGResultCallback<Map<String, KGPlayer>> callback) {
            Logger.INSTANCE.m704i(y.ۮڭڭܬި(862442395), y.ٴسسݬߨ(1392741162) + playerIds);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGPlayer$Companion$loadPlayers$5(playerIds, callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final List<String> getFields() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(y.ݬֲ֮ܲت(1512589743));
            arrayList.add(y.֬ڱܱײٮ(-1159585167));
            return arrayList;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void showDatePickerDialog(Activity activity, String title, String subTitle, final KGResultCallback<KGDate> callback) {
            String str = y.ۮڭڭܬި(862442395);
            String str2 = y.٬ݯح׭٩(575688654);
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
            try {
                Logger.INSTANCE.m699d(str, str2 + title + " : " + subTitle);
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGPlayer$Companion$showDatePickerDialog$1(activity, new DatePickerDialog.DatePickerListener() { // from class: com.kakaogame.KGPlayer$Companion$showDatePickerDialog$listener$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.auth.view.DatePickerDialog.DatePickerListener
                    public void onDatePick(int year, int month, int day) {
                        callback.onResult(KGResult.INSTANCE.getSuccessResult(new KGPlayer.KGDate(year, month, day)));
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.auth.view.DatePickerDialog.DatePickerListener
                    public void onUserCanceled() {
                        KGResult.Companion companion = KGResult.INSTANCE;
                        String str3 = y.ݮڮֲڭܩ(-628653948);
                        KGResult<KGPlayer.KGDate> result = companion.getResult(9001, str3, null);
                        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862442395), str3);
                        callback.onResult(result);
                    }
                }, title, subTitle, null), 3, null);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, y.֬ڱܱײٮ(-1159473103) + e, e);
                callback.onResult(KGResult.INSTANCE.getResult(4001, e.toString()));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void isEnablePersonalizedAds(KGResultCallback<Boolean> callback) {
            Logger logger = Logger.INSTANCE;
            String str = y.ݮڮֲڭܩ(-628639252);
            String str2 = y.ۮڭڭܬި(862442395);
            logger.m704i(str2, str);
            if (callback != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGPlayer$Companion$isEnablePersonalizedAds$1(callback, null), 3, null);
            } else {
                Logger.INSTANCE.m701e(str2, y.֬ڱܱײٮ(-1159474263));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void enablePersonalizedAds(boolean enable, KGResultCallback<Void> callback) {
            Logger logger = Logger.INSTANCE;
            String concat = y.دײܮڳܯ(2051706517).concat(enable ? y.دײܮڳܯ(2051939573) : y.ٲٴݴ״ٰ(1781635312));
            String str = y.ۮڭڭܬި(862442395);
            logger.m704i(str, concat);
            if (callback != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGPlayer$Companion$enablePersonalizedAds$1(enable, callback, null), 3, null);
            } else {
                Logger.INSTANCE.m701e(str, "enablePush: Invalid Parameter! 'callback' is null.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<Boolean> isEnablePersonalizedAds() {
            KGResult<Boolean> result;
            String name;
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                return KGResult.INSTANCE.getResult(3002);
            }
            Stopwatch start = Stopwatch.INSTANCE.start(y.دײܮڳܯ(2051715493));
            try {
                try {
                    result = PlayerService.getAdAgreement();
                    if (!result.isSuccess()) {
                        result = KGResult.INSTANCE.getResult(result);
                    }
                    start.stop();
                    name = start.getName();
                } catch (Exception e) {
                    Logger.INSTANCE.m702e("KGPlayer", e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                }
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            } catch (Throwable th) {
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<Void> enablePersonalizedAds(boolean enable) {
            KGResult<Void> result;
            String name;
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                return KGResult.INSTANCE.getResult(3002);
            }
            Stopwatch start = Stopwatch.INSTANCE.start(y.ٴسسݬߨ(1392751890));
            try {
                try {
                    KGResult<Void> adAgreement = PlayerService.setAdAgreement(enable);
                    if (!adAgreement.isSuccess()) {
                        result = KGResult.INSTANCE.getResult(adAgreement);
                    } else {
                        result = KGResult.INSTANCE.getSuccessResult();
                    }
                    start.stop();
                    name = start.getName();
                } catch (Exception e) {
                    Logger.INSTANCE.m702e("KGPlayer", e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                }
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            } catch (Throwable th) {
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392752146), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayer$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGResult<List<KGPlayer>> loadFriendPlayers = KGPlayer.INSTANCE.loadFriendPlayers();
                    if (!loadFriendPlayers.isSuccess()) {
                        return loadFriendPlayers;
                    }
                    List<KGPlayer> content = loadFriendPlayers.getContent();
                    Intrinsics.checkNotNull(content);
                    for (KGPlayer kGPlayer : content) {
                        kGPlayer.put(y.ٲٴݴ״ٰ(1781808296), Boolean.valueOf(kGPlayer.isOnline()));
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.٬ݯح׭٩(575700222), content);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512742087), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayer$Companion$initInterfaceBroker$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGResult<Map<String, KGPlayer>> loadPlayers = KGPlayer.INSTANCE.loadPlayers((List) request.getParameter("playerIds"));
                    if (!loadPlayers.isSuccess()) {
                        return loadPlayers;
                    }
                    Map<String, KGPlayer> content = loadPlayers.getContent();
                    Intrinsics.checkNotNull(content);
                    for (String str : content.keySet()) {
                        KGPlayer kGPlayer = content.get(str);
                        Intrinsics.checkNotNull(kGPlayer);
                        boolean isOnline = kGPlayer.isOnline();
                        KGPlayer kGPlayer2 = content.get(str);
                        Intrinsics.checkNotNull(kGPlayer2);
                        kGPlayer2.put(y.ٲٴݴ״ٰ(1781808296), Boolean.valueOf(isOnline));
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.٬ݯح׭٩(575700222), content);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392750690), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayer$Companion$initInterfaceBroker$3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                    String str = (String) request.getParameter(y.ٲٴݴ״ٰ(1781623336));
                    String str2 = (String) request.getParameter(y.ݬֲ֮ܲت(1512739471));
                    final MutexLock createLock = MutexLock.INSTANCE.createLock();
                    KGPlayer.INSTANCE.showDatePickerDialog(activity, str, str2, new KGResultCallback<KGPlayer.KGDate>() { // from class: com.kakaogame.KGPlayer$Companion$initInterfaceBroker$3$request$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<KGPlayer.KGDate> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                    MutexLock.lock$default(createLock, 0L, 1, null);
                    KGResult kGResult = (KGResult) createLock.getContent();
                    Intrinsics.checkNotNull(kGResult);
                    if (!kGResult.isSuccess()) {
                        return KGResult.INSTANCE.getResult(kGResult);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.٬ݯح׭٩(575818262), kGResult.getContent());
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628652748), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayer$Companion$initInterfaceBroker$4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult isEnablePersonalizedAds;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    isEnablePersonalizedAds = KGPlayer.INSTANCE.isEnablePersonalizedAds();
                    if (!isEnablePersonalizedAds.isSuccess()) {
                        return KGResult.INSTANCE.getResult(isEnablePersonalizedAds);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.ٲٴݴ״ٰ(1781966448), isEnablePersonalizedAds.getContent());
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051715285), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayer$Companion$initInterfaceBroker$5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> enablePersonalizedAds;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Object parameter = request.getParameter("enable");
                    Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.Boolean");
                    enablePersonalizedAds = KGPlayer.INSTANCE.enablePersonalizedAds(((Boolean) parameter).booleanValue());
                    return enablePersonalizedAds;
                }
            });
        }
    }
}
