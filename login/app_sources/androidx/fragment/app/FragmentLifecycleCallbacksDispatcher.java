package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
class FragmentLifecycleCallbacksDispatcher {
    private final FragmentManager mFragmentManager;
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks = new CopyOnWriteArrayList<>();

    private static final class FragmentLifecycleCallbacksHolder {
        final FragmentManager.FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.mCallback = fragmentLifecycleCallbacks;
            this.mRecursive = z;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.mLifecycleCallbacks) {
            int size = this.mLifecycleCallbacks.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (this.mLifecycleCallbacks.get(i).mCallback == fragmentLifecycleCallbacks) {
                    this.mLifecycleCallbacks.remove(i);
                    break;
                }
                i++;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentPreAttached(Fragment fragment, boolean z) {
        Context context = this.mFragmentManager.getHost().getContext();
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentPreAttached(this.mFragmentManager, fragment, context);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentAttached(Fragment fragment, boolean z) {
        Context context = this.mFragmentManager.getHost().getContext();
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentAttached(this.mFragmentManager, fragment, context);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentPreCreated(this.mFragmentManager, fragment, bundle);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentCreated(this.mFragmentManager, fragment, bundle);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentActivityCreated(this.mFragmentManager, fragment, bundle);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(fragment, view, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentViewCreated(this.mFragmentManager, fragment, view, bundle);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentStarted(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentStarted(this.mFragmentManager, fragment);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentResumed(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentResumed(this.mFragmentManager, fragment);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentPaused(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentPaused(this.mFragmentManager, fragment);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentStopped(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentStopped(this.mFragmentManager, fragment);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentSaveInstanceState(this.mFragmentManager, fragment, bundle);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentViewDestroyed(this.mFragmentManager, fragment);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentDestroyed(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentDestroyed(this.mFragmentManager, fragment);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void dispatchOnFragmentDetached(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.mRecursive) {
                next.mCallback.onFragmentDetached(this.mFragmentManager, fragment);
            }
        }
    }
}
