package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.unity3d.player.k */
/* loaded from: classes3.dex */
final class C2738k implements OnCompleteListener {

    /* renamed from: a */
    private IAssetPackManagerDownloadStatusCallback f1393a;

    /* renamed from: b */
    private Looper f1394b = Looper.myLooper();

    /* renamed from: c */
    private String f1395c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2738k(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f1393a = iAssetPackManagerDownloadStatusCallback;
        this.f1395c = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        C2744n c2744n;
        C2744n c2744n2;
        Object obj;
        HashSet hashSet;
        AssetPackManager assetPackManager;
        AssetPackManager assetPackManager2;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map packStates = assetPackStates.packStates();
            if (packStates.size() == 0) {
                return;
            }
            for (AssetPackState assetPackState : packStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                    String name = assetPackState.name();
                    int status = assetPackState.status();
                    int errorCode2 = assetPackState.errorCode();
                    long j = assetPackStates.totalBytes();
                    new Handler(this.f1394b).post(new RunnableC2727g(Collections.singleton(this.f1393a), name, status, j, status == 4 ? j : 0L, 0, errorCode2));
                } else {
                    c2744n = C2744n.f1419d;
                    String name2 = assetPackState.name();
                    IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.f1393a;
                    Looper looper = this.f1394b;
                    c2744n.getClass();
                    c2744n2 = C2744n.f1419d;
                    synchronized (c2744n2) {
                        obj = c2744n.f1422c;
                        if (obj == null) {
                            C2730h c2730h = new C2730h(c2744n, iAssetPackManagerDownloadStatusCallback, looper);
                            assetPackManager2 = c2744n.f1420a;
                            assetPackManager2.registerListener(c2730h);
                            c2744n.f1422c = c2730h;
                        } else {
                            ((C2730h) obj).m791a(iAssetPackManagerDownloadStatusCallback);
                        }
                        hashSet = c2744n.f1421b;
                        hashSet.add(name2);
                        assetPackManager = c2744n.f1420a;
                        assetPackManager.fetch(Collections.singletonList(name2));
                    }
                }
            }
        } catch (RuntimeExecutionException e) {
            e = e;
            String str = this.f1395c;
            while (true) {
                if (e instanceof AssetPackException) {
                    errorCode = e.getErrorCode();
                    break;
                }
                e = e.getCause();
                if (e == null) {
                    errorCode = -100;
                    break;
                }
            }
            new Handler(this.f1394b).post(new RunnableC2727g(Collections.singleton(this.f1393a), str, 0, 0L, 0L, 0, errorCode));
        }
    }
}
