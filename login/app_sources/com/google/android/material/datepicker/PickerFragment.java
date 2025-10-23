package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
abstract class PickerFragment<S> extends Fragment {
    protected final LinkedHashSet<OnSelectionChangedListener<S>> onSelectionChangedListeners = new LinkedHashSet<>();

    abstract DateSelector<S> getDateSelector();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PickerFragment() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean removeOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.remove(onSelectionChangedListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }
}
