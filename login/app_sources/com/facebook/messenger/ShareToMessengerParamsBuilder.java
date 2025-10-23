package com.facebook.messenger;

import android.net.Uri;

/* loaded from: classes.dex */
public class ShareToMessengerParamsBuilder {
    private Uri mExternalUri;
    private String mMetaData;
    private final String mMimeType;
    private final Uri mUri;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ShareToMessengerParamsBuilder(Uri uri, String mimeType) {
        this.mUri = uri;
        this.mMimeType = mimeType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Uri getUri() {
        return this.mUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getMimeType() {
        return this.mMimeType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShareToMessengerParamsBuilder setMetaData(String metaData) {
        this.mMetaData = metaData;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getMetaData() {
        return this.mMetaData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShareToMessengerParamsBuilder setExternalUri(Uri externalUri) {
        this.mExternalUri = externalUri;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Uri getExternalUri() {
        return this.mExternalUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShareToMessengerParams build() {
        return new ShareToMessengerParams(this);
    }
}
