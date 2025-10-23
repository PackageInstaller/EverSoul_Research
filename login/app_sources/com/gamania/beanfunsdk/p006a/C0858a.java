package com.gamania.beanfunsdk.p006a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.gamania.beanfunsdk.api.AppDefine;
import com.gamania.beanfunsdk.util.EncodeUtil;

/* renamed from: com.gamania.beanfunsdk.a.a */
/* loaded from: classes.dex */
public class C0858a {

    /* renamed from: a */
    private static String f191a = "access_token";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static void m72a(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(AppDefine.SHAREDPREFERENCES_NAME, 0).edit();
        edit.clear();
        edit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static boolean m73a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppDefine.SHAREDPREFERENCES_NAME, 0);
        if (sharedPreferences == null || TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(f191a, EncodeUtil.encodeData(EncodeUtil.genProductKey(AppDefine.BEANFUN), AppDefine.AES_IV, str));
        return edit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static String m74b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppDefine.SHAREDPREFERENCES_NAME, 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(f191a, "");
            if (!TextUtils.isEmpty(string)) {
                return EncodeUtil.decodeData(EncodeUtil.genProductKey(AppDefine.BEANFUN), AppDefine.AES_IV, string);
            }
        }
        return "";
    }
}
