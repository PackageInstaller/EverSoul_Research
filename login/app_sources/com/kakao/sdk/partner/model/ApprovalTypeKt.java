package com.kakao.sdk.partner.model;

import com.kakao.sdk.common.model.ApprovalType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProjectApprovalType.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m839d2 = {"project", "Lcom/kakao/sdk/common/model/ApprovalType;", "Lcom/kakao/sdk/common/model/ApprovalType$Companion;", "partner-common_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ApprovalTypeKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final ApprovalType project(ApprovalType.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new ProjectApprovalType();
    }
}
