package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
public final class KotlinDetector {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KotlinDetector() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String detectVersion() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
