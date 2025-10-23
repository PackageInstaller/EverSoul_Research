package com.android.installreferrer.api;

import android.os.Bundle;
import com.liapp.y;

/* loaded from: classes.dex */
public class ReferrerDetails {
    private static final String KEY_GOOGLE_PLAY_INSTANT = "google_play_instant";
    private static final String KEY_INSTALL_BEGIN_TIMESTAMP = "install_begin_timestamp_seconds";
    private static final String KEY_INSTALL_BEGIN_TIMESTAMP_SERVER = "install_begin_timestamp_server_seconds";
    private static final String KEY_INSTALL_REFERRER = "install_referrer";
    private static final String KEY_INSTALL_VERSION = "install_version";
    private static final String KEY_REFERRER_CLICK_TIMESTAMP = "referrer_click_timestamp_seconds";
    private static final String KEY_REFERRER_CLICK_TIMESTAMP_SERVER = "referrer_click_timestamp_server_seconds";
    private final Bundle mOriginalBundle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReferrerDetails(Bundle bundle) {
        this.mOriginalBundle = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getGooglePlayInstantParam() {
        return this.mOriginalBundle.getBoolean(y.ݮڮֲڭܩ(-629067740));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getInstallBeginTimestampSeconds() {
        return this.mOriginalBundle.getLong(y.ٴسسݬߨ(1392837954));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getInstallBeginTimestampServerSeconds() {
        return this.mOriginalBundle.getLong(y.ٲٴݴ״ٰ(1781537072));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getInstallReferrer() {
        return this.mOriginalBundle.getString(y.ݮڮֲڭܩ(-629066956));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getInstallVersion() {
        return this.mOriginalBundle.getString(y.٬ݯح׭٩(576111558));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getReferrerClickTimestampSeconds() {
        return this.mOriginalBundle.getLong(y.ٲٴݴ״ٰ(1781538664));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getReferrerClickTimestampServerSeconds() {
        return this.mOriginalBundle.getLong(y.ٲٴݴ״ٰ(1781538456));
    }
}
