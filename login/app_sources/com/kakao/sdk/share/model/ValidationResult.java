package com.kakao.sdk.share.model;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValidationResult.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, m839d2 = {"Lcom/kakao/sdk/share/model/ValidationResult;", "", "templateId", "", "templateArgs", "Lcom/google/gson/JsonObject;", "templateMsg", "warningMsg", "argumentMsg", "(JLcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;)V", "getArgumentMsg", "()Lcom/google/gson/JsonObject;", "getTemplateArgs", "getTemplateId", "()J", "getTemplateMsg", "getWarningMsg", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ValidationResult {
    private final JsonObject argumentMsg;
    private final JsonObject templateArgs;
    private final long templateId;
    private final JsonObject templateMsg;
    private final JsonObject warningMsg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ValidationResult copy$default(ValidationResult validationResult, long j, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3, JsonObject jsonObject4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = validationResult.templateId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            jsonObject = validationResult.templateArgs;
        }
        JsonObject jsonObject5 = jsonObject;
        if ((i & 4) != 0) {
            jsonObject2 = validationResult.templateMsg;
        }
        JsonObject jsonObject6 = jsonObject2;
        if ((i & 8) != 0) {
            jsonObject3 = validationResult.warningMsg;
        }
        JsonObject jsonObject7 = jsonObject3;
        if ((i & 16) != 0) {
            jsonObject4 = validationResult.argumentMsg;
        }
        return validationResult.copy(j2, jsonObject5, jsonObject6, jsonObject7, jsonObject4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long component1() {
        return this.templateId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject component2() {
        return this.templateArgs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject component3() {
        return this.templateMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject component4() {
        return this.warningMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject component5() {
        return this.argumentMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ValidationResult copy(long templateId, JsonObject templateArgs, JsonObject templateMsg, JsonObject warningMsg, JsonObject argumentMsg) {
        Intrinsics.checkNotNullParameter(templateMsg, "templateMsg");
        return new ValidationResult(templateId, templateArgs, templateMsg, warningMsg, argumentMsg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidationResult)) {
            return false;
        }
        ValidationResult validationResult = (ValidationResult) other;
        return this.templateId == validationResult.templateId && Intrinsics.areEqual(this.templateArgs, validationResult.templateArgs) && Intrinsics.areEqual(this.templateMsg, validationResult.templateMsg) && Intrinsics.areEqual(this.warningMsg, validationResult.warningMsg) && Intrinsics.areEqual(this.argumentMsg, validationResult.argumentMsg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Long.hashCode(this.templateId) * 31;
        JsonObject jsonObject = this.templateArgs;
        int hashCode2 = (((hashCode + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31) + this.templateMsg.hashCode()) * 31;
        JsonObject jsonObject2 = this.warningMsg;
        int hashCode3 = (hashCode2 + (jsonObject2 == null ? 0 : jsonObject2.hashCode())) * 31;
        JsonObject jsonObject3 = this.argumentMsg;
        return hashCode3 + (jsonObject3 != null ? jsonObject3.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ValidationResult(templateId=" + this.templateId + ", templateArgs=" + this.templateArgs + ", templateMsg=" + this.templateMsg + ", warningMsg=" + this.warningMsg + ", argumentMsg=" + this.argumentMsg + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ValidationResult(long j, JsonObject jsonObject, JsonObject templateMsg, JsonObject jsonObject2, JsonObject jsonObject3) {
        Intrinsics.checkNotNullParameter(templateMsg, "templateMsg");
        this.templateId = j;
        this.templateArgs = jsonObject;
        this.templateMsg = templateMsg;
        this.warningMsg = jsonObject2;
        this.argumentMsg = jsonObject3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getTemplateId() {
        return this.templateId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getTemplateArgs() {
        return this.templateArgs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getTemplateMsg() {
        return this.templateMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getWarningMsg() {
        return this.warningMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getArgumentMsg() {
        return this.argumentMsg;
    }
}
