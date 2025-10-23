package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkw {
    private static final char[] zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zza(zzkr zzkrVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzkrVar, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(int i, StringBuilder sb) {
        while (i > 0) {
            char[] cArr = zza;
            int length = i > cArr.length ? cArr.length : i;
            sb.append(cArr, 0, length);
            i -= length;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zza(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zza(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zza(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(zzme.zza(zzhu.zza((String) obj))).append(Typography.quote);
            return;
        }
        if (obj instanceof zzhu) {
            sb.append(": \"").append(zzme.zza((zzhu) obj)).append(Typography.quote);
            return;
        }
        if (obj instanceof zzjf) {
            sb.append(" {");
            zza((zzjf) obj, sb, i + 2);
            sb.append(StringUtils.f1524LF);
            zza(i, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i3 = i + 2;
            zza(sb, i3, "key", entry.getKey());
            zza(sb, i3, "value", entry.getValue());
            sb.append(StringUtils.f1524LF);
            zza(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": ").append(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0165, code lost:
    
        if (r5.containsKey("get" + r9.substring(0, r9.length() - 5)) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0196, code lost:
    
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0198, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a9, code lost:
    
        if (((java.lang.Integer) r7).intValue() == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01bb, code lost:
    
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d1, code lost:
    
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L64;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.measurement.zzkr r20, java.lang.StringBuilder r21, int r22) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkw.zza(com.google.android.gms.internal.measurement.zzkr, java.lang.StringBuilder, int):void");
    }
}
