package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import com.liapp.y;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class FMODAudioDevice implements Runnable {

    /* renamed from: a */
    private volatile Thread f1536a = null;

    /* renamed from: b */
    private volatile boolean f1537b = false;

    /* renamed from: c */
    private AudioTrack f1538c = null;

    /* renamed from: d */
    private boolean f1539d = false;

    /* renamed from: e */
    private ByteBuffer f1540e = null;

    /* renamed from: f */
    private byte[] f1541f = null;

    /* renamed from: g */
    private volatile RunnableC2925a f1542g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.f1538c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.f1538c.stop();
            }
            this.f1538c.release();
            this.f1538c = null;
        }
        this.f1540e = null;
        this.f1541f = null;
        this.f1539d = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void close() {
        stop();
    }

    native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isRunning() {
        return this.f1536a != null && this.f1536a.isAlive();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        int i = 3;
        while (this.f1537b) {
            if (!this.f1539d && i > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(0);
                int i2 = fmodGetInfo(4) == 1 ? 4 : 12;
                int minBufferSize = AudioTrack.getMinBufferSize(fmodGetInfo, i2, 2);
                int fmodGetInfo2 = fmodGetInfo(4) * 2;
                int round = Math.round(minBufferSize * 1.1f) & (~(fmodGetInfo2 - 1));
                int fmodGetInfo3 = fmodGetInfo(1);
                int fmodGetInfo4 = fmodGetInfo(2) * fmodGetInfo3 * fmodGetInfo2;
                AudioTrack audioTrack = new AudioTrack(3, fmodGetInfo, i2, 2, fmodGetInfo4 > round ? fmodGetInfo4 : round, 1);
                this.f1538c = audioTrack;
                boolean z = audioTrack.getState() == 1;
                this.f1539d = z;
                if (z) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fmodGetInfo3 * fmodGetInfo2);
                    this.f1540e = allocateDirect;
                    this.f1541f = new byte[allocateDirect.capacity()];
                    this.f1538c.play();
                    i = 3;
                } else {
                    Log.e(y.ۮڭڭܬި(862149211), y.֬ڱܱײٮ(-1159237855) + this.f1538c.getState() + y.ٴسسݬߨ(1392959042));
                    releaseAudioTrack();
                    i--;
                }
            }
            if (this.f1539d) {
                if (fmodGetInfo(3) == 1) {
                    fmodProcess(this.f1540e);
                    ByteBuffer byteBuffer = this.f1540e;
                    byteBuffer.get(this.f1541f, 0, byteBuffer.capacity());
                    this.f1538c.write(this.f1541f, 0, this.f1540e.capacity());
                    this.f1540e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void start() {
        if (this.f1536a != null) {
            stop();
        }
        this.f1536a = new Thread(this, "FMODAudioDevice");
        this.f1536a.setPriority(10);
        this.f1537b = true;
        this.f1536a.start();
        if (this.f1542g != null) {
            this.f1542g.m899c();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f1542g == null) {
            this.f1542g = new RunnableC2925a(this, i, i2);
            this.f1542g.m899c();
        }
        return this.f1542g.m898a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void stop() {
        while (this.f1536a != null) {
            this.f1537b = false;
            try {
                this.f1536a.join();
                this.f1536a = null;
            } catch (InterruptedException unused) {
            }
        }
        if (this.f1542g != null) {
            this.f1542g.m900d();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void stopAudioRecord() {
        if (this.f1542g != null) {
            this.f1542g.m900d();
            this.f1542g = null;
        }
    }
}
