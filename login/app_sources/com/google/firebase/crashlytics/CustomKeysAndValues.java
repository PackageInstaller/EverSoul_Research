package com.google.firebase.crashlytics;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class CustomKeysAndValues {
    final Map<String, String> keysAndValues;

    public static class Builder {
        private Map<String, String> keysAndValues = new HashMap();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putString(String str, String str2) {
            this.keysAndValues.put(str, str2);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putBoolean(String str, boolean z) {
            this.keysAndValues.put(str, Boolean.toString(z));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putDouble(String str, double d) {
            this.keysAndValues.put(str, Double.toString(d));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putFloat(String str, float f) {
            this.keysAndValues.put(str, Float.toString(f));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putLong(String str, long j) {
            this.keysAndValues.put(str, Long.toString(j));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder putInt(String str, int i) {
            this.keysAndValues.put(str, Integer.toString(i));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CustomKeysAndValues build() {
            return new CustomKeysAndValues(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CustomKeysAndValues(Builder builder) {
        this.keysAndValues = builder.keysAndValues;
    }
}
