package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.template.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Templates.kt */
@Metadata(m838d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BM\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003JS\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, m839d2 = {"Lcom/kakao/sdk/template/model/LocationTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "address", "", "content", "Lcom/kakao/sdk/template/model/Content;", "addressTitle", "social", "Lcom/kakao/sdk/template/model/Social;", Constants.BUTTONS, "", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Content;Ljava/lang/String;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAddressTitle", "getButtonTitle", "getButtons", "()Ljava/util/List;", "getContent", "()Lcom/kakao/sdk/template/model/Content;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "getSocial", "()Lcom/kakao/sdk/template/model/Social;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LocationTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<LocationTemplate> CREATOR = new Creator();
    private final String address;
    private final String addressTitle;
    private final String buttonTitle;
    private final List<Button> buttons;
    private final Content content;
    private final String objectType;
    private final Social social;

    /* compiled from: Templates.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<LocationTemplate> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final LocationTemplate createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Content createFromParcel = Content.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            ArrayList arrayList = null;
            Social createFromParcel2 = parcel.readInt() == 0 ? null : Social.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(Button.CREATOR.createFromParcel(parcel));
                }
            }
            return new LocationTemplate(readString, createFromParcel, readString2, createFromParcel2, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final LocationTemplate[] newArray(int i) {
            return new LocationTemplate[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationTemplate(String address, Content content) {
        this(address, content, null, null, null, null, 60, null);
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationTemplate(String address, Content content, String str) {
        this(address, content, str, null, null, null, 56, null);
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationTemplate(String address, Content content, String str, Social social) {
        this(address, content, str, social, null, null, 48, null);
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationTemplate(String address, Content content, String str, Social social, List<Button> list) {
        this(address, content, str, social, list, null, 32, null);
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ LocationTemplate copy$default(LocationTemplate locationTemplate, String str, Content content, String str2, Social social, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = locationTemplate.address;
        }
        if ((i & 2) != 0) {
            content = locationTemplate.content;
        }
        Content content2 = content;
        if ((i & 4) != 0) {
            str2 = locationTemplate.addressTitle;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            social = locationTemplate.social;
        }
        Social social2 = social;
        if ((i & 16) != 0) {
            list = locationTemplate.buttons;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            str3 = locationTemplate.buttonTitle;
        }
        return locationTemplate.copy(str, content2, str4, social2, list2, str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getObjectType$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.address;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Content component2() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.addressTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Social component4() {
        return this.social;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Button> component5() {
        return this.buttons;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component6() {
        return this.buttonTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final LocationTemplate copy(String address, Content content, String addressTitle, Social social, List<Button> buttons, String buttonTitle) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(content, "content");
        return new LocationTemplate(address, content, addressTitle, social, buttons, buttonTitle);
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
        if (!(other instanceof LocationTemplate)) {
            return false;
        }
        LocationTemplate locationTemplate = (LocationTemplate) other;
        return Intrinsics.areEqual(this.address, locationTemplate.address) && Intrinsics.areEqual(this.content, locationTemplate.content) && Intrinsics.areEqual(this.addressTitle, locationTemplate.addressTitle) && Intrinsics.areEqual(this.social, locationTemplate.social) && Intrinsics.areEqual(this.buttons, locationTemplate.buttons) && Intrinsics.areEqual(this.buttonTitle, locationTemplate.buttonTitle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((this.address.hashCode() * 31) + this.content.hashCode()) * 31;
        String str = this.addressTitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Social social = this.social;
        int hashCode3 = (hashCode2 + (social == null ? 0 : social.hashCode())) * 31;
        List<Button> list = this.buttons;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.buttonTitle;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "LocationTemplate(address=" + this.address + ", content=" + this.content + ", addressTitle=" + ((Object) this.addressTitle) + ", social=" + this.social + ", buttons=" + this.buttons + ", buttonTitle=" + ((Object) this.buttonTitle) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.address);
        this.content.writeToParcel(parcel, flags);
        parcel.writeString(this.addressTitle);
        Social social = this.social;
        if (social == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            social.writeToParcel(parcel, flags);
        }
        List<Button> list = this.buttons;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<Button> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.buttonTitle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationTemplate(String address, Content content, String str, Social social, List<Button> list, String str2) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(content, "content");
        this.address = address;
        this.content = content;
        this.addressTitle = str;
        this.social = social;
        this.buttons = list;
        this.buttonTitle = str2;
        this.objectType = "location";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ LocationTemplate(String str, Content content, String str2, Social social, List list, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, content, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : social, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAddress() {
        return this.address;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Content getContent() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAddressTitle() {
        return this.addressTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Social getSocial() {
        return this.social;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Button> getButtons() {
        return this.buttons;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getObjectType() {
        return this.objectType;
    }
}
