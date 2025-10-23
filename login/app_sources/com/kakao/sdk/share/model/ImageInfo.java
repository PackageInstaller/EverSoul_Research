package com.kakao.sdk.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadResult.kt */
@Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006#"}, m839d2 = {"Lcom/kakao/sdk/share/model/ImageInfo;", "Landroid/os/Parcelable;", "url", "", "contentType", "length", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(Ljava/lang/String;Ljava/lang/String;III)V", "getContentType", "()Ljava/lang/String;", "getHeight", "()I", "getLength", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = new Creator();
    private final String contentType;
    private final int height;
    private final int length;
    private final String url;
    private final int width;

    /* compiled from: ImageUploadResult.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ImageInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ImageInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ImageInfo[] newArray(int i) {
            return new ImageInfo[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ImageInfo copy$default(ImageInfo imageInfo, String str, String str2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = imageInfo.url;
        }
        if ((i4 & 2) != 0) {
            str2 = imageInfo.contentType;
        }
        String str3 = str2;
        if ((i4 & 4) != 0) {
            i = imageInfo.length;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = imageInfo.width;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = imageInfo.height;
        }
        return imageInfo.copy(str, str3, i5, i6, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.contentType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component3() {
        return this.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component4() {
        return this.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component5() {
        return this.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImageInfo copy(String url, String contentType, int length, int width, int height) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        return new ImageInfo(url, contentType, length, width, height);
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
        if (!(other instanceof ImageInfo)) {
            return false;
        }
        ImageInfo imageInfo = (ImageInfo) other;
        return Intrinsics.areEqual(this.url, imageInfo.url) && Intrinsics.areEqual(this.contentType, imageInfo.contentType) && this.length == imageInfo.length && this.width == imageInfo.width && this.height == imageInfo.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.contentType.hashCode()) * 31) + Integer.hashCode(this.length)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ImageInfo(url=" + this.url + ", contentType=" + this.contentType + ", length=" + this.length + ", width=" + this.width + ", height=" + this.height + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.url);
        parcel.writeString(this.contentType);
        parcel.writeInt(this.length);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageInfo(String url, String contentType, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.url = url;
        this.contentType = contentType;
        this.length = i;
        this.width = i2;
        this.height = i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getContentType() {
        return this.contentType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getLength() {
        return this.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getHeight() {
        return this.height;
    }
}
