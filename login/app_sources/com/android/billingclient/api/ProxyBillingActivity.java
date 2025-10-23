package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {
    private static final String KEY_ACTIVITY_CODE = "activity_code";
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    static final String KEY_PRICE_CHANGE_RESULT_RECEIVER = "result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
    private static final String TAG = "ProxyBillingActivity";
    private int activityCode;
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    private ResultReceiver priceChangeResultReceiver;
    private boolean sendCancelledBroadcastIfFinished;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        y.ݯױܭ۱ݭ(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        y.ݱݬ׬۬ݨ(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent(y.دײܮڳܯ(2051886589));
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra(y.ۮڭڭܬި(861937699), str);
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Intent makePurchasesUpdatedIntent() {
        Intent intent = new Intent(y.ٴسسݬߨ(1392790042));
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        y.٬خݮ۳ݯ(this);
        super.onCreate(bundle);
        String str = y.٬ݯح׭٩(576161006);
        String str2 = y.֬ڱܱײٮ(-1159455527);
        String str3 = y.٬ݯح׭٩(576161494);
        String str4 = y.ۮڭڭܬި(861941003);
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zze.zzk(str4, y.ݬֲ֮ܲت(1512925431));
            this.activityCode = 100;
            Intent intent = getIntent();
            String str5 = y.ۮڭڭܬި(861969107);
            if (intent.hasExtra(str5)) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra(str5);
                if (getIntent().hasExtra(str) && getIntent().getBooleanExtra(str, false)) {
                    this.isFlowFromFirstPartyClient = true;
                    this.activityCode = 110;
                }
            } else {
                Intent intent2 = getIntent();
                String str6 = y.֬ڱܱײٮ(-1159462471);
                if (intent2.hasExtra(str6)) {
                    pendingIntent = (PendingIntent) getIntent().getParcelableExtra(str6);
                    this.priceChangeResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(str3);
                } else {
                    Intent intent3 = getIntent();
                    String str7 = y.ݬֲ֮ܲت(1512928991);
                    if (intent3.hasExtra(str7)) {
                        pendingIntent = (PendingIntent) getIntent().getParcelableExtra(str7);
                        this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(str2);
                        this.activityCode = 101;
                    } else {
                        pendingIntent = null;
                    }
                }
            }
            try {
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException e) {
                com.google.android.gms.internal.play_billing.zze.zzm(str4, y.֬ڱܱײٮ(-1159462719), e);
                ResultReceiver resultReceiver = this.priceChangeResultReceiver;
                if (resultReceiver != null) {
                    resultReceiver.send(6, null);
                } else {
                    ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
                    if (resultReceiver2 != null) {
                        resultReceiver2.send(0, null);
                    } else {
                        Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                        if (this.isFlowFromFirstPartyClient) {
                            makePurchasesUpdatedIntent.putExtra(y.ݮڮֲڭܩ(-629117956), true);
                        }
                        makePurchasesUpdatedIntent.putExtra(y.ݬֲ֮ܲت(1512928239), 6);
                        makePurchasesUpdatedIntent.putExtra(y.ݮڮֲڭܩ(-629117764), y.ۮڭڭܬި(861941275));
                        sendBroadcast(makePurchasesUpdatedIntent);
                    }
                }
                this.sendCancelledBroadcastIfFinished = false;
                finish();
                return;
            }
        }
        com.google.android.gms.internal.play_billing.zze.zzk(str4, y.ۮڭڭܬި(861941843));
        this.sendCancelledBroadcastIfFinished = bundle.getBoolean(y.ٴسسݬߨ(1392794466), false);
        if (bundle.containsKey(str3)) {
            this.priceChangeResultReceiver = (ResultReceiver) bundle.getParcelable(str3);
        } else if (bundle.containsKey(str2)) {
            this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable(str2);
        }
        this.isFlowFromFirstPartyClient = bundle.getBoolean(str, false);
        this.activityCode = bundle.getInt(y.ݬֲ֮ܲت(1512931319), 100);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            makePurchasesUpdatedIntent.putExtra(y.ݬֲ֮ܲت(1512928239), 1);
            makePurchasesUpdatedIntent.putExtra(y.ݮڮֲڭܩ(-629117764), y.֬ڱܱײٮ(-1159460391));
            int i = this.activityCode;
            if (i == 110 || i == 100) {
                makePurchasesUpdatedIntent.putExtra(y.٬ݯح׭٩(576160390), y.٬ݯح׭٩(576160318));
            }
            sendBroadcast(makePurchasesUpdatedIntent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.priceChangeResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable(y.٬ݯح׭٩(576161494), resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
        if (resultReceiver2 != null) {
            bundle.putParcelable(y.֬ڱܱײٮ(-1159455527), resultReceiver2);
        }
        bundle.putBoolean(y.ٴسسݬߨ(1392794466), this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean(y.٬ݯح׭٩(576161006), this.isFlowFromFirstPartyClient);
        bundle.putInt(y.ݬֲ֮ܲت(1512931319), this.activityCode);
    }
}
