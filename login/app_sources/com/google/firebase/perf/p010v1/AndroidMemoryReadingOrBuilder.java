package com.google.firebase.perf.p010v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes2.dex */
public interface AndroidMemoryReadingOrBuilder extends MessageLiteOrBuilder {
    long getClientTimeUs();

    int getUsedAppJavaHeapMemoryKb();

    boolean hasClientTimeUs();

    boolean hasUsedAppJavaHeapMemoryKb();
}
