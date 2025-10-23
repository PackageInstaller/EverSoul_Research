package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    final int zza;
    int zzb;

    @Deprecated
    String zzc;
    Account zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccountChangeEventsRequest() {
        this.zza = 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Account getAccount() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public String getAccountName() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getEventIndex() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzd = account;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzc = str;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzb = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzd = account;
        } else {
            this.zzd = new Account(str, "com.google");
        }
    }
}
