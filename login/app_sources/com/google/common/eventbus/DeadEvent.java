package com.google.common.eventbus;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public class DeadEvent {
    private final Object event;
    private final Object source;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DeadEvent(Object obj, Object obj2) {
        this.source = Preconditions.checkNotNull(obj);
        this.event = Preconditions.checkNotNull(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getSource() {
        return this.source;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getEvent() {
        return this.event;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return MoreObjects.toStringHelper(this).add("source", this.source).add(NotificationCompat.CATEGORY_EVENT, this.event).toString();
    }
}
