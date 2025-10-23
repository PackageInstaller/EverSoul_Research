package com.google.firebase.crashlytics.internal.breadcrumbs;

import com.google.firebase.crashlytics.internal.Logger;

/* loaded from: classes2.dex */
public class DisabledBreadcrumbSource implements BreadcrumbSource {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        Logger.getLogger().m390d("Could not register handler for breadcrumbs events.");
    }
}
