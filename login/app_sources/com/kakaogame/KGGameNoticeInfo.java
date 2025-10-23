package com.kakaogame;

import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: KGGameNoticeInfo.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\b\u0000\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/KGGameNoticeInfo;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "detailLink", "getDetailLink", "()Ljava/lang/String;", "message", "getMessage", "periodBeginTime", "", "getPeriodBeginTime", "()J", "periodEndTime", "getPeriodEndTime", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGGameNoticeInfo extends KGObject {
    private static final String TAG = "KGGameNoticeInfo";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGGameNoticeInfo(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMessage() {
        return (String) get(y.دײܮڳܯ(2051551053));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDetailLink() {
        return (String) get(y.٬ݯح׭٩(575849926));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getPeriodBeginTime() {
        try {
            Number number = (Number) get("periodBeginTime");
            if (number != null) {
                return number.longValue();
            }
            return 0L;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512581583), e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getPeriodEndTime() {
        try {
            Number number = (Number) get("periodEndTime");
            if (number != null) {
                return number.longValue();
            }
            return 0L;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512581583), e.toString(), e);
            return 0L;
        }
    }
}
