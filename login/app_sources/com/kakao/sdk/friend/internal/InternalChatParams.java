package com.kakao.sdk.friend.internal;

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

@Metadata(m837bv = {}, m838d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001By\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0013\u0012\b\b\u0002\u0010+\u001a\u00020#\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002¢\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00138\u0006¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018R\u0017\u0010+\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'R\u0017\u0010-\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u00101\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100¨\u00065"}, m839d2 = {"Lcom/kakao/sdk/friend/internal/InternalChatParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "selectionType", "Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "getSelectionType", "()Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/kakao/sdk/friend/model/PickerChatFilter;", "chatFilters", "Ljava/util/List;", "getChatFilters", "()Ljava/util/List;", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "viewAppearance", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "getViewAppearance", "()Lcom/kakao/sdk/friend/model/ViewAppearance;", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "orientation", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "getOrientation", "()Lcom/kakao/sdk/friend/model/PickerOrientation;", "", "enableSearch", "Z", "getEnableSearch", "()Z", "Lcom/kakao/sdk/friend/model/DisableSelectOption;", "disableSelectOptions", "getDisableSelectOptions", "displayAllProfile", "getDisplayAllProfile", "maxPickableCount", "I", "getMaxPickableCount", "()I", "minPickableCount", "getMinPickableCount", "<init>", "(Lcom/kakao/sdk/friend/model/PickerChatSelectionType;Ljava/lang/String;Ljava/util/List;Lcom/kakao/sdk/friend/model/ViewAppearance;Lcom/kakao/sdk/friend/model/PickerOrientation;ZLjava/util/List;ZII)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class InternalChatParams implements Parcelable {
    public static final Parcelable.Creator<InternalChatParams> CREATOR = new C2173a();
    private final List<PickerChatFilter> chatFilters;
    private final List<DisableSelectOption> disableSelectOptions;
    private final boolean displayAllProfile;
    private final boolean enableSearch;
    private final int maxPickableCount;
    private final int minPickableCount;
    private final PickerOrientation orientation;
    private final PickerChatSelectionType selectionType;
    private final String title;
    private final ViewAppearance viewAppearance;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType) {
        this(selectionType, null, null, null, null, false, null, false, 0, 0, 1022, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str) {
        this(selectionType, str, null, null, null, false, null, false, 0, 0, PointerIconCompat.TYPE_GRAB, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> chatFilters) {
        this(selectionType, str, chatFilters, null, null, false, null, false, 0, 0, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> chatFilters, ViewAppearance viewAppearance) {
        this(selectionType, str, chatFilters, viewAppearance, null, false, null, false, 0, 0, PointerIconCompat.TYPE_TEXT, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> chatFilters, ViewAppearance viewAppearance, PickerOrientation orientation) {
        this(selectionType, str, chatFilters, viewAppearance, orientation, false, null, false, 0, 0, 992, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> chatFilters, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z) {
        this(selectionType, str, chatFilters, viewAppearance, orientation, z, null, false, 0, 0, 960, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> chatFilters, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, List<DisableSelectOption> disableSelectOptions) {
        this(selectionType, str, chatFilters, viewAppearance, orientation, z, disableSelectOptions, false, 0, 0, 896, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> chatFilters, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, List<DisableSelectOption> disableSelectOptions, boolean z2) {
        this(selectionType, str, chatFilters, viewAppearance, orientation, z, disableSelectOptions, z2, 0, 0, 768, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> chatFilters, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, List<DisableSelectOption> disableSelectOptions, boolean z2, int i) {
        this(selectionType, str, chatFilters, viewAppearance, orientation, z, disableSelectOptions, z2, i, 0, 512, null);
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalChatParams(PickerChatSelectionType selectionType, String str, List<? extends PickerChatFilter> chatFilters, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, List<DisableSelectOption> disableSelectOptions, boolean z2, int i, int i2) {
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
        this.selectionType = selectionType;
        this.title = str;
        this.chatFilters = chatFilters;
        this.viewAppearance = viewAppearance;
        this.orientation = orientation;
        this.enableSearch = z;
        this.disableSelectOptions = disableSelectOptions;
        this.displayAllProfile = z2;
        this.maxPickableCount = i;
        this.minPickableCount = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ InternalChatParams(PickerChatSelectionType pickerChatSelectionType, String str, List list, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, boolean z, List list2, boolean z2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(pickerChatSelectionType, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? CollectionsKt.listOf(DefaultValues.INSTANCE.getDEFAULT_PICKER_CHAT_FILTER()) : list, (i3 & 8) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE() : viewAppearance, (i3 & 16) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION() : pickerOrientation, (i3 & 32) != 0 ? true : z, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 128) != 0 ? false : z2, (i3 & 256) != 0 ? 30 : i, (i3 & 512) == 0 ? i2 : 1);
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
    public final boolean getDisplayAllProfile() {
        return this.displayAllProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getEnableSearch() {
        return this.enableSearch;
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
        parcel.writeInt(list.size());
        Iterator<PickerChatFilter> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
        parcel.writeString(this.viewAppearance.name());
        parcel.writeString(this.orientation.name());
        parcel.writeInt(this.enableSearch ? 1 : 0);
        List<DisableSelectOption> list2 = this.disableSelectOptions;
        parcel.writeInt(list2.size());
        Iterator<DisableSelectOption> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.displayAllProfile ? 1 : 0);
        parcel.writeInt(this.maxPickableCount);
        parcel.writeInt(this.minPickableCount);
    }

    /* renamed from: com.kakao.sdk.friend.internal.InternalChatParams$a */
    public static final class C2173a implements Parcelable.Creator<InternalChatParams> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public InternalChatParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            PickerChatSelectionType valueOf = PickerChatSelectionType.valueOf(parcel.readString());
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(PickerChatFilter.valueOf(parcel.readString()));
            }
            ViewAppearance valueOf2 = ViewAppearance.valueOf(parcel.readString());
            PickerOrientation valueOf3 = PickerOrientation.valueOf(parcel.readString());
            boolean z = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                arrayList2.add(DisableSelectOption.CREATOR.createFromParcel(parcel));
            }
            return new InternalChatParams(valueOf, readString, arrayList, valueOf2, valueOf3, z, arrayList2, parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public InternalChatParams[] newArray(int i) {
            return new InternalChatParams[i];
        }
    }
}
