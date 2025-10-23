package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.p036authapiphone.zzr;
import com.google.android.gms.internal.p036authapiphone.zzv;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
/* loaded from: classes.dex */
public final class SmsCodeRetriever {
    public static final String EXTRA_SMS_CODE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_CODE";
    public static final String EXTRA_SMS_CODE_LINE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_CODE_LINE";
    public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";
    public static final String SMS_CODE_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_CODE_RETRIEVED";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SmsCodeRetriever() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SmsCodeAutofillClient getAutofillClient(Activity activity) {
        return new zzr(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SmsCodeBrowserClient getBrowserClient(Activity activity) {
        return new zzv(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SmsCodeAutofillClient getAutofillClient(Context context) {
        return new zzr(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SmsCodeBrowserClient getBrowserClient(Context context) {
        return new zzv(context);
    }
}
