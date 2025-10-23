package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;

/* loaded from: classes.dex */
public abstract class ClientInfo {

    public static abstract class Builder {
        public abstract ClientInfo build();

        public abstract Builder setAndroidClientInfo(AndroidClientInfo androidClientInfo);

        public abstract Builder setClientType(ClientType clientType);
    }

    public abstract AndroidClientInfo getAndroidClientInfo();

    public abstract ClientType getClientType();

    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ClientType(int i) {
            this.value = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new AutoValue_ClientInfo.Builder();
    }
}
