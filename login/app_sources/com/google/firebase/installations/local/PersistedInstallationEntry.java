package com.google.firebase.installations.local;

import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

/* loaded from: classes2.dex */
public abstract class PersistedInstallationEntry {
    public static PersistedInstallationEntry INSTANCE = builder().build();

    public static abstract class Builder {
        public abstract PersistedInstallationEntry build();

        public abstract Builder setAuthToken(String str);

        public abstract Builder setExpiresInSecs(long j);

        public abstract Builder setFirebaseInstallationId(String str);

        public abstract Builder setFisError(String str);

        public abstract Builder setRefreshToken(String str);

        public abstract Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus);

        public abstract Builder setTokenCreationEpochInSecs(long j);
    }

    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    public abstract String getFirebaseInstallationId();

    public abstract String getFisError();

    public abstract String getRefreshToken();

    public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();

    public abstract Builder toBuilder();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isRegistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isErrored() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isUnregistered() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isNotGenerated() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.NOT_GENERATED || getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldAttemptMigration() {
        return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PersistedInstallationEntry withUnregisteredFid(String str) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PersistedInstallationEntry withRegisteredFid(String str, String str2, long j, String str3, long j2) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED).setAuthToken(str3).setRefreshToken(str2).setExpiresInSecs(j2).setTokenCreationEpochInSecs(j).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PersistedInstallationEntry withFisError(String str) {
        return toBuilder().setFisError(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PersistedInstallationEntry withNoGeneratedFid() {
        return toBuilder().setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PersistedInstallationEntry withAuthToken(String str, long j, long j2) {
        return toBuilder().setAuthToken(str).setExpiresInSecs(j).setTokenCreationEpochInSecs(j2).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PersistedInstallationEntry withClearedAuthToken() {
        return toBuilder().setAuthToken(null).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new AutoValue_PersistedInstallationEntry.Builder().setTokenCreationEpochInSecs(0L).setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).setExpiresInSecs(0L);
    }
}
