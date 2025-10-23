package com.kakaogame.broker;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterfaceBrokerHandler.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007H\u0007J\u001e\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J6\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001d"}, m839d2 = {"Lcom/kakaogame/broker/InterfaceBrokerHandler;", "", "()V", "TAG", "", "brokerMap", "", "Lcom/kakaogame/broker/InterfaceBrokerHandler$InterfaceBroker;", "getBrokerMap", "()Ljava/util/Map;", "setBrokerMap", "(Ljava/util/Map;)V", "hasBroker", "", "uri", "registerInterfaceBroker", "", "requestUri", "broker", "request", "Lcom/kakaogame/KGResult;", "activity", "Landroid/app/Activity;", "requestString", "requestWithUrl", "parameter", "", "InterfaceBroker", "InterfaceRequest", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InterfaceBrokerHandler {
    private static final String TAG = "InterfaceBrokerHandler";
    public static final InterfaceBrokerHandler INSTANCE = new InterfaceBrokerHandler();
    private static Map<String, InterfaceBroker> brokerMap = new LinkedHashMap();

    /* compiled from: InterfaceBrokerHandler.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H&¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/broker/InterfaceBrokerHandler$InterfaceBroker;", "", "request", "Lcom/kakaogame/KGResult;", "activity", "Landroid/app/Activity;", "Lcom/kakaogame/broker/InterfaceBrokerHandler$InterfaceRequest;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface InterfaceBroker {
        KGResult<?> request(Activity activity, InterfaceRequest request);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InterfaceBrokerHandler() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, InterfaceBroker> getBrokerMap() {
        return brokerMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setBrokerMap(Map<String, InterfaceBroker> map) {
        Intrinsics.checkNotNullParameter(map, y.ٴسسݬߨ(1392633402));
        brokerMap = map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void registerInterfaceBroker(String requestUri, InterfaceBroker broker) {
        Intrinsics.checkNotNullParameter(requestUri, y.دײܮڳܯ(2051368157));
        Intrinsics.checkNotNullParameter(broker, y.ٴسسݬߨ(1393321810));
        Logger.INSTANCE.m706v(y.ٲٴݴ״ٰ(1782151928), y.دײܮڳܯ(2051368253) + requestUri);
        String str = requestUri;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String obj = str.subSequence(i, length + 1).toString();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, y.دײܮڳܯ(2051368829));
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
        synchronized (brokerMap) {
            brokerMap.put(lowerCase, broker);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<?> request(Activity activity, String requestString) {
        try {
            if (activity == null) {
                return KGResult.INSTANCE.getResult(4000, "activity is null");
            }
            if (requestString == null) {
                return KGResult.INSTANCE.getResult(4000, "requestString is null");
            }
            InterfaceRequest interfaceRequest = new InterfaceRequest(requestString);
            InterfaceBroker interfaceBroker = brokerMap.get(interfaceRequest.getRequestUri());
            if (interfaceBroker == null) {
                return KGResult.INSTANCE.getResult(KGResult.KGResultCode.API_NOT_EXISTS, interfaceRequest.getRequestUri() + " is not registered");
            }
            KGResult<?> request = interfaceBroker.request(activity, interfaceRequest);
            return request == null ? KGResult.INSTANCE.getResult(9999, "result is null") : request;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782151928), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<?> requestWithUrl(Activity activity, String requestUri, Map<String, ? extends Object> parameter) {
        Intrinsics.checkNotNullParameter(parameter, y.ۮڭڭܬި(862456859));
        try {
            if (activity == null) {
                return KGResult.INSTANCE.getResult(4000, "activity is null");
            }
            if (requestUri == null) {
                return KGResult.INSTANCE.getResult(4000, "requestString is null");
            }
            InterfaceRequest interfaceRequest = new InterfaceRequest(requestUri, parameter);
            InterfaceBroker interfaceBroker = brokerMap.get(interfaceRequest.getRequestUri());
            if (interfaceBroker == null) {
                return KGResult.INSTANCE.getResult(4000, interfaceRequest.getRequestUri() + " is not registered");
            }
            KGResult<?> request = interfaceBroker.request(activity, interfaceRequest);
            return request == null ? KGResult.INSTANCE.getResult(9999, "result is null") : request;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782151928), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: InterfaceBrokerHandler.kt */
    @Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u0003R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/broker/InterfaceBrokerHandler$InterfaceRequest;", "", "uri", "", "parameter", "", "(Ljava/lang/String;Ljava/util/Map;)V", "request", "(Ljava/lang/String;)V", "requestUri", "getRequestUri", "()Ljava/lang/String;", "containsParameterKey", "", "key", "getParameter", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class InterfaceRequest {
        private final Map<String, Object> parameter;
        private final String requestUri;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRequestUri() {
            return this.requestUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InterfaceRequest(String str, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, y.ۮڭڭܬި(862392755));
            Intrinsics.checkNotNullParameter(map, y.ۮڭڭܬި(862456859));
            String str2 = str;
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String obj = str2.subSequence(i, length + 1).toString();
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, y.دײܮڳܯ(2051368829));
            String lowerCase = obj.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
            this.requestUri = lowerCase;
            this.parameter = map;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InterfaceRequest(String str) {
            Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(575820214));
            Object parse = JSONValue.parse(str);
            Intrinsics.checkNotNull(parse, y.֬ڱܱײٮ(-1158924303));
            JSONArray jSONArray = (JSONArray) parse;
            String str2 = (String) jSONArray.get(0);
            Intrinsics.checkNotNull(str2);
            String str3 = str2;
            int length = str3.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str3.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String obj = str3.subSequence(i, length + 1).toString();
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, y.دײܮڳܯ(2051368829));
            String lowerCase = obj.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
            this.requestUri = lowerCase;
            this.parameter = jSONArray.size() >= 2 ? (Map) jSONArray.get(1) : null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Object getParameter(String key) {
            Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
            Map<String, Object> map = this.parameter;
            if (map != null) {
                return map.get(key);
            }
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean containsParameterKey(String key) {
            Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
            Map<String, Object> map = this.parameter;
            if (map != null) {
                return map.containsKey(key);
            }
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean hasBroker(String uri) {
        if (uri == null) {
            return false;
        }
        String str = uri;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String obj = str.subSequence(i, length + 1).toString();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, y.دײܮڳܯ(2051368829));
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
        boolean containsKey = brokerMap.containsKey(lowerCase);
        Logger.INSTANCE.m706v(y.ٲٴݴ״ٰ(1782151928), y.ݮڮֲڭܩ(-628600364) + lowerCase + y.ݮڮֲڭܩ(-628756788) + containsKey);
        return containsKey;
    }
}
