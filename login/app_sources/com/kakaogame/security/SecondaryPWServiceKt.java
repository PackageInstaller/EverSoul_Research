package com.kakaogame.security;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecondaryPWService.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m839d2 = {"getSendAuthType", "Lcom/kakaogame/security/SendAuthType;", "", "security_release"}, m840k = 2, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SecondaryPWServiceKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final SendAuthType getSendAuthType(String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(575694806));
        return Intrinsics.areEqual(str, SendAuthType.SMS.getValue()) ? SendAuthType.SMS : Intrinsics.areEqual(str, SendAuthType.EMAIL.getValue()) ? SendAuthType.EMAIL : SendAuthType.TALK;
    }
}
