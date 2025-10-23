package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.C0890R;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class StringResourceValueReader {
    private final Resources zza;
    private final String zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StringResourceValueReader(Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.zza = resources;
        this.zzb = resources.getResourcePackageName(C0890R.string.common_google_play_services_unknown_issue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getString(String str) {
        int identifier = this.zza.getIdentifier(str, TypedValues.Custom.S_STRING, this.zzb);
        if (identifier == 0) {
            return null;
        }
        return this.zza.getString(identifier);
    }
}
