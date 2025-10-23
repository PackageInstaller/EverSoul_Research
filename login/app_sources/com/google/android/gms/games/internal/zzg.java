package com.google.android.gms.games.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzg {
    private static final AtomicReference zza = new AtomicReference();
    private final Application zzb;
    private WeakReference zzf;
    private final Application.ActivityLifecycleCallbacks zzc = new zzf(this, null);
    private final Object zzd = new Object();
    private final Set zze = Collections.newSetFromMap(new WeakHashMap());
    private boolean zzg = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzg(Application application) {
        this.zzb = application;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzg zzb(Application application) {
        Preconditions.checkNotNull(application);
        AtomicReference atomicReference = zza;
        zzg zzgVar = (zzg) atomicReference.get();
        if (zzgVar != null) {
            return zzgVar;
        }
        zzg zzgVar2 = new zzg(application);
        while (!UByte$$ExternalSyntheticBackport0.m850m(atomicReference, null, zzgVar2) && atomicReference.get() == null) {
        }
        return (zzg) zza.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzg zzc(Context context) {
        return zzb((Application) context.getApplicationContext());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ void zzd(zzg zzgVar, Activity activity) {
        synchronized (zzgVar.zzd) {
            WeakReference weakReference = zzgVar.zzf;
            if (weakReference == null) {
                return;
            }
            if (weakReference.get() == activity) {
                zzgVar.zzf = null;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ void zze(zzg zzgVar, Activity activity) {
        Preconditions.checkNotNull(activity);
        synchronized (zzgVar.zzd) {
            if (zzgVar.zza() == activity) {
                return;
            }
            zzgVar.zzf = new WeakReference(activity);
            Iterator it = zzgVar.zze.iterator();
            while (it.hasNext()) {
                ((zzd) it.next()).zza(activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final void zzg(zzd zzdVar) {
        Activity zza2 = zza();
        if (zza2 == null) {
            return;
        }
        zzdVar.zza(zza2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Activity zza() {
        Activity activity;
        synchronized (this.zzd) {
            WeakReference weakReference = this.zzf;
            activity = weakReference == null ? null : (Activity) weakReference.get();
        }
        return activity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzf(final zzd zzdVar) {
        Preconditions.checkNotNull(zzdVar);
        synchronized (this.zzd) {
            this.zze.add(zzdVar);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzg(zzdVar);
        } else {
            TaskExecutors.MAIN_THREAD.execute(new Runnable() { // from class: com.google.android.gms.games.internal.zzc
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    zzg.this.zzg(zzdVar);
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzh() {
        synchronized (this.zzd) {
            if (!this.zzg) {
                this.zzb.registerActivityLifecycleCallbacks(this.zzc);
                this.zzg = true;
            }
        }
    }
}
