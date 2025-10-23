package com.kakao.sdk.friend.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.friend.model.DefaultValues;
import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.model.PickerChatFilter;
import com.kakao.sdk.friend.model.PickerChatSelectionType;
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

@Metadata(m837bv = {}, m838d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u000278Bq\b\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b5\u00106J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR\u0017\u0010%\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010)\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00069"}, m839d2 = {"Lcom/kakao/sdk/friend/internal/InternalTabParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "viewAppearance", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "getViewAppearance", "()Lcom/kakao/sdk/friend/model/ViewAppearance;", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "orientation", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "getOrientation", "()Lcom/kakao/sdk/friend/model/PickerOrientation;", "", "enableSearch", "Z", "getEnableSearch", "()Z", "", "Lcom/kakao/sdk/friend/model/DisableSelectOption;", "disableSelectOptions", "Ljava/util/List;", "getDisableSelectOptions", "()Ljava/util/List;", "displayAllProfile", "getDisplayAllProfile", "maxPickableCount", "I", "getMaxPickableCount", "()I", "minPickableCount", "getMinPickableCount", "Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalFriendsParams;", "friendsParams", "Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalFriendsParams;", "getFriendsParams", "()Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalFriendsParams;", "Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalChatParams;", "chatParams", "Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalChatParams;", "getChatParams", "()Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalChatParams;", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/friend/model/ViewAppearance;Lcom/kakao/sdk/friend/model/PickerOrientation;ZLjava/util/List;ZIILcom/kakao/sdk/friend/internal/InternalTabParams$InternalFriendsParams;Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalChatParams;)V", "InternalChatParams", "InternalFriendsParams", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class InternalTabParams implements Parcelable {
    public static final Parcelable.Creator<InternalTabParams> CREATOR = new C2177a();
    private final InternalChatParams chatParams;
    private final List<DisableSelectOption> disableSelectOptions;
    private final boolean displayAllProfile;
    private final boolean enableSearch;
    private final InternalFriendsParams friendsParams;
    private final int maxPickableCount;
    private final int minPickableCount;
    private final PickerOrientation orientation;
    private final String title;
    private final ViewAppearance viewAppearance;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        this(null, null, null, false, null, false, 0, 0, friendsParams, chatParams, 255, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(String str, InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        this(str, null, null, false, null, false, 0, 0, friendsParams, chatParams, 254, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(String str, ViewAppearance viewAppearance, InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        this(str, viewAppearance, null, false, null, false, 0, 0, friendsParams, chatParams, 252, null);
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(String str, ViewAppearance viewAppearance, PickerOrientation orientation, InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        this(str, viewAppearance, orientation, false, null, false, 0, 0, friendsParams, chatParams, 248, null);
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(String str, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        this(str, viewAppearance, orientation, z, null, false, 0, 0, friendsParams, chatParams, 240, null);
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(String str, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, List<DisableSelectOption> disableSelectOptions, InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        this(str, viewAppearance, orientation, z, disableSelectOptions, false, 0, 0, friendsParams, chatParams, 224, null);
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(String str, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, List<DisableSelectOption> disableSelectOptions, boolean z2, int i, int i2, InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
        this.title = str;
        this.viewAppearance = viewAppearance;
        this.orientation = orientation;
        this.enableSearch = z;
        this.disableSelectOptions = disableSelectOptions;
        this.displayAllProfile = z2;
        this.maxPickableCount = i;
        this.minPickableCount = i2;
        this.friendsParams = friendsParams;
        this.chatParams = chatParams;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ InternalTabParams(String str, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, boolean z, List list, boolean z2, int i, int i2, InternalFriendsParams internalFriendsParams, InternalChatParams internalChatParams, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE() : viewAppearance, (i3 & 4) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION() : pickerOrientation, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? 30 : i, (i3 & 128) != 0 ? 1 : i2, internalFriendsParams, internalChatParams);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(String str, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, List<DisableSelectOption> disableSelectOptions, boolean z2, int i, InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        this(str, viewAppearance, orientation, z, disableSelectOptions, z2, i, 0, friendsParams, chatParams, 128, null);
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InternalTabParams(String str, ViewAppearance viewAppearance, PickerOrientation orientation, boolean z, List<DisableSelectOption> disableSelectOptions, boolean z2, InternalFriendsParams friendsParams, InternalChatParams chatParams) {
        this(str, viewAppearance, orientation, z, disableSelectOptions, z2, 0, 0, friendsParams, chatParams, 192, null);
        Intrinsics.checkNotNullParameter(viewAppearance, "viewAppearance");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(disableSelectOptions, "disableSelectOptions");
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InternalChatParams getChatParams() {
        return this.chatParams;
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
    public final InternalFriendsParams getFriendsParams() {
        return this.friendsParams;
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
        parcel.writeString(this.viewAppearance.name());
        parcel.writeString(this.orientation.name());
        parcel.writeInt(this.enableSearch ? 1 : 0);
        List<DisableSelectOption> list = this.disableSelectOptions;
        parcel.writeInt(list.size());
        Iterator<DisableSelectOption> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.displayAllProfile ? 1 : 0);
        parcel.writeInt(this.maxPickableCount);
        parcel.writeInt(this.minPickableCount);
        this.friendsParams.writeToParcel(parcel, flags);
        this.chatParams.writeToParcel(parcel, flags);
    }

    @Metadata(m837bv = {}, m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, m839d2 = {"Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalChatParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "selectionType", "Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "getSelectionType", "()Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "", "Lcom/kakao/sdk/friend/model/PickerChatFilter;", "chatFilters", "Ljava/util/List;", "getChatFilters", "()Ljava/util/List;", "<init>", "(Lcom/kakao/sdk/friend/model/PickerChatSelectionType;Ljava/util/List;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
    public static final class InternalChatParams implements Parcelable {
        public static final Parcelable.Creator<InternalChatParams> CREATOR = new C2175a();
        private final List<PickerChatFilter> chatFilters;
        private final PickerChatSelectionType selectionType;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalChatParams(PickerChatSelectionType selectionType) {
            this(selectionType, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalChatParams(PickerChatSelectionType selectionType, List<? extends PickerChatFilter> chatFilters) {
            Intrinsics.checkNotNullParameter(selectionType, "selectionType");
            Intrinsics.checkNotNullParameter(chatFilters, "chatFilters");
            this.selectionType = selectionType;
            this.chatFilters = chatFilters;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ InternalChatParams(PickerChatSelectionType pickerChatSelectionType, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(pickerChatSelectionType, (i & 2) != 0 ? CollectionsKt.listOf(DefaultValues.INSTANCE.getDEFAULT_PICKER_CHAT_FILTER()) : list);
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
        public final PickerChatSelectionType getSelectionType() {
            return this.selectionType;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.selectionType.name());
            List<PickerChatFilter> list = this.chatFilters;
            parcel.writeInt(list.size());
            Iterator<PickerChatFilter> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeString(it.next().name());
            }
        }

        /* renamed from: com.kakao.sdk.friend.internal.InternalTabParams$InternalChatParams$a */
        public static final class C2175a implements Parcelable.Creator<InternalChatParams> {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public InternalChatParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                PickerChatSelectionType valueOf = PickerChatSelectionType.valueOf(parcel.readString());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(PickerChatFilter.valueOf(parcel.readString()));
                }
                return new InternalChatParams(valueOf, arrayList);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public InternalChatParams[] newArray(int i) {
                return new InternalChatParams[i];
            }
        }
    }

    @Metadata(m837bv = {}, m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B_\b\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u0012\b\b\u0002\u0010%\u001a\u00020\u001e\u0012\b\b\u0002\u0010'\u001a\u00020\u001e¢\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010%\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u0017\u0010'\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"¨\u0006+"}, m839d2 = {"Lcom/kakao/sdk/friend/internal/InternalTabParams$InternalFriendsParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "serviceTypeFilter", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "getServiceTypeFilter", "()Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "friendFilter", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "getFriendFilter", "()Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "", "", "countryCodeFilters", "Ljava/util/List;", "getCountryCodeFilters", "()Ljava/util/List;", "Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "usingOsFilter", "Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "getUsingOsFilter", "()Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "", "enableIndex", "Z", "getEnableIndex", "()Z", "showMyProfile", "getShowMyProfile", "showFavorite", "getShowFavorite", "showPickedFriend", "getShowPickedFriend", "<init>", "(Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;Lcom/kakao/sdk/friend/model/PickerFriendFilter;Ljava/util/List;Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;ZZZZ)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
    public static final class InternalFriendsParams implements Parcelable {
        public static final Parcelable.Creator<InternalFriendsParams> CREATOR = new C2176a();
        private final List<String> countryCodeFilters;
        private final boolean enableIndex;
        private final PickerFriendFilter friendFilter;
        private final PickerServiceTypeFilter serviceTypeFilter;
        private final boolean showFavorite;
        private final boolean showMyProfile;
        private final boolean showPickedFriend;
        private final PickerUsingOsFilter usingOsFilter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams() {
            this(null, null, null, null, false, false, false, false, 255, null);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams(PickerServiceTypeFilter serviceTypeFilter) {
            this(serviceTypeFilter, null, null, null, false, false, false, false, 254, null);
            Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams(PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter) {
            this(serviceTypeFilter, friendFilter, null, null, false, false, false, false, 252, null);
            Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
            Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams(PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters) {
            this(serviceTypeFilter, friendFilter, countryCodeFilters, null, false, false, false, false, 248, null);
            Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
            Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
            Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams(PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter) {
            this(serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, false, false, false, false, 240, null);
            Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
            Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
            Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
            Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams(PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, boolean z) {
            this(serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, z, false, false, false, 224, null);
            Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
            Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
            Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
            Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams(PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, boolean z, boolean z2) {
            this(serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, z, z2, false, false, 192, null);
            Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
            Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
            Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
            Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams(PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, boolean z, boolean z2, boolean z3) {
            this(serviceTypeFilter, friendFilter, countryCodeFilters, usingOsFilter, z, z2, z3, false, 128, null);
            Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
            Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
            Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
            Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InternalFriendsParams(PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> countryCodeFilters, PickerUsingOsFilter usingOsFilter, boolean z, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
            Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
            Intrinsics.checkNotNullParameter(countryCodeFilters, "countryCodeFilters");
            Intrinsics.checkNotNullParameter(usingOsFilter, "usingOsFilter");
            this.serviceTypeFilter = serviceTypeFilter;
            this.friendFilter = friendFilter;
            this.countryCodeFilters = countryCodeFilters;
            this.usingOsFilter = usingOsFilter;
            this.enableIndex = z;
            this.showMyProfile = z2;
            this.showFavorite = z3;
            this.showPickedFriend = z4;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ InternalFriendsParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List list, PickerUsingOsFilter pickerUsingOsFilter, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_SERVICE_TYPE_FILTER() : pickerServiceTypeFilter, (i & 2) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_FRIEND_FILTER() : pickerFriendFilter, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? DefaultValues.INSTANCE.getDEFAULT_OS_FILTER() : pickerUsingOsFilter, (i & 16) != 0 ? true : z, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? true : z3, (i & 128) == 0 ? z4 : true);
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
        public final boolean getEnableIndex() {
            return this.enableIndex;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final PickerFriendFilter getFriendFilter() {
            return this.friendFilter;
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
        public final PickerUsingOsFilter getUsingOsFilter() {
            return this.usingOsFilter;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.serviceTypeFilter.name());
            parcel.writeString(this.friendFilter.name());
            parcel.writeStringList(this.countryCodeFilters);
            parcel.writeString(this.usingOsFilter.name());
            parcel.writeInt(this.enableIndex ? 1 : 0);
            parcel.writeInt(this.showMyProfile ? 1 : 0);
            parcel.writeInt(this.showFavorite ? 1 : 0);
            parcel.writeInt(this.showPickedFriend ? 1 : 0);
        }

        /* renamed from: com.kakao.sdk.friend.internal.InternalTabParams$InternalFriendsParams$a */
        public static final class C2176a implements Parcelable.Creator<InternalFriendsParams> {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public InternalFriendsParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new InternalFriendsParams(PickerServiceTypeFilter.valueOf(parcel.readString()), PickerFriendFilter.valueOf(parcel.readString()), parcel.createStringArrayList(), PickerUsingOsFilter.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public InternalFriendsParams[] newArray(int i) {
                return new InternalFriendsParams[i];
            }
        }
    }

    /* renamed from: com.kakao.sdk.friend.internal.InternalTabParams$a */
    public static final class C2177a implements Parcelable.Creator<InternalTabParams> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public InternalTabParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            ViewAppearance valueOf = ViewAppearance.valueOf(parcel.readString());
            PickerOrientation valueOf2 = PickerOrientation.valueOf(parcel.readString());
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(DisableSelectOption.CREATOR.createFromParcel(parcel));
            }
            return new InternalTabParams(readString, valueOf, valueOf2, z, arrayList, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), InternalFriendsParams.CREATOR.createFromParcel(parcel), InternalChatParams.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public InternalTabParams[] newArray(int i) {
            return new InternalTabParams[i];
        }
    }
}
