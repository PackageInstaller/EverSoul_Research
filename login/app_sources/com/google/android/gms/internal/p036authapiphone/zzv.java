package com.google.android.gms.internal.p036authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsCodeBrowserClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
/* loaded from: classes2.dex */
public final class zzv extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsCodeBrowserClient {
    private static final Api.ClientKey<zzw> zza;
    private static final Api.AbstractClientBuilder<zzw, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Api.ClientKey<zzw> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzt zztVar = new zzt();
        zzb = zztVar;
        zzc = new Api<>("SmsCodeBrowser.API", zztVar, clientKey);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzv(Activity activity) {
        super(activity, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.phone.SmsCodeBrowserClient
    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(TaskApiCall.builder().setFeatures(zzac.zzb).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api-phone.zzs
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzf(new zzu(zzv.this, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(1566).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzv(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
