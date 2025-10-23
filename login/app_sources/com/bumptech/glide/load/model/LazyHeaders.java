package com.bumptech.glide.load.model;

import android.text.TextUtils;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class LazyHeaders implements Headers {
    private volatile Map<String, String> combinedHeaders;
    private final Map<String, List<LazyHeaderFactory>> headers;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.headers = Collections.unmodifiableMap(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        if (this.combinedHeaders == null) {
            synchronized (this) {
                if (this.combinedHeaders == null) {
                    this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());
                }
            }
        }
        return this.combinedHeaders;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Map<String, String> generateHeaders() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.headers.entrySet()) {
            String buildHeaderValue = buildHeaderValue(entry.getValue());
            if (!TextUtils.isEmpty(buildHeaderValue)) {
                hashMap.put(entry.getKey(), buildHeaderValue);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String buildHeaderValue(List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String buildHeader = list.get(i).buildHeader();
            if (!TextUtils.isEmpty(buildHeader)) {
                sb.append(buildHeader);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٲٴݴ״ٰ(1781730048) + this.headers + '}';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.headers.equals(((LazyHeaders) obj).headers);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.headers.hashCode();
    }

    public static final class Builder {
        private static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS;
        private static final String DEFAULT_USER_AGENT;
        private static final String USER_AGENT_HEADER = "User-Agent";
        private boolean copyOnModify = true;
        private Map<String, List<LazyHeaderFactory>> headers = DEFAULT_HEADERS;
        private boolean isUserAgentDefault = true;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            String sanitizedUserAgent = getSanitizedUserAgent();
            DEFAULT_USER_AGENT = sanitizedUserAgent;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(sanitizedUserAgent)) {
                hashMap.put(y.ݮڮֲڭܩ(-629002692), Collections.singletonList(new StringHeaderFactory(sanitizedUserAgent)));
            }
            DEFAULT_HEADERS = Collections.unmodifiableMap(hashMap);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addHeader(String str, String str2) {
            return addHeader(str, new StringHeaderFactory(str2));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addHeader(String str, LazyHeaderFactory lazyHeaderFactory) {
            if (this.isUserAgentDefault && y.ݮڮֲڭܩ(-629002692).equalsIgnoreCase(str)) {
                return setHeader(str, lazyHeaderFactory);
            }
            copyIfNecessary();
            getFactories(str).add(lazyHeaderFactory);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setHeader(String str, String str2) {
            return setHeader(str, str2 == null ? null : new StringHeaderFactory(str2));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setHeader(String str, LazyHeaderFactory lazyHeaderFactory) {
            copyIfNecessary();
            if (lazyHeaderFactory == null) {
                this.headers.remove(str);
            } else {
                List<LazyHeaderFactory> factories = getFactories(str);
                factories.clear();
                factories.add(lazyHeaderFactory);
            }
            if (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(str)) {
                this.isUserAgentDefault = false;
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private List<LazyHeaderFactory> getFactories(String str) {
            List<LazyHeaderFactory> list = this.headers.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.headers.put(str, arrayList);
            return arrayList;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void copyIfNecessary() {
            if (this.copyOnModify) {
                this.copyOnModify = false;
                this.headers = copyHeaders();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LazyHeaders build() {
            this.copyOnModify = true;
            return new LazyHeaders(this.headers);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Map<String, List<LazyHeaderFactory>> copyHeaders() {
            HashMap hashMap = new HashMap(this.headers.size());
            for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.headers.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getSanitizedUserAgent() {
            String property = System.getProperty(y.ٴسسݬߨ(1392908946));
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
    }

    static final class StringHeaderFactory implements LazyHeaderFactory {
        private final String value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StringHeaderFactory(String str) {
            this.value = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return y.ٲٴݴ״ٰ(1781728312) + this.value + y.ݮڮֲڭܩ(-628973388);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.value.equals(((StringHeaderFactory) obj).value);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.value.hashCode();
        }
    }
}
