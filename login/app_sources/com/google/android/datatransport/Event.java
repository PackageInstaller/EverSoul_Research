package com.google.android.datatransport;

/* loaded from: classes.dex */
public abstract class Event<T> {
    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public abstract ProductData getProductData();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofData(int i, T t, ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i), t, Priority.DEFAULT, productData);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofData(int i, T t) {
        return new AutoValue_Event(Integer.valueOf(i), t, Priority.DEFAULT, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofData(T t, ProductData productData) {
        return new AutoValue_Event(null, t, Priority.DEFAULT, productData);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofData(T t) {
        return new AutoValue_Event(null, t, Priority.DEFAULT, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofTelemetry(int i, T t, ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i), t, Priority.VERY_LOW, productData);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofTelemetry(int i, T t) {
        return new AutoValue_Event(Integer.valueOf(i), t, Priority.VERY_LOW, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofTelemetry(T t, ProductData productData) {
        return new AutoValue_Event(null, t, Priority.VERY_LOW, productData);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofTelemetry(T t) {
        return new AutoValue_Event(null, t, Priority.VERY_LOW, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofUrgent(int i, T t, ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i), t, Priority.HIGHEST, productData);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofUrgent(int i, T t) {
        return new AutoValue_Event(Integer.valueOf(i), t, Priority.HIGHEST, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofUrgent(T t, ProductData productData) {
        return new AutoValue_Event(null, t, Priority.HIGHEST, productData);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Event<T> ofUrgent(T t) {
        return new AutoValue_Event(null, t, Priority.HIGHEST, null);
    }
}
