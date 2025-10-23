package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
final class zznj extends IllegalArgumentException {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zznj(int i, int i2) {
        super(new StringBuilder(54).append("Unpaired surrogate at index ").append(i).append(" of ").append(i2).toString());
    }
}
