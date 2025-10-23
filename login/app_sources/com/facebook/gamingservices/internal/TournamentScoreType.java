package com.facebook.gamingservices.internal;

import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: TournamentScoreType.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m839d2 = {"Lcom/facebook/gamingservices/internal/TournamentScoreType;", "", "(Ljava/lang/String;I)V", "NUMERIC", "TIME", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public enum TournamentScoreType {
    NUMERIC,
    TIME;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: values, reason: to resolve conflict with enum method */
    public static TournamentScoreType[] valuesCustom() {
        TournamentScoreType[] valuesCustom = values();
        return (TournamentScoreType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
