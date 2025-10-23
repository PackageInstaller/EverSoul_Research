package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* loaded from: classes.dex */
public interface MenuProvider {
    void onCreateMenu(Menu menu, MenuInflater menuInflater);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default void onMenuClosed(Menu menu) {
    }

    boolean onMenuItemSelected(MenuItem menuItem);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default void onPrepareMenu(Menu menu) {
    }
}
