package com.google.firebase.perf.logging;

/* loaded from: classes2.dex */
public final class ConsoleUrlGenerator {
    private static final String URL_BASE_PATH = "https://console.firebase.google.com";
    private static final String UTM_MEDIUM = "android-ide";
    private static final String UTM_SOURCE = "perf-android-sdk";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String generateDashboardUrl(String str, String str2) {
        return String.format("%s/trends?utm_source=%s&utm_medium=%s", getRootUrl(str, str2), UTM_SOURCE, UTM_MEDIUM);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String generateCustomTraceUrl(String str, String str2, String str3) {
        return String.format("%s/troubleshooting/trace/DURATION_TRACE/%s?utm_source=%s&utm_medium=%s", getRootUrl(str, str2), str3, UTM_SOURCE, UTM_MEDIUM);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String generateScreenTraceUrl(String str, String str2, String str3) {
        return String.format("%s/troubleshooting/trace/SCREEN_TRACE/%s?utm_source=%s&utm_medium=%s", getRootUrl(str, str2), str3, UTM_SOURCE, UTM_MEDIUM);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getRootUrl(String str, String str2) {
        return String.format("%s/project/%s/performance/app/android:%s", URL_BASE_PATH, str, str2);
    }
}
