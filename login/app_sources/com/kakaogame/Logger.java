package com.kakaogame;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.liapp.y;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.SingularParamsBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Logger.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\fJ\u0018\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0019\u001a\u00020\u0004J\u0018\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J,\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004J\u0018\u0010\"\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\"\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0018\u0010#\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010#\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m839d2 = {"Lcom/kakaogame/Logger;", "", "()V", "ASSERT", "", "DEBUG", "ERROR", "INFO", "VERBOSE", "WARN", "loggingEventListenerList", "", "Lcom/kakaogame/Logger$LoggingEventListener;", "loggingLevel", "a", "", "tag", "", "msg", "tr", "", "addLoggingEventListener", "loggingEventListener", "d", Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, "getLoggingLevel", "he", SingularParamsBase.Constants.PACKAGE_NAME_KEY, "isSdkLoggable", "", FirebaseAnalytics.Param.LEVEL, "notifyLoggingEvent", "removeLoggingEventListener", "setLoggingLevel", "v", "w", "LoggingEventListener", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final Logger INSTANCE = new Logger();
    private static int loggingLevel = 4;
    private static final List<LoggingEventListener> loggingEventListenerList = new ArrayList();

    /* compiled from: Logger.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/Logger$LoggingEventListener;", "", "onLog", "", "loggingLevel", "", "tag", "", "msg", "tr", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface LoggingEventListener {
        void onLog(int loggingLevel, String tag, String msg, Throwable tr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Logger() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setLoggingLevel(int level) {
        if (!(level >= 2 && level <= 7)) {
            throw new IllegalArgumentException((y.֬ڱܱײٮ(-1158875575) + level).toString());
        }
        loggingLevel = level;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getLoggingLevel() {
        return loggingLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isSdkLoggable(int level) {
        return level >= loggingLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: he */
    public final void m703he(String tag, String msg) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        StringBuffer stringBuffer = new StringBuffer(y.֬ڱܱײٮ(-1159525591));
        stringBuffer.append(msg);
        stringBuffer.append(y.دײܮڳܯ(2051387357));
        if (isSdkLoggable(6)) {
            Log.e(tag, stringBuffer.toString());
        }
        notifyLoggingEvent(6, tag, msg, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: v */
    public final void m706v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(2)) {
            Log.v(tag, msg);
        }
        notifyLoggingEvent(2, tag, msg, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: v */
    public final void m707v(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(2)) {
            Log.v(tag, msg, tr);
        }
        notifyLoggingEvent(2, tag, msg, tr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final void m699d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(3)) {
            Log.d(tag, msg);
        }
        notifyLoggingEvent(3, tag, msg, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final void m700d(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(3)) {
            Log.d(tag, msg, tr);
        }
        notifyLoggingEvent(3, tag, msg, tr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public final void m704i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(4)) {
            Log.i(tag, msg);
        }
        notifyLoggingEvent(4, tag, msg, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public final void m705i(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(4)) {
            Log.i(tag, msg, tr);
        }
        notifyLoggingEvent(4, tag, msg, tr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public final void m708w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(5)) {
            Log.w(tag, msg);
        }
        notifyLoggingEvent(5, tag, msg, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public final void m709w(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(5)) {
            Log.w(tag, msg, tr);
        }
        notifyLoggingEvent(5, tag, msg, tr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public final void m701e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(6)) {
            Log.e(tag, msg);
        }
        notifyLoggingEvent(6, tag, msg, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public final void m702e(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(6)) {
            Log.e(tag, msg, tr);
        }
        notifyLoggingEvent(6, tag, msg, tr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m697a(String tag, String msg) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(7)) {
            Log.e(tag, msg);
        }
        notifyLoggingEvent(7, tag, msg, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m698a(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, y.ݬֲ֮ܲت(1512734375));
        if (isSdkLoggable(7)) {
            Log.e(tag, msg, tr);
        }
        notifyLoggingEvent(7, tag, msg, tr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void notifyLoggingEvent(int loggingLevel2, String tag, String msg, Throwable tr) {
        List<LoggingEventListener> list = loggingEventListenerList;
        synchronized (list) {
            Iterator<LoggingEventListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onLog(loggingLevel2, tag, msg, tr);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addLoggingEventListener(LoggingEventListener loggingEventListener) {
        Intrinsics.checkNotNullParameter(loggingEventListener, y.دײܮڳܯ(2051692309));
        List<LoggingEventListener> list = loggingEventListenerList;
        synchronized (list) {
            list.clear();
            list.add(loggingEventListener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removeLoggingEventListener(LoggingEventListener loggingEventListener) {
        Intrinsics.checkNotNullParameter(loggingEventListener, y.دײܮڳܯ(2051692309));
        List<LoggingEventListener> list = loggingEventListenerList;
        synchronized (list) {
            list.remove(loggingEventListener);
        }
    }
}
