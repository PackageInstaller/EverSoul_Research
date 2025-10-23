package com.singular.sdk.internal;

/* loaded from: classes3.dex */
public class SingularGlobalProperty {
    public static final int GLOBAL_PROPERTIES_LIMIT = 5;
    private static final int GLOBAL_PROPERTY_MAX_LENGTH = 200;
    private String key;
    private boolean overrideExisting;
    private String value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularGlobalProperty(String str, String str2, boolean z) {
        this.key = str;
        this.value = str2;
        this.overrideExisting = z;
        if (str.length() > 200) {
            this.key = this.key.substring(0, 200);
        }
        if (this.value.length() > 200) {
            this.value = this.value.substring(0, 200);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isOverrideExisting() {
        return this.overrideExisting;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getKey() {
        return this.key;
    }
}
