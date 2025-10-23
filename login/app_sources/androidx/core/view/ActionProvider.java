package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasSubMenu() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onPerformDefaultAction() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean overridesItemVisibility() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ActionProvider(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Context getContext() {
        return this.mContext;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void refreshVisibility() {
        if (this.mVisibilityListener == null || !overridesItemVisibility()) {
            return;
        }
        this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subUiVisibilityChanged(boolean z) {
        SubUiVisibilityListener subUiVisibilityListener = this.mSubUiVisibilityListener;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.onSubUiVisibilityChanged(z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSubUiVisibilityListener(SubUiVisibilityListener subUiVisibilityListener) {
        this.mSubUiVisibilityListener = subUiVisibilityListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (this.mVisibilityListener != null && visibilityListener != null) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = visibilityListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }
}
