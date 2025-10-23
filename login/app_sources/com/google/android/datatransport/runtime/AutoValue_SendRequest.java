package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

/* loaded from: classes.dex */
final class AutoValue_SendRequest extends SendRequest {
    private final Encoding encoding;
    private final Event<?> event;
    private final Transformer<?, byte[]> transformer;
    private final TransportContext transportContext;
    private final String transportName;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AutoValue_SendRequest(TransportContext transportContext, String str, Event<?> event, Transformer<?, byte[]> transformer, Encoding encoding) {
        this.transportContext = transportContext;
        this.transportName = str;
        this.event = event;
        this.transformer = transformer;
        this.encoding = encoding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.SendRequest
    public TransportContext getTransportContext() {
        return this.transportContext;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.SendRequest
    public String getTransportName() {
        return this.transportName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.SendRequest
    Event<?> getEvent() {
        return this.event;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.SendRequest
    Transformer<?, byte[]> getTransformer() {
        return this.transformer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.SendRequest
    public Encoding getEncoding() {
        return this.encoding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "SendRequest{transportContext=" + this.transportContext + ", transportName=" + this.transportName + ", event=" + this.event + ", transformer=" + this.transformer + ", encoding=" + this.encoding + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        return this.transportContext.equals(sendRequest.getTransportContext()) && this.transportName.equals(sendRequest.getTransportName()) && this.event.equals(sendRequest.getEvent()) && this.transformer.equals(sendRequest.getTransformer()) && this.encoding.equals(sendRequest.getEncoding());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return ((((((((this.transportContext.hashCode() ^ 1000003) * 1000003) ^ this.transportName.hashCode()) * 1000003) ^ this.event.hashCode()) * 1000003) ^ this.transformer.hashCode()) * 1000003) ^ this.encoding.hashCode();
    }

    static final class Builder extends SendRequest.Builder {
        private Encoding encoding;
        private Event<?> event;
        private Transformer<?, byte[]> transformer;
        private TransportContext transportContext;
        private String transportName;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder setTransportContext(TransportContext transportContext) {
            if (transportContext == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.transportContext = transportContext;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder setTransportName(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.transportName = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder setEvent(Event<?> event) {
            if (event == null) {
                throw new NullPointerException("Null event");
            }
            this.event = event;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder setTransformer(Transformer<?, byte[]> transformer) {
            if (transformer == null) {
                throw new NullPointerException("Null transformer");
            }
            this.transformer = transformer;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder setEncoding(Encoding encoding) {
            if (encoding == null) {
                throw new NullPointerException("Null encoding");
            }
            this.encoding = encoding;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest build() {
            String str = this.transportContext == null ? " transportContext" : "";
            if (this.transportName == null) {
                str = str + " transportName";
            }
            if (this.event == null) {
                str = str + " event";
            }
            if (this.transformer == null) {
                str = str + " transformer";
            }
            if (this.encoding == null) {
                str = str + " encoding";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_SendRequest(this.transportContext, this.transportName, this.event, this.transformer, this.encoding);
        }
    }
}
