package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.liapp.y;
import java.util.ArrayList;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzcy {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzcx zza(Bundle bundle, String str, String str2) {
        BillingResult billingResult = zzcj.zzk;
        String str3 = y.ٴسسݬߨ(1392804282);
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zze.zzl(str3, String.format("%s got null owned items list", str2));
            return new zzcx(billingResult, 54);
        }
        int zzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle, str3);
        String zzh = com.google.android.gms.internal.play_billing.zze.zzh(bundle, str3);
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(zzb);
        newBuilder.setDebugMessage(zzh);
        BillingResult build = newBuilder.build();
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl(str3, String.format("%s failed. Response code: %s", str2, Integer.valueOf(zzb)));
            return new zzcx(build, 23);
        }
        String str4 = y.ٲٴݴ״ٰ(1781658200);
        if (bundle.containsKey(str4)) {
            String str5 = y.֬ڱܱײٮ(-1159417055);
            if (bundle.containsKey(str5)) {
                String str6 = y.ٲٴݴ״ٰ(1781658104);
                if (bundle.containsKey(str6)) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList(str4);
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList(str5);
                    ArrayList<String> stringArrayList3 = bundle.getStringArrayList(str6);
                    if (stringArrayList == null) {
                        com.google.android.gms.internal.play_billing.zze.zzl(str3, String.format("Bundle returned from %s contains null SKUs list.", str2));
                        return new zzcx(billingResult, 56);
                    }
                    if (stringArrayList2 == null) {
                        com.google.android.gms.internal.play_billing.zze.zzl(str3, String.format("Bundle returned from %s contains null purchases list.", str2));
                        return new zzcx(billingResult, 57);
                    }
                    if (stringArrayList3 != null) {
                        return new zzcx(zzcj.zzl, 1);
                    }
                    com.google.android.gms.internal.play_billing.zze.zzl(str3, String.format("Bundle returned from %s contains null signatures list.", str2));
                    return new zzcx(billingResult, 58);
                }
            }
        }
        com.google.android.gms.internal.play_billing.zze.zzl(str3, String.format("Bundle returned from %s doesn't contain required fields.", str2));
        return new zzcx(billingResult, 55);
    }
}
