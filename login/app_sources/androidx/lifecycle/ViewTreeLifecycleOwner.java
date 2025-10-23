package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.C0491R;

/* loaded from: classes.dex */
public class ViewTreeLifecycleOwner {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ViewTreeLifecycleOwner() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void set(View view, LifecycleOwner lifecycleOwner) {
        view.setTag(C0491R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LifecycleOwner get(View view) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) view.getTag(C0491R.id.view_tree_lifecycle_owner);
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Object parent = view.getParent();
        while (lifecycleOwner == null && (parent instanceof View)) {
            View view2 = (View) parent;
            lifecycleOwner = (LifecycleOwner) view2.getTag(C0491R.id.view_tree_lifecycle_owner);
            parent = view2.getParent();
        }
        return lifecycleOwner;
    }
}
