package com.unity3d.player;

import android.content.Context;
import com.unity3d.player.p030a.AbstractC2704a;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.m0 */
/* loaded from: classes3.dex */
final class RunnableC2743m0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1406a;

    /* renamed from: b */
    final /* synthetic */ String f1407b;

    /* renamed from: c */
    final /* synthetic */ int f1408c;

    /* renamed from: d */
    final /* synthetic */ boolean f1409d;

    /* renamed from: e */
    final /* synthetic */ boolean f1410e;

    /* renamed from: f */
    final /* synthetic */ boolean f1411f;

    /* renamed from: g */
    final /* synthetic */ boolean f1412g;

    /* renamed from: h */
    final /* synthetic */ String f1413h;

    /* renamed from: i */
    final /* synthetic */ int f1414i;

    /* renamed from: j */
    final /* synthetic */ boolean f1415j;

    /* renamed from: k */
    final /* synthetic */ boolean f1416k;

    /* renamed from: l */
    final /* synthetic */ Semaphore f1417l;

    /* renamed from: m */
    final /* synthetic */ UnityPlayer f1418m;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2743m0(UnityPlayer unityPlayer, UnityPlayer unityPlayer2, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6, Semaphore semaphore) {
        this.f1418m = unityPlayer;
        this.f1406a = unityPlayer2;
        this.f1407b = str;
        this.f1408c = i;
        this.f1409d = z;
        this.f1410e = z2;
        this.f1411f = z3;
        this.f1412g = z4;
        this.f1413h = str2;
        this.f1414i = i2;
        this.f1415j = z5;
        this.f1416k = z6;
        this.f1417l = semaphore;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        try {
            try {
                UnityPlayer unityPlayer = this.f1418m;
                if (unityPlayer.mSoftInput != null) {
                    unityPlayer.dismissSoftInput();
                }
                UnityPlayer unityPlayer2 = this.f1418m;
                int m755a = SoftInputProvider.m755a();
                context = this.f1418m.mContext;
                UnityPlayer unityPlayer3 = this.f1406a;
                unityPlayer2.mSoftInput = AbstractC2704a.m773a(m755a) != 2 ? new C2716c0(context, unityPlayer3) : new C2697X(context, unityPlayer3);
                this.f1418m.mSoftInput.mo747a(this.f1407b, this.f1408c, this.f1409d, this.f1410e, this.f1411f, this.f1412g, this.f1413h, this.f1414i, this.f1415j, this.f1416k);
                AbstractC2687S abstractC2687S = this.f1418m.mSoftInput;
                abstractC2687S.f1259f = new C2741l0(this);
                abstractC2687S.mo753e();
                this.f1418m.nativeReportKeyboardConfigChanged();
            } catch (Exception e) {
                AbstractC2768z.Log(6, "Exception when opening Softinput " + e);
            }
        } finally {
            this.f1417l.release();
        }
    }
}
