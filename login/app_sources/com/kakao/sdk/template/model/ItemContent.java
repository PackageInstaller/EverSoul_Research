package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Components.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\"HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\"HÖ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006."}, m839d2 = {"Lcom/kakao/sdk/template/model/ItemContent;", "Landroid/os/Parcelable;", "profileText", "", "profileImageUrl", "titleImageText", "titleImageUrl", "titleImageCategory", FirebaseAnalytics.Param.ITEMS, "", "Lcom/kakao/sdk/template/model/ItemInfo;", "sum", "sumOp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getProfileImageUrl", "()Ljava/lang/String;", "getProfileText", "getSum", "getSumOp", "getTitleImageCategory", "getTitleImageText", "getTitleImageUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ItemContent implements Parcelable {
    public static final Parcelable.Creator<ItemContent> CREATOR = new Creator();
    private final List<ItemInfo> items;
    private final String profileImageUrl;
    private final String profileText;
    private final String sum;
    private final String sumOp;
    private final String titleImageCategory;
    private final String titleImageText;
    private final String titleImageUrl;

    /* compiled from: Components.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ItemContent> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ItemContent createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(ItemInfo.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new ItemContent(readString, readString2, readString3, readString4, readString5, arrayList, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ItemContent[] newArray(int i) {
            return new ItemContent[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent(String str) {
        this(str, null, null, null, null, null, null, null, 254, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent(String str, String str2) {
        this(str, str2, null, null, null, null, null, null, 252, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent(String str, String str2, String str3) {
        this(str, str2, str3, null, null, null, null, null, 248, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, null, null, null, null, 240, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, null, null, null, 224, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent(String str, String str2, String str3, String str4, String str5, List<ItemInfo> list) {
        this(str, str2, str3, str4, str5, list, null, null, 192, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent(String str, String str2, String str3, String str4, String str5, List<ItemInfo> list, String str6) {
        this(str, str2, str3, str4, str5, list, str6, null, 128, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.profileText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.profileImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.titleImageText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.titleImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component5() {
        return this.titleImageCategory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<ItemInfo> component6() {
        return this.items;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component7() {
        return this.sum;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component8() {
        return this.sumOp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ItemContent copy(String profileText, String profileImageUrl, String titleImageText, String titleImageUrl, String titleImageCategory, List<ItemInfo> items, String sum, String sumOp) {
        return new ItemContent(profileText, profileImageUrl, titleImageText, titleImageUrl, titleImageCategory, items, sum, sumOp);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemContent)) {
            return false;
        }
        ItemContent itemContent = (ItemContent) other;
        return Intrinsics.areEqual(this.profileText, itemContent.profileText) && Intrinsics.areEqual(this.profileImageUrl, itemContent.profileImageUrl) && Intrinsics.areEqual(this.titleImageText, itemContent.titleImageText) && Intrinsics.areEqual(this.titleImageUrl, itemContent.titleImageUrl) && Intrinsics.areEqual(this.titleImageCategory, itemContent.titleImageCategory) && Intrinsics.areEqual(this.items, itemContent.items) && Intrinsics.areEqual(this.sum, itemContent.sum) && Intrinsics.areEqual(this.sumOp, itemContent.sumOp);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.profileText;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.profileImageUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.titleImageText;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.titleImageUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.titleImageCategory;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<ItemInfo> list = this.items;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str6 = this.sum;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sumOp;
        return hashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ItemContent(profileText=" + ((Object) this.profileText) + ", profileImageUrl=" + ((Object) this.profileImageUrl) + ", titleImageText=" + ((Object) this.titleImageText) + ", titleImageUrl=" + ((Object) this.titleImageUrl) + ", titleImageCategory=" + ((Object) this.titleImageCategory) + ", items=" + this.items + ", sum=" + ((Object) this.sum) + ", sumOp=" + ((Object) this.sumOp) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.profileText);
        parcel.writeString(this.profileImageUrl);
        parcel.writeString(this.titleImageText);
        parcel.writeString(this.titleImageUrl);
        parcel.writeString(this.titleImageCategory);
        List<ItemInfo> list = this.items;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<ItemInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.sum);
        parcel.writeString(this.sumOp);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ItemContent(String str, String str2, String str3, String str4, String str5, List<ItemInfo> list, String str6, String str7) {
        this.profileText = str;
        this.profileImageUrl = str2;
        this.titleImageText = str3;
        this.titleImageUrl = str4;
        this.titleImageCategory = str5;
        this.items = list;
        this.sum = str6;
        this.sumOp = str7;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ItemContent(String str, String str2, String str3, String str4, String str5, List list, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileText() {
        return this.profileText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitleImageText() {
        return this.titleImageText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitleImageUrl() {
        return this.titleImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitleImageCategory() {
        return this.titleImageCategory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<ItemInfo> getItems() {
        return this.items;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSum() {
        return this.sum;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSumOp() {
        return this.sumOp;
    }
}
