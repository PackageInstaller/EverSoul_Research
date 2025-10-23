package com.kakaogame.infodesk;

import com.kakaogame.KGObject;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: InfodeskData.kt */
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0003\u001c\u001d\u001eB\u001b\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskData;", "Ljava/util/LinkedHashMap;", "", "", "m", "", "(Ljava/util/Map;)V", "alarms", "", "Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskAlarm;", "getAlarms", "()Ljava/util/List;", "isNeedToRefresh", "", "()Z", "notices", "Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice;", "getNotices", "serverCalendarOnPST", "Ljava/util/Calendar;", "getServerCalendarOnPST", "()Ljava/util/Calendar;", "timestamp", "", "getTimestamp", "()J", "setGettingDataTime", "", "Companion", "KGInfodeskAlarm", "KGInfodeskNotice", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InfodeskData extends LinkedHashMap<String, Object> {
    private static final String TAG = "InfodeskData";
    private static final long serialVersionUID = -7607538319351441650L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InfodeskData(Map<String, ? extends Object> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, y.ٴسسݬߨ(1392530698));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782260976) + map;
        String str2 = y.ۮڭڭܬި(862608723);
        logger.m706v(str2, str);
        JSONObject jSONObject = (JSONObject) map.get(y.ݬֲ֮ܲت(1512513359));
        if (jSONObject != null) {
            putAll(jSONObject);
        }
        JSONObject jSONObject2 = (JSONObject) map.get(y.ݮڮֲڭܩ(-628490068));
        if (jSONObject2 != null) {
            putAll(jSONObject2);
        }
        JSONObject jSONObject3 = (JSONObject) map.get(y.֬ڱܱײٮ(-1158780823));
        if (jSONObject3 != null) {
            putAll(jSONObject3);
        }
        JSONObject jSONObject4 = (JSONObject) map.get(y.ٲٴݴ״ٰ(1782262456));
        if (jSONObject4 != null) {
            putAll(jSONObject4);
        }
        Logger.INSTANCE.m706v(str2, y.ۮڭڭܬި(862609179) + this);
        CoreManager.INSTANCE.getInstance().setServerTimeStamp(getTimestamp());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Object get(String str) {
        return super.get((Object) str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
        return super.entrySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Object getOrDefault(String str, Object obj) {
        return super.getOrDefault((Object) str, (String) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ int getSize() {
        return super.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Object remove(String str) {
        return super.remove((Object) str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (obj instanceof String) {
            return remove((String) obj, obj2);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ boolean remove(String str, Object obj) {
        return super.remove((Object) str, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final long getTimestamp() {
        String str = y.֬ڱܱײٮ(-1158779935);
        try {
            if (!containsKey((Object) str)) {
                return -1L;
            }
            Number number = (Number) get((Object) str);
            Intrinsics.checkNotNull(number);
            return number.longValue();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862608723), e.toString(), e);
            return -1L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Calendar getServerCalendarOnPST() {
        Date date = new Date(CoreManager.INSTANCE.getInstance().currentTimeMillis());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        Date time = gregorianCalendar.getTime();
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862608723), y.ݮڮֲڭܩ(-628489332) + time + ']');
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(time);
        Intrinsics.checkNotNull(calendar);
        return calendar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setGettingDataTime() {
        put(y.ٴسسݬߨ(1393438954), Long.valueOf(CoreManager.INSTANCE.getInstance().currentTimeMillis()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNeedToRefresh() {
        try {
            return System.currentTimeMillis() >= getTimestamp() + DateUtils.MILLIS_PER_MINUTE;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862608723), e.toString(), e);
            return true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<KGInfodeskNotice> getNotices() {
        JSONArray jSONArray = (JSONArray) get((Object) y.֬ڱܱײٮ(-1159613431));
        if (jSONArray == null) {
            return null;
        }
        JSONArray jSONArray2 = jSONArray;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONArray2, 10));
        Iterator<Object> it = jSONArray2.iterator();
        while (it.hasNext()) {
            arrayList.add(new KGInfodeskNotice(TypeIntrinsics.asMutableMap(it.next())));
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<KGInfodeskAlarm> getAlarms() {
        JSONArray jSONArray = (JSONArray) get((Object) y.دײܮڳܯ(2051487045));
        if (jSONArray == null) {
            return null;
        }
        JSONArray jSONArray2 = jSONArray;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONArray2, 10));
        Iterator<Object> it = jSONArray2.iterator();
        while (it.hasNext()) {
            arrayList.add(new KGInfodeskAlarm(TypeIntrinsics.asMutableMap(it.next())));
        }
        return arrayList;
    }

    /* compiled from: InfodeskData.kt */
    @Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\n¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskAlarm;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "endTime", "", "getEndTime", "()J", "interval", "getInterval", "isCancel", "", "()Z", "notificationId", "getNotificationId", "()Ljava/lang/String;", "startTime", "getStartTime", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGInfodeskAlarm extends KGObject {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGInfodeskAlarm(Map<String, Object> map) {
            super(map);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getNotificationId() {
            return (String) get(y.دײܮڳܯ(2051283261));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getStartTime() {
            Object obj = get(y.ݬֲ֮ܲت(1512510487));
            Intrinsics.checkNotNull(obj, y.دײܮڳܯ(2051781685));
            return ((Long) obj).longValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getEndTime() {
            Object obj = get(y.ٴسسݬߨ(1393442554));
            Intrinsics.checkNotNull(obj, y.دײܮڳܯ(2051781685));
            return ((Long) obj).longValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getInterval() {
            Object obj = get(y.ݬֲ֮ܲت(1512510599));
            Intrinsics.checkNotNull(obj, y.دײܮڳܯ(2051781685));
            return ((Long) obj).longValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isCancel() {
            return StringsKt.equals((String) get(y.ݮڮֲڭܩ(-628487100)), y.֬ڱܱײٮ(-1158781631), true);
        }
    }

    /* compiled from: InfodeskData.kt */
    @Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "actionOnClose", "Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice$InfodeskNoticeActionOnClose;", "getActionOnClose", "()Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice$InfodeskNoticeActionOnClose;", "displayRule", "Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice$InfodeskNoticeDisplayRule;", "getDisplayRule", "()Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice$InfodeskNoticeDisplayRule;", "link", "getLink", "()Ljava/lang/String;", "message", "getMessage", "noticeId", "getNoticeId", "startTime", "", "getStartTime", "()J", "Companion", "InfodeskNoticeActionOnClose", "InfodeskNoticeDisplayRule", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGInfodeskNotice extends KGObject {
        private static final long serialVersionUID = -2077740676410310224L;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGInfodeskNotice(Map<String, Object> map) {
            super(map);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getNoticeId() {
            return (String) get(y.٬ݯح׭٩(576585534));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getMessage() {
            return (String) get(y.ݬֲ֮ܲت(1512734375));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLink() {
            return (String) get(y.ݮڮֲڭܩ(-628442580));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getStartTime() {
            Object obj = get(y.ٴسسݬߨ(1393441538));
            Intrinsics.checkNotNull(obj, y.دײܮڳܯ(2051781685));
            return ((Long) obj).longValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final InfodeskNoticeActionOnClose getActionOnClose() {
            String str = (String) get(y.ۮڭڭܬި(862606107));
            for (InfodeskNoticeActionOnClose infodeskNoticeActionOnClose : InfodeskNoticeActionOnClose.values()) {
                if (StringsKt.equals(infodeskNoticeActionOnClose.getValue(), str, true)) {
                    return infodeskNoticeActionOnClose;
                }
            }
            return InfodeskNoticeActionOnClose.NONE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final InfodeskNoticeDisplayRule getDisplayRule() {
            String str = (String) get(y.ݮڮֲڭܩ(-628486412));
            for (InfodeskNoticeDisplayRule infodeskNoticeDisplayRule : InfodeskNoticeDisplayRule.values()) {
                if (StringsKt.equals(infodeskNoticeDisplayRule.getValue(), str, true)) {
                    return infodeskNoticeDisplayRule;
                }
            }
            return InfodeskNoticeDisplayRule.ALWAYS;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: InfodeskData.kt */
        @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice$InfodeskNoticeActionOnClose;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "TERMINATE", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class InfodeskNoticeActionOnClose {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ InfodeskNoticeActionOnClose[] $VALUES;
            public static final InfodeskNoticeActionOnClose NONE = new InfodeskNoticeActionOnClose(y.ۮڭڭܬި(862123667), 0, y.ݬֲ֮ܲت(1512369879));
            public static final InfodeskNoticeActionOnClose TERMINATE = new InfodeskNoticeActionOnClose(y.֬ڱܱײٮ(-1158781567), 1, y.ٲٴݴ״ٰ(1782149840));
            private final String value;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private static final /* synthetic */ InfodeskNoticeActionOnClose[] $values() {
                return new InfodeskNoticeActionOnClose[]{NONE, TERMINATE};
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumEntries<InfodeskNoticeActionOnClose> getEntries() {
                return $ENTRIES;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static InfodeskNoticeActionOnClose valueOf(String str) {
                return (InfodeskNoticeActionOnClose) Enum.valueOf(InfodeskNoticeActionOnClose.class, str);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static InfodeskNoticeActionOnClose[] values() {
                return (InfodeskNoticeActionOnClose[]) $VALUES.clone();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private InfodeskNoticeActionOnClose(String str, int i, String str2) {
                this.value = str2;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String getValue() {
                return this.value;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            static {
                InfodeskNoticeActionOnClose[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: InfodeskData.kt */
        @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice$InfodeskNoticeDisplayRule;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ONCE", "DAILY", "ALWAYS", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class InfodeskNoticeDisplayRule {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ InfodeskNoticeDisplayRule[] $VALUES;
            private final String value;
            public static final InfodeskNoticeDisplayRule ONCE = new InfodeskNoticeDisplayRule(y.ݮڮֲڭܩ(-628486892), 0, y.ݮڮֲڭܩ(-628486844));
            public static final InfodeskNoticeDisplayRule DAILY = new InfodeskNoticeDisplayRule(y.ٴسسݬߨ(1392578922), 1, y.ۮڭڭܬި(862605379));
            public static final InfodeskNoticeDisplayRule ALWAYS = new InfodeskNoticeDisplayRule(y.֬ڱܱײٮ(-1158781743), 2, y.ۮڭڭܬި(862605467));

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private static final /* synthetic */ InfodeskNoticeDisplayRule[] $values() {
                return new InfodeskNoticeDisplayRule[]{ONCE, DAILY, ALWAYS};
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumEntries<InfodeskNoticeDisplayRule> getEntries() {
                return $ENTRIES;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static InfodeskNoticeDisplayRule valueOf(String str) {
                return (InfodeskNoticeDisplayRule) Enum.valueOf(InfodeskNoticeDisplayRule.class, str);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static InfodeskNoticeDisplayRule[] values() {
                return (InfodeskNoticeDisplayRule[]) $VALUES.clone();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private InfodeskNoticeDisplayRule(String str, int i, String str2) {
                this.value = str2;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String getValue() {
                return this.value;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            static {
                InfodeskNoticeDisplayRule[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }
    }
}
