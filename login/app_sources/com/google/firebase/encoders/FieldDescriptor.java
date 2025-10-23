package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class FieldDescriptor {
    private final String name;
    private final Map<Class<?>, Object> properties;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.name = str;
        this.properties = map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T extends Annotation> T getProperty(Class<T> cls) {
        return (T) this.properties.get(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static FieldDescriptor m406of(String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder(String str) {
        return new Builder(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.name.equals(fieldDescriptor.name) && this.properties.equals(fieldDescriptor.properties);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.name.hashCode() * 31) + this.properties.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "FieldDescriptor{name=" + this.name + ", properties=" + this.properties.values() + "}";
    }

    public static final class Builder {
        private final String name;
        private Map<Class<?>, Object> properties = null;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder(String str) {
            this.name = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public <T extends Annotation> Builder withProperty(T t) {
            if (this.properties == null) {
                this.properties = new HashMap();
            }
            this.properties.put(t.annotationType(), t);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FieldDescriptor build() {
            Map unmodifiableMap;
            String str = this.name;
            if (this.properties == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(new HashMap(this.properties));
            }
            return new FieldDescriptor(str, unmodifiableMap);
        }
    }
}
