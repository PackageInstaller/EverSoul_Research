package twitter4j;

import com.liapp.y;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class HttpParameter implements Comparable<HttpParameter>, Serializable {
    private static final String GIF = "image/gif";
    private static final String JPEG = "image/jpeg";
    private static final String OCTET = "application/octet-stream";
    private static final String PNG = "image/png";
    private static final long serialVersionUID = 4046908449190454692L;
    private File file;
    private InputStream fileBody;
    private JSONObject jsonObject;
    private String name;
    private String value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter(String str, String str2) {
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter(JSONObject jSONObject) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.jsonObject = jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter(String str, File file) {
        this.value = null;
        this.jsonObject = null;
        this.fileBody = null;
        this.name = str;
        this.file = file;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter(String str, String str2, InputStream inputStream) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.file = new File(str2);
        this.fileBody = inputStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter(String str, int i) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter(String str, long j) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter(String str, double d) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter(String str, boolean z) {
        this.value = null;
        this.jsonObject = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public File getFile() {
        return this.file;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputStream getFileBody() {
        return this.fileBody;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFile() {
        return this.file != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isJson() {
        return this.jsonObject != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasFileBody() {
        return this.fileBody != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getContentType() {
        if (!isFile()) {
            throw new IllegalStateException(y.دײܮڳܯ(2051208589));
        }
        String name = this.file.getName();
        String str = y.ݮڮֲڭܩ(-629059348);
        int lastIndexOf = name.lastIndexOf(str);
        String str2 = y.ٲٴݴ״ٰ(1782508224);
        if (-1 == lastIndexOf) {
            return str2;
        }
        String lowerCase = name.substring(name.lastIndexOf(str) + 1).toLowerCase();
        int length = lowerCase.length();
        String str3 = y.ٴسسݬߨ(1393189970);
        if (length == 3) {
            if (y.ۮڭڭܬި(862953363).equals(lowerCase)) {
                return y.دײܮڳܯ(2051208381);
            }
            if (y.٬ݯح׭٩(576205590).equals(lowerCase)) {
                return y.دײܮڳܯ(2051208509);
            }
            if (!y.دײܮڳܯ(2051208661).equals(lowerCase)) {
                return str2;
            }
        } else if (lowerCase.length() != 4 || !y.ٲٴݴ״ٰ(1782507736).equals(lowerCase)) {
            return str2;
        }
        return str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpParameter httpParameter = (HttpParameter) obj;
        String str = this.name;
        if (str == null ? httpParameter.name != null : !str.equals(httpParameter.name)) {
            return false;
        }
        String str2 = this.value;
        if (str2 == null ? httpParameter.value != null : !str2.equals(httpParameter.value)) {
            return false;
        }
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null ? httpParameter.jsonObject != null : !jSONObject.equals(httpParameter.jsonObject)) {
            return false;
        }
        File file = this.file;
        if (file == null ? httpParameter.file != null : !file.equals(httpParameter.file)) {
            return false;
        }
        InputStream inputStream = this.fileBody;
        InputStream inputStream2 = httpParameter.fileBody;
        return inputStream != null ? inputStream.equals(inputStream2) : inputStream2 == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean containsJson(HttpParameter[] httpParameterArr) {
        return httpParameterArr.length == 1 && httpParameterArr[0].isJson();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean containsFile(HttpParameter[] httpParameterArr) {
        if (httpParameterArr == null) {
            return false;
        }
        for (HttpParameter httpParameter : httpParameterArr) {
            if (httpParameter.isFile()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean containsFile(List<HttpParameter> list) {
        Iterator<HttpParameter> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isFile()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpParameter[] getParameterArray(String str, String str2) {
        return new HttpParameter[]{new HttpParameter(str, str2)};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpParameter[] getParameterArray(String str, int i) {
        return getParameterArray(str, String.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpParameter[] getParameterArray(String str, String str2, String str3, String str4) {
        return new HttpParameter[]{new HttpParameter(str, str2), new HttpParameter(str3, str4)};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpParameter[] getParameterArray(String str, int i, String str2, int i2) {
        return getParameterArray(str, String.valueOf(i), str2, String.valueOf(i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.jsonObject;
        int hashCode3 = (hashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        File file = this.file;
        int hashCode4 = (hashCode3 + (file != null ? file.hashCode() : 0)) * 31;
        InputStream inputStream = this.fileBody;
        return hashCode4 + (inputStream != null ? inputStream.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576205934) + this.name + y.ٴسسݬߨ(1393291602) + this.value + y.ݬֲ֮ܲت(1512233719) + this.jsonObject + y.ٲٴݴ״ٰ(1782509304) + this.file + y.ݬֲ֮ܲت(1512233391) + this.fileBody + '}';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(HttpParameter httpParameter) {
        String str;
        String str2 = this.name;
        int compareTo = str2 != null ? str2.compareTo(httpParameter.name) : 0;
        return (compareTo != 0 || (str = this.value) == null) ? compareTo : str.compareTo(httpParameter.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeParameters(HttpParameter[] httpParameterArr) {
        if (httpParameterArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < httpParameterArr.length; i++) {
            if (httpParameterArr[i].isFile()) {
                throw new IllegalArgumentException(y.ٴسسݬߨ(1393292474) + httpParameterArr[i].name + y.ݮڮֲڭܩ(-628113124));
            }
            if (i != 0) {
                sb.append(y.֬ڱܱײٮ(-1159719487));
            }
            sb.append(encode(httpParameterArr[i].name)).append(y.ۮڭڭܬި(862004339)).append(encode(httpParameterArr[i].value));
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encode(String str) {
        String str2;
        int i;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = null;
        }
        StringBuilder sb = new StringBuilder(str2.length());
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '*') {
                sb.append(y.دײܮڳܯ(2051208733));
            } else if (charAt == '+') {
                sb.append(y.ٴسسݬߨ(1393292514));
            } else {
                if (charAt == '%' && (i = i2 + 1) < str2.length() && str2.charAt(i) == '7') {
                    int i3 = i2 + 2;
                    if (str2.charAt(i3) == 'E') {
                        sb.append('~');
                        i2 = i3;
                    }
                }
                sb.append(charAt);
            }
            i2++;
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String decode(String str) {
        String str2 = y.دײܮڳܯ(2051208733);
        String str3 = y.ٲٴݴ״ٰ(1782507304);
        try {
            return URLDecoder.decode(str.replace(str2, str3).replace(y.ݮڮֲڭܩ(-628113212), str3).replace(y.ٴسسݬߨ(1393292514), y.دײܮڳܯ(2051829469)), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<HttpParameter> decodeParameters(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(y.֬ڱܱײٮ(-1159719487))) {
            String[] split = str2.split(y.ۮڭڭܬި(862004339), 2);
            if (split.length == 2) {
                String decode = decode(split[0]);
                String decode2 = decode(split[1]);
                if (!decode.equals("") && !decode2.equals("")) {
                    arrayList.add(new HttpParameter(decode, decode2));
                }
            }
        }
        return arrayList;
    }
}
