package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails */
/* loaded from: classes2.dex */
final class C1773x94fa915f extends CrashlyticsReport.Session.Event.Application.ProcessDetails {
    private final boolean defaultProcess;
    private final int importance;
    private final int pid;
    private final String processName;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C1773x94fa915f(String str, int i, int i2, boolean z) {
        this.processName = str;
        this.pid = i;
        this.importance = i2;
        this.defaultProcess = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public String getProcessName() {
        return this.processName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public int getPid() {
        return this.pid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public int getImportance() {
        return this.importance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public boolean isDefaultProcess() {
        return this.defaultProcess;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ProcessDetails{processName=" + this.processName + ", pid=" + this.pid + ", importance=" + this.importance + ", defaultProcess=" + this.defaultProcess + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.ProcessDetails)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) obj;
        return this.processName.equals(processDetails.getProcessName()) && this.pid == processDetails.getPid() && this.importance == processDetails.getImportance() && this.defaultProcess == processDetails.isDefaultProcess();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return ((((((this.processName.hashCode() ^ 1000003) * 1000003) ^ this.pid) * 1000003) ^ this.importance) * 1000003) ^ (this.defaultProcess ? 1231 : 1237);
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails$Builder */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder {
        private Boolean defaultProcess;
        private Integer importance;
        private Integer pid;
        private String processName;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder setProcessName(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.processName = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder setPid(int i) {
            this.pid = Integer.valueOf(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder setDefaultProcess(boolean z) {
            this.defaultProcess = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails build() {
            String str = this.processName == null ? " processName" : "";
            if (this.pid == null) {
                str = str + " pid";
            }
            if (this.importance == null) {
                str = str + " importance";
            }
            if (this.defaultProcess == null) {
                str = str + " defaultProcess";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new C1773x94fa915f(this.processName, this.pid.intValue(), this.importance.intValue(), this.defaultProcess.booleanValue());
        }
    }
}
