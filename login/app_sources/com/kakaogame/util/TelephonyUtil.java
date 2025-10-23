package com.kakaogame.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.liapp.y;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TelephonyUtil.kt */
@Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/util/TelephonyUtil;", "", "()V", "NETWORK_TYPE_CELLULAR", "", "NETWORK_TYPE_NETWORK", "NETWORK_TYPE_UNKNOWN", "TAG", "UNKNOWN_COUNTRY_CODE", "getMCC", "context", "Landroid/content/Context;", "getMNC", "getNetworkCountryCode", "getNetworkOperatorName", "getPhoneNumber", "getSimCountryIso", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TelephonyUtil {
    public static final TelephonyUtil INSTANCE = new TelephonyUtil();
    public static final String NETWORK_TYPE_CELLULAR = "cellular";
    public static final String NETWORK_TYPE_NETWORK = "wifi";
    public static final String NETWORK_TYPE_UNKNOWN = "unknown";
    private static final String TAG = "TelephonyUtil";
    public static final String UNKNOWN_COUNTRY_CODE = "zz";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TelephonyUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPhoneNumber(Context context) {
        if (context == null) {
            return "";
        }
        Object systemService = context.getSystemService(y.ۮڭڭܬި(862007203));
        Intrinsics.checkNotNull(systemService, y.دײܮڳܯ(2051250517));
        String line1Number = ((TelephonyManager) systemService).getLine1Number();
        return line1Number == null ? "" : line1Number;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getNetworkOperatorName(Context context) {
        String str = y.٬ݯح׭٩(576288310);
        if (context == null) {
            return str;
        }
        Object systemService = context.getSystemService(y.ۮڭڭܬި(862007203));
        Intrinsics.checkNotNull(systemService, y.دײܮڳܯ(2051250517));
        String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
        String str2 = networkOperatorName;
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        Intrinsics.checkNotNull(networkOperatorName);
        return networkOperatorName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNetworkCountryCode(Context context) {
        String lowerCase;
        String str = y.ٴسسݬߨ(1393410370);
        if (context == null) {
            return str;
        }
        Object systemService = context.getSystemService(y.ۮڭڭܬި(862007203));
        Intrinsics.checkNotNull(systemService, y.دײܮڳܯ(2051250517));
        String networkCountryIso = ((TelephonyManager) systemService).getNetworkCountryIso();
        String str2 = networkCountryIso;
        if (str2 == null || str2.length() == 0) {
            lowerCase = str;
        } else {
            Intrinsics.checkNotNull(networkCountryIso);
            lowerCase = networkCountryIso.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, y.֬ڱܱײٮ(-1159086455));
        }
        return lowerCase == null ? str : lowerCase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getMCC(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService(y.ۮڭڭܬި(862007203));
        Intrinsics.checkNotNull(systemService, y.دײܮڳܯ(2051250517));
        String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
        if (networkOperator == null) {
            return null;
        }
        if (!(networkOperator.length() > 0)) {
            return null;
        }
        try {
            String substring = networkOperator.substring(0, 3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getMNC(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService(y.ۮڭڭܬި(862007203));
        Intrinsics.checkNotNull(systemService, y.دײܮڳܯ(2051250517));
        String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
        if (networkOperator == null) {
            return null;
        }
        if (!(networkOperator.length() > 0)) {
            return null;
        }
        try {
            String substring = networkOperator.substring(3, 5);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String getSimCountryIso(android.content.Context r2) {
        /*
            r0 = 1393410370(0x530dc142, float:6.088327E11)
            java.lang.String r0 = com.liapp.y.ٴسسݬߨ(r0)
            if (r2 != 0) goto La
            return r0
        La:
            r1 = 862007203(0x33612fa3, float:5.243022E-8)
            java.lang.String r1 = com.liapp.y.ۮڭڭܬި(r1)
            java.lang.Object r2 = r2.getSystemService(r1)
            r1 = 2051250517(0x7a439955, float:2.5390196E35)
            java.lang.String r1 = com.liapp.y.دײܮڳܯ(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            java.lang.String r2 = r2.getSimCountryIso()
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L33
            int r1 = r1.length()
            if (r1 != 0) goto L31
            goto L33
        L31:
            r1 = 0
            goto L34
        L33:
            r1 = 1
        L34:
            if (r1 == 0) goto L38
        L36:
            r2 = r0
            goto L54
        L38:
            com.kakaogame.util.ISOUtil r1 = com.kakaogame.util.ISOUtil.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r1 = r1.isValidISOCountry(r2)
            if (r1 != 0) goto L44
            goto L36
        L44:
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toLowerCase(r1)
            r1 = -1159086455(0xffffffffbae9be89, float:-0.0017833273)
            java.lang.String r1 = com.liapp.y.֬ڱܱײٮ(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
        L54:
            if (r2 != 0) goto L57
            goto L58
        L57:
            r0 = r2
        L58:
            return r0
            fill-array 0x005a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.util.TelephonyUtil.getSimCountryIso(android.content.Context):java.lang.String");
    }
}
