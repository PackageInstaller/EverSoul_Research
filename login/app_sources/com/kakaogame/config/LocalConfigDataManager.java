package com.kakaogame.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.kakaogame.Logger;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.PreferenceUtil;
import com.liapp.y;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: LocalConfigDataManager.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\"\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, m839d2 = {"Lcom/kakaogame/config/LocalConfigDataManager;", "", "()V", "DEBUG_LEVEL_KEY", "", "MARKET_KEY", "NAME", "SERVER_TYPE_KEY", "TAG", "ivBytes", "", "getIvBytes", "()[B", "setIvBytes", "([B)V", "decode", "str", "secretKey", "decryptConfig", "context", "Landroid/content/Context;", "localConfig", "t", "getLocalDebugLevel", "getLocalMarket", "getLocalServerType", "removeLocalConfigData", "", "saveLocalConfigData", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LocalConfigDataManager {
    private static final String DEBUG_LEVEL_KEY = "debugLevel";
    private static final String MARKET_KEY = "market";
    private static final String NAME = "LocalConfigData";
    private static final String SERVER_TYPE_KEY = "serverType";
    private static final String TAG = "LocalConfigDataManager";
    public static final LocalConfigDataManager INSTANCE = new LocalConfigDataManager();
    private static byte[] ivBytes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LocalConfigDataManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] getIvBytes() {
        return ivBytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setIvBytes(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, y.ٴسسݬߨ(1392633402));
        ivBytes = bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean saveLocalConfigData(Context context, String localConfig, String t) {
        boolean z;
        String str = y.ݮڮֲڭܩ(-628493556);
        String str2 = y.ݬֲ֮ܲت(1512366615);
        String str3 = y.دײܮڳܯ(2051758173);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(localConfig, y.֬ڱܱײٮ(-1158832143));
        Long valueOf = Long.valueOf(t);
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNull(valueOf);
        if (currentTimeMillis - valueOf.longValue() > 180000) {
            return false;
        }
        Logger logger = Logger.INSTANCE;
        String str4 = y.دײܮڳܯ(2051326277) + localConfig;
        String str5 = y.ٴسسݬߨ(1393411058);
        logger.m699d(str5, str4);
        Log.d(str5, y.ٲٴݴ״ٰ(1782104952) + DeviceUtil.getWhiteKey(context));
        String decryptConfig = INSTANCE.decryptConfig(context, localConfig, t);
        Logger.INSTANCE.m699d(str5, y.ݮڮֲڭܩ(-628496140) + decryptConfig);
        if (decryptConfig == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(decryptConfig);
            String optString = jSONObject.optString(str3, null);
            boolean isEmpty = TextUtils.isEmpty(optString);
            String str6 = y.ٲٴݴ״ٰ(1782111568);
            if (isEmpty) {
                z = false;
            } else {
                Intrinsics.checkNotNull(optString);
                PreferenceUtil.setString(context, str6, str3, optString);
                z = true;
            }
            String optString2 = jSONObject.optString(str2, null);
            if (!TextUtils.isEmpty(optString2)) {
                Intrinsics.checkNotNull(optString2);
                PreferenceUtil.setString(context, str6, str2, optString2);
                z = true;
            }
            String optString3 = jSONObject.optString(str, null);
            if (TextUtils.isEmpty(optString3)) {
                return z;
            }
            Intrinsics.checkNotNull(optString3);
            PreferenceUtil.setString(context, str6, str, optString3);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String decryptConfig(Context context, String localConfig, String t) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(localConfig, y.֬ڱܱײٮ(-1158832143));
        int longValue = (int) (Long.valueOf(t).longValue() % Calendar.getInstance().get(5));
        String str = DeviceUtil.getWhiteKey(context) + context.getPackageName();
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = 1 <= longValue && longValue < str.length();
        String str2 = y.٬ݯح׭٩(576592158);
        if (z) {
            String substring = str.substring(0, longValue - 1);
            Intrinsics.checkNotNullExpressionValue(substring, str2);
            stringBuffer.append(substring);
            String substring2 = str.substring(longValue);
            Intrinsics.checkNotNullExpressionValue(substring2, str2);
            stringBuffer.append(substring2);
        } else {
            stringBuffer.append(str);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        String substring3 = stringBuffer2.substring(0, 32);
        Intrinsics.checkNotNullExpressionValue(substring3, str2);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ٲٴݴ״ٰ(1782104760) + substring3;
        String str4 = y.ٴسسݬߨ(1393411058);
        logger.m699d(str4, str3);
        try {
            return decode(localConfig, substring3);
        } catch (Exception e) {
            Logger.INSTANCE.m701e(str4, y.ٴسسݬߨ(1393417658) + e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void removeLocalConfigData(Context context) {
        PreferenceUtil.remove(context, y.ٲٴݴ״ٰ(1782111568));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLocalMarket(Context context) {
        String string = PreferenceUtil.getString(context, y.ٲٴݴ״ٰ(1782111568), y.دײܮڳܯ(2051758173));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLocalServerType(Context context) {
        String string = PreferenceUtil.getString(context, y.ٲٴݴ״ٰ(1782111568), y.ݬֲ֮ܲت(1512366615));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLocalDebugLevel(Context context) {
        String string = PreferenceUtil.getString(context, y.ٲٴݴ״ٰ(1782111568), y.ݮڮֲڭܩ(-628493556));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String decode(String str, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] decode = Base64.decode(str, 0);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
        byte[] bytes = secretKey.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, y.ٴسسݬߨ(1393410554));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, y.ۮڭڭܬި(862563115));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        byte[] doFinal = cipher.doFinal(decode);
        Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
        return new String(doFinal, Charsets.UTF_8);
    }
}
