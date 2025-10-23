package com.liapp;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.activity.ComponentActivity.LifeCycle;
import com.google.android.gms.drive.DriveFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: ڱܳۯٴ۰.java */
/* renamed from: com.liapp.x */
/* loaded from: classes4.dex */
public class ApplicationC2576x extends Application {

    /* renamed from: ױֱ֮ܭީ, reason: contains not printable characters */
    private static int f1645;

    /* renamed from: ײ׮۳۱ݭ, reason: not valid java name and contains not printable characters */
    public static PackageInfo f1647;

    /* renamed from: ٬ִجױ٭, reason: not valid java name and contains not printable characters */
    public static ActivityManager f1661;

    /* renamed from: ٮٯٴ۳ݯ, reason: contains not printable characters */
    private static ClassLoader f1666;

    /* renamed from: ٮۭ֮ٮ۪, reason: contains not printable characters */
    public static int f1667;

    /* renamed from: ڱܮֱ֯ح, reason: contains not printable characters */
    private static Handler f1676;

    /* renamed from: ۲֯سݭߩ, reason: not valid java name and contains not printable characters */
    private static Runnable f1687;

    /* renamed from: ܭٳݬִذ, reason: contains not printable characters */
    public static String f1692;

    /* renamed from: ݴۮڳ׭٩, reason: not valid java name and contains not printable characters */
    public static PackageManager f1707;

    /* renamed from: ۮ۱׬ܬި, reason: not valid java name and contains not printable characters */
    public static final /* synthetic */ boolean f1685 = true;

    /* renamed from: ݬݱܲ۲ݮ, reason: contains not printable characters */
    public static long f1702 = 16384;

    /* renamed from: ִٱۮܴް, reason: not valid java name and contains not printable characters */
    public static long f1639 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* renamed from: ݮخڴݯ߫, reason: contains not printable characters */
    public static long f1704 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;

    /* renamed from: ׬ݬسۮݪ, reason: not valid java name and contains not printable characters */
    public static long f1641 = 8388608;

    /* renamed from: ڴײٮ۱ݭ, reason: contains not printable characters */
    public static int f1680 = 10;

    /* renamed from: ۬ٯݯֲخ, reason: not valid java name and contains not printable characters */
    public static int f1681 = 20;

    /* renamed from: ݯ۬جخڪ, reason: contains not printable characters */
    public static int f1705 = 30;

    /* renamed from: ֳڴܱܯޫ, reason: not valid java name and contains not printable characters */
    public static int f1638 = 40;

    /* renamed from: خۭܬشڰ, reason: contains not printable characters */
    public static int f1658 = 41;

    /* renamed from: ׮ٲرڲܮ, reason: not valid java name and contains not printable characters */
    public static int f1643 = 51;

    /* renamed from: ״ڲزشڰ, reason: not valid java name and contains not printable characters */
    public static int f1652 = 52;

    /* renamed from: زݴگܯޫ, reason: contains not printable characters */
    public static int f1659 = 53;

    /* renamed from: ٬ܱڱزڮ, reason: not valid java name and contains not printable characters */
    public static int f1664 = 54;

    /* renamed from: ֮ڲ֮۬ݨ, reason: not valid java name and contains not printable characters */
    public static int f1632 = 55;

    /* renamed from: ٴ۬׳ֲخ, reason: not valid java name and contains not printable characters */
    public static int f1672 = 56;

    /* renamed from: ܴׯحڴܰ, reason: not valid java name and contains not printable characters */
    public static int f1700 = 61;

    /* renamed from: ײܮ׮۱ݭ, reason: not valid java name and contains not printable characters */
    public static int f1649 = 62;

    /* renamed from: ܱڴج٬ۨ, reason: not valid java name and contains not printable characters */
    public static int f1696 = 63;

    /* renamed from: ܭֱܲجڨ, reason: contains not printable characters */
    public static int f1693 = 64;

    /* renamed from: ڱۯڮڴܰ, reason: contains not printable characters */
    public static int f1675 = 65;

    /* renamed from: ۬گٴֲخ, reason: not valid java name and contains not printable characters */
    public static int f1682 = 66;

    /* renamed from: ܲܳٯڳܯ, reason: not valid java name and contains not printable characters */
    public static int f1697 = 67;

    /* renamed from: ٬ٳܭ۴ݰ, reason: not valid java name and contains not printable characters */
    public static int f1663 = 71;

    /* renamed from: ݮׯֳ٬ۨ, reason: not valid java name and contains not printable characters */
    public static int f1703 = 72;

    /* renamed from: ح۳ײݴ߰, reason: contains not printable characters */
    public static int f1654 = 73;

    /* renamed from: ֬ݭײ׮٪, reason: not valid java name and contains not printable characters */
    public static int f1631 = 74;

    /* renamed from: شݮײܮު, reason: contains not printable characters */
    public static int f1660 = 75;

    /* renamed from: ٭ٱڮֳد, reason: not valid java name and contains not printable characters */
    public static int f1665 = 81;

    /* renamed from: ֲۮܬ۴ݰ, reason: not valid java name and contains not printable characters */
    public static int f1635 = 82;

    /* renamed from: ׭حݭرڭ, reason: not valid java name and contains not printable characters */
    public static int f1642 = 83;

    /* renamed from: ֬֬֬ڴܰ, reason: not valid java name and contains not printable characters */
    public static int f1630 = 84;

    /* renamed from: ڲ֯ڱܱޭ, reason: contains not printable characters */
    public static int f1677 = 85;

    /* renamed from: ۴ٴ٭ٯ۫, reason: not valid java name and contains not printable characters */
    public static int f1691 = 91;

    /* renamed from: ٯ٬ڲۮݪ, reason: not valid java name and contains not printable characters */
    public static int f1668 = 92;

    /* renamed from: ۳ٲ׮ܮު, reason: not valid java name and contains not printable characters */
    public static long f1689 = 0;

    /* renamed from: حݱݱֲخ, reason: contains not printable characters */
    public static long f1655 = 0;

    /* renamed from: ׮ݱحֳد, reason: not valid java name and contains not printable characters */
    public static int f1644 = 0;

    /* renamed from: ܮݭۭڭܩ, reason: contains not printable characters */
    public static Context f1694 = null;

    /* renamed from: ױگ֭خڪ, reason: contains not printable characters */
    public static String f1646 = null;

    /* renamed from: ۭܳ۳֬ب, reason: not valid java name and contains not printable characters */
    public static String f1699 = null;

    /* renamed from: ۬ݯشׯ٫, reason: not valid java name and contains not printable characters */
    public static String f1683 = null;

    /* renamed from: ֲۯ٭֮ت, reason: not valid java name and contains not printable characters */
    public static String f1636 = null;

    /* renamed from: ײڬݯسگ, reason: contains not printable characters */
    public static int f1648 = 0;

    /* renamed from: ٳܮزڮܪ, reason: contains not printable characters */
    public static int f1671 = 0;

    /* renamed from: ۮݴجڴܰ, reason: contains not printable characters */
    public static int f1686 = 0;

    /* renamed from: ܱڳݭܲޮ, reason: not valid java name and contains not printable characters */
    public static long f1695 = 0;

    /* renamed from: ۳ڱִٴ۰, reason: not valid java name and contains not printable characters */
    public static long f1690 = 0;

    /* renamed from: ֳ֯رڮܪ, reason: not valid java name and contains not printable characters */
    public static Context f1633 = null;

    /* renamed from: ڲگ׬ݮߪ, reason: not valid java name and contains not printable characters */
    public static String f1679 = null;

    /* renamed from: ׳۲ݴ׮٪, reason: not valid java name and contains not printable characters */
    public static String f1650 = null;

    /* renamed from: ڲجݱگܫ, reason: contains not printable characters */
    public static String f1678 = C2571p.m1300("_");

    /* renamed from: ܳٮٮ٭۩, reason: not valid java name and contains not printable characters */
    public static String f1698 = null;

    /* renamed from: ٯܮܬجڨ, reason: contains not printable characters */
    private static String f1669 = null;

    /* renamed from: ׬׮ׯٳۯ, reason: not valid java name and contains not printable characters */
    private static String f1640 = null;

    /* renamed from: خ֯ڲ۲ݮ, reason: contains not printable characters */
    private static String f1656 = null;

    /* renamed from: ڮٴ׳ڱܭ, reason: not valid java name and contains not printable characters */
    private static String f1673 = null;

    /* renamed from: ݲسֲڲܮ, reason: contains not printable characters */
    private static int f1706 = 0;

    /* renamed from: ۮײײدګ, reason: contains not printable characters */
    private static int f1684 = 0;

    /* renamed from: خڮڬ׳ٯ, reason: not valid java name and contains not printable characters */
    private static int f1657 = 0;

    /* renamed from: ۲ݯܮݭߩ, reason: not valid java name and contains not printable characters */
    public static int f1688 = 0;

    /* renamed from: ٬ײۭݬߨ, reason: not valid java name and contains not printable characters */
    public static int f1662 = 0;

    /* renamed from: ׳ݳڴٲۮ, reason: not valid java name and contains not printable characters */
    public static int f1651 = 0;

    /* renamed from: ٱݲ֮شڰ, reason: contains not printable characters */
    private static int f1670 = 0;

    /* renamed from: ڮڴۮڱܭ, reason: contains not printable characters */
    public static String f1674 = null;

    /* renamed from: ״ܴڱ۲ݮ, reason: not valid java name and contains not printable characters */
    public static String f1653 = null;

    /* renamed from: ֲܮݬڭܩ, reason: not valid java name and contains not printable characters */
    private static final Set<String> f1637 = new HashSet();

    /* renamed from: ֯ڴح֭ة, reason: not valid java name and contains not printable characters */
    private static int f1634 = 0;

    /* renamed from: ݬش׭ݮߪ, reason: not valid java name and contains not printable characters */
    private static Application f1701 = null;

    /* renamed from: ݯױܭ۱ݭ, reason: contains not printable characters */
    public static native String m1345(Context context, String str, String str2, int i, int i2, int i3, Context context2, Application application, Object obj);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        m1336(context);
        super.attachBaseContext(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ִۭ֯֬ب, reason: not valid java name and contains not printable characters */
    public static void m1336(Context context) {
        int i;
        int i2;
        char c;
        String str;
        String str2;
        f1633 = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String property = System.getProperty(C2571p.m1300("J@UA\nWJ\u000e^DYSEN\u0001"));
        try {
            if (f1633.checkCallingOrSelfPermission(C2571p.m1300("U[SF_\\W\u001aLPMYQFH]K[\t}naffbp;")) == 0) {
                f1651 |= 1;
            }
            if (f1633.checkCallingOrSelfPermission(C2571p.m1300("igozc`k&plqemztawg5I_JZ[CV]M@^XZcVx\\m]*")) == 0) {
                f1651 |= 2;
            }
            if (f1633.checkCallingOrSelfPermission(C2571p.m1300("OAI\\EFM\u0000VJWCK\\RGQA\u0013|\u007f~lke{jjwctzKp]oIdHiC<")) == 0) {
                f1651 |= 16;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if ((applicationInfo.flags & 2) == 2) {
            f1651 |= DriveFile.MODE_READ_ONLY;
        }
        try {
            i = applicationInfo.minSdkVersion;
        } catch (Throwable th2) {
            i = Build.VERSION.SDK_INT;
        }
        int i3 = 0;
        if (Debug.isDebuggerConnected()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        f1707 = f1633.getPackageManager();
        f1661 = (ActivityManager) f1633.getSystemService(C2571p.m1300("NMXF]G\\\u0016"));
        String str3 = applicationInfo.packageName;
        f1646 = str3;
        try {
            PackageInfo packageInfo = f1707.getPackageInfo(str3, 0);
            f1647 = packageInfo;
            if (packageInfo != null) {
                f1692 = packageInfo.applicationInfo.loadLabel(f1707).toString();
                f1645 = f1647.versionCode;
                f1678 = f1647.versionName;
                StringBuilder insert = new StringBuilder().insert(0, f1678);
                insert.append(C2571p.m1300("\u0013"));
                f1678 = insert.toString();
                StringBuilder insert2 = new StringBuilder().insert(0, f1678);
                insert2.append(applicationInfo.packageName);
                f1678 = insert2.toString();
                StringBuilder insert3 = new StringBuilder().insert(0, f1678);
                insert3.append(C2571p.m1300("\u0013"));
                f1678 = insert3.toString();
                StringBuilder insert4 = new StringBuilder().insert(0, f1678);
                insert4.append(applicationInfo.dataDir);
                f1678 = insert4.toString();
                StringBuilder insert5 = new StringBuilder().insert(0, f1678);
                insert5.append(C2571p.m1300("\u0013"));
                f1678 = insert5.toString();
                StringBuilder insert6 = new StringBuilder().insert(0, f1678);
                insert6.append(applicationInfo.sourceDir);
                f1678 = insert6.toString();
                StringBuilder insert7 = new StringBuilder().insert(0, f1678);
                insert7.append(C2571p.m1300("\u0013"));
                f1678 = insert7.toString();
                StringBuilder insert8 = new StringBuilder().insert(0, f1678);
                insert8.append(applicationInfo.nativeLibraryDir);
                f1678 = insert8.toString();
                StringBuilder insert9 = new StringBuilder().insert(0, f1678);
                insert9.append(C2571p.m1300("\u0013"));
                f1678 = insert9.toString();
                StringBuilder insert10 = new StringBuilder().insert(0, f1678);
                insert10.append(i);
                f1678 = insert10.toString();
                StringBuilder insert11 = new StringBuilder().insert(0, f1678);
                insert11.append(C2571p.m1300("\u0013"));
                f1678 = insert11.toString();
                StringBuilder insert12 = new StringBuilder().insert(0, f1678);
                insert12.append(applicationInfo.targetSdkVersion);
                f1678 = insert12.toString();
                StringBuilder insert13 = new StringBuilder().insert(0, f1678);
                insert13.append(C2571p.m1300("\u0013"));
                f1678 = insert13.toString();
                StringBuilder insert14 = new StringBuilder().insert(0, f1678);
                insert14.append(applicationInfo.flags);
                f1678 = insert14.toString();
                StringBuilder insert15 = new StringBuilder().insert(0, f1678);
                insert15.append(C2571p.m1300("\u0013"));
                f1678 = insert15.toString();
                StringBuilder insert16 = new StringBuilder().insert(0, f1678);
                insert16.append(Build.VERSION.SDK_INT);
                f1678 = insert16.toString();
                StringBuilder insert17 = new StringBuilder().insert(0, f1678);
                insert17.append(C2571p.m1300("\u0013"));
                f1678 = insert17.toString();
                if (Build.VERSION.SDK_INT < 16) {
                    f1667 = applicationInfo.uid;
                } else {
                    f1667 = Process.myUid();
                }
                StringBuilder insert18 = new StringBuilder().insert(0, f1678);
                insert18.append(f1667);
                f1678 = insert18.toString();
                StringBuilder insert19 = new StringBuilder().insert(0, f1678);
                insert19.append(C2571p.m1300("\u0013"));
                f1678 = insert19.toString();
                StringBuilder insert20 = new StringBuilder().insert(0, f1678);
                insert20.append(Build.VERSION.RELEASE);
                f1678 = insert20.toString();
                StringBuilder insert21 = new StringBuilder().insert(0, f1678);
                insert21.append(C2571p.m1300("\u0013"));
                f1678 = insert21.toString();
                StringBuilder insert22 = new StringBuilder().insert(0, f1678);
                insert22.append(i2);
                f1678 = insert22.toString();
                StringBuilder insert23 = new StringBuilder().insert(0, f1678);
                insert23.append(C2571p.m1300("\u0013"));
                f1678 = insert23.toString();
                StringBuilder insert24 = new StringBuilder().insert(0, f1678);
                insert24.append(Build.SERIAL);
                f1678 = insert24.toString();
                f1636 = applicationInfo.dataDir;
            }
        } catch (Throwable th3) {
        }
        f1699 = f1633.getResources().getConfiguration().locale.getLanguage();
        f1683 = f1633.getResources().getConfiguration().locale.toString();
        try {
            C2571p.m1300("GCI[\u001f");
            System.loadLibrary("cawwyayy");
            c = 1;
        } catch (Throwable th4) {
            c = 65535;
        }
        if (c < 0) {
            try {
                Thread.sleep(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            } catch (Throwable th5) {
            }
            m1331(88);
        }
        StringBuilder insert25 = new StringBuilder().insert(0, property);
        insert25.append(C2571p.m1300("C"));
        insert25.append(Build.TIME);
        String sb = insert25.toString();
        if (Build.VERSION.SDK_INT < 21) {
            StringBuilder insert26 = new StringBuilder().insert(0, sb);
            insert26.append(C2571p.m1300("C"));
            insert26.append(Build.CPU_ABI2);
            str = insert26.toString();
        } else {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length <= 0) {
                str = sb;
            } else {
                int i4 = 0;
                while (i4 < strArr.length) {
                    String m1300 = C2571p.m1300("A");
                    if (i4 == 0) {
                        m1300 = C2571p.m1300("C");
                    }
                    StringBuilder insert27 = new StringBuilder().insert(0, sb);
                    insert27.append(m1300);
                    StringBuilder insert28 = new StringBuilder().insert(0, insert27.toString());
                    String str4 = strArr[i4];
                    i4++;
                    insert28.append(str4);
                    sb = insert28.toString();
                }
                str = sb;
            }
        }
        String[] split = m1345(f1633, str, f1678, f1645, f1651, 0, null, null, null).split(C2571p.m1300("C"));
        String str5 = null;
        if (split == null) {
            i3 = -100;
            str2 = null;
        } else if (split.length == 8) {
            String str6 = split[0];
            String str7 = split[1];
            f1684 = Integer.parseInt(split[4]);
            f1706 = Integer.parseInt(split[5], 16);
            f1686 = Integer.parseInt(split[6], 16);
            if (!split[7].equals(C2571p.m1300("AAB\n"))) {
                f1656 = split[7];
            }
            str2 = str6;
            str5 = str7;
        } else {
            try {
                i3 = Integer.parseInt(split[0]);
                str2 = null;
            } catch (Throwable th6) {
                str2 = null;
            }
        }
        if (i3 < 0) {
            m1331(i3);
        }
        if (str5 != null && !str5.equals(C2571p.m1300("A"))) {
            f1690 = System.currentTimeMillis();
            m1322(str2, str5);
            f1690 = System.currentTimeMillis() - f1690;
        }
        f1671 = 1;
        String str8 = f1698;
        if (str8 != null) {
            String[] split2 = str8.split(C2571p.m1300("C"));
            for (int i5 = 1; i5 < split2.length; i5++) {
                if (split2[i5].length() > 0) {
                    try {
                        m1342(split2[i5]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application
    public void onCreate() {
        m1320(0);
        m1335();
        Application application = f1701;
        if (application != null) {
            application.onCreate();
        }
        super.onCreate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ִۭ֯֬ب, reason: not valid java name and contains not printable characters */
    public static void m1335() {
        f1694 = f1633.getApplicationContext();
        m1330();
        int i = f1667;
        if (i >= 90000 && i <= 99999) {
            return;
        }
        try {
            new Thread(new Runnable() { // from class: com.liapp.ݭײܱײٮ
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    ApplicationC2576x.m1340();
                }
            }).start();
        } catch (Throwable th) {
            m1331(1);
        }
        f1676 = new Handler();
        RunnableC3085 runnableC3085 = new Runnable() { // from class: com.liapp.رگײܯޫ
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                ApplicationC2576x.m1311();
            }
        };
        f1687 = runnableC3085;
        f1676.postDelayed(runnableC3085, DateUtils.MILLIS_PER_DAY);
        f1670 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    public static /* synthetic */ void m1340() {
        m1325(f1638, 0, String.valueOf(f1690));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ֱح۳ۯݫ, reason: not valid java name and contains not printable characters */
    public static /* synthetic */ void m1311() {
        String str = f1653;
        if (str != null) {
            m1333(str);
            f1662 = 0;
        }
        if (f1669 != null) {
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("OB\u0002"));
            insert.append(C2571p.m1300("A"));
            StringBuilder insert2 = new StringBuilder().insert(0, insert.toString());
            insert2.append(C2571p.m1300("GCI[\u001f"));
            StringBuilder insert3 = new StringBuilder().insert(0, insert2.toString());
            insert3.append(C2571p.m1300("A"));
            StringBuilder insert4 = new StringBuilder().insert(0, insert3.toString());
            insert4.append(C2571p.m1300("\u0015"));
            try {
                Method method = Class.forName(insert4.toString()).getMethod(C2571p.m1300("\u000e"), String.class);
                if (method != null) {
                    try {
                        method.invoke(null, f1669);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            }
            f1669 = null;
        }
        if (f1662 > 0) {
            f1676.postDelayed(f1687, 512L);
        } else {
            f1676.postDelayed(f1687, DateUtils.MILLIS_PER_DAY);
        }
        f1670 = 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private static /* synthetic */ void m1330() {
        if (f1657 == 0) {
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("OB\u0002"));
            insert.append(C2571p.m1300("A"));
            StringBuilder insert2 = new StringBuilder().insert(0, insert.toString());
            insert2.append(C2571p.m1300("GCI[\u001f"));
            StringBuilder insert3 = new StringBuilder().insert(0, insert2.toString());
            insert3.append(C2571p.m1300("A"));
            StringBuilder insert4 = new StringBuilder().insert(0, insert3.toString());
            insert4.append(C2571p.m1300("\u0016"));
            String sb = insert4.toString();
            f1657++;
            try {
                f1666.loadClass(sb);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static Context m1320(int i) {
        String str = f1656;
        if (str != null && str.length() > 0 && f1701 == null) {
            try {
                f1694 = f1633.getApplicationContext();
                Application application = (Application) f1633.getClassLoader().loadClass(f1656).newInstance();
                f1701 = application;
                m1345(f1694, null, null, 0, 0, f1658, f1633, application, null);
                f1694 = f1633.getApplicationContext();
            } catch (Exception e) {
                e.printStackTrace();
            }
            m1330();
        }
        if (f1694 == null) {
            f1694 = f1633.getApplicationContext();
        }
        return f1694;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    public static void m1342(String str) throws UnsatisfiedLinkError {
        String str2;
        char c;
        String m1325 = m1325(f1705, f1652, str);
        if (m1325.equals(C2571p.m1300("A"))) {
            c = 1;
            str2 = str;
        } else {
            str2 = m1325;
            c = 0;
        }
        if (c > 0) {
            if (str2.contains(C2571p.m1300("@"))) {
                try {
                    System.load(str2);
                } catch (Throwable th) {
                }
            } else {
                try {
                    System.loadLibrary(str2);
                } catch (Throwable th2) {
                }
            }
            m1325(f1705, f1659, str2);
        }
        if (!str.equals(str2)) {
            m1325(f1705, f1664, str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ݯױܭ۱ݭ, reason: contains not printable characters */
    public static int m1344(String str) {
        final String[] split = str.split(C2571p.m1300("C"));
        if (split[0].equals(C2571p.m1300("|@FMc\\\u001b"))) {
            z.ڱܴ֭ٲۮ(split[1]);
            return 0;
        }
        if (split[0].equals(C2571p.m1300("V\u0017\u001bq\u001c["))) {
            try {
                System.load(split[1]);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        if (split[0].equals(C2571p.m1300("eae{ekbf``+"))) {
            return m1314();
        }
        if (split[0].equals(C2571p.m1300("dadqEAeAG\u000b"))) {
            try {
                if (split[1].contains(C2571p.m1300("@"))) {
                    try {
                        System.load(split[1]);
                    } catch (Throwable th2) {
                    }
                } else {
                    try {
                        System.loadLibrary(split[1]);
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                return 0;
            }
        } else {
            if (split[0].equals(C2571p.m1300("kOBB`_CK\n"))) {
                try {
                    LifeCycle.Lifecycle = 9;
                    return 0;
                } catch (Throwable th5) {
                    return 0;
                }
            }
            if (split[0].equals(C2571p.m1300("D@IEM@\u0001"))) {
                y.٬خݮ۳ݯ(C2571p.m1300("BOE\u0001"));
                return 0;
            }
            if (split[0].equals(C2571p.m1300("LFIL@~M]JGW\\JAN\u001c"))) {
                return m1318(split[1], 0);
            }
            if (split[0].equals(C2571p.m1300("^J_CC\\ZGIAiGQ\u001b"))) {
                int m1318 = m1318(split[1], 1);
                m1325(f1705, f1631, f1640);
                return m1318;
            }
            if (split[0].equals(C2571p.m1300("OL_X^F\u001f"))) {
                try {
                    new Thread(new Runnable() { // from class: com.liapp.ܳ٭ݯܲޮ
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            ApplicationC2576x.m1334(split);
                        }
                    }).start();
                    try {
                        Thread.sleep(64L);
                    } catch (Throwable th6) {
                    }
                } catch (Throwable th7) {
                    f1673 = C2571p.m1300("A[@\u0003");
                }
                int i = f1705;
                int i2 = f1682;
                StringBuilder insert = new StringBuilder().insert(0, split[1]);
                insert.append(C2571p.m1300("U"));
                insert.append(f1673);
                m1325(i, i2, insert.toString());
                return 0;
            }
            while (f1695 > 0) {
                if (System.currentTimeMillis() - f1695 > 4000) {
                    f1695 = 0L;
                }
                try {
                    Thread.sleep(128L);
                } catch (Throwable th8) {
                }
            }
            if (f1670 == 0) {
                try {
                    Thread.sleep(128L);
                } catch (Throwable th9) {
                }
            }
            for (int i3 = 0; i3 < 64 && f1669 != null; i3++) {
                try {
                    Thread.sleep(64L);
                } catch (Throwable th10) {
                }
            }
            f1669 = str;
            f1676.post(f1687);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static /* synthetic */ void m1334(String[] strArr) {
        try {
            Runtime runtime = Runtime.getRuntime();
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("HKX_YAXO"));
            insert.append(strArr[1]);
            insert.append(C2571p.m1300("\u000e_"));
            Process exec = runtime.exec(insert.toString());
            f1673 = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine();
            exec.destroy();
        } catch (IOException e) {
            f1673 = C2571p.m1300("A[@\u0003");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private static /* synthetic */ int m1318(String str, int i) {
        if (i > 0) {
            f1640 = "";
        }
        try {
            String[] strArr = f1707.getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return 0;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                try {
                    if (strArr[i4].equals(C2571p.m1300("ekcvolg*|`}iavxm{k9VUTFAOQ@MVVOEhIxTaFhEk@<"))) {
                        i3 |= 1;
                    } else {
                        if (!strArr[i4].equals(C2571p.m1300("OAI\\EFM\u0000VJWCK\\RGQA\u0013|\u007f~lke{jjwctzKp]oIdHiC<")) && !strArr[i4].equals(C2571p.m1300("N@H]DGL\u0001WKVBJ]SFP@\u0012grj}pxxq}\u007foipXgBkDy[O")) && !strArr[i4].equals(C2571p.m1300("N@H]DGL\u0001WKVBJ]SFP@\u0012~nkjvhoxcl~qlDoK*"))) {
                            if (strArr[i4].equals(C2571p.m1300("mck~gdo\"thuai~pesc1M[N^_GRDY@HAY\u007fH="))) {
                                i3 |= 16;
                            } else if (strArr[i4].equals(C2571p.m1300("OAI\\EFM\u0000VJWCK\\RGQA\u0013{jkxzspeoqdpiK|RyC{AaS{Z{QjSq_lIgU!"))) {
                                i3 |= 64;
                            } else if (strArr[i4].equals(C2571p.m1300("OAI\\EFM\u0000VJWCK\\RGQA\u0013|\u007fl|g`jj}\u007f<"))) {
                                i2 |= 1;
                            } else if (strArr[i4].equals(C2571p.m1300("U[SF_\\W\u001aLPMYQFH]K[\tfetgk\u007fx<"))) {
                                i2 |= 2;
                            } else if (strArr[i4].equals(C2571p.m1300("U[SF_\\W\u001aLPMYQFH]K[\tge{gk\u007fx<"))) {
                                i2 |= 4;
                            }
                        }
                        i3 |= 2;
                    }
                    if (i > 0) {
                        String[] split = strArr[i4].split(C2571p.m1300("A"));
                        if (split.length == 3 && split[0].equals(C2571p.m1300("IGOZC@\u000b")) && split[1].equals(C2571p.m1300("^J_CC\\ZGI\u0001"))) {
                            StringBuilder insert = new StringBuilder().insert(0, f1640);
                            insert.append(C2571p.m1300("\u0013"));
                            insert.append(split[2]);
                            f1640 = insert.toString();
                        }
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    return i3;
                }
            }
            if (i2 != 7) {
                return i3;
            }
            return i3 | 128;
        } catch (PackageManager.NameNotFoundException e2) {
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static int m1314() {
        try {
            int i = Settings.Global.getInt(f1633.getContentResolver(), C2571p.m1300("EAE{EKBF@@\u000b"), 0);
            if (i > 0) {
                return 1;
            }
            return i;
        } catch (Throwable th) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0043  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ java.lang.ClassLoader m1322(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.StringBuilder r0 = r0.insert(r1, r3)
            java.lang.String r2 = "@"
            java.lang.String r2 = com.liapp.C2571p.m1300(r2)
            r0.append(r2)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L40
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L3b
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L3b
            r0.add(r1)     // Catch: java.lang.Throwable -> L3b
            android.content.Context r4 = com.liapp.ApplicationC2576x.f1633     // Catch: java.lang.Throwable -> L3b
            int r3 = m1316(r4, r3, r0)     // Catch: java.lang.Throwable -> L3b
            goto L41
        L3b:
            r3 = move-exception
            r1 = -1
            r3.printStackTrace()
        L40:
            r3 = r1
        L41:
            if (r3 < 0) goto L4a
            android.content.Context r3 = com.liapp.ApplicationC2576x.f1633
            java.lang.ClassLoader r3 = r3.getClassLoader()
            goto L4b
        L4a:
            r3 = 0
        L4b:
            return r3
            fill-array 0x004c: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liapp.ApplicationC2576x.m1322(java.lang.String, java.lang.String):java.lang.ClassLoader");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ֲܯحױ٭, reason: not valid java name and contains not printable characters */
    public static void m1312() {
        String str = f1650;
        if (str != null) {
            f1669 = str;
            if (f1688 > 0) {
                f1688 = 0;
            }
            f1676.post(f1687);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static int m1315(int i, int i2, int i3) {
        return Integer.parseInt(m1345(f1694, null, null, i2 ^ f1706, i3, i, null, null, null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static String m1324(int i, int i2, int i3) {
        int i4;
        if (i3 >= 4) {
            i4 = i2;
        } else {
            i4 = i2 ^ f1706;
        }
        return m1345(f1694, null, null, i4, i3, i, null, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static int m1316(Context context, String str, List<File> list) {
        try {
            ApplicationInfo m1321 = m1321(context);
            if (m1321 == null) {
                return -14;
            }
            Set<String> set = f1637;
            synchronized (set) {
                String str2 = m1321.sourceDir;
                if (set.contains(str2)) {
                    return -13;
                }
                set.add(str2);
                try {
                    ClassLoader classLoader = context.getClassLoader();
                    f1666 = classLoader;
                    if (classLoader == null) {
                        return -11;
                    }
                    return m1317(f1666, new File(str), list);
                } catch (Throwable th) {
                    return -12;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -10;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private static /* synthetic */ ApplicationInfo m1321(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, 128);
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private static /* synthetic */ int m1317(ClassLoader classLoader, File file, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int m1297;
        int m1310;
        if (!list.isEmpty()) {
            if (Build.VERSION.SDK_INT < 23) {
                if (Build.VERSION.SDK_INT < 19) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        try {
                            return C2568g.m1286(classLoader, list, file);
                        } catch (Exception e) {
                            return 0;
                        }
                    }
                    m1297 = C2570o.m1297(classLoader, list);
                    return m1297;
                }
                m1310 = C2575v.m1310(classLoader, list, file);
                return m1310;
            }
            return C2567e.m1283(classLoader, list, file);
        }
        return -8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    public static /* synthetic */ Field m1338(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (Throwable th) {
            }
        }
        StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("hFHBNO"));
        insert.append(str);
        insert.append(C2571p.m1300("\u000eABZ\nIF[HK\u0005GLO"));
        insert.append(obj.getClass());
        throw new NoSuchFieldException(insert.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    public static /* synthetic */ Method m1339(Object obj, String str) throws NoSuchMethodException {
        Method declaredMethod;
        Class<?> cls = obj.getClass();
        while (true) {
            int i = 0;
            if (cls != null) {
                try {
                    Method[] declaredMethods = cls.getDeclaredMethods();
                    Class<?>[] clsArr = null;
                    int length = declaredMethods.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        Method method = declaredMethods[i];
                        if (!method.getName().equals(str)) {
                            i++;
                        } else {
                            clsArr = method.getParameterTypes();
                            f1634 = clsArr.length;
                            break;
                        }
                    }
                    declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                        break;
                    }
                    break;
                } catch (Throwable th) {
                    cls = cls.getSuperclass();
                }
            } else {
                StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("eL_@CMO"));
                insert.append(str);
                insert.append(C2571p.m1300("\u000eABZ\nIF[HK\u0005GLO"));
                insert.append(obj.getClass());
                throw new NoSuchMethodException(insert.toString());
            }
        }
        return declaredMethod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    public static /* synthetic */ void m1341(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field m1338 = m1338(obj, str);
        Object[] objArr2 = (Object[]) m1338.get(obj);
        if (!f1685 && objArr2 == null) {
            throw new AssertionError();
        }
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        m1338.set(obj, objArr3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static void m1331(int i) {
        try {
            Intent intent = new Intent();
            intent.setAction(C2571p.m1300("OAI\\EFM\u0000OAQKL[\u000fO][TAT\u0001to\u007f!"));
            intent.addCategory(C2571p.m1300("N@H]DGL\u0001N@PJMZ\u000eL^ZYHT\\A\u0001\u007fay*"));
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            f1694.startActivity(intent);
        } catch (Throwable th) {
        }
        if (i == 9579) {
            return;
        }
        StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("yc\fJSG\\FII\u0004XJZH\u000fMKOZWZ\u0018LXJQO"));
        insert.append(i);
        insert.append(C2571p.m1300("\u0002\u000fNBONG[V\u000fVEK_QKZA"));
        String sb = insert.toString();
        Log.w(C2571p.m1300("ooj~("), sb);
        System.exit(0);
        m1325(f1705, f1691, C2571p.m1300("_"));
        Process.killProcess(Process.myPid());
        throw new NullPointerException(sb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static void m1333(String str) {
        if (Build.VERSION.SDK_INT >= 23 && (f1651 & 16) != 16) {
            return;
        }
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT <= 24) {
            intent.setAction(C2571p.m1300("OAI\\EFM\u0000OAQKL[\u000fO][TAT\u0001to\u007f!"));
            intent.addCategory(C2571p.m1300("N@H]DGL\u0001N@PJMZ\u000eL^ZYHT\\A\u0001\u007fay*"));
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            f1694.startActivity(intent);
            try {
                Thread.sleep(32L);
            } catch (Throwable th) {
            }
        }
        try {
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("_OODJIMU"));
            insert.append(str);
            f1694.startActivity(new Intent(C2571p.m1300("N@H]DGL\u0001N@PJMZ\u000eN\\ZU@U\u0000|j{k`*"), Uri.parse(insert.toString())).setFlags(872415232));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Context context;
        int i = f1648;
        if (i == 0) {
            f1648 = 1;
        } else if (i == 1) {
            while (f1648 == 1) {
                try {
                    Thread.sleep(1L);
                } catch (Throwable th) {
                }
            }
        }
        if (f1656 != null && f1701 == null) {
            m1320(1);
        }
        f1648 = 2;
        Application application = f1701;
        if (application == null) {
            Context baseContext = getBaseContext();
            if (baseContext == null && (baseContext = super.getApplicationContext()) == null) {
                baseContext = this;
            }
            context = baseContext.getApplicationContext();
        } else {
            try {
                context = application.getApplicationContext();
            } catch (Throwable th2) {
                th2.printStackTrace();
                context = null;
            }
        }
        if (context == null) {
            return super.getApplicationContext();
        }
        return context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        Application application = f1701;
        return application == null ? getBaseContext().getAssets() : application.getAssets();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Application application = f1701;
        return application == null ? getBaseContext().getTheme() : application.getTheme();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        Application application = f1701;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Application application = f1701;
        if (application != null) {
            application.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Application application = f1701;
        if (application != null) {
            application.onTrimMemory(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        Application application = f1701;
        if (application != null) {
            application.onLowMemory();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        Application application = f1701;
        if (application != null) {
            application.onTerminate();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static String m1327(Context context, int i, int i2, String str, String str2) {
        return m1345(context, str2, str, i2, 0, i, null, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static String m1326(int i, int i2, String str, String str2) {
        return m1327(f1694, i, i2, str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static String m1325(int i, int i2, String str) {
        return m1327(f1694, i, i2, str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static int m1319(Certificate certificate, String str) {
        return Integer.parseInt(m1345(null, str, null, f1697, 0, f1705, null, null, certificate));
    }
}
