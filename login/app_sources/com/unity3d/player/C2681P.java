package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* renamed from: com.unity3d.player.P */
/* loaded from: classes3.dex */
final class C2681P extends RelativeLayout {

    /* renamed from: a */
    protected Button f1211a;

    /* renamed from: b */
    protected EditText f1212b;

    /* renamed from: c */
    protected Context f1213c;

    /* renamed from: d */
    protected Rect f1214d;

    /* renamed from: e */
    protected Rect f1215e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2681P(Context context, EditText editText) {
        super(context);
        this.f1212b = editText;
        this.f1213c = context;
        this.f1214d = new Rect(16, 16, 16, 16);
        this.f1215e = new Rect(0, 0, 0, 0);
        createUI();
        setBackgroundColor(-1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void createUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Button button = new Button(this.f1213c);
        this.f1211a = button;
        button.setId(View.generateViewId());
        this.f1211a.setText(this.f1213c.getResources().getIdentifier("ok", TypedValues.Custom.S_STRING, "android"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.f1211a.setLayoutParams(layoutParams);
        this.f1211a.setBackgroundColor(0);
        addView(this.f1211a);
        this.f1212b.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, this.f1211a.getId());
        this.f1212b.setLayoutParams(layoutParams2);
        addView(this.f1212b);
        Rect rect = this.f1214d;
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1211a.setOnClickListener(onClickListener);
    }
}
