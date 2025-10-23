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
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000e¨\u0006+"}, m839d2 = {"Lcom/kakao/sdk/template/model/CommerceTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "content", "Lcom/kakao/sdk/template/model/Content;", "commerce", "Lcom/kakao/sdk/template/model/Commerce;", Constants.BUTTONS, "", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "", "(Lcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/Commerce;Ljava/util/List;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getCommerce", "()Lcom/kakao/sdk/template/model/Commerce;", "getContent", "()Lcom/kakao/sdk/template/model/Content;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CommerceTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<CommerceTemplate> CREATOR = new Creator();
    private final String buttonTitle;
    private final List<Button> buttons;
    private final Commerce commerce;
    private final Content content;
    private final String objectType;

    /* compiled from: Templates.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<CommerceTemplate> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final CommerceTemplate createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Content createFromParcel = Content.CREATOR.createFromParcel(parcel);
            Commerce createFromParcel2 = Commerce.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(Button.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new CommerceTemplate(createFromParcel, createFromParcel2, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final CommerceTemplate[] newArray(int i) {
            return new CommerceTemplate[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CommerceTemplate(Content content, Commerce commerce) {
        this(content, commerce, null, null, 12, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(commerce, "commerce");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CommerceTemplate(Content content, Commerce commerce, List<Button> list) {
        this(content, commerce, list, null, 8, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(commerce, "commerce");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ CommerceTemplate copy$default(CommerceTemplate commerceTemplate, Content content, Commerce commerce, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            content = commerceTemplate.content;
        }
        if ((i & 2) != 0) {
            commerce = commerceTemplate.commerce;
        }
        if ((i & 4) != 0) {
            list = commerceTemplate.buttons;
        }
        if ((i & 8) != 0) {
            str = commerceTemplate.buttonTitle;
        }
        return commerceTemplate.copy(content, commerce, list, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getObjectType$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Content component1() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Commerce component2() {
        return this.commerce;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Button> component3() {
        return this.buttons;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.buttonTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CommerceTemplate copy(Content content, Commerce commerce, List<Button> buttons, String buttonTitle) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(commerce, "commerce");
        return new CommerceTemplate(content, commerce, buttons, buttonTitle);
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
        if (!(other instanceof CommerceTemplate)) {
            return false;
        }
        CommerceTemplate commerceTemplate = (CommerceTemplate) other;
        return Intrinsics.areEqual(this.content, commerceTemplate.content) && Intrinsics.areEqual(this.commerce, commerceTemplate.commerce) && Intrinsics.areEqual(this.buttons, commerceTemplate.buttons) && Intrinsics.areEqual(this.buttonTitle, commerceTemplate.buttonTitle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((this.content.hashCode() * 31) + this.commerce.hashCode()) * 31;
        List<Button> list = this.buttons;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.buttonTitle;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "CommerceTemplate(content=" + this.content + ", commerce=" + this.commerce + ", buttons=" + this.buttons + ", buttonTitle=" + ((Object) this.buttonTitle) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.content.writeToParcel(parcel, flags);
        this.commerce.writeToParcel(parcel, flags);
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
    public CommerceTemplate(Content content, Commerce commerce, List<Button> list, String str) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(commerce, "commerce");
        this.content = content;
        this.commerce = commerce;
        this.buttons = list;
        this.buttonTitle = str;
        this.objectType = "commerce";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ CommerceTemplate(Content content, Commerce commerce, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(content, commerce, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Content getContent() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Commerce getCommerce() {
        return this.commerce;
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
