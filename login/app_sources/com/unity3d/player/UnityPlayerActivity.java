package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowMetrics;

/* loaded from: classes3.dex */
public class UnityPlayerActivity extends Activity implements IUnityPlayerLifecycleEvents {
    protected UnityPlayer mUnityPlayer;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.liapp.y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String updateUnityCommandLineArguments(String str) {
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getIntent().putExtra("unity", updateUnityCommandLineArguments(getIntent().getStringExtra("unity")));
        UnityPlayer unityPlayer = new UnityPlayer(this, this);
        this.mUnityPlayer = unityPlayer;
        setContentView(unityPlayer);
        this.mUnityPlayer.requestFocus();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
        moveTaskToBack(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        this.mUnityPlayer.newIntent(intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onDestroy() {
        this.mUnityPlayer.destroy();
        super.onDestroy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mUnityPlayer.onStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mUnityPlayer.onStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onPause() {
        com.liapp.y.ݯױܭ۱ݭ(this);
        super.onPause();
        this.mUnityPlayer.onPause();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onResume() {
        com.liapp.y.ݱݬ׬۬ݨ(this);
        super.onResume();
        this.mUnityPlayer.onResume();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mUnityPlayer.lowMemory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i == 15) {
            this.mUnityPlayer.lowMemory();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        DisplayCutout displayCutout;
        super.onConfigurationChanged(configuration);
        this.mUnityPlayer.configurationChanged(configuration);
        if (configuration.screenWidthDp == 0 || configuration.screenHeightDp == 0) {
            return;
        }
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (Build.VERSION.SDK_INT >= 31) {
            WindowMetrics currentWindowMetrics = getWindowManager().getCurrentWindowMetrics();
            i = currentWindowMetrics.getBounds().width();
            int height = currentWindowMetrics.getBounds().height();
            if (isInMultiWindowMode() || isInPictureInPictureMode() || (displayCutout = currentWindowMetrics.getWindowInsets().getDisplayCutout()) == null) {
                i2 = height;
            } else {
                int safeInsetTop = displayCutout.getSafeInsetTop();
                int safeInsetBottom = displayCutout.getSafeInsetBottom();
                i = (i - displayCutout.getSafeInsetLeft()) - displayCutout.getSafeInsetRight();
                i2 = (height - safeInsetTop) - safeInsetBottom;
            }
        }
        UnityPlayer.UnitySendMessage("Global", "OnScreenSizeChanged", i + "," + i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mUnityPlayer.windowFocusChanged(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 2) {
            return this.mUnityPlayer.injectEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mUnityPlayer.onKeyUp(i, keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mUnityPlayer.onKeyDown(i, keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mUnityPlayer.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return this.mUnityPlayer.onGenericMotionEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int OnEvent(Context context, int i, String str) {
        if (i != 1) {
            return 0;
        }
        UnityPlayer.UnitySendMessage("Global", "OnEvent", str);
        return 0;
    }
}
