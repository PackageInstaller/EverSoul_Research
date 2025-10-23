package com.kakaogame.secondpw.viewdata;

import com.kakaogame.secondpw.PasswordViewType;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ResultData.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/ResultData;", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", ServerConstants.TRACE_RESULT_CODE, "", Base2ndPWViewData.KEY_ACCESS_KEY, "", "(ILjava/lang/String;)V", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ResultData extends Base2ndPWViewData {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResultData(int i, String str) {
        put(y.ٲٴݴ״ٰ(1781623144), PasswordViewType.RESULT.getValue());
        put(y.ٴسسݬߨ(1392585418), Integer.valueOf(i));
        if (str != null) {
            put(Base2ndPWViewData.KEY_ACCESS_KEY, str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ResultData(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }
}
