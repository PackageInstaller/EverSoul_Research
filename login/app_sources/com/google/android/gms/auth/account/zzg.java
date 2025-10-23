package com.google.android.gms.auth.account;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.internal.PendingResultUtil;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzg implements PendingResultUtil.ResultConverter<WorkAccountApi.AddAccountResult, Account> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzg(WorkAccountClient workAccountClient) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* bridge */ /* synthetic */ Account convert(WorkAccountApi.AddAccountResult addAccountResult) {
        return addAccountResult.getAccount();
    }
}
