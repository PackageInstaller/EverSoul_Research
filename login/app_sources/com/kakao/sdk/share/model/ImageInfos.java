package com.kakao.sdk.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakaogame.game.StringSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadResult.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m839d2 = {"Lcom/kakao/sdk/share/model/ImageInfos;", "Landroid/os/Parcelable;", StringSet.original, "Lcom/kakao/sdk/share/model/ImageInfo;", "(Lcom/kakao/sdk/share/model/ImageInfo;)V", "getOriginal", "()Lcom/kakao/sdk/share/model/ImageInfo;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ImageInfos implements Parcelable {
    public static final Parcelable.Creator<ImageInfos> CREATOR = new Creator();
    private final ImageInfo original;

    /* compiled from: ImageUploadResult.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ImageInfos> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ImageInfos createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageInfos(ImageInfo.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ImageInfos[] newArray(int i) {
            return new ImageInfos[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ImageInfos copy$default(ImageInfos imageInfos, ImageInfo imageInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            imageInfo = imageInfos.original;
        }
        return imageInfos.copy(imageInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImageInfo component1() {
        return this.original;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImageInfos copy(ImageInfo original) {
        Intrinsics.checkNotNullParameter(original, "original");
        return new ImageInfos(original);
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
        return (other instanceof ImageInfos) && Intrinsics.areEqual(this.original, ((ImageInfos) other).original);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.original.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ImageInfos(original=" + this.original + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.original.writeToParcel(parcel, flags);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageInfos(ImageInfo original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImageInfo getOriginal() {
        return this.original;
    }
}
