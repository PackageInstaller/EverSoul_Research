package androidx.transition;

import android.os.IBinder;

/* loaded from: classes5.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    WindowIdApi14(IBinder iBinder) {
        this.mToken = iBinder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).mToken.equals(this.mToken);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.mToken.hashCode();
    }
}
