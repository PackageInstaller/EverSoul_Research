package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: androidx.recyclerview.widget.ListAdapter.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(List<T> list, List<T> list2) {
                ListAdapter.this.onCurrentListChanged(list, list2);
            }
        };
        this.mListener = listListener;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(listListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ListAdapter(AsyncDifferConfig<T> asyncDifferConfig) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: androidx.recyclerview.widget.ListAdapter.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(List<T> list, List<T> list2) {
                ListAdapter.this.onCurrentListChanged(list, list2);
            }
        };
        this.mListener = listListener;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(listListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void submitList(List<T> list) {
        this.mDiffer.submitList(list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void submitList(List<T> list, Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected T getItem(int i) {
        return this.mDiffer.getCurrentList().get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }
}
