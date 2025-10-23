package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes2.dex */
final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PreJava9ReflectionAccessor() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
