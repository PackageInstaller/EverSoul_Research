package com.google.android.gms.internal.games_v2;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzbl implements zzav {
    private final AtomicReference zza = new AtomicReference(zzbi.UNINITIALIZED);
    private final AtomicReference zzb = new AtomicReference(zzbh.AUTOMATIC);
    private final Queue zzc = new ArrayDeque();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final Application zzf;
    private final com.google.android.gms.games.internal.zzg zzg;
    private final zzbm zzh;
    private final com.google.android.gms.games.internal.p008v2.resolution.zzb zzi;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbl(Application application, com.google.android.gms.games.internal.zzg zzgVar, com.google.android.gms.games.internal.p008v2.resolution.zzb zzbVar, zzbm zzbmVar, byte[] bArr) {
        this.zzf = application;
        this.zzg = zzgVar;
        this.zzi = zzbVar;
        this.zzh = zzbmVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ApiException zzj() {
        return new ApiException(new Status(4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Task zzk(AtomicReference atomicReference, TaskCompletionSource taskCompletionSource) {
        zzbi zzbiVar = zzbi.UNINITIALIZED;
        int ordinal = ((zzbi) atomicReference.get()).ordinal();
        if (ordinal == 0) {
            return Tasks.forException(new ApiException(new Status(10)));
        }
        if (ordinal == 2) {
            return Tasks.forResult(AuthenticationResult.zza);
        }
        if (ordinal == 3) {
            return Tasks.forResult(AuthenticationResult.zzb);
        }
        if (taskCompletionSource == null) {
            return Tasks.forResult(AuthenticationResult.zzb);
        }
        Task task = taskCompletionSource.getTask();
        if (task.isSuccessful()) {
            return ((Boolean) task.getResult()).booleanValue() ? Tasks.forResult(AuthenticationResult.zza) : Tasks.forResult(AuthenticationResult.zzb);
        }
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        task.addOnCompleteListener(zzfe.zza(), new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbb
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                TaskCompletionSource taskCompletionSource3 = TaskCompletionSource.this;
                if (task2.isSuccessful() && ((Boolean) task2.getResult()).booleanValue()) {
                    taskCompletionSource3.trySetResult(AuthenticationResult.zza);
                } else {
                    taskCompletionSource3.trySetResult(AuthenticationResult.zzb);
                }
            }
        });
        return taskCompletionSource2.getTask();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Task zzl(final zzff zzffVar) {
        if (zzp()) {
            return (Task) zzffVar.zza();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskExecutors.MAIN_THREAD.execute(new Runnable() { // from class: com.google.android.gms.internal.games_v2.zzbe
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                zzff zzffVar2 = zzff.this;
                final TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                ((Task) zzffVar2.zza()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbc
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        TaskCompletionSource taskCompletionSource3 = TaskCompletionSource.this;
                        if (task.isSuccessful()) {
                            taskCompletionSource3.trySetResult(task.getResult());
                            return;
                        }
                        Exception exception = task.getException();
                        zzfb.zza(exception);
                        taskCompletionSource3.trySetException(exception);
                    }
                });
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzm(final TaskCompletionSource taskCompletionSource, final zzy zzyVar) {
        zzez.zza("GamesApiManager", "Attempting authentication: ".concat(zzyVar.toString()));
        this.zzh.zza(zzyVar).addOnCompleteListener(TaskExecutors.MAIN_THREAD, new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzba
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzbl.this.zzg(taskCompletionSource, zzyVar, task);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzn(final TaskCompletionSource taskCompletionSource, final int i, PendingIntent pendingIntent, boolean z, boolean z2) {
        Activity zza;
        Preconditions.checkMainThread("Must be called on the main thread.");
        if (z && pendingIntent != null && (zza = this.zzg.zza()) != null) {
            com.google.android.gms.games.internal.p008v2.resolution.zzb.zzb(zza, pendingIntent).addOnCompleteListener(TaskExecutors.MAIN_THREAD, new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzaz
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzbl.this.zzh(taskCompletionSource, i, task);
                }
            });
            zzez.zza("GamesApiManager", "Resolution triggered");
            return;
        }
        boolean zza2 = zzay.zza(this.zzb, zzbh.AUTOMATIC_PENDING_EXPLICIT, zzbh.EXPLICIT);
        if (!z2 && zza2) {
            zzez.zza("GamesApiManager", "Consumed pending explicit sign-in. Attempting explicit sign-in");
            zzm(taskCompletionSource, zzy.zzb(0));
            return;
        }
        taskCompletionSource.trySetResult(false);
        this.zza.set(zzbi.AUTHENTICATION_FAILED);
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            ((zzbk) it.next()).zzc(zzj());
            it.remove();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzo(int i) {
        StringBuilder sb = new StringBuilder(56);
        sb.append("startAuthenticationIfNecessary() signInType: ");
        sb.append(i);
        zzez.zza("GamesApiManager", sb.toString());
        Preconditions.checkMainThread("Must be called on the main thread.");
        if (zzay.zza(this.zza, zzbi.UNINITIALIZED, zzbi.AUTHENTICATING) || zzay.zza(this.zza, zzbi.AUTHENTICATION_FAILED, zzbi.AUTHENTICATING)) {
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzd.get();
            if (taskCompletionSource != null) {
                taskCompletionSource.trySetException(new IllegalStateException("New authentication attempt in progress"));
            }
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            this.zzd.set(taskCompletionSource2);
            this.zzb.set(i == 0 ? zzbh.EXPLICIT : zzbh.AUTOMATIC);
            zzm(taskCompletionSource2, zzy.zzb(i));
            return;
        }
        if (i == 0) {
            boolean zza = zzay.zza(this.zzb, zzbh.AUTOMATIC, zzbh.AUTOMATIC_PENDING_EXPLICIT);
            StringBuilder sb2 = new StringBuilder(88);
            sb2.append("Explicit sign-in during existing authentication. Marking pending explicit sign-in: ");
            sb2.append(zza);
            zzez.zza("GamesApiManager", sb2.toString());
        }
        String valueOf = String.valueOf(this.zza.get());
        String.valueOf(valueOf).length();
        zzez.zza("GamesApiManager", "Authentication attempt skipped. Already authenticated or authenticating. State: ".concat(String.valueOf(valueOf)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzp() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzav
    public final Task zza() {
        return zzl(new zzff() { // from class: com.google.android.gms.internal.games_v2.zzbf
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzff
            public final Object zza() {
                return zzbl.this.zze();
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzav
    public final Task zzb() {
        return zzl(new zzff() { // from class: com.google.android.gms.internal.games_v2.zzbg
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzff
            public final Object zza() {
                return zzbl.this.zzf();
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzav
    public final Task zzc() {
        return zzk(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzav
    public final Task zzd(zzap zzapVar) {
        zzbi zzbiVar = (zzbi) this.zza.get();
        String valueOf = String.valueOf(zzbiVar);
        String.valueOf(valueOf).length();
        zzez.zzf("GamesApiManager", "Executing API call with authentication state: ".concat(String.valueOf(valueOf)));
        if (zzbiVar == zzbi.AUTHENTICATED) {
            return zzapVar.zza((GoogleApi) this.zze.get());
        }
        if (zzbiVar == zzbi.AUTHENTICATION_FAILED) {
            return Tasks.forException(zzj());
        }
        if (zzbiVar == zzbi.UNINITIALIZED) {
            return Tasks.forException(new ApiException(new Status(10)));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final zzbk zzbkVar = new zzbk(zzapVar, taskCompletionSource, null);
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.games_v2.zzbd
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                zzbl.this.zzi(zzbkVar);
            }
        };
        if (zzp()) {
            runnable.run();
        } else {
            TaskExecutors.MAIN_THREAD.execute(runnable);
        }
        return taskCompletionSource.getTask();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Task zze() {
        zzo(1);
        return zzk(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Task zzf() {
        zzo(0);
        return zzk(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzg(TaskCompletionSource taskCompletionSource, zzy zzyVar, Task task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            zzfb.zza(exception);
            zzez.zzb("GamesApiManager", "Authentication task failed", exception);
            zzn(taskCompletionSource, zzyVar.zza(), null, false, !zzyVar.zzd());
            return;
        }
        zzbq zzbqVar = (zzbq) task.getResult();
        if (!zzbqVar.zze()) {
            String valueOf = String.valueOf(zzbqVar);
            String.valueOf(valueOf).length();
            zzez.zza("GamesApiManager", "Failed to authenticate: ".concat(String.valueOf(valueOf)));
            zzn(taskCompletionSource, zzyVar.zza(), zzbqVar.zza(), true, !zzyVar.zzd());
            return;
        }
        String zzd = zzbqVar.zzd();
        if (zzd == null) {
            zzez.zzg("GamesApiManager", "Unexpected state: game run token absent");
            zzn(taskCompletionSource, zzyVar.zza(), null, false, !zzyVar.zzd());
            return;
        }
        zzez.zza("GamesApiManager", "Successfully authenticated");
        Preconditions.checkMainThread("Must be called on the main thread.");
        com.google.android.gms.games.zzl zzb = com.google.android.gms.games.zzn.zzb();
        zzb.zzd(2101523);
        zzb.zzc(GoogleSignInAccount.createDefault());
        zzb.zza(zzd);
        com.google.android.gms.games.internal.zzj zza = com.google.android.gms.games.internal.zzl.zza();
        zza.zzb(true);
        zza.zzc(true);
        zza.zza(true);
        zzb.zzb(zza.zzd());
        zze zzeVar = new zze(this.zzf, zzb.zze());
        this.zze.set(zzeVar);
        this.zza.set(zzbi.AUTHENTICATED);
        taskCompletionSource.trySetResult(true);
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            ((zzbk) it.next()).zza(zzeVar);
            it.remove();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzh(TaskCompletionSource taskCompletionSource, int i, Task task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            zzfb.zza(exception);
            zzez.zzh("GamesApiManager", "Resolution failed", exception);
            zzn(taskCompletionSource, i, null, false, true);
            return;
        }
        com.google.android.gms.games.internal.p008v2.resolution.zzc zzcVar = (com.google.android.gms.games.internal.p008v2.resolution.zzc) task.getResult();
        if (zzcVar.zzd()) {
            zzez.zza("GamesApiManager", "Resolution successful");
            zzm(taskCompletionSource, zzy.zzc(i, zzaf.zza(zzcVar.zza())));
        } else {
            zzez.zza("GamesApiManager", "Resolution attempt was canceled");
            zzn(taskCompletionSource, i, null, false, true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzi(zzbk zzbkVar) {
        Preconditions.checkMainThread("Must be called on the main thread.");
        zzbi zzbiVar = (zzbi) this.zza.get();
        if (zzbiVar == zzbi.AUTHENTICATED) {
            zzbkVar.zza((GoogleApi) this.zze.get());
        } else if (zzbiVar == zzbi.AUTHENTICATION_FAILED) {
            zzbkVar.zzc(zzj());
        } else {
            this.zzc.add(zzbkVar);
        }
    }
}
