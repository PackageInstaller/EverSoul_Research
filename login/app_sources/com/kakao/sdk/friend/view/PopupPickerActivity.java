package com.kakao.sdk.friend.view;

import android.os.Bundle;
import android.view.WindowManager;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p023l.C2191g;
import com.kakao.sdk.friend.p024m.AbstractActivityC2198a;
import kotlin.Metadata;

@Metadata(m837bv = {}, m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m839d2 = {"Lcom/kakao/sdk/friend/view/PopupPickerActivity;", "Lcom/kakao/sdk/friend/m/a;", "<init>", "()V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class PopupPickerActivity extends AbstractActivityC2198a {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p024m.AbstractActivityC2198a, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(C2110R.layout.kakao_sdk_activity_popup_picker);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = C2191g.f846a;
        attributes.height = C2191g.f847b;
        attributes.dimAmount = 0.5f;
    }
}
