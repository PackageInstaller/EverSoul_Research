package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
class CrashlyticsFileMarker {
    private final FileStore fileStore;
    private final String markerName;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.markerName = str;
        this.fileStore = fileStore;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean create() {
        try {
            return getMarkerFile().createNewFile();
        } catch (IOException e) {
            Logger.getLogger().m393e("Error creating marker: " + this.markerName, e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean remove() {
        return getMarkerFile().delete();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private File getMarkerFile() {
        return this.fileStore.getCommonFile(this.markerName);
    }
}
