package com.kakao.sdk.partner.user;

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

/* compiled from: AgeAuthIntentFactory.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m839d2 = {"Lcom/kakao/sdk/partner/user/AgeAuthIntentFactory;", "", "()V", "ageAuth", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "resultReceiver", "Landroid/os/ResultReceiver;", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AgeAuthIntentFactory {
    public static final AgeAuthIntentFactory INSTANCE = new AgeAuthIntentFactory();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AgeAuthIntentFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent ageAuth(Context context, Uri uri, ResultReceiver resultReceiver) {
        Class cls;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        if (KakaoSdk.INSTANCE.isAutomotive()) {
            try {
                cls = Class.forName(com.kakao.sdk.auth.Constants.AUTOMOTIVE_VIEW);
            } catch (ClassNotFoundException unused) {
                throw new ClientError(ClientErrorCause.IllegalState, "Please initialize the SDK using 'KakaoSdk.initForAutomotive()'");
            }
        } else {
            cls = AgeAuthActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        Bundle bundle = new Bundle();
        bundle.putParcelable(com.kakao.sdk.auth.Constants.KEY_RESULT_RECEIVER, resultReceiver);
        bundle.putParcelable(com.kakao.sdk.auth.Constants.KEY_FULL_URI, uri);
        Unit unit = Unit.INSTANCE;
        Intent addFlags = intent.putExtra(com.kakao.sdk.auth.Constants.KEY_BUNDLE, bundle).addFlags(DriveFile.MODE_READ_ONLY);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(context, cls)\n   …t.FLAG_ACTIVITY_NEW_TASK)");
        return addFlags;
    }
}
