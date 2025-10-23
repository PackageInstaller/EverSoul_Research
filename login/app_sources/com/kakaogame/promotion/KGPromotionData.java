package com.kakaogame.promotion;

import android.content.Context;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGObject;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGPromotionData.kt */
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!J\u0018\u0010 \u001a\u00020#2\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010%R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006)"}, m839d2 = {"Lcom/kakaogame/promotion/KGPromotionData;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "applyType", "Lcom/kakaogame/promotion/KGPromotionData$KGPromotionApplyType;", "getApplyType", "()Lcom/kakaogame/promotion/KGPromotionData$KGPromotionApplyType;", KGKakaoInvitation.KGKakaoEvent.START_TIME, "", "getBeginTime", "()J", "endTime", "getEndTime", "landscapeImageUrl", "getLandscapeImageUrl", "()Ljava/lang/String;", "linkUrl", "getLinkUrl", "name", "getName", "portraitImageUrl", "getPortraitImageUrl", "sequence", "", "getSequence", "()I", "version", "getVersion", "apply", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "", "callback", "Lcom/kakaogame/KGResultCallback;", "Companion", "KGPromotionApplyType", "KGPromotionType", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGPromotionData extends KGObject {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "KGPromotionData";
    private static Context context = null;
    private static final long serialVersionUID = -6946340748394741158L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<KGPromotionData> loadEndingPromotion() {
        return INSTANCE.loadEndingPromotion();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<List<KGPromotionData>> loadPromotions() {
        return INSTANCE.loadPromotions();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGPromotionData(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getSequence() {
        try {
            Number number = (Number) get(ServerConstants.SEQ);
            if (number != null) {
                return number.intValue();
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getVersion() {
        try {
            Number number = (Number) get("version");
            if (number != null) {
                return number.intValue();
            }
            return 3;
        } catch (Exception unused) {
            return 3;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getName() {
        return (String) get(y.ٲٴݴ״ٰ(1781623392));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getBeginTime() {
        try {
            Number number = (Number) get(KGKakaoInvitation.KGKakaoEvent.START_TIME);
            if (number != null) {
                return number.longValue();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getEndTime() {
        try {
            Number number = (Number) get("endTime");
            if (number != null) {
                return number.longValue();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLinkUrl() {
        return (String) get(y.ۮڭڭܬި(862661435));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPortraitImageUrl() {
        String str;
        if (getVersion() == 4) {
            JSONObject jSONObject = (JSONObject) get(y.ٴسسݬߨ(1393508586));
            if (jSONObject == null || (str = (String) jSONObject.get((Object) y.ݬֲ֮ܲت(1512466895))) == null) {
                return null;
            }
            return str;
        }
        return (String) get(y.ݬֲ֮ܲت(1512466751));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLandscapeImageUrl() {
        String str;
        if (getVersion() == 4) {
            JSONObject jSONObject = (JSONObject) get(y.ٴسسݬߨ(1393508586));
            if (jSONObject == null || (str = (String) jSONObject.get((Object) y.دײܮڳܯ(2051425149))) == null) {
                return null;
            }
            return str;
        }
        return (String) get(y.ݮڮֲڭܩ(-628394692));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGPromotionApplyType getApplyType() {
        KGPromotionApplyType kGPromotionApplyType;
        String str = (String) get(y.ݮڮֲڭܩ(-628394996));
        KGPromotionApplyType[] values = KGPromotionApplyType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                kGPromotionApplyType = null;
                break;
            }
            kGPromotionApplyType = values[i];
            if (StringsKt.equals(kGPromotionApplyType.getValue(), str, true)) {
                break;
            }
            i++;
        }
        return kGPromotionApplyType == null ? KGPromotionApplyType.NONE : kGPromotionApplyType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
    
        if (r1.isSuccess() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ae, code lost:
    
        r0.stop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b1, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009f, code lost:
    
        r1.setMessage(com.kakaogame.promotion.StartingPromotionManager.INSTANCE.getErrorMessage(com.kakaogame.promotion.KGPromotionData.context, r1.getCode()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
    
        if (r1.isSuccess() != false) goto L24;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Void> apply() {
        /*
            r6 = this;
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            r1 = 1512467463(0x5a266c07, float:1.1710906E16)
            java.lang.String r1 = com.liapp.y.ݬֲ֮ܲت(r1)
            r2 = 862661955(0x336b2d43, float:5.4756367E-8)
            java.lang.String r2 = com.liapp.y.ۮڭڭܬި(r2)
            r0.m699d(r2, r1)
            com.kakaogame.util.Stopwatch$Companion r0 = com.kakaogame.util.Stopwatch.INSTANCE
            r1 = 1512467535(0x5a266c4f, float:1.1710983E16)
            java.lang.String r1 = com.liapp.y.ݬֲ֮ܲت(r1)
            com.kakaogame.util.Stopwatch r0 = r0.start(r1)
            com.kakaogame.core.CoreManager$Companion r1 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            com.kakaogame.core.CoreManager r1 = r1.getInstance()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            boolean r1 = r1.isNotAuthorized()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            if (r1 == 0) goto L50
            com.kakaogame.KGResult$Companion r1 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            r3 = 3002(0xbba, float:4.207E-42)
            com.kakaogame.KGResult r1 = r1.getResult(r3)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r2 = r1.isSuccess()
            if (r2 != 0) goto L4c
            com.kakaogame.promotion.StartingPromotionManager r2 = com.kakaogame.promotion.StartingPromotionManager.INSTANCE
            android.content.Context r3 = com.kakaogame.promotion.KGPromotionData.context
            int r4 = r1.getCode()
            java.lang.String r2 = r2.getErrorMessage(r3, r4)
            r1.setMessage(r2)
        L4c:
            r0.stop()
            return r1
        L50:
            int r1 = r6.getVersion()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            r3 = 3
            if (r1 != r3) goto L60
            int r1 = r6.getSequence()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            com.kakaogame.KGResult r1 = com.kakaogame.promotion.PromotionService.applyPromotion(r1)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            goto L68
        L60:
            int r1 = r6.getSequence()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            com.kakaogame.KGResult r1 = com.kakaogame.promotion.PromotionService.clickPromotion(r1)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
        L68:
            com.kakaogame.KGResult$Companion r3 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            com.kakaogame.KGResult r1 = r3.getResult(r1)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> Lb2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r2 = r1.isSuccess()
            if (r2 != 0) goto Lae
            goto L9f
        L7a:
            r1 = move-exception
            com.kakaogame.Logger r3 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> Lb2
            r5 = r1
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch: java.lang.Throwable -> Lb2
            r3.m702e(r2, r4, r5)     // Catch: java.lang.Throwable -> Lb2
            com.kakaogame.KGResult$Companion r2 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb2
            r3 = 4001(0xfa1, float:5.607E-42)
            com.kakaogame.KGResult r1 = r2.getResult(r3, r1)     // Catch: java.lang.Throwable -> Lb2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2 = r1
            com.kakaogame.KGResult r2 = (com.kakaogame.KGResult) r2
            boolean r2 = r1.isSuccess()
            if (r2 != 0) goto Lae
        L9f:
            com.kakaogame.promotion.StartingPromotionManager r2 = com.kakaogame.promotion.StartingPromotionManager.INSTANCE
            android.content.Context r3 = com.kakaogame.promotion.KGPromotionData.context
            int r4 = r1.getCode()
            java.lang.String r2 = r2.getErrorMessage(r3, r4)
            r1.setMessage(r2)
        Lae:
            r0.stop()
            return r1
        Lb2:
            r0 = 0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1 = r0
            com.kakaogame.KGResult r1 = (com.kakaogame.KGResult) r1
            r0.isSuccess()
            throw r0
            fill-array 0x00be: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.promotion.KGPromotionData.apply():com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void apply(KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGPromotionData$apply$4(this, callback, null), 3, null);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGPromotionData.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/promotion/KGPromotionData$KGPromotionApplyType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "SHOW", "CLICK", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGPromotionApplyType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGPromotionApplyType[] $VALUES;
        public static final KGPromotionApplyType CLICK;
        public static final KGPromotionApplyType NONE;
        public static final KGPromotionApplyType SHOW;
        private final String value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGPromotionApplyType[] $values() {
            return new KGPromotionApplyType[]{NONE, SHOW, CLICK};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGPromotionApplyType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGPromotionApplyType valueOf(String str) {
            return (KGPromotionApplyType) Enum.valueOf(KGPromotionApplyType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGPromotionApplyType[] values() {
            return (KGPromotionApplyType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGPromotionApplyType(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            String str = y.ۮڭڭܬި(862123667);
            NONE = new KGPromotionApplyType(str, 0, str);
            String str2 = y.ٲٴݴ״ٰ(1782208944);
            SHOW = new KGPromotionApplyType(str2, 1, str2);
            String str3 = y.ٴسسݬߨ(1393510026);
            CLICK = new KGPromotionApplyType(str3, 2, str3);
            KGPromotionApplyType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGPromotionData.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/promotion/KGPromotionData$KGPromotionType;", "", "(Ljava/lang/String;I)V", "STARTING", "HIDDEN", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGPromotionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGPromotionType[] $VALUES;
        public static final KGPromotionType STARTING = new KGPromotionType(y.دײܮڳܯ(2051425661), 0);
        public static final KGPromotionType HIDDEN = new KGPromotionType(y.دײܮڳܯ(2051425581), 1);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGPromotionType[] $values() {
            return new KGPromotionType[]{STARTING, HIDDEN};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGPromotionType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGPromotionType valueOf(String str) {
            return (KGPromotionType) Enum.valueOf(KGPromotionType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGPromotionType[] values() {
            return (KGPromotionType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGPromotionType(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGPromotionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: KGPromotionData.kt */
    @Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0007J\u0016\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00100\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/promotion/KGPromotionData$Companion;", "", "()V", "TAG", "", "context", "Landroid/content/Context;", "serialVersionUID", "", "initialize", "", "ctx", "loadEndingPromotion", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/promotion/KGPromotionData;", "loadPromotions", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void initialize(Context ctx) {
            KGPromotionData.context = ctx;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final KGResult<List<KGPromotionData>> loadPromotions() {
            String str = y.ۮڭڭܬި(862661955);
            String str2 = y.ݬֲ֮ܲت(1512468327);
            Stopwatch start = Stopwatch.INSTANCE.start(y.ٴسسݬߨ(1393509770));
            try {
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    KGResult<List<KGPromotionData>> result = KGResult.INSTANCE.getResult(3002);
                    if (result != null && !result.isSuccess()) {
                        result.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, result.getCode()));
                    }
                    return result;
                }
                ArrayList arrayList = new ArrayList();
                KGResult<List<PromotionData>> popupPromotionsforV4 = PromotionService.getPopupPromotionsforV4(PromotionService.TYPE_OPENING);
                if (popupPromotionsforV4.isNotSuccess()) {
                    KGResult<List<KGPromotionData>> result2 = KGResult.INSTANCE.getResult(popupPromotionsforV4);
                    if (result2 != null && !result2.isSuccess()) {
                        result2.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, result2.getCode()));
                    }
                    return result2;
                }
                Logger.INSTANCE.m699d(str, str2 + popupPromotionsforV4);
                List<PromotionData> content = popupPromotionsforV4.getContent();
                Intrinsics.checkNotNull(content);
                Iterator<PromotionData> it = content.iterator();
                while (it.hasNext()) {
                    arrayList.add(new KGPromotionData(it.next()));
                }
                if (!InfodeskHelper.INSTANCE.offPromotion3()) {
                    KGResult<List<PromotionData>> startingPopupPromotions = PromotionService.getStartingPopupPromotions();
                    if (startingPopupPromotions.isNotSuccess()) {
                        KGResult<List<KGPromotionData>> result3 = KGResult.INSTANCE.getResult(startingPopupPromotions);
                        if (result3 != null && !result3.isSuccess()) {
                            result3.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, result3.getCode()));
                        }
                        return result3;
                    }
                    Logger.INSTANCE.m699d(str, "loadPromotions result: " + startingPopupPromotions);
                    List<PromotionData> content2 = startingPopupPromotions.getContent();
                    Intrinsics.checkNotNull(content2);
                    Iterator<PromotionData> it2 = content2.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new KGPromotionData(it2.next()));
                    }
                }
                KGResult<List<KGPromotionData>> successResult = KGResult.INSTANCE.getSuccessResult(arrayList);
                if (successResult != null && !successResult.isSuccess()) {
                    successResult.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, successResult.getCode()));
                }
                return successResult;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, e.toString(), e);
                KGResult<List<KGPromotionData>> result4 = KGResult.INSTANCE.getResult(4001, e.toString());
                if (result4 != null && !result4.isSuccess()) {
                    result4.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, result4.getCode()));
                }
                return result4;
            } finally {
                start.stop();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final KGResult<KGPromotionData> loadEndingPromotion() {
            Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1158736319));
            try {
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    KGResult<KGPromotionData> result = KGResult.INSTANCE.getResult(3002);
                    if (result != null && result.isNotSuccess()) {
                        result.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, result.getCode()));
                    }
                    return result;
                }
                KGResult<List<PromotionData>> popupPromotionsforV4 = PromotionService.getPopupPromotionsforV4(PromotionService.TYPE_ENDING);
                if (!popupPromotionsforV4.isSuccess()) {
                    KGResult<KGPromotionData> result2 = KGResult.INSTANCE.getResult(popupPromotionsforV4);
                    if (result2 != null && result2.isNotSuccess()) {
                        result2.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, result2.getCode()));
                    }
                    return result2;
                }
                List<PromotionData> content = popupPromotionsforV4.getContent();
                Intrinsics.checkNotNull(content);
                List<PromotionData> list = content;
                if (!list.isEmpty()) {
                    KGResult<KGPromotionData> successResult = KGResult.INSTANCE.getSuccessResult(new KGPromotionData(list.get(0)));
                    if (successResult != null && successResult.isNotSuccess()) {
                        successResult.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, successResult.getCode()));
                    }
                    return successResult;
                }
                if (InfodeskHelper.INSTANCE.offPromotion3()) {
                    KGResult<KGPromotionData> successResult2 = KGResult.INSTANCE.getSuccessResult(null);
                    if (successResult2 != null && successResult2.isNotSuccess()) {
                        successResult2.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, successResult2.getCode()));
                    }
                    return successResult2;
                }
                KGResult<PromotionData> endingPopupPromotion = PromotionService.getEndingPopupPromotion();
                if (!endingPopupPromotion.isSuccess()) {
                    KGResult<KGPromotionData> result3 = KGResult.INSTANCE.getResult(endingPopupPromotion);
                    if (result3 != null && result3.isNotSuccess()) {
                        result3.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, result3.getCode()));
                    }
                    return result3;
                }
                KGResult<KGPromotionData> successResult3 = KGResult.INSTANCE.getSuccessResult(new KGPromotionData(endingPopupPromotion.getContent()));
                if (successResult3 != null && successResult3.isNotSuccess()) {
                    successResult3.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, successResult3.getCode()));
                }
                return successResult3;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(KGPromotionData.TAG, e.toString(), e);
                KGResult<KGPromotionData> result4 = KGResult.INSTANCE.getResult(4001, e.toString());
                if (result4 != null && result4.isNotSuccess()) {
                    result4.setMessage(StartingPromotionManager.INSTANCE.getErrorMessage(KGPromotionData.context, result4.getCode()));
                }
                return result4;
            } finally {
                start.stop();
            }
        }
    }
}
