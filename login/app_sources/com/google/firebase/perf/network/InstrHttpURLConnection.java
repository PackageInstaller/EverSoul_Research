package com.google.firebase.perf.network;

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
public final class InstrHttpURLConnection extends HttpURLConnection {
    private final InstrURLConnectionBase delegate;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    InstrHttpURLConnection(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        super(httpURLConnection.getURL());
        this.delegate = new InstrURLConnectionBase(httpURLConnection, timer, networkRequestMetricBuilder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.delegate.connect();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.delegate.disconnect();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        return this.delegate.getContent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        return this.delegate.getContent(clsArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.delegate.getPermission();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return this.delegate.getResponseCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return this.delegate.getResponseMessage();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.delegate.getExpiration();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i) {
        return this.delegate.getHeaderField(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.delegate.getHeaderField(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return this.delegate.getHeaderFieldDate(str, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return this.delegate.getHeaderFieldInt(str, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String str, long j) {
        return this.delegate.getHeaderFieldLong(str, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i) {
        return this.delegate.getHeaderFieldKey(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.delegate.getContentLength();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        return this.delegate.getContentLengthLong();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public String getContentType() {
        return this.delegate.getContentType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public long getDate() {
        return this.delegate.getDate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.delegate.addRequestProperty(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.delegate.getRequestProperty(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public URL getURL() {
        return this.delegate.getURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.delegate.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z) {
        this.delegate.setAllowUserInteraction(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        this.delegate.setChunkedStreamingMode(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        this.delegate.setConnectTimeout(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        this.delegate.setDefaultUseCaches(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        this.delegate.setDoInput(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        this.delegate.setDoOutput(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        this.delegate.setFixedLengthStreamingMode(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j) {
        this.delegate.setFixedLengthStreamingMode(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        this.delegate.setIfModifiedSince(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.delegate.setInstanceFollowRedirects(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        this.delegate.setReadTimeout(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.delegate.setRequestMethod(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.delegate.setRequestProperty(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        this.delegate.setUseCaches(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.URLConnection
    public String toString() {
        return this.delegate.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }
}
