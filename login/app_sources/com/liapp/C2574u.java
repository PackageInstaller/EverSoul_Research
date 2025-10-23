package com.liapp;

import android.util.Log;
import java.lang.Thread;

/* compiled from: ز׮ֱܬި.java */
/* renamed from: com.liapp.u */
/* loaded from: classes4.dex */
class C2574u implements Thread.UncaughtExceptionHandler {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i = 0;
        while (i < stackTrace.length) {
            String m1300 = C2571p.m1300("ooj~(");
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("mYO"));
            String stackTraceElement = stackTrace[i].toString();
            i++;
            insert.append(stackTraceElement);
            Log.e(m1300, insert.toString());
        }
    }
}
