package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

/* loaded from: classes2.dex */
public class Event<T> {
    private final T payload;
    private final Class<T> type;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Event(Class<T> cls, T t) {
        this.type = (Class) Preconditions.checkNotNull(cls);
        this.payload = (T) Preconditions.checkNotNull(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Class<T> getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T getPayload() {
        return this.payload;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.type, this.payload);
    }
}
