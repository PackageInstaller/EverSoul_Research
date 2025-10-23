package com.kakaogame.log;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.FileUtil;
import com.kakaogame.util.NetworkUtil;
import com.kakaogame.util.TelephonyUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.lang3.StringUtils;

/* compiled from: APILatencyLogManager.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\"\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m839d2 = {"Lcom/kakaogame/log/APILatencyLogManager;", "", "()V", "TAG", "", "bufferLock", "fileName", "folderName", "limitSize", "", "postFix", "used", "", "setNewFileName", "", "name", "setPostFix", "str", "uploadFile", "context", "Landroid/content/Context;", "uploadFileToS3", "useLantencyLog", "writeApiCall", "uri", "result", "Lcom/kakaogame/server/KeyBaseResult;", "latency", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class APILatencyLogManager {
    private static final String TAG = "APILatencyLogManager";
    private static final String folderName = "KGLatency";
    private static final long limitSize = 524288;
    private static boolean used;
    public static final APILatencyLogManager INSTANCE = new APILatencyLogManager();
    private static String postFix = "";
    private static String fileName = "";
    private static final Object bufferLock = new Object();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private APILatencyLogManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void useLantencyLog(String name) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        used = true;
        fileName = name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setNewFileName(String name) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        fileName = name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setPostFix(String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576465878));
        postFix = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void writeApiCall(String uri, KeyBaseResult<?> result, long latency) {
        String str = y.ٴسسݬߨ(1393551642);
        Intrinsics.checkNotNullParameter(uri, y.ۮڭڭܬި(862392755));
        Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
        if (used && !StringsKt.contains$default((CharSequence) uri, (CharSequence) y.ݮڮֲڭܩ(-628367916), false, 2, (Object) null)) {
            Log.d(y.֬ڱܱײٮ(-1158695631), y.ٲٴݴ״ٰ(1782248728) + postFix);
            Context context = CoreManager.INSTANCE.getInstance().getContext();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(CoreManager.INSTANCE.getInstance().currentTimeMillis());
            stringBuffer.append(y.ٲٴݴ״ٰ(1781559176));
            stringBuffer.append(uri);
            stringBuffer.append(",");
            stringBuffer.append(latency);
            stringBuffer.append(",");
            stringBuffer.append(NetworkUtil.getNetworkType(context));
            stringBuffer.append(",");
            stringBuffer.append(TelephonyUtil.getNetworkOperatorName(context));
            stringBuffer.append(",");
            stringBuffer.append(result.getCode());
            stringBuffer.append(",");
            stringBuffer.append(result.getDescription());
            stringBuffer.append(",");
            stringBuffer.append(DeviceUtil.getDeviceModel());
            stringBuffer.append(",");
            stringBuffer.append(Build.VERSION.SDK_INT);
            stringBuffer.append(",");
            stringBuffer.append(postFix);
            stringBuffer.append(StringUtils.f1524LF);
            synchronized (bufferLock) {
                String str2 = fileName;
                String stringBuffer2 = stringBuffer.toString();
                Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
                Log.d(TAG, str + FileUtil.write(context, folderName, str2, stringBuffer2));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void uploadFileToS3(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new APILatencyLogManager$uploadFileToS3$1(context, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0136 A[Catch: Exception -> 0x016c, TRY_LEAVE, TryCatch #2 {Exception -> 0x016c, blocks: (B:3:0x0015, B:7:0x0022, B:10:0x0069, B:12:0x008b, B:31:0x0122, B:36:0x0104, B:37:0x012e, B:39:0x0136, B:33:0x012a, B:48:0x015d, B:53:0x0165, B:50:0x0168, B:51:0x016b, B:60:0x00f9, B:62:0x0101), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void uploadFile(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.log.APILatencyLogManager.uploadFile(android.content.Context):void");
    }
}
