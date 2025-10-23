package com.kakaogame.secondpw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.kakaogame.security.databinding.KakaoGame2ndPwInputDisplayBinding;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordCodeDisplayView.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/secondpw/view/PasswordCodeDisplayView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/kakaogame/security/databinding/KakaoGame2ndPwInputDisplayBinding;", "code", "", "clear", "", "getCode", "setCode", "value", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PasswordCodeDisplayView extends FrameLayout {
    private final KakaoGame2ndPwInputDisplayBinding binding;
    private char code;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PasswordCodeDisplayView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PasswordCodeDisplayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PasswordCodeDisplayView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PasswordCodeDisplayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        KakaoGame2ndPwInputDisplayBinding inflate = KakaoGame2ndPwInputDisplayBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCode(char value) {
        this.code = value;
        KakaoGame2ndPwInputDisplayBinding kakaoGame2ndPwInputDisplayBinding = this.binding;
        kakaoGame2ndPwInputDisplayBinding.pwInputNone.setVisibility(4);
        kakaoGame2ndPwInputDisplayBinding.pwInputValue.setVisibility(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void clear() {
        this.code = (char) 0;
        KakaoGame2ndPwInputDisplayBinding kakaoGame2ndPwInputDisplayBinding = this.binding;
        kakaoGame2ndPwInputDisplayBinding.pwInputNone.setVisibility(0);
        kakaoGame2ndPwInputDisplayBinding.pwInputValue.setVisibility(4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final char getCode() {
        return this.code;
    }
}
