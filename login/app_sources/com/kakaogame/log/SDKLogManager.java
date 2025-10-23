package com.kakaogame.log;

import android.content.Context;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.infodesk.InfodeskService;
import com.kakaogame.server.ServerSecurityManager;
import com.kakaogame.util.AES256Cipher;
import com.kakaogame.util.DateUtil;
import com.kakaogame.util.FileUtil;
import com.kakaogame.util.PreferenceUtil;
import com.liapp.y;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.lang3.StringUtils;

/* compiled from: SDKLogManager.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J \u0010#\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, m839d2 = {"Lcom/kakaogame/log/SDKLogManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkKeys", "", "", "fileCountLimit", "", "fileName", "fileSizeLimit", FirebaseAnalytics.Param.INDEX, "isSaveOnFile", "", "isUpload", "isUploadNow", "()Z", "uploadLock", "writeLock", "checkSendFilesImmediately", "checkSendLogFile", "completeSendFilesImmediately", "", "getLevelCode", "", FirebaseAnalytics.Param.LEVEL, "", "getTokenInsertChar", "msg", "initSDKLogManager", "offSaveOnFile", "setIsUpload", "upload", "setNewFileName", "uploadFile", "folder", "uploadLogFiles", "uploadLogFilesImmediately", "writeLogOnFile", "logData", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SDKLogManager {
    private static final int FILE_MAX_COUNT = 20;
    private static final String SEND_LOG_FILES_IMMEDIATELY = "sendLogImmediately";
    private static final String TAG = "SDKLogManager";
    private static final String folderName = "KGLog";
    private static final String prefName = "kglogIndex";
    private final Set<String> checkKeys;
    private final Context context;
    private long fileCountLimit;
    private String fileName;
    private long fileSizeLimit;
    private long index;
    private boolean isSaveOnFile;
    private boolean isUpload;
    private final Object uploadLock;
    private final Object writeLock;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final char getLevelCode(int level) {
        if (level == 3) {
            return 'd';
        }
        if (level == 4) {
            return 'i';
        }
        if (level != 5) {
            return level != 6 ? 'd' : 'e';
        }
        return 'w';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SDKLogManager(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        this.context = context;
        this.isSaveOnFile = true;
        this.fileSizeLimit = 1L;
        this.fileCountLimit = 5L;
        HashSet hashSet = new HashSet();
        this.checkKeys = hashSet;
        this.uploadLock = new Object();
        this.writeLock = new Object();
        hashSet.add(y.ݬֲ֮ܲت(1512499703));
        hashSet.add(y.دײܮڳܯ(2051457173));
        hashSet.add(y.ݬֲ֮ܲت(1512499335));
        hashSet.add(y.ٴسسݬߨ(1393541922));
        hashSet.add(y.ٴسسݬߨ(1393548370));
        hashSet.add(y.֬ڱܱײٮ(-1158708903));
        hashSet.add(y.ٴسسݬߨ(1393548426));
        hashSet.add(y.ݬֲ֮ܲت(1512502983));
        initSDKLogManager();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isUploadNow() {
        boolean z;
        synchronized (this.uploadLock) {
            z = this.isUpload;
            Unit unit = Unit.INSTANCE;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setIsUpload(boolean upload) {
        synchronized (this.uploadLock) {
            this.isUpload = upload;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean checkSendLogFile() {
        /*
            r4 = this;
            com.kakaogame.KGLocalPlayer$Companion r0 = com.kakaogame.KGLocalPlayer.INSTANCE
            com.kakaogame.KGLocalPlayer r0 = r0.getCurrentPlayer()
            r1 = 1
            if (r0 == 0) goto L2e
            com.kakaogame.KGLocalPlayer$Companion r0 = com.kakaogame.KGLocalPlayer.INSTANCE
            com.kakaogame.KGLocalPlayer r0 = r0.getCurrentPlayer()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r2 = -1158795711(0xffffffffbaee2e41, float:-0.0018171744)
            java.lang.String r2 = com.liapp.y.֬ڱܱײٮ(r2)
            java.lang.String r0 = r0.getCustomProperty(r2)
            if (r0 == 0) goto L2e
            r2 = 2051939573(0x7a4e1cf5, float:2.6755012E35)
            java.lang.String r2 = com.liapp.y.دײܮڳܯ(r2)
            boolean r0 = kotlin.text.StringsKt.equals(r2, r0, r1)
            if (r0 == 0) goto L2e
            r0 = r1
            goto L2f
        L2e:
            r0 = 0
        L2f:
            com.kakaogame.infodesk.InfodeskHelper r2 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE
            boolean r2 = r2.sendLogFile()
            if (r2 == 0) goto L38
            goto L39
        L38:
            r1 = r0
        L39:
            if (r1 == 0) goto L3e
            r2 = 20
            goto L44
        L3e:
            com.kakaogame.infodesk.InfodeskHelper r0 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE
            long r2 = r0.getLogFileCount()
        L44:
            r4.fileCountLimit = r2
            com.kakaogame.infodesk.InfodeskHelper r0 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE
            long r2 = r0.getLogFileSize()
            r4.fileSizeLimit = r2
            return r1
            fill-array 0x0050: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.log.SDKLogManager.checkSendLogFile():boolean");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean checkSendFilesImmediately() {
        if (KGLocalPlayer.INSTANCE.getCurrentPlayer() != null) {
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer);
            String customProperty = currentPlayer.getCustomProperty(y.ݬֲ֮ܲت(1512502807));
            if (customProperty != null && StringsKt.equals(y.دײܮڳܯ(2051939573), customProperty, true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void completeSendFilesImmediately() {
        if (KGLocalPlayer.INSTANCE.getCurrentPlayer() != null) {
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer);
            currentPlayer.saveCustomProperty(y.ݬֲ֮ܲت(1512502807), y.ٲٴݴ״ٰ(1781635312));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void offSaveOnFile() {
        this.isSaveOnFile = false;
        File file = new File(this.context.getFilesDir().getAbsolutePath() + File.separator + y.دײܮڳܯ(2051464285));
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setNewFileName() {
        Context context = this.context;
        String str = y.دײܮڳܯ(2051463789);
        long j = PreferenceUtil.getLong(context, str, str, 0L);
        this.index = j;
        if (j + 1 == Long.MAX_VALUE) {
            this.index = 0L;
        }
        Context context2 = this.context;
        long j2 = this.index + 1;
        this.index = j2;
        PreferenceUtil.setLong(context2, str, str, j2);
        this.fileName = DateUtil.convertLongToFormattedString(CoreManager.INSTANCE.getInstance().currentTimeMillis()) + '-' + this.index + y.٬ݯح׭٩(576461902);
        Log.v(y.֬ڱܱײٮ(-1158702039), y.ٴسسݬߨ(1393547506) + this.fileName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void writeLogOnFile(String logData) {
        synchronized (this.writeLock) {
            if (FileUtil.write(this.context, folderName, this.fileName, logData, this.fileSizeLimit)) {
                uploadLogFiles(this.context);
                FileUtil.checkFolder(this.context, folderName, this.fileCountLimit, this.fileSizeLimit);
                setNewFileName();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTokenInsertChar(String msg) {
        String str = msg;
        for (String str2 : this.checkKeys) {
            Intrinsics.checkNotNull(str);
            String str3 = str;
            if (StringsKt.contains$default((CharSequence) str3, (CharSequence) str2, false, 2, (Object) null)) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, str2, 0, false, 6, (Object) null) + str2.length() + 10;
                Intrinsics.checkNotNull(msg);
                if (indexOf$default < msg.length()) {
                    StringBuilder sb = new StringBuilder();
                    String substring = str.substring(0, indexOf$default);
                    String str4 = y.٬ݯح׭٩(576592158);
                    Intrinsics.checkNotNullExpressionValue(substring, str4);
                    StringBuilder append = sb.append(substring).append('x');
                    String substring2 = str.substring(indexOf$default, msg.length());
                    Intrinsics.checkNotNullExpressionValue(substring2, str4);
                    str = append.append(substring2).toString();
                }
            }
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initSDKLogManager() {
        checkSendLogFile();
        String checkFolder = FileUtil.checkFolder(this.context, y.دײܮڳܯ(2051464285), this.fileCountLimit, this.fileSizeLimit);
        this.fileName = checkFolder;
        if (checkFolder == null) {
            setNewFileName();
        }
        if (InfodeskHelper.INSTANCE.offWriteLogToFile()) {
            offSaveOnFile();
        }
        if (this.isSaveOnFile) {
            writeLogOnFile(y.֬ڱܱײٮ(-1158708391) + DateUtil.convertLongToFormattedString(CoreManager.INSTANCE.getInstance().currentTimeMillis()) + y.ݬֲ֮ܲت(1512502287));
        }
        Logger.INSTANCE.addLoggingEventListener(new Logger.LoggingEventListener() { // from class: com.kakaogame.log.SDKLogManager$initSDKLogManager$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.Logger.LoggingEventListener
            public void onLog(int loggingLevel, String tag, String msg, Throwable tr) {
                boolean z;
                String tokenInsertChar;
                char levelCode;
                String encryptIV;
                z = SDKLogManager.this.isSaveOnFile;
                if (z && loggingLevel >= 3) {
                    tokenInsertChar = SDKLogManager.this.getTokenInsertChar(msg);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(DateUtil.convertLongToFormattedString(CoreManager.INSTANCE.getInstance().currentTimeMillis()));
                    stringBuffer.append(y.ٴسسݬߨ(1392956562));
                    levelCode = SDKLogManager.this.getLevelCode(loggingLevel);
                    stringBuffer.append(levelCode);
                    stringBuffer.append("]");
                    stringBuffer.append(tag);
                    stringBuffer.append("::");
                    stringBuffer.append(tokenInsertChar);
                    stringBuffer.append(StringUtils.f1524LF);
                    try {
                        String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
                        if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null) {
                            return;
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
                        SDKLogManager.this.writeLogOnFile("[Encrypted Log]" + AES256Cipher.encodeString(encryptKey, encryptIV, stringBuffer2) + '\n');
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int uploadFile(Context context, String folder, String fileName) {
        String str = y.ٴسسݬߨ(1393417658);
        String str2 = y.֬ڱܱײٮ(-1158702039);
        try {
            KGResult<String> createUploadUrl = InfodeskService.createUploadUrl(folder, fileName);
            if (!createUploadUrl.isSuccess()) {
                return -1;
            }
            String content = createUploadUrl.getContent();
            File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + folderName + File.separator + fileName);
            if (file.length() == 0) {
                return 200;
            }
            URL url = new URL(content);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
            Intrinsics.checkNotNull(uRLConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            httpsURLConnection.setConnectTimeout(20000);
            httpsURLConnection.setReadTimeout(20000);
            httpsURLConnection.setHostnameVerifier(ServerSecurityManager.getHostnameVerifier(url));
            httpsURLConnection.setSSLSocketFactory(ServerSecurityManager.getSSLSocketFactory());
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.PUT);
            httpsURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (file.exists() && file.canRead()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[2048];
                            while (fileInputStream2.read(bArr) != -1) {
                                dataOutputStream.write(bArr, 0, 2048);
                            }
                            fileInputStream = fileInputStream2;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            Log.e(str2, str + e);
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (IOException unused) {
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            System.gc();
                            return -1;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (IOException unused3) {
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            System.gc();
                            throw th;
                        }
                    }
                    try {
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    } catch (IOException unused5) {
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    System.gc();
                    return httpsURLConnection.getResponseCode();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            Log.e(str2, str + e3);
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void uploadLogFiles(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        if (checkSendFilesImmediately()) {
            uploadLogFilesImmediately(context);
        } else {
            if (!checkSendLogFile() || isUploadNow() || CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SDKLogManager$uploadLogFiles$1(this, context, null), 3, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void uploadLogFilesImmediately(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        if (isUploadNow()) {
            return;
        }
        if (!CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SDKLogManager$uploadLogFilesImmediately$1(this, context, null), 3, null);
        } else {
            Log.d(TAG, y.֬ڱܱײٮ(-1158708175));
        }
    }
}
