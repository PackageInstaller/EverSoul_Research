package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EncoderRegistry {
    private final List<Entry<?>> encoders = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <T> Encoder<T> getEncoder(Class<T> cls) {
        for (Entry<?> entry : this.encoders) {
            if (entry.handles(cls)) {
                return (Encoder<T>) entry.encoder;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <T> void append(Class<T> cls, Encoder<T> encoder) {
        this.encoders.add(new Entry<>(cls, encoder));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <T> void prepend(Class<T> cls, Encoder<T> encoder) {
        this.encoders.add(0, new Entry<>(cls, encoder));
    }

    private static final class Entry<T> {
        private final Class<T> dataClass;
        final Encoder<T> encoder;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Entry(Class<T> cls, Encoder<T> encoder) {
            this.dataClass = cls;
            this.encoder = encoder;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean handles(Class<?> cls) {
            return this.dataClass.isAssignableFrom(cls);
        }
    }
}
