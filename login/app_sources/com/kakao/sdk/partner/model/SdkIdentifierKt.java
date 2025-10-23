package com.kakao.sdk.partner.model;

import com.kakao.sdk.common.model.SdkIdentifier;
import com.kakao.sdk.common.util.SdkLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* compiled from: SdkIdentifier.kt */
@Metadata(m838d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, m839d2 = {"create", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "Lcom/kakao/sdk/common/model/SdkIdentifier$Companion;", "infos", "", "", "partner-common_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SdkIdentifierKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final SdkIdentifier create(SdkIdentifier.Companion companion, Map<String, String> infos) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(infos, "infos");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : infos.entrySet()) {
            sb.append(StringUtils.SPACE + entry.getKey() + '/' + entry.getValue());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply {\n…       }\n    }.toString()");
        SdkLog.INSTANCE.m469d(sb2);
        return new SdkIdentifier(sb2);
    }
}
