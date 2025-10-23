package com.android.volley;

import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public interface Cache {

    public static class Entry {
        public byte[] data;
        public String etag;
        public long lastModified;
        public Map<String, String> responseHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        public long serverDate;
        public long softTtl;
        public long ttl;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isExpired() {
            return this.ttl < System.currentTimeMillis();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean refreshNeeded() {
            return this.softTtl < System.currentTimeMillis();
        }
    }

    void clear();

    Entry get(String str);

    void initialize();

    void invalidate(String str, boolean z);

    void put(String str, Entry entry);

    void remove(String str);
}
