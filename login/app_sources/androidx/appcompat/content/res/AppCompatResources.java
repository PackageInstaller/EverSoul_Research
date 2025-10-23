package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

/* loaded from: classes.dex */
public final class AppCompatResources {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AppCompatResources() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ColorStateList getColorStateList(Context context, int i) {
        return ContextCompat.getColorStateList(context, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Drawable getDrawable(Context context, int i) {
        return ResourceManagerInternal.get().getDrawable(context, i);
    }
}
