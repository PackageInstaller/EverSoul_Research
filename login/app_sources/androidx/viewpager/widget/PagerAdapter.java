package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final DataSetObservable mObservable = new DataSetObservable();
    private DataSetObserver mViewPagerObserver;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void finishUpdate(View view) {
    }

    public abstract int getCount();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getItemPosition(Object obj) {
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getPageTitle(int i) {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getPageWidth(int i) {
        return 1.0f;
    }

    public abstract boolean isViewFromObject(View view, Object obj);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Parcelable saveState() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setPrimaryItem(View view, int i, Object obj) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void startUpdate(View view) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startUpdate(ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return instantiateItem((View) viewGroup, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        destroyItem((View) viewGroup, i, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        setPrimaryItem((View) viewGroup, i, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void finishUpdate(ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Object instantiateItem(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void destroyItem(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void notifyDataSetChanged() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.mViewPagerObserver;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.mObservable.notifyChanged();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setViewPagerObserver(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
        }
    }
}
