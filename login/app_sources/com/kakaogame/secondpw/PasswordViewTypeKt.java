package com.kakaogame.secondpw;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordViewType.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m839d2 = {"getViewType", "Lcom/kakaogame/secondpw/PasswordViewType;", "", "security_release"}, m840k = 2, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PasswordViewTypeKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final PasswordViewType getViewType(String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(575694806));
        return Intrinsics.areEqual(str, PasswordViewType.GUIDE_CENTER.getValue()) ? PasswordViewType.GUIDE_CENTER : Intrinsics.areEqual(str, PasswordViewType.GUIDE_3_LINE.getValue()) ? PasswordViewType.GUIDE_3_LINE : Intrinsics.areEqual(str, PasswordViewType.GUIDE_2_LINE.getValue()) ? PasswordViewType.GUIDE_2_LINE : Intrinsics.areEqual(str, PasswordViewType.INPUT_CODE.getValue()) ? PasswordViewType.INPUT_CODE : Intrinsics.areEqual(str, PasswordViewType.INPUT_PHONE.getValue()) ? PasswordViewType.INPUT_PHONE : Intrinsics.areEqual(str, PasswordViewType.INPUT_EMAIL.getValue()) ? PasswordViewType.INPUT_EMAIL : Intrinsics.areEqual(str, PasswordViewType.SET_PASSWORD.getValue()) ? PasswordViewType.SET_PASSWORD : Intrinsics.areEqual(str, PasswordViewType.INPUT_PASSWORD.getValue()) ? PasswordViewType.INPUT_PASSWORD : Intrinsics.areEqual(str, PasswordViewType.POPUP_RESTRICT.getValue()) ? PasswordViewType.POPUP_RESTRICT : Intrinsics.areEqual(str, PasswordViewType.RESET_DIGIT_CODE.getValue()) ? PasswordViewType.RESET_DIGIT_CODE : Intrinsics.areEqual(str, PasswordViewType.RESULT.getValue()) ? PasswordViewType.RESULT : PasswordViewType.POPUP;
    }
}
