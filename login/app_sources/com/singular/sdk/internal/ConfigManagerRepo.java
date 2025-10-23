package com.singular.sdk.internal;

/* loaded from: classes3.dex */
public abstract class ConfigManagerRepo {

    public interface CompletionHandler {
        void onCompleted(SLRemoteConfiguration sLRemoteConfiguration);

        void onError();
    }

    public abstract void getConfig(CompletionHandler completionHandler);

    public abstract void saveConfig(SLRemoteConfiguration sLRemoteConfiguration, CompletionHandler completionHandler);
}
