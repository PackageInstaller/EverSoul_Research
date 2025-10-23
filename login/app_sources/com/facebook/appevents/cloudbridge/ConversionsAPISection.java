package com.facebook.appevents.cloudbridge;

import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: AppEventsConversionsAPITransformer.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m839d2 = {"Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "USER_DATA", "APP_DATA", "CUSTOM_DATA", "CUSTOM_EVENTS", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public enum ConversionsAPISection {
    USER_DATA("user_data"),
    APP_DATA("app_data"),
    CUSTOM_DATA("custom_data"),
    CUSTOM_EVENTS("custom_events");

    private final String rawValue;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ConversionsAPISection(String str) {
        this.rawValue = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRawValue() {
        return this.rawValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ConversionsAPISection[] valuesCustom() {
        ConversionsAPISection[] valuesCustom = values();
        return (ConversionsAPISection[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
