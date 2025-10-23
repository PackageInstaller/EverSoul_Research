package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.qualityvalidation.Excuse;
import com.facebook.internal.qualityvalidation.ExcusesForDesignViolations;
import com.google.common.net.HttpHeaders;
import java.net.HttpURLConnection;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: FacebookRequestError.kt */
@Metadata(m838d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 @2\u00020\u0001:\u0003?@AB!\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rB\u000f\b\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010B\u0081\u0001\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\u000bH\u0016J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\tH\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b8F¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\"\u0010\u0004\u001a\u0004\u0018\u00010\u001c2\b\u00101\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)¨\u0006B"}, m839d2 = {"Lcom/facebook/FacebookRequestError;", "Landroid/os/Parcelable;", "connection", "Ljava/net/HttpURLConnection;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/net/HttpURLConnection;Ljava/lang/Exception;)V", "errorCode", "", "errorType", "", "errorMessage", "(ILjava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "requestStatusCode", "subErrorCode", "errorMessageField", "errorUserTitle", "errorUserMessage", "requestResultBody", "Lorg/json/JSONObject;", "requestResult", "batchRequestResult", "", "exceptionField", "Lcom/facebook/FacebookException;", "errorIsTransient", "", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Object;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;Z)V", "getBatchRequestResult", "()Ljava/lang/Object;", "category", "Lcom/facebook/FacebookRequestError$Category;", "getCategory", "()Lcom/facebook/FacebookRequestError$Category;", "getConnection", "()Ljava/net/HttpURLConnection;", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "errorRecoveryMessage", "getErrorRecoveryMessage", "getErrorType", "getErrorUserMessage", "getErrorUserTitle", "<set-?>", "getException", "()Lcom/facebook/FacebookException;", "getRequestResult", "()Lorg/json/JSONObject;", "getRequestResultBody", "getRequestStatusCode", "getSubErrorCode", "describeContents", "toString", "writeToParcel", "", "out", "flags", "Category", "Companion", HttpHeaders.RANGE, "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
@ExcusesForDesignViolations({@Excuse(reason = "Legacy migration", type = "KOTLIN_JVM_FIELD")})
/* loaded from: classes.dex */
public final class FacebookRequestError implements Parcelable {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Range HTTP_RANGE_SUCCESS = new Range(200, 299);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() { // from class: com.facebook.FacebookRequestError$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public FacebookRequestError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FacebookRequestError(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public FacebookRequestError[] newArray(int size) {
            return new FacebookRequestError[size];
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, str, str2, str3, str4, jSONObject, jSONObject2, obj, httpURLConnection, facebookException, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ FacebookRequestError(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        return INSTANCE.checkResponseAndCreateError(jSONObject, obj, httpURLConnection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final synchronized FacebookRequestErrorClassification getErrorClassification() {
        FacebookRequestErrorClassification errorClassification;
        synchronized (FacebookRequestError.class) {
            errorClassification = INSTANCE.getErrorClassification();
        }
        return errorClassification;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z) {
        boolean z2;
        Category classify;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorMessage = str2;
        if (facebookException != null) {
            this.exception = facebookException;
            z2 = true;
        } else {
            this.exception = new FacebookServiceException(this, getErrorMessage());
            z2 = false;
        }
        if (z2) {
            classify = Category.OTHER;
        } else {
            classify = INSTANCE.getErrorClassification().classify(i2, i3, z);
        }
        this.category = classify;
        this.errorRecoveryMessage = INSTANCE.getErrorClassification().getRecoveryMessage(classify);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getErrorType() {
        return this.errorType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    /* compiled from: FacebookRequestError.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m839d2 = {"Lcom/facebook/FacebookRequestError$Range;", "", "start", "", "end", "(II)V", "contains", "", "value", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Range {
        private final int end;
        private final int start;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean contains(int value) {
            return value <= this.end && this.start <= value;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        FacebookException facebookException = this.exception;
        if (facebookException == null) {
            return null;
        }
        return facebookException.getLocalizedMessage();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FacebookException getException() {
        return this.exception;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Category getCategory() {
        return this.category;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc), false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, null, null, null, null, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(\"{HttpStatus: \")\n        .append(requestStatusCode)\n        .append(\", errorCode: \")\n        .append(errorCode)\n        .append(\", subErrorCode: \")\n        .append(subErrorCode)\n        .append(\", errorType: \")\n        .append(errorType)\n        .append(\", errorMessage: \")\n        .append(errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.requestStatusCode);
        out.writeInt(this.errorCode);
        out.writeInt(this.subErrorCode);
        out.writeString(this.errorType);
        out.writeString(getErrorMessage());
        out.writeString(this.errorUserTitle);
        out.writeString(this.errorUserMessage);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), null, null, null, null, null, false);
    }

    /* compiled from: FacebookRequestError.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/facebook/FacebookRequestError$Category;", "", "(Ljava/lang/String;I)V", "LOGIN_RECOVERABLE", "OTHER", "TRANSIENT", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Category[] valuesCustom() {
            Category[] valuesCustom = values();
            return (Category[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* compiled from: FacebookRequestError.kt */
    @Metadata(m838d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, m839d2 = {"Lcom/facebook/FacebookRequestError$Companion;", "", "()V", "BODY_KEY", "", "CODE_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/FacebookRequestError;", "ERROR_CODE_FIELD_KEY", "ERROR_CODE_KEY", "ERROR_IS_TRANSIENT_KEY", "ERROR_KEY", "ERROR_MESSAGE_FIELD_KEY", "ERROR_MSG_KEY", "ERROR_REASON_KEY", "ERROR_SUB_CODE_KEY", "ERROR_TYPE_FIELD_KEY", "ERROR_USER_MSG_KEY", "ERROR_USER_TITLE_KEY", "HTTP_RANGE_SUCCESS", "Lcom/facebook/FacebookRequestError$Range;", "getHTTP_RANGE_SUCCESS$facebook_core_release", "()Lcom/facebook/FacebookRequestError$Range;", "INVALID_ERROR_CODE", "", "INVALID_HTTP_STATUS_CODE", "errorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "checkResponseAndCreateError", "singleResult", "Lorg/json/JSONObject;", "batchResult", "connection", "Ljava/net/HttpURLConnection;", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Range getHTTP_RANGE_SUCCESS$facebook_core_release() {
            return FacebookRequestError.HTTP_RANGE_SUCCESS;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00d3 A[Catch: JSONException -> 0x0136, TryCatch #0 {JSONException -> 0x0136, blocks: (B:3:0x0012, B:5:0x0018, B:7:0x0024, B:9:0x0028, B:12:0x0036, B:30:0x00d3, B:33:0x007b, B:34:0x0072, B:35:0x0068, B:36:0x0060, B:37:0x0059, B:38:0x004f, B:39:0x0045, B:40:0x0087, B:43:0x0094, B:45:0x009d, B:49:0x00ae, B:50:0x00f4, B:52:0x00fe, B:54:0x010c, B:55:0x011a, B:57:0x0116), top: B:2:0x0012 }] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.facebook.FacebookRequestError checkResponseAndCreateError(org.json.JSONObject r20, java.lang.Object r21, java.net.HttpURLConnection r22) {
            /*
                Method dump skipped, instructions count: 316
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.Companion.checkResponseAndCreateError(org.json.JSONObject, java.lang.Object, java.net.HttpURLConnection):com.facebook.FacebookRequestError");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final synchronized FacebookRequestErrorClassification getErrorClassification() {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                return FacebookRequestErrorClassification.INSTANCE.getDefaultErrorClassification();
            }
            return appSettingsWithoutQuery.getErrorClassification();
        }
    }
}
