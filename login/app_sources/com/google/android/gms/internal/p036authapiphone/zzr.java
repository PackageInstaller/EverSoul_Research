package com.google.android.gms.internal.p036authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsCodeAutofillClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
/* loaded from: classes2.dex */
public final class zzr extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsCodeAutofillClient {
    private static final Api.ClientKey<zzw> zza;
    private static final Api.AbstractClientBuilder<zzw, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Api.ClientKey<zzw> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzc = new Api<>("SmsCodeAutofill.API", zznVar, clientKey);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzr(Activity activity) {
        super(activity, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Integer> checkPermissionState() {
        return doRead(TaskApiCall.builder().setFeatures(zzac.zza).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api-phone.zzk
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzc(new zzp(zzr.this, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(1564).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Boolean> hasOngoingSmsRequest(final String str) {
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(TaskApiCall.builder().setFeatures(zzac.zza).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api-phone.zzm
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzr zzrVar = zzr.this;
                ((zzh) ((zzw) obj).getService()).zzd(str, new zzq(zzrVar, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(1565).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(TaskApiCall.builder().setFeatures(zzac.zza).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api-phone.zzl
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zze(new zzo(zzr.this, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(1563).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzr(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
