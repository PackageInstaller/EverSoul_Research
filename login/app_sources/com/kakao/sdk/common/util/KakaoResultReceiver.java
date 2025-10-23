package com.kakao.sdk.common.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.kakaogame.server.ServerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoResultReceiver.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\rH&J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakao/sdk/common/util/KakaoResultReceiver;", "T", "Landroid/os/ResultReceiver;", "message", "", "(Ljava/lang/String;)V", "emitter", "getEmitter", "()Ljava/lang/Object;", "setEmitter", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "onReceiveResult", "", ServerConstants.TRACE_RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "processError", "receiveCanceled", "receiveOk", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public abstract class KakaoResultReceiver<T> extends ResultReceiver {
    private T emitter;
    private final String message;

    public abstract void processError();

    public abstract void receiveCanceled(Bundle resultData);

    public abstract void receiveOk(Bundle resultData);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KakaoResultReceiver(String message) {
        super(new Handler(Looper.getMainLooper()));
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final T getEmitter() {
        return this.emitter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setEmitter(T t) {
        this.emitter = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        SdkLog.INSTANCE.m469d("***** " + this.message + " Status: " + resultData);
        if (resultCode == -1) {
            receiveOk(resultData);
        } else if (resultCode == 0) {
            receiveCanceled(resultData);
        } else {
            processError();
        }
        this.emitter = null;
    }
}
