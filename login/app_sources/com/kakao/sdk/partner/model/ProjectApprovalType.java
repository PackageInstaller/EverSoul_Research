package com.kakao.sdk.partner.model;

import com.kakao.sdk.common.model.ApprovalType;
import kotlin.Metadata;

/* compiled from: ProjectApprovalType.kt */
@Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakao/sdk/partner/model/ProjectApprovalType;", "Lcom/kakao/sdk/common/model/ApprovalType;", "()V", "value", "", "getValue", "()Ljava/lang/String;", "partner-common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ProjectApprovalType extends ApprovalType {
    private final String value = "project";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ApprovalType
    public String getValue() {
        return this.value;
    }
}
