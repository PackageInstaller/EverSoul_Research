package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompat";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TextViewCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Field retrieveField(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException unused) {
            Log.e(LOG_TAG, "Could not retrieve " + str + " field.");
            return field;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int retrieveIntFromField(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.d(LOG_TAG, "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Api17Impl.setCompoundDrawablesRelative(textView, drawable, drawable2, drawable3, drawable4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable, drawable2, drawable3, drawable4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, i, i2, i3, i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getMaxLines(TextView textView) {
        return Api16Impl.getMaxLines(textView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getMinLines(TextView textView) {
        return Api16Impl.getMinLines(textView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setTextAppearance(TextView textView, int i) {
        textView.setTextAppearance(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        return Api17Impl.getCompoundDrawablesRelative(textView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setAutoSizeTextTypeWithDefaults(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeWithDefaults(textView, i);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(textView, i, i2, i3, i4);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(textView, iArr, i);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getAutoSizeTextType(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeTextType(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeTextType();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getAutoSizeStepGranularity(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeStepGranularity(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeStepGranularity();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getAutoSizeMinTextSize(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeMinTextSize(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeMinTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getAutoSizeMaxTextSize(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeMaxTextSize(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeMaxTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int[] getAutoSizeTextAvailableSizes(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeTextAvailableSizes(textView);
        }
        return textView instanceof AutoSizeableTextView ? ((AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes() : new int[0];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(textView, callback));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        return (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 27 || (callback instanceof OreoCallback) || callback == null) ? callback : new OreoCallback(callback, textView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        return (!(callback instanceof OreoCallback) || Build.VERSION.SDK_INT < 26) ? callback : ((OreoCallback) callback).getWrappedCallback();
    }

    private static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences = false;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        OreoCallback(ActionMode.Callback callback, TextView textView) {
            this.mCallback = callback;
            this.mTextView = textView;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mCallback.onCreateActionMode(actionMode, menu);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            recomputeProcessTextMenuItems(menu);
            return this.mCallback.onPrepareActionMode(actionMode, menu);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mCallback.onActionItemClicked(actionMode, menuItem);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.mCallback.onDestroyActionMode(actionMode);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void recomputeProcessTextMenuItems(Menu menu) {
            Method declaredMethod;
            Context context = this.mTextView.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.mInitializedMenuBuilderReferences) {
                this.mInitializedMenuBuilderReferences = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.mMenuBuilderClass = cls;
                    this.mMenuBuilderRemoveItemAtMethod = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.mCanUseMenuBuilderReferences = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.mMenuBuilderClass = null;
                    this.mMenuBuilderRemoveItemAtMethod = null;
                    this.mCanUseMenuBuilderReferences = false;
                }
            }
            try {
                if (this.mCanUseMenuBuilderReferences && this.mMenuBuilderClass.isInstance(menu)) {
                    declaredMethod = this.mMenuBuilderRemoveItemAtMethod;
                } else {
                    declaredMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> supportedActivities = getSupportedActivities(context, packageManager);
                for (int i = 0; i < supportedActivities.size(); i++) {
                    ResolveInfo resolveInfo = supportedActivities.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(createProcessTextIntentForResolveInfo(resolveInfo, this.mTextView)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private List<ResolveInfo> getSupportedActivities(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(createProcessTextIntent(), 0)) {
                if (isSupportedActivity(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean isSupportedActivity(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (resolveInfo.activityInfo.exported) {
                return resolveInfo.activityInfo.permission == null || context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0;
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Intent createProcessTextIntentForResolveInfo(ResolveInfo resolveInfo, TextView textView) {
            return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean isEditable(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setFirstBaselineToTopHeight(TextView textView, int i) {
        int i2;
        Preconditions.checkArgumentNonnegative(i);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setFirstBaselineToTopHeight(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Api16Impl.getIncludeFontPadding(textView)) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setLastBaselineToBottomHeight(TextView textView, int i) {
        int i2;
        Preconditions.checkArgumentNonnegative(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Api16Impl.getIncludeFontPadding(textView)) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getFirstBaselineToTopHeight(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getLastBaselineToBottomHeight(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setLineHeight(TextView textView, int i) {
        Preconditions.checkArgumentNonnegative(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PrecomputedTextCompat.Params getTextMetricsParams(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(textView));
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint(textView.getPaint()));
        builder.setBreakStrategy(Api23Impl.getBreakStrategy(textView));
        builder.setHyphenationFrequency(Api23Impl.getHyphenationFrequency(textView));
        builder.setTextDirection(getTextDirectionHeuristic(textView));
        return builder.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setTextMetricsParams(TextView textView, PrecomputedTextCompat.Params params) {
        Api17Impl.setTextDirection(textView, getTextDirection(params.getTextDirection()));
        textView.getPaint().set(params.getTextPaint());
        Api23Impl.setBreakStrategy(textView, params.getBreakStrategy());
        Api23Impl.setHyphenationFrequency(textView, params.getHyphenationFrequency());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setPrecomputedText(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(precomputedTextCompat.getPrecomputedText());
        } else {
            if (!getTextMetricsParams(textView).equalsWithoutTextDirection(precomputedTextCompat.getParams())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(precomputedTextCompat);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(Api17Impl.getTextLocale(textView)))[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
        boolean z = Api17Impl.getLayoutDirection(textView) == 1;
        switch (Api17Impl.getTextDirection(textView)) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                if (!z) {
                    break;
                } else {
                    break;
                }
        }
        return TextDirectionHeuristics.LTR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCompoundDrawableTintList(TextView textView, ColorStateList colorStateList) {
        Preconditions.checkNotNull(textView);
        Api23Impl.setCompoundDrawableTintList(textView, colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ColorStateList getCompoundDrawableTintList(TextView textView) {
        Preconditions.checkNotNull(textView);
        return Api23Impl.getCompoundDrawableTintList(textView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode mode) {
        Preconditions.checkNotNull(textView);
        Api23Impl.setCompoundDrawableTintMode(textView, mode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
        Preconditions.checkNotNull(textView);
        return Api23Impl.getCompoundDrawableTintMode(textView);
    }

    static class Api17Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api17Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getLayoutDirection(View view) {
            return view.getLayoutDirection();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Drawable[] getCompoundDrawablesRelative(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setTextDirection(View view, int i) {
            view.setTextDirection(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Locale getTextLocale(TextView textView) {
            return textView.getTextLocale();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getTextDirection(View view) {
            return view.getTextDirection();
        }
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getMaxLines(TextView textView) {
            return textView.getMaxLines();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getMinLines(TextView textView) {
            return textView.getMinLines();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean getIncludeFontPadding(TextView textView) {
            return textView.getIncludeFontPadding();
        }
    }

    static class Api26Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api26Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setAutoSizeTextTypeWithDefaults(TextView textView, int i) {
            textView.setAutoSizeTextTypeWithDefaults(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getAutoSizeTextType(TextView textView) {
            return textView.getAutoSizeTextType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getAutoSizeMinTextSize(TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getAutoSizeMaxTextSize(TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int[] getAutoSizeTextAvailableSizes(TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setFirstBaselineToTopHeight(TextView textView, int i) {
            textView.setFirstBaselineToTopHeight(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static PrecomputedText.Params getTextMetricsParams(TextView textView) {
            return textView.getTextMetricsParams();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String[] getDigitStrings(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }
    }

    static class Api23Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api23Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getBreakStrategy(TextView textView) {
            return textView.getBreakStrategy();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setBreakStrategy(TextView textView, int i) {
            textView.setBreakStrategy(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getHyphenationFrequency(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setHyphenationFrequency(TextView textView, int i) {
            textView.setHyphenationFrequency(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ColorStateList getCompoundDrawableTintList(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setCompoundDrawableTintList(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static DecimalFormatSymbols getInstance(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }
}
