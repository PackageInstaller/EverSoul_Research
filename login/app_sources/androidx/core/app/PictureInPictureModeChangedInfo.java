package androidx.core.app;

import android.content.res.Configuration;

/* loaded from: classes.dex */
public final class PictureInPictureModeChangedInfo {
    private final boolean mIsInPictureInPictureMode;
    private final Configuration mNewConfig;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PictureInPictureModeChangedInfo(boolean z) {
        this.mIsInPictureInPictureMode = z;
        this.mNewConfig = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PictureInPictureModeChangedInfo(boolean z, Configuration configuration) {
        this.mIsInPictureInPictureMode = z;
        this.mNewConfig = configuration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isInPictureInPictureMode() {
        return this.mIsInPictureInPictureMode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Configuration getNewConfig() {
        Configuration configuration = this.mNewConfig;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
    }
}
