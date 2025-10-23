package com.google.firebase.perf.p010v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes2.dex */
public interface CpuMetricReadingOrBuilder extends MessageLiteOrBuilder {
    long getClientTimeUs();

    long getSystemTimeUs();

    long getUserTimeUs();

    boolean hasClientTimeUs();

    boolean hasSystemTimeUs();

    boolean hasUserTimeUs();
}
