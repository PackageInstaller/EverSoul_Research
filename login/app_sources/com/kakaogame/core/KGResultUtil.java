package com.kakaogame.core;

import android.util.Log;
import com.kakaogame.KGResult;
import com.kakaogame.log.APILogManager;

/* loaded from: classes3.dex */
public class KGResultUtil {
    private static final String TAG = "KGResultUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeClientApiCall(String str, KGResult<?> kGResult, long j) {
        if (kGResult != null) {
            APILogManager.writeClientApiCall(str, KGResult.getResult(kGResult), j);
        } else {
            Log.e(TAG, "writeClientApiCall is called with null result: " + str);
        }
    }
}
