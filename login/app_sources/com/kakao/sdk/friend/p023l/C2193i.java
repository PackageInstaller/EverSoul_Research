package com.kakao.sdk.friend.p023l;

import android.os.Parcelable;
import com.kakao.sdk.friend.internal.InternalChatParams;
import com.kakao.sdk.friend.internal.InternalFriendsParams;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.DefaultValues;
import com.kakao.sdk.friend.model.OpenPickerFriendRequestParams;
import com.kakao.sdk.friend.model.PickerOrientation;
import com.kakao.sdk.friend.model.PickerServiceTypeFilter;
import com.kakao.sdk.friend.model.ViewAppearance;
import com.kakao.sdk.friend.p020i.C2172e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.l.i */
/* loaded from: classes3.dex */
public final class C2193i {

    /* renamed from: a */
    public static final C2193i f849a = new C2193i();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    /* renamed from: a */
    public static final C2172e m550a(Parcelable parcelable) {
        ViewAppearance viewAppearance;
        PickerOrientation orientation;
        Intrinsics.checkNotNullParameter(parcelable, "<this>");
        if (parcelable instanceof InternalFriendsParams) {
            InternalFriendsParams internalFriendsParams = (InternalFriendsParams) parcelable;
            viewAppearance = internalFriendsParams.getViewAppearance();
            orientation = internalFriendsParams.getOrientation();
        } else if (parcelable instanceof InternalChatParams) {
            InternalChatParams internalChatParams = (InternalChatParams) parcelable;
            viewAppearance = internalChatParams.getViewAppearance();
            orientation = internalChatParams.getOrientation();
        } else {
            if (!(parcelable instanceof InternalTabParams)) {
                throw new IllegalArgumentException();
            }
            InternalTabParams internalTabParams = (InternalTabParams) parcelable;
            viewAppearance = internalTabParams.getViewAppearance();
            orientation = internalTabParams.getOrientation();
        }
        return new C2172e(viewAppearance, orientation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final InternalFriendsParams m551a(OpenPickerFriendRequestParams openPickerFriendRequestParams) {
        Intrinsics.checkNotNullParameter(openPickerFriendRequestParams, "<this>");
        String title = openPickerFriendRequestParams.getTitle();
        PickerServiceTypeFilter serviceTypeFilter = openPickerFriendRequestParams.getServiceTypeFilter();
        if (serviceTypeFilter == null) {
            serviceTypeFilter = DefaultValues.INSTANCE.getDEFAULT_PICKER_SERVICE_TYPE_FILTER();
        }
        ViewAppearance viewAppearance = openPickerFriendRequestParams.getViewAppearance();
        if (viewAppearance == null) {
            viewAppearance = DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE();
        }
        PickerOrientation orientation = openPickerFriendRequestParams.getOrientation();
        if (orientation == null) {
            orientation = DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION();
        }
        Boolean enableSearch = openPickerFriendRequestParams.getEnableSearch();
        boolean booleanValue = enableSearch == null ? true : enableSearch.booleanValue();
        Boolean enableIndex = openPickerFriendRequestParams.getEnableIndex();
        boolean booleanValue2 = enableIndex == null ? true : enableIndex.booleanValue();
        Boolean showMyProfile = openPickerFriendRequestParams.getShowMyProfile();
        boolean booleanValue3 = showMyProfile == null ? true : showMyProfile.booleanValue();
        Boolean showFavorite = openPickerFriendRequestParams.getShowFavorite();
        boolean booleanValue4 = showFavorite == null ? true : showFavorite.booleanValue();
        Boolean showPickedFriend = openPickerFriendRequestParams.getShowPickedFriend();
        boolean booleanValue5 = showPickedFriend == null ? true : showPickedFriend.booleanValue();
        Integer maxPickableCount = openPickerFriendRequestParams.getMaxPickableCount();
        int intValue = maxPickableCount == null ? 30 : maxPickableCount.intValue();
        Integer minPickableCount = openPickerFriendRequestParams.getMinPickableCount();
        return new InternalFriendsParams(title, serviceTypeFilter, null, null, null, viewAppearance, orientation, booleanValue, booleanValue2, booleanValue3, booleanValue4, null, false, booleanValue5, intValue, minPickableCount == null ? 1 : minPickableCount.intValue(), 6172, null);
    }
}
