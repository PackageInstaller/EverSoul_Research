package com.google.firebase.remoteconfig.interop.rollouts;

import java.util.Set;

/* loaded from: classes2.dex */
final class AutoValue_RolloutsState extends RolloutsState {
    private final Set<RolloutAssignment> rolloutAssignments;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AutoValue_RolloutsState(Set<RolloutAssignment> set) {
        if (set == null) {
            throw new NullPointerException("Null rolloutAssignments");
        }
        this.rolloutAssignments = set;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutsState
    public Set<RolloutAssignment> getRolloutAssignments() {
        return this.rolloutAssignments;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.rolloutAssignments + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RolloutsState) {
            return this.rolloutAssignments.equals(((RolloutsState) obj).getRolloutAssignments());
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.rolloutAssignments.hashCode() ^ 1000003;
    }
}
