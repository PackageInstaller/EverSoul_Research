package twitter4j;

import com.google.common.net.HttpHeaders;
import com.liapp.y;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public class TwitterException extends Exception implements TwitterResponse, HttpResponseCode {
    private static final String[] FILTER = {y.ݮڮֲڭܩ(-628048364)};
    private static final long serialVersionUID = 6006561839051121336L;
    private int errorCode;
    private String errorMessage;
    private ExceptionDiagnosis exceptionDiagnosis;
    private boolean nested;
    private HttpResponse response;
    private int statusCode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterException(String str, Throwable th) {
        super(str, th);
        this.statusCode = -1;
        this.errorCode = -1;
        this.exceptionDiagnosis = null;
        this.errorMessage = null;
        this.nested = false;
        decode(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterException(String str) {
        this(str, (Throwable) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterException(Exception exc) {
        this(exc.getMessage(), exc);
        if (exc instanceof TwitterException) {
            ((TwitterException) exc).setNested();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterException(String str, HttpResponse httpResponse) {
        this(str);
        this.response = httpResponse;
        this.statusCode = httpResponse.getStatusCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterException(String str, Exception exc, int i) {
        this(str, exc);
        this.statusCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        String str = this.errorMessage;
        String str2 = y.ٲٴݴ״ٰ(1781641888);
        if (str != null && this.errorCode != -1) {
            sb.append(y.ٴسسݬߨ(1393876786)).append(this.errorMessage).append(y.ۮڭڭܬި(863024891));
            sb.append(this.errorCode).append(str2);
        } else {
            sb.append(super.getMessage());
        }
        if (this.statusCode != -1) {
            return getCause(this.statusCode) + str2 + sb.toString();
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void decode(String str) {
        String str2 = y.ٴسسݬߨ(1393855170);
        if (str == null || !str.startsWith(y.֬ڱܱײٮ(-1159674159))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull(str2)) {
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONArray(str2).getJSONObject(0);
            this.errorMessage = jSONObject2.getString("message");
            this.errorCode = ParseUtil.getInt("code", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStatusCode() {
        return this.statusCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getErrorCode() {
        return this.errorCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getResponseHeader(String str) {
        HttpResponse httpResponse = this.response;
        if (httpResponse != null) {
            List<String> list = httpResponse.getResponseHeaderFields().get(str);
            if (list.size() > 0) {
                return list.get(0);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterResponse
    public RateLimitStatus getRateLimitStatus() {
        HttpResponse httpResponse = this.response;
        if (httpResponse == null) {
            return null;
        }
        return JSONImplFactory.createRateLimitStatusFromResponseHeader(httpResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterResponse
    public int getAccessLevel() {
        return ParseUtil.toAccessLevel(this.response);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getRetryAfter() {
        int i = this.statusCode;
        if (i == 400) {
            RateLimitStatus rateLimitStatus = getRateLimitStatus();
            if (rateLimitStatus != null) {
                return rateLimitStatus.getSecondsUntilReset();
            }
            return -1;
        }
        if (i != 420) {
            return -1;
        }
        try {
            String responseHeader = this.response.getResponseHeader(HttpHeaders.RETRY_AFTER);
            if (responseHeader != null) {
                return Integer.valueOf(responseHeader).intValue();
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCausedByNetworkIssue() {
        return getCause() instanceof IOException;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean exceededRateLimitation() {
        int i;
        return (this.statusCode == 400 && getRateLimitStatus() != null) || (i = this.statusCode) == 420 || i == 429;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean resourceNotFound() {
        return this.statusCode == 404;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getExceptionCode() {
        return getExceptionDiagnosis().asHexString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ExceptionDiagnosis getExceptionDiagnosis() {
        if (this.exceptionDiagnosis == null) {
            this.exceptionDiagnosis = new ExceptionDiagnosis(this, FILTER);
        }
        return this.exceptionDiagnosis;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setNested() {
        this.nested = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isErrorMessageAvailable() {
        return this.errorMessage != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TwitterException twitterException = (TwitterException) obj;
        if (this.errorCode != twitterException.errorCode || this.nested != twitterException.nested || this.statusCode != twitterException.statusCode) {
            return false;
        }
        String str = this.errorMessage;
        if (str == null ? twitterException.errorMessage != null : !str.equals(twitterException.errorMessage)) {
            return false;
        }
        ExceptionDiagnosis exceptionDiagnosis = this.exceptionDiagnosis;
        if (exceptionDiagnosis == null ? twitterException.exceptionDiagnosis != null : !exceptionDiagnosis.equals(twitterException.exceptionDiagnosis)) {
            return false;
        }
        HttpResponse httpResponse = this.response;
        HttpResponse httpResponse2 = twitterException.response;
        return httpResponse == null ? httpResponse2 == null : httpResponse.equals(httpResponse2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int i = ((this.statusCode * 31) + this.errorCode) * 31;
        ExceptionDiagnosis exceptionDiagnosis = this.exceptionDiagnosis;
        int hashCode = (i + (exceptionDiagnosis != null ? exceptionDiagnosis.hashCode() : 0)) * 31;
        HttpResponse httpResponse = this.response;
        int hashCode2 = (hashCode + (httpResponse != null ? httpResponse.hashCode() : 0)) * 31;
        String str = this.errorMessage;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + (this.nested ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String toString() {
        return getMessage() + (this.nested ? "" : y.ٲٴݴ״ٰ(1780598536) + getExceptionDiagnosis().getStackLineHashAsHex() + y.ٲٴݴ״ٰ(1780598240) + getExceptionDiagnosis().getLineNumberHashAsHex()) + y.ٲٴݴ״ٰ(1780599584) + (this.nested ? "" : y.ݬֲ֮ܲت(1514012495) + getExceptionCode() + y.ݬֲ֮ܲت(1513035735)) + y.ٲٴݴ״ٰ(1780599368) + this.statusCode + y.دײܮڳܯ(2051725725) + this.errorMessage + y.٬ݯح׭٩(575082998) + this.errorCode + y.֬ڱܱײٮ(-1158378703) + getRetryAfter() + y.ݬֲ֮ܲت(1514011935) + getRateLimitStatus() + y.ٴسسݬߨ(1393874810) + Version.getVersion() + '}';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getCause(int i) {
        String str;
        if (i == 304) {
            str = y.ۮڭڭܬި(863025003);
        } else if (i == 406) {
            str = y.ٲٴݴ״ٰ(1780601064);
        } else if (i == 420) {
            str = y.֬ڱܱײٮ(-1158370335);
        } else if (i == 422) {
            str = y.دײܮڳܯ(2052979685);
        } else if (i == 429) {
            str = y.ٴسسݬߨ(1393877842);
        } else if (i == 500) {
            str = y.دײܮڳܯ(2052973893);
        } else if (i == 400) {
            str = y.٬ݯح׭٩(575089206);
        } else if (i == 401) {
            str = y.٬ݯح׭٩(575099878);
        } else if (i == 403) {
            str = y.دײܮڳܯ(2052955637);
        } else if (i != 404) {
            switch (i) {
                case 502:
                    str = y.٬ݯح׭٩(575096118);
                    break;
                case 503:
                    str = y.ٲٴݴ״ٰ(1780586928);
                    break;
                case 504:
                    str = y.ݮڮֲڭܩ(-628048244);
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = y.٬ݯح׭٩(575096342);
        }
        return i + y.ݬֲ֮ܲت(1512942399) + str;
    }
}
