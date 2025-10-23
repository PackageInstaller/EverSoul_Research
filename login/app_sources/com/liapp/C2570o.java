package com.liapp;

import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

/* compiled from: ֳ۬ٯܮު.java */
/* renamed from: com.liapp.o */
/* loaded from: classes4.dex */
public final class C2570o {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private /* synthetic */ C2570o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static /* synthetic */ int m1297(ClassLoader classLoader, List<File> list) throws IllegalArgumentException {
        try {
            int size = list.size();
            Field m1338 = ApplicationC2576x.m1338((Object) classLoader, C2571p.m1300("_OX\u0007"));
            StringBuilder sb = new StringBuilder((String) m1338.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                StringBuilder insert = new StringBuilder().insert(0, absolutePath);
                insert.append(C2571p.m1300("\u0001JI\u0017"));
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, insert.toString(), 0);
            }
            m1338.set(classLoader, sb.toString());
            ApplicationC2576x.m1341(classLoader, C2571p.m1300("C\u007fLZB\u001c"), strArr);
            ApplicationC2576x.m1341(classLoader, C2571p.m1300("CiDBO\u001c"), fileArr);
            ApplicationC2576x.m1341(classLoader, C2571p.m1300("FpA[\u001c"), zipFileArr);
            ApplicationC2576x.m1341(classLoader, C2571p.m1300("FnMS\u001c"), dexFileArr);
            return 0;
        } catch (Throwable th) {
            return -1;
        }
    }
}
