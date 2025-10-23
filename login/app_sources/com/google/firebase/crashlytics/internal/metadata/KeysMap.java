package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class KeysMap {
    private final Map<String, String> keys = new HashMap();
    private final int maxEntries;
    private final int maxEntryLength;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KeysMap(int i, int i2) {
        this.maxEntries = i;
        this.maxEntryLength = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Map<String, String> getKeys() {
        return Collections.unmodifiableMap(new HashMap(this.keys));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean setKey(String str, String str2) {
        String sanitizeKey = sanitizeKey(str);
        if (this.keys.size() >= this.maxEntries && !this.keys.containsKey(sanitizeKey)) {
            Logger.getLogger().m398w("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.maxEntries);
            return false;
        }
        String sanitizeString = sanitizeString(str2, this.maxEntryLength);
        if (CommonUtils.nullSafeEquals(this.keys.get(sanitizeKey), sanitizeString)) {
            return false;
        }
        Map<String, String> map = this.keys;
        if (str2 == null) {
            sanitizeString = "";
        }
        map.put(sanitizeKey, sanitizeString);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setKeys(Map<String, String> map) {
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String sanitizeKey = sanitizeKey(entry.getKey());
            if (this.keys.size() >= this.maxEntries && !this.keys.containsKey(sanitizeKey)) {
                i++;
            }
            String value = entry.getValue();
            this.keys.put(sanitizeKey, value == null ? "" : sanitizeString(value, this.maxEntryLength));
        }
        if (i > 0) {
            Logger.getLogger().m398w("Ignored " + i + " entries when adding custom keys. Maximum allowable: " + this.maxEntries);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String sanitizeKey(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        return sanitizeString(str, this.maxEntryLength);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String sanitizeString(String str, int i) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > i ? trim.substring(0, i) : trim;
    }
}
