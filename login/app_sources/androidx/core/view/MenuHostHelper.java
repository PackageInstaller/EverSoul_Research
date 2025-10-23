package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MenuHostHelper {
    private final Runnable mOnInvalidateMenuCallback;
    private final CopyOnWriteArrayList<MenuProvider> mMenuProviders = new CopyOnWriteArrayList<>();
    private final Map<MenuProvider, LifecycleContainer> mProviderToLifecycleContainers = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MenuHostHelper(Runnable runnable) {
        this.mOnInvalidateMenuCallback = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onPrepareMenu(Menu menu) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onPrepareMenu(menu);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onCreateMenu(menu, menuInflater);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onMenuItemSelected(MenuItem menuItem) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            if (it.next().onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onMenuClosed(Menu menu) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onMenuClosed(menu);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addMenuProvider(MenuProvider menuProvider) {
        this.mMenuProviders.add(menuProvider);
        this.mOnInvalidateMenuCallback.run();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addMenuProvider(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        addMenuProvider(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.clearObservers();
        }
        this.mProviderToLifecycleContainers.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper.this.m918lambda$addMenuProvider$0$androidxcoreviewMenuHostHelper(menuProvider, lifecycleOwner2, event);
            }
        }));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$addMenuProvider$0$androidx-core-view-MenuHostHelper, reason: not valid java name */
    /* synthetic */ void m918lambda$addMenuProvider$0$androidxcoreviewMenuHostHelper(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addMenuProvider(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.clearObservers();
        }
        this.mProviderToLifecycleContainers.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper.this.m919lambda$addMenuProvider$1$androidxcoreviewMenuHostHelper(state, menuProvider, lifecycleOwner2, event);
            }
        }));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$addMenuProvider$1$androidx-core-view-MenuHostHelper, reason: not valid java name */
    /* synthetic */ void m919lambda$addMenuProvider$1$androidxcoreviewMenuHostHelper(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            addMenuProvider(menuProvider);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.mMenuProviders.remove(menuProvider);
            this.mOnInvalidateMenuCallback.run();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuProviders.remove(menuProvider);
        LifecycleContainer remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.clearObservers();
        }
        this.mOnInvalidateMenuCallback.run();
    }

    private static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private LifecycleEventObserver mObserver;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle = lifecycle;
            this.mObserver = lifecycleEventObserver;
            lifecycle.addObserver(lifecycleEventObserver);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }
    }
}
