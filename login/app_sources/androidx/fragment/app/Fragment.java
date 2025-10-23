package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.facebook.internal.security.CertificateUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho;

    interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDestroyOptionsMenu() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onHiddenChanged(boolean z) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onMultiWindowModeChanged(boolean z) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onOptionsMenuClosed(Menu menu) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onPictureInPictureModeChanged(boolean z) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onPrepareOptionsMenu(Menu menu) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onViewCreated(View view, Bundle bundle) {
    }

    private static abstract class OnPreAttachedListener {
        abstract void onPreAttached();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private OnPreAttachedListener() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
        if (fragmentViewLifecycleOwner != null) {
            return fragmentViewLifecycleOwner;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        return this.mFragmentManager.getViewModelStore(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int getMinimumMaxLifecycleState() {
        if (this.mMaxState == Lifecycle.State.INITIALIZED || this.mParentFragment == null) {
            return this.mMaxState.ordinal();
        }
        return Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.fragment.app.Fragment.SavedState.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final Bundle mState;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SavedState(Bundle bundle) {
            this.mState = bundle;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.mState = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.mState);
        }
    }

    public static class InstantiationException extends RuntimeException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new Runnable() { // from class: androidx.fragment.app.Fragment.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                Fragment.this.startPostponedEnterTransition();
            }
        };
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        initLifecycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Fragment(int i) {
        this();
        this.mContentLayoutId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.setArguments(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (java.lang.InstantiationException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return super.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getId() {
        return this.mFragmentId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTag() {
        return this.mTag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle getArguments() {
        return this.mArguments;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.isStateSaved();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInitialSavedState(SavedState savedState) {
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        this.mSavedFragmentState = (savedState == null || savedState.mState == null) ? null : savedState.mState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setTargetFragment(Fragment fragment, int i) {
        FragmentManager fragmentManager = this.mFragmentManager;
        FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
            if (fragment2.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && fragment.mFragmentManager != null) {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = fragment;
        }
        this.mTargetRequestCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.findActiveFragment(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Context getContext() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.getContext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.getActivity();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object getHost() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.onGetHost();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Resources getResources() {
        return requireContext().getResources();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getString(int i) {
        return getResources().getString(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.mChildFragmentManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isDetached() {
        return this.mDetached;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isRemoving() {
        return this.mRemoving;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isInLayout() {
        return this.mInLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isResumed() {
        return this.mState >= 7;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isHidden() {
        return this.mHidden;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isMenuVisible() {
        FragmentManager fragmentManager;
        return this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.isParentMenuVisible(this.mParentFragment));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            fragmentManager.addRetainedFragment(this);
        } else {
            fragmentManager.removeRetainedFragment(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.onSupportInvalidateOptionsMenu();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.performPendingDeferredStart(fragmentManager.createOrGetFragmentStateManager(this));
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 5 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startActivity(Intent intent, Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        fragmentHostCallback.onStartActivityFromFragment(this, intent, -1, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        getParentFragmentManager().launchStartActivityForResult(this, intent, i, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        getParentFragmentManager().launchStartIntentSenderForResult(this, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        getParentFragmentManager().launchRequestPermissions(this, strArr, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldShowRequestPermissionRationale(String str) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            return fragmentHostCallback.onShouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater onGetLayoutInflater = fragmentHostCallback.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(onGetLayoutInflater, this.mChildFragmentManager.getLayoutInflaterFactory());
        return onGetLayoutInflater;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onAttach(Context context) {
        this.mCalled = true;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.isStateAtLeast(1)) {
            return;
        }
        this.mChildFragmentManager.dispatchCreate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.restoreSaveState(parcelable);
        this.mChildFragmentManager.dispatchCreate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public View getView() {
        return this.mView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onStart() {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onResume() {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onPause() {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onStop() {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDestroyView() {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDestroy() {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDetach() {
        this.mCalled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().mEnterTransitionCallback = sharedElementCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().mExitTransitionCallback = sharedElementCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().mEnterTransition = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mEnterTransition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().mReturnTransition = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getReturnTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mReturnTransition == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mAnimationInfo.mReturnTransition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setExitTransition(Object obj) {
        ensureAnimationInfo().mExitTransition = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getExitTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mExitTransition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().mReenterTransition = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getReenterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mReenterTransition == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mAnimationInfo.mReenterTransition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().mSharedElementEnterTransition = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getSharedElementEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mSharedElementEnterTransition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().mSharedElementReturnTransition = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getSharedElementReturnTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        if (animationInfo.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION) {
            return getSharedElementEnterTransition();
        }
        return this.mAnimationInfo.mSharedElementReturnTransition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || animationInfo.mAllowEnterTransitionOverlap == null) {
            return true;
        }
        return this.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || animationInfo.mAllowReturnTransitionOverlap == null) {
            return true;
        }
        return this.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            handler = fragmentManager.getHost().getHandler();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !ensureAnimationInfo().mEnterTransitionPostponed) {
            return;
        }
        if (this.mHost == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = false;
        } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            this.mHost.getHandler().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.Fragment.2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    Fragment.this.callStartTransitionListener(false);
                }
            });
        } else {
            callStartTransitionListener(true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        AnimationInfo animationInfo = this.mAnimationInfo;
        OnStartEnterTransitionListener onStartEnterTransitionListener = null;
        if (animationInfo != null) {
            animationInfo.mEnterTransitionPostponed = false;
            OnStartEnterTransitionListener onStartEnterTransitionListener2 = this.mAnimationInfo.mStartEnterTransitionListener;
            this.mAnimationInfo.mStartEnterTransitionListener = null;
            onStartEnterTransitionListener = onStartEnterTransitionListener2;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.onStartEnterTransition();
            return;
        }
        if (!FragmentManager.USE_STATE_MANAGER || this.mView == null || (viewGroup = this.mContainer) == null || (fragmentManager = this.mFragmentManager) == null) {
            return;
        }
        final SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(viewGroup, fragmentManager);
        orCreateController.markPostponedState();
        if (z) {
            this.mHost.getHandler().post(new Runnable() { // from class: androidx.fragment.app.Fragment.3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    orCreateController.executePendingOperations();
                }
            });
        } else {
            orCreateController.executePendingOperations();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + CertificateUtil.DELIMITER);
        this.mChildFragmentManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.findFragmentByWho(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FragmentContainer createFragmentContainer() {
        return new FragmentContainer() { // from class: androidx.fragment.app.Fragment.4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.fragment.app.FragmentContainer
            public View onFindViewById(int i) {
                if (Fragment.this.mView == null) {
                    throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
                }
                return Fragment.this.mView.findViewById(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.fragment.app.FragmentContainer
            public boolean onHasView() {
                return Fragment.this.mView != null;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performAttach() {
        Iterator<OnPreAttachedListener> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onPreAttached();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
        this.mFragmentManager.dispatchOnAttachFragment(this);
        this.mChildFragmentManager.dispatchAttach();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performCreate(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment.5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event != Lifecycle.Event.ON_STOP || Fragment.this.mView == null) {
                    return;
                }
                Fragment.this.mView.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.performRestore(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.initialize();
            ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
            ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
            ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
            return;
        }
        if (this.mViewLifecycleOwner.isInitialized()) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
        this.mViewLifecycleOwner = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        restoreViewState();
        this.mChildFragmentManager.dispatchActivityCreated();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }
        this.mChildFragmentManager.dispatchStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        }
        this.mChildFragmentManager.dispatchResume();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performPrimaryNavigationFragmentChanged() {
        boolean isPrimaryNavigation = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != isPrimaryNavigation) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(isPrimaryNavigation);
            onPrimaryNavigationFragmentChanged(isPrimaryNavigation);
            this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.dispatchConfigurationChanged(configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return z | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return z | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        Parcelable saveAllState = this.mChildFragmentManager.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        LoaderManager.getInstance(this).markForRedelivery();
        this.mPerformedCreateView = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (this.mChildFragmentManager.isDestroyed()) {
            return;
        }
        this.mChildFragmentManager.dispatchDestroy();
        this.mChildFragmentManager = new FragmentManagerImpl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setOnStartEnterTransitionListener(OnStartEnterTransitionListener onStartEnterTransitionListener) {
        ensureAnimationInfo();
        if (onStartEnterTransitionListener == this.mAnimationInfo.mStartEnterTransitionListener) {
            return;
        }
        if (onStartEnterTransitionListener != null && this.mAnimationInfo.mStartEnterTransitionListener != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (this.mAnimationInfo.mEnterTransitionPostponed) {
            this.mAnimationInfo.mStartEnterTransitionListener = onStartEnterTransitionListener;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.startListening();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new AnimationInfo();
        }
        return this.mAnimationInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        ensureAnimationInfo().mEnterAnim = i;
        ensureAnimationInfo().mExitAnim = i2;
        ensureAnimationInfo().mPopEnterAnim = i3;
        ensureAnimationInfo().mPopExitAnim = i4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getEnterAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mEnterAnim;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getExitAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mExitAnim;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getPopEnterAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mPopEnterAnim;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getPopExitAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mPopExitAnim;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean getPopDirection() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mIsPop;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        ensureAnimationInfo().mIsPop = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getNextTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mNextTransition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || animationInfo.mSharedElementSourceNames == null) {
            return new ArrayList<>();
        }
        return this.mAnimationInfo.mSharedElementSourceNames;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || animationInfo.mSharedElementTargetNames == null) {
            return new ArrayList<>();
        }
        return this.mAnimationInfo.mSharedElementTargetNames;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        this.mAnimationInfo.mSharedElementSourceNames = arrayList;
        this.mAnimationInfo.mSharedElementTargetNames = arrayList2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mEnterTransitionCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SharedElementCallback getExitTransitionCallback() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mExitTransitionCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    View getAnimatingAway() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mAnimatingAway;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setAnimatingAway(View view) {
        ensureAnimationInfo().mAnimatingAway = view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setAnimator(Animator animator) {
        ensureAnimationInfo().mAnimator = animator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Animator getAnimator() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mAnimator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setPostOnViewCreatedAlpha(float f) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float getPostOnViewCreatedAlpha() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 1.0f;
        }
        return animationInfo.mPostOnViewCreatedAlpha;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setFocusedView(View view) {
        ensureAnimationInfo().mFocusedView = view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    View getFocusedView() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mFocusedView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isPostponed() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mEnterTransitionPostponed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isHideReplaced() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mIsHideReplaced;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setHideReplaced(boolean z) {
        ensureAnimationInfo().mIsHideReplaced = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return prepareCallInternal(activityResultContract, new Function<Void, ActivityResultRegistry>() { // from class: androidx.fragment.app.Fragment.6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.arch.core.util.Function
            public ActivityResultRegistry apply(Void r1) {
                if (Fragment.this.mHost instanceof ActivityResultRegistryOwner) {
                    return ((ActivityResultRegistryOwner) Fragment.this.mHost).getActivityResultRegistry();
                }
                return Fragment.this.requireActivity().getActivityResultRegistry();
            }
        }, activityResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, final ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        return prepareCallInternal(activityResultContract, new Function<Void, ActivityResultRegistry>() { // from class: androidx.fragment.app.Fragment.7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.arch.core.util.Function
            public ActivityResultRegistry apply(Void r1) {
                return activityResultRegistry;
            }
        }, activityResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <I, O> ActivityResultLauncher<I> prepareCallInternal(final ActivityResultContract<I, O> activityResultContract, final Function<Void, ActivityResultRegistry> function, final ActivityResultCallback<O> activityResultCallback) {
        if (this.mState > 1) {
            throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        }
        final AtomicReference atomicReference = new AtomicReference();
        registerOnPreAttachListener(new OnPreAttachedListener() { // from class: androidx.fragment.app.Fragment.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
            void onPreAttached() {
                String generateActivityResultKey = Fragment.this.generateActivityResultKey();
                atomicReference.set(((ActivityResultRegistry) function.apply(null)).register(generateActivityResultKey, Fragment.this, activityResultContract, activityResultCallback));
            }
        });
        return new ActivityResultLauncher<I>() { // from class: androidx.fragment.app.Fragment.9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
                ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.get();
                if (activityResultLauncher == null) {
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }
                activityResultLauncher.launch(i, activityOptionsCompat);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.getAndSet(null);
                if (activityResultLauncher != null) {
                    activityResultLauncher.unregister();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.activity.result.ActivityResultLauncher
            public ActivityResultContract<I, ?> getContract() {
                return activityResultContract;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void registerOnPreAttachListener(OnPreAttachedListener onPreAttachedListener) {
        if (this.mState >= 0) {
            onPreAttachedListener.onPreAttached();
        } else {
            this.mOnPreAttachedListeners.add(onPreAttachedListener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        Animator mAnimator;
        int mEnterAnim;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        boolean mIsHideReplaced;
        boolean mIsPop;
        int mNextTransition;
        int mPopEnterAnim;
        int mPopExitAnim;
        ArrayList<String> mSharedElementSourceNames;
        ArrayList<String> mSharedElementTargetNames;
        OnStartEnterTransitionListener mStartEnterTransitionListener;
        Object mEnterTransition = null;
        Object mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
        Object mExitTransition = null;
        Object mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
        Object mSharedElementEnterTransition = null;
        Object mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
        SharedElementCallback mEnterTransitionCallback = null;
        SharedElementCallback mExitTransitionCallback = null;
        float mPostOnViewCreatedAlpha = 1.0f;
        View mFocusedView = null;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        AnimationInfo() {
        }
    }
}
