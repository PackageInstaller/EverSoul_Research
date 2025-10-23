package com.kakaogame.secondpw;

import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.security.databinding.KakaoGame2ndPwErrorViewBinding;
import com.kakaogame.security.databinding.KakaoGameSecondPasswordGuideViewBinding;
import com.liapp.y;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SecondPWViewDialog.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.secondpw.SecondPWViewDialog$changeTime$1", m855f = "SecondPWViewDialog.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class SecondPWViewDialog$changeTime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $countDownSec;
    int label;
    final /* synthetic */ SecondPWViewDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SecondPWViewDialog$changeTime$1(SecondPWViewDialog secondPWViewDialog, int i, Continuation<? super SecondPWViewDialog$changeTime$1> continuation) {
        super(2, continuation);
        this.this$0 = secondPWViewDialog;
        this.$countDownSec = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SecondPWViewDialog$changeTime$1(this.this$0, this.$countDownSec, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SecondPWViewDialog$changeTime$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding;
        String str;
        String str2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            kakaoGameSecondPasswordGuideViewBinding = this.this$0.binding;
            int i = this.$countDownSec;
            SecondPWViewDialog secondPWViewDialog = this.this$0;
            KakaoGame2ndPwErrorViewBinding bind = KakaoGame2ndPwErrorViewBinding.bind(kakaoGameSecondPasswordGuideViewBinding.errorView.getRoot());
            Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
            int i2 = i / 60;
            NotoSansTextView notoSansTextView = bind.kakaoGame2ndPwError2lineTime;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            StringBuilder sb = new StringBuilder(y.ݮڮֲڭܩ(-628458116));
            str = secondPWViewDialog.minLabel;
            StringBuilder append = sb.append(str).append(y.ݬֲ֮ܲت(1512123591));
            str2 = secondPWViewDialog.secLabel;
            String format = String.format(append.append(str2).toString(), Arrays.copyOf(new Object[]{Boxing.boxInt(i2), Boxing.boxInt(i - (i2 * 60))}, 2));
            Intrinsics.checkNotNullExpressionValue(format, y.ٲٴݴ״ٰ(1782078816));
            notoSansTextView.setText(format);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
    }
}
