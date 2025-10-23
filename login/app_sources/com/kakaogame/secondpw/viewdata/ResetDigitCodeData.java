package com.kakaogame.secondpw.viewdata;

import com.kakaogame.secondpw.ActionType;
import com.kakaogame.secondpw.PasswordViewType;
import com.kakaogame.util.json.JSONArray;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResetDigitCodeData.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/ResetDigitCodeData;", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "path1", "", "keys1", "path2", "keys2", "keypadLimitTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ResetDigitCodeData extends Base2ndPWViewData {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResetDigitCodeData(String str, String str2, String str3, String str4, int i) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1393058818));
        Intrinsics.checkNotNullParameter(str2, y.دײܮڳܯ(2051106533));
        Intrinsics.checkNotNullParameter(str3, y.ٲٴݴ״ٰ(1782414296));
        Intrinsics.checkNotNullParameter(str4, y.دײܮڳܯ(2051106677));
        put(y.ٲٴݴ״ٰ(1781623144), PasswordViewType.RESET_DIGIT_CODE.getValue());
        JSONArray jSONArray = new JSONArray();
        String str5 = y.دײܮڳܯ(2051509965);
        jSONArray.add(MapsKt.mapOf(TuplesKt.m846to(str5, str), TuplesKt.m846to("key", str2)));
        boolean z = str3.length() == 0;
        String str6 = y.֬ڱܱײٮ(-1159583711);
        String str7 = y.٬ݯح׭٩(575818342);
        String str8 = y.ٴسسݬߨ(1393037386);
        if (z) {
            put(str8, MapsKt.mapOf(TuplesKt.m846to(str7, Integer.valueOf(i)), TuplesKt.m846to(str6, ActionType.KEYPAD_TIME_LIMIT_1.getValue())));
        } else {
            jSONArray.add(MapsKt.mapOf(TuplesKt.m846to(str5, str3), TuplesKt.m846to("key", str4)));
            put(str8, MapsKt.mapOf(TuplesKt.m846to(str7, Integer.valueOf(i)), TuplesKt.m846to(str6, ActionType.KEYPAD_TIME_LIMIT_2.getValue())));
        }
        put(Base2ndPWViewData.KEY_KEYPAD, jSONArray);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ResetDigitCodeData(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, i);
    }
}
