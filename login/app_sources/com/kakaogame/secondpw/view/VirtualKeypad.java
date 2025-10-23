package com.kakaogame.secondpw.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.security.C2558R;
import com.kakaogame.security.databinding.KakaoGame2ndVirtualKeypadBinding;
import com.liapp.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VirtualKeypad.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0011J*\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/secondpw/view/VirtualKeypad;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/kakaogame/security/databinding/KakaoGame2ndVirtualKeypadBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "", "setCode", "code", "", "setKeypadImage", Base2ndPWViewData.KEY_PATH, "setOnKeyListener", "viewData", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "eventListener", "Companion", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class VirtualKeypad extends RelativeLayout {
    public static final int ACTION_TYPE_INPUT = 1;
    public static final int ACTION_TYPE_REMOVE = 2;
    public static final int ACTION_TYPE_REMOVE_ALL = 0;
    private final KakaoGame2ndVirtualKeypadBinding binding;
    private Function2<? super Integer, ? super Character, Unit> listener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VirtualKeypad(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VirtualKeypad(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ VirtualKeypad(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VirtualKeypad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        KakaoGame2ndVirtualKeypadBinding inflate = KakaoGame2ndVirtualKeypadBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setOnKeyListener(Base2ndPWViewData viewData, Function2<? super Integer, ? super Character, Unit> eventListener) {
        Intrinsics.checkNotNullParameter(viewData, y.٬ݯح׭٩(576439206));
        Intrinsics.checkNotNullParameter(eventListener, y.ۮڭڭܬި(862302443));
        this.listener = eventListener;
        KakaoGame2ndVirtualKeypadBinding kakaoGame2ndVirtualKeypadBinding = this.binding;
        kakaoGame2ndVirtualKeypadBinding.digitCodeClear.setText(viewData.getResetButtonText());
        kakaoGame2ndVirtualKeypadBinding.digitCodeClear.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.view.VirtualKeypad$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualKeypad.setOnKeyListener$lambda$2$lambda$0(VirtualKeypad.this, view);
            }
        });
        kakaoGame2ndVirtualKeypadBinding.digitCodeDelete.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.view.VirtualKeypad$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualKeypad.setOnKeyListener$lambda$2$lambda$1(VirtualKeypad.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void setOnKeyListener$lambda$2$lambda$0(VirtualKeypad this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<? super Integer, ? super Character, Unit> function2 = this$0.listener;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            function2 = null;
        }
        function2.invoke(0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void setOnKeyListener$lambda$2$lambda$1(VirtualKeypad this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<? super Integer, ? super Character, Unit> function2 = this$0.listener;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            function2 = null;
        }
        function2.invoke(2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setKeypadImage(String path) {
        Intrinsics.checkNotNullParameter(path, y.دײܮڳܯ(2051509965));
        KakaoGame2ndVirtualKeypadBinding kakaoGame2ndVirtualKeypadBinding = this.binding;
        kakaoGame2ndVirtualKeypadBinding.kakaoGameVirtualKeypadImage.setImageBitmap(BitmapFactory.decodeFile(path));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCode(String code) {
        Intrinsics.checkNotNullParameter(code, y.دײܮڳܯ(2051571757));
        KakaoGame2ndVirtualKeypadBinding kakaoGame2ndVirtualKeypadBinding = this.binding;
        final List listOf = CollectionsKt.listOf((Object[]) new Button[]{kakaoGame2ndVirtualKeypadBinding.digitCode1, kakaoGame2ndVirtualKeypadBinding.digitCode2, kakaoGame2ndVirtualKeypadBinding.digitCode3, kakaoGame2ndVirtualKeypadBinding.digitCode4, kakaoGame2ndVirtualKeypadBinding.digitCode5, kakaoGame2ndVirtualKeypadBinding.digitCode6, kakaoGame2ndVirtualKeypadBinding.digitCode7, kakaoGame2ndVirtualKeypadBinding.digitCode8, kakaoGame2ndVirtualKeypadBinding.digitCode9, kakaoGame2ndVirtualKeypadBinding.digitCode0});
        int size = listOf.size();
        for (final int i = 0; i < size; i++) {
            ((Button) listOf.get(i)).setTag(C2558R.id.buttonTag, Character.valueOf(code.charAt(i)));
            ((Button) listOf.get(i)).setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.view.VirtualKeypad$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualKeypad.setCode$lambda$5$lambda$4(listOf, i, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void setCode$lambda$5$lambda$4(List buttons, int i, VirtualKeypad this$0, View view) {
        Intrinsics.checkNotNullParameter(buttons, "$buttons");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.e(y.دײܮڳܯ(2051087701), y.֬ڱܱײٮ(-1159183463) + ((Button) buttons.get(i)).getTag(C2558R.id.buttonTag));
        Function2<? super Integer, ? super Character, Unit> function2 = this$0.listener;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            function2 = null;
        }
        Object tag = ((Button) buttons.get(i)).getTag(C2558R.id.buttonTag);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Char");
        function2.invoke(1, (Character) tag);
    }
}
