package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

/* loaded from: classes3.dex */
public class HFPStatus {

    /* renamed from: a */
    private Context f1169a;

    /* renamed from: d */
    private AudioManager f1172d;

    /* renamed from: b */
    private BroadcastReceiver f1170b = null;

    /* renamed from: c */
    private boolean f1171c = false;

    /* renamed from: e */
    private boolean f1173e = false;

    /* renamed from: f */
    private int f1174f = 1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HFPStatus(Context context) {
        this.f1172d = null;
        this.f1169a = context;
        this.f1172d = (AudioManager) context.getSystemService("audio");
        initHFPStatusJni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public void m732a() {
        if (this.f1173e) {
            this.f1173e = false;
            this.f1172d.stopBluetoothSco();
        }
    }

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m733b() {
        clearHFPStat();
        deinitHFPStatusJni();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void clearHFPStat() {
        BroadcastReceiver broadcastReceiver = this.f1170b;
        if (broadcastReceiver != null) {
            this.f1169a.unregisterReceiver(broadcastReceiver);
            this.f1170b = null;
        }
        this.f1174f = 1;
        m732a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean getHFPStat() {
        return this.f1174f == 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void requestHFPStat() {
        clearHFPStat();
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.unity3d.player.HFPStatus.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) != 1) {
                    return;
                }
                HFPStatus hFPStatus = HFPStatus.this;
                hFPStatus.f1174f = 2;
                hFPStatus.m732a();
                HFPStatus hFPStatus2 = HFPStatus.this;
                if (hFPStatus2.f1171c) {
                    hFPStatus2.f1172d.setMode(3);
                }
            }
        };
        this.f1170b = broadcastReceiver;
        this.f1169a.registerReceiver(broadcastReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.f1173e = true;
            this.f1172d.startBluetoothSco();
        } catch (NullPointerException unused) {
            AbstractC2768z.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setHFPRecordingStat(boolean z) {
        this.f1171c = z;
        if (z) {
            return;
        }
        this.f1172d.setMode(0);
    }
}
