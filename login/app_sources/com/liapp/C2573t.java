package com.liapp;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: ٬۬ٮ׳ٯ.java */
/* renamed from: com.liapp.t */
/* loaded from: classes4.dex */
public class C2573t implements X509TrustManager {

    /* renamed from: ״ܴڱ۲ݮ, reason: not valid java name and contains not printable characters */
    private static final int f1625 = 7;

    /* renamed from: ٳܮزڮܪ, reason: contains not printable characters */
    private static final int f1626 = 2;

    /* renamed from: ִٱۮܴް, reason: not valid java name and contains not printable characters */
    private final String f1627;

    /* renamed from: ײڬݯسگ, reason: contains not printable characters */
    private final X509TrustManagerExtensions f1628;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2573t(String str, X509TrustManager x509TrustManager) {
        this.f1627 = str;
        if (Build.VERSION.SDK_INT < 17) {
            this.f1628 = null;
        } else {
            this.f1628 = new X509TrustManagerExtensions(x509TrustManager);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        boolean z;
        boolean z2;
        List<X509Certificate> asList = Arrays.asList(x509CertificateArr);
        try {
            asList = this.f1628.checkServerTrusted(x509CertificateArr, str, this.f1627);
            z = false;
            z2 = false;
        } catch (CertificateException e) {
            if (Build.VERSION.SDK_INT >= 24 && e.getMessage().startsWith(C2571p.m1300("hPU\u0018J\\MQVPPY@PXV\b_JQ@\\\u000b"))) {
                z = false;
                z2 = true;
            } else {
                z = true;
                z2 = false;
            }
        }
        if (!z && !z) {
            z2 = !m1304(asList);
        }
        if (z) {
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("mJ_ZCI@MG[@\u000eTNMGZNIGUA\u0019HWFYKV\u000fWA|O"));
            insert.append(this.f1627);
            throw new CertificateException(insert.toString());
        }
        if (z2) {
            throw new CertificateException(new StringBuilder().insert(0, C2571p.m1300("\u007f[QCG\u0012dZU\u0012NVM[ZZ@STZH\\\u0004UJ[DV\u000b")).toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private /* synthetic */ boolean m1304(List<X509Certificate> list) {
        boolean z;
        Iterator<X509Certificate> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (ApplicationC2576x.m1319((Certificate) it.next(), (String) null) > 0) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z || ApplicationC2576x.m1319((Certificate) null, this.f1627) <= 0) {
            return z;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException(C2571p.m1300("mCDKD[\tMC]QGDFBOJJN\u000eT@M\u000eEZE^]]EKjN"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public String m1307(Certificate certificate) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(C2571p.m1300("{aj\u0005\u001e\u001cY"));
            messageDigest.reset();
            byte[] digest = messageDigest.digest(certificate.getPublicKey().getEncoded());
            MessageDigest messageDigest2 = MessageDigest.getInstance(C2571p.m1300("aiZ"));
            messageDigest2.update(digest);
            return Base64.encodeToString(messageDigest2.digest(), 0).trim();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(C2571p.m1300("oUPITY\u001bRQKRN\u0010URL\\X\u0001"));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ֱح۳ۯݫ, reason: not valid java name and contains not printable characters */
    public boolean m1306(String str, X509Certificate x509Certificate) {
        if (Pattern.compile(C2571p.m1300("\u0006t\u001d\u0003\u0013N\u0004Hg\u0002cs\b\u0015z\u001e\u0013\u0016\\\u0003\\n\u0014h\f\u0001h\u0004\u001bS\u0019uRK#s!F")).matcher(this.f1627).matches()) {
            return m1305(str, x509Certificate);
        }
        return m1303(str, x509Certificate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    private /* synthetic */ boolean m1305(String str, X509Certificate x509Certificate) {
        List<String> m1301 = m1301(x509Certificate, 7);
        int size = m1301.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(m1301.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private /* synthetic */ boolean m1303(String str, X509Certificate x509Certificate) {
        String m1296;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> m1301 = m1301(x509Certificate, 2);
        int size = m1301.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (m1302(lowerCase, m1301.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (m1296 = new C2569l(x509Certificate.getSubjectX500Principal()).m1296(C2571p.m1300("M\u0001"))) == null) {
            return false;
        }
        return m1302(lowerCase, m1296);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private static /* synthetic */ List<String> m1301(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private /* synthetic */ boolean m1302(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(C2571p.m1300("A")) || str.endsWith(C2571p.m1300("\u0000A")) || str2 == null || str2.length() == 0 || str2.startsWith(C2571p.m1300("A")) || str2.endsWith(C2571p.m1300("\u0000A"))) {
            return false;
        }
        if (!str.endsWith(C2571p.m1300("A"))) {
            StringBuilder insert = new StringBuilder().insert(0, str);
            insert.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            str = insert.toString();
        }
        if (!str2.endsWith(C2571p.m1300("A"))) {
            StringBuilder insert2 = new StringBuilder().insert(0, str2);
            insert2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            str2 = insert2.toString();
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains(C2571p.m1300("E"))) {
            if (str.startsWith(C2571p.m1300("GZX_X\u0014\u0007@"))) {
                str = str.substring(8);
            }
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith(C2571p.m1300("\u0004A")) || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || C2571p.m1300("\u0004A").equals(lowerCase)) {
            return false;
        }
        String substring = lowerCase.substring(1);
        if (!str.endsWith(substring)) {
            return false;
        }
        int length = str.length() - substring.length();
        return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
    }
}
