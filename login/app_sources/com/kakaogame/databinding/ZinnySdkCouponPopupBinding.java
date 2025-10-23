package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class ZinnySdkCouponPopupBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView zinnySdkCouponInputCancel;
    public final TextView zinnySdkCouponInputSubmit;
    public final EditText zinnySdkCouponInputText;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ZinnySdkCouponPopupBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, EditText editText) {
        this.rootView = relativeLayout;
        this.zinnySdkCouponInputCancel = textView;
        this.zinnySdkCouponInputSubmit = textView2;
        this.zinnySdkCouponInputText = editText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkCouponPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkCouponPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.zinny_sdk_coupon_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkCouponPopupBinding bind(View view) {
        int i = C2382R.id.zinny_sdk_coupon_input_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C2382R.id.zinny_sdk_coupon_input_submit;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C2382R.id.zinny_sdk_coupon_input_text;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    return new ZinnySdkCouponPopupBinding((RelativeLayout) view, textView, textView2, editText);
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
