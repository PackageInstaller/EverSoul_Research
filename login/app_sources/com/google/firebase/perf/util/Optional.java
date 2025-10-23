package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class Optional<T> {
    private final T value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Optional() {
        this.value = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Optional(T t) {
        if (t == null) {
            throw new NullPointerException("value for optional is empty.");
        }
        this.value = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Optional<T> absent() {
        return new Optional<>();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <T> Optional<T> m443of(T t) {
        return new Optional<>(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Optional<T> fromNullable(T t) {
        return t == null ? absent() : m443of(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAvailable() {
        return this.value != null;
    }
}
