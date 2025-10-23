package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public class GetPhoneNumberHintIntentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetPhoneNumberHintIntentRequest> CREATOR = new zbe();
    private final int zba;

    /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
    public static final class Builder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(zbd zbdVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public GetPhoneNumberHintIntentRequest build() {
            return new GetPhoneNumberHintIntentRequest(0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GetPhoneNumberHintIntentRequest(int i) {
        this.zba = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new Builder(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj instanceof GetPhoneNumberHintIntentRequest) {
            return Objects.equal(Integer.valueOf(this.zba), Integer.valueOf(((GetPhoneNumberHintIntentRequest) obj).zba));
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zba));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zba);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
