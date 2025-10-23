package com.kakaogame.log.tracer;

import android.app.Activity;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.kakao.sdk.template.Constants;
import com.kakaogame.KGSystem;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.TimerManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Tracer.kt */
@Metadata(m838d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0016\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002J\b\u0010#\u001a\u0004\u0018\u00010\u0011J\n\u0010$\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010%\u001a\u00020\u0011J\b\u0010&\u001a\u00020\u0006H\u0002J0\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00112\u0018\b\u0002\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010,J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.J*\u0010'\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00112\u0018\b\u0002\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010,H\u0002J2\u0010'\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00112\u0018\b\u0002\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010,2\u0006\u0010/\u001a\u00020\u0006H\u0002J\u0006\u00100\u001a\u00020\u001eJ\u0006\u00101\u001a\u00020\u001eJ\b\u00102\u001a\u00020\u001eH\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\b\u00104\u001a\u00020\u001eH\u0002J\b\u00105\u001a\u00020\u001eH\u0002J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0019J4\u00108\u001a\u00020\u001e*\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00112\u0018\b\u0002\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010,J\"\u0010:\u001a\u00020\u001e*\u00020\u00192\u0006\u0010;\u001a\u00020<2\u0006\u0010-\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0011J<\u0010:\u001a\u00020\u001e*\u00020\u00192\u0006\u0010;\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00112\u0018\b\u0002\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010,J\n\u0010=\u001a\u00020\u0011*\u00020\u0019J\u0012\u0010>\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u00020\u0019J\u0012\u0010@\u001a\u00020\u0014*\u00020\u00192\u0006\u0010A\u001a\u00020\u0011J\u0014\u0010B\u001a\u00020\u001e*\u00020\u00142\b\u0010C\u001a\u0004\u0018\u00010DJ&\u0010B\u001a\u00020\u001e*\u00020\u00142\u001a\u0010C\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\"\u0018\u00010,J\u0012\u0010E\u001a\u00020\u001e*\u00020\u00192\u0006\u0010;\u001a\u00020<J\u0012\u0010E\u001a\u00020\u001e*\u00020\u00192\u0006\u0010;\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, m839d2 = {"Lcom/kakaogame/log/tracer/Tracer;", "", "()V", "enableTrace", "Lcom/kakaogame/log/tracer/TraceStatus;", "isSendingTrace", "", "jobList", "", "Lcom/kakaogame/log/tracer/Job;", "queueLock", "requestQueue", "Ljava/util/LinkedList;", "Lcom/kakaogame/log/tracer/Trace;", "rttCheckTimer", "Lcom/kakaogame/core/TimerManager;", "rttCheckUrlList", "", "rttList", "", "", "Lcom/kakaogame/log/tracer/ApiCallRtt;", "rttLock", "rttSendData", "rttSendingIndex", "", "sendLock", ServerConstants.HEADER_TRACE_ID, "tracingStartTime", "addTrace", "", "trace", "addTraceList", Constants.TYPE_LIST, "", "getRttData", "getTrace", "getTraceId", "isSending", "makeJob", "activity", "Landroid/app/Activity;", "name", "extras", "", "code", "Lcom/kakaogame/log/tracer/TraceJobCode;", RemoteConfigComponent.ACTIVATE_FILE_NAME, "onInfodesk", com.kakao.sdk.share.Constants.TALK_SHARE_AUTHORITY, "sendCompleted", "sendFailure", "sendRttUrls", "sendStart", "setTarget", "rate", "finish", "description", "finishAction", "action", "Lcom/kakaogame/log/tracer/TraceLoginActionCode;", "getJobName", "makeCustomErrorCode", "errorCode", "requestUri", "uri", "response", "headers", "Lcom/kakaogame/util/json/JSONObject;", "startAction", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Tracer {
    public static final Tracer INSTANCE = new Tracer();
    private static TraceStatus enableTrace = TraceStatus.UNKNOWN;
    private static boolean isSendingTrace;
    private static final List<Job> jobList;
    private static final Object queueLock;
    private static final LinkedList<Trace> requestQueue;
    private static TimerManager rttCheckTimer;
    private static final List<String> rttCheckUrlList;
    private static final Map<Long, ApiCallRtt> rttList;
    private static final Object rttLock;
    private static final LinkedList<ApiCallRtt> rttSendData;
    private static int rttSendingIndex;
    private static final Object sendLock;
    private static final String traceId;
    private static long tracingStartTime;

    /* compiled from: Tracer.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[TraceStatus.values().length];
            try {
                iArr[TraceStatus.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TraceStatus.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TraceStatus.STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Tracer() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, y.ٲٴݴ״ٰ(1781855688));
        traceId = uuid;
        jobList = new ArrayList();
        requestQueue = new LinkedList<>();
        rttList = new LinkedHashMap();
        rttSendData = new LinkedList<>();
        queueLock = new Object();
        rttLock = new Object();
        sendLock = new Object();
        tracingStartTime = CoreManager.INSTANCE.getInstance().currentTimeMillis();
        rttCheckUrlList = new ArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTraceId() {
        return traceId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTarget(int rate) {
        String str = y.ݮڮֲڭܩ(-628410468) + rate;
        String str2 = y.ٴسسݬߨ(1393493874);
        Log.d(str2, str);
        if (InfodeskHelper.INSTANCE.getSdkTraceStopNow()) {
            enableTrace = TraceStatus.DISABLED;
            return;
        }
        TraceStatus traceStatus = new Random().nextInt(1000) < rate ? TraceStatus.ENABLED : TraceStatus.DISABLED;
        enableTrace = traceStatus;
        if (traceStatus == TraceStatus.ENABLED) {
            Log.d(str2, "TARGETED!!!");
            tracingStartTime = CoreManager.INSTANCE.getInstance().currentTimeMillis();
            send();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onInfodesk() {
        if (rttCheckTimer == null) {
            int rttSampleRate = InfodeskHelper.INSTANCE.getRttSampleRate();
            Random random = new Random();
            rttCheckTimer = new TimerManager(new Runnable() { // from class: com.kakaogame.log.tracer.Tracer$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    Tracer.onInfodesk$lambda$0();
                }
            }, 0L, 3000L);
            if (random.nextInt(1000) < rttSampleRate) {
                rttCheckUrlList.addAll(InfodeskHelper.INSTANCE.rttCheckUrls());
                TimerManager timerManager = rttCheckTimer;
                if (timerManager != null) {
                    timerManager.startTimer();
                }
            }
        }
        if (InfodeskHelper.INSTANCE.getSdkTraceStopNow()) {
            enableTrace = TraceStatus.DISABLED;
            requestQueue.clear();
        } else {
            send();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onInfodesk$lambda$0() {
        INSTANCE.sendRttUrls();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendRttUrls() {
        List<String> list = rttCheckUrlList;
        if (list.size() == rttSendingIndex) {
            TimerManager timerManager = rttCheckTimer;
            if (timerManager != null) {
                timerManager.stopTimer();
                return;
            }
            return;
        }
        long currentTimeMillis = CoreManager.INSTANCE.getInstance().currentTimeMillis();
        String str = list.get(rttSendingIndex);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Tracer$sendRttUrls$1(currentTimeMillis, CoreManager.INSTANCE.getInstance().currentTimeMillis() - currentTimeMillis, HttpService.requestGETRttCheck$default(HttpService.INSTANCE, CoreManager.INSTANCE.getInstance().getContext(), str, null, 4, null), str, null), 3, null);
        rttSendingIndex++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int makeJob(TraceJobCode code) {
        Intrinsics.checkNotNullParameter(code, y.دײܮڳܯ(2051571757));
        String lowerCase = code.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return makeJob$default(this, lowerCase, (Map) null, false, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ int makeJob$default(Tracer tracer, Activity activity, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return tracer.makeJob(activity, str, (Map<String, ? extends Object>) map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int makeJob(final Activity activity, String name, Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        CoreManager.INSTANCE.getInstance().setActivityHolder(new Function0<Activity>() { // from class: com.kakaogame.log.tracer.Tracer$makeJob$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Activity invoke() {
                return activity;
            }
        });
        return makeJob(name, extras, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ int makeJob$default(Tracer tracer, String str, Map map, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return tracer.makeJob(str, (Map<String, ? extends Object>) map, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int makeJob(String name, Map<String, ? extends Object> extras, boolean activate) {
        int i = WhenMappings.$EnumSwitchMapping$0[enableTrace.ordinal()];
        if (i == 1 || i == 2) {
            return makeJob(name, extras);
        }
        if (i != 3 || !activate) {
            return -1;
        }
        enableTrace = TraceStatus.ENABLED;
        tracingStartTime = CoreManager.INSTANCE.getInstance().currentTimeMillis();
        return makeJob(name, extras);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ int makeJob$default(Tracer tracer, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return tracer.makeJob(str, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int makeJob(String name, Map<String, ? extends Object> extras) {
        if (CoreManager.INSTANCE.getInstance().currentTimeMillis() - tracingStartTime > InfodeskHelper.INSTANCE.getSdkTracingMin()) {
            enableTrace = TraceStatus.STOPPED;
            return -1;
        }
        List<Job> list = jobList;
        int size = list.size();
        Log.d(y.ٴسسݬߨ(1393493874), y.ۮڭڭܬި(862677315) + size);
        Job job = new Job(size, name);
        list.add(job);
        addTrace(job.start(extras));
        return size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int makeCustomErrorCode(int i, int i2) {
        if (i < 0) {
            return 0;
        }
        return jobList.get(i).getJobCode().getCode() + 10000 + i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getJobName(int i) {
        return i < 0 ? "check_rtt" : jobList.get(i).getName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void finish$default(Tracer tracer, int i, int i2, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        tracer.finish(i, i2, str, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void finish(int i, int i2, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392801274));
        if (i < 0) {
            return;
        }
        List<Trace> finish = jobList.get(i).finish(i2, str, map);
        if (!finish.isEmpty()) {
            addTraceList(finish);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void startAction(int i, TraceLoginActionCode traceLoginActionCode) {
        Intrinsics.checkNotNullParameter(traceLoginActionCode, y.֬ڱܱײٮ(-1159583711));
        String lowerCase = traceLoginActionCode.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
        startAction(i, lowerCase);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void startAction(int i, String str) {
        Intrinsics.checkNotNullParameter(str, y.֬ڱܱײٮ(-1159583711));
        if (i < 0) {
            return;
        }
        jobList.get(i).addAction(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void finishAction$default(Tracer tracer, int i, String str, int i2, String str2, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        tracer.finishAction(i, str, i2, str2, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void finishAction(int i, String str, int i2, String str2, Map<String, ? extends Object> map) {
        Trace finishAction;
        Intrinsics.checkNotNullParameter(str, y.֬ڱܱײٮ(-1159583711));
        Intrinsics.checkNotNullParameter(str2, y.ٴسسݬߨ(1392801274));
        if (i >= 0 && (finishAction = jobList.get(i).finishAction(str, i2, str2, map)) != null) {
            INSTANCE.addTrace(finishAction);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void finishAction(int i, TraceLoginActionCode traceLoginActionCode, int i2, String str) {
        Intrinsics.checkNotNullParameter(traceLoginActionCode, y.֬ڱܱײٮ(-1159583711));
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392801274));
        String lowerCase = traceLoginActionCode.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        finishAction$default(this, i, lowerCase, i2, str, null, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long requestUri(int i, String str) {
        Intrinsics.checkNotNullParameter(str, y.ۮڭڭܬި(862392755));
        Log.d(y.ٴسسݬߨ(1393493874), y.ٲٴݴ״ٰ(1782193408) + i + y.ٲٴݴ״ٰ(1782193488) + str);
        if (i < 0) {
            return -1L;
        }
        long currentTimeMillis = CoreManager.INSTANCE.getInstance().currentTimeMillis();
        ApiCallRtt apiCallRtt = new ApiCallRtt(i, getJobName(i), str, currentTimeMillis);
        synchronized (rttLock) {
            rttList.put(Long.valueOf(currentTimeMillis), apiCallRtt);
        }
        return currentTimeMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void response(long j, Map<String, ? extends List<String>> map) {
        ApiCallRtt responseApi;
        long j2 = 0;
        if (j < 0) {
            return;
        }
        Log.d(y.ٴسسݬߨ(1393493874), y.ٲٴݴ״ٰ(1782193408) + j + ':' + (map != null ? map.toString() : null));
        Map<Long, ApiCallRtt> map2 = rttList;
        if (map2.get(Long.valueOf(j)) == null || map == null) {
            return;
        }
        if (map.containsKey(y.ݮڮֲڭܩ(-628788004)) && map.containsKey(y.ٴسسݬߨ(1393492338))) {
            List<String> list = map.get(y.ݮڮֲڭܩ(-628788004));
            long parseLong = (list == null || !(list.isEmpty() ^ true)) ? 0L : Long.parseLong(list.get(0));
            List<String> list2 = map.get(y.ٴسسݬߨ(1393492338));
            if (list2 != null && (!list2.isEmpty())) {
                j2 = Long.parseLong(list2.get(0));
            }
            long j3 = j2;
            long j4 = j3 - parseLong;
            Log.d(y.ٴسسݬߨ(1393493874), y.֬ڱܱײٮ(-1158717527) + parseLong + y.ٴسسݬߨ(1393492642) + j3 + y.٬ݯح׭٩(576505686) + j4);
            ApiCallRtt apiCallRtt = map2.get(Long.valueOf(j));
            if (apiCallRtt == null || (responseApi = apiCallRtt.responseApi(parseLong, j3, j4)) == null) {
                return;
            }
            synchronized (rttLock) {
                rttSendData.add(responseApi);
                map2.remove(Long.valueOf(j));
            }
            return;
        }
        map2.remove(Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void response(long j, JSONObject jSONObject) {
        ApiCallRtt responseApi;
        if (j < 0) {
            return;
        }
        Log.d(y.ٴسسݬߨ(1393493874), y.ٲٴݴ״ٰ(1782193408) + j + ':' + (jSONObject != null ? jSONObject.toString() : null));
        Map<Long, ApiCallRtt> map = rttList;
        if (map.get(Long.valueOf(j)) == null || jSONObject == null) {
            return;
        }
        if (jSONObject.containsKey((Object) y.ݮڮֲڭܩ(-628788004)) && jSONObject.containsKey((Object) y.ٴسسݬߨ(1393492338))) {
            Long l = (Long) jSONObject.get((Object) y.ݮڮֲڭܩ(-628788004));
            long longValue = l != null ? l.longValue() : 0L;
            Long l2 = (Long) jSONObject.get((Object) y.ٴسسݬߨ(1393492338));
            long longValue2 = l2 != null ? l2.longValue() : 0L;
            long j2 = longValue2 - longValue;
            Log.d("sendTrace", y.֬ڱܱײٮ(-1158717527) + longValue + y.ٴسسݬߨ(1393492642) + longValue2 + y.٬ݯح׭٩(576505686) + j2);
            ApiCallRtt apiCallRtt = map.get(Long.valueOf(j));
            if (apiCallRtt == null || (responseApi = apiCallRtt.responseApi(longValue, longValue2, j2)) == null) {
                return;
            }
            synchronized (rttLock) {
                rttSendData.add(responseApi);
                map.remove(Long.valueOf(j));
            }
            return;
        }
        map.remove(Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void addTrace(Trace trace) {
        synchronized (queueLock) {
            requestQueue.add(trace);
        }
        if (enableTrace == TraceStatus.ENABLED) {
            send();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void addTraceList(List<Trace> list) {
        synchronized (queueLock) {
            requestQueue.addAll(list);
        }
        if (enableTrace == TraceStatus.ENABLED) {
            send();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendFailure(Trace trace) {
        synchronized (queueLock) {
            requestQueue.addFirst(trace);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Trace getTrace() {
        Trace poll;
        synchronized (queueLock) {
            poll = requestQueue.poll();
        }
        return poll;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRttData() {
        ApiCallRtt poll;
        synchronized (rttLock) {
            poll = rttSendData.poll();
        }
        if (poll == null) {
            return null;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put(y.ٴسسݬߨ(1393492114), poll.getJobId());
        jSONObject.put(y.٬ݯح׭٩(576505910), poll.getJobName());
        jSONObject.put(y.ۮڭڭܬި(862392755), poll.getUri());
        jSONObject.put(y.ۮڭڭܬި(862677043), poll.getOneWayRtt());
        jSONObject.put(y.دײܮڳܯ(2051393261), KGSystem.getDeviceId());
        jSONObject.put(y.ݮڮֲڭܩ(-628788004), poll.getServerStartTime());
        jSONObject.put(y.ٴسسݬߨ(1393492338), poll.getServerResponseTime());
        jSONObject.put(y.ٲٴݴ״ٰ(1782193760), poll.getServerElapsed());
        Log.d(y.ٴسسݬߨ(1393493874), y.ٴسسݬߨ(1393492450) + jSONObject);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, y.ٲٴݴ״ٰ(1781855688));
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, y.ٴسسݬߨ(1393410554));
        return Base64.encodeToString(bytes, 2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void send() {
        if (requestQueue.isEmpty()) {
            sendCompleted();
        } else {
            if (isSending()) {
                return;
            }
            sendStart();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Tracer$send$1(null), 3, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isSending() {
        boolean z;
        synchronized (sendLock) {
            z = isSendingTrace;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendStart() {
        synchronized (sendLock) {
            isSendingTrace = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendCompleted() {
        synchronized (sendLock) {
            isSendingTrace = false;
            Unit unit = Unit.INSTANCE;
        }
    }
}
