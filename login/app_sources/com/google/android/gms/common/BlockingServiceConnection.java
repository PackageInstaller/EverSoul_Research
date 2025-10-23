package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class BlockingServiceConnection implements ServiceConnection {
    boolean zza = false;
    private final BlockingQueue zzb = new LinkedBlockingQueue();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ResultIgnorabilityUnspecified
    public IBinder getService() throws InterruptedException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (this.zza) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.zza = true;
        return (IBinder) this.zzb.take();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ResultIgnorabilityUnspecified
    public IBinder getServiceWithTimeout(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.zza) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.zza = true;
        IBinder iBinder = (IBinder) this.zzb.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzb.add(iBinder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
