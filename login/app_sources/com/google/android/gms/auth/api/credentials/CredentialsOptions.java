package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
@Deprecated
/* loaded from: classes.dex */
public final class CredentialsOptions extends Auth.AuthCredentialsOptions {
    public static final CredentialsOptions DEFAULT = new Builder().build();

    /* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
    public static final class Builder extends Auth.AuthCredentialsOptions.Builder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CredentialsOptions build() {
            return new CredentialsOptions(this, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        public final /* bridge */ /* synthetic */ Auth.AuthCredentialsOptions.Builder forceEnableSaveDialog() {
            forceEnableSaveDialog();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        public Builder forceEnableSaveDialog() {
            this.zba = true;
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ CredentialsOptions(Builder builder, zbd zbdVar) {
        super(builder);
    }
}
