package com.kakao.sdk.user.model;

import com.kakao.sdk.user.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserRevokedServiceTerms.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m839d2 = {"Lcom/kakao/sdk/user/model/RevokedServiceTerms;", "", "tag", "", Constants.AGREED, "", "(Ljava/lang/String;Z)V", "getAgreed", "()Z", "getTag", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RevokedServiceTerms {
    private final boolean agreed;
    private final String tag;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ RevokedServiceTerms copy$default(RevokedServiceTerms revokedServiceTerms, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = revokedServiceTerms.tag;
        }
        if ((i & 2) != 0) {
            z = revokedServiceTerms.agreed;
        }
        return revokedServiceTerms.copy(str, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.tag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component2() {
        return this.agreed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final RevokedServiceTerms copy(String tag, boolean agreed) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new RevokedServiceTerms(tag, agreed);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RevokedServiceTerms)) {
            return false;
        }
        RevokedServiceTerms revokedServiceTerms = (RevokedServiceTerms) other;
        return Intrinsics.areEqual(this.tag, revokedServiceTerms.tag) && this.agreed == revokedServiceTerms.agreed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = this.tag.hashCode() * 31;
        boolean z = this.agreed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "RevokedServiceTerms(tag=" + this.tag + ", agreed=" + this.agreed + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RevokedServiceTerms(String tag, boolean z) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.agreed = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTag() {
        return this.tag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getAgreed() {
        return this.agreed;
    }
}
