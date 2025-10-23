package com.kakaogame.util;

import com.kakaogame.Logger;
import com.liapp.y;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p031io.CloseableKt;
import kotlin.p031io.TextStreamsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: StringUtil.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J*\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J(\u0010\u001c\u001a\u00020\u00042\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J(\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0016H\u0007J\u0010\u0010\"\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J\"\u0010'\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, m839d2 = {"Lcom/kakaogame/util/StringUtil;", "", "()V", "DEFAULT_CHARSET", "", "TAG", "compress", "", "source", "convertBytesToString", "bytes", "convertStreamToString", "is", "Ljava/io/InputStream;", "convertStringToBytes", "str", "decompress", "escapeHTML", "getDefaultEncodingString", "rawString", "getStringForMap", "objectMap", "", "keyString", "getUrlEncodedString", "getUrlLinks", "", "text", "makeRequestParamString", "paramMap", "appendParam", "", "makeRequestUrl", "url", "normalize", "parseQueryString", "queryString", "removeEmojis", "s", "replaceString", "key", "replace", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class StringUtil {
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final StringUtil INSTANCE = new StringUtil();
    private static final String TAG = "StringUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private StringUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String normalize(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        String replace = new Regex(y.ۮڭڭܬި(862910171)).replace(str2, "");
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, y.دײܮڳܯ(2051368829));
        String lowerCase = replace.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.֬ڱܱײٮ(-1159019095));
        Logger.INSTANCE.m706v(y.دײܮڳܯ(2051244973), y.ݬֲ֮ܲت(1512288663) + str + y.ݮڮֲڭܩ(-628959956) + lowerCase);
        return lowerCase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String convertStreamToString(InputStream is) {
        String str = y.٬ݯح׭٩(576275982);
        String str2 = y.دײܮڳܯ(2051244973);
        try {
            if (is == null) {
                return null;
            }
            try {
                Reader inputStreamReader = new InputStreamReader(is, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String readText = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    return readText;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, str, e);
                try {
                    is.close();
                    return null;
                } catch (IOException e2) {
                    Logger.INSTANCE.m702e(str2, str, e2);
                    return null;
                }
            }
        } finally {
            try {
                is.close();
            } catch (IOException e3) {
                Logger.INSTANCE.m702e(str2, str, e3);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String makeRequestUrl(String url, Map<String, ? extends Object> paramMap) {
        Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
        if (paramMap == null || paramMap.isEmpty()) {
            return url;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        String str = y.ٴسسݬߨ(1393197818);
        boolean z = false;
        if (!StringsKt.contains$default((CharSequence) url, (CharSequence) str, false, 2, (Object) null)) {
            sb.append(str);
        } else if (!StringsKt.endsWith$default(url, str, false, 2, (Object) null) && !StringsKt.endsWith$default(url, y.֬ڱܱײٮ(-1159719487), false, 2, (Object) null)) {
            z = true;
        }
        sb.append(INSTANCE.makeRequestParamString(paramMap, z));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String makeRequestParamString(Map<String, ? extends Object> paramMap, boolean appendParam) {
        if (paramMap == null || paramMap.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ? extends Object> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (appendParam) {
                sb.append(Typography.amp);
            } else {
                appendParam = true;
            }
            sb.append(key);
            sb.append('=');
            if (value == null) {
                sb.append("");
            } else if (value instanceof String) {
                sb.append(getDefaultEncodingString((String) value));
            } else {
                sb.append(value);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDefaultEncodingString(String rawString) {
        String str = rawString;
        if (str == null || str.length() == 0) {
            return rawString;
        }
        try {
            return URLEncoder.encode(rawString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051244973), e.toString(), e);
            return rawString;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getStringForMap(Map<String, String> objectMap, String keyString) {
        Intrinsics.checkNotNullParameter(objectMap, y.֬ڱܱײٮ(-1159020287));
        if (objectMap.containsKey(keyString)) {
            return objectMap.get(keyString);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] convertStringToBytes(String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576465878));
        if (str.length() == 0) {
            return null;
        }
        try {
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (UnsupportedEncodingException e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051244973), y.ٲٴݴ״ٰ(1782553704) + str, e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String convertBytesToString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        try {
            return new String(bytes, Charsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051244973), y.ݬֲ֮ܲت(1512286503) + bytes, e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getUrlEncodedString(String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576465878));
        if (str.length() == 0) {
            return str;
        }
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Intrinsics.checkNotNull(encode);
            return encode;
        } catch (UnsupportedEncodingException e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051244973), e.toString(), e);
            return str;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> parseQueryString(String queryString) {
        String str;
        Intrinsics.checkNotNullParameter(queryString, y.٬ݯح׭٩(576282182));
        String str2 = queryString;
        if (str2.length() == 0) {
            return MapsKt.emptyMap();
        }
        String[] strArr = (String[]) new Regex(y.֬ڱܱײٮ(-1159719487)).split(str2, 0).toArray(new String[0]);
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        while (true) {
            str = y.ۮڭڭܬި(862004339);
            if (i >= length) {
                break;
            }
            String str3 = strArr[i];
            if (new Regex(str).split(str3, 0).toArray(new String[0]).length == 2) {
                arrayList.add(str3);
            }
            i++;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String[] strArr2 = (String[]) new Regex(str).split((String) it.next(), 0).toArray(new String[0]);
            arrayList3.add(TuplesKt.m846to(strArr2[0], strArr2[1]));
        }
        return MapsKt.toMap(arrayList3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final byte[] compress(String source) {
        String str = source;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
            byte[] bytes = source.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            deflaterOutputStream.write(bytes);
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051244973), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] decompress(byte[] source) {
        try {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(source));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inflaterInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051244973), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getUrlLinks(String text) {
        Intrinsics.checkNotNullParameter(text, y.ٲٴݴ״ٰ(1782384304));
        String str = text;
        if (str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(y.ݬֲ֮ܲت(1512290063)).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            Intrinsics.checkNotNull(group);
            if (StringsKt.startsWith$default(group, y.٬ݯح׭٩(575982094), false, 2, (Object) null)) {
                Intrinsics.checkNotNull(group);
                if (StringsKt.endsWith$default(group, y.ٴسسݬߨ(1392959042), false, 2, (Object) null)) {
                    Intrinsics.checkNotNull(group);
                    group = group.substring(1, group.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(group, "this as java.lang.String…ing(startIndex, endIndex)");
                }
            }
            arrayList.add(group);
        }
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051244973), y.֬ڱܱײٮ(-1159019959) + text + y.ݮڮֲڭܩ(-628756788) + arrayList);
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String removeEmojis(String s) {
        Intrinsics.checkNotNullParameter(s, y.ٲٴݴ״ٰ(1781877368));
        String str = s;
        return str.length() == 0 ? s : new Regex(y.ۮڭڭܬި(862909419)).replace(str, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String replaceString(String source, String key, String replace) {
        Intrinsics.checkNotNullParameter(source, y.ٴسسݬߨ(1392903434));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        if (source.length() == 0) {
            return source;
        }
        String lowerCase = source.toLowerCase(Locale.ROOT);
        String str = y.֬ڱܱײٮ(-1159086455);
        Intrinsics.checkNotNullExpressionValue(lowerCase, str);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) lowerCase, key, 0, false, 6, (Object) null);
        while (indexOf$default > -1) {
            StringBuffer stringBuffer = new StringBuffer();
            String substring = source.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            stringBuffer.append(substring);
            stringBuffer.append(replace);
            String substring2 = source.substring(indexOf$default + key.length());
            Intrinsics.checkNotNullExpressionValue(substring2, y.ٲٴݴ״ٰ(1782336472));
            stringBuffer.append(substring2);
            source = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(source, y.ٲٴݴ״ٰ(1781855688));
            String lowerCase2 = source.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, str);
            indexOf$default = StringsKt.indexOf$default((CharSequence) lowerCase2, key, 0, false, 6, (Object) null);
        }
        return source;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String escapeHTML(String source) {
        Intrinsics.checkNotNullParameter(source, y.ٴسسݬߨ(1392903434));
        StringBuilder sb = new StringBuilder(RangesKt.coerceAtLeast(16, source.length()));
        int length = source.length();
        for (int i = 0; i < length; i++) {
            char charAt = source.charAt(i);
            if (charAt > 127 || charAt == '\"' || charAt == '\'' || charAt == '<' || charAt == '>' || charAt == '&') {
                sb.append(y.֬ڱܱײٮ(-1159719039));
                sb.append((int) charAt);
                sb.append(';');
            } else {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, y.ٲٴݴ״ٰ(1781855688));
        return sb2;
    }
}
