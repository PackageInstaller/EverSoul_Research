package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.unity3d.player.h */
/* loaded from: classes3.dex */
final class C2730h implements AssetPackStateUpdateListener {

    /* renamed from: a */
    private HashSet f1372a;

    /* renamed from: b */
    private Looper f1373b;

    /* renamed from: c */
    final /* synthetic */ C2744n f1374c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2730h(C2744n c2744n, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, Looper looper) {
        this.f1374c = c2744n;
        HashSet hashSet = new HashSet();
        this.f1372a = hashSet;
        hashSet.add(iAssetPackManagerDownloadStatusCallback);
        this.f1373b = looper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final synchronized void m791a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f1372a.add(iAssetPackManagerDownloadStatusCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onStateUpdate(Object obj) {
        C2744n c2744n;
        HashSet hashSet;
        HashSet hashSet2;
        Object obj2;
        AssetPackState assetPackState = (AssetPackState) obj;
        synchronized (this) {
            if (assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                c2744n = C2744n.f1419d;
                synchronized (c2744n) {
                    hashSet = this.f1374c.f1421b;
                    hashSet.remove(assetPackState.name());
                    hashSet2 = this.f1374c.f1421b;
                    if (hashSet2.isEmpty()) {
                        C2744n c2744n2 = this.f1374c;
                        obj2 = c2744n2.f1422c;
                        c2744n2.m806a(obj2);
                        this.f1374c.f1422c = null;
                    }
                }
            }
            if (this.f1372a.size() != 0) {
                new Handler(this.f1373b).post(new RunnableC2727g((Set) this.f1372a.clone(), assetPackState.name(), assetPackState.status(), assetPackState.totalBytesToDownload(), assetPackState.bytesDownloaded(), assetPackState.transferProgressPercentage(), assetPackState.errorCode()));
            }
        }
    }
}
