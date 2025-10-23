package com.kakaogame.session;

import com.kakaogame.server.ServerRequest;
import com.kakaogame.util.Base64Util;
import com.kakaogame.util.StringUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionUtil.kt */
@Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/session/SessionUtil;", "", "()V", "TRANSACTION_NO", "", "getCompressedMessage", "request", "Lcom/kakaogame/server/ServerRequest;", "getConnectParameter", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SessionUtil {
    public static final SessionUtil INSTANCE = new SessionUtil();
    public static final String TRANSACTION_NO = "txNo";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SessionUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getConnectParameter(ServerRequest request) {
        StringBuffer stringBuffer = new StringBuffer(y.٬ݯح׭٩(576330870));
        if (request != null) {
            stringBuffer.append(y.֬ڱܱײٮ(-1159100935) + INSTANCE.getCompressedMessage(request));
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
        return stringBuffer2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getCompressedMessage(ServerRequest request) {
        return Base64Util.getUrlSafeBase64(StringUtil.compress(request.getRequestMessage()));
    }
}
