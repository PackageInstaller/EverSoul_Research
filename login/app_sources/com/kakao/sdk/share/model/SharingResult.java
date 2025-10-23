package com.kakao.sdk.share.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharingResult.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001f"}, m839d2 = {"Lcom/kakao/sdk/share/model/SharingResult;", "Landroid/os/Parcelable;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "warningMsg", "", "", "argumentMsg", "(Landroid/content/Intent;Ljava/util/Map;Ljava/util/Map;)V", "getArgumentMsg", "()Ljava/util/Map;", "getIntent", "()Landroid/content/Intent;", "getWarningMsg", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SharingResult implements Parcelable {
    public static final Parcelable.Creator<SharingResult> CREATOR = new Creator();
    private final Map<String, String> argumentMsg;
    private final Intent intent;
    private final Map<String, String> warningMsg;

    /* compiled from: SharingResult.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<SharingResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final SharingResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Intent intent = (Intent) parcel.readParcelable(SharingResult.class.getClassLoader());
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                linkedHashMap3.put(parcel.readString(), parcel.readString());
            }
            return new SharingResult(intent, linkedHashMap2, linkedHashMap3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final SharingResult[] newArray(int i) {
            return new SharingResult[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ SharingResult copy$default(SharingResult sharingResult, Intent intent, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            intent = sharingResult.intent;
        }
        if ((i & 2) != 0) {
            map = sharingResult.warningMsg;
        }
        if ((i & 4) != 0) {
            map2 = sharingResult.argumentMsg;
        }
        return sharingResult.copy(intent, map, map2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent component1() {
        return this.intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> component2() {
        return this.warningMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> component3() {
        return this.argumentMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SharingResult copy(Intent intent, Map<String, String> warningMsg, Map<String, String> argumentMsg) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(warningMsg, "warningMsg");
        Intrinsics.checkNotNullParameter(argumentMsg, "argumentMsg");
        return new SharingResult(intent, warningMsg, argumentMsg);
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
        if (!(other instanceof SharingResult)) {
            return false;
        }
        SharingResult sharingResult = (SharingResult) other;
        return Intrinsics.areEqual(this.intent, sharingResult.intent) && Intrinsics.areEqual(this.warningMsg, sharingResult.warningMsg) && Intrinsics.areEqual(this.argumentMsg, sharingResult.argumentMsg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((this.intent.hashCode() * 31) + this.warningMsg.hashCode()) * 31) + this.argumentMsg.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "SharingResult(intent=" + this.intent + ", warningMsg=" + this.warningMsg + ", argumentMsg=" + this.argumentMsg + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.intent, flags);
        Map<String, String> map = this.warningMsg;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
        Map<String, String> map2 = this.argumentMsg;
        parcel.writeInt(map2.size());
        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
            parcel.writeString(entry2.getKey());
            parcel.writeString(entry2.getValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SharingResult(Intent intent, Map<String, String> warningMsg, Map<String, String> argumentMsg) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(warningMsg, "warningMsg");
        Intrinsics.checkNotNullParameter(argumentMsg, "argumentMsg");
        this.intent = intent;
        this.warningMsg = warningMsg;
        this.argumentMsg = argumentMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent getIntent() {
        return this.intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getWarningMsg() {
        return this.warningMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getArgumentMsg() {
        return this.argumentMsg;
    }
}
