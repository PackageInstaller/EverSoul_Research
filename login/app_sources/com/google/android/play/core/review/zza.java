package com.google.android.play.core.review;

import android.app.PendingIntent;

/* compiled from: com.google.android.play:review@@2.0.0 */
/* loaded from: classes2.dex */
final class zza extends ReviewInfo {
    private final PendingIntent zza;
    private final boolean zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zza(PendingIntent pendingIntent, boolean z) {
        if (pendingIntent == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.zza = pendingIntent;
        this.zzb = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            ReviewInfo reviewInfo = (ReviewInfo) obj;
            if (this.zza.equals(reviewInfo.zza()) && this.zzb == reviewInfo.zzb()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "ReviewInfo{pendingIntent=" + this.zza.toString() + ", isNoOp=" + this.zzb + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.play.core.review.ReviewInfo
    final PendingIntent zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.play.core.review.ReviewInfo
    final boolean zzb() {
        return this.zzb;
    }
}
