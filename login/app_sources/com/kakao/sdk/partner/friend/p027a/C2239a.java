package com.kakao.sdk.partner.friend.p027a;

import com.kakao.sdk.friend.internal.InternalFriendsParams;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.DefaultValues;
import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.model.PickerChatFilter;
import com.kakao.sdk.friend.model.PickerChatSelectionType;
import com.kakao.sdk.friend.model.PickerFriendFilter;
import com.kakao.sdk.friend.model.PickerOrientation;
import com.kakao.sdk.friend.model.PickerServiceTypeFilter;
import com.kakao.sdk.friend.model.PickerUsingOsFilter;
import com.kakao.sdk.friend.model.ViewAppearance;
import com.kakao.sdk.partner.friend.model.PickerFriendRequestParams;
import com.kakao.sdk.partner.friend.model.PickerTabRequestParams;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.partner.friend.a.a */
/* loaded from: classes3.dex */
public final class C2239a {

    /* renamed from: a */
    public static final C2239a f1043a = new C2239a();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final InternalFriendsParams m690a(PickerFriendRequestParams pickerFriendRequestParams) {
        Intrinsics.checkNotNullParameter(pickerFriendRequestParams, "<this>");
        String title = pickerFriendRequestParams.getTitle();
        PickerServiceTypeFilter serviceTypeFilter = pickerFriendRequestParams.getServiceTypeFilter();
        if (serviceTypeFilter == null) {
            serviceTypeFilter = DefaultValues.INSTANCE.getDEFAULT_PICKER_SERVICE_TYPE_FILTER();
        }
        PickerFriendFilter friendFilter = pickerFriendRequestParams.getFriendFilter();
        if (friendFilter == null) {
            friendFilter = DefaultValues.INSTANCE.getDEFAULT_PICKER_FRIEND_FILTER();
        }
        List<String> countryCodeFilters = pickerFriendRequestParams.getCountryCodeFilters();
        if (countryCodeFilters == null) {
            countryCodeFilters = CollectionsKt.emptyList();
        }
        PickerUsingOsFilter usingOsFilter = pickerFriendRequestParams.getUsingOsFilter();
        if (usingOsFilter == null) {
            usingOsFilter = DefaultValues.INSTANCE.getDEFAULT_OS_FILTER();
        }
        ViewAppearance viewAppearance = pickerFriendRequestParams.getViewAppearance();
        if (viewAppearance == null) {
            viewAppearance = DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE();
        }
        PickerOrientation orientation = pickerFriendRequestParams.getOrientation();
        if (orientation == null) {
            orientation = DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION();
        }
        Boolean enableSearch = pickerFriendRequestParams.getEnableSearch();
        boolean booleanValue = enableSearch == null ? true : enableSearch.booleanValue();
        Boolean enableIndex = pickerFriendRequestParams.getEnableIndex();
        boolean booleanValue2 = enableIndex == null ? true : enableIndex.booleanValue();
        Boolean showMyProfile = pickerFriendRequestParams.getShowMyProfile();
        boolean booleanValue3 = showMyProfile == null ? true : showMyProfile.booleanValue();
        Boolean showFavorite = pickerFriendRequestParams.getShowFavorite();
        boolean booleanValue4 = showFavorite == null ? true : showFavorite.booleanValue();
        List<DisableSelectOption> disableSelectOptions = pickerFriendRequestParams.getDisableSelectOptions();
        if (disableSelectOptions == null) {
            disableSelectOptions = CollectionsKt.emptyList();
        }
        Boolean displayAllProfile = pickerFriendRequestParams.getDisplayAllProfile();
        boolean booleanValue5 = displayAllProfile == null ? false : displayAllProfile.booleanValue();
        Boolean showPickedFriend = pickerFriendRequestParams.getShowPickedFriend();
        boolean booleanValue6 = showPickedFriend == null ? true : showPickedFriend.booleanValue();
        Integer maxPickableCount = pickerFriendRequestParams.getMaxPickableCount();
        int intValue = maxPickableCount == null ? 30 : maxPickableCount.intValue();
        Integer minPickableCount = pickerFriendRequestParams.getMinPickableCount();
        return new InternalFriendsParams(title, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, booleanValue, booleanValue2, booleanValue3, booleanValue4, disableSelectOptions, booleanValue5, booleanValue6, intValue, minPickableCount == null ? 1 : minPickableCount.intValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final InternalTabParams m691a(PickerTabRequestParams pickerTabRequestParams) {
        Intrinsics.checkNotNullParameter(pickerTabRequestParams, "<this>");
        String title = pickerTabRequestParams.getTitle();
        ViewAppearance viewAppearance = pickerTabRequestParams.getViewAppearance();
        if (viewAppearance == null) {
            viewAppearance = DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE();
        }
        PickerOrientation orientation = pickerTabRequestParams.getOrientation();
        if (orientation == null) {
            orientation = DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION();
        }
        Boolean enableSearch = pickerTabRequestParams.getEnableSearch();
        boolean booleanValue = enableSearch == null ? true : enableSearch.booleanValue();
        List<DisableSelectOption> disableSelectOptions = pickerTabRequestParams.getDisableSelectOptions();
        if (disableSelectOptions == null) {
            disableSelectOptions = CollectionsKt.emptyList();
        }
        Boolean displayAllProfile = pickerTabRequestParams.getDisplayAllProfile();
        boolean booleanValue2 = displayAllProfile == null ? false : displayAllProfile.booleanValue();
        Integer maxPickableCount = pickerTabRequestParams.getMaxPickableCount();
        int intValue = maxPickableCount == null ? 30 : maxPickableCount.intValue();
        Integer minPickableCount = pickerTabRequestParams.getMinPickableCount();
        int intValue2 = minPickableCount == null ? 1 : minPickableCount.intValue();
        PickerTabRequestParams.FriendsRequestParams friendsParams = pickerTabRequestParams.getFriendsParams();
        Intrinsics.checkNotNullParameter(friendsParams, "<this>");
        PickerServiceTypeFilter serviceTypeFilter = friendsParams.getServiceTypeFilter();
        if (serviceTypeFilter == null) {
            serviceTypeFilter = DefaultValues.INSTANCE.getDEFAULT_PICKER_SERVICE_TYPE_FILTER();
        }
        PickerServiceTypeFilter pickerServiceTypeFilter = serviceTypeFilter;
        PickerFriendFilter friendFilter = friendsParams.getFriendFilter();
        if (friendFilter == null) {
            friendFilter = DefaultValues.INSTANCE.getDEFAULT_PICKER_FRIEND_FILTER();
        }
        PickerFriendFilter pickerFriendFilter = friendFilter;
        List<String> countryCodeFilters = friendsParams.getCountryCodeFilters();
        if (countryCodeFilters == null) {
            countryCodeFilters = CollectionsKt.emptyList();
        }
        List<String> list = countryCodeFilters;
        PickerUsingOsFilter usingOsFilter = friendsParams.getUsingOsFilter();
        if (usingOsFilter == null) {
            usingOsFilter = DefaultValues.INSTANCE.getDEFAULT_OS_FILTER();
        }
        PickerUsingOsFilter pickerUsingOsFilter = usingOsFilter;
        Boolean enableIndex = friendsParams.getEnableIndex();
        boolean booleanValue3 = enableIndex == null ? true : enableIndex.booleanValue();
        Boolean showMyProfile = friendsParams.getShowMyProfile();
        boolean booleanValue4 = showMyProfile == null ? true : showMyProfile.booleanValue();
        Boolean showFavorite = friendsParams.getShowFavorite();
        boolean booleanValue5 = showFavorite == null ? true : showFavorite.booleanValue();
        Boolean showPickedFriend = friendsParams.getShowPickedFriend();
        InternalTabParams.InternalFriendsParams internalFriendsParams = new InternalTabParams.InternalFriendsParams(pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, booleanValue3, booleanValue4, booleanValue5, showPickedFriend != null ? showPickedFriend.booleanValue() : true);
        PickerTabRequestParams.ChatRequestParams chatParams = pickerTabRequestParams.getChatParams();
        Intrinsics.checkNotNullParameter(chatParams, "<this>");
        PickerChatSelectionType selectionType = chatParams.getSelectionType();
        List<PickerChatFilter> chatFilters = chatParams.getChatFilters();
        if (chatFilters == null) {
            chatFilters = CollectionsKt.listOf(DefaultValues.INSTANCE.getDEFAULT_PICKER_CHAT_FILTER());
        }
        return new InternalTabParams(title, viewAppearance, orientation, booleanValue, disableSelectOptions, booleanValue2, intValue, intValue2, internalFriendsParams, new InternalTabParams.InternalChatParams(selectionType, chatFilters));
    }
}
