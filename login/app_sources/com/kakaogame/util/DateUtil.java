package com.kakaogame.util;

import android.text.TextUtils;
import com.kakaogame.Logger;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DateUtil.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/util/DateUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "convertLongToFormattedString", Base2ndPWViewData.KEY_TIME, "", "convertString14ToDate", "Ljava/util/Date;", "dateString", "convertStringToDate", "datePattern", "currentDateToString", "format", "parseRFC3339Date", "datestring", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DateUtil {
    public static final DateUtil INSTANCE = new DateUtil();
    private static String TAG = y.دײܮڳܯ(2051038253);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DateUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTAG() {
        return TAG;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTAG(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        TAG = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date convertString14ToDate(String dateString) {
        Intrinsics.checkNotNullParameter(dateString, y.ٴسسݬߨ(1393123178));
        Logger.INSTANCE.m699d(TAG, y.ٴسسݬߨ(1393123274) + dateString);
        return convertStringToDate(dateString, y.ۮڭڭܬި(862795651));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date convertStringToDate(String dateString, String datePattern) {
        Intrinsics.checkNotNullParameter(dateString, y.ٴسسݬߨ(1393123178));
        Intrinsics.checkNotNullParameter(datePattern, y.٬ݯح׭٩(576363630));
        Logger.INSTANCE.m699d(TAG, y.ݮڮֲڭܩ(-628265836) + dateString + y.ݮڮֲڭܩ(-628756788) + datePattern);
        if (TextUtils.isEmpty(dateString) || TextUtils.isEmpty(datePattern) || dateString.length() != datePattern.length()) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            Logger.INSTANCE.m702e(TAG, y.ݮڮֲڭܩ(-628265684), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String convertLongToFormattedString(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(y.ۮڭڭܬި(862795651), Locale.KOREA);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return simpleDateFormat.format(calendar.getTime()).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String currentDateToString(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format2 = simpleDateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format2, y.ٲٴݴ״ٰ(1782078816));
        return format2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date parseRFC3339Date(String datestring) throws ParseException, IndexOutOfBoundsException {
        Intrinsics.checkNotNullParameter(datestring, y.٬ݯح׭٩(576364038));
        new Date();
        boolean endsWith$default = StringsKt.endsWith$default(datestring, y.֬ڱܱײٮ(-1159246623), false, 2, (Object) null);
        String str = y.֬ڱܱײٮ(-1159133271);
        String str2 = y.٬ݯح׭٩(576364462);
        String str3 = y.٬ݯح׭٩(576360542);
        if (endsWith$default) {
            try {
                Date parse = new SimpleDateFormat(str2).parse(datestring);
                Intrinsics.checkNotNullExpressionValue(parse, str3);
                return parse;
            } catch (ParseException unused) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
                simpleDateFormat.setLenient(true);
                Date parse2 = simpleDateFormat.parse(datestring);
                Intrinsics.checkNotNullExpressionValue(parse2, str3);
                return parse2;
            }
        }
        String str4 = datestring;
        if (StringsKt.lastIndexOf$default((CharSequence) str4, '-', 0, false, 6, (Object) null) > -1) {
            String substring = datestring.substring(0, StringsKt.lastIndexOf$default((CharSequence) str4, '-', 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = datestring.substring(StringsKt.lastIndexOf$default((CharSequence) str4, '-', 0, false, 6, (Object) null));
            String str5 = y.ٲٴݴ״ٰ(1782336472);
            Intrinsics.checkNotNullExpressionValue(substring2, str5);
            String str6 = substring2;
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str6, ':', 0, false, 6, (Object) null);
            if (indexOf$default > -1 && indexOf$default + 1 < substring2.length()) {
                StringBuilder sb = new StringBuilder();
                String substring3 = substring2.substring(0, StringsKt.indexOf$default((CharSequence) str6, ':', 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                StringBuilder append = sb.append(substring3);
                String substring4 = substring2.substring(StringsKt.indexOf$default((CharSequence) str6, ':', 0, false, 6, (Object) null) + 1);
                Intrinsics.checkNotNullExpressionValue(substring4, str5);
                substring2 = append.append(substring4).toString();
            }
            String str7 = substring + substring2;
            try {
                Date parse3 = new SimpleDateFormat(y.ݮڮֲڭܩ(-628268540)).parse(str7);
                Intrinsics.checkNotNullExpressionValue(parse3, str3);
                return parse3;
            } catch (ParseException unused2) {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(y.ٲٴݴ״ٰ(1782335488));
                simpleDateFormat2.setLenient(true);
                Date parse4 = simpleDateFormat2.parse(str7);
                Intrinsics.checkNotNullExpressionValue(parse4, str3);
                return parse4;
            }
        }
        try {
            Date parse5 = new SimpleDateFormat(str2).parse(datestring);
            Intrinsics.checkNotNullExpressionValue(parse5, str3);
            return parse5;
        } catch (ParseException unused3) {
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(str);
            simpleDateFormat3.setLenient(true);
            Date parse6 = simpleDateFormat3.parse(datestring);
            Intrinsics.checkNotNullExpressionValue(parse6, str3);
            return parse6;
        }
    }
}
