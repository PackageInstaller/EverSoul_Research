package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;

/* loaded from: classes.dex */
public abstract class BackendRequest {

    public static abstract class Builder {
        public abstract BackendRequest build();

        public abstract Builder setEvents(Iterable<EventInternal> iterable);

        public abstract Builder setExtras(byte[] bArr);
    }

    public abstract Iterable<EventInternal> getEvents();

    public abstract byte[] getExtras();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendRequest create(Iterable<EventInternal> iterable) {
        return builder().setEvents(iterable).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new AutoValue_BackendRequest.Builder();
    }
}
