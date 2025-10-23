package com.kakao.sdk.partner.friend.model;

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

@Metadata(m837bv = {}, m838d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u000278B\u007f\b\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b5\u00106J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010#\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010)\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00069"}, m839d2 = {"Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "viewAppearance", "Lcom/kakao/sdk/friend/model/ViewAppearance;", "getViewAppearance", "()Lcom/kakao/sdk/friend/model/ViewAppearance;", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "orientation", "Lcom/kakao/sdk/friend/model/PickerOrientation;", "getOrientation", "()Lcom/kakao/sdk/friend/model/PickerOrientation;", "", "enableSearch", "Ljava/lang/Boolean;", "getEnableSearch", "()Ljava/lang/Boolean;", "", "Lcom/kakao/sdk/friend/model/DisableSelectOption;", "disableSelectOptions", "Ljava/util/List;", "getDisableSelectOptions", "()Ljava/util/List;", "displayAllProfile", "getDisplayAllProfile", "maxPickableCount", "Ljava/lang/Integer;", "getMaxPickableCount", "()Ljava/lang/Integer;", "minPickableCount", "getMinPickableCount", "Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$FriendsRequestParams;", "friendsParams", "Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$FriendsRequestParams;", "getFriendsParams", "()Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$FriendsRequestParams;", "Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$ChatRequestParams;", "chatParams", "Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$ChatRequestParams;", "getChatParams", "()Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$ChatRequestParams;", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/friend/model/ViewAppearance;Lcom/kakao/sdk/friend/model/PickerOrientation;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$FriendsRequestParams;Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$ChatRequestParams;)V", "ChatRequestParams", "FriendsRequestParams", "partner-friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class PickerTabRequestParams implements Parcelable {
    public static final Parcelable.Creator<PickerTabRequestParams> CREATOR = new Creator();
    private final ChatRequestParams chatParams;
    private final List<DisableSelectOption> disableSelectOptions;
    private final Boolean displayAllProfile;
    private final Boolean enableSearch;
    private final FriendsRequestParams friendsParams;
    private final Integer maxPickableCount;
    private final Integer minPickableCount;
    private final PickerOrientation orientation;
    private final String title;
    private final ViewAppearance viewAppearance;

    @Metadata(m837bv = {}, m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, m839d2 = {"Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$ChatRequestParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "selectionType", "Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "getSelectionType", "()Lcom/kakao/sdk/friend/model/PickerChatSelectionType;", "", "Lcom/kakao/sdk/friend/model/PickerChatFilter;", "chatFilters", "Ljava/util/List;", "getChatFilters", "()Ljava/util/List;", "<init>", "(Lcom/kakao/sdk/friend/model/PickerChatSelectionType;Ljava/util/List;)V", "partner-friend_release"}, m840k = 1, m841mv = {1, 6, 0})
    public static final class ChatRequestParams implements Parcelable {
        public static final Parcelable.Creator<ChatRequestParams> CREATOR = new Creator();
        private final List<PickerChatFilter> chatFilters;
        private final PickerChatSelectionType selectionType;

        @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
        public static final class Creator implements Parcelable.Creator<ChatRequestParams> {
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public final ChatRequestParams createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                PickerChatSelectionType valueOf = PickerChatSelectionType.valueOf(parcel.readString());
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int readInt = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(readInt);
                    for (int i = 0; i != readInt; i++) {
                        arrayList2.add(PickerChatFilter.valueOf(parcel.readString()));
                    }
                    arrayList = arrayList2;
                }
                return new ChatRequestParams(valueOf, arrayList);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public final ChatRequestParams[] newArray(int i) {
                return new ChatRequestParams[i];
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ChatRequestParams(PickerChatSelectionType selectionType) {
            this(selectionType, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ChatRequestParams(PickerChatSelectionType selectionType, List<? extends PickerChatFilter> list) {
            Intrinsics.checkNotNullParameter(selectionType, "selectionType");
            this.selectionType = selectionType;
            this.chatFilters = list;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ ChatRequestParams(PickerChatSelectionType pickerChatSelectionType, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
            if (list == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<PickerChatFilter> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeString(it.next().name());
            }
        }
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerTabRequestParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PickerTabRequestParams createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            ViewAppearance valueOf = parcel.readInt() == 0 ? null : ViewAppearance.valueOf(parcel.readString());
            PickerOrientation valueOf2 = parcel.readInt() == 0 ? null : PickerOrientation.valueOf(parcel.readString());
            Boolean valueOf3 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(parcel.readParcelable(PickerTabRequestParams.class.getClassLoader()));
                }
            }
            return new PickerTabRequestParams(readString, valueOf, valueOf2, valueOf3, arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, FriendsRequestParams.CREATOR.createFromParcel(parcel), ChatRequestParams.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PickerTabRequestParams[] newArray(int i) {
            return new PickerTabRequestParams[i];
        }
    }

    @Metadata(m837bv = {}, m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u0019\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u0019\u0010'\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"¨\u0006+"}, m839d2 = {"Lcom/kakao/sdk/partner/friend/model/PickerTabRequestParams$FriendsRequestParams;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "serviceTypeFilter", "Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "getServiceTypeFilter", "()Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "friendFilter", "Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "getFriendFilter", "()Lcom/kakao/sdk/friend/model/PickerFriendFilter;", "", "", "countryCodeFilters", "Ljava/util/List;", "getCountryCodeFilters", "()Ljava/util/List;", "Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "usingOsFilter", "Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "getUsingOsFilter", "()Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;", "", "enableIndex", "Ljava/lang/Boolean;", "getEnableIndex", "()Ljava/lang/Boolean;", "showMyProfile", "getShowMyProfile", "showFavorite", "getShowFavorite", "showPickedFriend", "getShowPickedFriend", "<init>", "(Lcom/kakao/sdk/friend/model/PickerServiceTypeFilter;Lcom/kakao/sdk/friend/model/PickerFriendFilter;Ljava/util/List;Lcom/kakao/sdk/friend/model/PickerUsingOsFilter;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "partner-friend_release"}, m840k = 1, m841mv = {1, 6, 0})
    public static final class FriendsRequestParams implements Parcelable {
        public static final Parcelable.Creator<FriendsRequestParams> CREATOR = new Creator();
        private final List<String> countryCodeFilters;
        private final Boolean enableIndex;
        private final PickerFriendFilter friendFilter;
        private final PickerServiceTypeFilter serviceTypeFilter;
        private final Boolean showFavorite;
        private final Boolean showMyProfile;
        private final Boolean showPickedFriend;
        private final PickerUsingOsFilter usingOsFilter;

        @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
        public static final class Creator implements Parcelable.Creator<FriendsRequestParams> {
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public final FriendsRequestParams createFromParcel(Parcel parcel) {
                Boolean valueOf;
                Boolean valueOf2;
                Boolean valueOf3;
                Boolean valueOf4;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                PickerServiceTypeFilter valueOf5 = parcel.readInt() == 0 ? null : PickerServiceTypeFilter.valueOf(parcel.readString());
                PickerFriendFilter valueOf6 = parcel.readInt() == 0 ? null : PickerFriendFilter.valueOf(parcel.readString());
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                PickerUsingOsFilter valueOf7 = parcel.readInt() == 0 ? null : PickerUsingOsFilter.valueOf(parcel.readString());
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
                return new FriendsRequestParams(valueOf5, valueOf6, createStringArrayList, valueOf7, valueOf, valueOf2, valueOf3, valueOf4);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public final FriendsRequestParams[] newArray(int i) {
                return new FriendsRequestParams[i];
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter) {
            this(pickerServiceTypeFilter, null, null, null, null, null, null, null, 254, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter) {
            this(pickerServiceTypeFilter, pickerFriendFilter, null, null, null, null, null, null, 252, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list) {
            this(pickerServiceTypeFilter, pickerFriendFilter, list, null, null, null, null, null, 248, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter) {
            this(pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, null, null, null, null, 240, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, Boolean bool) {
            this(pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, bool, null, null, null, 224, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, Boolean bool, Boolean bool2) {
            this(pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, bool, bool2, null, null, 192, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, Boolean bool, Boolean bool2, Boolean bool3) {
            this(pickerServiceTypeFilter, pickerFriendFilter, list, pickerUsingOsFilter, bool, bool2, bool3, null, 128, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List<String> list, PickerUsingOsFilter pickerUsingOsFilter, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
            this.serviceTypeFilter = pickerServiceTypeFilter;
            this.friendFilter = pickerFriendFilter;
            this.countryCodeFilters = list;
            this.usingOsFilter = pickerUsingOsFilter;
            this.enableIndex = bool;
            this.showMyProfile = bool2;
            this.showFavorite = bool3;
            this.showPickedFriend = bool4;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ FriendsRequestParams(PickerServiceTypeFilter pickerServiceTypeFilter, PickerFriendFilter pickerFriendFilter, List list, PickerUsingOsFilter pickerUsingOsFilter, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_SERVICE_TYPE_FILTER() : pickerServiceTypeFilter, (i & 2) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_FRIEND_FILTER() : pickerFriendFilter, (i & 4) != 0 ? null : list, (i & 8) != 0 ? DefaultValues.INSTANCE.getDEFAULT_OS_FILTER() : pickerUsingOsFilter, (i & 16) != 0 ? Boolean.TRUE : bool, (i & 32) != 0 ? Boolean.TRUE : bool2, (i & 64) != 0 ? Boolean.TRUE : bool3, (i & 128) != 0 ? Boolean.TRUE : bool4);
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
        public final Boolean getEnableIndex() {
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
        public final PickerUsingOsFilter getUsingOsFilter() {
            return this.usingOsFilter;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
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
            Boolean bool = this.enableIndex;
            if (bool == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool.booleanValue() ? 1 : 0);
            }
            Boolean bool2 = this.showMyProfile;
            if (bool2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool2.booleanValue() ? 1 : 0);
            }
            Boolean bool3 = this.showFavorite;
            if (bool3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool3.booleanValue() ? 1 : 0);
            }
            Boolean bool4 = this.showPickedFriend;
            if (bool4 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool4.booleanValue() ? 1 : 0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        this(null, null, null, null, null, null, null, null, friendsParams, chatParams, 255, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(String str, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        this(str, viewAppearance, pickerOrientation, null, null, null, null, null, friendsParams, chatParams, 248, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(String str, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        this(str, viewAppearance, pickerOrientation, bool, null, null, null, null, friendsParams, chatParams, 240, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(String str, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List<DisableSelectOption> list, FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        this(str, viewAppearance, pickerOrientation, bool, list, null, null, null, friendsParams, chatParams, 224, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(String str, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List<DisableSelectOption> list, Boolean bool2, FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        this(str, viewAppearance, pickerOrientation, bool, list, bool2, null, null, friendsParams, chatParams, 192, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(String str, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List<DisableSelectOption> list, Boolean bool2, Integer num, FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        this(str, viewAppearance, pickerOrientation, bool, list, bool2, num, null, friendsParams, chatParams, 128, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(String str, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List<DisableSelectOption> list, Boolean bool2, Integer num, Integer num2, FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
        this.title = str;
        this.viewAppearance = viewAppearance;
        this.orientation = pickerOrientation;
        this.enableSearch = bool;
        this.disableSelectOptions = list;
        this.displayAllProfile = bool2;
        this.maxPickableCount = num;
        this.minPickableCount = num2;
        this.friendsParams = friendsParams;
        this.chatParams = chatParams;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PickerTabRequestParams(String str, ViewAppearance viewAppearance, PickerOrientation pickerOrientation, Boolean bool, List list, Boolean bool2, Integer num, Integer num2, FriendsRequestParams friendsRequestParams, ChatRequestParams chatRequestParams, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_VIEW_APPEARANCE() : viewAppearance, (i & 4) != 0 ? DefaultValues.INSTANCE.getDEFAULT_PICKER_ORIENTATION() : pickerOrientation, (i & 8) != 0 ? Boolean.TRUE : bool, (i & 16) != 0 ? null : list, (i & 32) != 0 ? Boolean.FALSE : bool2, (i & 64) != 0 ? 30 : num, (i & 128) != 0 ? 1 : num2, friendsRequestParams, chatRequestParams);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(String str, ViewAppearance viewAppearance, FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        this(str, viewAppearance, null, null, null, null, null, null, friendsParams, chatParams, 252, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerTabRequestParams(String str, FriendsRequestParams friendsParams, ChatRequestParams chatParams) {
        this(str, null, null, null, null, null, null, null, friendsParams, chatParams, 254, null);
        Intrinsics.checkNotNullParameter(friendsParams, "friendsParams");
        Intrinsics.checkNotNullParameter(chatParams, "chatParams");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ChatRequestParams getChatParams() {
        return this.chatParams;
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
    public final FriendsRequestParams getFriendsParams() {
        return this.friendsParams;
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
        this.friendsParams.writeToParcel(parcel, flags);
        this.chatParams.writeToParcel(parcel, flags);
    }
}
