package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackManagerFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/* renamed from: com.unity3d.player.n */
/* loaded from: classes3.dex */
final class C2744n {

    /* renamed from: d */
    private static C2744n f1419d;

    /* renamed from: a */
    private AssetPackManager f1420a;

    /* renamed from: b */
    private HashSet f1421b;

    /* renamed from: c */
    private Object f1422c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C2744n(Context context) {
        if (f1419d != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        this.f1420a = AssetPackManagerFactory.getInstance(context);
        this.f1421b = new HashSet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static C2744n m802a(Context context) {
        if (f1419d == null) {
            f1419d = new C2744n(context);
        }
        return f1419d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Object m803a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        C2730h c2730h = new C2730h(this, iAssetPackManagerDownloadStatusCallback, Looper.myLooper());
        this.f1420a.registerListener(c2730h);
        return c2730h;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final String m804a(String str) {
        AssetPackLocation packLocation = this.f1420a.getPackLocation(str);
        return packLocation == null ? "" : packLocation.assetsPath();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m805a(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.f1420a.showCellularDataConfirmation(activity).addOnSuccessListener(new C2736j(iAssetPackManagerMobileDataConfirmationCallback));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m806a(Object obj) {
        if (obj instanceof C2730h) {
            this.f1420a.unregisterListener((C2730h) obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m807a(String[] strArr) {
        this.f1420a.cancel(Arrays.asList(strArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m808a(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        for (String str : strArr) {
            this.f1420a.getPackStates(Collections.singletonList(str)).addOnCompleteListener(new C2738k(str, iAssetPackManagerDownloadStatusCallback));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m809a(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.f1420a.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C2742m(strArr, iAssetPackManagerStatusQueryCallback));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m810b(String str) {
        this.f1420a.removePack(str);
    }
}
