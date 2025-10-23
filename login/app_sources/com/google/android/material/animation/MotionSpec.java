package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class MotionSpec {
    private static final String TAG = "MotionSpec";
    private final SimpleArrayMap<String, MotionTiming> timings = new SimpleArrayMap<>();
    private final SimpleArrayMap<String, PropertyValuesHolder[]> propertyValues = new SimpleArrayMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasTiming(String str) {
        return this.timings.get(str) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionTiming getTiming(String str) {
        if (!hasTiming(str)) {
            throw new IllegalArgumentException();
        }
        return this.timings.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTiming(String str, MotionTiming motionTiming) {
        this.timings.put(str, motionTiming);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasPropertyValues(String str) {
        return this.propertyValues.get(str) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PropertyValuesHolder[] getPropertyValues(String str) {
        if (!hasPropertyValues(str)) {
            throw new IllegalArgumentException();
        }
        return clonePropertyValuesHolder(this.propertyValues.get(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPropertyValues(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.propertyValues.put(str, propertyValuesHolderArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PropertyValuesHolder[] clonePropertyValuesHolder(PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i = 0; i < propertyValuesHolderArr.length; i++) {
            propertyValuesHolderArr2[i] = propertyValuesHolderArr[i].clone();
        }
        return propertyValuesHolderArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> ObjectAnimator getAnimator(String str, T t, Property<T, ?> property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, getPropertyValues(str));
        ofPropertyValuesHolder.setProperty(property);
        getTiming(str).apply(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getTotalDuration() {
        int size = this.timings.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            MotionTiming valueAt = this.timings.valueAt(i);
            j = Math.max(j, valueAt.getDelay() + valueAt.getDuration());
        }
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MotionSpec createFromAttribute(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return createFromResource(context, resourceId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MotionSpec createFromResource(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return createSpecFromAnimators(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return createSpecFromAnimators(arrayList);
        } catch (Exception e) {
            Log.w(TAG, "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static MotionSpec createSpecFromAnimators(List<Animator> list) {
        MotionSpec motionSpec = new MotionSpec();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            addInfoFromAnimator(motionSpec, list.get(i));
        }
        return motionSpec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void addInfoFromAnimator(MotionSpec motionSpec, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            motionSpec.setPropertyValues(objectAnimator.getPropertyName(), objectAnimator.getValues());
            motionSpec.setTiming(objectAnimator.getPropertyName(), MotionTiming.createFromAnimator(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MotionSpec) {
            return this.timings.equals(((MotionSpec) obj).timings);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.timings.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return StringUtils.f1524LF + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
    }
}
