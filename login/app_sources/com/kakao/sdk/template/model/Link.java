package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.common.json.MapToQueryAdapter;
import com.kakao.sdk.template.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Components.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003JQ\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, m839d2 = {"Lcom/kakao/sdk/template/model/Link;", "Landroid/os/Parcelable;", "webUrl", "", "mobileWebUrl", "androidExecutionParams", "", "iosExecutionParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getAndroidExecutionParams", "()Ljava/util/Map;", "getIosExecutionParams", "getMobileWebUrl", "()Ljava/lang/String;", "getWebUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Link implements Parcelable {
    public static final Parcelable.Creator<Link> CREATOR = new Creator();

    @SerializedName(Constants.ANDROID_EXECUTION_PARAMS)
    @JsonAdapter(MapToQueryAdapter.class)
    private final Map<String, String> androidExecutionParams;

    @SerializedName(Constants.IOS_EXECUTION_PARAMS)
    @JsonAdapter(MapToQueryAdapter.class)
    private final Map<String, String> iosExecutionParams;
    private final String mobileWebUrl;
    private final String webUrl;

    /* compiled from: Components.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Link> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Link createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            LinkedHashMap linkedHashMap2 = null;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            LinkedHashMap linkedHashMap3 = linkedHashMap;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap2 = new LinkedHashMap(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                }
            }
            return new Link(readString, readString2, linkedHashMap3, linkedHashMap2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Link[] newArray(int i) {
            return new Link[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Link() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Link(String str) {
        this(str, null, null, null, 14, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Link(String str, String str2) {
        this(str, str2, null, null, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Link(String str, String str2, Map<String, String> map) {
        this(str, str2, map, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Link copy$default(Link link, String str, String str2, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = link.webUrl;
        }
        if ((i & 2) != 0) {
            str2 = link.mobileWebUrl;
        }
        if ((i & 4) != 0) {
            map = link.androidExecutionParams;
        }
        if ((i & 8) != 0) {
            map2 = link.iosExecutionParams;
        }
        return link.copy(str, str2, map, map2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.webUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.mobileWebUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> component3() {
        return this.androidExecutionParams;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> component4() {
        return this.iosExecutionParams;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Link copy(String webUrl, String mobileWebUrl, Map<String, String> androidExecutionParams, Map<String, String> iosExecutionParams) {
        return new Link(webUrl, mobileWebUrl, androidExecutionParams, iosExecutionParams);
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
        if (!(other instanceof Link)) {
            return false;
        }
        Link link = (Link) other;
        return Intrinsics.areEqual(this.webUrl, link.webUrl) && Intrinsics.areEqual(this.mobileWebUrl, link.mobileWebUrl) && Intrinsics.areEqual(this.androidExecutionParams, link.androidExecutionParams) && Intrinsics.areEqual(this.iosExecutionParams, link.iosExecutionParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.webUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mobileWebUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.androidExecutionParams;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String> map2 = this.iosExecutionParams;
        return hashCode3 + (map2 != null ? map2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Link(webUrl=" + ((Object) this.webUrl) + ", mobileWebUrl=" + ((Object) this.mobileWebUrl) + ", androidExecutionParams=" + this.androidExecutionParams + ", iosExecutionParams=" + this.iosExecutionParams + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.webUrl);
        parcel.writeString(this.mobileWebUrl);
        Map<String, String> map = this.androidExecutionParams;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
        }
        Map<String, String> map2 = this.iosExecutionParams;
        if (map2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(map2.size());
        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
            parcel.writeString(entry2.getKey());
            parcel.writeString(entry2.getValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Link(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        this.webUrl = str;
        this.mobileWebUrl = str2;
        this.androidExecutionParams = map;
        this.iosExecutionParams = map2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ Link(String str, String str2, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getWebUrl() {
        return this.webUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMobileWebUrl() {
        return this.mobileWebUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getAndroidExecutionParams() {
        return this.androidExecutionParams;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getIosExecutionParams() {
        return this.iosExecutionParams;
    }
}
