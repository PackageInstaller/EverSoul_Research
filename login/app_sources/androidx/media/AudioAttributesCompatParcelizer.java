package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes5.dex */
public final class AudioAttributesCompatParcelizer {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = (AudioAttributesImpl) versionedParcel.readVersionedParcelable(audioAttributesCompat.mImpl, 1);
        return audioAttributesCompat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeVersionedParcelable(audioAttributesCompat.mImpl, 1);
    }
}
