package com.kakaogame.log;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.kakaogame.server.ServerConstants;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IFirebase.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&J$\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000fH&J$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000fH&¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/log/IFirebase;", "", "addTraceMetric", "", ServerConstants.HEADER_TRACE_ID, "", NotificationCompat.CATEGORY_EVENT, "", "getFCMToken", "initialize", "context", "Landroid/content/Context;", "logEvent", "name", "attr", "", "setCrashUserIdentifier", "playerId", "traceStart", "traceStop", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface IFirebase {
    void addTraceMetric(int traceId, String event);

    String getFCMToken();

    void initialize(Context context);

    void logEvent(String name, Map<String, String> attr);

    void setCrashUserIdentifier(String playerId);

    int traceStart(String name, Map<String, String> attr);

    void traceStop(int traceId, Map<String, String> attr);
}
