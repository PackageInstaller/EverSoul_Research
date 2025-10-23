package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> mTransformers = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mTransformers.add(pageTransformer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mTransformers.remove(pageTransformer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        Iterator<ViewPager2.PageTransformer> it = this.mTransformers.iterator();
        while (it.hasNext()) {
            it.next().transformPage(view, f);
        }
    }
}
