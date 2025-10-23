package twitter4j;

import com.facebook.internal.security.CertificateUtil;
import com.liapp.y;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import twitter4j.conf.ConfigurationContext;

/* loaded from: classes4.dex */
public abstract class HttpResponse {
    private static final Logger logger = Logger.getLogger(HttpResponseImpl.class);
    protected final HttpClientConfiguration CONF;

    /* renamed from: is */
    protected InputStream f1563is;
    private JSONObject json;
    private JSONArray jsonArray;
    protected String responseAsString;
    protected int statusCode;
    private boolean streamConsumed;

    public abstract void disconnect() throws IOException;

    public abstract String getResponseHeader(String str);

    public abstract Map<String, List<String>> getResponseHeaderFields();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpResponse() {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = ConfigurationContext.getInstance().getHttpClientConfiguration();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpResponse(HttpClientConfiguration httpClientConfiguration) {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = httpClientConfiguration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStatusCode() {
        return this.statusCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputStream asStream() {
        if (this.streamConsumed) {
            throw new IllegalStateException(y.ݮڮֲڭܩ(-628098780));
        }
        return this.f1563is;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String asString() throws TwitterException {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        IOException e;
        BufferedReader bufferedReader2;
        if (this.responseAsString == null) {
            try {
                try {
                    inputStream = asStream();
                    if (inputStream != null) {
                        try {
                            bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        } catch (IOException e2) {
                            e = e2;
                        } catch (Throwable th2) {
                            bufferedReader = null;
                            th = th2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused2) {
                                }
                            }
                            disconnectForcibly();
                            throw th;
                        }
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine).append(StringUtils.f1524LF);
                            }
                            String sb2 = sb.toString();
                            this.responseAsString = sb2;
                            logger.debug(sb2);
                            inputStream.close();
                            this.streamConsumed = true;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused4) {
                            }
                            disconnectForcibly();
                        } catch (IOException e3) {
                            e = e3;
                            throw new TwitterException(e.getMessage(), e);
                        }
                    } else {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        disconnectForcibly();
                        return null;
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return this.responseAsString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject asJSONObject() throws TwitterException {
        try {
            if (this.json == null) {
                try {
                    this.json = new JSONObject(asString());
                    if (this.CONF.isPrettyDebugEnabled()) {
                        logger.debug(this.json.toString(1));
                    } else {
                        Logger logger2 = logger;
                        String str = this.responseAsString;
                        if (str == null) {
                            str = this.json.toString();
                        }
                        logger2.debug(str);
                    }
                } catch (JSONException e) {
                    if (this.responseAsString == null) {
                        throw new TwitterException(e.getMessage(), e);
                    }
                    throw new TwitterException(e.getMessage() + CertificateUtil.DELIMITER + this.responseAsString, e);
                }
            }
            return this.json;
        } finally {
            disconnectForcibly();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONArray asJSONArray() throws TwitterException {
        try {
            if (this.jsonArray == null) {
                try {
                    this.jsonArray = new JSONArray(asString());
                    if (this.CONF.isPrettyDebugEnabled()) {
                        logger.debug(this.jsonArray.toString(1));
                    } else {
                        Logger logger2 = logger;
                        String str = this.responseAsString;
                        if (str == null) {
                            str = this.jsonArray.toString();
                        }
                        logger2.debug(str);
                    }
                } catch (JSONException e) {
                    if (logger.isDebugEnabled()) {
                        throw new TwitterException(e.getMessage() + CertificateUtil.DELIMITER + this.responseAsString, e);
                    }
                    throw new TwitterException(e.getMessage(), e);
                }
            }
            return this.jsonArray;
        } finally {
            disconnectForcibly();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Reader asReader() {
        try {
            return new BufferedReader(new InputStreamReader(this.f1563is, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return new InputStreamReader(this.f1563is);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void disconnectForcibly() {
        try {
            disconnect();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ۮڭڭܬި(862955451) + this.statusCode + y.دײܮڳܯ(2051198253) + this.responseAsString + y.֬ڱܱײٮ(-1158965967) + this.f1563is + y.ٲٴݴ״ٰ(1782503256) + this.streamConsumed + '}';
    }
}
