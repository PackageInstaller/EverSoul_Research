package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.volley.AuthFailureError;
import com.liapp.y;

/* loaded from: classes.dex */
public class AndroidAuthenticator implements Authenticator {
    private final Account mAccount;
    private final AccountManager mAccountManager;
    private final String mAuthTokenType;
    private final boolean mNotifyAuthFailure;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AndroidAuthenticator(AccountManager accountManager, Account account, String str, boolean z) {
        this.mAccountManager = accountManager;
        this.mAccount = account;
        this.mAuthTokenType = str;
        this.mNotifyAuthFailure = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AndroidAuthenticator(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AndroidAuthenticator(Context context, Account account, String str, boolean z) {
        this(AccountManager.get(context), account, str, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Account getAccount() {
        return this.mAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.toolbox.Authenticator
    public String getAuthToken() {
        String str;
        AccountManagerFuture<Bundle> authToken = this.mAccountManager.getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, null, null);
        try {
            Bundle result = authToken.getResult();
            if (!authToken.isDone() || authToken.isCancelled()) {
                str = null;
            } else {
                String str2 = y.ݬֲ֮ܲت(1512852487);
                if (result.containsKey(str2)) {
                    throw new AuthFailureError((Intent) result.getParcelable(str2));
                }
                str = result.getString(y.ۮڭڭܬި(861998827));
            }
            if (str != null) {
                return str;
            }
            throw new AuthFailureError(y.ۮڭڭܬި(861997315) + this.mAuthTokenType);
        } catch (Exception e) {
            throw new AuthFailureError(y.ۮڭڭܬި(861997059), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAuthTokenType() {
        return this.mAuthTokenType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.toolbox.Authenticator
    public void invalidateAuthToken(String str) {
        this.mAccountManager.invalidateAuthToken(this.mAccount.type, str);
    }
}
