package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class ActionMode {
    private Object mTag;
    private boolean mTitleOptionalHint;

    public interface Callback {
        boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem);

        boolean onCreateActionMode(ActionMode actionMode, Menu menu);

        void onDestroyActionMode(ActionMode actionMode);

        boolean onPrepareActionMode(ActionMode actionMode, Menu menu);
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public abstract CharSequence getTitle();

    public abstract void invalidate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isTitleOptional() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charSequence);

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charSequence);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTag(Object obj) {
        this.mTag = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getTag() {
        return this.mTag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTitleOptionalHint(boolean z) {
        this.mTitleOptionalHint = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }
}
