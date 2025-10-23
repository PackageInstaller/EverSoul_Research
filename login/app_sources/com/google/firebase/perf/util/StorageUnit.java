package com.google.firebase.perf.util;

import android.support.v4.media.session.PlaybackStateCompat;

/* loaded from: classes2.dex */
public enum StorageUnit {
    TERABYTES(1099511627776L) { // from class: com.google.firebase.perf.util.StorageUnit.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.util.StorageUnit
        public long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toTerabytes(j);
        }
    },
    GIGABYTES(1073741824) { // from class: com.google.firebase.perf.util.StorageUnit.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.util.StorageUnit
        public long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toGigabytes(j);
        }
    },
    MEGABYTES(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) { // from class: com.google.firebase.perf.util.StorageUnit.3
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.util.StorageUnit
        public long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toMegabytes(j);
        }
    },
    KILOBYTES(1024) { // from class: com.google.firebase.perf.util.StorageUnit.4
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.util.StorageUnit
        public long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toKilobytes(j);
        }
    },
    BYTES(1) { // from class: com.google.firebase.perf.util.StorageUnit.5
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.perf.util.StorageUnit
        public long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toBytes(j);
        }
    };

    long numBytes;

    public abstract long convert(long j, StorageUnit storageUnit);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StorageUnit(long j) {
        this.numBytes = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long toBytes(long j) {
        return j * this.numBytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long toKilobytes(long j) {
        return (j * this.numBytes) / KILOBYTES.numBytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long toMegabytes(long j) {
        return (j * this.numBytes) / MEGABYTES.numBytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long toGigabytes(long j) {
        return (j * this.numBytes) / GIGABYTES.numBytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long toTerabytes(long j) {
        return (j * this.numBytes) / TERABYTES.numBytes;
    }
}
