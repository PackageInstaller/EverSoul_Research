package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGApplication;
import com.kakaogame.p029ui.PermissionManager;
import com.liapp.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGApplication.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGApplication$requestPermissionsWithDescriptionPopup$2", m855f = "KGApplication.kt", m856i = {}, m857l = {268}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGApplication$requestPermissionsWithDescriptionPopup$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KGResultCallback<Boolean> $callback;
    final /* synthetic */ boolean $optionalGuarantee;
    final /* synthetic */ List<String> $optionalPermissions;
    final /* synthetic */ List<String> $permissions;
    final /* synthetic */ KGApplication.KGPermissionTheme $theme;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGApplication$requestPermissionsWithDescriptionPopup$2(KGApplication.KGPermissionTheme kGPermissionTheme, Activity activity, List<String> list, List<String> list2, boolean z, KGResultCallback<Boolean> kGResultCallback, Continuation<? super KGApplication$requestPermissionsWithDescriptionPopup$2> continuation) {
        super(2, continuation);
        this.$theme = kGPermissionTheme;
        this.$activity = activity;
        this.$permissions = list;
        this.$optionalPermissions = list2;
        this.$optionalGuarantee = z;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGApplication$requestPermissionsWithDescriptionPopup$2(this.$theme, this.$activity, this.$permissions, this.$optionalPermissions, this.$optionalGuarantee, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGApplication$requestPermissionsWithDescriptionPopup$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KGApplication.KGPermissionTheme kGPermissionTheme = this.$theme;
            if (kGPermissionTheme == null) {
                kGPermissionTheme = KGApplication.KGPermissionTheme.Builder.INSTANCE.createTheme().setIconResourceId(-1).build();
            }
            KGResult successResult = KGResult.INSTANCE.getSuccessResult(Boxing.boxBoolean(PermissionManager.showUsePermissionsNotification(this.$activity, this.$permissions, this.$optionalPermissions, this.$optionalGuarantee, kGPermissionTheme)));
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C22661(successResult, this.$callback, null), this) == coroutine_suspended) {
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

    /* compiled from: KGApplication.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGApplication$requestPermissionsWithDescriptionPopup$2$1", m855f = "KGApplication.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGApplication$requestPermissionsWithDescriptionPopup$2$1 */
    static final class C22661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<Boolean> $callback;
        final /* synthetic */ KGResult<Boolean> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C22661(KGResult<Boolean> kGResult, KGResultCallback<Boolean> kGResultCallback, Continuation<? super C22661> continuation) {
            super(2, continuation);
            this.$result = kGResult;
            this.$callback = kGResultCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22661(this.$result, this.$callback, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            Logger.INSTANCE.m704i(y.ݬֲ֮ܲت(1512625815), y.ݮڮֲڭܩ(-628764812) + this.$result);
            KGResultCallback<Boolean> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(this.$result);
            }
            return Unit.INSTANCE;
        }
    }
}
