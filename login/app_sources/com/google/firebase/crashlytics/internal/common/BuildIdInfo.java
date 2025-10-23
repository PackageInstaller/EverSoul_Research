package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes2.dex */
public class BuildIdInfo {
    private final String arch;
    private final String buildId;
    private final String libraryName;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BuildIdInfo(String str, String str2, String str3) {
        this.libraryName = str;
        this.arch = str2;
        this.buildId = str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getLibraryName() {
        return this.libraryName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getArch() {
        return this.arch;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getBuildId() {
        return this.buildId;
    }
}
