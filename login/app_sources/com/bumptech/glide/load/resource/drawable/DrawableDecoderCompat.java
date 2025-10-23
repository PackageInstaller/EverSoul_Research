package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DrawableDecoderCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Drawable getDrawable(Context context, Context context2, int i) {
        return getDrawable(context, context2, i, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Drawable getDrawable(Context context, int i, Resources.Theme theme) {
        return getDrawable(context, context, i, theme);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Drawable getDrawable(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i, theme);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Drawable loadDrawableV7(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Drawable loadDrawableV4(Context context, int i, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }
}
