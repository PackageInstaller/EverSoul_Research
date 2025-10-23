package androidx.activity;

import androidx.core.util.Consumer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables = new CopyOnWriteArrayList<>();
    private boolean mEnabled;
    private Consumer<Boolean> mEnabledConsumer;

    public abstract void handleOnBackPressed();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OnBackPressedCallback(boolean z) {
        this.mEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setEnabled(boolean z) {
        this.mEnabled = z;
        Consumer<Boolean> consumer = this.mEnabledConsumer;
        if (consumer != null) {
            consumer.accept(Boolean.valueOf(z));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isEnabled() {
        return this.mEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void remove() {
        Iterator<Cancellable> it = this.mCancellables.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void addCancellable(Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void removeCancellable(Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setIsEnabledConsumer(Consumer<Boolean> consumer) {
        this.mEnabledConsumer = consumer;
    }
}
