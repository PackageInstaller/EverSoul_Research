package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public class SavePasswordRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SavePasswordRequest> CREATOR = new zbk();
    private final SignInPassword zba;
    private final String zbb;
    private final int zbc;

    /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
    public static final class Builder {
        private SignInPassword zba;
        private String zbb;
        private int zbc;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SavePasswordRequest build() {
            return new SavePasswordRequest(this.zba, this.zbb, this.zbc);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSignInPassword(SignInPassword signInPassword) {
            this.zba = signInPassword;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder zba(String str) {
            this.zbb = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder zbb(int i) {
            this.zbc = i;
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SavePasswordRequest(SignInPassword signInPassword, String str, int i) {
        this.zba = (SignInPassword) Preconditions.checkNotNull(signInPassword);
        this.zbb = str;
        this.zbc = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder zba(SavePasswordRequest savePasswordRequest) {
        Preconditions.checkNotNull(savePasswordRequest);
        Builder builder = builder();
        builder.setSignInPassword(savePasswordRequest.getSignInPassword());
        builder.zbb(savePasswordRequest.zbc);
        String str = savePasswordRequest.zbb;
        if (str != null) {
            builder.zba(str);
        }
        return builder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof SavePasswordRequest)) {
            return false;
        }
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
        return Objects.equal(this.zba, savePasswordRequest.zba) && Objects.equal(this.zbb, savePasswordRequest.zbb) && this.zbc == savePasswordRequest.zbc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SignInPassword getSignInPassword() {
        return this.zba;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getSignInPassword(), i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zbc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
