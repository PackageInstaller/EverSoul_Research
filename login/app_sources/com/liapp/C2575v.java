package com.liapp;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ڴگݲخڪ.java */
/* renamed from: com.liapp.v */
/* loaded from: classes4.dex */
public final class C2575v {

    /* renamed from: ִٱۮܴް, reason: not valid java name and contains not printable characters */
    public static final /* synthetic */ boolean f1629 = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private /* synthetic */ C2575v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    public static /* synthetic */ int m1310(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        IOException[] iOExceptionArr;
        Object obj = ApplicationC2576x.m1338((Object) classLoader, C2571p.m1300("_OXGgG[\u001b")).get(classLoader);
        ArrayList arrayList = new ArrayList();
        Object[] m1309 = m1309(obj, new ArrayList(list), file, arrayList, classLoader);
        if (m1309 != null) {
            ApplicationC2576x.m1341(obj, C2571p.m1300("@@_aL@NABQ\u001c"), m1309);
            if (arrayList.size() > 0) {
                if (!f1629 && obj == null) {
                    throw new AssertionError();
                }
                Field m1338 = ApplicationC2576x.m1338(obj, C2571p.m1300("TTKuXTZUVEHcIAOBEBPU@t_SMA_YC_\u001c"));
                IOException[] iOExceptionArr2 = (IOException[]) m1338.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[0]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                m1338.set(obj, iOExceptionArr);
            }
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private static /* synthetic */ Object[] m1309(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2, ClassLoader classLoader) {
        try {
            Method m1339 = ApplicationC2576x.m1339(obj, C2571p.m1300("M@HE`D_eDDFEBU\u001c"));
            return ApplicationC2576x.f1634 == 4 ? (Object[]) m1339.invoke(obj, arrayList, file, arrayList2, classLoader) : (Object[]) m1339.invoke(obj, arrayList, file, arrayList2);
        } catch (Throwable th) {
            return null;
        }
    }
}
