package com.kakao.sdk.partner.user;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.auth.TokenManagerProvider;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.Description;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.common.util.KakaoResultReceiver;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.partner.user.model.AgeAuthError;
import com.kakao.sdk.partner.user.model.AgeAuthErrorCause;
import com.kakao.sdk.partner.user.model.AgeAuthLevel;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgeAuthManager.kt */
@Metadata(m838d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\rJN\u0010\u000e\u001a%\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u00100\u000f2#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010Jt\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010¢\u0006\u0002\u0010\u001a¨\u0006\u001c"}, m839d2 = {"Lcom/kakao/sdk/partner/user/AgeAuthManager;", "", "()V", "makeUri", "Landroid/net/Uri;", "ageLimit", "", "authLevel", "Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;", "skipTerms", "", "adultsOnly", "underAge", "(Ljava/lang/Integer;Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Landroid/net/Uri;", "resultReceiver", "Lcom/kakao/sdk/common/util/KakaoResultReceiver;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "error", "", "callback", "verifyAgeWithAuthentication", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/Integer;Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "Companion", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AgeAuthManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<AgeAuthManager> instance$delegate = LazyKt.lazy(new Function0<AgeAuthManager>() { // from class: com.kakao.sdk.partner.user.AgeAuthManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final AgeAuthManager invoke() {
            return new AgeAuthManager();
        }
    });

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final AgeAuthManager getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void verifyAgeWithAuthentication(Context context, Integer ageLimit, AgeAuthLevel authLevel, Boolean skipTerms, Boolean adultsOnly, Boolean underAge, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            context.startActivity(AgeAuthIntentFactory.INSTANCE.ageAuth(context, makeUri(ageLimit, authLevel, skipTerms, adultsOnly, underAge), resultReceiver(callback)));
        } catch (Throwable th) {
            SdkLog.INSTANCE.m470e(th);
            callback.invoke(th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ KakaoResultReceiver resultReceiver(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        KakaoResultReceiver<Function1<? super Throwable, ? extends Unit>> kakaoResultReceiver = new KakaoResultReceiver<Function1<? super Throwable, ? extends Unit>>() { // from class: com.kakao.sdk.partner.user.AgeAuthManager$resultReceiver$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.common.util.KakaoResultReceiver
            public void receiveOk(Bundle resultData) {
                Uri uri;
                AgeAuthErrorCause ageAuthErrorCause;
                if (Build.VERSION.SDK_INT >= 33) {
                    if (resultData != null) {
                        uri = (Uri) resultData.getParcelable(com.kakao.sdk.auth.Constants.KEY_URL, Uri.class);
                    }
                    uri = null;
                } else {
                    if (resultData != null) {
                        uri = (Uri) resultData.getParcelable(com.kakao.sdk.auth.Constants.KEY_URL);
                    }
                    uri = null;
                }
                int i = -1;
                if (uri != null) {
                    try {
                        String queryParameter = uri.getQueryParameter("status");
                        if (queryParameter != null) {
                            i = Integer.parseInt(queryParameter);
                        }
                    } catch (Exception e) {
                        SdkLog.INSTANCE.m471i(e);
                        i = -9999;
                    }
                }
                if (i == 0) {
                    Function1<? super Throwable, ? extends Unit> emitter = getEmitter();
                    if (emitter == null) {
                        return;
                    }
                    emitter.invoke(null);
                    return;
                }
                AgeAuthErrorCause[] values = AgeAuthErrorCause.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        ageAuthErrorCause = null;
                        break;
                    }
                    ageAuthErrorCause = values[i2];
                    i2++;
                    if (ageAuthErrorCause.getStatus() == i) {
                        break;
                    }
                }
                if (ageAuthErrorCause == null) {
                    Function1<? super Throwable, ? extends Unit> emitter2 = getEmitter();
                    if (emitter2 == null) {
                        return;
                    }
                    emitter2.invoke(new AgeAuthError(AgeAuthErrorCause.UNKNOWN, "unknown error."));
                    return;
                }
                Description description = (Description) ageAuthErrorCause.getClass().getField(ageAuthErrorCause.name()).getAnnotation(Description.class);
                String value = description == null ? null : description.value();
                SdkLog.INSTANCE.m471i("status " + ageAuthErrorCause.getStatus() + " , description " + ((Object) value));
                Function1<? super Throwable, ? extends Unit> emitter3 = getEmitter();
                if (emitter3 == null) {
                    return;
                }
                emitter3.invoke(value != null ? new AgeAuthError(ageAuthErrorCause, value) : null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.common.util.KakaoResultReceiver
            public void receiveCanceled(Bundle resultData) {
                if (Build.VERSION.SDK_INT < 33) {
                    r2 = resultData != null ? resultData.getSerializable(com.kakao.sdk.auth.Constants.KEY_EXCEPTION) : null;
                    if (r2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.kakao.sdk.common.model.KakaoSdkError");
                    }
                    r2 = (KakaoSdkError) r2;
                } else if (resultData != null) {
                    r2 = (KakaoSdkError) resultData.getSerializable(com.kakao.sdk.auth.Constants.KEY_EXCEPTION, KakaoSdkError.class);
                }
                Function1<? super Throwable, ? extends Unit> emitter = getEmitter();
                if (emitter == null) {
                    return;
                }
                emitter.invoke(r2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.common.util.KakaoResultReceiver
            public void processError() {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown status in AgeAuthClient#onReceivedResult()");
                Function1<? super Throwable, ? extends Unit> emitter = getEmitter();
                if (emitter == null) {
                    return;
                }
                emitter.invoke(illegalArgumentException);
            }
        };
        kakaoResultReceiver.setEmitter(callback);
        return kakaoResultReceiver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Uri makeUri$default(AgeAuthManager ageAuthManager, Integer num, AgeAuthLevel ageAuthLevel, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 16) != 0) {
            bool3 = false;
        }
        return ageAuthManager.makeUri(num, ageAuthLevel, bool, bool2, bool3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeUri(Integer ageLimit, AgeAuthLevel authLevel, Boolean skipTerms, Boolean adultsOnly, Boolean underAge) {
        Class<?> cls;
        Field field;
        SerializedName serializedName;
        String value;
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority(KakaoSdk.INSTANCE.getHosts().getMobileAccount()).path(Constants.AGE_AUTH_PATH).appendQueryParameter(Constants.RETURN_URL, Intrinsics.stringPlus(KakaoSdk.INSTANCE.getApplicationContextInfo().getCustomScheme(), "://ageauth")).appendQueryParameter("token_type", Constants.API_TYPE);
        OAuthToken token = TokenManagerProvider.INSTANCE.getInstance().getManager().getToken();
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("access_token", token == null ? null : token.getAccessToken()).appendQueryParameter(Constants.AUTH_FROM, KakaoSdk.INSTANCE.getAppKey());
        if (authLevel != null && (cls = authLevel.getClass()) != null && (field = cls.getField(authLevel.name())) != null && (serializedName = (SerializedName) field.getAnnotation(SerializedName.class)) != null && (value = serializedName.value()) != null) {
            appendQueryParameter2.appendQueryParameter(Constants.AUTH_LEVEL, value);
        }
        if (ageLimit != null) {
            appendQueryParameter2.appendQueryParameter("age_limit", String.valueOf(ageLimit.intValue()));
        }
        if (skipTerms != null) {
            appendQueryParameter2.appendQueryParameter(Constants.SKIP_TERM, String.valueOf(skipTerms.booleanValue()));
        }
        if (adultsOnly != null) {
            appendQueryParameter2.appendQueryParameter(Constants.ADULTS_ONLY, String.valueOf(adultsOnly.booleanValue()));
        }
        if (underAge != null) {
            appendQueryParameter2.appendQueryParameter(Constants.UNDER_AGE, String.valueOf(underAge.booleanValue()));
        }
        Uri build = appendQueryParameter2.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().scheme(com.kak…ng()) }\n        }.build()");
        return build;
    }

    /* compiled from: AgeAuthManager.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m839d2 = {"Lcom/kakao/sdk/partner/user/AgeAuthManager$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/partner/user/AgeAuthManager;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/partner/user/AgeAuthManager;", "instance$delegate", "Lkotlin/Lazy;", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final AgeAuthManager getInstance() {
            return (AgeAuthManager) AgeAuthManager.instance$delegate.getValue();
        }
    }
}
