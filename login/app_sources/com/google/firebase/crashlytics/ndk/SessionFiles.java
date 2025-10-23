package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes2.dex */
final class SessionFiles {
    public final File app;
    public final File binaryImages;
    public final File device;
    public final File metadata;
    public final NativeCore nativeCore;

    /* renamed from: os */
    public final File f430os;
    public final File session;

    static final class NativeCore {
        public final CrashlyticsReport.ApplicationExitInfo applicationExitInfo;
        public final File minidump;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        NativeCore(File file, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.minidump = file;
            this.applicationExitInfo = applicationExitInfo;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean hasCore() {
            File file = this.minidump;
            return (file != null && file.exists()) || this.applicationExitInfo != null;
        }
    }

    static final class Builder {
        private File app;
        private File binaryImages;
        private File device;
        private File metadata;
        private NativeCore nativeCore;

        /* renamed from: os */
        private File f431os;
        private File session;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder nativeCore(NativeCore nativeCore) {
            this.nativeCore = nativeCore;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder binaryImagesFile(File file) {
            this.binaryImages = file;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder metadataFile(File file) {
            this.metadata = file;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder sessionFile(File file) {
            this.session = file;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder appFile(File file) {
            this.app = file;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder deviceFile(File file) {
            this.device = file;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder osFile(File file) {
            this.f431os = file;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SessionFiles build() {
            return new SessionFiles(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SessionFiles(Builder builder) {
        this.nativeCore = builder.nativeCore;
        this.binaryImages = builder.binaryImages;
        this.metadata = builder.metadata;
        this.session = builder.session;
        this.app = builder.app;
        this.device = builder.device;
        this.f430os = builder.f431os;
    }
}
