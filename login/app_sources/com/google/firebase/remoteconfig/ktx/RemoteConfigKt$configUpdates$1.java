package com.google.firebase.remoteconfig.ktx;

import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: RemoteConfig.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/firebase/remoteconfig/ConfigUpdate;"}, m840k = 3, m841mv = {1, 7, 1}, m843xi = 48)
@DebugMetadata(m854c = "com.google.firebase.remoteconfig.ktx.RemoteConfigKt$configUpdates$1", m855f = "RemoteConfig.kt", m856i = {}, m857l = {117}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes2.dex */
final class RemoteConfigKt$configUpdates$1 extends SuspendLambda implements Function2<ProducerScope<? super ConfigUpdate>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FirebaseRemoteConfig $this_configUpdates;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RemoteConfigKt$configUpdates$1(FirebaseRemoteConfig firebaseRemoteConfig, Continuation<? super RemoteConfigKt$configUpdates$1> continuation) {
        super(2, continuation);
        this.$this_configUpdates = firebaseRemoteConfig;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RemoteConfigKt$configUpdates$1 remoteConfigKt$configUpdates$1 = new RemoteConfigKt$configUpdates$1(this.$this_configUpdates, continuation);
        remoteConfigKt$configUpdates$1.L$0 = obj;
        return remoteConfigKt$configUpdates$1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super ConfigUpdate> producerScope, Continuation<? super Unit> continuation) {
        return ((RemoteConfigKt$configUpdates$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final ConfigUpdateListenerRegistration addOnConfigUpdateListener = this.$this_configUpdates.addOnConfigUpdateListener(new RemoteConfigKt$configUpdates$1$registration$1(this.$this_configUpdates, producerScope));
            Intrinsics.checkNotNullExpressionValue(addOnConfigUpdateListener, "FirebaseRemoteConfig.con…      }\n        }\n      )");
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: com.google.firebase.remoteconfig.ktx.RemoteConfigKt$configUpdates$1.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(0);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConfigUpdateListenerRegistration.this.remove();
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
