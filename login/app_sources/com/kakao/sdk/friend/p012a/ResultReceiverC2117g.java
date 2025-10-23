package com.kakao.sdk.friend.p012a;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.LruCache;
import com.kakao.sdk.common.util.KakaoResultReceiver;
import com.kakao.sdk.friend.model.SelectedChat;
import com.kakao.sdk.friend.model.SelectedUser;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p023l.C2185a;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.a.g */
/* loaded from: classes3.dex */
public final class ResultReceiverC2117g extends KakaoResultReceiver<Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, ? extends Unit>> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResultReceiverC2117g(String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.KakaoResultReceiver
    public void processError() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown resultCode");
        Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, ? extends Unit> emitter = getEmitter();
        if (emitter == null) {
            return;
        }
        emitter.invoke(null, null, illegalArgumentException);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.KakaoResultReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void receiveCanceled(android.os.Bundle r5) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            java.lang.String r2 = "key.exception"
            r3 = 0
            if (r0 < r1) goto L16
            if (r5 != 0) goto Ld
            r5 = r3
            goto L21
        Ld:
            java.lang.Class<com.kakao.sdk.common.model.KakaoSdkError> r0 = com.kakao.sdk.common.model.KakaoSdkError.class
            java.io.Serializable r5 = r5.getSerializable(r2, r0)
        L13:
            com.kakao.sdk.common.model.KakaoSdkError r5 = (com.kakao.sdk.common.model.KakaoSdkError) r5
            goto L21
        L16:
            if (r5 != 0) goto L1a
            r5 = r3
            goto L1e
        L1a:
            java.io.Serializable r5 = r5.getSerializable(r2)
        L1e:
            if (r5 == 0) goto L2e
            goto L13
        L21:
            java.lang.Object r0 = r4.getEmitter()
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            if (r0 != 0) goto L2a
            goto L2d
        L2a:
            r0.invoke(r3, r3, r5)
        L2d:
            return
        L2e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type com.kakao.sdk.common.model.KakaoSdkError"
            r5.<init>(r0)
            throw r5
            fill-array 0x0036: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.p012a.ResultReceiverC2117g.receiveCanceled(android.os.Bundle):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.KakaoResultReceiver
    public void receiveOk(Bundle bundle) {
        ArrayList parcelableArrayList;
        Object parcelable;
        SelectedChat selectedChat;
        int i = bundle == null ? 0 : bundle.getInt("key.selected.totalcount");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            if (bundle != null) {
                parcelableArrayList = bundle.getParcelableArrayList("key.selected.friends", SelectedUser.class);
            }
            parcelableArrayList = null;
        } else {
            if (bundle != null) {
                parcelableArrayList = bundle.getParcelableArrayList("key.selected.friends");
            }
            parcelableArrayList = null;
        }
        if (i2 >= 33) {
            if (bundle != null) {
                parcelable = bundle.getParcelable("key.selected.chat", SelectedChat.class);
                selectedChat = (SelectedChat) parcelable;
            }
            selectedChat = null;
        } else {
            if (bundle != null) {
                parcelable = bundle.getParcelable("key.selected.chat");
                selectedChat = (SelectedChat) parcelable;
            }
            selectedChat = null;
        }
        Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, ? extends Unit> emitter = getEmitter();
        if (emitter == null) {
            return;
        }
        emitter.invoke(parcelableArrayList == null ? null : new SelectedUsers(i, parcelableArrayList), selectedChat, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.KakaoResultReceiver, android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        C2185a c2185a = C2185a.f829a;
        LruCache<Long, Bitmap> lruCache = C2185a.f833e;
        if (lruCache != null) {
            lruCache.evictAll();
        }
        C2120j.f621b = null;
        if (C2171d.f794j == null) {
            C2171d.f794j = new C2171d();
        }
        C2171d c2171d = C2171d.f794j;
        Intrinsics.checkNotNull(c2171d);
        c2171d.getClass();
        C2171d.f794j = null;
    }
}
