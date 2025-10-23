package com.yasirkula.unity;

import com.liapp.y;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class DebugConsoleLogcatLogger {
    private LogcatWorker worker;

    private static class LogcatWorker implements Runnable {
        private String command;
        private DebugConsoleLogcatLogReceiver logReceiver;
        private volatile boolean running = true;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LogcatWorker(DebugConsoleLogcatLogReceiver debugConsoleLogcatLogReceiver, String str) {
            this.logReceiver = debugConsoleLogcatLogReceiver;
            this.command = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                Runtime.getRuntime().exec("logcat -c");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(this.command).getInputStream()));
                while (this.running) {
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else {
                            this.logReceiver.OnLogReceived(readLine);
                        }
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void terminate() {
            this.running = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void Start(DebugConsoleLogcatLogReceiver debugConsoleLogcatLogReceiver, String str) {
        String str2;
        Stop();
        if (debugConsoleLogcatLogReceiver == null) {
            return;
        }
        if (str != null) {
            String trim = str.trim();
            if (trim.length() > 0) {
                str2 = y.ٴسسݬߨ(1393194682) + trim;
                this.worker = new LogcatWorker(debugConsoleLogcatLogReceiver, str2);
                new Thread(this.worker).start();
            }
        }
        str2 = "logcat";
        this.worker = new LogcatWorker(debugConsoleLogcatLogReceiver, str2);
        new Thread(this.worker).start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void Stop() {
        LogcatWorker logcatWorker = this.worker;
        if (logcatWorker != null) {
            logcatWorker.terminate();
            this.worker = null;
        }
    }
}
