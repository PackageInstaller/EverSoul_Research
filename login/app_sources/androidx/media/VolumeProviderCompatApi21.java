package androidx.media;

import android.media.VolumeProvider;

/* loaded from: classes5.dex */
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createVolumeProvider(int i, int i2, int i3, final Delegate delegate) {
        return new VolumeProvider(i, i2, i3) { // from class: androidx.media.VolumeProviderCompatApi21.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i4) {
                delegate.onSetVolumeTo(i4);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i4) {
                delegate.onAdjustVolume(i4);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private VolumeProviderCompatApi21() {
    }
}
