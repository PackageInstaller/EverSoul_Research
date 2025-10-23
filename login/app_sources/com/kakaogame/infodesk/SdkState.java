package com.kakaogame.infodesk;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InfodeskService.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/infodesk/SdkState;", "", "(Ljava/lang/String;I)V", "INIT", "BEFORE_LOGIN", "AFTER_LOGIN", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SdkState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SdkState[] $VALUES;
    public static final SdkState INIT = new SdkState(y.֬ڱܱײٮ(-1158846575), 0);
    public static final SdkState BEFORE_LOGIN = new SdkState(y.֬ڱܱײٮ(-1158806199), 1);
    public static final SdkState AFTER_LOGIN = new SdkState(y.ݮڮֲڭܩ(-628462412), 2);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ SdkState[] $values() {
        return new SdkState[]{INIT, BEFORE_LOGIN, AFTER_LOGIN};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<SdkState> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SdkState valueOf(String str) {
        return (SdkState) Enum.valueOf(SdkState.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SdkState[] values() {
        return (SdkState[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SdkState(String str, int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        SdkState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
