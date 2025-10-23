package com.kakao.sdk.partner.friend.model;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001BÕ\u0001\b\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010,\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u0018\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bD\u0010EJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010#\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010(\u001a\u0004\u0018\u00010'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010-\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00101\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u0019\u00103\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R\u0019\u00105\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R\u001f\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\u001cR\u0019\u0010:\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b:\u0010.\u001a\u0004\b;\u00100R\u0019\u0010<\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b<\u0010.\u001a\u0004\b=\u00100R\u0019\u0010>\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010B\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bB\u0010?\u001a\u0004\bC\u0010A¨\u0006F"}, m839d2 = {"Lcom/kakao/sdk/partner/friend/model/PickerFriendRequestParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "serviceTypeFilter", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "getServiceTypeFilter", "()Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "friendFilter", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "getFriendFilter", "()Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "", "countryCodeFilters", "Ljava/util/List;", "getCountryCodeFilters", "()Ljava/util/List;", "Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "usingOsFilter", "Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "getUsingOsFilter", "()Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "viewAppearance", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "getViewAppearance", "()Lcom/kakao/sdk/friend/model/ViewAppearance;", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "orientation", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "getOrientation", "()Lcom/kakao/sdk/friend/model/PickerOrientation;", "", "enableSearch", "Ljava/lang/Boolean;", "getEnableSearch", "()Ljava/lang/Boolean;", "enableIndex", "getEnableIndex", "showMyProfile", "getShowMyProfile", "showFavorite", "getShowFavorite", "Lcom/kakao/sdk/friend/model/DisableSelectOption;", "disableSelectOptions", "getDisableSelectOptions", "displayAllProfile", "getDisplayAllProfile", "showPickedFriend", "getShowPickedFriend", "maxPickableCount", "Ljava/lang/Integer;", "getMaxPickableCount", "()Ljava/lang/Integer;", "minPickableCount", "getMinPickableCount", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;Lcom/kakao/sdk/friend/model/PickerFriendFilter;Ljava/util/List;Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;Lcom/kakao/sdk/friend/model/ViewAppearance;Lcom/kakao/sdk/friend/model/PickerOrientation;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "partner-friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class PickerFriendRequestParams implements Parcelable {
    public static final Parcelable.Creator<PickerFriendRequestParams> CREATOR = new Creator();
    private final List<String> countryCodeFilters;
    private final List<DisableSelectOption> disableSelectOptions;
    private final Boolean displayAllProfile;
    private final Boolean enableIndex;
    private final Boolean enableSearch;
    private final PickerFriendFilter friendFilter;
    private final Integer maxPickableCount;
    private final Integer minPickableCount;
    private final PickerOrientation orientation;
    private final PickerServiceTypeFilter serviceTypeFilter;
    private final Boolean showFavorite;
    private final Boolean showMyProfile;
    private final Boolean showPickedFriend;
    private final String title;
    private final PickerUsingOsFilter usingOsFilter;
    private final ViewAppearance viewAppearance;

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerFriendRequestParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PickerFriendRequestParams createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            PickerServiceTypeFilter valueOf = parcel.readInt() == 0 ? null : PickerServiceTypeFilter.valueOf(parcel.readString());
            PickerFriendFilter valueOf2 = parcel.readInt() == 0 ? null : PickerFriendFilter.valueOf(parcel.readString());
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            PickerUsingOsFilter valueOf3 = parcel.readInt() == 0 ? null : PickerUsingOsFilter.valueOf(parcel.readString());
            ViewAppearance valueOf4 = parcel.readInt() == 0 ? null : ViewAppearance.valueOf(parcel.readString());
            PickerOrientation valueOf5 = parcel.readInt() == 0 ? null : PickerOrientation.valueOf(parcel.readString());
            Boolean valueOf6 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean valueOf7 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean valueOf8 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean valueOf9 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(parcel.readParcelable(PickerFriendRequestParams.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new PickerFriendRequestParams(readString, valueOf, valueOf2, createStringArrayList, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, valueOf8, valueOf9, arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PickerFriendRequestParams[] newArray(int i) {
            return new PickerFriendRequestParams[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str) {
        this(str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65534, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter) {
        this(str, pickerServiceTypeFilter, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65532, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, null, null, null, null, null, null, null, null, null, null, null, null, null, 65528, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, null, null, null, null, null, null, null, null, null, null, null, null, 65520, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, null, null, null, null, null, null, null, null, null, null, null, 65504, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, null, null, null, null, null, null, null, null, null, null, 65472, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, null, null, null, null, null, null, null, null, null, 65408, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, bool, null, null, null, null, null, null, null, null, MotionEventCompat.ACTION_POINTER_INDEX_MASK, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, bool, bool2, null, null, null, null, null, null, null, 65024, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, null, null, null, null, null, null, 64512, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, bool4, null, null, null, null, null, 63488, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List<DisableSelectOption> list2) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, bool4, list2, null, null, null, null, 61440, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List<DisableSelectOption> list2, Boolean bool5) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, bool4, list2, bool5, null, null, null, 57344, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List<DisableSelectOption> list2, Boolean bool5, Boolean bool6) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, bool4, list2, bool5, bool6, null, null, 49152, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List<DisableSelectOption> list2, Boolean bool5, Boolean bool6, Integer num) {
        this(str, pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, bool4, list2, bool5, bool6, num, null, 32768, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List<DisableSelectOption> list2, Boolean bool5, Boolean bool6, Integer num, Integer num2) {
        this.title = str;
        this.serviceTypeFilter = pickerServiceTypeFilter;
        this.friendFilter = pickerFriendFilter;
        this.countryCodeFilters = list;
        this.usingOsFilter = pickerUsingOsFilter;
        this.viewAppearance = viewAppearance;
        this.orientation = pickerOrientation;
        this.enableSearch = bool;
        this.enableIndex = bool2;
        this.showMyProfile = bool3;
        this.showFavorite = bool4;
        this.disableSelectOptions = list2;
        this.displayAllProfile = bool5;
        this.showPickedFriend = bool6;
        this.maxPickableCount = num;
        this.minPickableCount = num2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List list, PickerUsingOsFilter pickerUsingOsFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List list2, Boolean bool5, Boolean bool6, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_SERVICE_TYPE_FILTER() : pickerServiceTypeFilter, (i & 4) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_FRIEND_FILTER() : pickerFriendFilter, (i & 8) != 0 ? null : list, (i & 16) != 0 ? DefaultValues.INSTANCE.getDEFAULT_OS_FILTER() : pickerUsingOsFilter, (i & 32) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE() : viewAppearance, (i & 64) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION() : pickerOrientation, (i & 128) != 0 ? Boolean.TRUE : bool, (i & 256) != 0 ? Boolean.TRUE : bool2, (i & 512) != 0 ? Boolean.TRUE : bool3, (i & 1024) != 0 ? Boolean.TRUE : bool4, (i & 2048) == 0 ? list2 : null, (i & 4096) != 0 ? Boolean.FALSE : bool5, (i & 8192) != 0 ? Boolean.TRUE : bool6, (i & 16384) != 0 ? 30 : num, (i & 32768) != 0 ? 1 : num2);
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
    public final Boolean getDisplayAllProfile() {
        return this.displayAllProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getEnableIndex() {
        return this.enableIndex;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getEnableSearch() {
        return this.enableSearch;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PickerFriendFilter getFriendFilter() {
        return this.friendFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getMaxPickableCount() {
        return this.maxPickableCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getMinPickableCount() {
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
    public final Boolean getShowFavorite() {
        return this.showFavorite;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getShowMyProfile() {
        return this.showMyProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getShowPickedFriend() {
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
        PickerServiceTypeFilter pickerServiceTypeFilter = this.serviceTypeFilter;
        if (pickerServiceTypeFilter == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(pickerServiceTypeFilter.name());
        }
        PickerFriendFilter pickerFriendFilter = this.friendFilter;
        if (pickerFriendFilter == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(pickerFriendFilter.name());
        }
        parcel.writeStringList(this.countryCodeFilters);
        PickerUsingOsFilter pickerUsingOsFilter = this.usingOsFilter;
        if (pickerUsingOsFilter == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(pickerUsingOsFilter.name());
        }
        ViewAppearance viewAppearance = this.viewAppearance;
        if (viewAppearance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(viewAppearance.name());
        }
        PickerOrientation pickerOrientation = this.orientation;
        if (pickerOrientation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(pickerOrientation.name());
        }
        Boolean bool = this.enableSearch;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.enableIndex;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.showMyProfile;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.showFavorite;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        List<DisableSelectOption> list = this.disableSelectOptions;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<DisableSelectOption> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable(it.next(), flags);
            }
        }
        Boolean bool5 = this.displayAllProfile;
        if (bool5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        Boolean bool6 = this.showPickedFriend;
        if (bool6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        Integer num = this.maxPickableCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.minPickableCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
    }
}
