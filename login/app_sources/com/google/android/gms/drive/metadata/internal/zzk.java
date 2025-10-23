package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveFolder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzk {
    private String zzji;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzk zzg(String str) {
        Preconditions.checkArgument(str == null || !str.isEmpty());
        if (str == null) {
            return null;
        }
        return new zzk(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzk(String str) {
        this.zzji = str.toLowerCase(Locale.US);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isFolder() {
        return this.zzji.equals(DriveFolder.MIME_TYPE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzbh() {
        return this.zzji.startsWith("application/vnd.google-apps");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.zzji.equals(((zzk) obj).zzji);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return this.zzji.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return this.zzji;
    }
}
