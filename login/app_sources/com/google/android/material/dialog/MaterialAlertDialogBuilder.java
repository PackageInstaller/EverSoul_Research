package com.google.android.material.dialog;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.C0903R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes2.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
    private static final int DEF_STYLE_ATTR = C0903R.attr.alertDialogStyle;
    private static final int DEF_STYLE_RES = C0903R.style.MaterialAlertDialog_MaterialComponents;
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = C0903R.attr.materialAlertDialogTheme;
    private Drawable background;
    private final Rect backgroundInsets;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getMaterialAlertDialogThemeOverlay(Context context) {
        TypedValue resolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Context createMaterialAlertDialogThemedContext(Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        Context wrap = MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        return materialAlertDialogThemeOverlay == 0 ? wrap : new ContextThemeWrapper(wrap, materialAlertDialogThemeOverlay);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getOverridingThemeResId(Context context, int i) {
        return i == 0 ? getMaterialAlertDialogThemeOverlay(context) : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialAlertDialogBuilder(Context context, int i) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i2 = DEF_STYLE_ATTR;
        int i3 = DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, i2, i3);
        int color = MaterialColors.getColor(context2, C0903R.attr.colorSurface, getClass().getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, i2, i3);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.background;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(ViewCompat.getElevation(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(create, this.backgroundInsets));
        return create;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable getBackground() {
        return this.background;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialAlertDialogBuilder setBackground(Drawable drawable) {
        this.background = drawable;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialAlertDialogBuilder setBackgroundInsetStart(int i) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.right = i;
        } else {
            this.backgroundInsets.left = i;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialAlertDialogBuilder setBackgroundInsetTop(int i) {
        this.backgroundInsets.top = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialAlertDialogBuilder setBackgroundInsetEnd(int i) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.left = i;
        } else {
            this.backgroundInsets.right = i;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialAlertDialogBuilder setBackgroundInsetBottom(int i) {
        this.backgroundInsets.bottom = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setTitle(int i) {
        return (MaterialAlertDialogBuilder) super.setTitle(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setTitle(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setCustomTitle(View view) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMessage(int i) {
        return (MaterialAlertDialogBuilder) super.setMessage(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMessage(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setIcon(int i) {
        return (MaterialAlertDialogBuilder) super.setIcon(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setIconAttribute(int i) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setPositiveButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNegativeButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(i, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNeutralButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setCancelable(boolean z) {
        return (MaterialAlertDialogBuilder) super.setCancelable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setItems(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(i, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
        return (MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(i, zArr, onMultiChoiceClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(i, i2, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i, str, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i, onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setView(int i) {
        return (MaterialAlertDialogBuilder) super.setView(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setView(View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }
}
