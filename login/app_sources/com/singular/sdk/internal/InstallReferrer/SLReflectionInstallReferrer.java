package com.singular.sdk.internal.InstallReferrer;

import android.content.Context;
import com.singular.sdk.internal.SLReflectionUtils;
import com.singular.sdk.internal.SingularLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SLReflectionInstallReferrer implements InvocationHandler {
    private static final long DEFAULT_TIMESTAMP_VALUE = -1;
    private static final SingularLog logger = SingularLog.getLogger("SLReflectionInstallReferrer");
    private Context context;
    private String packageName;
    private final SLInstallReferrerCompletionHandler referrerCallback;
    private Object referrerClient;

    enum InstallReferrerCodes {
        STATUS_OK(0),
        STATUS_FEATURE_NOT_SUPPORTED(1),
        STATUS_SERVICE_UNAVAILABLE(2);

        private int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InstallReferrerCodes(int i) {
            this.value = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SLReflectionInstallReferrer(Context context, String str, SLInstallReferrerCompletionHandler sLInstallReferrerCompletionHandler) {
        this.context = context;
        this.referrerCallback = sLInstallReferrerCompletionHandler;
        this.packageName = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startConnection() {
        Context context = this.context;
        if (context == null) {
            logger.error("context can not be null");
            this.referrerCallback.onInstallReferrerReceived(null);
            return;
        }
        Object createInstallReferrerClient = createInstallReferrerClient(context);
        this.referrerClient = createInstallReferrerClient;
        if (createInstallReferrerClient == null) {
            this.referrerCallback.onInstallReferrerReceived(null);
            return;
        }
        Class installReferrerStateListenerClass = getInstallReferrerStateListenerClass();
        if (installReferrerStateListenerClass == null) {
            this.referrerCallback.onInstallReferrerReceived(null);
            return;
        }
        Object createProxyInstallReferrerStateListener = createProxyInstallReferrerStateListener(installReferrerStateListenerClass);
        if (createProxyInstallReferrerStateListener == null) {
            this.referrerCallback.onInstallReferrerReceived(null);
        } else {
            startConnection(installReferrerStateListenerClass, createProxyInstallReferrerStateListener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object createInstallReferrerClient(Context context) {
        try {
            return SLReflectionUtils.invokeInstanceMethod(SLReflectionUtils.invokeStaticMethod(this.packageName + ".InstallReferrerClient", "newBuilder", new Class[]{Context.class}, context), "build", null, new Object[0]);
        } catch (Throwable th) {
            logger.error("could not create install referrer client %s", th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Class getInstallReferrerStateListenerClass() {
        try {
            return Class.forName(this.packageName + ".InstallReferrerStateListener");
        } catch (Exception e) {
            logger.error("getInstallReferrerStateListenerClass %s", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object createProxyInstallReferrerStateListener(Class cls) {
        try {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
        } catch (Exception e) {
            logger.error("InstallReferrer proxy exception %s", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
        } catch (Throwable th) {
            logger.error("invoke error %s", th.getMessage());
        }
        if (method == null) {
            logger.error("InstallReferrer invoke method null");
            return null;
        }
        String name = method.getName();
        if (name == null) {
            logger.error("InstallReferrer invoke method name null");
            return null;
        }
        if (name.equals("onInstallReferrerSetupFinished")) {
            if (objArr != null && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (!(obj2 instanceof Integer)) {
                    logger.error("onInstallReferrerSetupFinished invalid arg");
                    return null;
                }
                Integer num = (Integer) obj2;
                if (num == null) {
                    logger.error("InstallReferrer invoke onInstallReferrerSetupFinished responseCode arg is null");
                    return null;
                }
                handleOnInstallReferrerSetupFinished(num.intValue());
            }
            logger.error("onInstallReferrerSetupFinished invalid args");
            return null;
        }
        if (name.equals("onInstallReferrerServiceDisconnected")) {
            logger.debug("onInstallReferrerServiceDisconnected");
            closeReferrerClient();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void startConnection(Class cls, Object obj) {
        try {
            SLReflectionUtils.invokeInstanceMethod(this.referrerClient, "startConnection", new Class[]{cls}, obj);
        } catch (Exception e) {
            logger.error("startConnection error %s", e.getMessage());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void handleOnInstallReferrerSetupFinished(int i) {
        int i2 = C26111.f1142x4bf9d7f7[InstallReferrerCodes.values()[i].ordinal()];
        if (i2 == 1) {
            try {
                Object installReferrer = getInstallReferrer();
                HashMap hashMap = new HashMap();
                hashMap.put("referral_url", getStringInstallReferrer(installReferrer));
                hashMap.put("click_time", Long.valueOf(getReferrerClickTimestampSeconds(installReferrer)));
                hashMap.put("install_time", Long.valueOf(getInstallBeginTimestampSeconds(installReferrer)));
                this.referrerCallback.onInstallReferrerReceived(hashMap);
                return;
            } catch (Exception e) {
                logger.error("Couldn't get install referrer %s", e.getMessage());
                return;
            }
        }
        if (i2 == 2) {
            logger.debug("STATUS_FEATURE_NOT_SUPPORTED");
            this.referrerCallback.onInstallReferrerReceived(null);
        } else if (i2 == 3) {
            logger.debug("STATUS_SERVICE_UNAVAILABLE");
            this.referrerCallback.onInstallReferrerReceived(null);
        } else {
            logger.debug("Unexpected response code of install referrer response %d", Integer.valueOf(i));
            this.referrerCallback.onInstallReferrerReceived(null);
        }
    }

    /* renamed from: com.singular.sdk.internal.InstallReferrer.SLReflectionInstallReferrer$1 */
    static /* synthetic */ class C26111 {

        /* renamed from: $SwitchMap$com$singular$sdk$internal$InstallReferrer$SLReflectionInstallReferrer$InstallReferrerCodes */
        static final /* synthetic */ int[] f1142x4bf9d7f7;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[InstallReferrerCodes.values().length];
            f1142x4bf9d7f7 = iArr;
            try {
                iArr[InstallReferrerCodes.STATUS_OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1142x4bf9d7f7[InstallReferrerCodes.STATUS_FEATURE_NOT_SUPPORTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1142x4bf9d7f7[InstallReferrerCodes.STATUS_SERVICE_UNAVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object getInstallReferrer() {
        Object obj = this.referrerClient;
        if (obj == null) {
            return null;
        }
        try {
            return SLReflectionUtils.invokeInstanceMethod(obj, "getInstallReferrer", null, new Object[0]);
        } catch (Exception e) {
            logger.error("getInstallReferrer error %s", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String getStringInstallReferrer(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) SLReflectionUtils.invokeInstanceMethod(obj, "getInstallReferrer", null, new Object[0]);
        } catch (Exception e) {
            logger.error("getStringInstallReferrer error %s", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long getReferrerClickTimestampSeconds(Object obj) {
        if (obj == null) {
            return -1L;
        }
        try {
            return ((Long) SLReflectionUtils.invokeInstanceMethod(obj, "getReferrerClickTimestampSeconds", null, new Object[0])).longValue();
        } catch (Exception e) {
            logger.error("getReferrerClickTimestampSeconds error %s", e.getMessage());
            return -1L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long getInstallBeginTimestampSeconds(Object obj) {
        if (obj == null) {
            return -1L;
        }
        try {
            return ((Long) SLReflectionUtils.invokeInstanceMethod(obj, "getInstallBeginTimestampSeconds", null, new Object[0])).longValue();
        } catch (Exception e) {
            logger.error("getInstallBeginTimestampSeconds error %s", e.getMessage());
            return -1L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void closeReferrerClient() {
        Object obj = this.referrerClient;
        if (obj == null) {
            return;
        }
        try {
            SLReflectionUtils.invokeInstanceMethod(obj, "endConnection", null, new Object[0]);
        } catch (Exception e) {
            logger.error("closeReferrerClient %s", e.getMessage());
        }
        this.referrerClient = null;
    }
}
