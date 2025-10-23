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
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J9\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0012¨\u0006+"}, m839d2 = {"Lcom/kakao/sdk/template/model/CalendarTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "id", "", "idType", "Lcom/kakao/sdk/template/model/IdType;", "content", "Lcom/kakao/sdk/template/model/Content;", Constants.BUTTONS, "", "Lcom/kakao/sdk/template/model/Button;", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/IdType;Lcom/kakao/sdk/template/model/Content;Ljava/util/List;)V", "getButtons", "()Ljava/util/List;", "getContent", "()Lcom/kakao/sdk/template/model/Content;", "getId", "()Ljava/lang/String;", "getIdType", "()Lcom/kakao/sdk/template/model/IdType;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CalendarTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<CalendarTemplate> CREATOR = new Creator();
    private final List<Button> buttons;
    private final Content content;
    private final String id;
    private final IdType idType;
    private final String objectType;

    /* compiled from: Templates.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<CalendarTemplate> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final CalendarTemplate createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            IdType valueOf = IdType.valueOf(parcel.readString());
            Content createFromParcel = Content.CREATOR.createFromParcel(parcel);
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
            return new CalendarTemplate(readString, valueOf, createFromParcel, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final CalendarTemplate[] newArray(int i) {
            return new CalendarTemplate[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CalendarTemplate(String id, IdType idType, Content content) {
        this(id, idType, content, null, 8, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(idType, "idType");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ CalendarTemplate copy$default(CalendarTemplate calendarTemplate, String str, IdType idType, Content content, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = calendarTemplate.id;
        }
        if ((i & 2) != 0) {
            idType = calendarTemplate.idType;
        }
        if ((i & 4) != 0) {
            content = calendarTemplate.content;
        }
        if ((i & 8) != 0) {
            list = calendarTemplate.buttons;
        }
        return calendarTemplate.copy(str, idType, content, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getObjectType$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IdType component2() {
        return this.idType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Content component3() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Button> component4() {
        return this.buttons;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CalendarTemplate copy(String id, IdType idType, Content content, List<Button> buttons) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(idType, "idType");
        Intrinsics.checkNotNullParameter(content, "content");
        return new CalendarTemplate(id, idType, content, buttons);
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
        if (!(other instanceof CalendarTemplate)) {
            return false;
        }
        CalendarTemplate calendarTemplate = (CalendarTemplate) other;
        return Intrinsics.areEqual(this.id, calendarTemplate.id) && this.idType == calendarTemplate.idType && Intrinsics.areEqual(this.content, calendarTemplate.content) && Intrinsics.areEqual(this.buttons, calendarTemplate.buttons);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.idType.hashCode()) * 31) + this.content.hashCode()) * 31;
        List<Button> list = this.buttons;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "CalendarTemplate(id=" + this.id + ", idType=" + this.idType + ", content=" + this.content + ", buttons=" + this.buttons + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.idType.name());
        this.content.writeToParcel(parcel, flags);
        List<Button> list = this.buttons;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<Button> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CalendarTemplate(String id, IdType idType, Content content, List<Button> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(idType, "idType");
        Intrinsics.checkNotNullParameter(content, "content");
        this.id = id;
        this.idType = idType;
        this.content = content;
        this.buttons = list;
        this.objectType = Constants.TYPE_CALENDAR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ CalendarTemplate(String str, IdType idType, Content content, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, idType, content, (i & 8) != 0 ? null : list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IdType getIdType() {
        return this.idType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Content getContent() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Button> getButtons() {
        return this.buttons;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getObjectType() {
        return this.objectType;
    }
}
