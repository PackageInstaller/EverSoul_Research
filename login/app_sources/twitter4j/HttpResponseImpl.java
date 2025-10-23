package twitter4j;

import com.liapp.y;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class HttpResponseImpl extends HttpResponse {
    private HttpURLConnection con;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpResponseImpl(HttpURLConnection httpURLConnection, HttpClientConfiguration httpClientConfiguration) throws IOException {
        super(httpClientConfiguration);
        this.con = httpURLConnection;
        try {
            this.statusCode = httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (y.֬ڱܱײٮ(-1158965487).equals(e.getMessage())) {
                this.statusCode = httpURLConnection.getResponseCode();
            } else {
                throw e;
            }
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        this.f1563is = errorStream;
        if (errorStream == null) {
            this.f1563is = httpURLConnection.getInputStream();
        }
        if (this.f1563is == null || !"gzip".equals(httpURLConnection.getContentEncoding())) {
            return;
        }
        this.f1563is = new StreamingGZIPInputStream(this.f1563is);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpResponseImpl(String str) {
        this.responseAsString = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpResponse
    public String getResponseHeader(String str) {
        return this.con.getHeaderField(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpResponse
    public Map<String, List<String>> getResponseHeaderFields() {
        return this.con.getHeaderFields();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpResponse
    public void disconnect() {
        this.con.disconnect();
    }
}
