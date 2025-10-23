package com.gamania.beanfunsdk.api;

import com.gamania.beanfunsdk.model.Result;

/* loaded from: classes.dex */
public interface AccessCallback {
    void onCancel();

    void onError(String str);

    void onSuccess(Result result);
}
