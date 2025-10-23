package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme theme);

    public static final class Helper {
        private final Context mContext;
        private LayoutInflater mDropDownInflater;
        private final LayoutInflater mInflater;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Helper(Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setDropDownViewTheme(Resources.Theme theme) {
            if (theme == null) {
                this.mDropDownInflater = null;
            } else if (theme.equals(this.mContext.getTheme())) {
                this.mDropDownInflater = this.mInflater;
            } else {
                this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, theme));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater layoutInflater = this.mDropDownInflater;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater layoutInflater = this.mDropDownInflater;
            return layoutInflater != null ? layoutInflater : this.mInflater;
        }
    }
}
