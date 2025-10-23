package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class DependencyCycleException extends DependencyException {
    private final List<Component<?>> componentsInCycle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DependencyCycleException(List<Component<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Component<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
