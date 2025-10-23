package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes2.dex */
class SessionFilesProvider implements NativeSessionFileProvider {
    private final SessionFiles sessionFiles;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SessionFilesProvider(SessionFiles sessionFiles) {
        this.sessionFiles = sessionFiles;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public File getMinidumpFile() {
        return this.sessionFiles.nativeCore.minidump;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public CrashlyticsReport.ApplicationExitInfo getApplicationExitInto() {
        if (this.sessionFiles.nativeCore != null) {
            return this.sessionFiles.nativeCore.applicationExitInfo;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public File getBinaryImagesFile() {
        return this.sessionFiles.binaryImages;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public File getMetadataFile() {
        return this.sessionFiles.metadata;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public File getSessionFile() {
        return this.sessionFiles.session;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public File getAppFile() {
        return this.sessionFiles.app;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public File getDeviceFile() {
        return this.sessionFiles.device;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public File getOsFile() {
        return this.sessionFiles.f430os;
    }
}
