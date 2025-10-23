package com.kakao.sdk.friend.p024m;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import com.kakao.sdk.auth.Constants;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.friend.p012a.C2120j;
import com.kakao.sdk.friend.p020i.C2171d;
import com.liapp.y;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.m.a */
/* loaded from: classes3.dex */
public abstract class AbstractActivityC2198a extends AppCompatActivity {

    /* renamed from: a */
    public final C2171d f860a = C2171d.f793i.m529a();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "This method was deprecated in API level 33.")
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            m564a(new ClientError(ClientErrorCause.Cancelled, "cancelled."));
        }
        super.onBackPressed();
    }

    /* renamed from: com.kakao.sdk.friend.m.a$a */
    public static final class a extends OnBackPressedCallback {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a() {
            super(true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (AbstractActivityC2198a.this.getSupportFragmentManager().getBackStackEntryCount() == 0) {
                AbstractActivityC2198a.this.m564a(new ClientError(ClientErrorCause.Cancelled, "cancelled."));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m564a(KakaoSdkError kakaoSdkError) {
        if (C2171d.f794j == null) {
            C2171d.f794j = new C2171d();
        }
        C2171d c2171d = C2171d.f794j;
        Intrinsics.checkNotNull(c2171d);
        ResultReceiver resultReceiver = c2171d.f802h;
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.KEY_EXCEPTION, kakaoSdkError);
            Unit unit = Unit.INSTANCE;
            resultReceiver.send(0, bundle);
        }
        C2120j.f621b = null;
        if (C2171d.f794j == null) {
            C2171d.f794j = new C2171d();
        }
        C2171d c2171d2 = C2171d.f794j;
        Intrinsics.checkNotNull(c2171d2);
        c2171d2.getClass();
        C2171d.f794j = null;
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069 A[Catch: IllegalStateException -> 0x007b, TryCatch #0 {IllegalStateException -> 0x007b, blocks: (B:24:0x0065, B:26:0x0069, B:75:0x0073, B:77:0x0077, B:78:0x0071, B:80:0x0063), top: B:79:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.p024m.AbstractActivityC2198a.onCreate(android.os.Bundle):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isChangingConfigurations()) {
            return;
        }
        C2120j.f621b = null;
        if (C2171d.f794j == null) {
            C2171d.f794j = new C2171d();
        }
        C2171d c2171d = C2171d.f794j;
        Intrinsics.checkNotNull(c2171d);
        c2171d.getClass();
        C2171d.f794j = null;
        finish();
    }
}
