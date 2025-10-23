package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzgs {
    private static final ArrayMap<String, Uri> zza = new ArrayMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized Uri zza(String str) {
        Uri uri;
        synchronized (zzgs.class) {
            ArrayMap<String, Uri> arrayMap = zza;
            uri = arrayMap.get(str);
            if (uri == null) {
                uri = Uri.parse("content://com.google.android.gms.phenotype/" + Uri.encode(str));
                arrayMap.put(str, uri);
            }
        }
        return uri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zza(Context context, String str) {
        if (str.contains("#")) {
            throw new IllegalArgumentException("The passed in package cannot already have a subpackage: " + str);
        }
        return str + "#" + context.getPackageName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zza(String str, String str2) {
        if (str.equals("eng") || str.equals("userdebug")) {
            return str2.contains("dev-keys") || str2.contains("test-keys");
        }
        return false;
    }
}
