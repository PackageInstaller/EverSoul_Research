package com.liapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: خ׮ٱ֮ت.java */
/* renamed from: com.liapp.g */
/* loaded from: classes4.dex */
public final class C2568g {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private /* synthetic */ C2568g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public static /* synthetic */ int m1286(ClassLoader classLoader, List<File> list, File file) throws Exception {
        Object obj = ApplicationC2576x.m1338((Object) classLoader, C2571p.m1300("_OXGgG[\u001b")).get(classLoader);
        Object[] m1287 = m1287(obj, (ArrayList<File>) new ArrayList(list), file);
        if (m1287 != null) {
            ApplicationC2576x.m1341(obj, C2571p.m1300("@@_aL@NABQ\u001c"), m1287);
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private static /* synthetic */ Object[] m1287(Object obj, ArrayList<File> arrayList, File file) {
        try {
            return (Object[]) ApplicationC2576x.m1339(obj, C2571p.m1300("M@HE`D_eDDFEBU\u001c")).invoke(obj, arrayList, file);
        } catch (Throwable th) {
            return null;
        }
    }
}
