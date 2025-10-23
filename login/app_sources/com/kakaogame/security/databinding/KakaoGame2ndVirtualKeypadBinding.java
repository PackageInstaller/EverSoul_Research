package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansButton;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndVirtualKeypadBinding implements ViewBinding {
    public final Button digitCode0;
    public final Button digitCode1;
    public final Button digitCode2;
    public final Button digitCode3;
    public final Button digitCode4;
    public final Button digitCode5;
    public final Button digitCode6;
    public final Button digitCode7;
    public final Button digitCode8;
    public final Button digitCode9;
    public final NotoSansButton digitCodeClear;
    public final Button digitCodeDelete;
    public final ImageView kakaoGameVirtualKeypadImage;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndVirtualKeypadBinding(RelativeLayout relativeLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, NotoSansButton notoSansButton, Button button11, ImageView imageView) {
        this.rootView = relativeLayout;
        this.digitCode0 = button;
        this.digitCode1 = button2;
        this.digitCode2 = button3;
        this.digitCode3 = button4;
        this.digitCode4 = button5;
        this.digitCode5 = button6;
        this.digitCode6 = button7;
        this.digitCode7 = button8;
        this.digitCode8 = button9;
        this.digitCode9 = button10;
        this.digitCodeClear = notoSansButton;
        this.digitCodeDelete = button11;
        this.kakaoGameVirtualKeypadImage = imageView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndVirtualKeypadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndVirtualKeypadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_virtual_keypad, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndVirtualKeypadBinding bind(View view) {
        int i = C2558R.id.digit_code_0;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = C2558R.id.digit_code_1;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = C2558R.id.digit_code_2;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = C2558R.id.digit_code_3;
                    Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button4 != null) {
                        i = C2558R.id.digit_code_4;
                        Button button5 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button5 != null) {
                            i = C2558R.id.digit_code_5;
                            Button button6 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button6 != null) {
                                i = C2558R.id.digit_code_6;
                                Button button7 = (Button) ViewBindings.findChildViewById(view, i);
                                if (button7 != null) {
                                    i = C2558R.id.digit_code_7;
                                    Button button8 = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button8 != null) {
                                        i = C2558R.id.digit_code_8;
                                        Button button9 = (Button) ViewBindings.findChildViewById(view, i);
                                        if (button9 != null) {
                                            i = C2558R.id.digit_code_9;
                                            Button button10 = (Button) ViewBindings.findChildViewById(view, i);
                                            if (button10 != null) {
                                                i = C2558R.id.digit_code_clear;
                                                NotoSansButton notoSansButton = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                                                if (notoSansButton != null) {
                                                    i = C2558R.id.digit_code_delete;
                                                    Button button11 = (Button) ViewBindings.findChildViewById(view, i);
                                                    if (button11 != null) {
                                                        i = C2558R.id.kakao_game_virtual_keypad_image;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView != null) {
                                                            return new KakaoGame2ndVirtualKeypadBinding((RelativeLayout) view, button, button2, button3, button4, button5, button6, button7, button8, button9, button10, notoSansButton, button11, imageView);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
