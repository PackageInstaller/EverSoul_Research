package com.kakaogame;

import kotlin.Metadata;

/* compiled from: KGResultCallback.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H&¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGResultCallback;", "T", "", "onResult", "", "result", "Lcom/kakaogame/KGResult;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface KGResultCallback<T> {
    void onResult(KGResult<T> result);
}
