package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.liapp.y;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {
    private static final String TAG = "SupportRMFragment";
    private final Set<SupportRequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private Fragment parentFragmentHint;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private SupportRequestManagerFragment rootRequestManagerFragment;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode();
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
    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(supportRequestManagerFragment2.getParentFragmentUsingHint())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setParentFragmentHint(Fragment fragment) {
        FragmentManager rootFragmentManager;
        this.parentFragmentHint = fragment;
        if (fragment == null || fragment.getContext() == null || (rootFragmentManager = getRootFragmentManager(fragment)) == null) {
            return;
        }
        registerFragmentWithRoot(fragment.getContext(), rootFragmentManager);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static FragmentManager getRootFragmentManager(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isDescendant(Fragment fragment) {
        Fragment parentFragmentUsingHint = getParentFragmentUsingHint();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(parentFragmentUsingHint)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void registerFragmentWithRoot(Context context, FragmentManager fragmentManager) {
        unregisterFragmentWithRoot();
        SupportRequestManagerFragment supportRequestManagerFragment = Glide.get(context).getRequestManagerRetriever().getSupportRequestManagerFragment(context, fragmentManager);
        this.rootRequestManagerFragment = supportRequestManagerFragment;
        if (equals(supportRequestManagerFragment)) {
            return;
        }
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager rootFragmentManager = getRootFragmentManager(this);
        String str = y.٬ݯح׭٩(575943294);
        if (rootFragmentManager == null) {
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                registerFragmentWithRoot(getContext(), rootFragmentManager);
            } catch (IllegalStateException e) {
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, y.ۮڭڭܬި(862162067), e);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.parentFragmentHint = null;
        unregisterFragmentWithRoot();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + y.٬ݯح׭٩(575939310) + getParentFragmentUsingHint() + y.ۮڭڭܬި(861939259);
    }

    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SupportFragmentRequestManagerTreeNode() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> descendantRequestManagerFragments = SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return super.toString() + y.ݮڮֲڭܩ(-628895564) + SupportRequestManagerFragment.this + y.ۮڭڭܬި(861939259);
        }
    }
}
