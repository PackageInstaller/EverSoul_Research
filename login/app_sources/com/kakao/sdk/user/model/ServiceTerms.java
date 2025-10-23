package com.kakao.sdk.user.model;

import com.kakao.sdk.user.Constants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserServiceTerms.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, m839d2 = {"Lcom/kakao/sdk/user/model/ServiceTerms;", "", "tag", "", Constants.REQUIRED, "", Constants.AGREED, Constants.REVOCABLE, "agreedAt", "Ljava/util/Date;", "(Ljava/lang/String;ZZZLjava/util/Date;)V", "getAgreed", "()Z", "getAgreedAt", "()Ljava/util/Date;", "getRequired", "getRevocable", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServiceTerms {
    private final boolean agreed;
    private final Date agreedAt;
    private final boolean required;
    private final boolean revocable;
    private final String tag;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ServiceTerms copy$default(ServiceTerms serviceTerms, String str, boolean z, boolean z2, boolean z3, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serviceTerms.tag;
        }
        if ((i & 2) != 0) {
            z = serviceTerms.required;
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            z2 = serviceTerms.agreed;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = serviceTerms.revocable;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            date = serviceTerms.agreedAt;
        }
        return serviceTerms.copy(str, z4, z5, z6, date);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.tag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component2() {
        return this.required;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component3() {
        return this.agreed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component4() {
        return this.revocable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component5() {
        return this.agreedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServiceTerms copy(String tag, boolean required, boolean agreed, boolean revocable, Date agreedAt) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new ServiceTerms(tag, required, agreed, revocable, agreedAt);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceTerms)) {
            return false;
        }
        ServiceTerms serviceTerms = (ServiceTerms) other;
        return Intrinsics.areEqual(this.tag, serviceTerms.tag) && this.required == serviceTerms.required && this.agreed == serviceTerms.agreed && this.revocable == serviceTerms.revocable && Intrinsics.areEqual(this.agreedAt, serviceTerms.agreedAt);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = this.tag.hashCode() * 31;
        boolean z = this.required;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.agreed;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.revocable;
        int i5 = (i4 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        Date date = this.agreedAt;
        return i5 + (date == null ? 0 : date.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ServiceTerms(tag=" + this.tag + ", required=" + this.required + ", agreed=" + this.agreed + ", revocable=" + this.revocable + ", agreedAt=" + this.agreedAt + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ServiceTerms(String tag, boolean z, boolean z2, boolean z3, Date date) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.required = z;
        this.agreed = z2;
        this.revocable = z3;
        this.agreedAt = date;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTag() {
        return this.tag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getRequired() {
        return this.required;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getAgreed() {
        return this.agreed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getRevocable() {
        return this.revocable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getAgreedAt() {
        return this.agreedAt;
    }
}
