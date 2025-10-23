package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareFeedContent.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0019H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b¨\u0006 "}, m839d2 = {"Lcom/facebook/share/internal/ShareFeedContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/internal/ShareFeedContent$Builder;", "builder", "(Lcom/facebook/share/internal/ShareFeedContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "link", "", "getLink", "()Ljava/lang/String;", "linkCaption", "getLinkCaption", "linkDescription", "getLinkDescription", "linkName", "getLinkName", "mediaSource", "getMediaSource", "picture", "getPicture", "toId", "getToId", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {
    private final String link;
    private final String linkCaption;
    private final String linkDescription;
    private final String linkName;
    private final String mediaSource;
    private final String picture;
    private final String toId;
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator<ShareFeedContent>() { // from class: com.facebook.share.internal.ShareFeedContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public ShareFeedContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareFeedContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public ShareFeedContent[] newArray(int size) {
            return new ShareFeedContent[size];
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ShareFeedContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getToId() {
        return this.toId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLink() {
        return this.link;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLinkName() {
        return this.linkName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLinkCaption() {
        return this.linkCaption;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLinkDescription() {
        return this.linkDescription;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPicture() {
        return this.picture;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMediaSource() {
        return this.mediaSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ShareFeedContent(Builder builder) {
        super(builder);
        this.toId = builder.getToId$facebook_common_release();
        this.link = builder.getLink$facebook_common_release();
        this.linkName = builder.getLinkName$facebook_common_release();
        this.linkCaption = builder.getLinkCaption$facebook_common_release();
        this.linkDescription = builder.getLinkDescription$facebook_common_release();
        this.picture = builder.getPicture$facebook_common_release();
        this.mediaSource = builder.getMediaSource$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShareFeedContent(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, flags);
        out.writeString(this.toId);
        out.writeString(this.link);
        out.writeString(this.linkName);
        out.writeString(this.linkCaption);
        out.writeString(this.linkDescription);
        out.writeString(this.picture);
        out.writeString(this.mediaSource);
    }

    /* compiled from: ShareFeedContent.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010 \u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010!\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0010\u0010$\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0010\u0010%\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006&"}, m839d2 = {"Lcom/facebook/share/internal/ShareFeedContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/internal/ShareFeedContent;", "()V", "link", "", "getLink$facebook_common_release", "()Ljava/lang/String;", "setLink$facebook_common_release", "(Ljava/lang/String;)V", "linkCaption", "getLinkCaption$facebook_common_release", "setLinkCaption$facebook_common_release", "linkDescription", "getLinkDescription$facebook_common_release", "setLinkDescription$facebook_common_release", "linkName", "getLinkName$facebook_common_release", "setLinkName$facebook_common_release", "mediaSource", "getMediaSource$facebook_common_release", "setMediaSource$facebook_common_release", "picture", "getPicture$facebook_common_release", "setPicture$facebook_common_release", "toId", "getToId$facebook_common_release", "setToId$facebook_common_release", "build", "readFrom", "content", "setLink", "setLinkCaption", "setLinkDescription", "setLinkName", "setMediaSource", "setPicture", "setToId", "facebook-common_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {
        private String link;
        private String linkCaption;
        private String linkDescription;
        private String linkName;
        private String mediaSource;
        private String picture;
        private String toId;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getToId$facebook_common_release() {
            return this.toId;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setToId$facebook_common_release(String str) {
            this.toId = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLink$facebook_common_release() {
            return this.link;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setLink$facebook_common_release(String str) {
            this.link = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLinkName$facebook_common_release() {
            return this.linkName;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setLinkName$facebook_common_release(String str) {
            this.linkName = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLinkCaption$facebook_common_release() {
            return this.linkCaption;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setLinkCaption$facebook_common_release(String str) {
            this.linkCaption = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLinkDescription$facebook_common_release() {
            return this.linkDescription;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setLinkDescription$facebook_common_release(String str) {
            this.linkDescription = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getPicture$facebook_common_release() {
            return this.picture;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPicture$facebook_common_release(String str) {
            this.picture = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getMediaSource$facebook_common_release() {
            return this.mediaSource;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setMediaSource$facebook_common_release(String str) {
            this.mediaSource = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setToId(String toId) {
            this.toId = toId;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setLink(String link) {
            this.link = link;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setLinkName(String linkName) {
            this.linkName = linkName;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setLinkCaption(String linkCaption) {
            this.linkCaption = linkCaption;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setLinkDescription(String linkDescription) {
            this.linkDescription = linkDescription;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setPicture(String picture) {
            this.picture = picture;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setMediaSource(String mediaSource) {
            this.mediaSource = mediaSource;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.ShareBuilder
        public ShareFeedContent build() {
            return new ShareFeedContent(this, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareFeedContent content) {
            return content == null ? this : ((Builder) super.readFrom((Builder) content)).setToId(content.getToId()).setLink(content.getLink()).setLinkName(content.getLinkName()).setLinkCaption(content.getLinkCaption()).setLinkDescription(content.getLinkDescription()).setPicture(content.getPicture()).setMediaSource(content.getMediaSource());
        }
    }
}
