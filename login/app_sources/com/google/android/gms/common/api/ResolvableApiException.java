package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class ResolvableApiException extends ApiException {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResolvableApiException(Status status) {
        super(status);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PendingIntent getResolution() {
        return getStatus().getResolution();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        getStatus().startResolutionForResult(activity, i);
    }
}
