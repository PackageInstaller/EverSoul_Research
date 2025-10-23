package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
final class zzlt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zza(zzlq zzlqVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzlqVar, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0226, code lost:
    
        if (((java.lang.Double) r11).doubleValue() == 0.0d) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01f1, code lost:
    
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f3, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0203, code lost:
    
        if (((java.lang.Integer) r11).intValue() == 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0214, code lost:
    
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L80;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.drive.zzlq r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlt.zza(com.google.android.gms.internal.drive.zzlq, java.lang.StringBuilder, int):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static final void zza(StringBuilder sb, int i, String str, Object obj) {
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
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(zzmt.zzc(zzjc.zzk((String) obj))).append(Typography.quote);
            return;
        }
        if (obj instanceof zzjc) {
            sb.append(": \"").append(zzmt.zzc((zzjc) obj)).append(Typography.quote);
            return;
        }
        if (obj instanceof zzkk) {
            sb.append(" {");
            zza((zzkk) obj, sb, i + 2);
            sb.append(StringUtils.f1524LF);
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i4 = i + 2;
            zza(sb, i4, "key", entry.getKey());
            zza(sb, i4, "value", entry.getValue());
            sb.append(StringUtils.f1524LF);
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ").append(obj.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final String zzo(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
