package com.google.android.gms.common.moduleinstall;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.moduleinstall.internal.zay;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public final class ModuleInstall {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ModuleInstall() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ModuleInstallClient getClient(Activity activity) {
        return new zay(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ModuleInstallClient getClient(Context context) {
        return new zay(context);
    }
}
