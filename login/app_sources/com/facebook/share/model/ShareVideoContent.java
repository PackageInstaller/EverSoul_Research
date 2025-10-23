package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareVideoContent.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u001d\u001eB\u000f\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005B\u000f\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0018H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, m839d2 = {"Lcom/facebook/share/model/ShareVideoContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareVideoContent$Builder;", "Lcom/facebook/share/model/ShareModel;", "builder", "(Lcom/facebook/share/model/ShareVideoContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "contentTitle", "getContentTitle", "previewPhoto", "Lcom/facebook/share/model/SharePhoto;", "getPreviewPhoto", "()Lcom/facebook/share/model/SharePhoto;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "Lcom/facebook/share/model/ShareVideo;", "getVideo", "()Lcom/facebook/share/model/ShareVideo;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>() { // from class: com.facebook.share.model.ShareVideoContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public ShareVideoContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareVideoContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public ShareVideoContent[] newArray(int size) {
            return new ShareVideoContent[size];
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ShareVideoContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getContentDescription() {
        return this.contentDescription;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getContentTitle() {
        return this.contentTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ShareVideo getVideo() {
        return this.video;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ShareVideoContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.getContentDescription$facebook_common_release();
        this.contentTitle = builder.getContentTitle$facebook_common_release();
        this.previewPhoto = builder.getPreviewPhoto$facebook_common_release();
        this.video = builder.getVideo$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShareVideoContent(Parcel parcel) {
        super(parcel);
        SharePhoto build;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        SharePhoto.Builder readFrom$facebook_common_release = new SharePhoto.Builder().readFrom$facebook_common_release(parcel);
        if (readFrom$facebook_common_release.getImageUrl$facebook_common_release() != null || readFrom$facebook_common_release.getBitmap$facebook_common_release() != null) {
            build = readFrom$facebook_common_release.build();
        } else {
            build = null;
        }
        this.previewPhoto = build;
        this.video = new ShareVideo.Builder().readFrom$facebook_common_release(parcel).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, flags);
        out.writeString(this.contentDescription);
        out.writeString(this.contentTitle);
        out.writeParcelable(this.previewPhoto, 0);
        out.writeParcelable(this.video, 0);
    }

    /* compiled from: ShareVideoContent.kt */
    @Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0012\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, m839d2 = {"Lcom/facebook/share/model/ShareVideoContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareVideoContent;", "()V", "contentDescription", "", "getContentDescription$facebook_common_release", "()Ljava/lang/String;", "setContentDescription$facebook_common_release", "(Ljava/lang/String;)V", "contentTitle", "getContentTitle$facebook_common_release", "setContentTitle$facebook_common_release", "previewPhoto", "Lcom/facebook/share/model/SharePhoto;", "getPreviewPhoto$facebook_common_release", "()Lcom/facebook/share/model/SharePhoto;", "setPreviewPhoto$facebook_common_release", "(Lcom/facebook/share/model/SharePhoto;)V", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "Lcom/facebook/share/model/ShareVideo;", "getVideo$facebook_common_release", "()Lcom/facebook/share/model/ShareVideo;", "setVideo$facebook_common_release", "(Lcom/facebook/share/model/ShareVideo;)V", "build", "readFrom", "content", "setContentDescription", "setContentTitle", "setPreviewPhoto", "setVideo", "facebook-common_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Builder extends ShareContent.Builder<ShareVideoContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private SharePhoto previewPhoto;
        private ShareVideo video;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getContentDescription$facebook_common_release() {
            return this.contentDescription;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setContentDescription$facebook_common_release(String str) {
            this.contentDescription = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getContentTitle$facebook_common_release() {
            return this.contentTitle;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setContentTitle$facebook_common_release(String str) {
            this.contentTitle = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final SharePhoto getPreviewPhoto$facebook_common_release() {
            return this.previewPhoto;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPreviewPhoto$facebook_common_release(SharePhoto sharePhoto) {
            this.previewPhoto = sharePhoto;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final ShareVideo getVideo$facebook_common_release() {
            return this.video;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setVideo$facebook_common_release(ShareVideo shareVideo) {
            this.video = shareVideo;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setContentDescription(String contentDescription) {
            this.contentDescription = contentDescription;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setContentTitle(String contentTitle) {
            this.contentTitle = contentTitle;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setPreviewPhoto(SharePhoto previewPhoto) {
            this.previewPhoto = previewPhoto == null ? null : new SharePhoto.Builder().readFrom(previewPhoto).build();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setVideo(ShareVideo video) {
            if (video == null) {
                return this;
            }
            this.video = new ShareVideo.Builder().readFrom(video).build();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.ShareBuilder
        public ShareVideoContent build() {
            return new ShareVideoContent(this, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareVideoContent content) {
            return content == null ? this : ((Builder) super.readFrom((Builder) content)).setContentDescription(content.getContentDescription()).setContentTitle(content.getContentTitle()).setPreviewPhoto(content.getPreviewPhoto()).setVideo(content.getVideo());
        }
    }
}
