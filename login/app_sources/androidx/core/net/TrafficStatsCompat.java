package androidx.core.net;

import android.net.TrafficStats;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/* loaded from: classes.dex */
public final class TrafficStatsCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void incrementOperationCount(int i) {
        TrafficStats.incrementOperationCount(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void incrementOperationCount(int i, int i2) {
        TrafficStats.incrementOperationCount(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void setThreadStatsTag(int i) {
        TrafficStats.setThreadStatsTag(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void tagSocket(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void untagSocket(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        Api24Impl.tagDatagramSocket(datagramSocket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        Api24Impl.untagDatagramSocket(datagramSocket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TrafficStatsCompat() {
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStats.tagDatagramSocket(datagramSocket);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStats.untagDatagramSocket(datagramSocket);
        }
    }
}
