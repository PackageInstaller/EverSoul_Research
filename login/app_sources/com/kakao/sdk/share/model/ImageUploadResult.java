package com.kakao.sdk.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadResult.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m839d2 = {"Lcom/kakao/sdk/share/model/ImageUploadResult;", "Landroid/os/Parcelable;", "infos", "Lcom/kakao/sdk/share/model/ImageInfos;", "(Lcom/kakao/sdk/share/model/ImageInfos;)V", "getInfos", "()Lcom/kakao/sdk/share/model/ImageInfos;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ImageUploadResult implements Parcelable {
    public static final Parcelable.Creator<ImageUploadResult> CREATOR = new Creator();
    private final ImageInfos infos;

    /* compiled from: ImageUploadResult.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ImageUploadResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ImageUploadResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageUploadResult(ImageInfos.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ImageUploadResult[] newArray(int i) {
            return new ImageUploadResult[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ImageUploadResult copy$default(ImageUploadResult imageUploadResult, ImageInfos imageInfos, int i, Object obj) {
        if ((i & 1) != 0) {
            imageInfos = imageUploadResult.infos;
        }
        return imageUploadResult.copy(imageInfos);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImageInfos component1() {
        return this.infos;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImageUploadResult copy(ImageInfos infos) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        return new ImageUploadResult(infos);
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
        return (other instanceof ImageUploadResult) && Intrinsics.areEqual(this.infos, ((ImageUploadResult) other).infos);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.infos.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ImageUploadResult(infos=" + this.infos + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.infos.writeToParcel(parcel, flags);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageUploadResult(ImageInfos infos) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        this.infos = infos;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImageInfos getInfos() {
        return this.infos;
    }
}
