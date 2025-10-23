package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import com.liapp.y;
import java.nio.ByteBuffer;

/* renamed from: org.fmod.a */
/* loaded from: classes.dex */
final class RunnableC2925a implements Runnable {

    /* renamed from: a */
    private final FMODAudioDevice f1543a;

    /* renamed from: b */
    private final ByteBuffer f1544b;

    /* renamed from: c */
    private final int f1545c;

    /* renamed from: d */
    private final int f1546d;

    /* renamed from: e */
    private volatile Thread f1547e;

    /* renamed from: f */
    private volatile boolean f1548f;

    /* renamed from: g */
    private AudioRecord f1549g;

    /* renamed from: h */
    private boolean f1550h;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2925a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f1543a = fMODAudioDevice;
        this.f1545c = i;
        this.f1546d = i2;
        this.f1544b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    private void m897b() {
        AudioRecord audioRecord = this.f1549g;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.f1549g.stop();
            }
            this.f1549g.release();
            this.f1549g = null;
        }
        this.f1544b.position(0);
        this.f1550h = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final int m898a() {
        return this.f1544b.capacity();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final void m899c() {
        if (this.f1547e != null) {
            m900d();
        }
        this.f1548f = true;
        this.f1547e = new Thread(this);
        this.f1547e.start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final void m900d() {
        while (this.f1547e != null) {
            this.f1548f = false;
            try {
                this.f1547e.join();
                this.f1547e = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        int i = 3;
        while (this.f1548f) {
            if (!this.f1550h && i > 0) {
                m897b();
                AudioRecord audioRecord = new AudioRecord(1, this.f1545c, this.f1546d, 2, this.f1544b.capacity());
                this.f1549g = audioRecord;
                boolean z = audioRecord.getState() == 1;
                this.f1550h = z;
                if (z) {
                    this.f1544b.position(0);
                    this.f1549g.startRecording();
                    i = 3;
                } else {
                    Log.e(y.ۮڭڭܬި(862149211), y.٬ݯح׭٩(575993774) + this.f1549g.getState() + y.ٴسسݬߨ(1392959042));
                    i--;
                    m897b();
                }
            }
            if (this.f1550h && this.f1549g.getRecordingState() == 3) {
                AudioRecord audioRecord2 = this.f1549g;
                ByteBuffer byteBuffer = this.f1544b;
                this.f1543a.fmodProcessMicData(this.f1544b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.f1544b.position(0);
            }
        }
        m897b();
    }
}
