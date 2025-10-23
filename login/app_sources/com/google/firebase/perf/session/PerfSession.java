package com.google.firebase.perf.session;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.p010v1.PerfSession;
import com.google.firebase.perf.p010v1.SessionVerbosity;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PerfSession implements Parcelable {
    public static final Parcelable.Creator<PerfSession> CREATOR = new Parcelable.Creator<PerfSession>() { // from class: com.google.firebase.perf.session.PerfSession.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PerfSession createFromParcel(Parcel parcel) {
            return new PerfSession(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PerfSession[] newArray(int i) {
            return new PerfSession[i];
        }
    };
    private final Timer creationTime;
    private boolean isGaugeAndEventCollectionEnabled;
    private final String sessionId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfSession createWithId(String str) {
        PerfSession perfSession = new PerfSession(str.replace("-", ""), new Clock());
        perfSession.setGaugeAndEventCollectionEnabled(shouldCollectGaugesAndEvents());
        return perfSession;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PerfSession(String str, Clock clock) {
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = str;
        this.creationTime = clock.getTime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PerfSession(Parcel parcel) {
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = parcel.readString();
        this.isGaugeAndEventCollectionEnabled = parcel.readByte() != 0;
        this.creationTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String sessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Timer getTimer() {
        return this.creationTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGaugeAndEventCollectionEnabled(boolean z) {
        this.isGaugeAndEventCollectionEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isGaugeAndEventCollectionEnabled() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isVerbose() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isVerbose(com.google.firebase.perf.p010v1.PerfSession perfSession) {
        Iterator<SessionVerbosity> it = perfSession.getSessionVerbosityList().iterator();
        while (it.hasNext()) {
            if (it.next() == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSessionRunningTooLong() {
        return TimeUnit.MICROSECONDS.toMinutes(this.creationTime.getDurationMicros()) > ConfigResolver.getInstance().getSessionsMaxDurationMinutes();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public com.google.firebase.perf.p010v1.PerfSession build() {
        PerfSession.Builder sessionId = com.google.firebase.perf.p010v1.PerfSession.newBuilder().setSessionId(this.sessionId);
        if (this.isGaugeAndEventCollectionEnabled) {
            sessionId.addSessionVerbosity(SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS);
        }
        return sessionId.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.google.firebase.perf.p010v1.PerfSession[] buildAndSort(List<PerfSession> list) {
        if (list.isEmpty()) {
            return null;
        }
        com.google.firebase.perf.p010v1.PerfSession[] perfSessionArr = new com.google.firebase.perf.p010v1.PerfSession[list.size()];
        com.google.firebase.perf.p010v1.PerfSession build = list.get(0).build();
        boolean z = false;
        for (int i = 1; i < list.size(); i++) {
            com.google.firebase.perf.p010v1.PerfSession build2 = list.get(i).build();
            if (!z && list.get(i).isVerbose()) {
                perfSessionArr[0] = build2;
                perfSessionArr[i] = build;
                z = true;
            } else {
                perfSessionArr[i] = build2;
            }
        }
        if (!z) {
            perfSessionArr[0] = build;
        }
        return perfSessionArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean shouldCollectGaugesAndEvents() {
        ConfigResolver configResolver = ConfigResolver.getInstance();
        return configResolver.isPerformanceMonitoringEnabled() && Math.random() < configResolver.getSessionsSamplingRate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sessionId);
        parcel.writeByte(this.isGaugeAndEventCollectionEnabled ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.creationTime, 0);
    }
}
