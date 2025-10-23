package com.kakaogames.eversoul;

import android.app.Activity;
import com.liapp.ApplicationC2576x;
import com.liapp.C2571p;
import com.liapp.z;

/* compiled from: ٳس׬ܲޮ.java */
/* renamed from: com.kakaogames.eversoul.سܯܱ۬ݨ, reason: contains not printable characters */
/* loaded from: classes3.dex */
public class ActivityC3083 extends Activity {

    /* renamed from: ֬֬֬ڴܰ, reason: not valid java name and contains not printable characters */
    public static final int f1604 = 3;

    /* renamed from: ֮ڲ֮۬ݨ, reason: not valid java name and contains not printable characters */
    public static final int f1605 = 2;

    /* renamed from: ִٱۮܴް, reason: not valid java name and contains not printable characters */
    public static final int f1606 = 8;

    /* renamed from: ײڬݯسگ, reason: contains not printable characters */
    public static final int f1607 = 0;

    /* renamed from: ״ܴڱ۲ݮ, reason: not valid java name and contains not printable characters */
    public static final int f1608 = 1;

    /* renamed from: حݱݱֲخ, reason: contains not printable characters */
    public static final int f1609 = -1;

    /* renamed from: ٳܮزڮܪ, reason: contains not printable characters */
    public static final int f1610 = 7;

    /* renamed from: ܱڳݭܲޮ, reason: not valid java name and contains not printable characters */
    public static final int f1611 = 1;

    /* renamed from: خ۳ٯٯ۫, reason: contains not printable characters */
    public static int m1280() {
        return z.ֱح۳ۯݫ();
    }

    /* renamed from: ֭گدخڪ, reason: not valid java name and contains not printable characters */
    public static int m1277() {
        return z.ֱح۳ۯݫ();
    }

    /* renamed from: ײݱֱ֮ح, reason: contains not printable characters */
    public static String m1279() {
        String m1300;
        int i = z.ֱح۳ۯݫ();
        if (i <= 0) {
            return "";
        }
        if (i == 1) {
            m1300 = C2571p.m1300("+");
        } else if (i == 8) {
            m1300 = C2571p.m1300("'");
        } else if (i == 2) {
            m1300 = C2571p.m1300(";");
        } else if (i == 7) {
            m1300 = C2571p.m1300("=");
        } else {
            if (i != 3) {
                return "";
            }
            m1300 = C2571p.m1300("9");
        }
        StringBuilder insert = new StringBuilder().insert(0, m1300);
        insert.append(C2571p.m1300("\u0014O"));
        insert.append(z.ֱح۳ۯݫ(m1300));
        return insert.toString();
    }

    /* renamed from: ײڬڴشڰ, reason: contains not printable characters */
    public static String m1278(String str) {
        return ApplicationC2576x.m1325(ApplicationC2576x.f1705, ApplicationC2576x.f1642, str);
    }

    /* renamed from: ٳڬݮڴܰ, reason: contains not printable characters */
    public static String m1281() {
        return ApplicationC2576x.m1325(ApplicationC2576x.f1705, ApplicationC2576x.f1665, (String) null);
    }

    /* renamed from: ڮڲݱݱ߭, reason: contains not printable characters */
    public static void m1282(String str) {
        ApplicationC2576x.m1325(ApplicationC2576x.f1705, ApplicationC2576x.f1630, str);
    }
}
