package com.google.android.gms.games.internal.p008v2.resolution;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.games_v2.zzez;
import com.liapp.y;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class GamesResolutionActivity extends Activity {
    private ResultReceiver zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(int i, Intent intent) {
        Bundle bundle;
        ResultReceiver resultReceiver = this.zza;
        if (resultReceiver == null) {
            return;
        }
        if (intent == null) {
            bundle = new Bundle();
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("resultData", intent);
            bundle = bundle2;
        }
        resultReceiver.send(i, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            zza(i2, intent);
            finish();
            return;
        }
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected request code: ");
        sb.append(i);
        zzez.zzc("ResultActivity", sb.toString());
        zza(0, intent);
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        y.٬خݮ۳ݯ(this);
        super.onCreate(bundle);
        if (bundle != null) {
            this.zza = (ResultReceiver) Preconditions.checkNotNull((ResultReceiver) bundle.getParcelable("resultReceiver"));
            return;
        }
        this.zza = (ResultReceiver) Preconditions.checkNotNull((ResultReceiver) getIntent().getParcelableExtra("resultReceiver"));
        try {
            startIntentSenderForResult(((PendingIntent) Preconditions.checkNotNull((PendingIntent) getIntent().getParcelableExtra(BaseGmsClient.KEY_PENDING_INTENT))).getIntentSender(), 0, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            zzez.zzd("ResultActivity", "Failed to launch", e);
            zza(0, null);
            finish();
        }
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
    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("resultReceiver", this.zza);
    }
}
