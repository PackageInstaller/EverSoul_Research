package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {
    final Context mContext;
    final ActionMode mWrappedObject;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.mContext = context;
        this.mWrappedObject = actionMode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public Object getTag() {
        return this.mWrappedObject.getTag();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.mWrappedObject.setTag(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.mWrappedObject.setSubtitle(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void invalidate() {
        this.mWrappedObject.invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void finish() {
        this.mWrappedObject.finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.mContext, (SupportMenu) this.mWrappedObject.getMenu());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.mWrappedObject.setTitle(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.mWrappedObject.setSubtitle(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.mWrappedObject.setCustomView(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.mWrappedObject.setTitleOptionalHint(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    public static class CallbackWrapper implements ActionMode.Callback {
        final Context mContext;
        final ActionMode.Callback mWrappedCallback;
        final ArrayList<SupportActionModeWrapper> mActionModes = new ArrayList<>();
        final SimpleArrayMap<Menu, Menu> mMenus = new SimpleArrayMap<>();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.mContext = context;
            this.mWrappedCallback = callback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.mContext, (SupportMenuItem) menuItem));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Menu getMenuWrapper(Menu menu) {
            Menu menu2 = this.mMenus.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.mContext, (SupportMenu) menu);
            this.mMenus.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.mActionModes.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.mActionModes.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
            this.mActionModes.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }
}
