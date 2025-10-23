package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void dispatchReallyStop() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void doLoaderDestroy() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void doLoaderRetain() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void doLoaderStart() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void reportLoaderStart() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Fragment findFragmentByWho(String str) {
        return this.mHost.mFragmentManager.findFragmentByWho(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Fragment> getActiveFragments(List<Fragment> list) {
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void attachHost(Fragment fragment) {
        FragmentManager fragmentManager = this.mHost.mFragmentManager;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        fragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(view, str, context, attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.mHost.mFragmentManager.restoreAllState(parcelable, new FragmentManagerNonConfig(list, null, null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mHost.mFragmentManager.restoreAllState(parcelable, fragmentManagerNonConfig);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void restoreSaveState(Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (!(fragmentHostCallback instanceof ViewModelStoreOwner)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        fragmentHostCallback.mFragmentManager.restoreSaveState(parcelable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig retainNonConfig = this.mHost.mFragmentManager.retainNonConfig();
        if (retainNonConfig == null || retainNonConfig.getFragments() == null) {
            return null;
        }
        return new ArrayList(retainNonConfig.getFragments());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchMultiWindowModeChanged(boolean z) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchConfigurationChanged(Configuration configuration) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dispatchOptionsMenuClosed(Menu menu) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }
}
