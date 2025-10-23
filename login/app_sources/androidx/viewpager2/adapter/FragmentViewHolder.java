package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FragmentViewHolder(FrameLayout frameLayout) {
        super(frameLayout);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static FragmentViewHolder create(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(ViewCompat.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new FragmentViewHolder(frameLayout);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}
