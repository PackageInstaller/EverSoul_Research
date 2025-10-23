package com.android.volley;

import android.content.Intent;
import com.liapp.y;

/* loaded from: classes.dex */
public class AuthFailureError extends VolleyError {
    private Intent mResolutionIntent;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthFailureError() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthFailureError(Intent intent) {
        this.mResolutionIntent = intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthFailureError(String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthFailureError(String str, Exception exc) {
        super(str, exc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mResolutionIntent != null ? y.ٴسسݬߨ(1392844370) : super.getMessage();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Intent getResolutionIntent() {
        return this.mResolutionIntent;
    }
}
