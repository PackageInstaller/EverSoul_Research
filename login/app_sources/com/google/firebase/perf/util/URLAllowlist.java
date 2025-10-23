package com.google.firebase.perf.util;

import android.content.Context;
import android.content.res.Resources;
import com.google.firebase.perf.logging.AndroidLogger;
import java.net.URI;

/* loaded from: classes2.dex */
public class URLAllowlist {
    private static String[] allowlistedDomains;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isURLAllowlisted(URI uri, Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier == 0) {
            return true;
        }
        AndroidLogger.getInstance().debug("Detected domain allowlist, only allowlisted domains will be measured.");
        if (allowlistedDomains == null) {
            allowlistedDomains = resources.getStringArray(identifier);
        }
        String host = uri.getHost();
        if (host == null) {
            return true;
        }
        for (String str : allowlistedDomains) {
            if (host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
