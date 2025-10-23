package com.google.android.play.core.ktx;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: com.google.android.play:review-ktx@@2.0.0 */
@Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.google.android.play.core.ktx.ReviewManagerKtxKt", m855f = "ReviewManagerKtx.kt", m856i = {}, m857l = {22}, m858m = "requestReview", m859n = {}, m860s = {})
/* loaded from: classes2.dex */
final class ReviewManagerKtxKt$requestReview$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ReviewManagerKtxKt$requestReview$1(Continuation<? super ReviewManagerKtxKt$requestReview$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReviewManagerKtxKt.requestReview(null, this);
    }
}
