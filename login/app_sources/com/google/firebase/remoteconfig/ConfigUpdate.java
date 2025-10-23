package com.google.firebase.remoteconfig;

import java.util.Set;

/* loaded from: classes2.dex */
public abstract class ConfigUpdate {
    public abstract Set<String> getUpdatedKeys();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigUpdate create(Set<String> set) {
        return new AutoValue_ConfigUpdate(set);
    }
}
