package com.kakao.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.internal.NativeProtocol;
import com.kakao.sdk.common.model.AuthError;
import com.kakao.sdk.common.model.AuthErrorCause;
import com.kakao.sdk.common.model.AuthErrorResponse;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.p028v2.auth.C2245R;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TalkAuthCodeActivity.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, m839d2 = {"Lcom/kakao/sdk/auth/TalkAuthCodeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "APPLICATION_ERROR", "", "getAPPLICATION_ERROR", "()Ljava/lang/String;", "AUTH_CODE_ERROR", "getAUTH_CODE_ERROR", "CLIENT_INFO_ERROR", "getCLIENT_INFO_ERROR", "EXTRA_ERROR_DESCRIPTION", "getEXTRA_ERROR_DESCRIPTION", "EXTRA_ERROR_TYPE", "getEXTRA_ERROR_TYPE", "NOT_SUPPORT_ERROR", "getNOT_SUPPORT_ERROR", "PROTOCOL_ERROR", "getPROTOCOL_ERROR", "UNKNOWN_ERROR", "getUNKNOWN_ERROR", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "resultReceiver", "Landroid/os/ResultReceiver;", "activityResultCallback", "Landroidx/activity/result/ActivityResultCallback;", "Landroidx/activity/result/ActivityResult;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "sendError", "exception", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TalkAuthCodeActivity extends AppCompatActivity {
    private final String APPLICATION_ERROR;
    private final String AUTH_CODE_ERROR;
    private final String CLIENT_INFO_ERROR;
    private final String EXTRA_ERROR_DESCRIPTION;
    private final String EXTRA_ERROR_TYPE;
    private final String NOT_SUPPORT_ERROR;
    private final String PROTOCOL_ERROR;
    private final String UNKNOWN_ERROR;
    private final ActivityResultLauncher<Intent> activityResultLauncher;
    private ResultReceiver resultReceiver;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TalkAuthCodeActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), activityResultCallback());
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…ityResultCallback()\n    )");
        this.activityResultLauncher = registerForActivityResult;
        this.EXTRA_ERROR_TYPE = Constants.EXTRA_ERROR_TYPE;
        this.EXTRA_ERROR_DESCRIPTION = Constants.EXTRA_ERROR_DESCRIPTION;
        this.NOT_SUPPORT_ERROR = Constants.NOT_SUPPORT_ERROR;
        this.UNKNOWN_ERROR = NativeProtocol.ERROR_UNKNOWN_ERROR;
        this.PROTOCOL_ERROR = NativeProtocol.ERROR_PROTOCOL_ERROR;
        this.APPLICATION_ERROR = NativeProtocol.ERROR_APPLICATION_ERROR;
        this.AUTH_CODE_ERROR = "AuthCodeError";
        this.CLIENT_INFO_ERROR = "ClientInfoError";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        ResultReceiver resultReceiver;
        Intent intent;
        Bundle extras;
        y.٬خݮ۳ݯ(this);
        super.onCreate(savedInstanceState);
        setContentView(C2245R.layout.activity_talk_auth_code);
        try {
            Bundle extras2 = getIntent().getExtras();
            if (extras2 == null) {
                throw new IllegalArgumentException("no extras.");
            }
            Bundle bundle = extras2.getBundle(Constants.KEY_BUNDLE);
            if (bundle != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    resultReceiver = (ResultReceiver) bundle.getParcelable(Constants.KEY_RESULT_RECEIVER, ResultReceiver.class);
                } else {
                    Parcelable parcelable = bundle.getParcelable(Constants.KEY_RESULT_RECEIVER);
                    if (parcelable == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.os.ResultReceiver");
                    }
                    resultReceiver = (ResultReceiver) parcelable;
                }
                if (resultReceiver != null) {
                    this.resultReceiver = resultReceiver;
                } else {
                    throw new IllegalStateException();
                }
            }
            SdkLog.INSTANCE.m471i(Intrinsics.stringPlus("requestCode: ", Integer.valueOf(extras2.getInt(Constants.KEY_REQUEST_CODE))));
            if (Build.VERSION.SDK_INT >= 33) {
                intent = (Intent) extras2.getParcelable(Constants.KEY_LOGIN_INTENT, Intent.class);
            } else {
                intent = (Intent) extras2.getParcelable(Constants.KEY_LOGIN_INTENT);
            }
            SdkLog.INSTANCE.m471i("loginIntent:");
            if (intent != null && (extras = intent.getExtras()) != null) {
                SdkLog.INSTANCE.m471i(Intrinsics.stringPlus("\tcom.kakao.sdk.talk.appKey : ", extras.getString(Constants.EXTRA_APPLICATION_KEY)));
                SdkLog.INSTANCE.m471i(Intrinsics.stringPlus("\tcom.kakao.sdk.talk.redirectUri : ", extras.getString(Constants.EXTRA_REDIRECT_URI)));
                SdkLog.INSTANCE.m471i(Intrinsics.stringPlus("\tcom.kakao.sdk.talk.kaHeader : ", extras.getString(Constants.EXTRA_KA_HEADER)));
                Bundle bundle2 = extras.getBundle(Constants.EXTRA_EXTRAPARAMS);
                if (bundle2 != null) {
                    SdkLog.INSTANCE.m471i("\tcom.kakao.sdk.talk.extraparams");
                    Set<String> keySet = bundle2.keySet();
                    Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
                    Set<String> set = keySet;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                    for (String str : set) {
                        arrayList.add("\t\t" + ((Object) str) + " : " + ((Object) bundle2.getString(str)));
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        SdkLog.INSTANCE.m471i((String) it.next());
                    }
                }
            }
            this.activityResultLauncher.launch(intent);
        } catch (Throwable th) {
            SdkLog.INSTANCE.m470e(th);
            ClientError clientError = new ClientError(ClientErrorCause.Unknown, null, 2, null);
            clientError.initCause(th);
            sendError(clientError);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendError(KakaoSdkError exception) {
        ResultReceiver resultReceiver = this.resultReceiver;
        if (resultReceiver != null) {
            if (resultReceiver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultReceiver");
                resultReceiver = null;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.KEY_EXCEPTION, exception);
            Unit unit = Unit.INSTANCE;
            resultReceiver.send(0, bundle);
        }
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ActivityResultCallback<ActivityResult> activityResultCallback() {
        return new ActivityResultCallback() { // from class: com.kakao.sdk.auth.TalkAuthCodeActivity$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                TalkAuthCodeActivity.m1212activityResultCallback$lambda7(TalkAuthCodeActivity.this, (ActivityResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: activityResultCallback$lambda-7, reason: not valid java name */
    public static final void m1212activityResultCallback$lambda7(TalkAuthCodeActivity this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        ResultReceiver resultReceiver = null;
        if (activityResult.getData() == null || activityResult.getResultCode() == 0) {
            this$0.sendError(new ClientError(ClientErrorCause.Cancelled, null, 2, null));
            return;
        }
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Bundle extras = data == null ? null : data.getExtras();
            if (extras == null) {
                this$0.sendError(new ClientError(ClientErrorCause.Unknown, "No result from KakaoTalk."));
                return;
            }
            String string = extras.getString(this$0.EXTRA_ERROR_TYPE);
            String string2 = extras.getString(this$0.EXTRA_ERROR_DESCRIPTION);
            if (Intrinsics.areEqual(string, "access_denied")) {
                this$0.sendError(new ClientError(ClientErrorCause.Cancelled, null, 2, null));
                return;
            }
            if (string != null) {
                AuthErrorCause authErrorCause = (AuthErrorCause) KakaoJson.INSTANCE.fromJson(string, AuthErrorCause.class);
                if (authErrorCause == null) {
                    authErrorCause = AuthErrorCause.Unknown;
                }
                if (string2 == null) {
                    string2 = "no error description";
                }
                this$0.sendError(new AuthError(302, authErrorCause, new AuthErrorResponse(string, string2)));
                return;
            }
            bundle.putParcelable(Constants.KEY_URL, Uri.parse(extras.getString(Constants.EXTRA_REDIRECT_URL)));
            ResultReceiver resultReceiver2 = this$0.resultReceiver;
            if (resultReceiver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultReceiver");
            } else {
                resultReceiver = resultReceiver2;
            }
            resultReceiver.send(-1, bundle);
            this$0.finish();
            this$0.overridePendingTransition(0, 0);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEXTRA_ERROR_TYPE() {
        return this.EXTRA_ERROR_TYPE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEXTRA_ERROR_DESCRIPTION() {
        return this.EXTRA_ERROR_DESCRIPTION;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNOT_SUPPORT_ERROR() {
        return this.NOT_SUPPORT_ERROR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUNKNOWN_ERROR() {
        return this.UNKNOWN_ERROR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPROTOCOL_ERROR() {
        return this.PROTOCOL_ERROR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAPPLICATION_ERROR() {
        return this.APPLICATION_ERROR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAUTH_CODE_ERROR() {
        return this.AUTH_CODE_ERROR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCLIENT_INFO_ERROR() {
        return this.CLIENT_INFO_ERROR;
    }
}
