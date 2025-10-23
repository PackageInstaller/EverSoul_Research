package com.kakaogame.util;

import android.content.Context;
import android.util.Log;
import com.liapp.y;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: FileUtil.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J*\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J2\u0010\u0010\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0007J,\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/util/FileUtil;", "", "()V", "READ_BLOCK_SIZE", "", "TAG", "", "checkFolder", "context", "Landroid/content/Context;", "folderName", "countLimit", "", "limitSize", "read", "fileName", "write", "text", "", "writeTmpFile", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class FileUtil {
    public static final FileUtil INSTANCE = new FileUtil();
    public static final int READ_BLOCK_SIZE = 100;
    private static final String TAG = "FileUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FileUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String checkFolder(Context context, String folderName, long countLimit, long limitSize) {
        String str = y.֬ڱܱײٮ(-1159006823);
        String str2 = y.ۮڭڭܬި(862896579);
        String str3 = y.ٲٴݴ״ٰ(1782560376);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(folderName, y.٬ݯح׭٩(576286190));
        try {
            File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + folderName);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            Arrays.sort(listFiles);
            int length = listFiles.length;
            Log.v(str, str3 + length);
            if (length == 0) {
                return null;
            }
            long j = length;
            if (j >= countLimit) {
                long j2 = j - countLimit;
                if (j2 >= 100) {
                    j2 = 100;
                }
                Log.v(str, str2 + j2);
                long j3 = 0;
                if (0 <= j2) {
                    while (true) {
                        listFiles[(int) j3].delete();
                        if (j3 == j2) {
                            break;
                        }
                        j3++;
                    }
                }
            }
            int i = length - 1;
            if (listFiles[i].length() < 1048576 * limitSize) {
                return listFiles[i].getName();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String writeTmpFile(android.content.Context r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 1512979991(0x5a2e3e17, float:1.2261229E16)
            java.lang.String r0 = com.liapp.y.ݬֲ֮ܲت(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 576286190(0x22596dee, float:2.946718E-18)
            java.lang.String r0 = com.liapp.y.٬ݯح׭٩(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1782384304(0x6a3d06b0, float:5.712964E25)
            java.lang.String r0 = com.liapp.y.ٲٴݴ״ٰ(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r1.<init>()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.io.File r3 = r3.getFilesDir()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.StringBuilder r3 = r1.append(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            boolean r1 = r4.exists()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            if (r1 != 0) goto L4c
            r4.mkdirs()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
        L4c:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r5 = 1
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L71
            byte[] r5 = r6.getBytes(r5)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L71
            java.lang.String r6 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L71
            r3.write(r5)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L71
            java.lang.String r0 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L71
            r3.close()     // Catch: java.io.IOException -> L82
            goto L82
        L6d:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L85
        L71:
            r4 = move-exception
            r2 = r4
            r4 = r3
            r3 = r2
            goto L7a
        L76:
            r3 = move-exception
            goto L85
        L78:
            r3 = move-exception
            r4 = r0
        L7a:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L83
            if (r4 == 0) goto L82
            r4.close()     // Catch: java.io.IOException -> L82
        L82:
            return r0
        L83:
            r3 = move-exception
            r0 = r4
        L85:
            if (r0 == 0) goto L8a
            r0.close()     // Catch: java.io.IOException -> L8a
        L8a:
            throw r3
            fill-array 0x008c: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.util.FileUtil.writeTmpFile(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final long write(Context context, String folderName, String fileName, String text) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(folderName, y.٬ݯح׭٩(576286190));
        Intrinsics.checkNotNullParameter(text, y.ٲٴݴ״ٰ(1782384304));
        FileOutputStream fileOutputStream = null;
        try {
            try {
                String str = context.getFilesDir().getAbsolutePath() + File.separator + folderName;
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str, fileName);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2, true);
                try {
                    byte[] bytes = text.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    fileOutputStream2.write(bytes);
                    long length = file2.length();
                    try {
                        fileOutputStream2.close();
                        return length;
                    } catch (IOException unused) {
                        return length;
                    }
                } catch (Exception e) {
                    fileOutputStream = fileOutputStream2;
                    e = e;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return 0L;
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.String] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean write(Context context, String folderName, String fileName, String text, long limitSize) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(folderName, y.٬ݯح׭٩(576286190));
        Intrinsics.checkNotNullParameter(text, y.ٲٴݴ״ٰ(1782384304));
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        boolean z = false;
        try {
            try {
                File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + folderName, fileName);
                FileOutputStream fileOutputStream3 = new FileOutputStream(file, true);
                try {
                    byte[] bytes = text.getBytes(Charsets.UTF_8);
                    ?? r0 = "this as java.lang.String).getBytes(charset)";
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    fileOutputStream3.write(bytes);
                    if (limitSize != 0) {
                        if (file.length() > 1048576 * limitSize) {
                            z = true;
                        }
                    }
                    fileOutputStream3.close();
                    fileOutputStream = r0;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream3;
                    e.printStackTrace();
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                        fileOutputStream = fileOutputStream2;
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a4, code lost:
    
        if (r1 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String read(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            r0 = 1512979991(0x5a2e3e17, float:1.2261229E16)
            java.lang.String r0 = com.liapp.y.ݬֲ֮ܲت(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 576286190(0x22596dee, float:2.946718E-18)
            java.lang.String r0 = com.liapp.y.٬ݯح׭٩(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1393450378(0x530e5d8a, float:6.114547E11)
            java.lang.String r0 = com.liapp.y.ٴسسݬߨ(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = ""
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            r2.<init>()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.String r4 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r2.append(r4)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.String r2 = java.io.File.separator     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r2)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            boolean r4 = r5.exists()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            if (r4 == 0) goto L98
            boolean r4 = r5.canRead()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            if (r4 == 0) goto L98
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            r5 = 512(0x200, float:7.17E-43)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
        L64:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r1 = -1
            if (r6 == r1) goto L8d
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r1 = "forName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r1.<init>(r5, r6)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r6.<init>()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.StringBuilder r6 = r6.append(r1)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L64
        L8d:
            r4.close()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r1 = r4
            goto L98
        L92:
            r5 = move-exception
            r1 = r4
            goto La8
        L95:
            r5 = move-exception
            r1 = r4
            goto La1
        L98:
            if (r1 == 0) goto La7
        L9a:
            r1.close()     // Catch: java.io.IOException -> La7
            goto La7
        L9e:
            r5 = move-exception
            goto La8
        La0:
            r5 = move-exception
        La1:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L9e
            if (r1 == 0) goto La7
            goto L9a
        La7:
            return r0
        La8:
            if (r1 == 0) goto Lad
            r1.close()     // Catch: java.io.IOException -> Lad
        Lad:
            throw r5
            fill-array 0x00ae: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.util.FileUtil.read(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }
}
