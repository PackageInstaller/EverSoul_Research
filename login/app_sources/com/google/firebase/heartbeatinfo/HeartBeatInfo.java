package com.google.firebase.heartbeatinfo;

/* loaded from: classes2.dex */
public interface HeartBeatInfo {
    HeartBeat getHeartBeatCode(String str);

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        HeartBeat(int i) {
            this.code = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getCode() {
            return this.code;
        }
    }
}
