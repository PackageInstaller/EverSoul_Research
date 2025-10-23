package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class GooglePlayServicesManifestException extends IllegalStateException {
    private final int zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GooglePlayServicesManifestException(int i, String str) {
        super(str);
        this.zza = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getActualVersion() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getExpectedVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
