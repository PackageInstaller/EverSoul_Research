package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjx implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzio zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c6 A[Catch: RuntimeException -> 0x01d3, TRY_ENTER, TryCatch #0 {RuntimeException -> 0x01d3, blocks: (B:3:0x000b, B:5:0x0018, B:8:0x0029, B:10:0x002f, B:13:0x0040, B:19:0x00c6, B:21:0x00d2, B:24:0x00e3, B:26:0x00e9, B:29:0x00fe, B:31:0x0104, B:34:0x0111, B:36:0x0117, B:37:0x012f, B:38:0x013e, B:42:0x0145, B:46:0x0168, B:47:0x0184, B:49:0x0175, B:50:0x018b, B:52:0x0191, B:54:0x0197, B:56:0x019d, B:58:0x01a3, B:60:0x01ab, B:64:0x01b9, B:66:0x01c7, B:68:0x01cd, B:76:0x0054, B:79:0x005c, B:81:0x0064, B:83:0x006a, B:85:0x0070, B:87:0x0076, B:89:0x007e, B:91:0x0086, B:94:0x0090, B:96:0x0098, B:97:0x00a4, B:99:0x00bd), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0144 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0145 A[Catch: RuntimeException -> 0x01d3, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x01d3, blocks: (B:3:0x000b, B:5:0x0018, B:8:0x0029, B:10:0x002f, B:13:0x0040, B:19:0x00c6, B:21:0x00d2, B:24:0x00e3, B:26:0x00e9, B:29:0x00fe, B:31:0x0104, B:34:0x0111, B:36:0x0117, B:37:0x012f, B:38:0x013e, B:42:0x0145, B:46:0x0168, B:47:0x0184, B:49:0x0175, B:50:0x018b, B:52:0x0191, B:54:0x0197, B:56:0x019d, B:58:0x01a3, B:60:0x01ab, B:64:0x01b9, B:66:0x01c7, B:68:0x01cd, B:76:0x0054, B:79:0x005c, B:81:0x0064, B:83:0x006a, B:85:0x0070, B:87:0x0076, B:89:0x007e, B:91:0x0086, B:94:0x0090, B:96:0x0098, B:97:0x00a4, B:99:0x00bd), top: B:2:0x000b }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void zza(com.google.android.gms.measurement.internal.zzjx r17, boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjx.zza(com.google.android.gms.measurement.internal.zzjx, boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjx(zzio zzioVar) {
        this.zza = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.zza.zzj().zzp().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            if (data == null || !data.isHierarchical()) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString("com.android.vending.referral_url");
                    if (!TextUtils.isEmpty(string)) {
                        data = Uri.parse(string);
                    }
                }
                data = null;
            }
            Uri uri = data;
            if (uri != null && uri.isHierarchical()) {
                this.zza.zzq();
                this.zza.zzl().zzb(new zzka(this, bundle == null, uri, zzng.zza(intent) ? "gs" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO, uri.getQueryParameter("referrer")));
            }
        } catch (RuntimeException e) {
            this.zza.zzj().zzg().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzn().zza(activity, bundle);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzn().zza(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzn().zzb(activity);
        zzly zzp = this.zza.zzp();
        zzp.zzl().zzb(new zzma(zzp, zzp.zzb().elapsedRealtime()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzly zzp = this.zza.zzp();
        zzp.zzl().zzb(new zzlx(zzp, zzp.zzb().elapsedRealtime()));
        this.zza.zzn().zzc(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzn().zzb(activity, bundle);
    }
}
