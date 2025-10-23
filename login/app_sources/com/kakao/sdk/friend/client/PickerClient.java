package com.kakao.sdk.friend.client;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.kakao.sdk.common.Constants;
import com.kakao.sdk.friend.PickerManager;
import com.kakao.sdk.friend.model.OpenPickerFriendRequestParams;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.friend.p023l.C2193i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(m837bv = {}, m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014JR\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042:\u0010\u000e\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006JR\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042:\u0010\u000e\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006JR\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042:\u0010\u000e\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006JR\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042:\u0010\u000e\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006¨\u0006\u0016"}, m839d2 = {"Lcom/kakao/sdk/friend/client/PickerClient;", "", "Landroid/content/Context;", "context", "Lcom/kakao/sdk/friend/model/OpenPickerFriendRequestParams;", NativeProtocol.WEB_DIALOG_PARAMS, "Lkotlin/Function2;", "Lcom/kakao/sdk/friend/model/SelectedUsers;", "Lkotlin/ParameterName;", "name", "selectedUsers", "", "error", "", "callback", "selectFriends", "selectFriend", "selectFriendsPopup", "selectFriendPopup", "<init>", "()V", "Companion", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class PickerClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<PickerClient> instance$delegate = LazyKt.lazy(C2136a.f667a);

    @Metadata(m837bv = {}, m838d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m839d2 = {"Lcom/kakao/sdk/friend/client/PickerClient$Companion;", "", "Lcom/kakao/sdk/friend/client/PickerClient;", "instance$delegate", "Lkotlin/Lazy;", Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/friend/client/PickerClient;", "getInstance$annotations", "()V", "instance", "<init>", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final PickerClient getInstance() {
            return (PickerClient) PickerClient.instance$delegate.getValue();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final PickerClient getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void selectFriend(Context context, OpenPickerFriendRequestParams params, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForFriend$default(true, false, context, C2193i.f849a.m551a(params), callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void selectFriendPopup(Context context, OpenPickerFriendRequestParams params, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForFriend(true, true, context, C2193i.f849a.m551a(params), callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void selectFriends(Context context, OpenPickerFriendRequestParams params, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForFriend$default(false, false, context, C2193i.f849a.m551a(params), callback, 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void selectFriendsPopup(Context context, OpenPickerFriendRequestParams params, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForFriend$default(false, true, context, C2193i.f849a.m551a(params), callback, 1, null);
    }

    /* renamed from: com.kakao.sdk.friend.client.PickerClient$a */
    public static final class C2136a extends Lambda implements Function0<PickerClient> {

        /* renamed from: a */
        public static final C2136a f667a = new C2136a();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public C2136a() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public PickerClient invoke() {
            return new PickerClient();
        }
    }
}
