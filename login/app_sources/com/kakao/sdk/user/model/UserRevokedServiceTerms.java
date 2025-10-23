package com.kakao.sdk.user.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserRevokedServiceTerms.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m839d2 = {"Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "", "id", "", "revokedServiceTerms", "", "Lcom/kakao/sdk/user/model/RevokedServiceTerms;", "(JLjava/util/List;)V", "getId", "()J", "getRevokedServiceTerms", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserRevokedServiceTerms {
    private final long id;
    private final List<RevokedServiceTerms> revokedServiceTerms;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ UserRevokedServiceTerms copy$default(UserRevokedServiceTerms userRevokedServiceTerms, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = userRevokedServiceTerms.id;
        }
        if ((i & 2) != 0) {
            list = userRevokedServiceTerms.revokedServiceTerms;
        }
        return userRevokedServiceTerms.copy(j, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<RevokedServiceTerms> component2() {
        return this.revokedServiceTerms;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final UserRevokedServiceTerms copy(long id, List<RevokedServiceTerms> revokedServiceTerms) {
        return new UserRevokedServiceTerms(id, revokedServiceTerms);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserRevokedServiceTerms)) {
            return false;
        }
        UserRevokedServiceTerms userRevokedServiceTerms = (UserRevokedServiceTerms) other;
        return this.id == userRevokedServiceTerms.id && Intrinsics.areEqual(this.revokedServiceTerms, userRevokedServiceTerms.revokedServiceTerms);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        List<RevokedServiceTerms> list = this.revokedServiceTerms;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "UserRevokedServiceTerms(id=" + this.id + ", revokedServiceTerms=" + this.revokedServiceTerms + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserRevokedServiceTerms(long j, List<RevokedServiceTerms> list) {
        this.id = j;
        this.revokedServiceTerms = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<RevokedServiceTerms> getRevokedServiceTerms() {
        return this.revokedServiceTerms;
    }
}
