package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class ViewModelStore {
    private final HashMap<String, ViewModel> mMap = new HashMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void put(String str, ViewModel viewModel) {
        ViewModel put = this.mMap.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final ViewModel get(String str) {
        return this.mMap.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Set<String> keys() {
        return new HashSet(this.mMap.keySet());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void clear() {
        Iterator<ViewModel> it = this.mMap.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.mMap.clear();
    }
}
