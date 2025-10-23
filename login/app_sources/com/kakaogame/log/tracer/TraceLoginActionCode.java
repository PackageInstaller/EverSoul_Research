package com.kakaogame.log.tracer;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TracerCode.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/log/tracer/TraceLoginActionCode;", "", "(Ljava/lang/String;I)V", "SDK_COPPA_UI", "SDK_IDP_LOGIN", "SDK_IDP_PROFILE", "SDK_SHOW_AGREEMENT", "SDK_AGREEMENT_WEB_LOADING", "SDK_AGREEMENT_WEB_CLOSE", "SDK_KAKAO_SIGN_UP", "SDK_IDP_LIST_POPUP", "SDK_GUEST_POPUP", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TraceLoginActionCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TraceLoginActionCode[] $VALUES;
    public static final TraceLoginActionCode SDK_COPPA_UI = new TraceLoginActionCode(y.֬ڱܱײٮ(-1158720487), 0);
    public static final TraceLoginActionCode SDK_IDP_LOGIN = new TraceLoginActionCode(y.ݬֲ֮ܲت(1512448527), 1);
    public static final TraceLoginActionCode SDK_IDP_PROFILE = new TraceLoginActionCode(y.ٲٴݴ״ٰ(1782191384), 2);
    public static final TraceLoginActionCode SDK_SHOW_AGREEMENT = new TraceLoginActionCode(y.ݮڮֲڭܩ(-628408636), 3);
    public static final TraceLoginActionCode SDK_AGREEMENT_WEB_LOADING = new TraceLoginActionCode(y.ݮڮֲڭܩ(-628408476), 4);
    public static final TraceLoginActionCode SDK_AGREEMENT_WEB_CLOSE = new TraceLoginActionCode(y.ۮڭڭܬި(862678331), 5);
    public static final TraceLoginActionCode SDK_KAKAO_SIGN_UP = new TraceLoginActionCode(y.ݮڮֲڭܩ(-628412284), 6);
    public static final TraceLoginActionCode SDK_IDP_LIST_POPUP = new TraceLoginActionCode(y.֬ڱܱײٮ(-1158719407), 7);
    public static final TraceLoginActionCode SDK_GUEST_POPUP = new TraceLoginActionCode(y.ݮڮֲڭܩ(-628411812), 8);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ TraceLoginActionCode[] $values() {
        return new TraceLoginActionCode[]{SDK_COPPA_UI, SDK_IDP_LOGIN, SDK_IDP_PROFILE, SDK_SHOW_AGREEMENT, SDK_AGREEMENT_WEB_LOADING, SDK_AGREEMENT_WEB_CLOSE, SDK_KAKAO_SIGN_UP, SDK_IDP_LIST_POPUP, SDK_GUEST_POPUP};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<TraceLoginActionCode> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TraceLoginActionCode valueOf(String str) {
        return (TraceLoginActionCode) Enum.valueOf(TraceLoginActionCode.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TraceLoginActionCode[] values() {
        return (TraceLoginActionCode[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TraceLoginActionCode(String str, int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        TraceLoginActionCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
