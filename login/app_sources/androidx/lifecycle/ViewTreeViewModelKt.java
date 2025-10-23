package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewTreeViewModel.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, m839d2 = {"findViewTreeViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroid/view/View;", "lifecycle-viewmodel_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
