package com.google.firebase.perf.p010v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface PerfSessionOrBuilder extends MessageLiteOrBuilder {
    String getSessionId();

    ByteString getSessionIdBytes();

    SessionVerbosity getSessionVerbosity(int i);

    int getSessionVerbosityCount();

    List<SessionVerbosity> getSessionVerbosityList();

    boolean hasSessionId();
}
