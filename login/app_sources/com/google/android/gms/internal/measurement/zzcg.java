package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzcg extends zzcd {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcd
    public final URLConnection zza(URL url, String str) throws IOException {
        return url.openConnection();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzcg() {
    }
}
