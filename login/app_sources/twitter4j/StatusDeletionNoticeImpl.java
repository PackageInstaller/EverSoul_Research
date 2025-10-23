package twitter4j;

import com.liapp.y;
import java.io.Serializable;

/* loaded from: classes4.dex */
class StatusDeletionNoticeImpl implements StatusDeletionNotice, Serializable {
    private static final long serialVersionUID = 9144204870473786368L;
    private final long statusId;
    private final long userId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StatusDeletionNoticeImpl(JSONObject jSONObject) {
        this.statusId = ParseUtil.getLong(y.ٲٴݴ״ٰ(1781792816), jSONObject);
        this.userId = ParseUtil.getLong(y.ݬֲ֮ܲت(1512773759), jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.StatusDeletionNotice
    public long getStatusId() {
        return this.statusId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.StatusDeletionNotice
    public long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(StatusDeletionNotice statusDeletionNotice) {
        long statusId = this.statusId - statusDeletionNotice.getStatusId();
        if (statusId < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (statusId > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) statusId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusDeletionNoticeImpl statusDeletionNoticeImpl = (StatusDeletionNoticeImpl) obj;
        return this.statusId == statusDeletionNoticeImpl.statusId && this.userId == statusDeletionNoticeImpl.userId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.statusId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.userId;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628130284) + this.statusId + y.ٴسسݬߨ(1393249082) + this.userId + '}';
    }
}
