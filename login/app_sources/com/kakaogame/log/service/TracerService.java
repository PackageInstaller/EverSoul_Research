package com.kakaogame.log.service;

import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.addon.KGService;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.tracer.Trace;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.server.session.SessionService;
import com.kakaogame.util.TelephonyUtil;
import com.kakaogame.util.VersionUtil;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TracerService.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/log/service/TracerService;", "", "()V", "TAG", "", KGService.COUNT, "", "getCount", "()I", "setCount", "(I)V", "sendTrace", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", ServerConstants.HEADER_TRACE_ID, "trace", "Lcom/kakaogame/log/tracer/Trace;", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TracerService {
    public static final TracerService INSTANCE = new TracerService();
    private static final String TAG = "TracerService";
    private static int count;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TracerService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getCount() {
        return count;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCount(int i) {
        count = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> sendTrace(String traceId, Trace trace) {
        String str = y.ٴسسݬߨ(1393504626);
        Intrinsics.checkNotNullParameter(traceId, str);
        Intrinsics.checkNotNullParameter(trace, y.٬ݯح׭٩(576517446));
        Logger logger = Logger.INSTANCE;
        String str2 = y.ۮڭڭܬި(862673051) + traceId + y.֬ڱܱײٮ(-1158713559) + trace;
        String str3 = y.֬ڱܱײٮ(-1158713519);
        logger.m706v(str3, str2);
        try {
            boolean z = true;
            count++;
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getTracerUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            serverRequest.putHeader(str, traceId);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("appVersion", configuration.getAppVersion());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            serverRequest.putBody(ServerConstants.DEVICE_MODEL, KGSystem.getDeviceModel());
            serverRequest.putBody(ServerConstants.LANGUAGE_CODE, KGSystem.getLanguageCode());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody(ServerConstants.NETWORK_TYPE, KGSystem.getNetworkType());
            serverRequest.putBody("os", KGSystem.getOSName());
            serverRequest.putBody(ServerConstants.OS_VERSION, VersionUtil.getOSVersion());
            serverRequest.putBody(ServerConstants.SDK_VERSION, SDKVersion.version);
            serverRequest.putBody(ServerConstants.TELECOM, TelephonyUtil.getNetworkOperatorName(CoreManager.INSTANCE.getInstance().getContext()));
            serverRequest.putBody(ServerConstants.TRACE_JOB_NAME, trace.getJob());
            serverRequest.putBody("jobId", Integer.valueOf(trace.getJobId()));
            if (trace.getAction().length() > 0) {
                serverRequest.putBody("action", trace.getAction());
            }
            serverRequest.putBody("startTime", Long.valueOf(trace.getStartTime()));
            serverRequest.putBody("duration", Long.valueOf(trace.getDuration()));
            serverRequest.putBody(ServerConstants.TRACE_RESULT_CODE, Integer.valueOf(trace.getResultCode()));
            serverRequest.putBody(ServerConstants.TRACE_RESULT_DESCRIPTION, trace.getResultDescription());
            serverRequest.putBody("extras", trace.getExtras());
            if (trace.getRttCheckServerUrl().length() <= 0) {
                z = false;
            }
            if (z) {
                serverRequest.putBody(ServerConstants.TRACE_RTT_CHECK_SERVER_URL, trace.getRttCheckServerUrl());
            }
            return KGResult.INSTANCE.getResult(SessionService.isConnected() ? ServerService.requestServer$default(serverRequest, 0, 2, null) : OpenApiService.requestServerApi$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: TracerService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/log/service/TracerService$Settings;", "", "()V", "tracerUri", "", "getTracerUri", "()Ljava/lang/String;", "setTracerUri", "(Ljava/lang/String;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String tracerUri = OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1158714063), y.ݮڮֲڭܩ(-628423452));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getTracerUri() {
            return tracerUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setTracerUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            tracerUri = str;
        }
    }
}
