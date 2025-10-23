package com.google.common.eventbus;

import com.google.common.eventbus.EventBus;
import com.kakao.sdk.share.Constants;
import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public class AsyncEventBus extends EventBus {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AsyncEventBus(String str, Executor executor) {
        super(str, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super(Constants.VALIDATION_DEFAULT, executor, Dispatcher.legacyAsync(), subscriberExceptionHandler);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AsyncEventBus(Executor executor) {
        super(Constants.VALIDATION_DEFAULT, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }
}
