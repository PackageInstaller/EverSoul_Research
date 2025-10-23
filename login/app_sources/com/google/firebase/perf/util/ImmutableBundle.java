package com.google.firebase.perf.util;

import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;

/* loaded from: classes2.dex */
public final class ImmutableBundle {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Bundle bundle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImmutableBundle() {
        this(new Bundle());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImmutableBundle(Bundle bundle) {
        this.bundle = (Bundle) bundle.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean containsKey(String str) {
        return str != null && this.bundle.containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Boolean> getBoolean(String str) {
        if (!containsKey(str)) {
            return Optional.absent();
        }
        try {
            return Optional.fromNullable((Boolean) this.bundle.get(str));
        } catch (ClassCastException e) {
            logger.debug("Metadata key %s contains type other than boolean: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Double> getDouble(String str) {
        if (!containsKey(str)) {
            return Optional.absent();
        }
        Object obj = this.bundle.get(str);
        if (obj == null) {
            return Optional.absent();
        }
        if (obj instanceof Float) {
            return Optional.m443of(Double.valueOf(((Float) obj).doubleValue()));
        }
        if (obj instanceof Double) {
            return Optional.m443of((Double) obj);
        }
        logger.debug("Metadata key %s contains type other than double: %s", str);
        return Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Long> getLong(String str) {
        if (getInt(str).isAvailable()) {
            return Optional.m443of(Long.valueOf(r3.get().intValue()));
        }
        return Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Optional<Integer> getInt(String str) {
        if (!containsKey(str)) {
            return Optional.absent();
        }
        try {
            return Optional.fromNullable((Integer) this.bundle.get(str));
        } catch (ClassCastException e) {
            logger.debug("Metadata key %s contains type other than int: %s", str, e.getMessage());
            return Optional.absent();
        }
    }
}
