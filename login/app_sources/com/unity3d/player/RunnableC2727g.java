package com.unity3d.player;

import java.util.Iterator;
import java.util.Set;

/* renamed from: com.unity3d.player.g */
/* loaded from: classes3.dex */
final class RunnableC2727g implements Runnable {

    /* renamed from: a */
    private Set f1362a;

    /* renamed from: b */
    private String f1363b;

    /* renamed from: c */
    private int f1364c;

    /* renamed from: d */
    private long f1365d;

    /* renamed from: e */
    private long f1366e;

    /* renamed from: f */
    private int f1367f;

    /* renamed from: g */
    private int f1368g;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2727g(Set set, String str, int i, long j, long j2, int i2, int i3) {
        this.f1362a = set;
        this.f1363b = str;
        this.f1364c = i;
        this.f1365d = j;
        this.f1366e = j2;
        this.f1367f = i2;
        this.f1368g = i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f1362a.iterator();
        while (it.hasNext()) {
            ((IAssetPackManagerDownloadStatusCallback) it.next()).onStatusUpdate(this.f1363b, this.f1364c, this.f1365d, this.f1366e, this.f1367f, this.f1368g);
        }
    }
}
