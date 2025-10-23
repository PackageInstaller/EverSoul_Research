package com.google.zxing.pdf417;

/* loaded from: classes3.dex */
public final class PDF417ResultMetadata {
    private String addressee;
    private String fileId;
    private String fileName;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentIndex;
    private String sender;
    private int segmentCount = -1;
    private long fileSize = -1;
    private long timestamp = -1;
    private int checksum = -1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSegmentIndex() {
        return this.segmentIndex;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSegmentIndex(int i) {
        this.segmentIndex = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getFileId() {
        return this.fileId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFileId(String str) {
        this.fileId = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int[] getOptionalData() {
        return this.optionalData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setOptionalData(int[] iArr) {
        this.optionalData = iArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isLastSegment() {
        return this.lastSegment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLastSegment(boolean z) {
        this.lastSegment = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSegmentCount() {
        return this.segmentCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSegmentCount(int i) {
        this.segmentCount = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSender() {
        return this.sender;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSender(String str) {
        this.sender = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAddressee() {
        return this.addressee;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAddressee(String str) {
        this.addressee = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getFileName() {
        return this.fileName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFileName(String str) {
        this.fileName = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getFileSize() {
        return this.fileSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFileSize(long j) {
        this.fileSize = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getChecksum() {
        return this.checksum;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChecksum(int i) {
        this.checksum = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getTimestamp() {
        return this.timestamp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
