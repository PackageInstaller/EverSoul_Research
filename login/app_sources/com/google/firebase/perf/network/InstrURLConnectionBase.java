package com.google.firebase.perf.network;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class InstrURLConnectionBase {
    private static final String USER_AGENT_PROPERTY = "User-Agent";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final HttpURLConnection httpUrlConnection;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private long timeRequestedInMicros = -1;
    private long timeToResponseInitiatedInMicros = -1;
    private final Timer timer;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InstrURLConnectionBase(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        this.httpUrlConnection = httpURLConnection;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timer = timer;
        networkRequestMetricBuilder.setUrl(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void connect() throws IOException {
        if (this.timeRequestedInMicros == -1) {
            this.timer.reset();
            long micros = this.timer.getMicros();
            this.timeRequestedInMicros = micros;
            this.networkMetricBuilder.setRequestStartTimeMicros(micros);
        }
        try {
            this.httpUrlConnection.connect();
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void disconnect() {
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
        this.networkMetricBuilder.build();
        this.httpUrlConnection.disconnect();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getContent() throws IOException {
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        try {
            Object content = this.httpUrlConnection.getContent();
            if (content instanceof InputStream) {
                this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
                return new InstrHttpInputStream((InputStream) content, this.networkMetricBuilder, this.timer);
            }
            this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
            this.networkMetricBuilder.setResponsePayloadBytes(this.httpUrlConnection.getContentLength());
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            this.networkMetricBuilder.build();
            return content;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getContent(Class[] clsArr) throws IOException {
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        try {
            Object content = this.httpUrlConnection.getContent(clsArr);
            if (content instanceof InputStream) {
                this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
                return new InstrHttpInputStream((InputStream) content, this.networkMetricBuilder, this.timer);
            }
            this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
            this.networkMetricBuilder.setResponsePayloadBytes(this.httpUrlConnection.getContentLength());
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            this.networkMetricBuilder.build();
            return content;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputStream getInputStream() throws IOException {
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
        try {
            InputStream inputStream = this.httpUrlConnection.getInputStream();
            return inputStream != null ? new InstrHttpInputStream(inputStream, this.networkMetricBuilder, this.timer) : inputStream;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getLastModified() {
        updateRequestInfo();
        return this.httpUrlConnection.getLastModified();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OutputStream getOutputStream() throws IOException {
        try {
            OutputStream outputStream = this.httpUrlConnection.getOutputStream();
            return outputStream != null ? new InstrHttpOutputStream(outputStream, this.networkMetricBuilder, this.timer) : outputStream;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Permission getPermission() throws IOException {
        try {
            return this.httpUrlConnection.getPermission();
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getResponseCode() throws IOException {
        updateRequestInfo();
        if (this.timeToResponseInitiatedInMicros == -1) {
            long durationMicros = this.timer.getDurationMicros();
            this.timeToResponseInitiatedInMicros = durationMicros;
            this.networkMetricBuilder.setTimeToResponseInitiatedMicros(durationMicros);
        }
        try {
            int responseCode = this.httpUrlConnection.getResponseCode();
            this.networkMetricBuilder.setHttpResponseCode(responseCode);
            return responseCode;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getResponseMessage() throws IOException {
        updateRequestInfo();
        if (this.timeToResponseInitiatedInMicros == -1) {
            long durationMicros = this.timer.getDurationMicros();
            this.timeToResponseInitiatedInMicros = durationMicros;
            this.networkMetricBuilder.setTimeToResponseInitiatedMicros(durationMicros);
        }
        try {
            String responseMessage = this.httpUrlConnection.getResponseMessage();
            this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
            return responseMessage;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getExpiration() {
        updateRequestInfo();
        return this.httpUrlConnection.getExpiration();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getHeaderField(int i) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderField(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getHeaderField(String str) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderField(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getHeaderFieldDate(String str, long j) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldDate(str, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getHeaderFieldInt(String str, int i) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldInt(str, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getHeaderFieldLong(String str, long j) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldLong(str, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getHeaderFieldKey(int i) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldKey(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, List<String>> getHeaderFields() {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFields();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getContentEncoding() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentEncoding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getContentLength() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentLength();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getContentLengthLong() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentLengthLong();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getContentType() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getDate() {
        updateRequestInfo();
        return this.httpUrlConnection.getDate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addRequestProperty(String str, String str2) {
        this.httpUrlConnection.addRequestProperty(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return this.httpUrlConnection.equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getAllowUserInteraction() {
        return this.httpUrlConnection.getAllowUserInteraction();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getConnectTimeout() {
        return this.httpUrlConnection.getConnectTimeout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getDefaultUseCaches() {
        return this.httpUrlConnection.getDefaultUseCaches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getDoInput() {
        return this.httpUrlConnection.getDoInput();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getDoOutput() {
        return this.httpUrlConnection.getDoOutput();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputStream getErrorStream() {
        updateRequestInfo();
        try {
            this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        } catch (IOException unused) {
            logger.debug("IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.httpUrlConnection.getErrorStream();
        return errorStream != null ? new InstrHttpInputStream(errorStream, this.networkMetricBuilder, this.timer) : errorStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getIfModifiedSince() {
        return this.httpUrlConnection.getIfModifiedSince();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getInstanceFollowRedirects() {
        return this.httpUrlConnection.getInstanceFollowRedirects();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getReadTimeout() {
        return this.httpUrlConnection.getReadTimeout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getRequestMethod() {
        return this.httpUrlConnection.getRequestMethod();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, List<String>> getRequestProperties() {
        return this.httpUrlConnection.getRequestProperties();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getRequestProperty(String str) {
        return this.httpUrlConnection.getRequestProperty(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public URL getURL() {
        return this.httpUrlConnection.getURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getUseCaches() {
        return this.httpUrlConnection.getUseCaches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.httpUrlConnection.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAllowUserInteraction(boolean z) {
        this.httpUrlConnection.setAllowUserInteraction(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChunkedStreamingMode(int i) {
        this.httpUrlConnection.setChunkedStreamingMode(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setConnectTimeout(int i) {
        this.httpUrlConnection.setConnectTimeout(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDefaultUseCaches(boolean z) {
        this.httpUrlConnection.setDefaultUseCaches(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDoInput(boolean z) {
        this.httpUrlConnection.setDoInput(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDoOutput(boolean z) {
        this.httpUrlConnection.setDoOutput(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFixedLengthStreamingMode(int i) {
        this.httpUrlConnection.setFixedLengthStreamingMode(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFixedLengthStreamingMode(long j) {
        this.httpUrlConnection.setFixedLengthStreamingMode(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIfModifiedSince(long j) {
        this.httpUrlConnection.setIfModifiedSince(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInstanceFollowRedirects(boolean z) {
        this.httpUrlConnection.setInstanceFollowRedirects(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setReadTimeout(int i) {
        this.httpUrlConnection.setReadTimeout(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRequestMethod(String str) throws ProtocolException {
        this.httpUrlConnection.setRequestMethod(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRequestProperty(String str, String str2) {
        if ("User-Agent".equalsIgnoreCase(str)) {
            this.networkMetricBuilder.setUserAgent(str2);
        }
        this.httpUrlConnection.setRequestProperty(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUseCaches(boolean z) {
        this.httpUrlConnection.setUseCaches(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.httpUrlConnection.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean usingProxy() {
        return this.httpUrlConnection.usingProxy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateRequestInfo() {
        if (this.timeRequestedInMicros == -1) {
            this.timer.reset();
            long micros = this.timer.getMicros();
            this.timeRequestedInMicros = micros;
            this.networkMetricBuilder.setRequestStartTimeMicros(micros);
        }
        String requestMethod = getRequestMethod();
        if (requestMethod != null) {
            this.networkMetricBuilder.setHttpMethod(requestMethod);
        } else if (getDoOutput()) {
            this.networkMetricBuilder.setHttpMethod("POST");
        } else {
            this.networkMetricBuilder.setHttpMethod("GET");
        }
    }
}
