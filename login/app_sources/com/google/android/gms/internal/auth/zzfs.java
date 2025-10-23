package com.google.android.gms.internal.auth;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzfs {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zza(zzfq zzfqVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzfqVar, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
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
            sb.append(": \"");
            sb.append(zzgn.zza(zzeb.zzl((String) obj)));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzeb) {
            sb.append(": \"");
            sb.append(zzgn.zza((zzeb) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzeq) {
            sb.append(" {");
            zzd((zzeq) obj, sb, i + 2);
            sb.append(StringUtils.f1524LF);
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        zzb(sb, i4, "key", entry.getKey());
        zzb(sb, i4, "value", entry.getValue());
        sb.append(StringUtils.f1524LF);
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final String zzc(String str) {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zzd(zzfq zzfqVar, StringBuilder sb, int i) {
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzfqVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(concat), zzeq.zzf(method2, zzfqVar, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(concat2), zzeq.zzf(method3, zzfqVar, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(substring);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (!hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(substring.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(substring);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(substring);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object zzf = zzeq.zzf(method4, zzfqVar, new Object[0]);
                    if (method5 == null) {
                        if (zzf instanceof Boolean) {
                            if (((Boolean) zzf).booleanValue()) {
                                zzb(sb, i, zzc(concat3), zzf);
                            }
                        } else if (zzf instanceof Integer) {
                            if (((Integer) zzf).intValue() != 0) {
                                zzb(sb, i, zzc(concat3), zzf);
                            }
                        } else if (zzf instanceof Float) {
                            if (((Float) zzf).floatValue() != 0.0f) {
                                zzb(sb, i, zzc(concat3), zzf);
                            }
                        } else if (!(zzf instanceof Double)) {
                            if (zzf instanceof String) {
                                equals = zzf.equals("");
                            } else if (zzf instanceof zzeb) {
                                equals = zzf.equals(zzeb.zzb);
                            } else if (!(zzf instanceof zzfq)) {
                                if ((zzf instanceof Enum) && ((Enum) zzf).ordinal() == 0) {
                                }
                                zzb(sb, i, zzc(concat3), zzf);
                            } else if (zzf != ((zzfq) zzf).zzh()) {
                                zzb(sb, i, zzc(concat3), zzf);
                            }
                            if (!equals) {
                                zzb(sb, i, zzc(concat3), zzf);
                            }
                        } else if (((Double) zzf).doubleValue() != 0.0d) {
                            zzb(sb, i, zzc(concat3), zzf);
                        }
                    } else if (((Boolean) zzeq.zzf(method5, zzfqVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzc(concat3), zzf);
                    }
                }
            }
        }
        if (zzfqVar instanceof zzep) {
            zzel zzelVar = ((zzep) zzfqVar).zzb;
            throw null;
        }
        zzgq zzgqVar = ((zzeq) zzfqVar).zzc;
        if (zzgqVar != null) {
            zzgqVar.zze(sb, i);
        }
    }
}
