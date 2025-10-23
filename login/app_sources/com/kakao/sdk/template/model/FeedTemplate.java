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
@Metadata(m838d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BE\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JI\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020$HÖ\u0001J\t\u0010*\u001a\u00020\rHÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\rX\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00060"}, m839d2 = {"Lcom/kakao/sdk/template/model/FeedTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "content", "Lcom/kakao/sdk/template/model/Content;", "itemContent", "Lcom/kakao/sdk/template/model/ItemContent;", "social", "Lcom/kakao/sdk/template/model/Social;", Constants.BUTTONS, "", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "", "(Lcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/ItemContent;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getContent", "()Lcom/kakao/sdk/template/model/Content;", "getItemContent", "()Lcom/kakao/sdk/template/model/ItemContent;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "getSocial", "()Lcom/kakao/sdk/template/model/Social;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FeedTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<FeedTemplate> CREATOR = new Creator();
    private final String buttonTitle;
    private final List<Button> buttons;
    private final Content content;
    private final ItemContent itemContent;
    private final String objectType;
    private final Social social;

    /* compiled from: Templates.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<FeedTemplate> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final FeedTemplate createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Content createFromParcel = Content.CREATOR.createFromParcel(parcel);
            ArrayList arrayList = null;
            ItemContent createFromParcel2 = parcel.readInt() == 0 ? null : ItemContent.CREATOR.createFromParcel(parcel);
            Social createFromParcel3 = parcel.readInt() == 0 ? null : Social.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(Button.CREATOR.createFromParcel(parcel));
                }
            }
            return new FeedTemplate(createFromParcel, createFromParcel2, createFromParcel3, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final FeedTemplate[] newArray(int i) {
            return new FeedTemplate[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FeedTemplate(Content content) {
        this(content, null, null, null, null, 30, null);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FeedTemplate(Content content, ItemContent itemContent) {
        this(content, itemContent, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FeedTemplate(Content content, ItemContent itemContent, Social social) {
        this(content, itemContent, social, null, null, 24, null);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FeedTemplate(Content content, ItemContent itemContent, Social social, List<Button> list) {
        this(content, itemContent, social, list, null, 16, null);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ FeedTemplate copy$default(FeedTemplate feedTemplate, Content content, ItemContent itemContent, Social social, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            content = feedTemplate.content;
        }
        if ((i & 2) != 0) {
            itemContent = feedTemplate.itemContent;
        }
        ItemContent itemContent2 = itemContent;
        if ((i & 4) != 0) {
            social = feedTemplate.social;
        }
        Social social2 = social;
        if ((i & 8) != 0) {
            list = feedTemplate.buttons;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            str = feedTemplate.buttonTitle;
        }
        return feedTemplate.copy(content, itemContent2, social2, list2, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getObjectType$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Content component1() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ItemContent component2() {
        return this.itemContent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Social component3() {
        return this.social;
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
    public final FeedTemplate copy(Content content, ItemContent itemContent, Social social, List<Button> buttons, String buttonTitle) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new FeedTemplate(content, itemContent, social, buttons, buttonTitle);
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
        if (!(other instanceof FeedTemplate)) {
            return false;
        }
        FeedTemplate feedTemplate = (FeedTemplate) other;
        return Intrinsics.areEqual(this.content, feedTemplate.content) && Intrinsics.areEqual(this.itemContent, feedTemplate.itemContent) && Intrinsics.areEqual(this.social, feedTemplate.social) && Intrinsics.areEqual(this.buttons, feedTemplate.buttons) && Intrinsics.areEqual(this.buttonTitle, feedTemplate.buttonTitle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = this.content.hashCode() * 31;
        ItemContent itemContent = this.itemContent;
        int hashCode2 = (hashCode + (itemContent == null ? 0 : itemContent.hashCode())) * 31;
        Social social = this.social;
        int hashCode3 = (hashCode2 + (social == null ? 0 : social.hashCode())) * 31;
        List<Button> list = this.buttons;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.buttonTitle;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "FeedTemplate(content=" + this.content + ", itemContent=" + this.itemContent + ", social=" + this.social + ", buttons=" + this.buttons + ", buttonTitle=" + ((Object) this.buttonTitle) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.content.writeToParcel(parcel, flags);
        ItemContent itemContent = this.itemContent;
        if (itemContent == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            itemContent.writeToParcel(parcel, flags);
        }
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
    public FeedTemplate(Content content, ItemContent itemContent, Social social, List<Button> list, String str) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.itemContent = itemContent;
        this.social = social;
        this.buttons = list;
        this.buttonTitle = str;
        this.objectType = Constants.TYPE_FEED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ FeedTemplate(Content content, ItemContent itemContent, Social social, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(content, (i & 2) != 0 ? null : itemContent, (i & 4) != 0 ? null : social, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Content getContent() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ItemContent getItemContent() {
        return this.itemContent;
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
