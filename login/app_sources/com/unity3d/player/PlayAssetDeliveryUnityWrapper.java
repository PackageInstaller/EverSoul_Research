package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.List;

/* loaded from: classes3.dex */
class PlayAssetDeliveryUnityWrapper {

    /* renamed from: b */
    private static PlayAssetDeliveryUnityWrapper f1218b;

    /* renamed from: a */
    private C2744n f1219a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PlayAssetDeliveryUnityWrapper(Context context) {
        this.f1219a = null;
        if (f1218b != null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper should be created only once. Use getInstance() instead.");
        }
        try {
            if (getClass().getClassLoader().loadClass("com.google.android.play.core.assetpacks.AssetPackManager").getMethod("getPackStates", List.class).getReturnType().getName().equals("com.google.android.gms.tasks.Task")) {
                this.f1219a = m740a(context);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private static C2744n m740a(Context context) {
        return C2744n.m802a(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private void m741a() {
        if (playCoreApiMissing()) {
            throw new RuntimeException("AssetPackManager API is not available! Make sure your gradle project includes 'com.google.android.play:asset-delivery' dependency.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized PlayAssetDeliveryUnityWrapper getInstance() {
        PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper;
        synchronized (PlayAssetDeliveryUnityWrapper.class) {
            while (true) {
                playAssetDeliveryUnityWrapper = f1218b;
                if (playAssetDeliveryUnityWrapper != null) {
                    break;
                }
                try {
                    PlayAssetDeliveryUnityWrapper.class.wait(3000L);
                } catch (InterruptedException e) {
                    AbstractC2768z.Log(6, e.getMessage());
                }
            }
            if (playAssetDeliveryUnityWrapper == null) {
                throw new RuntimeException("PlayAssetDeliveryUnityWrapper is not yet initialised.");
            }
        }
        return playAssetDeliveryUnityWrapper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized PlayAssetDeliveryUnityWrapper init(Context context) {
        PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper;
        synchronized (PlayAssetDeliveryUnityWrapper.class) {
            if (f1218b != null) {
                throw new RuntimeException("PlayAssetDeliveryUnityWrapper.init() should be called only once. Use getInstance() instead.");
            }
            f1218b = new PlayAssetDeliveryUnityWrapper(context);
            PlayAssetDeliveryUnityWrapper.class.notifyAll();
            playAssetDeliveryUnityWrapper = f1218b;
        }
        return playAssetDeliveryUnityWrapper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancelAssetPackDownload(String str) {
        cancelAssetPackDownloads(new String[]{str});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancelAssetPackDownloads(String[] strArr) {
        m741a();
        this.f1219a.m807a(strArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void downloadAssetPack(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        downloadAssetPacks(new String[]{str}, iAssetPackManagerDownloadStatusCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void downloadAssetPacks(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        m741a();
        this.f1219a.m808a(strArr, iAssetPackManagerDownloadStatusCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAssetPackPath(String str) {
        m741a();
        return this.f1219a.m804a(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getAssetPackState(String str, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        getAssetPackStates(new String[]{str}, iAssetPackManagerStatusQueryCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getAssetPackStates(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        m741a();
        this.f1219a.m809a(strArr, iAssetPackManagerStatusQueryCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean playCoreApiMissing() {
        return this.f1219a == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object registerDownloadStatusListener(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        m741a();
        return this.f1219a.m803a(iAssetPackManagerDownloadStatusCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeAssetPack(String str) {
        m741a();
        this.f1219a.m810b(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void requestToUseMobileData(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        m741a();
        this.f1219a.m805a(activity, iAssetPackManagerMobileDataConfirmationCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregisterDownloadStatusListener(Object obj) {
        m741a();
        this.f1219a.m806a(obj);
    }
}
