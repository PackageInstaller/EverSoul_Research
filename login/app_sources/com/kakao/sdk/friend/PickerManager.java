package com.kakao.sdk.friend;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.friend.internal.InternalChatParams;
import com.kakao.sdk.friend.internal.InternalFriendsParams;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.SelectedChat;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.friend.p012a.C2113c;
import com.kakao.sdk.friend.p012a.C2114d;
import com.kakao.sdk.friend.p012a.C2116f;
import com.kakao.sdk.friend.p012a.C2119i;
import com.kakao.sdk.friend.p012a.C2120j;
import com.kakao.sdk.user.UserApiClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJh\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0007Ju\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00052Q\u0010\u0011\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0014H\u0007J\u007f\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182Q\u0010\u0011\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0014H\u0007¨\u0006\u001d"}, m839d2 = {"Lcom/kakao/sdk/friend/PickerManager;", "", "", "isSingle", "isPopup", "Landroid/content/Context;", "context", "Lcom/kakao/sdk/friend/internal/InternalFriendsParams;", "param", "Lkotlin/Function2;", "Lcom/kakao/sdk/friend/model/SelectedUsers;", "Lkotlin/ParameterName;", "name", "selectedUsers", "", "error", "", "callback", "startActivityForFriend", "Lcom/kakao/sdk/friend/internal/InternalChatParams;", "Lkotlin/Function3;", "Lcom/kakao/sdk/friend/model/SelectedChat;", "selectedChat", "startActivityForChat", "Lcom/kakao/sdk/friend/internal/InternalTabParams;", NativeProtocol.WEB_DIALOG_PARAMS, "startActivityForTab", "<init>", "()V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class PickerManager {
    public static final PickerManager INSTANCE = new PickerManager();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PickerManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void startActivityForChat$default(boolean z, InternalChatParams internalChatParams, Context context, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        startActivityForChat(z, internalChatParams, context, function3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void startActivityForFriend$default(boolean z, boolean z2, Context context, InternalFriendsParams internalFriendsParams, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        startActivityForFriend(z, z2, context, internalFriendsParams, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void startActivityForTab$default(boolean z, boolean z2, Context context, InternalTabParams internalTabParams, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        startActivityForTab(z, z2, context, internalTabParams, function3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void startActivityForChat(boolean isPopup, InternalChatParams param, Context context, Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(param, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            C2119i c2119i = C2119i.f619a;
            c2119i.m476a(param, false);
            C2120j.f620a.m478b().mo495a(c2119i.m475a(param.getChatFilters()), new C2113c(callback, isPopup, context, param));
        } catch (ClientError e) {
            callback.invoke(null, null, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void startActivityForFriend(boolean isSingle, boolean isPopup, Context context, InternalFriendsParams param, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            C2119i.f619a.m476a(param, isSingle);
            C2120j.f620a.m478b().mo493a(param.getServiceTypeFilter(), param.getFriendFilter(), param.getCountryCodeFilters(), new C2114d(callback, isPopup, context, isSingle, param));
        } catch (ClientError e) {
            callback.invoke(null, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void startActivityForTab(boolean isSingle, boolean isPopup, Context context, InternalTabParams params, Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            C2119i.f619a.m476a(params, isSingle);
            UserApiClient.INSTANCE.getInstance().scopes(CollectionsKt.listOf((Object[]) new String[]{NativeProtocol.AUDIENCE_FRIENDS, "talk_chats"}), new C2116f(callback, context, isSingle, isPopup, params));
        } catch (ClientError e) {
            callback.invoke(null, null, e);
        }
    }
}
