package com.kakaogame.log.tracer;

import com.liapp.y;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TracerCode.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/log/tracer/TraceJobCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SDK_LOGIN", "SDK_AUTO_LOGIN", "SDK_CONNECT", "GAME_CUSTOM", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TraceJobCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TraceJobCode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    public static final TraceJobCode SDK_LOGIN = new TraceJobCode(y.ۮڭڭܬި(862676555), 0, 1000);
    public static final TraceJobCode SDK_AUTO_LOGIN = new TraceJobCode(y.ݮڮֲڭܩ(-628409468), 1, 2000);
    public static final TraceJobCode SDK_CONNECT = new TraceJobCode(y.دײܮڳܯ(2051410469), 2, 4000);
    public static final TraceJobCode GAME_CUSTOM = new TraceJobCode(y.ۮڭڭܬި(862675339), 3, 9000);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ TraceJobCode[] $values() {
        return new TraceJobCode[]{SDK_LOGIN, SDK_AUTO_LOGIN, SDK_CONNECT, GAME_CUSTOM};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<TraceJobCode> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TraceJobCode valueOf(String str) {
        return (TraceJobCode) Enum.valueOf(TraceJobCode.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TraceJobCode[] values() {
        return (TraceJobCode[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TraceJobCode(String str, int i, int i2) {
        this.code = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getCode() {
        return this.code;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        TraceJobCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: TracerCode.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/log/tracer/TraceJobCode$Companion;", "", "()V", "get", "Lcom/kakaogame/log/tracer/TraceJobCode;", "name", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final TraceJobCode get(String name) {
            Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
            String lowerCase = name.toLowerCase(Locale.ROOT);
            String str = y.ݮڮֲڭܩ(-628797244);
            Intrinsics.checkNotNullExpressionValue(lowerCase, str);
            String lowerCase2 = y.ۮڭڭܬި(862676555).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, str);
            return Intrinsics.areEqual(lowerCase, lowerCase2) ? TraceJobCode.SDK_LOGIN : TraceJobCode.GAME_CUSTOM;
        }
    }
}
