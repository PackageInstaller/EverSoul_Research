package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGKakaoPicker;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
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
@DebugMetadata(m854c = "com.kakaogame.KGKakaoPicker$sendSingleInviteMessage$1", m855f = "KGKakaoPicker.kt", m856i = {}, m857l = {82}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGKakaoPicker$sendSingleInviteMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Map<String, String> $args;
    final /* synthetic */ KGResultCallback<KGKakaoPicker.KGKakaoUser> $callback;
    final /* synthetic */ boolean $isPopup;
    final /* synthetic */ String $templateId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGKakaoPicker$sendSingleInviteMessage$1(Activity activity, boolean z, String str, Map<String, String> map, KGResultCallback<KGKakaoPicker.KGKakaoUser> kGResultCallback, Continuation<? super KGKakaoPicker$sendSingleInviteMessage$1> continuation) {
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
        return new KGKakaoPicker$sendSingleInviteMessage$1(this.$activity, this.$isPopup, this.$templateId, this.$args, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGKakaoPicker$sendSingleInviteMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KGResult sendSingleInviteMessage;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sendSingleInviteMessage = KGKakaoPicker.INSTANCE.sendSingleInviteMessage(this.$activity, this.$isPopup, this.$templateId, this.$args);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C22961(sendSingleInviteMessage, this.$callback, null), this) == coroutine_suspended) {
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
    @DebugMetadata(m854c = "com.kakaogame.KGKakaoPicker$sendSingleInviteMessage$1$1", m855f = "KGKakaoPicker.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGKakaoPicker$sendSingleInviteMessage$1$1 */
    static final class C22961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<KGKakaoPicker.KGKakaoUser> $callback;
        final /* synthetic */ KGResult<KGKakaoPicker.KGKakaoUser> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C22961(KGResult<KGKakaoPicker.KGKakaoUser> kGResult, KGResultCallback<KGKakaoPicker.KGKakaoUser> kGResultCallback, Continuation<? super C22961> continuation) {
            super(2, continuation);
            this.$result = kGResult;
            this.$callback = kGResultCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22961(this.$result, this.$callback, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            logger.m704i(str, y.ٴسسݬߨ(1392679050) + this.$result);
            KGResultCallback<KGKakaoPicker.KGKakaoUser> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(this.$result);
            }
            FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
            str2 = KGKakaoPicker.CLASS_NAME_KEY;
            companion.sendEvent(str2, y.ۮڭڭܬި(862267939), this.$result);
            return Unit.INSTANCE;
        }
    }
}
