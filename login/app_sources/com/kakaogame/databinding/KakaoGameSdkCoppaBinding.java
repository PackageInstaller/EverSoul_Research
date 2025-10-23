package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameSdkCoppaBinding implements ViewBinding {
    public final Button kakaoGameCoppaButton;
    public final DatePicker kakaoGameCoppaDatePicker;
    public final TextView kakaoGameCoppaDesc;
    public final TextView kakaoGameCoppaTitle;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameSdkCoppaBinding(RelativeLayout relativeLayout, Button button, DatePicker datePicker, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.kakaoGameCoppaButton = button;
        this.kakaoGameCoppaDatePicker = datePicker;
        this.kakaoGameCoppaDesc = textView;
        this.kakaoGameCoppaTitle = textView2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkCoppaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkCoppaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_sdk_coppa, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkCoppaBinding bind(View view) {
        int i = C2382R.id.kakao_game_coppa_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = C2382R.id.kakao_game_coppa_datePicker;
            DatePicker datePicker = (DatePicker) ViewBindings.findChildViewById(view, i);
            if (datePicker != null) {
                i = C2382R.id.kakao_game_coppa_desc;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C2382R.id.kakao_game_coppa_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new KakaoGameSdkCoppaBinding((RelativeLayout) view, button, datePicker, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
