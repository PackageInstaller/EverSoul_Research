package com.unity3d.player;

import android.os.Build;
import com.facebook.internal.AnalyticsEvents;
import java.lang.Thread;
import java.util.Arrays;

/* renamed from: com.unity3d.player.g0 */
/* loaded from: classes3.dex */
final class C2728g0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private volatile Thread.UncaughtExceptionHandler f1369a;

    /* renamed from: b */
    private String f1370b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2728g0() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    static void m789a(String str) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C2728g0) {
            C2728g0 c2728g0 = (C2728g0) defaultUncaughtExceptionHandler;
            int i = -1;
            int i2 = -1;
            while (true) {
                int indexOf = str.indexOf(47, i + 1);
                if (indexOf == -1) {
                    break;
                }
                i2 = i;
                i = indexOf;
            }
            c2728g0.f1370b = i2 < 0 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : str.substring(i2 + 1);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    final synchronized void m790a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            return;
        }
        this.f1369a = defaultUncaughtExceptionHandler;
        this.f1370b = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Error error = new Error(String.format("FATAL EXCEPTION [%s]\n", thread.getName()) + String.format("Unity version     : %s\n", "2022.3.62f1") + String.format("Device model      : %s %s\n", Build.MANUFACTURER, Build.MODEL) + String.format("Device fingerprint: %s\n", Build.FINGERPRINT) + String.format("CPU supported ABI : %s\n", Arrays.toString(Build.SUPPORTED_ABIS)) + String.format("Build Type        : %s\n", "Release") + String.format("Scripting Backend : %s\n", "IL2CPP") + String.format("Libs loaded from  : %s\n", this.f1370b) + String.format("Strip Engine Code : %s\n", Boolean.TRUE));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f1369a.uncaughtException(thread, error);
        } catch (Throwable unused) {
            this.f1369a.uncaughtException(thread, th);
        }
    }
}
