package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGKakaoPicker;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoPicker.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGKakaoPicker$sendMultiInviteMessage$1", m855f = "KGKakaoPicker.kt", m856i = {}, m857l = {124}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGKakaoPicker$sendMultiInviteMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Map<String, String> $args;
    final /* synthetic */ KGResultCallback<List<KGKakaoPicker.KGKakaoUser>> $callback;
    final /* synthetic */ boolean $isPopup;
    final /* synthetic */ String $templateId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGKakaoPicker$sendMultiInviteMessage$1(Activity activity, boolean z, String str, Map<String, String> map, KGResultCallback<List<KGKakaoPicker.KGKakaoUser>> kGResultCallback, Continuation<? super KGKakaoPicker$sendMultiInviteMessage$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$isPopup = z;
        this.$templateId = str;
        this.$args = map;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGKakaoPicker$sendMultiInviteMessage$1(this.$activity, this.$isPopup, this.$templateId, this.$args, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGKakaoPicker$sendMultiInviteMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KGResult sendMultiInviteMessage;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sendMultiInviteMessage = KGKakaoPicker.INSTANCE.sendMultiInviteMessage(this.$activity, this.$isPopup, this.$templateId, this.$args);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C22951(sendMultiInviteMessage, this.$callback, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: KGKakaoPicker.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGKakaoPicker$sendMultiInviteMessage$1$1", m855f = "KGKakaoPicker.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGKakaoPicker$sendMultiInviteMessage$1$1 */
    static final class C22951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<List<KGKakaoPicker.KGKakaoUser>> $callback;
        final /* synthetic */ KGResult<List<KGKakaoPicker.KGKakaoUser>> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C22951(KGResult<List<KGKakaoPicker.KGKakaoUser>> kGResult, KGResultCallback<List<KGKakaoPicker.KGKakaoUser>> kGResultCallback, Continuation<? super C22951> continuation) {
            super(2, continuation);
            this.$result = kGResult;
            this.$callback = kGResultCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22951(this.$result, this.$callback, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            String str2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            Logger logger = Logger.INSTANCE;
            str = KGKakaoPicker.TAG;
            logger.m704i(str, y.ݬֲ֮ܲت(1512813951) + this.$result);
            FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
            str2 = KGKakaoPicker.CLASS_NAME_KEY;
            companion.sendEvent(str2, y.ۮڭڭܬި(862384419), this.$result);
            KGResultCallback<List<KGKakaoPicker.KGKakaoUser>> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(this.$result);
            }
            return Unit.INSTANCE;
        }
    }
}
