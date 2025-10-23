package com.bumptech.glide.load.engine.bitmap_recycle;

import com.liapp.y;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PrettyPrintTreeMap() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(y.دײܮڳܯ(2052005997));
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append('{').append(entry.getKey()).append(':').append(entry.getValue()).append(y.ݮڮֲڭܩ(-628956516));
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        return sb.append(y.ۮڭڭܬި(862109635)).toString();
    }
}
