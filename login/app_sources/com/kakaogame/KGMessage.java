package com.kakaogame;

import android.app.Activity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.KGMessage;
import com.kakaogame.KGResult;
import com.kakaogame.addon.KGService;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.delivery.DeliveryService;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGMessage.kt */
@Metadata(m838d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 12\u00020\u0001:\u000512345B\u001f\b\u0000\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\tR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\tR\u0011\u0010\u001d\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0011\u0010\u001f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0011\u0010!\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\rR\u001f\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b(\u0010\tR$\u0010)\u001a\u00020*2\u0006\u0010)\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b0\u0010\t¨\u00066"}, m839d2 = {"Lcom/kakaogame/KGMessage;", "Lcom/kakaogame/KGObject;", "messagePacket", "", "", "", "(Ljava/util/Map;)V", SDKConstants.PARAM_A2U_BODY, "getBody", "()Ljava/lang/String;", "deliverySeq", "", "getDeliverySeq", "()J", "expiryTime", "getExpiryTime", FirebaseAnalytics.Param.ITEMS, "", "Lcom/kakaogame/KGItem;", "getItems", "()Ljava/util/List;", "message", "Lcom/kakaogame/util/json/JSONObject;", "getMessage", "()Lcom/kakaogame/util/json/JSONObject;", "messageBoxId", "getMessageBoxId", "messageId", "getMessageId", "modTime", "getModTime", "readTime", "getReadTime", ServerConstants.REG_TIME, "getRegTime", "resourceMap", "", "getResourceMap", "()Ljava/util/Map;", "senderId", "getSenderId", "state", "Lcom/kakaogame/KGMessage$KGMessageState;", "getState", "()Lcom/kakaogame/KGMessage$KGMessageState;", "setState", "(Lcom/kakaogame/KGMessage$KGMessageState;)V", "title", "getTitle", "Companion", "KGMessageResponse", "KGMessageResultCode", "KGMessageState", "MessageCount", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGMessage extends KGObject {
    private static final String CLASS_NAME_KEY = "KGMessage";
    private static final String MESSAGEBOX_ID_INBOX = "inbox";
    public static final long PAGE_KEY_END = -1;
    public static final long PAGE_KEY_INIT = Long.MAX_VALUE;
    public static final String SENDER_ID_ACHIEVEMENT = "achievement";
    public static final String SENDER_ID_ADMIN = "admin";
    public static final String SENDER_ID_COUPON = "coupon";
    public static final String SENDER_ID_NOTICE = "notice";
    public static final String SENDER_ID_PROMOTION = "promotion";
    public static final String SENDER_ID_TOURNAMENT = "tournament";
    private static final String TAG = "KGMessage";
    private static final long serialVersionUID = 4331202737815627514L;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, MessageCount> messageCountCache = new LinkedHashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void deleteMessages(List<KGMessage> list, KGResultCallback<Void> kGResultCallback) {
        INSTANCE.deleteMessages(list, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadMessages(String str, List<? extends KGMessageState> list, long j, int i, KGResultCallback<KGMessageResponse> kGResultCallback) {
        INSTANCE.loadMessages(str, list, j, i, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadUnreadMessageCount(String str, KGResultCallback<Integer> kGResultCallback) {
        INSTANCE.loadUnreadMessageCount(str, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void markAsReadMessages(List<KGMessage> list, KGResultCallback<Void> kGResultCallback) {
        INSTANCE.markAsReadMessages(list, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void updateAction() {
        INSTANCE.updateAction();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGMessage(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSenderId() {
        return (String) get(y.֬ڱܱײٮ(-1159469759));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMessageId() {
        JSONObject message = getMessage();
        if (message == null) {
            return null;
        }
        return (String) message.get((Object) y.ۮڭڭܬި(862443499));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMessageBoxId() {
        JSONObject message = getMessage();
        if (message == null) {
            return null;
        }
        return (String) message.get((Object) y.ݮڮֲڭܩ(-628649356));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitle() {
        JSONObject message = getMessage();
        if (message == null) {
            return null;
        }
        return (String) message.get((Object) y.ٲٴݴ״ٰ(1781623336));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBody() {
        JSONObject message = getMessage();
        if (message == null) {
            return null;
        }
        return (String) message.get((Object) y.ۮڭڭܬި(862442651));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> getResourceMap() {
        JSONObject message = getMessage();
        if (message == null) {
            return new LinkedHashMap();
        }
        String str = y.֬ڱܱײٮ(-1159469783);
        if (!message.containsKey((Object) str)) {
            return new LinkedHashMap();
        }
        return (Map) message.get((Object) str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getReadTime() {
        Number number;
        JSONObject message = getMessage();
        if (message == null || (number = (Number) message.get((Object) y.ݮڮֲڭܩ(-628651220))) == null) {
            return 0L;
        }
        return number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getExpiryTime() {
        Number number;
        JSONObject message = getMessage();
        if (message == null || (number = (Number) message.get((Object) y.֬ڱܱײٮ(-1159470215))) == null) {
            return 0L;
        }
        return number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getDeliverySeq() {
        Number number;
        JSONObject message = getMessage();
        if (message == null || (number = (Number) message.get((Object) y.ݬֲ֮ܲت(1512740423))) == null) {
            return 0L;
        }
        return number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getModTime() {
        Number number;
        JSONObject message = getMessage();
        if (message == null || (number = (Number) message.get((Object) y.ݬֲ֮ܲت(1512740015))) == null) {
            return 0L;
        }
        return number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getRegTime() {
        Number number;
        JSONObject message = getMessage();
        if (message == null || (number = (Number) message.get((Object) y.دײܮڳܯ(2051718589))) == null) {
            return 0L;
        }
        return number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGMessageState getState() {
        JSONObject message = getMessage();
        if (message == null) {
            return KGMessageState.EXPIRED;
        }
        String str = (String) message.get((Object) y.֬ڱܱײٮ(-1159648199));
        for (KGMessageState kGMessageState : KGMessageState.values()) {
            if (StringsKt.equals(kGMessageState.getValue$gamesdk_release(), str, true)) {
                return kGMessageState;
            }
        }
        return KGMessageState.EXPIRED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setState(KGMessageState kGMessageState) {
        String str = y.֬ڱܱײٮ(-1159648199);
        Intrinsics.checkNotNullParameter(kGMessageState, str);
        put(str, kGMessageState.getValue$gamesdk_release());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<KGItem> getItems() {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = (JSONArray) get(y.ٴسسݬߨ(1392754426));
        if (jSONArray != null) {
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new KGItem((JSONObject) jSONArray.get(i)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final JSONObject getMessage() {
        return (JSONObject) get(y.دײܮڳܯ(2051551053));
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGMessage.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/KGMessage$KGMessageState;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$gamesdk_release", "()Ljava/lang/String;", "UNREAD", "READ", "EXPIRED", "DELETED", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGMessageState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGMessageState[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final KGMessageState UNREAD = new KGMessageState(y.֬ڱܱײٮ(-1159470759), 0, y.ۮڭڭܬި(862442771));
        public static final KGMessageState READ = new KGMessageState(y.ݬֲ֮ܲت(1513072495), 1, y.٬ݯح׭٩(575699094));
        public static final KGMessageState EXPIRED = new KGMessageState(y.֬ڱܱײٮ(-1159648559), 2, y.ۮڭڭܬި(862442979));
        public static final KGMessageState DELETED = new KGMessageState(y.دײܮڳܯ(2051718933), 3, y.֬ڱܱײٮ(-1159471071));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGMessageState[] $values() {
            return new KGMessageState[]{UNREAD, READ, EXPIRED, DELETED};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGMessageState> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGMessageState valueOf(String str) {
            return (KGMessageState) Enum.valueOf(KGMessageState.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGMessageState[] values() {
            return (KGMessageState[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGMessageState(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue$gamesdk_release() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGMessageState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        /* compiled from: KGMessage.kt */
        @Metadata(m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/KGMessage$KGMessageState$Companion;", "", "()V", "convertMessageState", "Lcom/kakaogame/KGMessage$KGMessageState;", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGMessageState convertMessageState(String str) {
                Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(575694806));
                for (KGMessageState kGMessageState : KGMessageState.values()) {
                    if (StringsKt.equals(kGMessageState.getValue$gamesdk_release(), str, true)) {
                        return kGMessageState;
                    }
                }
                return null;
            }
        }
    }

    /* compiled from: KGMessage.kt */
    @Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/KGMessage$KGMessageResponse;", "", "messages", "", "Lcom/kakaogame/KGMessage;", "nextPageKey", "", "maxCount", "", "totalCount", "(Ljava/util/List;JII)V", "getMaxCount", "()I", "getMessages", "()Ljava/util/List;", "getNextPageKey", "()J", "getTotalCount", "toString", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGMessageResponse {
        private final int maxCount;
        private final List<KGMessage> messages;
        private final long nextPageKey;
        private final int totalCount;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGMessageResponse(List<KGMessage> list, long j, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, y.ٴسسݬߨ(1392662162));
            this.messages = list;
            this.nextPageKey = j;
            this.maxCount = i;
            this.totalCount = i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<KGMessage> getMessages() {
            return this.messages;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getNextPageKey() {
            return this.nextPageKey;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getMaxCount() {
            return this.maxCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTotalCount() {
            return this.totalCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (!this.messages.isEmpty()) {
                stringBuffer.append(y.֬ڱܱײٮ(-1159463751) + this.messages);
            } else {
                stringBuffer.append(y.ݬֲ֮ܲت(1512737407));
            }
            stringBuffer.append(y.ٴسسݬߨ(1392747058) + this.nextPageKey);
            stringBuffer.append(y.ٲٴݴ״ٰ(1781972448) + this.maxCount);
            stringBuffer.append(y.ٴسسݬߨ(1392747322) + this.totalCount);
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
            return stringBuffer2;
        }
    }

    /* compiled from: KGMessage.kt */
    @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/KGMessage$MessageCount;", "", "getTime", "", KGService.COUNT, "", "(JI)V", "getCount", "()I", "getGetTime", "()J", "getNew", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static abstract class MessageCount {
        private final int count;
        private final long getTime;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public MessageCount(long j, int i) {
            this.getTime = j;
            this.count = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getGetTime() {
            return this.getTime;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getCount() {
            return this.count;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean getNew() {
            return CoreManager.INSTANCE.getInstance().currentTimeMillis() > this.getTime + InfodeskHelper.INSTANCE.getMessageCountCacheSec();
        }
    }

    /* compiled from: KGMessage.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/KGMessage$KGMessageResultCode;", "", "()V", "MESSAGE_BOX_ID_NOT_FOUND", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private static final class KGMessageResultCode {
        public static final KGMessageResultCode INSTANCE = new KGMessageResultCode();
        public static final int MESSAGE_BOX_ID_NOT_FOUND = 461;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGMessageResultCode() {
        }
    }

    /* compiled from: KGMessage.kt */
    @Metadata(m838d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J(\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH\u0007J \u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001d2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0006\u0010\u001f\u001a\u00020\u0015J@\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u001bH\u0007J:\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u00042\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00182\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010(\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00042\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010\u001bH\u0007J\u001a\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010)\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH\u0007J \u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001d2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0002J\b\u0010*\u001a\u00020\u0015H\u0007J\u0018\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u001d2\u0006\u0010!\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, m839d2 = {"Lcom/kakaogame/KGMessage$Companion;", "", "()V", "CLASS_NAME_KEY", "", "MESSAGEBOX_ID_INBOX", "PAGE_KEY_END", "", "PAGE_KEY_INIT", "SENDER_ID_ACHIEVEMENT", "SENDER_ID_ADMIN", "SENDER_ID_COUPON", "SENDER_ID_NOTICE", "SENDER_ID_PROMOTION", "SENDER_ID_TOURNAMENT", "TAG", "messageCountCache", "", "Lcom/kakaogame/KGMessage$MessageCount;", "serialVersionUID", "clearCacheData", "", "deleteMessages", "messages", "", "Lcom/kakaogame/KGMessage;", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "Lcom/kakaogame/KGResult;", "initInterfaceBroker", "initialize", "loadMessages", "messageBoxId", "states", "Lcom/kakaogame/KGMessage$KGMessageState;", "pageKey", KGService.COUNT, "", "Lcom/kakaogame/KGMessage$KGMessageResponse;", "loadUnreadMessageCount", "markAsReadMessages", "updateAction", "updateMessageCount", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<Void> markAsReadMessages(List<KGMessage> messages) {
            KGResult<Void> result;
            String name;
            String str = y.ݮڮֲڭܩ(-628647932);
            Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575692950));
            try {
                try {
                    if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.delivery)) {
                        result = KGResult.INSTANCE.getResult(5001);
                    } else if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                        result = KGResult.INSTANCE.getResult(3002);
                    } else {
                        if (messages != null && !messages.isEmpty()) {
                            clearCacheData();
                            List<KGMessage> list = messages;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((KGMessage) it.next()).getMessageId());
                            }
                            KGResult<Void> markAsReadMessages = DeliveryService.markAsReadMessages(arrayList);
                            if (markAsReadMessages.isNotSuccess()) {
                                result = KGResult.INSTANCE.getResult(markAsReadMessages);
                            } else {
                                Iterator<KGMessage> it2 = messages.iterator();
                                while (it2.hasNext()) {
                                    it2.next().setState(KGMessageState.READ);
                                }
                                result = KGResult.INSTANCE.getSuccessResult();
                            }
                        }
                        result = KGResult.INSTANCE.getResult(4000, str + messages);
                    }
                    start.stop();
                    name = start.getName();
                } catch (Exception e) {
                    Logger.INSTANCE.m702e("KGMessage", e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                }
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            } catch (Throwable th) {
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void markAsReadMessages(List<KGMessage> messages, KGResultCallback<Void> callback) {
            Intrinsics.checkNotNullParameter(messages, y.ٴسسݬߨ(1392662162));
            Logger.INSTANCE.m704i(y.ٲٴݴ״ٰ(1782008680), y.ݬֲ֮ܲت(1512737759) + messages);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGMessage$Companion$markAsReadMessages$5(messages, callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<Void> deleteMessages(List<KGMessage> messages) {
            KGResult<Void> result;
            String name;
            String str = y.ݮڮֲڭܩ(-628647932);
            Stopwatch start = Stopwatch.INSTANCE.start(y.ݬֲ֮ܲت(1512736623));
            try {
                try {
                    if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.delivery)) {
                        result = KGResult.INSTANCE.getResult(5001);
                    } else if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                        result = KGResult.INSTANCE.getResult(3002);
                    } else {
                        if (messages != null && !messages.isEmpty()) {
                            clearCacheData();
                            List<KGMessage> list = messages;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((KGMessage) it.next()).getMessageId());
                            }
                            KGResult<Void> deleteMessages = DeliveryService.deleteMessages(arrayList);
                            if (deleteMessages.isNotSuccess()) {
                                result = KGResult.INSTANCE.getResult(deleteMessages);
                            } else {
                                Iterator<KGMessage> it2 = messages.iterator();
                                while (it2.hasNext()) {
                                    it2.next().setState(KGMessageState.DELETED);
                                }
                                result = KGResult.INSTANCE.getSuccessResult();
                            }
                        }
                        result = KGResult.INSTANCE.getResult(4000, str + messages);
                    }
                    start.stop();
                    name = start.getName();
                } catch (Exception e) {
                    Logger.INSTANCE.m702e("KGMessage", e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    name = start.getName();
                }
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            } catch (Throwable th) {
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void deleteMessages(List<KGMessage> messages, KGResultCallback<Void> callback) {
            Intrinsics.checkNotNullParameter(messages, y.ٴسسݬߨ(1392662162));
            Logger.INSTANCE.m704i(y.ٲٴݴ״ٰ(1782008680), y.ݬֲ֮ܲت(1512738335) + messages);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGMessage$Companion$deleteMessages$5(messages, callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[Catch: all -> 0x017a, Exception -> 0x017c, TryCatch #0 {Exception -> 0x017c, blocks: (B:4:0x001c, B:6:0x0026, B:11:0x0030, B:13:0x003c, B:14:0x0046, B:16:0x004d, B:22:0x005b, B:23:0x0065, B:25:0x006a, B:28:0x0073, B:29:0x007d, B:31:0x0087, B:34:0x009e, B:35:0x00b4, B:37:0x00ba, B:39:0x00c8, B:41:0x00d4, B:42:0x00dd, B:43:0x0104, B:45:0x010a, B:47:0x0120, B:49:0x013b, B:51:0x0143, B:52:0x014a, B:54:0x0150, B:56:0x0158, B:57:0x015f), top: B:3:0x001c, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[Catch: all -> 0x017a, Exception -> 0x017c, TryCatch #0 {Exception -> 0x017c, blocks: (B:4:0x001c, B:6:0x0026, B:11:0x0030, B:13:0x003c, B:14:0x0046, B:16:0x004d, B:22:0x005b, B:23:0x0065, B:25:0x006a, B:28:0x0073, B:29:0x007d, B:31:0x0087, B:34:0x009e, B:35:0x00b4, B:37:0x00ba, B:39:0x00c8, B:41:0x00d4, B:42:0x00dd, B:43:0x0104, B:45:0x010a, B:47:0x0120, B:49:0x013b, B:51:0x0143, B:52:0x014a, B:54:0x0150, B:56:0x0158, B:57:0x015f), top: B:3:0x001c, outer: #1 }] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.kakaogame.KGResult<com.kakaogame.KGMessage.KGMessageResponse> loadMessages(java.lang.String r11, java.util.List<? extends com.kakaogame.KGMessage.KGMessageState> r12, long r13, int r15) {
            /*
                Method dump skipped, instructions count: 442
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGMessage.Companion.loadMessages(java.lang.String, java.util.List, long, int):com.kakaogame.KGResult");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void loadMessages(String messageBoxId, List<? extends KGMessageState> states, long pageKey, int count, KGResultCallback<KGMessageResponse> callback) {
            Intrinsics.checkNotNullParameter(messageBoxId, y.ݮڮֲڭܩ(-628649356));
            Intrinsics.checkNotNullParameter(states, y.ݮڮֲڭܩ(-628649276));
            Logger logger = Logger.INSTANCE;
            StringBuilder append = new StringBuilder(y.ݮڮֲڭܩ(-628649340)).append(messageBoxId);
            String str = y.ݮڮֲڭܩ(-628756788);
            logger.m699d(y.ٲٴݴ״ٰ(1782008680), append.append(str).append(states).append(str).append(pageKey).append(str).append(count).toString());
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGMessage$Companion$loadMessages$3(messageBoxId, states, pageKey, count, callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final KGResult<Integer> updateMessageCount(String messageBoxId) {
            KGResult<Integer> unreadMessageCount = DeliveryService.getUnreadMessageCount(messageBoxId);
            if (!unreadMessageCount.isNotSuccess()) {
                Map map = KGMessage.messageCountCache;
                Integer content = unreadMessageCount.getContent();
                Intrinsics.checkNotNull(content);
                final int intValue = content.intValue();
                final long currentTimeMillis = CoreManager.INSTANCE.getInstance().currentTimeMillis();
                map.put(messageBoxId, new MessageCount(intValue, currentTimeMillis) { // from class: com.kakaogame.KGMessage$Companion$updateMessageCount$1
                });
                KGResult.Companion companion = KGResult.INSTANCE;
                Integer content2 = unreadMessageCount.getContent();
                Intrinsics.checkNotNull(content2);
                return companion.getSuccessResult(content2);
            }
            return KGResult.INSTANCE.getResult(unreadMessageCount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[Catch: all -> 0x00b7, Exception -> 0x00b9, TryCatch #0 {Exception -> 0x00b9, blocks: (B:4:0x0015, B:6:0x001f, B:11:0x0029, B:13:0x0035, B:14:0x003e, B:16:0x0043, B:21:0x004f, B:22:0x005a, B:24:0x0064, B:27:0x007b, B:29:0x0087, B:32:0x008e, B:33:0x00a4), top: B:3:0x0015, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[Catch: all -> 0x00b7, Exception -> 0x00b9, TryCatch #0 {Exception -> 0x00b9, blocks: (B:4:0x0015, B:6:0x001f, B:11:0x0029, B:13:0x0035, B:14:0x003e, B:16:0x0043, B:21:0x004f, B:22:0x005a, B:24:0x0064, B:27:0x007b, B:29:0x0087, B:32:0x008e, B:33:0x00a4), top: B:3:0x0015, outer: #1 }] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.kakaogame.KGResult<java.lang.Integer> loadUnreadMessageCount(java.lang.String r7) {
            /*
                r6 = this;
                r0 = 1782008680(0x6a374b68, float:5.539738E25)
                java.lang.String r0 = com.liapp.y.ٲٴݴ״ٰ(r0)
                com.kakaogame.util.Stopwatch$Companion r1 = com.kakaogame.util.Stopwatch.INSTANCE
                r2 = 1781970096(0x6a36b4b0, float:5.5219443E25)
                java.lang.String r2 = com.liapp.y.ٲٴݴ״ٰ(r2)
                com.kakaogame.util.Stopwatch r1 = r1.start(r2)
                r2 = 0
                com.kakaogame.core.FeatureManager r3 = com.kakaogame.core.FeatureManager.INSTANCE     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                com.kakaogame.core.FeatureManager$Feature r4 = com.kakaogame.core.FeatureManager.Feature.delivery     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                boolean r3 = r3.isNotSupportedFeature(r4)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                if (r3 == 0) goto L29
                com.kakaogame.KGResult$Companion r7 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                r3 = 5001(0x1389, float:7.008E-42)
                com.kakaogame.KGResult r7 = r7.getResult(r3)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                goto La8
            L29:
                com.kakaogame.core.CoreManager$Companion r3 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                com.kakaogame.core.CoreManager r3 = r3.getInstance()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                boolean r3 = r3.isNotAuthorized()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                if (r3 == 0) goto L3e
                com.kakaogame.KGResult$Companion r7 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                r3 = 3002(0xbba, float:4.207E-42)
                com.kakaogame.KGResult r7 = r7.getResult(r3)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                goto La8
            L3e:
                r3 = r7
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                if (r3 == 0) goto L4c
                int r3 = r3.length()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                if (r3 != 0) goto L4a
                goto L4c
            L4a:
                r3 = 0
                goto L4d
            L4c:
                r3 = 1
            L4d:
                if (r3 == 0) goto L5a
                com.kakaogame.KGResult$Companion r7 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                java.lang.String r3 = "messageBoxId is null"
                r4 = 4000(0xfa0, float:5.605E-42)
                com.kakaogame.KGResult r7 = r7.getResult(r4, r3)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                goto La8
            L5a:
                com.kakaogame.KGResult r3 = com.kakaogame.promotion.PromotionService.sendSavedRequestSNSShareReward()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                boolean r4 = r3.isNotSuccess()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                if (r4 == 0) goto L7b
                com.kakaogame.KGResult$Companion r7 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                java.util.Map r3 = (java.util.Map) r3     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                com.kakaogame.KGResult r7 = r7.getResult(r3)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                r1.stop()
                java.lang.String r0 = r1.getName()
                long r3 = r1.getDurationMs()
                com.kakaogame.core.KGResultUtil.writeClientApiCall(r0, r2, r3)
                return r7
            L7b:
                java.util.Map r3 = com.kakaogame.KGMessage.access$getMessageCountCache$cp()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                java.lang.Object r3 = r3.get(r7)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                com.kakaogame.KGMessage$MessageCount r3 = (com.kakaogame.KGMessage.MessageCount) r3     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                if (r3 == 0) goto La4
                boolean r4 = r3.getNew()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                if (r4 == 0) goto L8e
                goto La4
            L8e:
                com.kakaogame.Logger r7 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                java.lang.String r4 = "Return -- Cached Message Count."
                r7.m699d(r0, r4)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                com.kakaogame.KGResult$Companion r7 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                int r3 = r3.getCount()     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                com.kakaogame.KGResult r7 = r7.getSuccessResult(r3)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
                goto La8
            La4:
                com.kakaogame.KGResult r7 = r6.updateMessageCount(r7)     // Catch: java.lang.Throwable -> Lb7 java.lang.Exception -> Lb9
            La8:
                r1.stop()
                java.lang.String r0 = r1.getName()
            Laf:
                long r1 = r1.getDurationMs()
                com.kakaogame.core.KGResultUtil.writeClientApiCall(r0, r7, r1)
                goto Ldd
            Lb7:
                r7 = move-exception
                goto Lde
            Lb9:
                r7 = move-exception
                com.kakaogame.Logger r3 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Throwable -> Lb7
                java.lang.String r4 = r7.toString()     // Catch: java.lang.Throwable -> Lb7
                r5 = r7
                java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch: java.lang.Throwable -> Lb7
                r3.m702e(r0, r4, r5)     // Catch: java.lang.Throwable -> Lb7
                com.kakaogame.KGResult$Companion r0 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Lb7
                java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb7
                r3 = 4001(0xfa1, float:5.607E-42)
                com.kakaogame.KGResult r7 = r0.getResult(r3, r7)     // Catch: java.lang.Throwable -> Lb7
                r1.stop()
                java.lang.String r0 = r1.getName()
                r2 = r7
                com.kakaogame.KGResult r2 = (com.kakaogame.KGResult) r2
                goto Laf
            Ldd:
                return r7
            Lde:
                r1.stop()
                java.lang.String r0 = r1.getName()
                r3 = r2
                com.kakaogame.KGResult r3 = (com.kakaogame.KGResult) r3
                long r3 = r1.getDurationMs()
                com.kakaogame.core.KGResultUtil.writeClientApiCall(r0, r2, r3)
                throw r7
                fill-array 0x00f0: FILL_ARRAY_DATA , data: ?
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGMessage.Companion.loadUnreadMessageCount(java.lang.String):com.kakaogame.KGResult");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void loadUnreadMessageCount(String messageBoxId, KGResultCallback<Integer> callback) {
            Intrinsics.checkNotNullParameter(messageBoxId, y.ݮڮֲڭܩ(-628649356));
            Logger.INSTANCE.m704i(y.ٲٴݴ״ٰ(1782008680), y.٬ݯح׭٩(575693654) + messageBoxId);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGMessage$Companion$loadUnreadMessageCount$3(messageBoxId, callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void updateAction() {
            Logger.INSTANCE.m704i(y.ٲٴݴ״ٰ(1782008680), y.ٲٴݴ״ٰ(1781972496));
            clearCacheData();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void clearCacheData() {
            KGMessage.messageCountCache.clear();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628647452), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGMessage$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> loadMessages;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    String str = (String) request.getParameter("messageBoxId");
                    List<String> list = (List) request.getParameter("states");
                    Number number = (Number) request.getParameter(y.ݬֲ֮ܲت(1512799951));
                    Intrinsics.checkNotNull(number);
                    long longValue = number.longValue();
                    Number number2 = (Number) request.getParameter(y.٬ݯح׭٩(575838374));
                    Intrinsics.checkNotNull(number2);
                    int intValue = number2.intValue();
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNull(list);
                    for (String str2 : list) {
                        KGMessage.KGMessageState convertMessageState = KGMessage.KGMessageState.INSTANCE.convertMessageState(str2);
                        if (convertMessageState != null) {
                            arrayList.add(convertMessageState);
                        } else {
                            return KGResult.INSTANCE.getResult(4000, y.ۮڭڭܬި(862338219) + str2);
                        }
                    }
                    loadMessages = KGMessage.INSTANCE.loadMessages(str, arrayList, longValue, intValue);
                    FirebaseEvent.INSTANCE.sendEvent(y.ٲٴݴ״ٰ(1782008680), y.ݮڮֲڭܩ(-628727284), loadMessages);
                    if (loadMessages.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(loadMessages);
                    }
                    KGMessage.KGMessageResponse kGMessageResponse = (KGMessage.KGMessageResponse) loadMessages.getContent();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Intrinsics.checkNotNull(kGMessageResponse);
                    linkedHashMap.put(y.ٴسسݬߨ(1392662162), kGMessageResponse.getMessages());
                    linkedHashMap.put(y.٬ݯح׭٩(575771438), Long.valueOf(kGMessageResponse.getNextPageKey()));
                    linkedHashMap.put(y.ٲٴݴ״ٰ(1782007952), Integer.valueOf(kGMessageResponse.getMaxCount()));
                    linkedHashMap.put(y.ۮڭڭܬި(862269467), Integer.valueOf(kGMessageResponse.getTotalCount()));
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575695510), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGMessage$Companion$initInterfaceBroker$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> loadUnreadMessageCount;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    loadUnreadMessageCount = KGMessage.INSTANCE.loadUnreadMessageCount((String) request.getParameter("messageBoxId"));
                    FirebaseEvent.INSTANCE.sendEvent(y.ٲٴݴ״ٰ(1782008680), y.ٲٴݴ״ٰ(1782008000), loadUnreadMessageCount);
                    if (loadUnreadMessageCount.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(loadUnreadMessageCount);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.٬ݯح׭٩(575838374), loadUnreadMessageCount.getContent());
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392750522), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGMessage$Companion$initInterfaceBroker$3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> markAsReadMessages;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    List list = (List) request.getParameter("messages");
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNull(list);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new KGMessage((Map) it.next()));
                    }
                    markAsReadMessages = KGMessage.INSTANCE.markAsReadMessages(arrayList);
                    FirebaseEvent.INSTANCE.sendEvent(y.ٲٴݴ״ٰ(1782008680), y.ٲٴݴ״ٰ(1782009728), markAsReadMessages);
                    if (markAsReadMessages.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(markAsReadMessages);
                    }
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392748890), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGMessage$Companion$initInterfaceBroker$4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> deleteMessages;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    List list = (List) request.getParameter("messages");
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNull(list);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new KGMessage((Map) it.next()));
                    }
                    deleteMessages = KGMessage.INSTANCE.deleteMessages(arrayList);
                    FirebaseEvent.INSTANCE.sendEvent(y.ٲٴݴ״ٰ(1782008680), y.ٴسسݬߨ(1392661642), deleteMessages);
                    if (deleteMessages.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(deleteMessages);
                    }
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392749146), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGMessage$Companion$initInterfaceBroker$5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGMessage.INSTANCE.updateAction();
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
        }
    }
}
