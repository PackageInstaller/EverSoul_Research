package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
class BytesBackedNativeSessionFile implements NativeSessionFile {
    private final byte[] bytes;
    private final String dataTransportFilename;
    private final String reportsEndpointFilename;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BytesBackedNativeSessionFile(String str, String str2, byte[] bArr) {
        this.dataTransportFilename = str;
        this.reportsEndpointFilename = str2;
        this.bytes = bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public String getReportsEndpointFilename() {
        return this.reportsEndpointFilename;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public InputStream getStream() {
        if (isEmpty()) {
            return null;
        }
        return new ByteArrayInputStream(this.bytes);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public CrashlyticsReport.FilesPayload.File asFilePayload() {
        byte[] asGzippedBytes = asGzippedBytes();
        if (asGzippedBytes == null) {
            return null;
        }
        return CrashlyticsReport.FilesPayload.File.builder().setContents(asGzippedBytes).setFilename(this.dataTransportFilename).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isEmpty() {
        byte[] bArr = this.bytes;
        return bArr == null || bArr.length == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] asGzippedBytes() {
        if (isEmpty()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.bytes);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
