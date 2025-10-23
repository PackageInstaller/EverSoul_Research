package com.google.android.gms.games;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzn implements Api.ApiOptions.Optional, GoogleSignInOptionsExtension, Api.ApiOptions.HasGoogleSignInAccountOptions {
    public final int zze;
    public final ArrayList zzg;
    public final GoogleSignInAccount zzk;
    public final String zzn;
    public final com.google.android.gms.games.internal.zzl zzo;
    public final boolean zza = false;
    public final boolean zzb = true;
    public final int zzc = 17;
    public final boolean zzd = false;
    public final String zzf = null;
    public final boolean zzh = false;
    public final boolean zzi = false;
    public final boolean zzj = false;
    public final String zzl = null;
    private final int zzp = 0;
    public final int zzm = 9;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzn(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList arrayList, boolean z4, boolean z5, boolean z6, GoogleSignInAccount googleSignInAccount, String str2, int i3, int i4, String str3, com.google.android.gms.games.internal.zzl zzlVar, zzm zzmVar) {
        this.zze = i2;
        this.zzg = arrayList;
        this.zzk = googleSignInAccount;
        this.zzn = str3;
        this.zzo = zzlVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzl zzb() {
        return new zzl(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        boolean z = zznVar.zza;
        boolean z2 = zznVar.zzb;
        int i = zznVar.zzc;
        boolean z3 = zznVar.zzd;
        if (this.zze == zznVar.zze) {
            String str = zznVar.zzf;
            if (this.zzg.equals(zznVar.zzg)) {
                boolean z4 = zznVar.zzh;
                boolean z5 = zznVar.zzi;
                boolean z6 = zznVar.zzj;
                GoogleSignInAccount googleSignInAccount = this.zzk;
                if (googleSignInAccount != null ? googleSignInAccount.equals(zznVar.zzk) : zznVar.zzk == null) {
                    String str2 = zznVar.zzl;
                    if (TextUtils.equals(null, null)) {
                        int i2 = zznVar.zzp;
                        int i3 = zznVar.zzm;
                        if (Objects.equal(this.zzn, zznVar.zzn)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public final int getExtensionType() {
        return 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public final List getImpliedScopes() {
        return Collections.singletonList(Games.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int hashCode = (((this.zze + 486741695) * 961) + this.zzg.hashCode()) * 923521;
        GoogleSignInAccount googleSignInAccount = this.zzk;
        int hashCode2 = (((hashCode + (googleSignInAccount == null ? 0 : googleSignInAccount.hashCode())) * 29791) + 9) * 31;
        String str = this.zzn;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public final Bundle toBundle() {
        return zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", true);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", 17);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zze);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzg);
        bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
        bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzk);
        bundle.putString("com.google.android.gms.games.key.realClientPackageName", null);
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        bundle.putString("com.google.android.gms.games.key.gameRunToken", this.zzn);
        return bundle;
    }
}
