package com.kakaogame;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakao.sdk.common.Constants;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.log.PlayerLogManager;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGPlayerGameData.kt */
@Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR(\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/KGPlayerGameData;", "", "()V", PlayerLogManager.KEY_COHORT1, "", "getCohort1", "()Ljava/lang/String;", "setCohort1", "(Ljava/lang/String;)V", PlayerLogManager.KEY_COHORT2, "getCohort2", "setCohort2", PlayerLogManager.KEY_COHORT3, "getCohort3", "setCohort3", PlayerLogManager.KEY_COHORT4, "getCohort4", "setCohort4", PlayerLogManager.KEY_COHORT5, "getCohort5", "setCohort5", PlayerLogManager.KEY_GRADE, "", "getGrade", "()I", "setGrade", "(I)V", FirebaseAnalytics.Param.LEVEL, "getLevel", "setLevel", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGPlayerGameData {
    private static final String TAG = "PlayerGameData";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KGPlayerGameData instance = new KGPlayerGameData();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGPlayerGameData() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getLevel() {
        try {
            Object playerGameData = PlayerLogManager.getPlayerGameData(PlayerLogManager.KEY_PLAYER_LEVEL);
            if (playerGameData instanceof Integer) {
                return ((Number) playerGameData).intValue();
            }
            return 0;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628645364), e.toString(), e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setLevel(int i) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159476143) + i;
        String str2 = y.ݮڮֲڭܩ(-628645364);
        logger.m699d(str2, str);
        try {
            PlayerLogManager.setPlayerGameData(PlayerLogManager.KEY_PLAYER_LEVEL, i);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getGrade() {
        try {
            Object playerGameData = PlayerLogManager.getPlayerGameData(PlayerLogManager.KEY_GRADE);
            if (playerGameData instanceof Integer) {
                return ((Number) playerGameData).intValue();
            }
            return 0;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628645364), e.toString(), e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setGrade(int i) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159476175) + i;
        String str2 = y.ݮڮֲڭܩ(-628645364);
        logger.m699d(str2, str);
        try {
            PlayerLogManager.setPlayerGameData(PlayerLogManager.KEY_GRADE, i);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCohort1() {
        try {
            Object playerGameData = PlayerLogManager.getPlayerGameData(PlayerLogManager.KEY_COHORT1);
            if (playerGameData instanceof String) {
                return (String) playerGameData;
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628645364), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCohort1(String str) {
        Logger logger = Logger.INSTANCE;
        String str2 = y.٬ݯح׭٩(575689454) + str;
        String str3 = y.ݮڮֲڭܩ(-628645364);
        logger.m699d(str3, str2);
        try {
            PlayerLogManager.setPlayerGameData(PlayerLogManager.KEY_COHORT1, str);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCohort2() {
        try {
            Object playerGameData = PlayerLogManager.getPlayerGameData(PlayerLogManager.KEY_COHORT2);
            if (playerGameData instanceof String) {
                return (String) playerGameData;
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628645364), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCohort2(String str) {
        Logger logger = Logger.INSTANCE;
        String str2 = y.ۮڭڭܬި(862453371) + str;
        String str3 = y.ݮڮֲڭܩ(-628645364);
        logger.m699d(str3, str2);
        try {
            PlayerLogManager.setPlayerGameData(PlayerLogManager.KEY_COHORT2, str);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCohort3() {
        try {
            Object playerGameData = PlayerLogManager.getPlayerGameData(PlayerLogManager.KEY_COHORT3);
            if (playerGameData instanceof String) {
                return (String) playerGameData;
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628645364), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCohort3(String str) {
        Logger logger = Logger.INSTANCE;
        String str2 = y.ۮڭڭܬި(862453387) + str;
        String str3 = y.ݮڮֲڭܩ(-628645364);
        logger.m699d(str3, str2);
        try {
            PlayerLogManager.setPlayerGameData(PlayerLogManager.KEY_COHORT3, str);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCohort4() {
        try {
            Object playerGameData = PlayerLogManager.getPlayerGameData(PlayerLogManager.KEY_COHORT4);
            if (playerGameData instanceof String) {
                return (String) playerGameData;
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628645364), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCohort4(String str) {
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݬֲ֮ܲت(1512750007) + str;
        String str3 = y.ݮڮֲڭܩ(-628645364);
        logger.m699d(str3, str2);
        try {
            PlayerLogManager.setPlayerGameData(PlayerLogManager.KEY_COHORT4, str);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCohort5() {
        try {
            Object playerGameData = PlayerLogManager.getPlayerGameData(PlayerLogManager.KEY_COHORT5);
            if (playerGameData instanceof String) {
                return (String) playerGameData;
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628645364), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCohort5(String str) {
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݬֲ֮ܲت(1512749831) + str;
        String str3 = y.ݮڮֲڭܩ(-628645364);
        logger.m699d(str3, str2);
        try {
            PlayerLogManager.setPlayerGameData(PlayerLogManager.KEY_COHORT5, str);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
        }
    }

    /* compiled from: KGPlayerGameData.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/KGPlayerGameData$Companion;", "", "()V", "TAG", "", "instance", "Lcom/kakaogame/KGPlayerGameData;", Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakaogame/KGPlayerGameData;", "initInterfaceBroker", "", "initialize", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGPlayerGameData getInstance() {
            return KGPlayerGameData.instance;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051704125), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Number number = (Number) request.getParameter(FirebaseAnalytics.Param.LEVEL);
                    Intrinsics.checkNotNull(number);
                    KGPlayerGameData.INSTANCE.getInstance().setLevel(number.intValue());
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512745935), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Number number = (Number) request.getParameter(PlayerLogManager.KEY_GRADE);
                    Intrinsics.checkNotNull(number);
                    KGPlayerGameData.INSTANCE.getInstance().setGrade(number.intValue());
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575685998), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGPlayerGameData.INSTANCE.getInstance().setCohort1((String) request.getParameter("cohort"));
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159471287), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGPlayerGameData.INSTANCE.getInstance().setCohort2((String) request.getParameter("cohort"));
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781963928), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGPlayerGameData.INSTANCE.getInstance().setCohort3((String) request.getParameter("cohort"));
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781957552), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$6
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGPlayerGameData.INSTANCE.getInstance().setCohort4((String) request.getParameter("cohort"));
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575691150), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$7
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGPlayerGameData.INSTANCE.getInstance().setCohort5((String) request.getParameter("cohort"));
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392746122), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$8
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    int level = KGPlayerGameData.INSTANCE.getInstance().getLevel();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ݮڮֲڭܩ(-628641140), Integer.valueOf(level));
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392746370), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$9
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    int grade = KGPlayerGameData.INSTANCE.getInstance().getGrade();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ٴسسݬߨ(1392740170), Integer.valueOf(grade));
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051709589), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$10
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    String cohort1 = KGPlayerGameData.INSTANCE.getInstance().getCohort1();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ݮڮֲڭܩ(-628641076), cohort1);
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628642388), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$11
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    String cohort2 = KGPlayerGameData.INSTANCE.getInstance().getCohort2();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ݮڮֲڭܩ(-628641076), cohort2);
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512747151), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$12
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    String cohort3 = KGPlayerGameData.INSTANCE.getInstance().getCohort3();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ݮڮֲڭܩ(-628641076), cohort3);
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392743538), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$13
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    String cohort4 = KGPlayerGameData.INSTANCE.getInstance().getCohort4();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ݮڮֲڭܩ(-628641076), cohort4);
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392743706), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPlayerGameData$Companion$initInterfaceBroker$14
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    String cohort5 = KGPlayerGameData.INSTANCE.getInstance().getCohort5();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ݮڮֲڭܩ(-628641076), cohort5);
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
            });
        }
    }
}
