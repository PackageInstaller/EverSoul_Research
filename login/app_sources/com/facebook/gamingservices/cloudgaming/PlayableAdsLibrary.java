package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PlayableAdsLibrary {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void openAppStore(Context context, JSONObject parameters, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, parameters, callback, SDKMessageEnum.OPEN_APP_STORE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void markGameLoaded(Context context, JSONObject parameters, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, parameters, callback, SDKMessageEnum.MARK_GAME_LOADED);
    }
}
