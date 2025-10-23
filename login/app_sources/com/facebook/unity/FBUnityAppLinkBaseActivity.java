package com.facebook.unity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import com.liapp.y;

/* loaded from: classes.dex */
public abstract class FBUnityAppLinkBaseActivity extends Activity {
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
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Log.v(C0848FB.TAG, "Saving deep link from deep linking activity");
        C0848FB.SetIntent(getIntent());
        Log.v(C0848FB.TAG, "Returning to main activity");
        startActivity(new Intent(this, getMainActivityClass()));
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Class<?> getMainActivityClass() {
        try {
            return Class.forName(getPackageManager().getLaunchIntentForPackage(getPackageName()).getComponent().getClassName());
        } catch (Exception unused) {
            Log.e(C0848FB.TAG, "Unable to find Main Activity Class");
            return null;
        }
    }
}
