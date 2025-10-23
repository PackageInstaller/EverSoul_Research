package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.OnChangeListener;

/* loaded from: classes2.dex */
final /* synthetic */ class zzdj implements ChangeListener {
    private final OnChangeListener zzgi;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzdj(OnChangeListener onChangeListener) {
        this.zzgi = onChangeListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ChangeListener zza(OnChangeListener onChangeListener) {
        return new zzdj(onChangeListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.events.ChangeListener
    public final void onChange(ChangeEvent changeEvent) {
        this.zzgi.onChange(changeEvent);
    }
}
