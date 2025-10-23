package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

@Encodable
/* loaded from: classes.dex */
public abstract class BatchedLogRequest {
    @Encodable.Field(name = "logRequest")
    public abstract List<LogRequest> getLogRequests();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BatchedLogRequest create(List<LogRequest> list) {
        return new AutoValue_BatchedLogRequest(list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DataEncoder createDataEncoder() {
        return new JsonDataEncoderBuilder().configureWith(AutoBatchedLogRequestEncoder.CONFIG).ignoreNullValues(true).build();
    }
}
