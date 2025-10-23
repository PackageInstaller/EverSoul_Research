package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OpenFileCallback;

/* loaded from: classes2.dex */
final class zzdk extends zzl {
    private final /* synthetic */ zzch zzfw;
    private final ListenerToken zzgj;
    private final ListenerHolder<OpenFileCallback> zzgk;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdk(zzch zzchVar, ListenerToken listenerToken, ListenerHolder<OpenFileCallback> listenerHolder) {
        this.zzfw = zzchVar;
        this.zzgj = listenerToken;
        this.zzgk = listenerHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(final Status status) throws RemoteException {
        zza(new zzdg(this, status) { // from class: com.google.android.gms.internal.drive.zzdl
            private final zzdk zzgl;
            private final Status zzgm;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.zzgl = this;
                this.zzgm = status;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.drive.zzdg
            public final void accept(Object obj) {
                this.zzgl.zza(this.zzgm, (OpenFileCallback) obj);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(final zzfl zzflVar) throws RemoteException {
        zza(new zzdg(zzflVar) { // from class: com.google.android.gms.internal.drive.zzdm
            private final zzfl zzgn;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.zzgn = zzflVar;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.drive.zzdg
            public final void accept(Object obj) {
                zzfl zzflVar2 = this.zzgn;
                ((OpenFileCallback) obj).onProgress(zzflVar2.zzhy, zzflVar2.zzhz);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(final zzfh zzfhVar) throws RemoteException {
        zza(new zzdg(this, zzfhVar) { // from class: com.google.android.gms.internal.drive.zzdn
            private final zzdk zzgl;
            private final zzfh zzgo;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.zzgl = this;
                this.zzgo = zzfhVar;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.drive.zzdg
            public final void accept(Object obj) {
                this.zzgl.zza(this.zzgo, (OpenFileCallback) obj);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(zzdg<OpenFileCallback> zzdgVar) {
        this.zzgk.notifyListener(new zzdo(this, zzdgVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(zzfh zzfhVar, OpenFileCallback openFileCallback) {
        openFileCallback.onContents(new zzbi(zzfhVar.zzes));
        this.zzfw.cancelOpenFileCallback(this.zzgj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(Status status, OpenFileCallback openFileCallback) {
        openFileCallback.onError(ApiExceptionUtil.fromStatus(status));
        this.zzfw.cancelOpenFileCallback(this.zzgj);
    }
}
