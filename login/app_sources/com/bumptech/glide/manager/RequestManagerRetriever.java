package com.bumptech.glide.manager;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = new RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        public RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    private static final String FRAGMENT_INDEX_KEY = "key";
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final Handler handler;
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments = new HashMap();
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap();
    private final ArrayMap<View, Fragment> tempViewToSupportFragment = new ArrayMap<>();
    private final ArrayMap<View, android.app.Fragment> tempViewToFragment = new ArrayMap<>();
    private final Bundle tempBundle = new Bundle();

    public interface RequestManagerFactory {
        RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        this.factory = requestManagerFactory == null ? DEFAULT_FACTORY : requestManagerFactory;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private RequestManager getApplicationManager(Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = this.factory.build(Glide.get(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.applicationManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManager get(Context context) {
        if (context == null) {
            throw new IllegalArgumentException(y.ۮڭڭܬި(862161563));
        }
        if (Util.isOnMainThread() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return get((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return get((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return get(contextWrapper.getBaseContext());
                }
            }
        }
        return getApplicationManager(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManager get(FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        return supportFragmentGet(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, isActivityVisible(fragmentActivity));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManager get(Fragment fragment) {
        Preconditions.checkNotNull(fragment.getContext(), y.ٲٴݴ״ٰ(1781719064));
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        return supportFragmentGet(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManager get(Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        assertNotDestroyed(activity);
        return fragmentGet(activity, activity.getFragmentManager(), null, isActivityVisible(activity));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManager get(View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), y.ٲٴݴ״ٰ(1781719568));
        Activity findActivity = findActivity(view.getContext());
        if (findActivity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (findActivity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) findActivity;
            Fragment findSupportFragment = findSupportFragment(view, fragmentActivity);
            return findSupportFragment != null ? get(findSupportFragment) : get(fragmentActivity);
        }
        android.app.Fragment findFragment = findFragment(view, findActivity);
        if (findFragment == null) {
            return get(findActivity);
        }
        return get(findFragment);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void findAllSupportFragmentsWithViews(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Fragment findSupportFragment(View view, FragmentActivity fragmentActivity) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
        View findViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToSupportFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return fragment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    private android.app.Fragment findFragment(View view, Activity activity) {
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(activity.getFragmentManager(), this.tempViewToFragment);
        View findViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToFragment.clear();
        return fragment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    private void findAllFragmentsWithViews(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        findAllFragmentsWithViewsPreO(fragmentManager, arrayMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    private void findAllFragmentsWithViewsPreO(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        android.app.Fragment fragment;
        int i = 0;
        while (true) {
            Bundle bundle = this.tempBundle;
            int i2 = i + 1;
            String str = y.٬ݯح׭٩(575939726);
            bundle.putInt(str, i);
            try {
                fragment = fragmentManager.getFragment(this.tempBundle, str);
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
            }
            i = i2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void assertNotDestroyed(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1393026930));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public RequestManager get(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException(y.ۮڭڭܬި(862161139));
        }
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        }
        return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    RequestManagerFragment getRequestManagerFragment(Activity activity) {
        return getRequestManagerFragment(activity.getFragmentManager(), null, isActivityVisible(activity));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private RequestManagerFragment getRequestManagerFragment(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        String str = y.ݬֲ֮ܲت(1513016191);
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestManagerFragment == null && (requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.setParentFragmentHint(fragment);
            if (z) {
                requestManagerFragment.getGlideLifecycle().onStart();
            }
            this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, str).commitAllowingStateLoss();
            this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    private RequestManager fragmentGet(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager, fragment, z);
        RequestManager requestManager = requestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager build = this.factory.build(Glide.get(context), requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
        requestManagerFragment.setRequestManager(build);
        return build;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SupportRequestManagerFragment getSupportRequestManagerFragment(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return getSupportRequestManagerFragment(fragmentManager, null, isActivityVisible(context));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isActivityVisible(Context context) {
        Activity findActivity = findActivity(context);
        return findActivity == null || !findActivity.isFinishing();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SupportRequestManagerFragment getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        String str = y.ݬֲ֮ܲت(1513016191);
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.setParentFragmentHint(fragment);
            if (z) {
                supportRequestManagerFragment.getGlideLifecycle().onStart();
            }
            this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, str).commitAllowingStateLoss();
            this.handler.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private RequestManager supportFragmentGet(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = getSupportRequestManagerFragment(fragmentManager, fragment, z);
        RequestManager requestManager = supportRequestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager build = this.factory.build(Glide.get(context), supportRequestManagerFragment.getGlideLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode(), context);
        supportRequestManagerFragment.setRequestManager(build);
        return build;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r6) {
        /*
            r5 = this;
            int r0 = r6.what
            r1 = 1
            if (r0 == r1) goto L17
            r2 = 2
            if (r0 == r2) goto Lc
            r6 = 0
            r1 = 0
            r0 = r6
            goto L24
        Lc:
            java.lang.Object r6 = r6.obj
            androidx.fragment.app.FragmentManager r6 = (androidx.fragment.app.FragmentManager) r6
            java.util.Map<androidx.fragment.app.FragmentManager, com.bumptech.glide.manager.SupportRequestManagerFragment> r0 = r5.pendingSupportRequestManagerFragments
            java.lang.Object r0 = r0.remove(r6)
            goto L21
        L17:
            java.lang.Object r6 = r6.obj
            android.app.FragmentManager r6 = (android.app.FragmentManager) r6
            java.util.Map<android.app.FragmentManager, com.bumptech.glide.manager.RequestManagerFragment> r0 = r5.pendingRequestManagerFragments
            java.lang.Object r0 = r0.remove(r6)
        L21:
            r4 = r0
            r0 = r6
            r6 = r4
        L24:
            if (r1 == 0) goto L4d
            if (r6 != 0) goto L4d
            r6 = 5
            r2 = 2051996621(0x7a4efbcd, float:2.6868007E35)
            java.lang.String r2 = com.liapp.y.دײܮڳܯ(r2)
            boolean r6 = android.util.Log.isLoggable(r2, r6)
            if (r6 == 0) goto L4d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r3 = -1159223527(0xffffffffbae7a719, float:-0.00176737)
            java.lang.String r3 = com.liapp.y.֬ڱܱײٮ(r3)
            r6.<init>(r3)
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r2, r6)
        L4d:
            return r1
            fill-array 0x004e: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.RequestManagerRetriever.handleMessage(android.os.Message):boolean");
    }
}
