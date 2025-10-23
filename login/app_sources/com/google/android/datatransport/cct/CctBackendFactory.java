package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;

/* loaded from: classes.dex */
public class CctBackendFactory implements BackendFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.backends.BackendFactory
    public TransportBackend create(CreationContext creationContext) {
        return new CctTransportBackend(creationContext.getApplicationContext(), creationContext.getWallClock(), creationContext.getMonotonicClock());
    }
}
