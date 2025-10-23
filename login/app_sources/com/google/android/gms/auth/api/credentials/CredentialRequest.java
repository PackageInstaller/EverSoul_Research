package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
@Deprecated
/* loaded from: classes.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zbc();
    final int zba;
    private final boolean zbb;
    private final String[] zbc;
    private final CredentialPickerConfig zbd;
    private final CredentialPickerConfig zbe;
    private final boolean zbf;
    private final String zbg;
    private final String zbh;
    private final boolean zbi;

    /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
    public static final class Builder {
        private boolean zba;
        private String[] zbb;
        private CredentialPickerConfig zbc;
        private CredentialPickerConfig zbd;
        private boolean zbe = false;
        private String zbf = null;
        private String zbg;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CredentialRequest build() {
            if (this.zbb == null) {
                this.zbb = new String[0];
            }
            if (this.zba || this.zbb.length != 0) {
                return new CredentialRequest(4, this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, false);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zbb = strArr;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zbd = credentialPickerConfig;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zbc = credentialPickerConfig;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIdTokenNonce(String str) {
            this.zbg = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIdTokenRequested(boolean z) {
            this.zbe = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPasswordLoginSupported(boolean z) {
            this.zba = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setServerClientId(String str) {
            this.zbf = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder setSupportsPasswordLogin(boolean z) {
            setPasswordLoginSupported(z);
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.zba = i;
        this.zbb = z;
        this.zbc = (String[]) Preconditions.checkNotNull(strArr);
        this.zbd = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.zbe = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
        if (i < 3) {
            this.zbf = true;
            this.zbg = null;
            this.zbh = null;
        } else {
            this.zbf = z2;
            this.zbg = str;
            this.zbh = str2;
        }
        this.zbi = z3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String[] getAccountTypes() {
        return this.zbc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.zbc));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zbe;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zbd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getIdTokenNonce() {
        return this.zbh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getServerClientId() {
        return this.zbg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isIdTokenRequested() {
        return this.zbf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPasswordLoginSupported() {
        return this.zbb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isPasswordLoginSupported());
        SafeParcelWriter.writeStringArray(parcel, 2, getAccountTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredentialPickerConfig(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getCredentialHintPickerConfig(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zbi);
        SafeParcelWriter.writeInt(parcel, 1000, this.zba);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
