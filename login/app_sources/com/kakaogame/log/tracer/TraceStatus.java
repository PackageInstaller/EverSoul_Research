package com.kakaogame.log.tracer;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Tracer.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/log/tracer/TraceStatus;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "ENABLED", "DISABLED", "STOPPED", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TraceStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TraceStatus[] $VALUES;
    public static final TraceStatus UNKNOWN = new TraceStatus(y.٬ݯح׭٩(576019982), 0);
    public static final TraceStatus ENABLED = new TraceStatus(y.֬ڱܱײٮ(-1158718551), 1);
    public static final TraceStatus DISABLED = new TraceStatus(y.ݮڮֲڭܩ(-628411764), 2);
    public static final TraceStatus STOPPED = new TraceStatus(y.ݬֲ֮ܲت(1512609375), 3);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ TraceStatus[] $values() {
        return new TraceStatus[]{UNKNOWN, ENABLED, DISABLED, STOPPED};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<TraceStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TraceStatus valueOf(String str) {
        return (TraceStatus) Enum.valueOf(TraceStatus.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TraceStatus[] values() {
        return (TraceStatus[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TraceStatus(String str, int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        TraceStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
