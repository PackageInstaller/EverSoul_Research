package com.kakao.sdk.partner.friend.client;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.kakao.sdk.friend.PickerManager;
import com.kakao.sdk.friend.client.PickerClient;
import com.kakao.sdk.friend.internal.InternalChatParams;
import com.kakao.sdk.friend.model.DefaultValues;
import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.model.PickerChatFilter;
import com.kakao.sdk.friend.model.PickerChatSelectionType;
import com.kakao.sdk.friend.model.PickerOrientation;
import com.kakao.sdk.friend.model.SelectedChat;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.friend.model.ViewAppearance;
import com.kakao.sdk.partner.friend.model.PickerChatRequestParams;
import com.kakao.sdk.partner.friend.model.PickerFriendRequestParams;
import com.kakao.sdk.partner.friend.model.PickerTabRequestParams;
import com.kakao.sdk.partner.friend.p027a.C2239a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\u000e\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032:\u0010\r\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005\u001aV\u0010\u000f\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032:\u0010\r\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005\u001aV\u0010\u0010\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032:\u0010\r\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005\u001aV\u0010\u0011\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032:\u0010\r\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005\u001am\u0010\u0016\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00122Q\u0010\r\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0013\u001am\u0010\u0017\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00122Q\u0010\r\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0013\u001am\u0010\u0019\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00182Q\u0010\r\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0013\u001am\u0010\u001a\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00182Q\u0010\r\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0013¨\u0006\u001b"}, m839d2 = {"Lcom/kakao/sdk/friend/client/PickerClient;", "Landroid/content/Context;", "context", "Lcom/kakao/sdk/partner/friend/model/PickerFriendRequestParams;", NativeProtocol.WEB_DIALOG_PARAMS, "Lkotlin/Function2;", "Lcom/kakao/sdk/friend/model/SelectedUsers;", "Lkotlin/ParameterName;", "name", "selectedUsers", "", "error", "", "callback", "selectFriends", "selectFriend", "selectFriendsPopup", "selectFriendPopup", "Lcom/kakao/sdk/partner/friend/model/PickerChatRequestParams;", "Lkotlin/Function3;", "Lcom/kakao/sdk/friend/model/SelectedChat;", "selectedChat", "selectChat", "selectChatPopup", "Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams;", "select", "selectPopup", "partner-friend_release"}, m840k = 2, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class PickerClientKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void select(PickerClient pickerClient, Context context, PickerTabRequestParams params, Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(pickerClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForTab$default(false, false, context, C2239a.f1043a.m691a(params), callback, 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void selectFriend(PickerClient pickerClient, Context context, PickerFriendRequestParams params, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(pickerClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForFriend$default(true, false, context, C2239a.f1043a.m690a(params), callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void selectFriendPopup(PickerClient pickerClient, Context context, PickerFriendRequestParams params, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(pickerClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForFriend(true, true, context, C2239a.f1043a.m690a(params), callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void selectFriends(PickerClient pickerClient, Context context, PickerFriendRequestParams params, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(pickerClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForFriend$default(false, false, context, C2239a.f1043a.m690a(params), callback, 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void selectFriendsPopup(PickerClient pickerClient, Context context, PickerFriendRequestParams params, Function2<? super SelectedUsers, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(pickerClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager.startActivityForFriend$default(false, true, context, C2239a.f1043a.m690a(params), callback, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void selectPopup(PickerClient pickerClient, Context context, PickerTabRequestParams params, Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(pickerClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager pickerManager = PickerManager.INSTANCE;
        PickerManager.startActivityForTab$default(false, true, context, C2239a.f1043a.m691a(params), callback, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void selectChat(PickerClient pickerClient, Context context, PickerChatRequestParams params, Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(pickerClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager pickerManager = PickerManager.INSTANCE;
        Intrinsics.checkNotNullParameter(params, "<this>");
        PickerChatSelectionType selectionType = params.getSelectionType();
        String title = params.getTitle();
        List<PickerChatFilter> chatFilters = params.getChatFilters();
        if (chatFilters == null) {
            chatFilters = CollectionsKt.listOf(DefaultValues.INSTANCE.getDEFAULT_PICKER_CHAT_FILTER());
        }
        List<PickerChatFilter> list = chatFilters;
        ViewAppearance viewAppearance = params.getViewAppearance();
        if (viewAppearance == null) {
            viewAppearance = DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE();
        }
        ViewAppearance viewAppearance2 = viewAppearance;
        PickerOrientation orientation = params.getOrientation();
        if (orientation == null) {
            orientation = DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION();
        }
        PickerOrientation pickerOrientation = orientation;
        Boolean enableSearch = params.getEnableSearch();
        boolean booleanValue = enableSearch == null ? true : enableSearch.booleanValue();
        List<DisableSelectOption> disableSelectOptions = params.getDisableSelectOptions();
        if (disableSelectOptions == null) {
            disableSelectOptions = CollectionsKt.emptyList();
        }
        List<DisableSelectOption> list2 = disableSelectOptions;
        Boolean displayAllProfile = params.getDisplayAllProfile();
        boolean booleanValue2 = displayAllProfile == null ? false : displayAllProfile.booleanValue();
        Integer maxPickableCount = params.getMaxPickableCount();
        int intValue = maxPickableCount == null ? 30 : maxPickableCount.intValue();
        Integer minPickableCount = params.getMinPickableCount();
        PickerManager.startActivityForChat$default(false, new InternalChatParams(selectionType, title, list, viewAppearance2, pickerOrientation, booleanValue, list2, booleanValue2, intValue, minPickableCount == null ? 1 : minPickableCount.intValue()), context, callback, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void selectChatPopup(PickerClient pickerClient, Context context, PickerChatRequestParams params, Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(pickerClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PickerManager pickerManager = PickerManager.INSTANCE;
        Intrinsics.checkNotNullParameter(params, "<this>");
        PickerChatSelectionType selectionType = params.getSelectionType();
        String title = params.getTitle();
        List<PickerChatFilter> chatFilters = params.getChatFilters();
        if (chatFilters == null) {
            chatFilters = CollectionsKt.listOf(DefaultValues.INSTANCE.getDEFAULT_PICKER_CHAT_FILTER());
        }
        List<PickerChatFilter> list = chatFilters;
        ViewAppearance viewAppearance = params.getViewAppearance();
        if (viewAppearance == null) {
            viewAppearance = DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE();
        }
        ViewAppearance viewAppearance2 = viewAppearance;
        PickerOrientation orientation = params.getOrientation();
        if (orientation == null) {
            orientation = DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION();
        }
        PickerOrientation pickerOrientation = orientation;
        Boolean enableSearch = params.getEnableSearch();
        boolean booleanValue = enableSearch == null ? true : enableSearch.booleanValue();
        List<DisableSelectOption> disableSelectOptions = params.getDisableSelectOptions();
        if (disableSelectOptions == null) {
            disableSelectOptions = CollectionsKt.emptyList();
        }
        List<DisableSelectOption> list2 = disableSelectOptions;
        Boolean displayAllProfile = params.getDisplayAllProfile();
        boolean booleanValue2 = displayAllProfile == null ? false : displayAllProfile.booleanValue();
        Integer maxPickableCount = params.getMaxPickableCount();
        int intValue = maxPickableCount == null ? 30 : maxPickableCount.intValue();
        Integer minPickableCount = params.getMinPickableCount();
        PickerManager.startActivityForChat(true, new InternalChatParams(selectionType, title, list, viewAppearance2, pickerOrientation, booleanValue, list2, booleanValue2, intValue, minPickableCount == null ? 1 : minPickableCount.intValue()), context, callback);
    }
}
