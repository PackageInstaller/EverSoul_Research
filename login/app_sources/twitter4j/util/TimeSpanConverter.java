package twitter4j.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.liapp.y;
import java.io.Serializable;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class TimeSpanConverter implements Serializable {
    private static final int AN_HOUR_AGO = 4;
    private static final int A_MINUTE_AGO = 2;
    private static final int NOW = 0;
    private static final int N_HOURS_AGO = 5;
    private static final int N_MINUTES_AGO = 3;
    private static final int N_SECONDS_AGO = 1;
    private static final int ONE_DAY_IN_SECONDS = 86400;
    private static final int ONE_HOUR_IN_SECONDS = 3600;
    private static final int ONE_MONTH_IN_SECONDS = 2592000;
    private static final long serialVersionUID = 8665013607650804076L;
    private final SimpleDateFormat dateMonth;
    private final SimpleDateFormat dateMonthYear;
    private final MessageFormat[] formats;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TimeSpanConverter() {
        this(Locale.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TimeSpanConverter(Locale locale) {
        MessageFormat[] messageFormatArr = new MessageFormat[6];
        this.formats = messageFormatArr;
        String language = locale.getLanguage();
        boolean equals = y.ٲٴݴ״ٰ(1782134480).equals(language);
        String str = y.ۮڭڭܬި(863074003);
        String str2 = y.֬ڱܱײٮ(-1158331015);
        String str3 = y.ٴسسݬߨ(1393891530);
        if (equals) {
            messageFormatArr[0] = new MessageFormat(y.ۮڭڭܬި(863072763));
            messageFormatArr[1] = new MessageFormat(y.ݮڮֲڭܩ(-628020060));
            messageFormatArr[2] = new MessageFormat(y.ٴسسݬߨ(1393891626));
            messageFormatArr[3] = new MessageFormat(y.ݬֲ֮ܲت(1513894471));
            messageFormatArr[4] = new MessageFormat(y.ٴسسݬߨ(1393891850));
            messageFormatArr[5] = new MessageFormat(str);
            this.dateMonth = new SimpleDateFormat(str3, locale);
            this.dateMonthYear = new SimpleDateFormat(str2, locale);
            return;
        }
        if (y.ٴسسݬߨ(1393410210).equals(language)) {
            messageFormatArr[0] = new MessageFormat("지금");
            messageFormatArr[1] = new MessageFormat("{0}초 전");
            messageFormatArr[2] = new MessageFormat("1분 전");
            messageFormatArr[3] = new MessageFormat("{0}분 전");
            messageFormatArr[4] = new MessageFormat("1시간 전");
            messageFormatArr[5] = new MessageFormat(str);
            this.dateMonth = new SimpleDateFormat("M월 d일", locale);
            this.dateMonthYear = new SimpleDateFormat("yy년 M월 d일", locale);
            return;
        }
        if (y.ݬֲ֮ܲت(1513894207).equals(language)) {
            messageFormatArr[0] = new MessageFormat(y.٬ݯح׭٩(575069942));
            messageFormatArr[1] = new MessageFormat(y.ۮڭڭܬި(863073227));
            messageFormatArr[2] = new MessageFormat(y.دײܮڳܯ(2052856293));
            messageFormatArr[3] = new MessageFormat(y.ٲٴݴ״ٰ(1780484888));
            messageFormatArr[4] = new MessageFormat(y.ݮڮֲڭܩ(-628023092));
            messageFormatArr[5] = new MessageFormat(y.֬ڱܱײٮ(-1158330311));
            this.dateMonth = new SimpleDateFormat(str3, locale);
            this.dateMonthYear = new SimpleDateFormat(str2, locale);
            return;
        }
        if (y.دײܮڳܯ(2052855797).equals(language)) {
            messageFormatArr[0] = new MessageFormat(y.٬ݯح׭٩(575066518));
            messageFormatArr[1] = new MessageFormat(y.֬ڱܱײٮ(-1158329543));
            messageFormatArr[2] = new MessageFormat(y.ݬֲ֮ܲت(1513897271));
            messageFormatArr[3] = new MessageFormat(y.֬ڱܱײٮ(-1158329847));
            messageFormatArr[4] = new MessageFormat(y.دײܮڳܯ(2052855205));
            messageFormatArr[5] = new MessageFormat(y.ٲٴݴ״ٰ(1780485952));
            this.dateMonth = new SimpleDateFormat(str3, locale);
            this.dateMonthYear = new SimpleDateFormat(str2, locale);
            return;
        }
        if (y.ۮڭڭܬި(863074779).equals(language)) {
            messageFormatArr[0] = new MessageFormat(y.٬ݯح׭٩(575067454));
            messageFormatArr[1] = new MessageFormat(y.٬ݯح׭٩(575067510));
            messageFormatArr[2] = new MessageFormat(y.ݬֲ֮ܲت(1513896527));
            messageFormatArr[3] = new MessageFormat(y.ݮڮֲڭܩ(-628021740));
            messageFormatArr[4] = new MessageFormat(y.ݬֲ֮ܲت(1513896279));
            messageFormatArr[5] = new MessageFormat(y.ۮڭڭܬި(863074827));
            this.dateMonth = new SimpleDateFormat(str3, locale);
            this.dateMonthYear = new SimpleDateFormat(str2, locale);
            return;
        }
        if (y.ݮڮֲڭܩ(-628777260).equals(language)) {
            messageFormatArr[0] = new MessageFormat("今");
            messageFormatArr[1] = new MessageFormat("{0}秒前");
            messageFormatArr[2] = new MessageFormat("1分前");
            messageFormatArr[3] = new MessageFormat("{0}分前");
            messageFormatArr[4] = new MessageFormat("1時間前");
            messageFormatArr[5] = new MessageFormat("{0}時間前");
            this.dateMonth = new SimpleDateFormat("M月d日", locale);
            this.dateMonthYear = new SimpleDateFormat("yy年M月d日", locale);
            return;
        }
        messageFormatArr[0] = new MessageFormat(y.ٲٴݴ״ٰ(1780485328));
        messageFormatArr[1] = new MessageFormat(y.٬ݯح׭٩(575068126));
        messageFormatArr[2] = new MessageFormat(y.٬ݯح׭٩(575055942));
        messageFormatArr[3] = new MessageFormat(y.ٴسسݬߨ(1393913018));
        messageFormatArr[4] = new MessageFormat(y.ٲٴݴ״ٰ(1780511352));
        messageFormatArr[5] = new MessageFormat(y.ٴسسݬߨ(1393913234));
        this.dateMonth = new SimpleDateFormat(str3, Locale.ENGLISH);
        this.dateMonthYear = new SimpleDateFormat(str2, Locale.ENGLISH);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toTimeSpanString(Date date) {
        return toTimeSpanString(date.getTime());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toTimeSpanString(long j) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() - j) / 1000);
        if (currentTimeMillis < ONE_DAY_IN_SECONDS) {
            return toTimeSpanString(currentTimeMillis);
        }
        if (currentTimeMillis >= ONE_MONTH_IN_SECONDS) {
            return this.dateMonthYear.format(new Date(j));
        }
        return this.dateMonth.format(new Date(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String toTimeSpanString(int i) {
        if (i <= 1) {
            return this.formats[0].format(null);
        }
        if (i < 60) {
            return this.formats[1].format(new Object[]{Integer.valueOf(i)});
        }
        if (i < 2700) {
            int i2 = i / 60;
            return i2 == 1 ? this.formats[2].format(null) : this.formats[3].format(new Object[]{Integer.valueOf(i2)});
        }
        if (i < 6300) {
            return this.formats[4].format(null);
        }
        return this.formats[5].format(new Object[]{Integer.valueOf((i + TypedValues.Custom.TYPE_INT) / ONE_HOUR_IN_SECONDS)});
    }
}
