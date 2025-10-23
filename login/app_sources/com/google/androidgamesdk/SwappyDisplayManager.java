package com.google.androidgamesdk;

import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.liapp.y;

/* loaded from: classes2.dex */
public class SwappyDisplayManager implements DisplayManager.DisplayListener {
    private Activity mActivity;
    private long mCookie;
    private Display.Mode mCurrentMode;
    private C1189d mLooper;
    private WindowManager mWindowManager;
    private final String LOG_TAG = "SwappyDisplayManager";
    private final boolean DEBUG = false;
    private final long ONE_MS_IN_NS = 1000000;
    private final long ONE_S_IN_NS = 1000000000;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SwappyDisplayManager(long j, Activity activity) {
        String string;
        try {
            Bundle bundle = activity.getPackageManager().getActivityInfo(activity.getIntent().getComponent(), 128).metaData;
            if (bundle != null && (string = bundle.getString("android.app.lib_name")) != null) {
                y.٬خݮ۳ݯ(string);
            }
        } catch (Throwable th) {
            Log.e("SwappyDisplayManager", th.getMessage());
        }
        this.mCookie = j;
        this.mActivity = activity;
        WindowManager windowManager = (WindowManager) activity.getSystemService(WindowManager.class);
        this.mWindowManager = windowManager;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        this.mCurrentMode = defaultDisplay.getMode();
        updateSupportedRefreshRates(defaultDisplay);
        DisplayManager displayManager = (DisplayManager) this.mActivity.getSystemService(DisplayManager.class);
        synchronized (this) {
            C1189d c1189d = new C1189d();
            this.mLooper = c1189d;
            c1189d.start();
            displayManager.registerDisplayListener(this, this.mLooper.f281a);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean modeMatchesCurrentResolution(Display.Mode mode) {
        return mode.getPhysicalHeight() == this.mCurrentMode.getPhysicalHeight() && mode.getPhysicalWidth() == this.mCurrentMode.getPhysicalWidth();
    }

    private native void nOnRefreshPeriodChanged(long j, long j2, long j3, long j4);

    private native void nSetSupportedRefreshPeriods(long j, long[] jArr, int[] iArr);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateSupportedRefreshRates(Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        int i = 0;
        for (Display.Mode mode : supportedModes) {
            if (modeMatchesCurrentResolution(mode)) {
                i++;
            }
        }
        long[] jArr = new long[i];
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < supportedModes.length; i3++) {
            if (modeMatchesCurrentResolution(supportedModes[i3])) {
                jArr[i2] = (long) (1.0E9f / supportedModes[i3].getRefreshRate());
                iArr[i2] = supportedModes[i3].getModeId();
                i2++;
            }
        }
        nSetSupportedRefreshPeriods(this.mCookie, jArr, iArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i) {
        synchronized (this) {
            Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
            float refreshRate = defaultDisplay.getRefreshRate();
            Display.Mode mode = defaultDisplay.getMode();
            boolean z = true;
            boolean z2 = (mode.getPhysicalWidth() != this.mCurrentMode.getPhysicalWidth()) | (mode.getPhysicalHeight() != this.mCurrentMode.getPhysicalHeight());
            if (refreshRate == this.mCurrentMode.getRefreshRate()) {
                z = false;
            }
            this.mCurrentMode = mode;
            if (z2) {
                updateSupportedRefreshRates(defaultDisplay);
            }
            if (z) {
                long j = (long) (1.0E9f / refreshRate);
                nOnRefreshPeriodChanged(this.mCookie, j, defaultDisplay.getAppVsyncOffsetNanos(), j - (this.mWindowManager.getDefaultDisplay().getPresentationDeadlineNanos() - 1000000));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPreferredDisplayModeId(int i) {
        this.mActivity.runOnUiThread(new RunnableC1188c(this, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void terminate() {
        this.mLooper.f281a.getLooper().quit();
    }
}
