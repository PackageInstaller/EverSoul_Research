package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.android.gms.internal.play_billing.zzev;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkb;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzki;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzky;
import com.google.android.gms.internal.play_billing.zzlb;
import com.google.android.gms.internal.play_billing.zzlv;
import com.google.android.gms.internal.play_billing.zzlx;
import com.liapp.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private PendingPurchasesParams zzB;
    private boolean zzC;
    private ExecutorService zzD;
    private volatile zzev zzE;
    private final Long zzF;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final Handler zzd;
    private volatile zzn zze;
    private Context zzf;
    private zzch zzg;
    private volatile com.google.android.gms.internal.play_billing.zzan zzh;
    private volatile zzba zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final String zzaN(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzch zzk() {
        return this.zzg;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BillingClientImpl(Activity activity, PendingPurchasesParams pendingPurchasesParams, String str) {
        this(activity.getApplicationContext(), pendingPurchasesParams, new zzbm(), str, null, null, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzch zzchVar) {
        this.zzf = context.getApplicationContext();
        zzks zzc = zzku.zzc();
        zzc.zzo(str);
        zzc.zzn(this.zzf.getPackageName());
        zzc.zzm(this.zzF.longValue());
        if (zzchVar != null) {
            this.zzg = zzchVar;
        } else {
            this.zzg = new zzcl(this.zzf, (zzku) zzc.zzf());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zze = new zzn(this.zzf, purchasesUpdatedListener, null, zzbVar, null, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzC = zzbVar != null;
        this.zzf.getPackageName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void startConnection(long j) {
        startConnection(new zzbm(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Future zzE(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future submit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaf
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.٬ݯح׭٩(576080382));
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return submit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final BillingResult zzaA() {
        BillingResult billingResult;
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            int i = 0;
            while (true) {
                if (i < 2) {
                    if (this.zzb == iArr[i]) {
                        billingResult = zzcj.zzm;
                        break;
                    }
                    i++;
                } else {
                    billingResult = zzcj.zzk;
                    break;
                }
            }
        }
        return billingResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zzaB(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzf.getPackageName();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String zzaC() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return y.٬ݯح׭٩(576147606);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized ExecutorService zzaD() {
        if (this.zzD == null) {
            this.zzD = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zze.zza, new zzas(this));
        }
        return this.zzD;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaE(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        int zza;
        String str;
        String str2 = y.ݬֲ֮ܲت(1512947527);
        String str3 = y.ٴسسݬߨ(1392809682);
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", str3 + purchaseToken);
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, 119, "Service has been reset to null.", null);
                return;
            }
            if (this.zzo) {
                String packageName = this.zzf.getPackageName();
                boolean z = this.zzo;
                String str4 = this.zzc;
                long longValue = this.zzF.longValue();
                Bundle bundle = new Bundle();
                if (z) {
                    com.google.android.gms.internal.play_billing.zze.zzc(bundle, str4, longValue);
                }
                Bundle zze = zzanVar.zze(9, packageName, purchaseToken, bundle);
                zza = zze.getInt("RESPONSE_CODE");
                str = com.google.android.gms.internal.play_billing.zze.zzh(zze, "BillingClient");
            } else {
                zza = zzanVar.zza(3, this.zzf.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult zza2 = zzcj.zza(zza, str);
            if (zza != 0) {
                zzaW(consumeResponseListener, purchaseToken, zza2, 23, str2 + zza, null);
            } else {
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
            }
        } catch (DeadObjectException e) {
            zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, 29, y.ۮڭڭܬި(861994659), e);
        } catch (Exception e2) {
            zzaW(consumeResponseListener, purchaseToken, zzcj.zzk, 29, y.ۮڭڭܬި(861994659), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzaF(zzjz zzjzVar) {
        try {
            this.zzg.zzb(zzjzVar, this.zzl);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), y.ٴسسݬߨ(1392807986), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaG(zzkd zzkdVar) {
        try {
            this.zzg.zzd(zzkdVar, this.zzl);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), y.ٴسسݬߨ(1392807986), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaH(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            zzbe(2, 11, zzcj.zzm);
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzcj.zzm, null);
        } else if (zzE(new zzau(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzal
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzak(purchaseHistoryResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult zzaA = zzaA();
            zzbe(25, 11, zzaA);
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzaA, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaI(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            zzbe(2, 9, zzcj.zzm);
            purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzm, com.google.android.gms.internal.play_billing.zzco.zzl());
        } else if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", y.ۮڭڭܬި(861993435));
            zzbe(50, 9, zzcj.zzh);
            purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzh, com.google.android.gms.internal.play_billing.zzco.zzl());
        } else if (zzE(new zzat(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzac
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzal(purchasesResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult zzaA = zzaA();
            zzbe(25, 9, zzaA);
            purchasesResponseListener.onQueryPurchasesResponse(zzaA, com.google.android.gms.internal.play_billing.zzco.zzl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzaJ(int i) {
        String str = y.ٲٴݴ״ٰ(1781632264);
        synchronized (this.zza) {
            if (this.zzb == 3) {
                return;
            }
            com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", str + zzaN(this.zzb) + " to " + zzaN(i));
            this.zzb = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void zzaK() {
        ExecutorService executorService = this.zzD;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzD = null;
            this.zzE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzaL() {
        synchronized (this.zza) {
            if (this.zzi != null) {
                try {
                    this.zzf.unbindService(this.zzi);
                } catch (Throwable th) {
                    try {
                        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzh = null;
                        this.zzi = null;
                    } finally {
                        this.zzh = null;
                        this.zzi = null;
                    }
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzaM() {
        return this.zzw && this.zzB.isEnabledForPrepaidPlans();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzbj zzaO(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), str, exc);
        zzbf(i, 7, billingResult, zzcg.zza(exc));
        return new zzbj(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzbk zzaP(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), str, exc);
        zzbf(i, 11, billingResult, zzcg.zza(exc));
        return new zzbk(billingResult, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzcv zzaQ(int i, BillingResult billingResult, int i2, String str, Exception exc) {
        zzbf(i2, 9, billingResult, zzcg.zza(exc));
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        return new zzcv(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzcv zzaR(String str, int i) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        Bundle zzi;
        com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.٬ݯح׭٩(576149190).concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzd = com.google.android.gms.internal.play_billing.zze.zzd(this.zzo, this.zzw, this.zzB.isEnabledForOneTimeProducts(), this.zzB.isEnabledForPrepaidPlans(), this.zzc, this.zzF.longValue());
        String str2 = null;
        do {
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar != null) {
                    if (this.zzo) {
                        zzi = zzanVar.zzj(true != this.zzw ? 9 : 19, this.zzf.getPackageName(), str, str2, zzd);
                    } else {
                        zzi = zzanVar.zzi(3, this.zzf.getPackageName(), str, str2);
                    }
                    zzcx zza = zzcy.zza(zzi, y.ٴسسݬߨ(1392804282), y.ݮڮֲڭܩ(-629090212));
                    BillingResult zza2 = zza.zza();
                    if (zza2 == zzcj.zzl) {
                        ArrayList<String> stringArrayList = zzi.getStringArrayList(y.ٲٴݴ״ٰ(1781658200));
                        ArrayList<String> stringArrayList2 = zzi.getStringArrayList(y.֬ڱܱײٮ(-1159417055));
                        ArrayList<String> stringArrayList3 = zzi.getStringArrayList(y.ٲٴݴ״ٰ(1781658104));
                        boolean z = false;
                        for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                            String str3 = stringArrayList2.get(i2);
                            String str4 = stringArrayList3.get(i2);
                            com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.ۮڭڭܬި(861964019).concat(String.valueOf(stringArrayList.get(i2))));
                            try {
                                Purchase purchase = new Purchase(str3, str4);
                                if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                    com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ٴسسݬߨ(1392830490));
                                    z = true;
                                }
                                arrayList.add(purchase);
                            } catch (JSONException e) {
                                return zzaQ(9, zzcj.zzk, 51, y.ٲٴݴ״ٰ(1781659152), e);
                            }
                        }
                        if (z) {
                            zzbe(26, 9, zzcj.zzk);
                        }
                        str2 = zzi.getString(y.ٴسسݬߨ(1392831186));
                        com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.ݮڮֲڭܩ(-629088500).concat(String.valueOf(str2)));
                    } else {
                        return zzaQ(9, zza2, zza.zzb(), y.٬ݯح׭٩(576137398), null);
                    }
                } else {
                    return zzaQ(9, zzcj.zzm, 119, "Service has been reset to null", null);
                }
            } catch (DeadObjectException e2) {
                return zzaQ(9, zzcj.zzm, 52, y.ٲٴݴ״ٰ(1781660440), e2);
            } catch (Exception e3) {
                return zzaQ(9, zzcj.zzk, 52, y.ٲٴݴ״ٰ(1781660440), e3);
            }
        } while (!TextUtils.isEmpty(str2));
        return new zzcv(zzcj.zzl, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzdc zzaS(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), str, exc);
        zzbf(i, 8, billingResult, zzcg.zza(exc));
        return new zzdc(billingResult.getResponseCode(), billingResult.getDebugMessage(), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaT(BillingResult billingResult, int i, int i2) {
        int responseCode = billingResult.getResponseCode();
        zzkd zzkdVar = null;
        zzjz zzjzVar = null;
        String str = y.ٲٴݴ״ٰ(1781660376);
        String str2 = y.ݮڮֲڭܩ(-629091700);
        if (responseCode != 0) {
            int i3 = zzcg.zza;
            try {
                zzjx zzc = zzjz.zzc();
                zzke zzc2 = zzki.zzc();
                zzc2.zzn(billingResult.getResponseCode());
                zzc2.zzm(billingResult.getDebugMessage());
                zzc2.zzo(i);
                zzc.zza(zzc2);
                zzc.zzn(5);
                zzky zzc3 = zzlb.zzc();
                zzc3.zza(i2);
                zzc.zzm((zzlb) zzc3.zzf());
                zzjzVar = (zzjz) zzc.zzf();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zze.zzm(str2, str, e);
            }
            zzaF(zzjzVar);
            return;
        }
        int i4 = zzcg.zza;
        try {
            zzkb zzc4 = zzkd.zzc();
            zzc4.zzn(5);
            zzky zzc5 = zzlb.zzc();
            zzc5.zza(i2);
            zzc4.zza((zzlb) zzc5.zzf());
            zzkdVar = (zzkd) zzc4.zzf();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zze.zzm(str2, str, e2);
        }
        zzaG(zzkdVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaU(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, int i, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), y.دײܮڳܯ(2051925285), exc);
        zzbf(i, 3, billingResult, zzcg.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaV(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 14, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaW(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, int i, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), str2, exc);
        zzbf(i, 4, billingResult, zzcg.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaX(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 15, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaY(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 24, billingResult, zzcg.zza(exc));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(billingResult, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzaZ(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 23, billingResult, zzcg.zza(exc));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(billingResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ boolean zzaq(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Handler zzax() {
        return Looper.myLooper() == null ? this.zzd : new Handler(Looper.myLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzbk zzay(String str) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.ݬֲ֮ܲت(1512950735).concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzd = com.google.android.gms.internal.play_billing.zze.zzd(this.zzo, this.zzw, this.zzB.isEnabledForOneTimeProducts(), this.zzB.isEnabledForPrepaidPlans(), this.zzc, this.zzF.longValue());
        String str2 = null;
        while (this.zzm) {
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar != null) {
                    Bundle zzh = zzanVar.zzh(6, this.zzf.getPackageName(), str, str2, zzd);
                    zzcx zza = zzcy.zza(zzh, y.ٴسسݬߨ(1392804282), y.ٲٴݴ״ٰ(1781660760));
                    BillingResult zza2 = zza.zza();
                    if (zza2 == zzcj.zzl) {
                        ArrayList<String> stringArrayList = zzh.getStringArrayList(y.ٲٴݴ״ٰ(1781658200));
                        ArrayList<String> stringArrayList2 = zzh.getStringArrayList(y.֬ڱܱײٮ(-1159417055));
                        ArrayList<String> stringArrayList3 = zzh.getStringArrayList(y.ٲٴݴ״ٰ(1781658104));
                        boolean z = false;
                        for (int i = 0; i < stringArrayList2.size(); i++) {
                            String str3 = stringArrayList2.get(i);
                            String str4 = stringArrayList3.get(i);
                            com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.ٴسسݬߨ(1392829346).concat(String.valueOf(stringArrayList.get(i))));
                            try {
                                PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                                if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                                    com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ٴسسݬߨ(1392830490));
                                    z = true;
                                }
                                arrayList.add(purchaseHistoryRecord);
                            } catch (JSONException e) {
                                return zzaP(zzcj.zzk, 51, y.ٲٴݴ״ٰ(1781659152), e);
                            }
                        }
                        if (z) {
                            zzbe(26, 11, zzcj.zzk);
                        }
                        str2 = zzh.getString(y.ٴسسݬߨ(1392831186));
                        com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.ݮڮֲڭܩ(-629088500).concat(String.valueOf(str2)));
                        if (TextUtils.isEmpty(str2)) {
                            return new zzbk(zzcj.zzl, arrayList);
                        }
                    } else {
                        zzbe(zza.zzb(), 11, zza2);
                        return new zzbk(zza2, null);
                    }
                } else {
                    return zzaP(zzcj.zzm, 119, "Service reset to null", null);
                }
            } catch (DeadObjectException e2) {
                return zzaP(zzcj.zzm, 59, y.٬ݯح׭٩(576141630), e2);
            } catch (Exception e3) {
                return zzaP(zzcj.zzk, 59, y.٬ݯح׭٩(576141630), e3);
            }
        }
        com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.دײܮڳܯ(2051924965));
        return new zzbk(zzcj.zzq, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final BillingResult zzaz() {
        com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.֬ڱܱײٮ(-1159421119));
        zzkb zzc = zzkd.zzc();
        zzc.zzn(6);
        zzlv zzc2 = zzlx.zzc();
        zzc2.zza(true);
        zzc.zzm(zzc2);
        zzaG((zzkd) zzc.zzf());
        return zzcj.zzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzba(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 25, billingResult, zzcg.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzbb(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, int i, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), y.ٴسسݬߨ(1392834658), exc);
        zzbf(i, 13, billingResult, zzcg.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzbc(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 16, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzbd(int i, int i2, Exception exc) {
        zzjz zzjzVar;
        com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), y.دײܮڳܯ(2051930925), exc);
        zzch zzchVar = this.zzg;
        String zza = zzcg.zza(exc);
        try {
            zzke zzc = zzki.zzc();
            zzc.zzn(i);
            zzc.zzo(i2);
            if (zza != null) {
                zzc.zza(zza);
            }
            zzjx zzc2 = zzjz.zzc();
            zzc2.zza(zzc);
            zzc2.zzn(30);
            zzjzVar = (zzjz) zzc2.zzf();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", th);
            zzjzVar = null;
        }
        zzchVar.zza(zzjzVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void zzbe(int i, int i2, BillingResult billingResult) {
        try {
            zzaF(zzcg.zzb(i, i2, billingResult));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzbf(int i, int i2, BillingResult billingResult, String str) {
        try {
            zzaF(zzcg.zzc(i, i2, billingResult, str));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void zzbg(int i) {
        try {
            zzaG(zzcg.zzd(i));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm(y.ٴسسݬߨ(1392804282), y.ٴسسݬߨ(1392807986), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            zzbe(2, 3, zzcj.zzm);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzm);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", y.ٲٴݴ״ٰ(1781654840));
            zzbe(26, 3, zzcj.zzj);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzj);
        } else if (!this.zzo) {
            zzbe(27, 3, zzcj.zzb);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzb);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzt
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzs(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzu
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzab(acknowledgePurchaseResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult zzaA = zzaA();
            zzbe(25, 3, zzaA);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzaA);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            zzbe(2, 4, zzcj.zzm);
            consumeResponseListener.onConsumeResponse(zzcj.zzm, consumeParams.getPurchaseToken());
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzag
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzt(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzah
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzad(consumeResponseListener, consumeParams);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult zzaA = zzaA();
            zzbe(25, 4, zzaA);
            consumeResponseListener.onConsumeResponse(zzaA, consumeParams.getPurchaseToken());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (!isReady()) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ٲٴݴ״ٰ(1781654648));
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzE, 66, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzx
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzx(alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzy
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzae(alternativeBillingOnlyReportingDetailsListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzaA(), 25, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        if (!isReady()) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ݮڮֲڭܩ(-629096084));
            zzaY(externalOfferReportingDetailsListener, zzcj.zzx, 103, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzaa
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzy(externalOfferReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaj
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaf(externalOfferReportingDetailsListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaY(externalOfferReportingDetailsListener, zzaA(), 25, null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(3:3|4|(1:6))|8|9|10|11|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0025, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0026, code lost:
    
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "There was an exception while unbinding from the service while ending connection!", r1);
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void endConnection() {
        /*
            r5 = this;
            r0 = 12
            r5.zzbg(r0)
            java.lang.Object r0 = r5.zza
            monitor-enter(r0)
            com.android.billingclient.api.zzn r1 = r5.zze     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto L1a
            com.android.billingclient.api.zzn r1 = r5.zze     // Catch: java.lang.Throwable -> L12
            r1.zzf()     // Catch: java.lang.Throwable -> L12
            goto L1a
        L12:
            r1 = move-exception
            java.lang.String r2 = "BillingClient"
            java.lang.String r3 = "There was an exception while shutting down broadcast manager while ending connection!"
            com.google.android.gms.internal.play_billing.zze.zzm(r2, r3, r1)     // Catch: java.lang.Throwable -> L45
        L1a:
            java.lang.String r1 = "BillingClient"
            java.lang.String r2 = "Unbinding from service."
            com.google.android.gms.internal.play_billing.zze.zzk(r1, r2)     // Catch: java.lang.Throwable -> L25
            r5.zzaL()     // Catch: java.lang.Throwable -> L25
            goto L2d
        L25:
            r1 = move-exception
            java.lang.String r2 = "BillingClient"
            java.lang.String r3 = "There was an exception while unbinding from the service while ending connection!"
            com.google.android.gms.internal.play_billing.zze.zzm(r2, r3, r1)     // Catch: java.lang.Throwable -> L45
        L2d:
            r1 = 3
            r5.zzaK()     // Catch: java.lang.Throwable -> L35
        L31:
            r5.zzaJ(r1)     // Catch: java.lang.Throwable -> L45
            goto L3e
        L35:
            r2 = move-exception
            java.lang.String r3 = "BillingClient"
            java.lang.String r4 = "There was an exception while shutting down the executor service while ending connection!"
            com.google.android.gms.internal.play_billing.zze.zzm(r3, r4, r2)     // Catch: java.lang.Throwable -> L40
            goto L31
        L3e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            return
        L40:
            r2 = move-exception
            r5.zzaJ(r1)     // Catch: java.lang.Throwable -> L45
            throw r2     // Catch: java.lang.Throwable -> L45
        L45:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            throw r1
            fill-array 0x0048: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.endConnection():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        boolean isReady = isReady();
        String str = y.ٴسسݬߨ(1392804282);
        if (!isReady) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, "Service disconnected.");
            zzbe(2, 13, zzcj.zzm);
            billingConfigResponseListener.onBillingConfigResponse(zzcj.zzm, null);
        } else if (!this.zzv) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, "Current client doesn't support get billing config.");
            zzbe(32, 13, zzcj.zzA);
            billingConfigResponseListener.onBillingConfigResponse(zzcj.zzA, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzv
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzu(billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzw
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzag(billingConfigResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult zzaA = zzaA();
            zzbe(25, 13, zzaA);
            billingConfigResponseListener.onBillingConfigResponse(zzaA, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        int i;
        synchronized (this.zza) {
            i = this.zzb;
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (!isReady()) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ٲٴݴ״ٰ(1781654648));
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzE, 66, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzad
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzz(alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzah(alternativeBillingOnlyAvailabilityListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzaA(), 25, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (!isReady()) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ݮڮֲڭܩ(-629096084));
            zzaZ(externalOfferAvailabilityListener, zzcj.zzx, 103, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzap
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzA(externalOfferAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaq
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzai(externalOfferAvailabilityListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaZ(externalOfferAvailabilityListener, zzaA(), 25, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        char c;
        if (!isReady()) {
            BillingResult billingResult = zzcj.zzm;
            if (billingResult.getResponseCode() != 0) {
                zzbe(2, 5, billingResult);
            } else {
                zzbg(5);
            }
            return zzcj.zzm;
        }
        int i = zzcj.zzH;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(y.ۮڭڭܬި(861968619))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 96321:
                if (str.equals(y.ٴسسݬߨ(1392833002))) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 97314:
                if (str.equals(y.٬ݯح׭٩(576140734))) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 98307:
                if (str.equals(y.ٲٴݴ״ٰ(1781657200))) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 99300:
                if (str.equals(y.ٴسسݬߨ(1392832866))) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 100293:
                if (str.equals(y.ݮڮֲڭܩ(-629095100))) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 101286:
                if (str.equals(y.دײܮڳܯ(2051928733))) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 102279:
                if (str.equals(y.ٴسسݬߨ(1392832666))) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 103272:
                if (str.equals(y.ٴسسݬߨ(1392832706))) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 104265:
                if (str.equals(y.دײܮڳܯ(2051928581))) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 105258:
                if (str.equals(y.ݮڮֲڭܩ(-629095396))) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 106251:
                if (str.equals(y.٬ݯح׭٩(576140310))) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 107244:
                if (str.equals(y.ݬֲ֮ܲت(1512954983))) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 207616302:
                if (str.equals(y.ۮڭڭܬި(861969923))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1987365622:
                if (str.equals(y.ۮڭڭܬި(861970315))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                BillingResult billingResult2 = this.zzj ? zzcj.zzl : zzcj.zzo;
                zzaT(billingResult2, 9, 2);
                return billingResult2;
            case 1:
                BillingResult billingResult3 = this.zzk ? zzcj.zzl : zzcj.zzp;
                zzaT(billingResult3, 10, 3);
                return billingResult3;
            case 2:
                BillingResult billingResult4 = this.zzn ? zzcj.zzl : zzcj.zzr;
                zzaT(billingResult4, 35, 4);
                return billingResult4;
            case 3:
                BillingResult billingResult5 = this.zzq ? zzcj.zzl : zzcj.zzw;
                zzaT(billingResult5, 30, 5);
                return billingResult5;
            case 4:
                BillingResult billingResult6 = this.zzs ? zzcj.zzl : zzcj.zzs;
                zzaT(billingResult6, 31, 6);
                return billingResult6;
            case 5:
                BillingResult billingResult7 = this.zzr ? zzcj.zzl : zzcj.zzu;
                zzaT(billingResult7, 21, 7);
                return billingResult7;
            case 6:
                BillingResult billingResult8 = this.zzt ? zzcj.zzl : zzcj.zzt;
                zzaT(billingResult8, 19, 8);
                return billingResult8;
            case 7:
                BillingResult billingResult9 = this.zzt ? zzcj.zzl : zzcj.zzt;
                zzaT(billingResult9, 61, 9);
                return billingResult9;
            case '\b':
                BillingResult billingResult10 = this.zzu ? zzcj.zzl : zzcj.zzv;
                zzaT(billingResult10, 20, 10);
                return billingResult10;
            case '\t':
                BillingResult billingResult11 = this.zzv ? zzcj.zzl : zzcj.zzA;
                zzaT(billingResult11, 32, 11);
                return billingResult11;
            case '\n':
                BillingResult billingResult12 = this.zzv ? zzcj.zzl : zzcj.zzB;
                zzaT(billingResult12, 33, 12);
                return billingResult12;
            case 11:
                BillingResult billingResult13 = this.zzx ? zzcj.zzl : zzcj.zzD;
                zzaT(billingResult13, 60, 13);
                return billingResult13;
            case '\f':
                BillingResult billingResult14 = this.zzy ? zzcj.zzl : zzcj.zzE;
                zzaT(billingResult14, 66, 14);
                return billingResult14;
            case '\r':
                BillingResult billingResult15 = this.zzz ? zzcj.zzl : zzcj.zzx;
                zzaT(billingResult15, 103, 18);
                return billingResult15;
            case 14:
                BillingResult billingResult16 = this.zzA ? zzcj.zzl : zzcj.zzy;
                zzaT(billingResult16, 116, 19);
                return billingResult16;
            default:
                com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ٴسسݬߨ(1392833242).concat(String.valueOf(str)));
                zzaT(zzcj.zzz, 34, 1);
                return zzcj.zzz;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzb == 2 && this.zzh != null && this.zzi != null) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x064c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0572 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0520  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r33, final com.android.billingclient.api.BillingFlowParams r34) {
        /*
            Method dump skipped, instructions count: 1744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            zzbe(2, 7, zzcj.zzm);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zzm, new ArrayList());
        } else if (!this.zzu) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", y.دײܮڳܯ(2051920797));
            zzbe(20, 7, zzcj.zzv);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zzv, new ArrayList());
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzam
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzbj zzh = BillingClientImpl.this.zzh(queryProductDetailsParams);
                productDetailsResponseListener.onProductDetailsResponse(zzcj.zza(zzh.zza(), zzh.zzb()), zzh.zzc());
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzan
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaj(productDetailsResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult zzaA = zzaA();
            zzbe(25, 7, zzaA);
            productDetailsResponseListener.onProductDetailsResponse(zzaA, new ArrayList());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzaH(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzaI(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            zzbe(2, 8, zzcj.zzm);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzm, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        boolean isEmpty = TextUtils.isEmpty(skuType);
        String str = y.ٴسسݬߨ(1392804282);
        if (isEmpty) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, "Please fix the input params. SKU type can't be empty.");
            zzbe(49, 8, zzcj.zzg);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzg, null);
        } else if (skusList == null) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, "Please fix the input params. The list of SKUs can't be empty.");
            zzbe(48, 8, zzcj.zzf);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzf, null);
        } else {
            final String str2 = null;
            if (zzE(new Callable(skuType, skusList, str2, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzz
                public final /* synthetic */ String zzb;
                public final /* synthetic */ List zzc;
                public final /* synthetic */ SkuDetailsResponseListener zzd;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    this.zzd = skuDetailsResponseListener;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdc zzn = BillingClientImpl.this.zzn(this.zzb, this.zzc, null);
                    this.zzd.onSkuDetailsResponse(zzcj.zza(zzn.zza(), zzn.zzb()), zzn.zzc());
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzab
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzam(skuDetailsResponseListener);
                }
            }, zzax(), zzaD()) == null) {
                BillingResult zzaA = zzaA();
                zzbe(25, 8, zzaA);
                skuDetailsResponseListener.onSkuDetailsResponse(zzaA, null);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        boolean isReady = isReady();
        String str = y.ٴسسݬߨ(1392804282);
        if (!isReady) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, "Service disconnected.");
            return zzcj.zzm;
        }
        if (!this.zzq) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, "Current client doesn't support showing in-app messages.");
            return zzcj.zzw;
        }
        View findViewById = activity.findViewById(R.id.content);
        IBinder windowToken = findViewById.getWindowToken();
        Rect rect = new Rect();
        findViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, y.ٲٴݴ״ٰ(1781648472), windowToken);
        bundle.putInt(y.ۮڭڭܬި(861977323), rect.left);
        bundle.putInt(y.ٲٴݴ״ٰ(1781609288), rect.top);
        bundle.putInt(y.ٲٴݴ״ٰ(1781609408), rect.right);
        bundle.putInt(y.ٴسسݬߨ(1392782594), rect.bottom);
        bundle.putString(y.ٲٴݴ״ٰ(1781609208), this.zzc);
        bundle.putIntegerArrayList(y.֬ڱܱײٮ(-1159433223), inAppMessageParams.zza());
        final zzav zzavVar = new zzav(this, this.zzd, inAppMessageResponseListener);
        zzE(new Callable() { // from class: com.android.billingclient.api.zzao
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzv(bundle, activity, zzavVar);
                return null;
            }
        }, 5000L, null, this.zzd, zzaD());
        return zzcj.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Void zzA(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaZ(externalOfferAvailabilityListener, zzcj.zzm, 119, null);
            } else {
                zzanVar.zzs(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbh(externalOfferAvailabilityListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzm, 91, e);
        } catch (Exception e2) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzk, 91, e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Void zzB(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzm, 119, null);
            } else {
                zzanVar.zzo(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbd(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzm, 74, e);
        } catch (Exception e2) {
            zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzk, 74, e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Void zzC(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzba(externalOfferInformationDialogListener, zzcj.zzm, 119, null);
            } else {
                zzanVar.zzq(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbf(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzba(externalOfferInformationDialogListener, zzcj.zzm, 98, e);
        } catch (Exception e2) {
            zzba(externalOfferInformationDialogListener, zzcj.zzk, 98, e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzab(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzbe(24, 3, zzcj.zzn);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzn);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzac(BillingResult billingResult) {
        if (this.zze.zzd() != null) {
            this.zze.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", y.ݮڮֲڭܩ(-629140740));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzad(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzbe(24, 4, zzcj.zzn);
        consumeResponseListener.onConsumeResponse(zzcj.zzn, consumeParams.getPurchaseToken());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzae(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzn, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzaf(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        zzaY(externalOfferReportingDetailsListener, zzcj.zzn, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzag(BillingConfigResponseListener billingConfigResponseListener) {
        zzbe(24, 13, zzcj.zzn);
        billingConfigResponseListener.onBillingConfigResponse(zzcj.zzn, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzah(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzn, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzai(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        zzaZ(externalOfferAvailabilityListener, zzcj.zzn, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzaj(ProductDetailsResponseListener productDetailsResponseListener) {
        zzbe(24, 7, zzcj.zzn);
        productDetailsResponseListener.onProductDetailsResponse(zzcj.zzn, new ArrayList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzak(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzbe(24, 11, zzcj.zzn);
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzcj.zzn, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzal(PurchasesResponseListener purchasesResponseListener) {
        zzbe(24, 9, zzcj.zzn);
        purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzn, com.google.android.gms.internal.play_billing.zzco.zzl());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzam(SkuDetailsResponseListener skuDetailsResponseListener) {
        zzbe(24, 8, zzcj.zzn);
        skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzn, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzan(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzn, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzao(ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        zzba(externalOfferInformationDialogListener, zzcj.zzn, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Bundle zzd(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                return com.google.android.gms.internal.play_billing.zze.zzn(zzcj.zzm, 119);
            }
            return zzanVar.zzg(i, this.zzf.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzm, 5, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzk, 5, zzcg.zza(e2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Bundle zze(String str, String str2) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                return com.google.android.gms.internal.play_billing.zze.zzn(zzcj.zzm, 119);
            }
            return zzanVar.zzf(3, this.zzf.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzm, 5, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzk, 5, zzcg.zza(e2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzbj zzh(QueryProductDetailsParams queryProductDetailsParams) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        ArrayList arrayList = new ArrayList();
        String zzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzco zza = queryProductDetailsParams.zza();
        int size = zza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList arrayList2 = new ArrayList(zza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(((QueryProductDetailsParams.Product) arrayList2.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(y.ٲٴݴ״ٰ(1781612296), arrayList3);
            bundle.putString(y.ٲٴݴ״ٰ(1781609208), this.zzc);
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar != null) {
                    int i4 = true != this.zzx ? 17 : 20;
                    String packageName = this.zzf.getPackageName();
                    boolean zzaM = zzaM();
                    String str = this.zzc;
                    zzaB(queryProductDetailsParams);
                    zzaB(queryProductDetailsParams);
                    zzaB(queryProductDetailsParams);
                    zzaB(queryProductDetailsParams);
                    long longValue = this.zzF.longValue();
                    Bundle bundle2 = new Bundle();
                    com.google.android.gms.internal.play_billing.zze.zzc(bundle2, str, longValue);
                    bundle2.putBoolean("enablePendingPurchases", true);
                    bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                    if (zzaM) {
                        bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                    }
                    ArrayList<String> arrayList4 = new ArrayList<>();
                    ArrayList<String> arrayList5 = new ArrayList<>();
                    int size3 = arrayList2.size();
                    int i5 = 0;
                    boolean z = false;
                    boolean z2 = false;
                    while (i5 < size3) {
                        QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList2.get(i5);
                        arrayList4.add(null);
                        z |= !TextUtils.isEmpty(null);
                        String zzb2 = product.zzb();
                        ArrayList arrayList6 = arrayList2;
                        if (zzb2.equals("first_party")) {
                            com.google.android.gms.internal.play_billing.zzbe.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                            arrayList5.add(null);
                            z2 = true;
                        }
                        i5++;
                        arrayList2 = arrayList6;
                    }
                    if (z) {
                        bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                    }
                    if (!arrayList5.isEmpty()) {
                        bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                    }
                    if (z2 && !TextUtils.isEmpty(null)) {
                        bundle2.putString("accountName", null);
                    }
                    Bundle zzl = zzanVar.zzl(i4, packageName, zzb, bundle, bundle2);
                    if (zzl != null) {
                        if (zzl.containsKey(y.دײܮڳܯ(2051874829))) {
                            ArrayList<String> stringArrayList = zzl.getStringArrayList(y.دײܮڳܯ(2051874829));
                            if (stringArrayList != null) {
                                for (int i6 = 0; i6 < stringArrayList.size(); i6++) {
                                    try {
                                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i6));
                                        com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.֬ڱܱײٮ(-1159436903).concat(productDetails.toString()));
                                        arrayList.add(productDetails);
                                    } catch (JSONException e) {
                                        return zzaO(zzcj.zza(6, y.دײܮڳܯ(2051881773)), 47, y.دײܮڳܯ(2051880973), e);
                                    }
                                }
                                i = i2;
                            } else {
                                return zzaO(zzcj.zzC, 46, y.ٲٴݴ״ٰ(1781607344), null);
                            }
                        } else {
                            int zzb3 = com.google.android.gms.internal.play_billing.zze.zzb(zzl, y.ٴسسݬߨ(1392804282));
                            String zzh = com.google.android.gms.internal.play_billing.zze.zzh(zzl, y.ٴسسݬߨ(1392804282));
                            if (zzb3 != 0) {
                                return zzaO(zzcj.zza(zzb3, zzh), 23, y.٬ݯح׭٩(576186078) + zzb3, null);
                            }
                            return zzaO(zzcj.zza(6, zzh), 45, y.٬ݯح׭٩(576190766), null);
                        }
                    } else {
                        return zzaO(zzcj.zzC, 44, y.دײܮڳܯ(2051875581), null);
                    }
                } else {
                    return zzaO(zzcj.zzm, 119, "Service has been reset to null.", null);
                }
            } catch (DeadObjectException e2) {
                return zzaO(zzcj.zzm, 43, y.٬ݯح׭٩(576188958), e2);
            } catch (Exception e3) {
                return zzaO(zzcj.zzk, 43, y.٬ݯح׭٩(576188958), e3);
            }
        }
        return new zzbj(0, "", arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final BillingResult zzm(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzd.post(new Runnable() { // from class: com.android.billingclient.api.zzp
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzac(billingResult);
            }
        });
        return billingResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzdc zzn(String str, List list, String str2) {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        Bundle zzk;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i, i2 > size ? size : i2));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(y.ٲٴݴ״ٰ(1781612296), arrayList2);
            bundle.putString(y.ٲٴݴ״ٰ(1781609208), this.zzc);
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar == null) {
                    return zzaS(zzcj.zzm, 119, "Service has been reset to null.", null);
                }
                if (this.zzp) {
                    String packageName = this.zzf.getPackageName();
                    int i3 = this.zzl;
                    boolean isEnabledForOneTimeProducts = this.zzB.isEnabledForOneTimeProducts();
                    boolean zzaM = zzaM();
                    String str3 = this.zzc;
                    long longValue = this.zzF.longValue();
                    Bundle bundle2 = new Bundle();
                    if (i3 >= 9) {
                        com.google.android.gms.internal.play_billing.zze.zzc(bundle2, str3, longValue);
                    }
                    if (i3 >= 9 && isEnabledForOneTimeProducts) {
                        bundle2.putBoolean("enablePendingPurchases", true);
                    }
                    if (zzaM) {
                        bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                    }
                    zzk = zzanVar.zzl(10, packageName, str, bundle, bundle2);
                } else {
                    zzk = zzanVar.zzk(3, this.zzf.getPackageName(), str, bundle);
                }
                if (zzk != null) {
                    if (zzk.containsKey(y.دײܮڳܯ(2051874829))) {
                        ArrayList<String> stringArrayList = zzk.getStringArrayList(y.دײܮڳܯ(2051874829));
                        if (stringArrayList != null) {
                            for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                                try {
                                    SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                                    com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.ٲٴݴ״ٰ(1781600872).concat(skuDetails.toString()));
                                    arrayList.add(skuDetails);
                                } catch (JSONException e) {
                                    return zzaS(zzcj.zza(6, y.دײܮڳܯ(2051881773)), 47, y.֬ڱܱײٮ(-1159441623), e);
                                }
                            }
                            i = i2;
                        } else {
                            return zzaS(zzcj.zzC, 46, y.ٴسسݬߨ(1392775154), null);
                        }
                    } else {
                        int zzb = com.google.android.gms.internal.play_billing.zze.zzb(zzk, y.ٴسسݬߨ(1392804282));
                        String zzh = com.google.android.gms.internal.play_billing.zze.zzh(zzk, y.ٴسسݬߨ(1392804282));
                        if (zzb != 0) {
                            return zzaS(zzcj.zza(zzb, zzh), 23, y.֬ڱܱײٮ(-1159435031) + zzb, null);
                        }
                        return zzaS(zzcj.zza(6, zzh), 45, y.ۮڭڭܬި(861952555), null);
                    }
                } else {
                    return zzaS(zzcj.zzC, 44, y.ݬֲ֮ܲت(1512905679), null);
                }
            } catch (DeadObjectException e2) {
                return zzaS(zzcj.zzm, 43, y.٬ݯح׭٩(576179494), e2);
            } catch (Exception e3) {
                return zzaS(zzcj.zzk, 43, y.٬ݯح׭٩(576179494), e3);
            }
        }
        return new zzdc(0, "", arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final synchronized zzev zzp() {
        if (this.zzE == null) {
            this.zzE = zzfb.zza(zzaD());
        }
        return this.zzE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Object zzs(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaU(acknowledgePurchaseResponseListener, zzcj.zzm, 119, null);
                return null;
            }
            String packageName = this.zzf.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzc;
            long longValue = this.zzF.longValue();
            Bundle bundle = new Bundle();
            com.google.android.gms.internal.play_billing.zze.zzc(bundle, str, longValue);
            Bundle zzd = zzanVar.zzd(9, packageName, purchaseToken, bundle);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zza(com.google.android.gms.internal.play_billing.zze.zzb(zzd, y.ٴسسݬߨ(1392804282)), com.google.android.gms.internal.play_billing.zze.zzh(zzd, y.ٴسسݬߨ(1392804282))));
            return null;
        } catch (DeadObjectException e) {
            zzaU(acknowledgePurchaseResponseListener, zzcj.zzm, 28, e);
            return null;
        } catch (Exception e2) {
            zzaU(acknowledgePurchaseResponseListener, zzcj.zzk, 28, e2);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Object zzt(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        zzaE(consumeParams, consumeResponseListener);
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Object zzu(BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzbb(billingConfigResponseListener, zzcj.zzm, 119, null);
            } else {
                String packageName = this.zzf.getPackageName();
                String str = this.zzc;
                long longValue = this.zzF.longValue();
                Bundle bundle = new Bundle();
                com.google.android.gms.internal.play_billing.zze.zzc(bundle, str, longValue);
                zzanVar.zzp(18, packageName, bundle, new zzbe(billingConfigResponseListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e) {
            zzbb(billingConfigResponseListener, zzcj.zzm, 62, e);
        } catch (Exception e2) {
            zzbb(billingConfigResponseListener, zzcj.zzk, 62, e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Object zzv(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzbd(-1, 119, null);
            } else {
                zzanVar.zzt(12, this.zzf.getPackageName(), bundle, new zzbi(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzbd(-1, 118, e);
        } catch (Exception e2) {
            zzbd(6, 118, e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Void zzx(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, 119, null);
            } else {
                zzanVar.zzm(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbb(alternativeBillingOnlyReportingDetailsListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, 70, e);
        } catch (Exception e2) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzk, 70, e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Void zzy(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaY(externalOfferReportingDetailsListener, zzcj.zzm, 119, null);
            } else {
                zzanVar.zzn(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbc(externalOfferReportingDetailsListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzm, 94, e);
        } catch (Exception e2) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzk, 94, e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ Void zzz(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, 119, null);
            } else {
                zzanVar.zzr(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbg(alternativeBillingOnlyAvailabilityListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, 69, e);
        } catch (Exception e2) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzk, 69, e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzaH(str, purchaseHistoryResponseListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzaI(str, purchasesResponseListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!isReady()) {
            zzbe(2, 16, zzcj.zzm);
            return zzcj.zzm;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzbe(66, 16, zzcj.zzE);
            return zzcj.zzE;
        }
        final zzaw zzawVar = new zzaw(this, this.zzd, alternativeBillingOnlyInformationDialogListener);
        if (zzE(new Callable() { // from class: com.android.billingclient.api.zzr
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzB(alternativeBillingOnlyInformationDialogListener, activity, zzawVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzs
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzan(alternativeBillingOnlyInformationDialogListener);
            }
        }, this.zzd, zzaD()) == null) {
            BillingResult zzaA = zzaA();
            zzbe(25, 16, zzaA);
            return zzaA;
        }
        return zzcj.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!isReady()) {
            zzbe(2, 25, zzcj.zzm);
            return zzcj.zzm;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current Play Store version doesn't support external offer.");
            zzbe(103, 25, zzcj.zzx);
            return zzcj.zzx;
        }
        final zzax zzaxVar = new zzax(this, this.zzd, externalOfferInformationDialogListener);
        if (zzE(new Callable() { // from class: com.android.billingclient.api.zzai
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzC(externalOfferInformationDialogListener, activity, zzaxVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzak
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzao(externalOfferInformationDialogListener);
            }
        }, this.zzd, zzaD()) == null) {
            BillingResult zzaA = zzaA();
            zzbe(25, 25, zzaA);
            return zzaA;
        }
        return zzcj.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        BillingResult billingResult;
        synchronized (this.zza) {
            if (isReady()) {
                billingResult = zzaz();
            } else if (this.zzb == 1) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client is already in the process of connecting to billing service.");
                zzbe(37, 6, zzcj.zze);
                billingResult = zzcj.zze;
            } else if (this.zzb == 3) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                zzbe(38, 6, zzcj.zzm);
                billingResult = zzcj.zzm;
            } else {
                zzaJ(1);
                zzaL();
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Starting in-app billing setup.");
                this.zzi = new zzba(this, billingClientStateListener, null);
                Intent intent = new Intent(y.ٴسسݬߨ(1392783114));
                intent.setPackage(y.ݮڮֲڭܩ(-629138092));
                List<ResolveInfo> queryIntentServices = this.zzf.getPackageManager().queryIntentServices(intent, 0);
                int i = 41;
                if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                    ResolveInfo resolveInfo = queryIntentServices.get(0);
                    if (resolveInfo.serviceInfo != null) {
                        String str = resolveInfo.serviceInfo.packageName;
                        String str2 = resolveInfo.serviceInfo.name;
                        if (!Objects.equals(str, y.ݮڮֲڭܩ(-629138092)) || str2 == null) {
                            com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ٲٴݴ״ٰ(1781611264));
                        } else {
                            ComponentName componentName = new ComponentName(str, str2);
                            Intent intent2 = new Intent(intent);
                            intent2.setComponent(componentName);
                            intent2.putExtra(y.ٲٴݴ״ٰ(1781609208), this.zzc);
                            synchronized (this.zza) {
                                if (this.zzb == 2) {
                                    billingResult = zzaz();
                                } else if (this.zzb != 1) {
                                    com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                    zzbe(117, 6, zzcj.zzm);
                                    billingResult = zzcj.zzm;
                                } else {
                                    zzba zzbaVar = this.zzi;
                                    if (this.zzf.bindService(intent2, zzbaVar, 1)) {
                                        com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.دײܮڳܯ(2051877853));
                                        billingResult = null;
                                    } else {
                                        com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.دײܮڳܯ(2051877069));
                                        i = 39;
                                    }
                                }
                            }
                        }
                    } else {
                        com.google.android.gms.internal.play_billing.zze.zzl(y.ٴسسݬߨ(1392804282), y.ٲٴݴ״ٰ(1781611264));
                    }
                    i = 40;
                }
                zzaJ(0);
                com.google.android.gms.internal.play_billing.zze.zzk(y.ٴسسݬߨ(1392804282), y.ٲٴݴ״ٰ(1781611128));
                zzbe(i, 6, zzcj.zzc);
                billingResult = zzcj.zzc;
            }
        }
        if (billingResult != null) {
            billingClientStateListener.onBillingSetupFinished(billingResult);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = str;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, str, (zzch) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BillingClientImpl(String str) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BillingClientImpl(String str, Context context, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        Long valueOf = Long.valueOf(new Random().nextLong());
        this.zzF = valueOf;
        String zzaC = zzaC();
        this.zzc = zzaC;
        this.zzf = context.getApplicationContext();
        zzks zzc = zzku.zzc();
        zzc.zzo(zzaC);
        zzc.zzn(this.zzf.getPackageName());
        zzc.zzm(valueOf.longValue());
        this.zzg = new zzcl(this.zzf, (zzku) zzc.zzf());
        this.zzf.getPackageName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, String str, zzch zzchVar) {
        this.zzf = context.getApplicationContext();
        zzks zzc = zzku.zzc();
        zzc.zzo(str);
        zzc.zzn(this.zzf.getPackageName());
        zzc.zzm(this.zzF.longValue());
        if (zzchVar != null) {
            this.zzg = zzchVar;
        } else {
            this.zzg = new zzcl(this.zzf, (zzku) zzc.zzf());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zze = new zzn(this.zzf, purchasesUpdatedListener, null, null, userChoiceBillingListener, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzC = userChoiceBillingListener != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzco zzcoVar, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        Long valueOf = Long.valueOf(new Random().nextLong());
        this.zzF = valueOf;
        this.zzc = zzaC();
        this.zzf = context.getApplicationContext();
        zzks zzc = zzku.zzc();
        zzc.zzo(zzaC());
        zzc.zzn(this.zzf.getPackageName());
        zzc.zzm(valueOf.longValue());
        this.zzg = new zzcl(this.zzf, (zzku) zzc.zzf());
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zze = new zzn(this.zzf, null, null, null, null, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzf.getPackageName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzch zzchVar, ExecutorService executorService) {
        String zzaC = zzaC();
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = zzaC;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, (zzb) null, zzaC, (zzch) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, zzaC(), null, userChoiceBillingListener, null, null);
    }
}
