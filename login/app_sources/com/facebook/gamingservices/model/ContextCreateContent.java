package com.facebook.gamingservices.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import com.kakaogame.server.ServerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextCreateContent.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m839d2 = {"Lcom/facebook/gamingservices/model/ContextCreateContent;", "Lcom/facebook/share/model/ShareModel;", "builder", "Lcom/facebook/gamingservices/model/ContextCreateContent$Builder;", "(Lcom/facebook/gamingservices/model/ContextCreateContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "suggestedPlayerID", "", "getSuggestedPlayerID", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "CREATOR", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class ContextCreateContent implements ShareModel {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String suggestedPlayerID;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ContextCreateContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSuggestedPlayerID() {
        return this.suggestedPlayerID;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ContextCreateContent(Builder builder) {
        this.suggestedPlayerID = builder.getSuggestedPlayerID$facebook_gamingservices_release();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextCreateContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.suggestedPlayerID = parcel.readString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.suggestedPlayerID);
    }

    /* compiled from: ContextCreateContent.kt */
    @Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, m839d2 = {"Lcom/facebook/gamingservices/model/ContextCreateContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/model/ContextCreateContent;", "()V", "suggestedPlayerID", "", "getSuggestedPlayerID$facebook_gamingservices_release", "()Ljava/lang/String;", "setSuggestedPlayerID$facebook_gamingservices_release", "(Ljava/lang/String;)V", "build", "readFrom", "parcel", "Landroid/os/Parcel;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "setSuggestedPlayerID", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Builder implements ShareModelBuilder<ContextCreateContent, Builder> {
        private String suggestedPlayerID;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSuggestedPlayerID$facebook_gamingservices_release() {
            return this.suggestedPlayerID;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSuggestedPlayerID$facebook_gamingservices_release(String str) {
            this.suggestedPlayerID = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setSuggestedPlayerID(String suggestedPlayerID) {
            this.suggestedPlayerID = suggestedPlayerID;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.ShareBuilder
        public ContextCreateContent build() {
            return new ContextCreateContent(this, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextCreateContent model) {
            Builder suggestedPlayerID;
            return (model == null || (suggestedPlayerID = setSuggestedPlayerID(model.getSuggestedPlayerID())) == null) ? this : suggestedPlayerID;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder readFrom(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((ContextCreateContent) parcel.readParcelable(ContextCreateContent.class.getClassLoader()));
        }
    }

    /* compiled from: ContextCreateContent.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m839d2 = {"Lcom/facebook/gamingservices/model/ContextCreateContent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/model/ContextCreateContent;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", ServerConstants.SIZE, "", "(I)[Lcom/facebook/gamingservices/model/ContextCreateContent;", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    /* renamed from: com.facebook.gamingservices.model.ContextCreateContent$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<ContextCreateContent> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public ContextCreateContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContextCreateContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public ContextCreateContent[] newArray(int size) {
            return new ContextCreateContent[size];
        }
    }
}
