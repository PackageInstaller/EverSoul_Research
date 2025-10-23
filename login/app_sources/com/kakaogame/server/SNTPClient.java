package com.kakaogame.server;

import android.os.SystemClock;
import com.google.common.base.Ascii;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import kotlin.Metadata;

/* compiled from: SNTPClient.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0010J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0004H\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/server/SNTPClient;", "", "()V", "<set-?>", "", "ntpTime", "getNtpTime", "()J", "ntpTimeReference", "getNtpTimeReference", "roundTripTime", "getRoundTripTime", "read32", "buffer", "", "offset", "", "readTimeStamp", "requestTime", "", "host", "", "timeout", "writeTimeStamp", "", Base2ndPWViewData.KEY_TIME, "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SNTPClient {
    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 2208988800L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final int REFERENCE_TIME_OFFSET = 16;
    public static final String TAG = "SntpClient";
    private static final int TRANSMIT_TIME_OFFSET = 40;
    private long ntpTime;
    private long ntpTimeReference;
    private long roundTripTime;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getNtpTime() {
        return this.ntpTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getNtpTimeReference() {
        return this.ntpTimeReference;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getRoundTripTime() {
        return this.roundTripTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean requestTime(String host, int timeout) {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2 = null;
        try {
            datagramSocket = new DatagramSocket();
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            datagramSocket.setSoTimeout(timeout);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, InetAddress.getByName(host), 123);
            bArr[0] = Ascii.ESC;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            writeTimeStamp(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j = elapsedRealtime2 - elapsedRealtime;
            long j2 = currentTimeMillis + j;
            long readTimeStamp = readTimeStamp(bArr, 24);
            long readTimeStamp2 = readTimeStamp(bArr, 32);
            long readTimeStamp3 = readTimeStamp(bArr, 40);
            this.ntpTime = j2 + (((readTimeStamp2 - readTimeStamp) + (readTimeStamp3 - j2)) / 2);
            this.ntpTimeReference = elapsedRealtime2;
            this.roundTripTime = j - (readTimeStamp3 - readTimeStamp2);
            datagramSocket.close();
            return true;
        } catch (Exception unused2) {
            datagramSocket2 = datagramSocket;
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            datagramSocket2 = datagramSocket;
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final long read32(byte[] buffer, int offset) {
        int i = buffer[offset];
        int i2 = buffer[offset + 1];
        int i3 = buffer[offset + 2];
        int i4 = buffer[offset + 3];
        if ((i & 128) == 128) {
            i = (i & 127) + 128;
        }
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final long readTimeStamp(byte[] buffer, int offset) {
        return ((read32(buffer, offset) - OFFSET_1900_TO_1970) * 1000) + ((read32(buffer, offset + 4) * 1000) / 4294967296L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void writeTimeStamp(byte[] buffer, int offset, long time) {
        long j = time / 1000;
        long j2 = time - (j * 1000);
        long j3 = j + OFFSET_1900_TO_1970;
        int i = offset + 1;
        buffer[offset] = (byte) (j3 >> 24);
        int i2 = i + 1;
        buffer[i] = (byte) (j3 >> 16);
        int i3 = i2 + 1;
        buffer[i2] = (byte) (j3 >> 8);
        int i4 = i3 + 1;
        buffer[i3] = (byte) (j3 >> 0);
        long j4 = (j2 * 4294967296L) / 1000;
        int i5 = i4 + 1;
        buffer[i4] = (byte) (j4 >> 24);
        int i6 = i5 + 1;
        buffer[i5] = (byte) (j4 >> 16);
        buffer[i6] = (byte) (j4 >> 8);
        buffer[i6 + 1] = (byte) (Math.random() * 255.0d);
    }
}
