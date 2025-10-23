package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
final class AutoValue_LibraryVersion extends LibraryVersion {
    private final String libraryName;
    private final String version;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AutoValue_LibraryVersion(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.libraryName = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.version = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public String getLibraryName() {
        return this.libraryName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public String getVersion() {
        return this.version;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "LibraryVersion{libraryName=" + this.libraryName + ", version=" + this.version + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        return this.libraryName.equals(libraryVersion.getLibraryName()) && this.version.equals(libraryVersion.getVersion());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return ((this.libraryName.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode();
    }
}
