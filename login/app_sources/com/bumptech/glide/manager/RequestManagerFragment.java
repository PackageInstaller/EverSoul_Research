package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.liapp.y;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {
    private static final String TAG = "RMFragment";
    private final Set<RequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private Fragment parentFragmentHint;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private RequestManagerFragment rootRequestManagerFragment;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new FragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = activityFragmentLifecycle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ActivityFragmentLifecycle getGlideLifecycle() {
        return this.lifecycle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void removeChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove(requestManagerFragment);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (equals(this.rootRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (this.rootRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment requestManagerFragment : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(requestManagerFragment.getParentFragment())) {
                hashSet.add(requestManagerFragment);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setParentFragmentHint(Fragment fragment) {
        this.parentFragmentHint = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        registerFragmentWithRoot(fragment.getActivity());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isDescendant(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void registerFragmentWithRoot(Activity activity) {
        unregisterFragmentWithRoot();
        RequestManagerFragment requestManagerFragment = Glide.get(activity).getRequestManagerRetriever().getRequestManagerFragment(activity);
        this.rootRequestManagerFragment = requestManagerFragment;
        if (equals(requestManagerFragment)) {
            return;
        }
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void unregisterFragmentWithRoot() {
        RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment != null) {
            requestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            registerFragmentWithRoot(activity);
        } catch (IllegalStateException e) {
            String str = y.٬ݯح׭٩(575938934);
            if (Log.isLoggable(str, 5)) {
                Log.w(str, y.ۮڭڭܬި(862162067), e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        unregisterFragmentWithRoot();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + y.٬ݯح׭٩(575939310) + getParentFragmentUsingHint() + y.ۮڭڭܬި(861939259);
    }

    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        FragmentRequestManagerTreeNode() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> descendantRequestManagerFragments = RequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                if (requestManagerFragment.getRequestManager() != null) {
                    hashSet.add(requestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return super.toString() + y.ݮڮֲڭܩ(-628895564) + RequestManagerFragment.this + y.ۮڭڭܬި(861939259);
        }
    }
}
