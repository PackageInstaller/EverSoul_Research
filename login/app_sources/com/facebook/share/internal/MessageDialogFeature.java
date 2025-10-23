package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;

/* loaded from: classes.dex */
public enum MessageDialogFeature implements DialogFeature {
    MESSAGE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140204),
    PHOTOS(NativeProtocol.PROTOCOL_VERSION_20140324),
    VIDEO(NativeProtocol.PROTOCOL_VERSION_20141218),
    MESSENGER_GENERIC_TEMPLATE(NativeProtocol.PROTOCOL_VERSION_20171115),
    MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE(NativeProtocol.PROTOCOL_VERSION_20171115),
    MESSENGER_MEDIA_TEMPLATE(NativeProtocol.PROTOCOL_VERSION_20171115);

    private int minVersion;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.DialogFeature
    public String getAction() {
        return NativeProtocol.ACTION_MESSAGE_DIALOG;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MessageDialogFeature(int minVersion) {
        this.minVersion = minVersion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.DialogFeature
    public int getMinVersion() {
        return this.minVersion;
    }
}
