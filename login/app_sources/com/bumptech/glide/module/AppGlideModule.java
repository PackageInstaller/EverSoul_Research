package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;

/* loaded from: classes.dex */
public abstract class AppGlideModule extends LibraryGlideModule implements AppliesOptions {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isManifestParsingEnabled() {
        return true;
    }
}
