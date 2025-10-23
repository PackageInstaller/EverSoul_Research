package com.kakaogame.invite;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.kakaogame.addon.KGService;
import com.kakaogame.core.CoreManager;
import com.kakaogame.promotion.PromotionService;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.util.PreferenceUtil;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: InviteDataManager.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0004J\u0018\u0010\u001f\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004J\u0018\u0010 \u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004J\u0018\u0010!\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010#\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\"\u0010%\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0014H\u0007J\"\u0010'\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0014H\u0007J\"\u0010)\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0007J\u001a\u0010+\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0018\u0010,\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0004H\u0007J \u0010-\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001aJ(\u0010/\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, m839d2 = {"Lcom/kakaogame/invite/InviteDataManager;", "", "()V", "INVITATION_KEY", "", "INVITATION_SEQ_KEY", "KEY", "KEY_FIRST_LAUNCHING", "KEY_PLAYER_REFERRER", "NAME", "PLAYER_KEY", "REWARD_KEY", "TAG", InviteDataManager.KEY_FIRST_LAUNCHING, "", "context", "Landroid/content/Context;", "isPlayerReward", "playerId", "loadInvitationSeq", "", "loadPlayerInvitationCount", "loadPlayerInvitationReferrer", "loadReferrer", "loadRewardRequest", "", "Lcom/kakaogame/server/ServerRequest;", "logout", "", "activity", "Landroid/app/Activity;", "removePlayerInvitationCount", "removePlayerInvitationReferrer", "removePlayerRewardData", "removeReferrer", "removeRewardReqeust", "removeUserInvitationData", "saveInvitationSeq", ServerConstants.SEQ, "savePlayerInvitationCount", KGService.COUNT, "savePlayerInvitationReferrer", InviteDataManager.KEY, "savePlayerRewardData", "saveReferrer", "saveRewardRequest", "request", "saveRewardRequests", "requests", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InviteDataManager {
    public static final InviteDataManager INSTANCE = new InviteDataManager();
    private static final String INVITATION_KEY = "invitation_";
    private static final String INVITATION_SEQ_KEY = "invitation_seq_";
    private static final String KEY = "referrer";
    public static final String KEY_FIRST_LAUNCHING = "isFirstLaunching";
    private static final String KEY_PLAYER_REFERRER = "playerReferrer";
    private static final String NAME = "InviteData";
    private static final String PLAYER_KEY = "playerId_";
    private static final String REWARD_KEY = "reward_";
    private static final String TAG = "InviteDataManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InviteDataManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isFirstLaunching(Context context) {
        String str = y.ݮڮֲڭܩ(-628462308);
        String str2 = y.دײܮڳܯ(2051496925);
        boolean z = PreferenceUtil.getBoolean(context, str, str2, true);
        if (z) {
            PreferenceUtil.setBoolean(context, str, str2, false);
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void saveReferrer(Context context, String referrer) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        String str = y.ۮڭڭܬި(862461307);
        Intrinsics.checkNotNullParameter(referrer, str);
        Log.i(y.ݬֲ֮ܲت(1512538111), y.ۮڭڭܬި(862600499) + referrer);
        PreferenceUtil.setString(context, y.ݮڮֲڭܩ(-628462308), str, referrer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String loadReferrer(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        return PreferenceUtil.getString(context, y.ݮڮֲڭܩ(-628462308), y.ۮڭڭܬި(862461307), "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void removeReferrer(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        PreferenceUtil.removeKey(context, y.ݮڮֲڭܩ(-628462308), y.ۮڭڭܬި(862461307));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void savePlayerInvitationReferrer(Context context, String playerId, String referrer) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        Intrinsics.checkNotNullParameter(referrer, y.ۮڭڭܬި(862461307));
        Log.i(y.ݬֲ֮ܲت(1512538111), y.ۮڭڭܬި(862600499) + referrer);
        PreferenceUtil.setString(context, y.ݮڮֲڭܩ(-628462308), y.ݬֲ֮ܲت(1512534047) + playerId, referrer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String loadPlayerInvitationReferrer(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        return PreferenceUtil.getString(context, y.ݮڮֲڭܩ(-628462308), y.ݬֲ֮ܲت(1512534047) + playerId, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removePlayerInvitationReferrer(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        PreferenceUtil.removeKey(context, y.ݮڮֲڭܩ(-628462308), y.ݬֲ֮ܲت(1512534047) + playerId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void savePlayerRewardData(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        PreferenceUtil.setString(context, y.ݮڮֲڭܩ(-628462308), y.ݮڮֲڭܩ(-628461972) + playerId, y.دײܮڳܯ(2051939573));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isPlayerReward(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        return StringsKt.equals(PreferenceUtil.getString(context, y.ݮڮֲڭܩ(-628462308), y.ݮڮֲڭܩ(-628461972) + playerId, y.ٲٴݴ״ٰ(1781635312)), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removePlayerRewardData(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        PreferenceUtil.removeKey(context, y.ݮڮֲڭܩ(-628462308), y.ݮڮֲڭܩ(-628461972) + playerId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void savePlayerInvitationCount(Context context, String playerId, long count) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        PreferenceUtil.setLong(context, y.ݮڮֲڭܩ(-628462308), y.֬ڱܱײٮ(-1158805983) + playerId, count);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final long loadPlayerInvitationCount(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        return PreferenceUtil.getLong(context, y.ݮڮֲڭܩ(-628462308), y.֬ڱܱײٮ(-1158805983) + playerId, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void saveInvitationSeq(Context context, String playerId, long seq) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        PreferenceUtil.setLong(context, y.ݮڮֲڭܩ(-628462308), y.֬ڱܱײٮ(-1158805591) + playerId, seq);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final long loadInvitationSeq(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        return PreferenceUtil.getLong(context, y.ݮڮֲڭܩ(-628462308), y.֬ڱܱײٮ(-1158805591) + playerId, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removePlayerInvitationCount(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        PreferenceUtil.removeKey(context, y.ݮڮֲڭܩ(-628462308), y.֬ڱܱײٮ(-1158805983) + playerId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void saveRewardRequest(Context context, String playerId, ServerRequest request) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        String str = y.ݮڮֲڭܩ(-628465492);
        String str2 = y.ݮڮֲڭܩ(-628462308);
        String string = PreferenceUtil.getString(context, str2, str + playerId);
        if (TextUtils.isEmpty(string)) {
            PreferenceUtil.setString(context, str2, str + playerId, request.toString());
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(y.٬ݯح׭٩(576557382));
        stringBuffer.append(request.toString());
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
        PreferenceUtil.setString(context, str2, str + playerId, stringBuffer2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void saveRewardRequests(Context context, String playerId, List<ServerRequest> requests) {
        String str;
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        Intrinsics.checkNotNullParameter(requests, y.ٴسسݬߨ(1393448394));
        String str2 = y.ݮڮֲڭܩ(-628465492);
        String str3 = y.ݮڮֲڭܩ(-628462308);
        String string = PreferenceUtil.getString(context, str3, str2 + playerId);
        StringBuffer stringBuffer = new StringBuffer();
        int size = requests.size();
        int i = 0;
        while (true) {
            str = y.٬ݯح׭٩(576557382);
            if (i >= size) {
                break;
            }
            stringBuffer.append(String.valueOf(requests.get(i)));
            if (i < requests.size() - 1) {
                stringBuffer.append(str);
            }
            i++;
        }
        boolean isEmpty = TextUtils.isEmpty(string);
        String str4 = y.ٲٴݴ״ٰ(1781855688);
        if (isEmpty) {
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, str4);
            PreferenceUtil.setString(context, str3, str2 + playerId, stringBuffer2);
            return;
        }
        stringBuffer.append(string);
        stringBuffer.append(str);
        stringBuffer.append(stringBuffer.toString());
        String stringBuffer3 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer3, str4);
        PreferenceUtil.setString(context, str3, str2 + playerId, stringBuffer3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<ServerRequest> loadRewardRequest(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        String str = y.ݮڮֲڭܩ(-628465492);
        String str2 = y.ݮڮֲڭܩ(-628462308);
        String string = PreferenceUtil.getString(context, str2, str + playerId);
        String str3 = string;
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(string);
        for (String str4 : (String[]) new Regex(y.֬ڱܱײٮ(-1158805383)).split(str3, 0).toArray(new String[0])) {
            ServerRequest parse = ServerRequest.INSTANCE.parse(str4);
            if (parse == null) {
                parse = null;
            }
            if (parse != null) {
                arrayList.add(parse);
            }
        }
        PreferenceUtil.removeKey(context, str2, str + playerId);
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removeRewardReqeust(Context context, String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        PreferenceUtil.removeKey(context, y.ݮڮֲڭܩ(-628462308), y.ݮڮֲڭܩ(-628465492) + playerId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void logout(Activity activity, String playerId) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        Activity activity2 = activity;
        removeReferrer(activity2);
        removePlayerInvitationCount(activity2, playerId);
        removePlayerRewardData(activity2, playerId);
        removePlayerInvitationReferrer(activity2, playerId);
        removeRewardReqeust(activity2, playerId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void removeUserInvitationData(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        INSTANCE.logout(activity, CoreManager.INSTANCE.getInstance().getPlayerId());
        PromotionService.removeUserInvitationData();
    }
}
