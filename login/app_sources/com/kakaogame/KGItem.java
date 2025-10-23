package com.kakaogame;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.StringsKt;

/* compiled from: KGItem.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u001f\b\u0000\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\nR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\n¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/KGItem;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "expiryTime", "", "getExpiryTime", "()J", "itemCode", "getItemCode", "()Ljava/lang/String;", "itemId", "getItemId", FirebaseAnalytics.Param.QUANTITY, "getQuantity", "state", "Lcom/kakaogame/KGItem$KGItemState;", "getState", "()Lcom/kakaogame/KGItem$KGItemState;", "validityTime", "getValidityTime", "Companion", "KGItemState", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGItem extends KGObject {
    private static final String TAG = "KGItem";
    private static final long serialVersionUID = -1350114578412805647L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGItem(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getItemId() {
        return (String) get(y.ٴسسݬߨ(1392603290));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getItemCode() {
        return (String) get(y.ۮڭڭܬި(862263619));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getQuantity() {
        try {
            Number number = (Number) get(FirebaseAnalytics.Param.QUANTITY);
            if (number != null) {
                return number.longValue();
            }
            return 0L;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051568197), e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getValidityTime() {
        try {
            Number number = (Number) get("validityTime");
            if (number != null) {
                return number.longValue();
            }
            return 0L;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051568197), e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getExpiryTime() {
        try {
            Number number = (Number) get("expiryTime");
            if (number != null) {
                return number.longValue();
            }
            return 0L;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051568197), e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGItemState getState() {
        String str = (String) get(y.֬ڱܱײٮ(-1159648199));
        if (StringsKt.equals(y.ۮڭڭܬި(862263307), str, true)) {
            return KGItemState.CONFIRMED;
        }
        if (StringsKt.equals(y.دײܮڳܯ(2051568613), str, true) || StringsKt.equals(y.دײܮڳܯ(2051568517), str, true)) {
            return KGItemState.UNCONFIRMED;
        }
        return KGItemState.EXPIRED;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGItem.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/KGItem$KGItemState;", "", "(Ljava/lang/String;I)V", "UNCONFIRMED", "CONFIRMED", "EXPIRED", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGItemState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGItemState[] $VALUES;
        public static final KGItemState UNCONFIRMED = new KGItemState(y.֬ڱܱײٮ(-1159648751), 0);
        public static final KGItemState CONFIRMED = new KGItemState(y.֬ڱܱײٮ(-1159648599), 1);
        public static final KGItemState EXPIRED = new KGItemState(y.֬ڱܱײٮ(-1159648559), 2);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGItemState[] $values() {
            return new KGItemState[]{UNCONFIRMED, CONFIRMED, EXPIRED};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGItemState> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGItemState valueOf(String str) {
            return (KGItemState) Enum.valueOf(KGItemState.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGItemState[] values() {
            return (KGItemState[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGItemState(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGItemState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
