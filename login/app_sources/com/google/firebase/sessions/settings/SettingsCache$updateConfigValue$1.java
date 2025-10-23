package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SettingsCache.kt */
@Metadata(m840k = 3, m841mv = {1, 7, 1}, m843xi = 48)
@DebugMetadata(m854c = "com.google.firebase.sessions.settings.SettingsCache", m855f = "SettingsCache.kt", m856i = {}, m857l = {112}, m858m = "updateConfigValue", m859n = {}, m860s = {})
/* loaded from: classes2.dex */
final class SettingsCache$updateConfigValue$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SettingsCache$updateConfigValue$1(SettingsCache settingsCache, Continuation<? super SettingsCache$updateConfigValue$1> continuation) {
        super(continuation);
        this.this$0 = settingsCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updateConfigValue;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateConfigValue = this.this$0.updateConfigValue(null, null, this);
        return updateConfigValue;
    }
}
