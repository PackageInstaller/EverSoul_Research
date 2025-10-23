package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.InternalUtils;
import com.android.volley.NetworkResponse;
import com.liapp.y;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpHeaderParser {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.headers;
        String str = map.get(y.٬ݯح׭٩(576107462));
        long parseDateAsEpoch = str != null ? parseDateAsEpoch(str) : 0L;
        String str2 = map.get(y.ٲٴݴ״ٰ(1781559088));
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(y.ٲٴݴ״ٰ(1781559176));
            z = false;
            j = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals(y.ۮڭڭܬި(862001539)) || trim.equals(y.ݮڮֲڭܩ(-629062316))) {
                    return null;
                }
                if (trim.startsWith(y.ݬֲ֮ܲت(1512856271))) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith(y.ݬֲ֮ܲت(1512856127))) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals(y.٬ݯح׭٩(576108126)) || trim.equals(y.ٲٴݴ״ٰ(1781558752))) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = map.get(y.٬ݯح׭٩(576108470));
        long parseDateAsEpoch2 = str3 != null ? parseDateAsEpoch(str3) : 0L;
        String str4 = map.get(y.֬ڱܱײٮ(-1159385359));
        long parseDateAsEpoch3 = str4 != null ? parseDateAsEpoch(str4) : 0L;
        String str5 = map.get(y.ۮڭڭܬި(862004595));
        if (i != 0) {
            long j5 = currentTimeMillis + (j * 1000);
            j3 = j5;
            j4 = z ? j5 : (j2 * 1000) + j5;
        } else {
            j3 = 0;
            if (parseDateAsEpoch <= 0 || parseDateAsEpoch2 < parseDateAsEpoch) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (parseDateAsEpoch2 - parseDateAsEpoch);
                j3 = j4;
            }
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = networkResponse.data;
        entry.etag = str5;
        entry.softTtl = j3;
        entry.ttl = j4;
        entry.serverDate = parseDateAsEpoch;
        entry.lastModified = parseDateAsEpoch3;
        entry.responseHeaders = map;
        return entry;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String parseCharset(Map<String, String> map) {
        return parseCharset(map, y.֬ڱܱײٮ(-1159392951));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String parseCharset(Map<String, String> map, String str) {
        String str2 = map.get(y.ٲٴݴ״ٰ(1781552064));
        if (str2 != null) {
            String[] split = str2.split(y.֬ڱܱײٮ(-1159407399));
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split(y.ۮڭڭܬި(862004339));
                if (split2.length == 2 && split2[0].equals(y.ٲٴݴ״ٰ(1781551688))) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long parseDateAsEpoch(String str) {
        try {
            Date parseDate = InternalUtils.parseDate(str);
            if (parseDate == null) {
                return 0L;
            }
            return parseDate.getTime();
        } catch (Exception unused) {
            return 0L;
        }
    }
}
