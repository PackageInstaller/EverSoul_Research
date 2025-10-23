package androidx.media;

import android.content.Context;
import androidx.media.MediaSessionManager;

/* loaded from: classes5.dex */
class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MediaSessionManagerImplApi21(Context context) {
        super(context);
        this.mContext = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        return hasMediaControlPermission(remoteUserInfoImpl) || super.isTrustedForMediaControl(remoteUserInfoImpl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean hasMediaControlPermission(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        return getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
    }
}
