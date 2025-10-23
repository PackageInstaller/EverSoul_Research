package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new zba();
    private final PasswordRequestOptions zba;
    private final GoogleIdTokenRequestOptions zbb;
    private final String zbc;
    private final boolean zbd;
    private final int zbe;

    /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
    public static final class Builder {
        private PasswordRequestOptions zba;
        private GoogleIdTokenRequestOptions zbb;
        private String zbc;
        private boolean zbd;
        private int zbe;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder() {
            PasswordRequestOptions.Builder builder = PasswordRequestOptions.builder();
            builder.setSupported(false);
            this.zba = builder.build();
            GoogleIdTokenRequestOptions.Builder builder2 = GoogleIdTokenRequestOptions.builder();
            builder2.setSupported(false);
            this.zbb = builder2.build();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public BeginSignInRequest build() {
            return new BeginSignInRequest(this.zba, this.zbb, this.zbc, this.zbd, this.zbe);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAutoSelectEnabled(boolean z) {
            this.zbd = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setGoogleIdTokenRequestOptions(GoogleIdTokenRequestOptions googleIdTokenRequestOptions) {
            this.zbb = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPasswordRequestOptions(PasswordRequestOptions passwordRequestOptions) {
            this.zba = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder zba(String str) {
            this.zbc = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder zbb(int i) {
            this.zbe = i;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new zbg();
        private final boolean zba;
        private final String zbb;
        private final String zbc;
        private final boolean zbd;
        private final String zbe;
        private final List zbf;
        private final boolean zbg;

        /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
        public static final class Builder {
            private boolean zba = false;
            private String zbb = null;
            private String zbc = null;
            private boolean zbd = true;
            private String zbe = null;
            private List zbf = null;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder associateLinkedAccounts(String str, List<String> list) {
                this.zbe = (String) Preconditions.checkNotNull(str, "linkedServiceId must be provided if you want to associate linked accounts.");
                this.zbf = list;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public GoogleIdTokenRequestOptions build() {
                return new GoogleIdTokenRequestOptions(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, false);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setFilterByAuthorizedAccounts(boolean z) {
                this.zbd = z;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setNonce(String str) {
                this.zbc = str;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setServerClientId(String str) {
                this.zbb = Preconditions.checkNotEmpty(str);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSupported(boolean z) {
                this.zba = z;
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        GoogleIdTokenRequestOptions(boolean z, String str, String str2, boolean z2, String str3, List list, boolean z3) {
            boolean z4 = true;
            if (z2 && z3) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.zba = z;
            if (z) {
                Preconditions.checkNotNull(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.zbb = str;
            this.zbc = str2;
            this.zbd = z2;
            Parcelable.Creator<BeginSignInRequest> creator = BeginSignInRequest.CREATOR;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.zbf = arrayList;
            this.zbe = str3;
            this.zbg = z3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder builder() {
            return new Builder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            return this.zba == googleIdTokenRequestOptions.zba && Objects.equal(this.zbb, googleIdTokenRequestOptions.zbb) && Objects.equal(this.zbc, googleIdTokenRequestOptions.zbc) && this.zbd == googleIdTokenRequestOptions.zbd && Objects.equal(this.zbe, googleIdTokenRequestOptions.zbe) && Objects.equal(this.zbf, googleIdTokenRequestOptions.zbf) && this.zbg == googleIdTokenRequestOptions.zbg;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean filterByAuthorizedAccounts() {
            return this.zbd;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<String> getIdTokenDepositionScopes() {
            return this.zbf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getLinkedServiceId() {
            return this.zbe;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getNonce() {
            return this.zbc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getServerClientId() {
            return this.zbb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zba), this.zbb, this.zbc, Boolean.valueOf(this.zbd), this.zbe, this.zbf, Boolean.valueOf(this.zbg));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isSupported() {
            return this.zba;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeString(parcel, 2, getServerClientId(), false);
            SafeParcelWriter.writeString(parcel, 3, getNonce(), false);
            SafeParcelWriter.writeBoolean(parcel, 4, filterByAuthorizedAccounts());
            SafeParcelWriter.writeString(parcel, 5, getLinkedServiceId(), false);
            SafeParcelWriter.writeStringList(parcel, 6, getIdTokenDepositionScopes(), false);
            SafeParcelWriter.writeBoolean(parcel, 7, this.zbg);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new zbh();
        private final boolean zba;

        /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
        public static final class Builder {
            private boolean zba = false;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public PasswordRequestOptions build() {
                return new PasswordRequestOptions(this.zba);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSupported(boolean z) {
                this.zba = z;
                return this;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PasswordRequestOptions(boolean z) {
            this.zba = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder builder() {
            return new Builder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            return (obj instanceof PasswordRequestOptions) && this.zba == ((PasswordRequestOptions) obj).zba;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zba));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isSupported() {
            return this.zba;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BeginSignInRequest(PasswordRequestOptions passwordRequestOptions, GoogleIdTokenRequestOptions googleIdTokenRequestOptions, String str, boolean z, int i) {
        this.zba = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
        this.zbb = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
        this.zbc = str;
        this.zbd = z;
        this.zbe = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder zba(BeginSignInRequest beginSignInRequest) {
        Preconditions.checkNotNull(beginSignInRequest);
        Builder builder = builder();
        builder.setGoogleIdTokenRequestOptions(beginSignInRequest.getGoogleIdTokenRequestOptions());
        builder.setPasswordRequestOptions(beginSignInRequest.getPasswordRequestOptions());
        builder.setAutoSelectEnabled(beginSignInRequest.zbd);
        builder.zbb(beginSignInRequest.zbe);
        String str = beginSignInRequest.zbc;
        if (str != null) {
            builder.zba(str);
        }
        return builder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        return Objects.equal(this.zba, beginSignInRequest.zba) && Objects.equal(this.zbb, beginSignInRequest.zbb) && Objects.equal(this.zbc, beginSignInRequest.zbc) && this.zbd == beginSignInRequest.zbd && this.zbe == beginSignInRequest.zbe;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GoogleIdTokenRequestOptions getGoogleIdTokenRequestOptions() {
        return this.zbb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PasswordRequestOptions getPasswordRequestOptions() {
        return this.zba;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc, Boolean.valueOf(this.zbd));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAutoSelectEnabled() {
        return this.zbd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getPasswordRequestOptions(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getGoogleIdTokenRequestOptions(), i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isAutoSelectEnabled());
        SafeParcelWriter.writeInt(parcel, 5, this.zbe);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
