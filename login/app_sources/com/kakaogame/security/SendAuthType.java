package com.kakaogame.security;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SecondaryPWService.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/security/SendAuthType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TALK", "SMS", "EMAIL", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SendAuthType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SendAuthType[] $VALUES;
    public static final SendAuthType EMAIL;
    public static final SendAuthType SMS;
    public static final SendAuthType TALK;
    private final String value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final /* synthetic */ SendAuthType[] $values() {
        return new SendAuthType[]{TALK, SMS, EMAIL};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EnumEntries<SendAuthType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SendAuthType valueOf(String str) {
        return (SendAuthType) Enum.valueOf(SendAuthType.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SendAuthType[] values() {
        return (SendAuthType[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SendAuthType(String str, int i, String str2) {
        this.value = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String str = y.٬ݯح׭٩(576351286);
        TALK = new SendAuthType(str, 0, str);
        String str2 = y.ۮڭڭܬި(862609915);
        SMS = new SendAuthType(str2, 1, str2);
        String str3 = y.֬ڱܱײٮ(-1158918911);
        EMAIL = new SendAuthType(str3, 2, str3);
        SendAuthType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
