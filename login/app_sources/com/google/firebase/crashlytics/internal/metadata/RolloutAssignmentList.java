package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class RolloutAssignmentList {
    static final String ROLLOUTS_STATE = "rolloutsState";
    private final int maxEntries;
    private final List<RolloutAssignment> rolloutsState = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RolloutAssignmentList(int i) {
        this.maxEntries = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized List<RolloutAssignment> getRolloutAssignmentList() {
        return Collections.unmodifiableList(new ArrayList(this.rolloutsState));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean updateRolloutAssignmentList(List<RolloutAssignment> list) {
        this.rolloutsState.clear();
        if (list.size() > this.maxEntries) {
            Logger.getLogger().m398w("Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.maxEntries);
            return this.rolloutsState.addAll(list.subList(0, this.maxEntries));
        }
        return this.rolloutsState.addAll(list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<CrashlyticsReport.Session.Event.RolloutAssignment> getReportRolloutsState() {
        List<RolloutAssignment> rolloutAssignmentList = getRolloutAssignmentList();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < rolloutAssignmentList.size(); i++) {
            arrayList.add(rolloutAssignmentList.get(i).toReportProto());
        }
        return arrayList;
    }
}
