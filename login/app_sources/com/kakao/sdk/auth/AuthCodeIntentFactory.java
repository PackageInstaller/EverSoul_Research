package com.kakao.sdk.auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.drive.DriveFile;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthCodeIntentFactory.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ>\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\u0004¨\u0006\u0015"}, m839d2 = {"Lcom/kakao/sdk/auth/AuthCodeIntentFactory;", "", "()V", "account", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "fullUri", "Landroid/net/Uri;", "redirectUri", "", "resultReceiver", "Landroid/os/ResultReceiver;", "talk", "requestCode", "", "clientId", "kaHeader", "extras", "Landroid/os/Bundle;", "talkBase", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthCodeIntentFactory {
    public static final AuthCodeIntentFactory INSTANCE = new AuthCodeIntentFactory();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AuthCodeIntentFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent talkBase() {
        Intent addCategory = new Intent(Constants.CAPRI_LOGGED_IN_ACTIVITY).addCategory("android.intent.category.DEFAULT");
        Intrinsics.checkNotNullExpressionValue(addCategory, "Intent(Constants.CAPRI_L…(Intent.CATEGORY_DEFAULT)");
        return addCategory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent talk(Context context, int requestCode, String clientId, String redirectUri, String kaHeader, Bundle extras, ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(kaHeader, "kaHeader");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        Intent putExtra = new Intent(context, (Class<?>) TalkAuthCodeActivity.class).putExtra(Constants.KEY_LOGIN_INTENT, talkBase().putExtra(Constants.EXTRA_APPLICATION_KEY, clientId).putExtra(Constants.EXTRA_REDIRECT_URI, redirectUri).putExtra(Constants.EXTRA_KA_HEADER, kaHeader).putExtra(Constants.EXTRA_EXTRAPARAMS, extras)).putExtra(Constants.KEY_REQUEST_CODE, requestCode);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.KEY_RESULT_RECEIVER, resultReceiver);
        Unit unit = Unit.INSTANCE;
        Intent putExtra2 = putExtra.putExtra(Constants.KEY_BUNDLE, bundle);
        Intrinsics.checkNotNullExpressionValue(putExtra2, "Intent(context, TalkAuth…tReceiver)\n            })");
        return putExtra2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent account(Context context, Uri fullUri, String redirectUri, ResultReceiver resultReceiver) {
        Class cls;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fullUri, "fullUri");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        if (KakaoSdk.INSTANCE.isAutomotive()) {
            try {
                cls = Class.forName(Constants.AUTOMOTIVE_VIEW);
            } catch (ClassNotFoundException unused) {
                throw new ClientError(ClientErrorCause.IllegalState, "Please initialize the SDK using 'KakaoSdk.initForAutomotive()'");
            }
        } else {
            cls = AuthCodeHandlerActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.KEY_RESULT_RECEIVER, resultReceiver);
        bundle.putParcelable(Constants.KEY_FULL_URI, fullUri);
        bundle.putString(Constants.KEY_REDIRECT_URI, redirectUri);
        Unit unit = Unit.INSTANCE;
        Intent addFlags = intent.putExtra(Constants.KEY_BUNDLE, bundle).addFlags(DriveFile.MODE_READ_ONLY);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(context, cls)\n   …t.FLAG_ACTIVITY_NEW_TASK)");
        return addFlags;
    }
}
