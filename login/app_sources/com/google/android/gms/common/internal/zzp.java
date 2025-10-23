package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzp implements ServiceConnection, zzt {
    final /* synthetic */ zzs zza;
    private final Map zzb = new HashMap();
    private int zzc = 2;
    private boolean zzd;
    private IBinder zze;
    private final zzo zzf;
    private ComponentName zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzp(zzs zzsVar, zzo zzoVar) {
        this.zza = zzsVar;
        this.zzf = zzoVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.zza.zzb;
        synchronized (hashMap) {
            handler = this.zza.zzd;
            handler.removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            Iterator it = this.zzb.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.zza.zzb;
        synchronized (hashMap) {
            handler = this.zza.zzd;
            handler.removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            Iterator it = this.zzb.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ComponentName zzb() {
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IBinder zzc() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zze(String str, Executor executor) {
        ConnectionTracker connectionTracker;
        Context context;
        Context context2;
        ConnectionTracker connectionTracker2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        this.zzc = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.isAtLeastS()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            zzs zzsVar = this.zza;
            connectionTracker = zzsVar.zzf;
            context = zzsVar.zzc;
            zzo zzoVar = this.zzf;
            context2 = zzsVar.zzc;
            boolean zza = connectionTracker.zza(context, str, zzoVar.zzb(context2), this, 4225, executor);
            this.zzd = zza;
            if (zza) {
                handler = this.zza.zzd;
                Message obtainMessage = handler.obtainMessage(1, this.zzf);
                handler2 = this.zza.zzd;
                j = this.zza.zzh;
                handler2.sendMessageDelayed(obtainMessage, j);
            } else {
                this.zzc = 2;
                try {
                    zzs zzsVar2 = this.zza;
                    connectionTracker2 = zzsVar2.zzf;
                    context3 = zzsVar2.zzc;
                    connectionTracker2.unbindService(context3, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzf(ServiceConnection serviceConnection, String str) {
        this.zzb.remove(serviceConnection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzg(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        zzo zzoVar = this.zzf;
        handler = this.zza.zzd;
        handler.removeMessages(1, zzoVar);
        zzs zzsVar = this.zza;
        connectionTracker = zzsVar.zzf;
        context = zzsVar.zzc;
        connectionTracker.unbindService(context, this);
        this.zzd = false;
        this.zzc = 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzh(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzi() {
        return this.zzb.isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzj() {
        return this.zzd;
    }
}
