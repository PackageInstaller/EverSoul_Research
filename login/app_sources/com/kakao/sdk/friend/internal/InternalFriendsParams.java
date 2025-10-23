package com.kakao.sdk.friend.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.MotionEventCompat;
import com.kakao.sdk.friend.model.DefaultValues;
import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.model.PickerFriendFilter;
import com.kakao.sdk.friend.model.PickerOrientation;
import com.kakao.sdk.friend.model.PickerServiceTypeFilter;
import com.kakao.sdk.friend.model.PickerUsingOsFilter;
import com.kakao.sdk.friend.model.ViewAppearance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B·\u0001\b\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010-\u001a\u00020,\u0012\b\b\u0002\u00101\u001a\u00020,\u0012\b\b\u0002\u00103\u001a\u00020,\u0012\b\b\u0002\u00105\u001a\u00020,\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0018\u0012\b\b\u0002\u0010:\u001a\u00020,\u0012\b\b\u0002\u0010<\u001a\u00020,\u0012\b\b\u0002\u0010>\u001a\u00020\u0002\u0012\b\b\u0002\u0010B\u001a\u00020\u0002¢\u0006\u0004\bD\u0010EJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u00101\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u0017\u00103\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R\u0017\u00105\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002070\u00188\u0006¢\u0006\f\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\u001cR\u0017\u0010:\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b:\u0010.\u001a\u0004\b;\u00100R\u0017\u0010<\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b<\u0010.\u001a\u0004\b=\u00100R\u0017\u0010>\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010B\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bB\u0010?\u001a\u0004\bC\u0010A¨\u0006F"}, m839d2 = {"Lcom/kakao/sdk/friend/internal/InternalFriendsParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "serviceTypeFilter", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "getServiceTypeFilter", "()Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "friendFilter", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "getFriendFilter", "()Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "", "countryCodeFilters", "Ljava/util/List;", "getCountryCodeFilters", "()Ljava/util/List;", "Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "usingOsFilter", "Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "getUsingOsFilter", "()Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "viewAppearance", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "getViewAppearance", "()Lcom/kakao/sdk/friend/model/ViewAppearance;", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "orientation", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "getOrientation", "()Lcom/kakao/sdk/friend/model/PickerOrientation;", "", "enableSearch", "Z", "getEnableSearch", "()Z", "enableIndex", "getEnableIndex", "showMyProfile", "getShowMyProfile", "showFavorite", "getShowFavorite", "Lcom/kakao/sdk/friend/model/DisableSelectOption;", "disableSelectOptions", "getDisableSelectOptions", "displayAllProfile", "getDisplayAllProfile", "showPickedFriend", "getShowPickedFriend", "maxPickableCount", "I", "getMaxPickableCount", "()I", "minPickableCount", "getMinPickableCount", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;Lcom/kakao/sdk/friend/model/PickerFriendFilter;Ljava/util/List;Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;Lcom/kakao/sdk/friend/model/ViewAppearance;Lcom/kakao/sdk/friend/model/PickerOrientation;ZZZZLjava/util/List;ZZII)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class InternalFriendsParams implements Parcelable {
    public static final Parcelable.Creator<InternalFriendsParams> CREATOR = new C2174a();
    private final List<String> countryCodeFilters;
    private final List<DisableSelectOption> disableSelectOptions;
    private final boolean displayAllProfile;
    private final boolean enableIndex;
    private final boolean enableSearch;
    private final PickerFriendFilter friendFilter;
    private final int maxPickableCount;
    private final int minPickableCount;
    private final PickerOrientation orientation;
    private final PickerServiceTypeFilter serviceTypeFilter;
    private final boolean showFavorite;
    private final boolean showMyProfile;
    private final boolean showPickedFriend;
    private final String title;
    private final PickerUsingOsFilter usingOsFilter;
    private final ViewAppearance viewAppearance;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams() {
        this(null, null, null, null, null, null, null, false, false, false, false, null, false, false, 0, 0, 65535, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str) {
        this(str, null, null, null, null, null, null, false, false, false, false, null, false, false, 0, 0, 65534, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter) {
        this(str, serviceTypeFilter, null, null, null, null, null, false, false, false, false, null, false, false, 0, 0, 65532, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter) {
        this(str, serviceTypeFilter, friendFilter, null, null, null, null, false, false, false, false, null, false, false, 0, 0, 65528, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, null, null, null, false, false, false, false, null, false, false, 0, 0, 65520, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, null, null, false, false, false, false, null, false, false, 0, 0, 65504, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, null, false, false, false, false, null, false, false, 0, 0, 65472, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, false, false, false, false, null, false, false, 0, 0, 65408, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, z, false, false, false, null, false, false, 0, 0, MotionEventCompat.ACTION_POINTER_INDEX_MASK, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, boolean z2) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, z, z2, false, false, null, false, false, 0, 0, 65024, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, boolean z2, boolean z3) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, z, z2, z3, false, null, false, false, 0, 0, 64512, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, boolean z2, boolean z3, boolean z4) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, z, z2, z3, z4, null, false, false, 0, 0, 63488, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, boolean z2, boolean z3, boolean z4, List<DisableSelectOption> disableSelectOptions) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, z, z2, z3, z4, disableSelectOptions, false, false, 0, 0, 61440, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, boolean z2, boolean z3, boolean z4, List<DisableSelectOption> disableSelectOptions, boolean z5) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, z, z2, z3, z4, disableSelectOptions, z5, false, 0, 0, 57344, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, boolean z2, boolean z3, boolean z4, List<DisableSelectOption> disableSelectOptions, boolean z5, boolean z6) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, z, z2, z3, z4, disableSelectOptions, z5, z6, 0, 0, 49152, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, boolean z2, boolean z3, boolean z4, List<DisableSelectOption> disableSelectOptions, boolean z5, boolean z6, int i) {
        this(str, serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, viewAppearance, orientation, z, z2, z3, z4, disableSelectOptions, z5, z6, i, 0, 32768, null);
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalFriendsParams(String str, PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, boolean z2, boolean z3, boolean z4, List<DisableSelectOption> disableSelectOptions, boolean z5, boolean z6, int i, int i2) {
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
        this.title = str;
        this.serviceTypeFilter = serviceTypeFilter;
        this.friendFilter = friendFilter;
        this.countryCodeFilters = countryCodeFilters;
        this.usingOsFilter = usingOsFilter;
        this.viewAppearance = viewAppearance;
        this.orientation = orientation;
        this.enableSearch = z;
        this.enableIndex = z2;
        this.showMyProfile = z3;
        this.showFavorite = z4;
        this.disableSelectOptions = disableSelectOptions;
        this.displayAllProfile = z5;
        this.showPickedFriend = z6;
        this.maxPickableCount = i;
        this.minPickableCount = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ InternalFriendsParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, boolean z, boolean z2, boolean z3, boolean z4, List list2, boolean z5, boolean z6, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_SERVICE_TYPE_FILTER() : pickerServiceTypeFilter, (i3 & 4) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_FRIEND_FILTER() : pickerFriendFilter, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? DefaultValues.INSTANCE.getDEFAULT_OS_FILTER() : pickerUsingOsFilter, (i3 & 32) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE() : viewAppearance, (i3 & 64) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION() : pickerOrientation, (i3 & 128) != 0 ? true : z, (i3 & 256) != 0 ? true : z2, (i3 & 512) != 0 ? true : z3, (i3 & 1024) != 0 ? true : z4, (i3 & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 4096) != 0 ? false : z5, (i3 & 8192) != 0 ? true : z6, (i3 & 16384) != 0 ? 30 : i, (i3 & 32768) != 0 ? 1 : i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getCountryCodeFilters() {
        return this.countryCodeFilters;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<DisableSelectOption> getDisableSelectOptions() {
        return this.disableSelectOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getDisplayAllProfile() {
        return this.displayAllProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getEnableIndex() {
        return this.enableIndex;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getEnableSearch() {
        return this.enableSearch;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PickerFriendFilter getFriendFilter() {
        return this.friendFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getMaxPickableCount() {
        return this.maxPickableCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getMinPickableCount() {
        return this.minPickableCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PickerOrientation getOrientation() {
        return this.orientation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PickerServiceTypeFilter getServiceTypeFilter() {
        return this.serviceTypeFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getShowFavorite() {
        return this.showFavorite;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getShowMyProfile() {
        return this.showMyProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getShowPickedFriend() {
        return this.showPickedFriend;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PickerUsingOsFilter getUsingOsFilter() {
        return this.usingOsFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ViewAppearance getViewAppearance() {
        return this.viewAppearance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.serviceTypeFilter.name());
        parcel.writeString(this.friendFilter.name());
        parcel.writeStringList(this.countryCodeFilters);
        parcel.writeString(this.usingOsFilter.name());
        parcel.writeString(this.viewAppearance.name());
        parcel.writeString(this.orientation.name());
        parcel.writeInt(this.enableSearch ? 1 : 0);
        parcel.writeInt(this.enableIndex ? 1 : 0);
        parcel.writeInt(this.showMyProfile ? 1 : 0);
        parcel.writeInt(this.showFavorite ? 1 : 0);
        List<DisableSelectOption> list = this.disableSelectOptions;
        parcel.writeInt(list.size());
        Iterator<DisableSelectOption> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.displayAllProfile ? 1 : 0);
        parcel.writeInt(this.showPickedFriend ? 1 : 0);
        parcel.writeInt(this.maxPickableCount);
        parcel.writeInt(this.minPickableCount);
    }

    /* renamed from: com.kakao.sdk.friend.internal.InternalFriendsParams$a */
    public static final class C2174a implements Parcelable.Creator<InternalFriendsParams> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public InternalFriendsParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            PickerServiceTypeFilter valueOf = PickerServiceTypeFilter.valueOf(parcel.readString());
            PickerFriendFilter valueOf2 = PickerFriendFilter.valueOf(parcel.readString());
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            PickerUsingOsFilter valueOf3 = PickerUsingOsFilter.valueOf(parcel.readString());
            ViewAppearance valueOf4 = ViewAppearance.valueOf(parcel.readString());
            PickerOrientation valueOf5 = PickerOrientation.valueOf(parcel.readString());
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(DisableSelectOption.CREATOR.createFromParcel(parcel));
            }
            return new InternalFriendsParams(readString, valueOf, valueOf2, createStringArrayList, valueOf3, valueOf4, valueOf5, z, z2, z3, z4, arrayList, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public InternalFriendsParams[] newArray(int i) {
            return new InternalFriendsParams[i];
        }
    }
}
