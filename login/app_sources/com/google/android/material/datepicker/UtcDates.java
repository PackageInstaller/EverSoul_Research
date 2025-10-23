package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.google.android.material.C0903R;
import com.kakaogame.auth.agreement.AgreementService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
class UtcDates {
    static final String UTC = "UTC";
    static AtomicReference<TimeSource> timeSourceRef = new AtomicReference<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void setTimeSource(TimeSource timeSource) {
        timeSourceRef.set(timeSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static TimeSource getTimeSource() {
        TimeSource timeSource = timeSourceRef.get();
        return timeSource == null ? TimeSource.system() : timeSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UtcDates() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static TimeZone getTimeZone() {
        return TimeZone.getTimeZone(UTC);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        return android.icu.util.TimeZone.getTimeZone(UTC);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Calendar getTodayCalendar() {
        Calendar now = getTimeSource().now();
        now.set(11, 0);
        now.set(12, 0);
        now.set(13, 0);
        now.set(14, 0);
        now.setTimeZone(getTimeZone());
        return now;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Calendar getUtcCalendar() {
        return getUtcCalendarOf(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Calendar getUtcCalendarOf(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(getTimeZone());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Calendar getDayCopy(Calendar calendar) {
        Calendar utcCalendarOf = getUtcCalendarOf(calendar);
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
        return utcCalendar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long canonicalYearMonthDay(long j) {
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return getDayCopy(utcCalendar).getTimeInMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static DateFormat getAndroidFormat(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(getUtcAndroidTimeZone());
        return instanceForSkeleton;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.text.DateFormat getFormat(int i, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(getTimeZone());
        return dateInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static SimpleDateFormat getTextInputFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(getTimeZone());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getTextInputHint(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(C0903R.string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(C0903R.string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(C0903R.string.mtrl_picker_text_input_day_abbr);
        if (pattern.replaceAll("[^y]", "").length() == 1) {
            pattern = pattern.replace(AgreementService.VALUE_YES, "yyyy");
        }
        return pattern.replace("d", string3).replace("M", string2).replace(AgreementService.VALUE_YES, string);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static SimpleDateFormat getSimpleFormat(String str) {
        return getSimpleFormat(str, Locale.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static SimpleDateFormat getSimpleFormat(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static DateFormat getYearAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("yMMMd", locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static DateFormat getAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("MMMd", locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static DateFormat getAbbrMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("MMMEd", locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static DateFormat getYearAbbrMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("yMMMEd", locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static java.text.DateFormat getMediumFormat() {
        return getMediumFormat(Locale.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static java.text.DateFormat getMediumFormat(Locale locale) {
        return getFormat(2, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static java.text.DateFormat getMediumNoYear() {
        return getMediumNoYear(Locale.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static java.text.DateFormat getMediumNoYear(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) getMediumFormat(locale);
        simpleDateFormat.applyPattern(removeYearFromDateFormatPattern(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static java.text.DateFormat getFullFormat() {
        return getFullFormat(Locale.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static java.text.DateFormat getFullFormat(Locale locale) {
        return getFormat(0, locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String removeYearFromDateFormatPattern(String str) {
        int findCharactersInDateFormatPattern = findCharactersInDateFormatPattern(str, "yY", 1, 0);
        if (findCharactersInDateFormatPattern >= str.length()) {
            return str;
        }
        int findCharactersInDateFormatPattern2 = findCharactersInDateFormatPattern(str, "EMd", 1, findCharactersInDateFormatPattern);
        return str.replace(str.substring(findCharactersInDateFormatPattern(str, findCharactersInDateFormatPattern2 < str.length() ? "EMd," : "EMd", -1, findCharactersInDateFormatPattern) + 1, findCharactersInDateFormatPattern2), StringUtils.SPACE).trim();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int findCharactersInDateFormatPattern(String str, String str2, int i, int i2) {
        while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            if (str.charAt(i2) == '\'') {
                do {
                    i2 += i;
                    if (i2 >= 0 && i2 < str.length()) {
                    }
                } while (str.charAt(i2) != '\'');
            }
            i2 += i;
        }
        return i2;
    }
}
