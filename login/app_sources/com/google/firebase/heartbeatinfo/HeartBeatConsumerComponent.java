package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;

/* loaded from: classes2.dex */
public class HeartBeatConsumerComponent {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HeartBeatConsumerComponent() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Component<?> create() {
        return Component.intoSet(new HeartBeatConsumer() { // from class: com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent.1
        }, (Class<HeartBeatConsumer>) HeartBeatConsumer.class);
    }
}
