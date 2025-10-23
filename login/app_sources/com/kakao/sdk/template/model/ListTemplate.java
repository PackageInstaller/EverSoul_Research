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
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BC\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000f¨\u0006-"}, m839d2 = {"Lcom/kakao/sdk/template/model/ListTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "headerTitle", "", "headerLink", "Lcom/kakao/sdk/template/model/Link;", Constants.CONTENTS, "", "Lcom/kakao/sdk/template/model/Content;", Constants.BUTTONS, "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getContents", "getHeaderLink", "()Lcom/kakao/sdk/template/model/Link;", "getHeaderTitle", "objectType", "getObjectType$annotations", "()V", "getObjectType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ListTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<ListTemplate> CREATOR = new Creator();
    private final String buttonTitle;
    private final List<Button> buttons;
    private final List<Content> contents;
    private final Link headerLink;
    private final String headerTitle;
    private final String objectType;

    /* compiled from: Templates.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ListTemplate> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ListTemplate createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Link createFromParcel = Link.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList2.add(Content.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList3 = arrayList2;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList4.add(Button.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList4;
            }
            return new ListTemplate(readString, createFromParcel, arrayList3, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ListTemplate[] newArray(int i) {
            return new ListTemplate[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ListTemplate(String headerTitle, Link headerLink, List<Content> contents) {
        this(headerTitle, headerLink, contents, null, null, 24, null);
        Intrinsics.checkNotNullParameter(headerTitle, "headerTitle");
        Intrinsics.checkNotNullParameter(headerLink, "headerLink");
        Intrinsics.checkNotNullParameter(contents, "contents");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ListTemplate(String headerTitle, Link headerLink, List<Content> contents, List<Button> list) {
        this(headerTitle, headerLink, contents, list, null, 16, null);
        Intrinsics.checkNotNullParameter(headerTitle, "headerTitle");
        Intrinsics.checkNotNullParameter(headerLink, "headerLink");
        Intrinsics.checkNotNullParameter(contents, "contents");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ListTemplate copy$default(ListTemplate listTemplate, String str, Link link, List list, List list2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listTemplate.headerTitle;
        }
        if ((i & 2) != 0) {
            link = listTemplate.headerLink;
        }
        Link link2 = link;
        if ((i & 4) != 0) {
            list = listTemplate.contents;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = listTemplate.buttons;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            str2 = listTemplate.buttonTitle;
        }
        return listTemplate.copy(str, link2, list3, list4, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getObjectType$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.headerTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Link component2() {
        return this.headerLink;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Content> component3() {
        return this.contents;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Button> component4() {
        return this.buttons;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component5() {
        return this.buttonTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ListTemplate copy(String headerTitle, Link headerLink, List<Content> contents, List<Button> buttons, String buttonTitle) {
        Intrinsics.checkNotNullParameter(headerTitle, "headerTitle");
        Intrinsics.checkNotNullParameter(headerLink, "headerLink");
        Intrinsics.checkNotNullParameter(contents, "contents");
        return new ListTemplate(headerTitle, headerLink, contents, buttons, buttonTitle);
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
        if (!(other instanceof ListTemplate)) {
            return false;
        }
        ListTemplate listTemplate = (ListTemplate) other;
        return Intrinsics.areEqual(this.headerTitle, listTemplate.headerTitle) && Intrinsics.areEqual(this.headerLink, listTemplate.headerLink) && Intrinsics.areEqual(this.contents, listTemplate.contents) && Intrinsics.areEqual(this.buttons, listTemplate.buttons) && Intrinsics.areEqual(this.buttonTitle, listTemplate.buttonTitle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((((this.headerTitle.hashCode() * 31) + this.headerLink.hashCode()) * 31) + this.contents.hashCode()) * 31;
        List<Button> list = this.buttons;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.buttonTitle;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ListTemplate(headerTitle=" + this.headerTitle + ", headerLink=" + this.headerLink + ", contents=" + this.contents + ", buttons=" + this.buttons + ", buttonTitle=" + ((Object) this.buttonTitle) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.headerTitle);
        this.headerLink.writeToParcel(parcel, flags);
        List<Content> list = this.contents;
        parcel.writeInt(list.size());
        Iterator<Content> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        List<Button> list2 = this.buttons;
        if (list2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            Iterator<Button> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.buttonTitle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ListTemplate(String headerTitle, Link headerLink, List<Content> contents, List<Button> list, String str) {
        Intrinsics.checkNotNullParameter(headerTitle, "headerTitle");
        Intrinsics.checkNotNullParameter(headerLink, "headerLink");
        Intrinsics.checkNotNullParameter(contents, "contents");
        this.headerTitle = headerTitle;
        this.headerLink = headerLink;
        this.contents = contents;
        this.buttons = list;
        this.buttonTitle = str;
        this.objectType = Constants.TYPE_LIST;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ListTemplate(String str, Link link, List list, List list2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, link, list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getHeaderTitle() {
        return this.headerTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Link getHeaderLink() {
        return this.headerLink;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Content> getContents() {
        return this.contents;
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
