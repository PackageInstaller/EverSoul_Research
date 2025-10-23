package com.google.firebase.crashlytics.internal;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class DevelopmentPlatformProvider {
    private static final String FLUTTER_ASSET_FILE = "flutter_assets/NOTICES.Z";
    private static final String FLUTTER_PLATFORM = "Flutter";
    private static final String UNITY_PLATFORM = "Unity";
    private static final String UNITY_VERSION_FIELD = "com.google.firebase.crashlytics.unity_version";
    private final Context context;
    private DevelopmentPlatform developmentPlatform = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DevelopmentPlatformProvider(Context context) {
        this.context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDevelopmentPlatform() {
        return initDevelopmentPlatform().developmentPlatform;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDevelopmentPlatformVersion() {
        return initDevelopmentPlatform().developmentPlatformVersion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isUnity(Context context) {
        return CommonUtils.getResourcesIdentifier(context, UNITY_VERSION_FIELD, TypedValues.Custom.S_STRING) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean assetFileExists(String str) {
        if (this.context.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.context.getAssets().open(str);
            if (open == null) {
                return true;
            }
            open.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DevelopmentPlatform initDevelopmentPlatform() {
        if (this.developmentPlatform == null) {
            this.developmentPlatform = new DevelopmentPlatform();
        }
        return this.developmentPlatform;
    }

    private class DevelopmentPlatform {
        private final String developmentPlatform;
        private final String developmentPlatformVersion;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DevelopmentPlatform() {
            int resourcesIdentifier = CommonUtils.getResourcesIdentifier(DevelopmentPlatformProvider.this.context, DevelopmentPlatformProvider.UNITY_VERSION_FIELD, TypedValues.Custom.S_STRING);
            if (resourcesIdentifier == 0) {
                if (DevelopmentPlatformProvider.this.assetFileExists(DevelopmentPlatformProvider.FLUTTER_ASSET_FILE)) {
                    this.developmentPlatform = DevelopmentPlatformProvider.FLUTTER_PLATFORM;
                    this.developmentPlatformVersion = null;
                    Logger.getLogger().m396v("Development platform is: Flutter");
                    return;
                } else {
                    this.developmentPlatform = null;
                    this.developmentPlatformVersion = null;
                    return;
                }
            }
            this.developmentPlatform = DevelopmentPlatformProvider.UNITY_PLATFORM;
            String string = DevelopmentPlatformProvider.this.context.getResources().getString(resourcesIdentifier);
            this.developmentPlatformVersion = string;
            Logger.getLogger().m396v("Unity Editor version is: " + string);
        }
    }
}
