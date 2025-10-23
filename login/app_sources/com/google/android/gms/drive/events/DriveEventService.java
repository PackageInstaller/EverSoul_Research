package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.drive.zzet;
import com.google.android.gms.internal.drive.zzfp;
import com.google.android.gms.internal.drive.zzir;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DriveEventService extends Service implements ChangeListener, CompletionListener, zzd, zzi {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private static final GmsLogger zzbz = new GmsLogger("DriveEventService", "");
    private final String name;
    private CountDownLatch zzcj;
    zza zzck;
    boolean zzcl;
    private int zzcm;

    final class zzb extends zzet {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zzb() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.drive.zzes
        public final void zzc(zzfp zzfpVar) throws RemoteException {
            synchronized (DriveEventService.this) {
                DriveEventService.this.zzw();
                if (DriveEventService.this.zzck != null) {
                    DriveEventService.this.zzck.sendMessage(DriveEventService.this.zzck.zzb(zzfpVar));
                } else {
                    DriveEventService.zzbz.m145e("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ zzb(DriveEventService driveEventService, zzh zzhVar) {
            this();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected DriveEventService(String str) {
        this.zzcl = false;
        this.zzcm = -1;
        this.name = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return true;
    }

    static final class zza extends zzir {
        private final WeakReference<DriveEventService> zzcp;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zza(DriveEventService driveEventService) {
            this.zzcp = new WeakReference<>(driveEventService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Message zzb(zzfp zzfpVar) {
            return obtainMessage(1, zzfpVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Message zzy() {
            return obtainMessage(2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    getLooper().quit();
                    return;
                } else {
                    DriveEventService.zzbz.wfmt("DriveEventService", "Unexpected message type: %s", Integer.valueOf(message.what));
                    return;
                }
            }
            DriveEventService driveEventService = this.zzcp.get();
            if (driveEventService == null) {
                getLooper().quit();
            } else {
                driveEventService.zza((zzfp) message.obj);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ zza(DriveEventService driveEventService, zzh zzhVar) {
            this(driveEventService);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected DriveEventService() {
        this("DriveEventService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        zzh zzhVar = null;
        if (!ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            return null;
        }
        if (this.zzck == null && !this.zzcl) {
            this.zzcl = true;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzcj = new CountDownLatch(1);
            new zzh(this, countDownLatch).start();
            try {
                if (!countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                    zzbz.m145e("DriveEventService", "Failed to synchronously initialize event handler.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Unable to start event handler", e);
            }
        }
        return new zzb(this, zzhVar).asBinder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Service
    public synchronized void onDestroy() {
        zza zzaVar = this.zzck;
        if (zzaVar != null) {
            this.zzck.sendMessage(zzaVar.zzy());
            this.zzck = null;
            try {
                if (!this.zzcj.await(5000L, TimeUnit.MILLISECONDS)) {
                    zzbz.m151w("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException unused) {
            }
            this.zzcj = null;
        }
        super.onDestroy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.events.ChangeListener
    public void onChange(ChangeEvent changeEvent) {
        zzbz.wfmt("DriveEventService", "Unhandled change event in %s: %s", this.name, changeEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.events.zzd
    public final void zza(com.google.android.gms.drive.events.zzb zzbVar) {
        zzbz.wfmt("DriveEventService", "Unhandled changes available event in %s: %s", this.name, zzbVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.events.CompletionListener
    public void onCompletion(CompletionEvent completionEvent) {
        zzbz.wfmt("DriveEventService", "Unhandled completion event in %s: %s", this.name, completionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzfp zzfpVar) {
        DriveEvent zzat = zzfpVar.zzat();
        try {
            int type = zzat.getType();
            if (type == 1) {
                onChange((ChangeEvent) zzat);
                return;
            }
            if (type == 2) {
                onCompletion((CompletionEvent) zzat);
                return;
            }
            if (type == 4) {
                zza((com.google.android.gms.drive.events.zzb) zzat);
            } else if (type == 7) {
                zzbz.wfmt("DriveEventService", "Unhandled transfer state event in %s: %s", this.name, (zzv) zzat);
            } else {
                zzbz.wfmt("DriveEventService", "Unhandled event: %s", zzat);
            }
        } catch (Exception e) {
            zzbz.m146e("DriveEventService", String.format("Error handling event in %s", this.name), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzw() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid == this.zzcm) {
            return;
        }
        if (UidVerifier.isGooglePlayServicesUid(this, callingUid)) {
            this.zzcm = callingUid;
            return;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
