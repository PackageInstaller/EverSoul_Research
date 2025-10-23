package com.kakaogame;

import android.app.Activity;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGTracer.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rH\u0007J:\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rH\u0007J2\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rH\u0007J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/KGTracer;", "", "()V", "TAG", "", "finishAction", "", "jobId", "", "action", ServerConstants.TRACE_RESULT_CODE, "description", "extras", "", "finishJob", "makeJob", "activity", "Landroid/app/Activity;", "name", "startAction", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGTracer {
    public static final KGTracer INSTANCE = new KGTracer();
    private static final String TAG = "KGTracer";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGTracer() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int makeJob(Activity activity, String name, Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        String str = name;
        if (str == null || str.length() == 0) {
            return -1;
        }
        return Tracer.INSTANCE.makeJob(activity, name, extras);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void startAction(int jobId, String action) {
        String str = action;
        if (str == null || str.length() == 0) {
            return;
        }
        Tracer.INSTANCE.startAction(jobId, action);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void finishAction(int jobId, String action, int resultCode, String description, Map<String, ? extends Object> extras) {
        String str = action;
        if (str == null || str.length() == 0) {
            return;
        }
        Tracer tracer = Tracer.INSTANCE;
        if (description == null) {
            description = y.٬ݯح׭٩(575705262) + resultCode;
        }
        tracer.finishAction(jobId, action, resultCode, description, extras);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void finishJob(int jobId, int resultCode, String description, Map<String, ? extends Object> extras) {
        Tracer tracer = Tracer.INSTANCE;
        if (description == null) {
            description = y.٬ݯح׭٩(575705262) + resultCode;
        }
        tracer.finish(jobId, resultCode, description, extras);
    }
}
