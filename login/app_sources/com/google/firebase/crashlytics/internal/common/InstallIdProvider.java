package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes2.dex */
public interface InstallIdProvider {
    InstallIds getInstallIds();

    public static abstract class InstallIds {
        public abstract String getCrashlyticsInstallId();

        public abstract String getFirebaseInstallationId();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static InstallIds createWithoutFid(String str) {
            return create(str, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static InstallIds create(String str, String str2) {
            return new AutoValue_InstallIdProvider_InstallIds(str, str2);
        }
    }
}
