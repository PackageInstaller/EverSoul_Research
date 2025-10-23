package com.unity3d.player;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.security.CertificateUtil;
import com.unity3d.player.UnityPermissions;
import com.unity3d.player.p030a.AbstractC2708e;
import com.unity3d.player.p030a.C2709f;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class UnityPlayer extends FrameLayout implements IUnityPlayerLifecycleEvents {
    private static final String ARCORE_ENABLE_METADATA_NAME = "unity.arcore-enable";
    private static final String AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME = "unity.auto-report-fully-drawn";
    private static final String LAUNCH_FULLSCREEN = "unity.launch-fullscreen";
    private static final int RUN_STATE_CHANGED_MSG_CODE = 2269;
    private static final String SPLASH_ENABLE_METADATA_NAME = "unity.splash-enable";
    private static final String SPLASH_MODE_METADATA_NAME = "unity.splash-mode";
    public static Activity currentActivity;
    public static Context currentContext;
    private Activity mActivity;
    private Context mContext;
    private C2734i0 mGlView;
    Handler mHandler;
    private int mInitialScreenOrientation;
    private boolean mIsFullscreen;
    private boolean mMainDisplayOverride;
    private int mNaturalOrientation;
    private InterfaceC2658E mOnHandleFocusListener;
    private OrientationEventListener mOrientationListener;
    private boolean mProcessKillRequested;
    private boolean mQuitting;
    AbstractC2687S mSoftInput;
    private long mSoftInputTimeoutMilliSeconds;
    private C2696W0 mState;
    private C2735i1 mVideoPlayerProxy;
    private GoogleARCoreApi m_ARCoreApi;
    private boolean m_AddPhoneCallListener;
    private AudioVolumeHandler m_AudioVolumeHandler;
    private Camera2Wrapper m_Camera2Wrapper;
    private ClipboardManager m_ClipboardManager;
    private final ConcurrentLinkedQueue m_Events;
    private C2684Q0 m_FakeListener;
    private HFPStatus m_HFPStatus;
    private int m_IsNoWindowMode;
    C2692U0 m_MainThread;
    private NetworkConnectivity m_NetworkConnectivity;
    private C2654C m_OnBackPressedDispatcher;
    private OrientationLockListener m_OrientationLockListener;
    private C2686R0 m_PhoneCallListener;
    private C2709f m_SplashScreen;
    private TelephonyManager m_TelephonyManager;
    private IUnityPlayerLifecycleEvents m_UnityPlayerLifecycleEvents;
    Window m_Window;
    private Uri m_launchUri;
    private Configuration prevConfig;

    public enum SynchronizationTimeout {
        Pause(0),
        SurfaceDetach(1),
        Destroy(2);

        private int m_TimeoutMilliseconds = 2000;
        final int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SynchronizationTimeout(int i) {
            this.value = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setTimeoutForAll(int i) {
            for (SynchronizationTimeout synchronizationTimeout : (SynchronizationTimeout[]) SynchronizationTimeout.class.getEnumConstants()) {
                synchronizationTimeout.setTimeout(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getTimeout() {
            return this.m_TimeoutMilliseconds;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setTimeout(int i) {
            this.m_TimeoutMilliseconds = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        new C2728g0().m790a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnityPlayer(Context context) {
        this(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnityPlayer(Context context, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents) {
        super(context);
        this.mHandler = new Handler();
        this.mInitialScreenOrientation = -1;
        this.mMainDisplayOverride = false;
        this.mIsFullscreen = true;
        this.mState = new C2696W0();
        this.m_Events = new ConcurrentLinkedQueue();
        this.mOrientationListener = null;
        this.m_MainThread = new C2692U0(this);
        this.m_AddPhoneCallListener = false;
        this.m_PhoneCallListener = new C2686R0(this);
        this.m_ARCoreApi = null;
        this.m_FakeListener = new C2684Q0();
        this.m_Camera2Wrapper = null;
        this.m_HFPStatus = null;
        this.m_AudioVolumeHandler = null;
        this.m_OrientationLockListener = null;
        this.m_launchUri = null;
        this.m_NetworkConnectivity = null;
        this.m_OnBackPressedDispatcher = null;
        this.m_UnityPlayerLifecycleEvents = null;
        this.m_IsNoWindowMode = -1;
        this.mSoftInputTimeoutMilliSeconds = 1000L;
        this.mProcessKillRequested = true;
        this.mSoftInput = null;
        this.m_UnityPlayerLifecycleEvents = iUnityPlayerLifecycleEvents == null ? this : iUnityPlayerLifecycleEvents;
        C2728g0.m789a(getUnityNativeLibraryPath(context));
        currentContext = context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.mActivity = activity;
            currentActivity = activity;
            this.mInitialScreenOrientation = activity.getRequestedOrientation();
            this.m_launchUri = this.mActivity.getIntent().getData();
        }
        this.mContext = context;
        EarlyEnableFullScreenIfEnabled();
        Configuration configuration = getResources().getConfiguration();
        this.prevConfig = configuration;
        this.mNaturalOrientation = getNaturalOrientation(configuration.orientation);
        if (this.mActivity != null && getSplashEnabled()) {
            C2709f c2709f = new C2709f(this.mContext, AbstractC2708e.m776a()[getSplashMode()]);
            this.m_SplashScreen = c2709f;
            addView(c2709f);
        }
        preloadJavaPlugins();
        String loadNative = loadNative(getUnityNativeLibraryPath(this.mContext));
        if (!C2696W0.m762d()) {
            AbstractC2768z.Log(6, "Your hardware does not support this application.");
            AlertDialog create = new AlertDialog.Builder(this.mContext).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterfaceOnClickListenerC2763w0(this)).setMessage("Your hardware does not support this application.\n\n" + loadNative + "\n\n Press OK to quit.").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(context);
        this.mState.m771d(true);
        C2734i0 c2734i0 = new C2734i0(context, this);
        this.mGlView = c2734i0;
        addView(c2734i0);
        bringChildToFront(this.m_SplashScreen);
        this.mQuitting = false;
        Activity activity2 = this.mActivity;
        if (activity2 != null) {
            this.m_Window = activity2.getWindow();
        }
        hideStatusBar();
        this.m_TelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        this.m_ClipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
        this.m_Camera2Wrapper = new Camera2Wrapper(this.mContext);
        this.m_HFPStatus = new HFPStatus(this.mContext);
        this.m_MainThread.start();
        this.m_OnBackPressedDispatcher = C2656D.m731a(this.mActivity, 1, new RunnableC2665H0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void DisableStaticSplashScreen() {
        runOnUiThread(new RunnableC2670J0(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void EarlyEnableFullScreenIfEnabled() {
        View decorView;
        Activity activity = this.mActivity;
        if (activity != null && activity.getWindow() != null && ((getLaunchFullscreen() || this.mActivity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) && (decorView = this.mActivity.getWindow().getDecorView()) != null)) {
            decorView.setSystemUiVisibility(7);
        }
        AbstractC2764x.m835a(this.mActivity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String GetGlViewContentDescription(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", TypedValues.Custom.S_STRING, context.getPackageName()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean IsWindowTranslucent() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void UnitySendMessage(String str, String str2, String str3) {
        if (!C2696W0.m762d()) {
            AbstractC2768z.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
        } else {
            try {
                nativeUnitySendMessage(str, str2, str3.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkResumePlayer() {
        Activity activity = this.mActivity;
        if (this.mState.m766a(activity != null ? MultiWindowSupport.isInMultiWindowMode(activity) : false)) {
            this.mState.m769c(true);
            queueGLThreadEvent(new RunnableC2739k0(this));
            this.m_MainThread.m760a(EnumC2688S0.f1262b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dismissSoftInput() {
        AbstractC2687S abstractC2687S = this.mSoftInput;
        if (abstractC2687S != null) {
            abstractC2687S.mo751c();
            nativeReportKeyboardConfigChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void finish() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.mActivity.finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean getARCoreEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(ARCORE_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ActivityInfo getActivityInfo() {
        return this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 128);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ApplicationInfo getApplicationInfo() {
        return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getAutoReportFullyDrawnEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getHaveAndroidWindowSupport() {
        if (this.m_IsNoWindowMode == -1) {
            this.m_IsNoWindowMode = nativeGetNoWindowMode() ? 1 : 0;
        }
        return this.m_IsNoWindowMode == 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean getLaunchFullscreen() {
        try {
            return getApplicationInfo().metaData.getBoolean(LAUNCH_FULLSCREEN);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int getNaturalOrientation(int i) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if ((rotation == 0 || rotation == 2) && i == 2) {
            return 0;
        }
        return ((rotation == 1 || rotation == 3) && i == 1) ? 0 : 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String getProcessName() {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long getSoftInputTimeout() {
        return Math.round(this.mSoftInputTimeoutMilliSeconds * Math.max(1.0f, Settings.System.getFloat(this.mContext.getContentResolver(), "animator_duration_scale", 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getSplashEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(SPLASH_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getUnityNativeLibraryPath(Context context) {
        return context.getApplicationInfo().nativeLibraryDir;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void hidePreservedContent() {
        runOnUiThread(new RunnableC2745n0(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void hideStatusBar() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    private final native void initJni(Context context);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String loadNative(String str) {
        String str2 = str + "/libmain.so";
        try {
            try {
                try {
                    System.load(str2);
                    com.liapp.y.٬خݮ۳ݯ(str2);
                } catch (UnsatisfiedLinkError unused) {
                    System.loadLibrary("main");
                    com.liapp.y.٬خݮ۳ݯ("main");
                }
                if (NativeLoader.load(str)) {
                    C2696W0.m763e();
                    return "";
                }
                AbstractC2768z.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
                return "NativeLoader.load failure, Unity libraries were not loaded.";
            } catch (SecurityException e) {
                return logLoadLibMainError(str2, e.toString());
            }
        } catch (UnsatisfiedLinkError e2) {
            return logLoadLibMainError(str2, e2.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String logLoadLibMainError(String str, String str2) {
        String str3 = "Failed to load 'libmain.so'\n\n" + str2;
        AbstractC2768z.Log(6, str3);
        return str3;
    }

    private final native void nativeApplicationUnload();

    private final native boolean nativeDone();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native boolean nativeGetNoWindowMode();

    private final native void nativeHidePreservedContent();

    private final native boolean nativeInjectEvent(InputEvent inputEvent, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeLowMemory();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeOrientationChanged(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativePause();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeRecreateGfxState(int i, Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeRender();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeReportKeyboardConfigChanged();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeResume();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSendSurfaceChangedEvent();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputArea(int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputSelection(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetKeyboardIsVisible(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetLaunchURL(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputCanceled();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void pauseUnity() {
        reportSoftInputStr(null, 1, true);
        C2654C c2654c = this.m_OnBackPressedDispatcher;
        if (c2654c != null) {
            c2654c.f1152c = c2654c.f1150a != null;
            c2654c.unregisterOnBackPressedCallback();
        }
        if (!this.mState.m770c() || this.mState.m768b()) {
            return;
        }
        if (C2696W0.m762d()) {
            Semaphore semaphore = new Semaphore(0);
            Runnable runnableC2680O0 = isFinishing() ? new RunnableC2680O0(this, semaphore) : new RunnableC2682P0(this, semaphore);
            C2692U0 c2692u0 = this.m_MainThread;
            if (c2692u0.f1278a != null) {
                c2692u0.m760a(EnumC2688S0.f1261a);
                Message.obtain(c2692u0.f1278a, runnableC2680O0).sendToTarget();
            }
            try {
                SynchronizationTimeout synchronizationTimeout = SynchronizationTimeout.Pause;
                if (!semaphore.tryAcquire(synchronizationTimeout.getTimeout(), TimeUnit.MILLISECONDS)) {
                    AbstractC2768z.Log(5, "Timeout (" + synchronizationTimeout.getTimeout() + " ms) while trying to pause the Unity Engine.");
                }
            } catch (InterruptedException unused) {
                AbstractC2768z.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
            }
        }
        this.mState.m769c(false);
        this.mState.m772e(true);
        if (this.m_AddPhoneCallListener) {
            this.m_TelephonyManager.listen(this.m_PhoneCallListener, 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void preloadJavaPlugins() {
        try {
            Class.forName("com.unity3d.JavaPluginPreloader");
        } catch (ClassNotFoundException unused) {
        } catch (LinkageError e) {
            AbstractC2768z.Log(6, "Java class preloading failed: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void queueDestroy() {
        AbstractC2768z.Log(4, "Queue Destroy");
        runOnUiThread(new RunnableC2678N0(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void queueGLThreadEvent(AbstractRunnableC2694V0 abstractRunnableC2694V0) {
        if (isFinishing()) {
            return;
        }
        queueGLThreadEvent((Runnable) abstractRunnableC2694V0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void raiseFocusListener(boolean z) {
        InterfaceC2658E interfaceC2658E = this.mOnHandleFocusListener;
        if (interfaceC2658E != null) {
            RunnableC2751q0 runnableC2751q0 = ((C2747o0) interfaceC2658E).f1428a;
            runnableC2751q0.f1434b = true;
            if (runnableC2751q0.f1433a) {
                runnableC2751q0.f1435c.release();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setBackButtonLeavesApp(boolean z) {
        C2654C c2654c = this.m_OnBackPressedDispatcher;
        if (c2654c != null) {
            if (!z) {
                c2654c.registerOnBackPressedCallback();
            } else {
                c2654c.unregisterOnBackPressedCallback();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void shutdown() {
        this.mProcessKillRequested = nativeDone();
        this.mState.m771d(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void startActivityIndicator(int i) {
        postOnUiThread(new RunnableC2663G0(this, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void stopActivityIndicator() {
        postOnUiThread(new RunnableC2668I0());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void swapViews(View view, View view2) {
        boolean z;
        if (this.mState.m768b()) {
            z = false;
        } else {
            setupUnityToBePaused();
            z = true;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof UnityPlayer) || ((UnityPlayer) parent) != this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(0);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            removeView(view2);
        }
        if (z) {
            setupUnityToBeResumed();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void unloadNative() {
        if (C2696W0.m762d()) {
            if (!NativeLoader.unload()) {
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            C2696W0.m764f();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean updateDisplayInternal(int i, Surface surface) {
        if (!C2696W0.m762d() || !this.mState.m765a()) {
            return false;
        }
        Semaphore semaphore = new Semaphore(0);
        RunnableC2674L0 runnableC2674L0 = new RunnableC2674L0(this, i, surface, semaphore);
        if (i == 0) {
            C2692U0 c2692u0 = this.m_MainThread;
            Handler handler = c2692u0.f1278a;
            if (surface == null) {
                if (handler != null) {
                    c2692u0.m760a(EnumC2688S0.f1264d);
                    Message.obtain(c2692u0.f1278a, runnableC2674L0).sendToTarget();
                }
            } else if (handler != null) {
                Message.obtain(handler, runnableC2674L0).sendToTarget();
                c2692u0.m760a(EnumC2688S0.f1265e);
            }
        } else {
            runnableC2674L0.run();
        }
        if (surface != null || i != 0) {
            return true;
        }
        try {
            SynchronizationTimeout synchronizationTimeout = SynchronizationTimeout.SurfaceDetach;
            if (semaphore.tryAcquire(synchronizationTimeout.getTimeout(), TimeUnit.MILLISECONDS)) {
                return true;
            }
            AbstractC2768z.Log(5, "Timeout (" + synchronizationTimeout.getTimeout() + " ms) while trying detaching primary window.");
            return true;
        } catch (InterruptedException unused) {
            AbstractC2768z.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
            return true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void addPhoneCallListener() {
        this.m_AddPhoneCallListener = true;
        this.m_TelephonyManager.listen(this.m_PhoneCallListener, 32);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean addViewToPlayer(View view, boolean z) {
        swapViews(view, z ? this.mGlView : null);
        boolean z2 = true;
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.mGlView.getParent() == null;
        boolean z5 = this.mGlView.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                AbstractC2768z.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                AbstractC2768z.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void configurationChanged(Configuration configuration) {
        int diff = this.prevConfig.diff(configuration);
        if ((diff & 256) != 0 || (diff & 1024) != 0 || (diff & 2048) != 0 || (diff & 128) != 0) {
            nativeHidePreservedContent();
        }
        this.prevConfig = new Configuration(configuration);
        C2735i1 c2735i1 = this.mVideoPlayerProxy;
        if (c2735i1 != null) {
            c2735i1.m797a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void destroy() {
        Camera2Wrapper camera2Wrapper = this.m_Camera2Wrapper;
        if (camera2Wrapper != null) {
            camera2Wrapper.m728a();
            this.m_Camera2Wrapper = null;
        }
        HFPStatus hFPStatus = this.m_HFPStatus;
        if (hFPStatus != null) {
            hFPStatus.m733b();
            this.m_HFPStatus = null;
        }
        NetworkConnectivity networkConnectivity = this.m_NetworkConnectivity;
        if (networkConnectivity != null) {
            networkConnectivity.mo736a();
            this.m_NetworkConnectivity = null;
        }
        C2654C c2654c = this.m_OnBackPressedDispatcher;
        if (c2654c != null) {
            c2654c.unregisterOnBackPressedCallback();
            this.m_OnBackPressedDispatcher = null;
        }
        this.mQuitting = true;
        if (!this.mState.m768b()) {
            setupUnityToBePaused();
        }
        this.m_MainThread.m760a(EnumC2688S0.f1263c);
        try {
            this.m_MainThread.join(SynchronizationTimeout.Destroy.getTimeout());
        } catch (InterruptedException unused) {
            this.m_MainThread.interrupt();
        }
        if (C2696W0.m762d()) {
            removeAllViews();
        }
        if (this.mProcessKillRequested) {
            this.m_UnityPlayerLifecycleEvents.onUnityPlayerQuitted();
            kill();
        }
        unloadNative();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void disableLogger() {
        AbstractC2768z.f1492a = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.mMainDisplayOverride = surface != null;
            runOnUiThread(new RunnableC2676M0(this));
        }
        return updateDisplayInternal(i, surface);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.m_Events.poll();
            if (runnable == null) {
                return;
            } else {
                runnable.run();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Activity getActivity() {
        return this.mActivity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String getClipboardText() {
        ClipData primaryClip = this.m_ClipboardManager.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.mContext).toString() : "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String getKeyboardLayout() {
        AbstractC2687S abstractC2687S = this.mSoftInput;
        if (abstractC2687S == null) {
            return null;
        }
        return abstractC2687S.m746a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String getLaunchURL() {
        Uri uri = this.m_launchUri;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getNetworkConnectivity() {
        NetworkConnectivity networkConnectivity = this.m_NetworkConnectivity;
        if (networkConnectivity != null) {
            return networkConnectivity.mo737b();
        }
        this.m_NetworkConnectivity = PlatformSupport.NOUGAT_SUPPORT ? new NetworkConnectivityNougat(this.mContext) : new NetworkConnectivity(this.mContext);
        return this.m_NetworkConnectivity.mo737b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getNetworkProxySettings(String str) {
        String str2;
        String str3;
        if (!str.startsWith("http:")) {
            if (str.startsWith("https:")) {
                str2 = "https.proxyHost";
                str3 = "https.proxyPort";
            }
            return null;
        }
        str2 = "http.proxyHost";
        str3 = "http.proxyPort";
        String property = System.getProperties().getProperty(str2);
        if (property != null && !"".equals(property)) {
            StringBuilder sb = new StringBuilder(property);
            String property2 = System.getProperties().getProperty(str3);
            if (property2 != null && !"".equals(property2)) {
                sb.append(CertificateUtil.DELIMITER).append(property2);
            }
            String property3 = System.getProperties().getProperty("http.nonProxyHosts");
            if (property3 != null && !"".equals(property3)) {
                sb.append('\n').append(property3);
            }
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getScreenBrightness() {
        Window window = this.m_Window;
        if (window == null) {
            return 1.0f;
        }
        float f = window.getAttributes().screenBrightness;
        if (f >= 0.0f) {
            return f;
        }
        int i = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness", 255);
        return PlatformSupport.PIE_SUPPORT ? (float) Math.max(0.0d, Math.min(1.0d, ((Math.log(i) * 19.811d) - 9.411d) / 100.0d)) : i / 255.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getSplashMode() {
        try {
            return getApplicationInfo().metaData.getInt(SPLASH_MODE_METADATA_NAME);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getUaaLLaunchProcessType() {
        String processName = getProcessName();
        return (processName == null || processName.equals(this.mContext.getPackageName())) ? 0 : 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public View getView() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void hideSoftInput() {
        if (this.mSoftInput == null) {
            return;
        }
        reportSoftInputArea(new Rect());
        reportSoftInputIsVisible(false);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            dismissSoftInput();
            return;
        }
        Semaphore semaphore = new Semaphore(0);
        postOnUiThread(new RunnableC2751q0(this, semaphore, this));
        try {
            try {
                if (!semaphore.tryAcquire(getSoftInputTimeout(), TimeUnit.MILLISECONDS)) {
                    AbstractC2768z.Log(6, "Timeout (" + getSoftInputTimeout() + " ms) while waiting softinput hiding operation.");
                }
            } catch (InterruptedException unused) {
                AbstractC2768z.Log(6, "UI thread got interrupted while waiting softinput hiding operation.");
            }
        } finally {
            this.mSoftInput = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void init(int i, boolean z) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean initializeGoogleAr() {
        if (this.m_ARCoreApi != null || this.mActivity == null || !getARCoreEnabled()) {
            return false;
        }
        GoogleARCoreApi googleARCoreApi = new GoogleARCoreApi();
        this.m_ARCoreApi = googleARCoreApi;
        googleARCoreApi.initializeARCore(this.mActivity);
        if (this.mState.m768b()) {
            return false;
        }
        this.m_ARCoreApi.resumeARCore();
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean injectEvent(InputEvent inputEvent) {
        return injectEvent(inputEvent, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean injectEvent(InputEvent inputEvent, int i) {
        if (C2696W0.m762d()) {
            return nativeInjectEvent(inputEvent, i);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean isFinishing() {
        if (this.mQuitting) {
            return true;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mQuitting = activity.isFinishing();
        }
        return this.mQuitting;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean isUaaLUseCase() {
        String callingPackage;
        Activity activity = this.mActivity;
        return (activity == null || (callingPackage = activity.getCallingPackage()) == null || !callingPackage.equals(this.mContext.getPackageName())) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void kill() {
        Process.killProcess(Process.myPid());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            com.liapp.y.٬خݮ۳ݯ(str);
            return true;
        } catch (Exception | UnsatisfiedLinkError unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void lowMemory() {
        if (C2696W0.m762d()) {
            queueGLThreadEvent(new RunnableC2737j0(this));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void newIntent(Intent intent) {
        this.m_launchUri = intent.getData();
        this.m_MainThread.m760a(EnumC2688S0.f1269i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mGlView.m796c()) {
            return false;
        }
        return injectEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onPause() {
        MultiWindowSupport.saveMultiWindowMode(this.mActivity);
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            return;
        }
        setupUnityToBePaused();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onResume() {
        if (!MultiWindowSupport.isInMultiWindowMode(this.mActivity) || MultiWindowSupport.isMultiWindowModeChangedToTrue(this.mActivity)) {
            setupUnityToBeResumed();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onStart() {
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            setupUnityToBeResumed();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onStop() {
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            setupUnityToBePaused();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mGlView.m796c()) {
            return false;
        }
        return injectEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void pause() {
        setupUnityToBePaused();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void pauseJavaAndCallUnloadCallback() {
        runOnUiThread(new RunnableC2655C0(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void postOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void queueGLThreadEvent(Runnable runnable) {
        if (C2696W0.m762d()) {
            if (Thread.currentThread() == this.m_MainThread) {
                runnable.run();
            } else {
                this.m_Events.add(runnable);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void quit() {
        destroy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeViewFromPlayer(View view) {
        swapViews(this.mGlView, view);
        boolean z = view.getParent() == null;
        boolean z2 = this.mGlView.getParent() == this;
        if (z && z2) {
            return;
        }
        if (!z) {
            AbstractC2768z.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
        }
        if (z2) {
            return;
        }
        AbstractC2768z.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reportError(String str, String str2) {
        AbstractC2768z.Log(6, str + ": " + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void reportSoftInputArea(Rect rect) {
        queueGLThreadEvent((AbstractRunnableC2694V0) new C2767y0(this, rect));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void reportSoftInputIsVisible(boolean z) {
        queueGLThreadEvent((AbstractRunnableC2694V0) new C2769z0(this, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void reportSoftInputSelection(int i, int i2) {
        queueGLThreadEvent((AbstractRunnableC2694V0) new C2765x0(this, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void reportSoftInputStr(String str, int i, boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        queueGLThreadEvent((AbstractRunnableC2694V0) new C2761v0(this, z, str, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void requestUserAuthorization(String str) {
        if (str == null || str.isEmpty() || this.mActivity == null) {
            return;
        }
        UnityPermissions.ModalWaitForPermissionResponse modalWaitForPermissionResponse = new UnityPermissions.ModalWaitForPermissionResponse();
        UnityPermissions.requestUserPermissions(this.mActivity, new String[]{str}, modalWaitForPermissionResponse);
        modalWaitForPermissionResponse.waitForResponse();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resume() {
        setupUnityToBeResumed();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void runOnAnonymousThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void runOnUiThread(Runnable runnable) {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void sendSurfaceChangedEvent() {
        if (C2696W0.m762d() && this.mState.m765a()) {
            RunnableC2672K0 runnableC2672K0 = new RunnableC2672K0(this);
            Handler handler = this.m_MainThread.f1278a;
            if (handler != null) {
                Message.obtain(handler, runnableC2672K0).sendToTarget();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setCharacterLimit(int i) {
        runOnUiThread(new RunnableC2755s0(this, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setClipboardText(String str) {
        this.m_ClipboardManager.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setHideInputField(boolean z) {
        runOnUiThread(new RunnableC2757t0(this, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMainSurfaceViewAspectRatio(float f) {
        if (this.mGlView != null) {
            runOnUiThread(new RunnableC2659E0(this, f));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOnHandleFocusListener(InterfaceC2658E interfaceC2658E) {
        this.mOnHandleFocusListener = interfaceC2658E;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setScreenBrightness(float f) {
        float max = Math.max(0.04f, f);
        if (this.m_Window == null || getScreenBrightness() == max) {
            return;
        }
        runOnUiThread(new RunnableC2661F0(this, max));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setSelection(int i, int i2) {
        runOnUiThread(new RunnableC2759u0(this, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setSoftInputStr(String str) {
        runOnUiThread(new RunnableC2753r0(this, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setupUnityToBePaused() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        C2735i1 c2735i1 = this.mVideoPlayerProxy;
        if (c2735i1 != null) {
            c2735i1.m799b();
        }
        AudioVolumeHandler audioVolumeHandler = this.m_AudioVolumeHandler;
        if (audioVolumeHandler != null) {
            audioVolumeHandler.m727a();
            this.m_AudioVolumeHandler = null;
        }
        OrientationLockListener orientationLockListener = this.m_OrientationLockListener;
        if (orientationLockListener != null) {
            orientationLockListener.m738a();
            this.m_OrientationLockListener = null;
        }
        pauseUnity();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setupUnityToBeResumed() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.mState.m772e(false);
        C2735i1 c2735i1 = this.mVideoPlayerProxy;
        if (c2735i1 != null) {
            c2735i1.m800c();
        }
        checkResumePlayer();
        if (this.m_AudioVolumeHandler == null) {
            this.m_AudioVolumeHandler = new AudioVolumeHandler(this.mContext);
        }
        if (this.m_OrientationLockListener == null && C2696W0.m762d()) {
            this.m_OrientationLockListener = new OrientationLockListener(this.mContext);
        }
        C2654C c2654c = this.m_OnBackPressedDispatcher;
        if (c2654c != null && c2654c.f1152c) {
            c2654c.registerOnBackPressedCallback();
        }
        this.prevConfig = getResources().getConfiguration();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void showSoftInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        Semaphore semaphore = new Semaphore(0);
        postOnUiThread(new RunnableC2743m0(this, this, str, i, z, z2, z3, z4, str2, i2, z5, z6, semaphore));
        try {
            if (semaphore.tryAcquire(getSoftInputTimeout(), TimeUnit.MILLISECONDS)) {
                return;
            }
            AbstractC2768z.Log(6, "Timeout (" + getSoftInputTimeout() + " ms) while waiting softinput showing operation.");
        } catch (InterruptedException unused) {
            AbstractC2768z.Log(6, "UI thread got interrupted while waiting softinput showing operation.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.mVideoPlayerProxy == null) {
            this.mVideoPlayerProxy = new C2735i1(this);
        }
        boolean m798a = this.mVideoPlayerProxy.m798a(this.mContext, str, i, i2, i3, z, i4, i5, new C2651A0(this));
        if (m798a) {
            runOnUiThread(new RunnableC2653B0(this));
        }
        return m798a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean skipPermissionsDialog() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return UnityPermissions.skipPermissionsDialog(activity);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean startOrientationListener(int i) {
        String str;
        if (this.mOrientationListener != null) {
            str = "Orientation Listener already started.";
        } else {
            C2657D0 c2657d0 = new C2657D0(this, this.mContext, i);
            this.mOrientationListener = c2657d0;
            if (c2657d0.canDetectOrientation()) {
                this.mOrientationListener.enable();
                return true;
            }
            str = "Orientation Listener cannot detect orientation.";
        }
        AbstractC2768z.Log(5, str);
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean stopOrientationListener() {
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener == null) {
            AbstractC2768z.Log(5, "Orientation Listener was not started.");
            return false;
        }
        orientationEventListener.disable();
        this.mOrientationListener = null;
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.m_FakeListener, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.m_FakeListener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unload() {
        nativeApplicationUnload();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateGLDisplay(int i, Surface surface) {
        if (this.mMainDisplayOverride) {
            return;
        }
        updateDisplayInternal(i, surface);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void windowFocusChanged(boolean z) {
        AbstractC2687S abstractC2687S;
        this.mState.m767b(z);
        if (!this.mState.m765a() || ((abstractC2687S = this.mSoftInput) != null && !abstractC2687S.mo752d())) {
            raiseFocusListener(z);
            return;
        }
        this.m_MainThread.m760a(z ? EnumC2688S0.f1267g : EnumC2688S0.f1266f);
        raiseFocusListener(z);
        checkResumePlayer();
    }
}
