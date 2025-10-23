package com.kakaogame;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.LocaleManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.NetworkUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: KGSystem.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010'\u001a\u00020(2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u0017\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u000b¨\u0006,"}, m839d2 = {"Lcom/kakaogame/KGSystem;", "", "()V", "NETWORK_TYPE_CELLULAR", "", "NETWORK_TYPE_NETWORK", "NETWORK_TYPE_UNKNOWN", "TAG", "countryCode", "getCountryCode$annotations", "getCountryCode", "()Ljava/lang/String;", ServerConstants.DEVICE_APP_KEY, "getDeviceAppKey", ServerConstants.DEVICE_ID, "getDeviceId$annotations", "getDeviceId", ServerConstants.DEVICE_MODEL, "getDeviceModel$annotations", "getDeviceModel", "geoCountryCode", "getGeoCountryCode$annotations", "getGeoCountryCode", "isNetworkConnected", "", "isNetworkConnected$annotations", "()Z", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "getLanguageCode$annotations", "getLanguageCode", "languageTag", "getLanguageTag$annotations", "getLanguageTag", "networkType", "getNetworkType$annotations", "getNetworkType", "oSName", "getOSName$annotations", "getOSName", "updateLanguageCode", "", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGSystem {
    public static final KGSystem INSTANCE = new KGSystem();
    public static final String NETWORK_TYPE_CELLULAR = "cellular";
    public static final String NETWORK_TYPE_NETWORK = "wifi";
    public static final String NETWORK_TYPE_UNKNOWN = "unknown";
    private static final String TAG = "KGSystem";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getCountryCode$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getDeviceModel$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getGeoCountryCode$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getLanguageCode$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getLanguageTag$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getNetworkType$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getOSName() {
        return y.ٴسسݬߨ(1392813258);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getOSName$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isNetworkConnected$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGSystem() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getDeviceId() {
        try {
            return DeviceUtil.getDeviceId(CoreManager.INSTANCE.getInstance().getContext());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDeviceAppKey() {
        try {
            if (CoreManager.INSTANCE.getInstance().getAppId().length() == 0) {
                return "";
            }
            return DeviceUtil.getSSAID(CoreManager.INSTANCE.getInstance().getActivity()) + CoreManager.INSTANCE.getInstance().getAppId();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getNetworkType() {
        try {
            return CoreManager.INSTANCE.getInstance().getContext() == null ? "" : NetworkUtil.getNetworkType(CoreManager.INSTANCE.getInstance().getContext());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isNetworkConnected() {
        try {
            return NetworkUtil.INSTANCE.isNetworkConnected(CoreManager.INSTANCE.getInstance().getContext());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getCountryCode() {
        try {
            return LocaleManager.INSTANCE.getCountryCode();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getGeoCountryCode() {
        try {
            return LocaleManager.getGeoCountryCode();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getLanguageCode() {
        try {
            return LocaleManager.INSTANCE.getLanguageCode();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getLanguageTag() {
        try {
            return LocaleManager.INSTANCE.getLanguageTag();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getDeviceModel() {
        try {
            return DeviceUtil.getDeviceModel();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1781943128), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void updateLanguageCode(String languageCode, KGResultCallback<Void> callback) {
        KGResult<Void> updateLanguageCode = LocaleManager.INSTANCE.updateLanguageCode(CoreManager.INSTANCE.getInstance().getContext(), languageCode);
        if (callback != null) {
            callback.onResult(updateLanguageCode);
        }
    }
}
