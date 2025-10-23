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
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006)"}, m839d2 = {"Lcom/kakao/sdk/template/model/TextTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "text", "", "link", "Lcom/kakao/sdk/template/model/Link;", Constants.BUTTONS, "", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getLink", "()Lcom/kakao/sdk/template/model/Link;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "getText", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TextTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<TextTemplate> CREATOR = new Creator();
    private final String buttonTitle;
    private final List<Button> buttons;
    private final Link link;
    private final String objectType;
    private final String text;

    /* compiled from: Templates.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<TextTemplate> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final TextTemplate createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Link createFromParcel = Link.CREATOR.createFromParcel(parcel);
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
            return new TextTemplate(readString, createFromParcel, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final TextTemplate[] newArray(int i) {
            return new TextTemplate[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextTemplate(String text, Link link) {
        this(text, link, null, null, 12, null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(link, "link");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextTemplate(String text, Link link, List<Button> list) {
        this(text, link, list, null, 8, null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(link, "link");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ TextTemplate copy$default(TextTemplate textTemplate, String str, Link link, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textTemplate.text;
        }
        if ((i & 2) != 0) {
            link = textTemplate.link;
        }
        if ((i & 4) != 0) {
            list = textTemplate.buttons;
        }
        if ((i & 8) != 0) {
            str2 = textTemplate.buttonTitle;
        }
        return textTemplate.copy(str, link, list, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getObjectType$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.text;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Link component2() {
        return this.link;
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
    public final TextTemplate copy(String text, Link link, List<Button> buttons, String buttonTitle) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(link, "link");
        return new TextTemplate(text, link, buttons, buttonTitle);
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
        if (!(other instanceof TextTemplate)) {
            return false;
        }
        TextTemplate textTemplate = (TextTemplate) other;
        return Intrinsics.areEqual(this.text, textTemplate.text) && Intrinsics.areEqual(this.link, textTemplate.link) && Intrinsics.areEqual(this.buttons, textTemplate.buttons) && Intrinsics.areEqual(this.buttonTitle, textTemplate.buttonTitle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + this.link.hashCode()) * 31;
        List<Button> list = this.buttons;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.buttonTitle;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "TextTemplate(text=" + this.text + ", link=" + this.link + ", buttons=" + this.buttons + ", buttonTitle=" + ((Object) this.buttonTitle) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.text);
        this.link.writeToParcel(parcel, flags);
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
    public TextTemplate(String text, Link link, List<Button> list, String str) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(link, "link");
        this.text = text;
        this.link = link;
        this.buttons = list;
        this.buttonTitle = str;
        this.objectType = "text";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ TextTemplate(String str, Link link, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, link, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Link getLink() {
        return this.link;
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
