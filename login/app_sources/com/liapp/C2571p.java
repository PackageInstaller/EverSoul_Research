package com.liapp;

/* compiled from: جֳۭׯ٫.java */
/* renamed from: com.liapp.p */
/* loaded from: classes4.dex */
public class C2571p {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static String m1299(String str) {
        StackTraceElement stackTraceElement = new LinkageError().getStackTrace()[1];
        StringBuffer stringBuffer = new StringBuffer();
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        stringBuffer.append(className);
        stringBuffer.append(methodName);
        String stringBuffer2 = stringBuffer.toString();
        int length = stringBuffer2.length() - 1;
        int length2 = str.length();
        char[] cArr = new char[length2];
        char c = 'o';
        int i = length;
        for (int i2 = length2 - 1; i2 >= 0; i2--) {
            char charAt = stringBuffer2.charAt(i);
            cArr[i2] = (char) ((str.charAt(i2) ^ c) ^ charAt);
            c = (char) ((c ^ (charAt ^ i2)) & 63);
            i--;
            if (i < 0) {
                i = length;
            }
        }
        return new String(cArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    public static String m1300(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i = length - 1;
        char c = 'o';
        while (i >= 0) {
            char charAt = (char) (str.charAt(i) ^ c);
            char c2 = (char) (((char) (c ^ i)) & '?');
            cArr[i] = charAt;
            int i2 = i - 1;
            if (i2 < 0) {
                break;
            }
            char charAt2 = (char) (str.charAt(i2) ^ c2);
            c = (char) (((char) (c2 ^ i2)) & '?');
            cArr[i2] = charAt2;
            i = i2 - 1;
        }
        return new String(cArr);
    }
}
