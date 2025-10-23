package com.kakao.sdk.friend.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u008d\u0001\b\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0019\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u0019\u0010&\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u0019\u0010(\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\u0019\u0010*\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010.\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-¨\u00062"}, m839d2 = {"Lcom/kakao/sdk/friend/model/OpenPickerFriendRequestParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "serviceTypeFilter", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "getServiceTypeFilter", "()Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "viewAppearance", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "getViewAppearance", "()Lcom/kakao/sdk/friend/model/ViewAppearance;", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "orientation", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "getOrientation", "()Lcom/kakao/sdk/friend/model/PickerOrientation;", "", "enableSearch", "Ljava/lang/Boolean;", "getEnableSearch", "()Ljava/lang/Boolean;", "enableIndex", "getEnableIndex", "showMyProfile", "getShowMyProfile", "showFavorite", "getShowFavorite", "showPickedFriend", "getShowPickedFriend", "maxPickableCount", "Ljava/lang/Integer;", "getMaxPickableCount", "()Ljava/lang/Integer;", "minPickableCount", "getMinPickableCount", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;Lcom/kakao/sdk/friend/model/ViewAppearance;Lcom/kakao/sdk/friend/model/PickerOrientation;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class OpenPickerFriendRequestParams implements Parcelable {
    public static final Parcelable.Creator<OpenPickerFriendRequestParams> CREATOR = new Creator();
    private final Boolean enableIndex;
    private final Boolean enableSearch;
    private final Integer maxPickableCount;
    private final Integer minPickableCount;
    private final PickerOrientation orientation;
    private final PickerServiceTypeFilter serviceTypeFilter;
    private final Boolean showFavorite;
    private final Boolean showMyProfile;
    private final Boolean showPickedFriend;
    private final String title;
    private final ViewAppearance viewAppearance;

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<OpenPickerFriendRequestParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final OpenPickerFriendRequestParams createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            PickerServiceTypeFilter valueOf6 = parcel.readInt() == 0 ? null : PickerServiceTypeFilter.valueOf(parcel.readString());
            ViewAppearance valueOf7 = parcel.readInt() == 0 ? null : ViewAppearance.valueOf(parcel.readString());
            PickerOrientation valueOf8 = parcel.readInt() == 0 ? null : PickerOrientation.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf5 = null;
            } else {
                valueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new OpenPickerFriendRequestParams(readString, valueOf6, valueOf7, valueOf8, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final OpenPickerFriendRequestParams[] newArray(int i) {
            return new OpenPickerFriendRequestParams[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str) {
        this(str, null, null, null, null, null, null, null, null, null, null, 2046, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter) {
        this(str, pickerServiceTypeFilter, null, null, null, null, null, null, null, null, null, 2044, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance) {
        this(str, pickerServiceTypeFilter, viewAppearance, null, null, null, null, null, null, null, null, 2040, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation) {
        this(str, pickerServiceTypeFilter, viewAppearance, pickerOrientation, null, null, null, null, null, null, null, 2032, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool) {
        this(str, pickerServiceTypeFilter, viewAppearance, pickerOrientation, bool, null, null, null, null, null, null, 2016, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2) {
        this(str, pickerServiceTypeFilter, viewAppearance, pickerOrientation, bool, bool2, null, null, null, null, null, 1984, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3) {
        this(str, pickerServiceTypeFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, null, null, null, null, 1920, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this(str, pickerServiceTypeFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, bool4, null, null, null, 1792, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        this(str, pickerServiceTypeFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, bool4, bool5, null, null, 1536, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Integer num) {
        this(str, pickerServiceTypeFilter, viewAppearance, pickerOrientation, bool, bool2, bool3, bool4, bool5, num, null, 1024, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Integer num, Integer num2) {
        this.title = str;
        this.serviceTypeFilter = pickerServiceTypeFilter;
        this.viewAppearance = viewAppearance;
        this.orientation = pickerOrientation;
        this.enableSearch = bool;
        this.enableIndex = bool2;
        this.showMyProfile = bool3;
        this.showFavorite = bool4;
        this.showPickedFriend = bool5;
        this.maxPickableCount = num;
        this.minPickableCount = num2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ OpenPickerFriendRequestParams(String str, PickerServiceTypeFilter pickerServiceTypeFilter, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_SERVICE_TYPE_FILTER() : pickerServiceTypeFilter, (i & 4) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE() : viewAppearance, (i & 8) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION() : pickerOrientation, (i & 16) != 0 ? Boolean.TRUE : bool, (i & 32) != 0 ? Boolean.TRUE : bool2, (i & 64) != 0 ? Boolean.TRUE : bool3, (i & 128) != 0 ? Boolean.TRUE : bool4, (i & 256) != 0 ? Boolean.TRUE : bool5, (i & 512) != 0 ? 30 : num, (i & 1024) != 0 ? 1 : num2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        Boolean bool5 = this.showPickedFriend;
        if (bool5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
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
