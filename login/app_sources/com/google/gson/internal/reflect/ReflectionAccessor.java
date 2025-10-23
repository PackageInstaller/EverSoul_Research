package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* loaded from: classes2.dex */
public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance;

    public abstract void makeAccessible(AccessibleObject accessibleObject);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        instance = JavaVersion.getMajorJavaVersion() < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ReflectionAccessor getInstance() {
        return instance;
    }
}
