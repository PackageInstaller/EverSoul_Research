package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zab extends DataHolder.Builder {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zab(String[] strArr, String str) {
        super(strArr, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataHolder.Builder
    public final DataHolder.Builder withRow(ContentValues contentValues) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataHolder.Builder
    public final DataHolder.Builder zaa(HashMap hashMap) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
}
