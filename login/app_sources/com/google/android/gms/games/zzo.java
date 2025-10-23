package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public class zzo extends DataBufferRef {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzo(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int zzp(String str, int i) {
        return (!hasColumn(str) || hasNull(str)) ? i : getInteger(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final String zzq(String str, String str2) {
        if (!hasColumn(str) || hasNull(str)) {
            return null;
        }
        return getString(str);
    }
}
