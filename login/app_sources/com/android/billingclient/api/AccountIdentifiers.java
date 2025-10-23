package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class AccountIdentifiers {
    private final String zza;
    private final String zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AccountIdentifiers(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getObfuscatedAccountId() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getObfuscatedProfileId() {
        return this.zzb;
    }
}
