package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* loaded from: classes.dex */
public class AllCapsTransformationMethod implements TransformationMethod {
    private Locale mLocale;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AllCapsTransformationMethod(Context context) {
        this.mLocale = context.getResources().getConfiguration().locale;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.mLocale);
        }
        return null;
    }
}
