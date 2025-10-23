package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public abstract float getValue(T t);

    public abstract void setValue(T t, float f);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> floatProperty) {
        return new FloatPropertyCompat<T>(floatProperty.getName()) { // from class: androidx.dynamicanimation.animation.FloatPropertyCompat.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(T t) {
                return ((Float) floatProperty.get(t)).floatValue();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(T t, float f) {
                floatProperty.setValue(t, f);
            }
        };
    }
}
