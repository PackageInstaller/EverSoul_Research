package com.kakaogame;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: KGKakaoAuthType.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/KGKakaoAuthType;", "", "authType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAuthType", "()Ljava/lang/String;", "KakaoTalk", "KakaoWeb", "KakaoAllType", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoAuthType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KGKakaoAuthType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String authType;
    public static final KGKakaoAuthType KakaoTalk = new KGKakaoAuthType(y.ٴسسݬߨ(1392603682), 0, y.دײܮڳܯ(2051567701));
    public static final KGKakaoAuthType KakaoWeb = new KGKakaoAuthType(y.دײܮڳܯ(2051567957), 1, y.֬ڱܱײٮ(-1159647255));
    public static final KGKakaoAuthType KakaoAllType = new KGKakaoAuthType(y.֬ڱܱײٮ(-1159647527), 2, y.ٲٴݴ״ٰ(1781820512));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ KGKakaoAuthType[] $values() {
        return new KGKakaoAuthType[]{KakaoTalk, KakaoWeb, KakaoAllType};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<KGKakaoAuthType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KGKakaoAuthType valueOf(String str) {
        return (KGKakaoAuthType) Enum.valueOf(KGKakaoAuthType.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KGKakaoAuthType[] values() {
        return (KGKakaoAuthType[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoAuthType(String str, int i, String str2) {
        this.authType = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAuthType() {
        return this.authType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        KGKakaoAuthType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: KGKakaoAuthType.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGKakaoAuthType$Companion;", "", "()V", "get", "Lcom/kakaogame/KGKakaoAuthType;", "name", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGKakaoAuthType get(String name) {
            if (Intrinsics.areEqual(name, KGKakaoAuthType.KakaoTalk.getAuthType())) {
                return KGKakaoAuthType.KakaoTalk;
            }
            if (Intrinsics.areEqual(name, KGKakaoAuthType.KakaoWeb.getAuthType())) {
                return KGKakaoAuthType.KakaoWeb;
            }
            if (Intrinsics.areEqual(name, KGKakaoAuthType.KakaoAllType.getAuthType())) {
                return KGKakaoAuthType.KakaoAllType;
            }
            return null;
        }
    }
}
