package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public class ProxyBillingActivityV2 extends ComponentActivity {
    private ActivityResultLauncher zza;
    private ActivityResultLauncher zzb;
    private ResultReceiver zzc;
    private ResultReceiver zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        y.٬خݮ۳ݯ(this);
        super.onCreate(bundle);
        this.zza = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.android.billingclient.api.zzct
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProxyBillingActivityV2.this.zza((ActivityResult) obj);
            }
        });
        this.zzb = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.android.billingclient.api.zzcu
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProxyBillingActivityV2.this.zzb((ActivityResult) obj);
            }
        });
        String str = y.ݮڮֲڭܩ(-629120524);
        String str2 = y.ٲٴݴ״ٰ(1781615096);
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zze.zzk("ProxyBillingActivityV2", y.٬ݯح׭٩(576164934));
            Intent intent = getIntent();
            String str3 = y.دײܮڳܯ(2051888109);
            if (intent.hasExtra(str3)) {
                PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra(str3);
                this.zzc = (ResultReceiver) getIntent().getParcelableExtra(str2);
                this.zza.launch(new IntentSenderRequest.Builder(pendingIntent).build());
                return;
            }
            Intent intent2 = getIntent();
            String str4 = y.ݮڮֲڭܩ(-629119348);
            if (intent2.hasExtra(str4)) {
                PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra(str4);
                this.zzd = (ResultReceiver) getIntent().getParcelableExtra(str);
                this.zzb.launch(new IntentSenderRequest.Builder(pendingIntent2).build());
                return;
            }
            return;
        }
        if (bundle.containsKey(str2)) {
            this.zzc = (ResultReceiver) bundle.getParcelable(str2);
        } else if (bundle.containsKey(str)) {
            this.zzd = (ResultReceiver) bundle.getParcelable(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.zzc;
        if (resultReceiver != null) {
            bundle.putParcelable(y.ٲٴݴ״ٰ(1781615096), resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.zzd;
        if (resultReceiver2 != null) {
            bundle.putParcelable(y.ݮڮֲڭܩ(-629120524), resultReceiver2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        String str = y.ݬֲ֮ܲت(1512867719);
        int responseCode = com.google.android.gms.internal.play_billing.zze.zzf(data, str).getResponseCode();
        ResultReceiver resultReceiver = this.zzc;
        if (resultReceiver != null) {
            resultReceiver.send(responseCode, data == null ? null : data.getExtras());
        }
        if (activityResult.getResultCode() != -1 || responseCode != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, y.ٲٴݴ״ٰ(1781576648) + activityResult.getResultCode() + " and billing's responseCode: " + responseCode);
        }
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzb(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        String str = y.ݬֲ֮ܲت(1512867719);
        int responseCode = com.google.android.gms.internal.play_billing.zze.zzf(data, str).getResponseCode();
        ResultReceiver resultReceiver = this.zzd;
        if (resultReceiver != null) {
            resultReceiver.send(responseCode, data == null ? null : data.getExtras());
        }
        if (activityResult.getResultCode() != -1 || responseCode != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", Integer.valueOf(activityResult.getResultCode()), Integer.valueOf(responseCode)));
        }
        finish();
    }
}
