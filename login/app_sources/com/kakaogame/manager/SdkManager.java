package com.kakaogame.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.kakaogame.Logger;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.AppUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkManager.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/manager/SdkManager;", "", "()V", "TAG", "", "<set-?>", "Lcom/kakaogame/manager/Version;", "appVersion", "getAppVersion", "()Lcom/kakaogame/manager/Version;", "", "isInitialized", "()Z", "isTestAppLaunching", RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "checkTestAppLaunching", "activity", "Landroid/app/Activity;", "getSdkVersion", "initialize", "", "context", "Landroid/content/Context;", "isTestMode", "setSdkVersion", "sdkVersionStr", "setTestModeApp", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SdkManager {
    private static final String TAG = "SdkManager";
    private static Version appVersion;
    private static boolean isInitialized;
    private static boolean isTestAppLaunching;
    public static final SdkManager INSTANCE = new SdkManager();
    private static Version sdkVersion = new Version(y.٬ݯح׭٩(576570206));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SdkManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isInitialized() {
        return isInitialized;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Version getAppVersion() {
        return appVersion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        isInitialized = true;
        appVersion = new Version(AndroidManifestUtil.getVersionName(context));
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051415181) + appVersion;
        String str2 = y.٬ݯح׭٩(576510790);
        logger.m699d(str2, str);
        Logger.INSTANCE.m699d(str2, y.ٲٴݴ״ٰ(1782186176) + sdkVersion);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setSdkVersion(String sdkVersionStr) {
        Intrinsics.checkNotNullParameter(sdkVersionStr, y.ݮڮֲڭܩ(-628412676));
        sdkVersion = new Version(sdkVersionStr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSdkVersion() {
        return sdkVersion.getVersion();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean checkTestAppLaunching(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (isTestAppLaunching) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            return false;
        }
        boolean booleanExtra = intent.getBooleanExtra(y.ݮڮֲڭܩ(-628413700), false);
        if (booleanExtra) {
            isTestAppLaunching = booleanExtra;
        }
        return isTestAppLaunching;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTestModeApp() {
        isTestAppLaunching = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isTestMode(Context context) {
        Intrinsics.checkNotNull(context);
        return AppUtil.isInstalledWithPackageName(context, y.ٲٴݴ״ٰ(1782187864)) || AppUtil.isInstalledWithPackageName(context, y.ۮڭڭܬި(862679155)) || AppUtil.isInstalledWithPackageName(context, y.ٴسسݬߨ(1393498538));
    }
}
