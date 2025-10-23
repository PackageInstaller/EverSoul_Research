package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions;

/* loaded from: classes.dex */
public final class zzp extends ExecutionOptions.Builder {
    private boolean zzat = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions build() {
        zzo();
        return new zzn(this.zzaq, this.zzar, this.zzas, this.zzat);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setConflictStrategy(int i) {
        super.setConflictStrategy(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setNotifyOnCompletion(boolean z) {
        super.setNotifyOnCompletion(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setTrackingTag(String str) {
        super.setTrackingTag(str);
        return this;
    }
}
