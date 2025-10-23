package com.kakao.sdk.partner.friend.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.PointerIconCompat;
import com.kakao.sdk.friend.model.DefaultValues;
import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.model.PickerChatFilter;
import com.kakao.sdk.friend.model.PickerChatSelectionType;
import com.kakao.sdk.friend.model.PickerOrientation;
import com.kakao.sdk.friend.model.ViewAppearance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0013\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010$\u001a\u0004\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001f\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018R\u0019\u0010+\u001a\u0004\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'R\u0019\u0010-\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00101\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100¨\u00065"}, m839d2 = {"Lcom/kakao/sdk/partner/friend/model/PickerChatRequestParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "selectionType", "Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "getSelectionType", "()Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/kakao/sdk/friend/model/PickerChatFilter;", "chatFilters", "Ljava/util/List;", "getChatFilters", "()Ljava/util/List;", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "viewAppearance", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "getViewAppearance", "()Lcom/kakao/sdk/friend/model/ViewAppearance;", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "orientation", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "getOrientation", "()Lcom/kakao/sdk/friend/model/PickerOrientation;", "", "enableSearch", "Ljava/lang/Boolean;", "getEnableSearch", "()Ljava/lang/Boolean;", "Lcom/kakao/sdk/friend/model/DisableSelectOption;", "disableSelectOptions", "getDisableSelectOptions", "displayAllProfile", "getDisplayAllProfile", "maxPickableCount", "Ljava/lang/Integer;", "getMaxPickableCount", "()Ljava/lang/Integer;", "minPickableCount", "getMinPickableCount", "<init>", "(Lcom/kakao/sdk/friend/model/PickerChatSelectionType;Ljava/lang/String;Ljava/util/List;Lcom/kakao/sdk/friend/model/ViewAppearance;Lcom/kakao/sdk/friend/model/PickerOrientation;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "partner-friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class PickerChatRequestParams implements Parcelable {
    public static final Parcelable.Creator<PickerChatRequestParams> CREATOR = new Creator();
    private final List<PickerChatFilter> chatFilters;
    private final List<DisableSelectOption> disableSelectOptions;
    private final Boolean displayAllProfile;
    private final Boolean enableSearch;
    private final Integer maxPickableCount;
    private final Integer minPickableCount;
    private final PickerOrientation orientation;
    private final PickerChatSelectionType selectionType;
    private final String title;
    private final ViewAppearance viewAppearance;

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerChatRequestParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PickerChatRequestParams createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            PickerChatSelectionType valueOf = PickerChatSelectionType.valueOf(parcel.readString());
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(PickerChatFilter.valueOf(parcel.readString()));
                }
            }
            ViewAppearance valueOf2 = parcel.readInt() == 0 ? null : ViewAppearance.valueOf(parcel.readString());
            PickerOrientation valueOf3 = parcel.readInt() == 0 ? null : PickerOrientation.valueOf(parcel.readString());
            Boolean valueOf4 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList2.add(parcel.readParcelable(PickerChatRequestParams.class.getClassLoader()));
                }
            }
            return new PickerChatRequestParams(valueOf, readString, arrayList, valueOf2, valueOf3, valueOf4, arrayList2, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PickerChatRequestParams[] newArray(int i) {
            return new PickerChatRequestParams[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType) {
        this(selectionType, null, null, null, null, null, null, null, null, null, 1022, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str) {
        this(selectionType, str, null, null, null, null, null, null, null, null, PointerIconCompat.TYPE_GRAB, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> list) {
        this(selectionType, str, list, null, null, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> list, ViewAppearance viewAppearance) {
        this(selectionType, str, list, viewAppearance, null, null, null, null, null, null, PointerIconCompat.TYPE_TEXT, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> list, ViewAppearance viewAppearance, PickerOrientation pickerOrientation) {
        this(selectionType, str, list, viewAppearance, pickerOrientation, null, null, null, null, null, 992, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> list, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool) {
        this(selectionType, str, list, viewAppearance, pickerOrientation, bool, null, null, null, null, 960, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> list, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List<DisableSelectOption> list2) {
        this(selectionType, str, list, viewAppearance, pickerOrientation, bool, list2, null, null, null, 896, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> list, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List<DisableSelectOption> list2, Boolean bool2) {
        this(selectionType, str, list, viewAppearance, pickerOrientation, bool, list2, bool2, null, null, 768, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> list, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List<DisableSelectOption> list2, Boolean bool2, Integer num) {
        this(selectionType, str, list, viewAppearance, pickerOrientation, bool, list2, bool2, num, null, 512, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatRequestParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> list, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List<DisableSelectOption> list2, Boolean bool2, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        this.selectionType = selectionType;
        this.title = str;
        this.chatFilters = list;
        this.viewAppearance = viewAppearance;
        this.orientation = pickerOrientation;
        this.enableSearch = bool;
        this.disableSelectOptions = list2;
        this.displayAllProfile = bool2;
        this.maxPickableCount = num;
        this.minPickableCount = num2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PickerChatRequestParams(PickerChatSelectionType pickerChatSelectionType, String str, List list, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List list2, Boolean bool2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pickerChatSelectionType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? CollectionsKt.listOf(DefaultValues.INSTANCE.getDEFAULT_PICKER_CHAT_FILTER()) : list, (i & 8) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE() : viewAppearance, (i & 16) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION() : pickerOrientation, (i & 32) != 0 ? Boolean.TRUE : bool, (i & 64) == 0 ? list2 : null, (i & 128) != 0 ? Boolean.FALSE : bool2, (i & 256) != 0 ? 30 : num, (i & 512) != 0 ? 1 : num2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<PickerChatFilter> getChatFilters() {
        return this.chatFilters;
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
    public final PickerChatSelectionType getSelectionType() {
        return this.selectionType;
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
        parcel.writeString(this.selectionType.name());
        parcel.writeString(this.title);
        List<PickerChatFilter> list = this.chatFilters;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<PickerChatFilter> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeString(it.next().name());
            }
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
        List<DisableSelectOption> list2 = this.disableSelectOptions;
        if (list2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            Iterator<DisableSelectOption> it2 = list2.iterator();
            while (it2.hasNext()) {
                parcel.writeParcelable(it2.next(), flags);
            }
        }
        Boolean bool2 = this.displayAllProfile;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
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
