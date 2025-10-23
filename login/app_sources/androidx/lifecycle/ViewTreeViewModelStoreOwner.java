package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.C0492R;

/* loaded from: classes.dex */
public class ViewTreeViewModelStoreOwner {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ViewTreeViewModelStoreOwner() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(C0492R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ViewModelStoreOwner get(View view) {
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) view.getTag(C0492R.id.view_tree_view_model_store_owner);
        if (viewModelStoreOwner != null) {
            return viewModelStoreOwner;
        }
        Object parent = view.getParent();
        while (viewModelStoreOwner == null && (parent instanceof View)) {
            View view2 = (View) parent;
            viewModelStoreOwner = (ViewModelStoreOwner) view2.getTag(C0492R.id.view_tree_view_model_store_owner);
            parent = view2.getParent();
        }
        return viewModelStoreOwner;
    }
}
