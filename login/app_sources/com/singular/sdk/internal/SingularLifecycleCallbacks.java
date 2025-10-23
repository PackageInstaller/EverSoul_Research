package com.singular.sdk.internal;

import android.app.Application;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public class SingularLifecycleCallbacks implements InvocationHandler {
    private static final SingularLog logger = SingularLog.getLogger("SingularLifecycleCallbacks");
    private final SessionManager sessionManager;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingularLifecycleCallbacks(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        sessionManager.useForegroundTracking();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void registerSelf(Application application) {
        Method method;
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Application.class.getClassLoader(), new Class[]{Class.forName("android.app.Application$ActivityLifecycleCallbacks")}, this);
            Method[] methods = Application.class.getMethods();
            int length = methods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methods[i];
                if (method.getName().equals("registerActivityLifecycleCallbacks")) {
                    break;
                } else {
                    i++;
                }
            }
            if (method != null) {
                method.invoke(application, newProxyInstance);
                logger.debug("ActivityLifecycleCallbacks registration successful, Automatic session management will work.");
            } else {
                logger.error("ActivityLifecycleCallbacks registration not available, Automatic session management will not work");
            }
        } catch (Throwable th) {
            logger.error("ActivityLifecycleCallbacks registration failed, Automatic session management will not work", th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if ("onActivityResumed".equals(method.getName())) {
            this.sessionManager.onEnterForeground(Utils.getCurrentTimeMillis());
            return null;
        }
        if (!"onActivityPaused".equals(method.getName())) {
            return null;
        }
        BatchManager batchManager = BatchManager.getInstance();
        if (batchManager != null) {
            batchManager.sendEvents();
        }
        this.sessionManager.onExitForeground(Utils.getCurrentTimeMillis());
        return null;
    }
}
