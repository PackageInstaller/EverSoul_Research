package com.kakaogame;

import android.app.Activity;
import com.google.android.gms.games.PlayGames;
import com.kakaogame.KGGoogleGamesLeaderboards;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGGoogleGamesLeaderboards.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007J\"\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m839d2 = {"Lcom/kakaogame/KGGoogleGamesLeaderboards;", "", "()V", "CLASS_NAME_KEY", "", "RC_LEADERBOARD_UI", "", "REQUEST_LEADERBOARD", "TAG", "initInterfaceBroker", "", "initialize", "showLeaderboardView", "activity", "Landroid/app/Activity;", "id", "timeSpan", "Lcom/kakaogame/KGGoogleGamesLeaderboards$KGTimeSpan;", "submitScore", "score", "", "tag", "KGTimeSpan", "idp_googlegame_v2_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGGoogleGamesLeaderboards {
    private static final String CLASS_NAME_KEY = "KGGoogleGamesLeaderboards";
    public static final KGGoogleGamesLeaderboards INSTANCE = new KGGoogleGamesLeaderboards();
    private static final int RC_LEADERBOARD_UI = 9004;
    private static final int REQUEST_LEADERBOARD = 112;
    private static final String TAG = "KGGoogleGamesLeaderboards";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGGoogleGamesLeaderboards() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void submitScore(String id, long score, String tag) {
        Intrinsics.checkNotNullParameter(id, y.ٲٴݴ״ٰ(1781792816));
        Intrinsics.checkNotNullParameter(tag, y.ٲٴݴ״ٰ(1781796128));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159645911) + id + y.دײܮڳܯ(2051566333) + score;
        String str2 = y.ۮڭڭܬި(862258315);
        logger.m704i(str2, str);
        try {
            if (KGSession.isLoggedIn()) {
                PlayGames.getLeaderboardsClient(CoreManager.INSTANCE.getInstance().getActivity()).submitScore(id, score, tag);
                FirebaseEvent.INSTANCE.sendEvent(str2, "submitScore", KGResult.INSTANCE.getSuccessResult());
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:3:0x0027, B:7:0x002e, B:9:0x003c, B:14:0x0048, B:15:0x0070, B:18:0x0052, B:21:0x005d, B:22:0x0069), top: B:2:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052 A[Catch: Exception -> 0x008b, TRY_LEAVE, TryCatch #0 {Exception -> 0x008b, blocks: (B:3:0x0027, B:7:0x002e, B:9:0x003c, B:14:0x0048, B:15:0x0070, B:18:0x0052, B:21:0x005d, B:22:0x0069), top: B:2:0x0027 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showLeaderboardView(final android.app.Activity r5, java.lang.String r6, com.kakaogame.KGGoogleGamesLeaderboards.KGTimeSpan r7) {
        /*
            r0 = -1159305015(0xffffffffbae668c9, float:-0.0017578836)
            java.lang.String r0 = com.liapp.y.֬ڱܱײٮ(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 2051543085(0x7a48102d, float:2.5969686E35)
            java.lang.String r0 = com.liapp.y.دײܮڳܯ(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            r1 = 862258315(0x3365048b, float:5.332235E-8)
            java.lang.String r1 = com.liapp.y.ۮڭڭܬި(r1)
            r2 = 1512588559(0x5a28450f, float:1.1840932E16)
            java.lang.String r2 = com.liapp.y.ݬֲ֮ܲت(r2)
            r0.m704i(r1, r2)
            boolean r0 = com.kakaogame.KGSession.isLoggedIn()     // Catch: java.lang.Exception -> L8b
            if (r0 != 0) goto L2e
            return
        L2e:
            com.google.android.gms.games.LeaderboardsClient r0 = com.google.android.gms.games.PlayGames.getLeaderboardsClient(r5)     // Catch: java.lang.Exception -> L8b
            java.lang.String r3 = "getLeaderboardsClient(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: java.lang.Exception -> L8b
            r3 = r6
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> L8b
            if (r3 == 0) goto L45
            int r3 = r3.length()     // Catch: java.lang.Exception -> L8b
            if (r3 != 0) goto L43
            goto L45
        L43:
            r3 = 0
            goto L46
        L45:
            r3 = 1
        L46:
            if (r3 == 0) goto L52
            com.google.android.gms.tasks.Task r6 = r0.getAllLeaderboardsIntent()     // Catch: java.lang.Exception -> L8b
            java.lang.String r7 = "getAllLeaderboardsIntent(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch: java.lang.Exception -> L8b
            goto L70
        L52:
            com.kakaogame.KGGoogleGamesLeaderboards$KGTimeSpan r3 = com.kakaogame.KGGoogleGamesLeaderboards.KGTimeSpan.NONE     // Catch: java.lang.Exception -> L8b
            r4 = 1392602978(0x53016f62, float:5.559195E11)
            java.lang.String r4 = com.liapp.y.ٴسسݬߨ(r4)
            if (r7 == r3) goto L69
            int r7 = r7.get()     // Catch: java.lang.Exception -> L8b
            com.google.android.gms.tasks.Task r6 = r0.getLeaderboardIntent(r6, r7)     // Catch: java.lang.Exception -> L8b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)     // Catch: java.lang.Exception -> L8b
            goto L70
        L69:
            com.google.android.gms.tasks.Task r6 = r0.getLeaderboardIntent(r6)     // Catch: java.lang.Exception -> L8b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)     // Catch: java.lang.Exception -> L8b
        L70:
            com.kakaogame.KGGoogleGamesLeaderboards$showLeaderboardView$1 r7 = new com.kakaogame.KGGoogleGamesLeaderboards$showLeaderboardView$1     // Catch: java.lang.Exception -> L8b
            r7.<init>()     // Catch: java.lang.Exception -> L8b
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7     // Catch: java.lang.Exception -> L8b
            com.kakaogame.KGGoogleGamesLeaderboards$$ExternalSyntheticLambda0 r5 = new com.kakaogame.KGGoogleGamesLeaderboards$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L8b
            r5.<init>()     // Catch: java.lang.Exception -> L8b
            r6.addOnSuccessListener(r5)     // Catch: java.lang.Exception -> L8b
            com.kakaogame.log.FirebaseEvent$Companion r5 = com.kakaogame.log.FirebaseEvent.INSTANCE     // Catch: java.lang.Exception -> L8b
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> L8b
            com.kakaogame.KGResult r6 = r6.getSuccessResult()     // Catch: java.lang.Exception -> L8b
            r5.sendEvent(r1, r2, r6)     // Catch: java.lang.Exception -> L8b
            goto L97
        L8b:
            r5 = move-exception
            com.kakaogame.Logger r6 = com.kakaogame.Logger.INSTANCE
            java.lang.String r7 = r5.toString()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.m702e(r1, r7, r5)
        L97:
            return
            fill-array 0x0098: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGGoogleGamesLeaderboards.showLeaderboardView(android.app.Activity, java.lang.String, com.kakaogame.KGGoogleGamesLeaderboards$KGTimeSpan):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showLeaderboardView$lambda$0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, y.ٲٴݴ״ٰ(1781796792));
        function1.invoke(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781796280), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGamesLeaderboards$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("id");
                Number number = (Number) request.getParameter(y.ٴسسݬߨ(1392578978));
                Long valueOf = number != null ? Long.valueOf(number.longValue()) : null;
                String str2 = (String) request.getParameter(y.ٲٴݴ״ٰ(1781796128));
                if (str != null && valueOf != null && str2 != null) {
                    KGGoogleGamesLeaderboards.submitScore(str, valueOf.longValue(), str2);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862258467), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGamesLeaderboards$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = (String) request.getParameter(y.ٲٴݴ״ٰ(1781792816));
                Number number = (Number) request.getParameter(y.دײܮڳܯ(2051543085));
                KGGoogleGamesLeaderboards.KGTimeSpan kGTimeSpan = KGGoogleGamesLeaderboards.KGTimeSpan.INSTANCE.get(number != null ? Integer.valueOf(number.intValue()) : null);
                if (str != null) {
                    KGGoogleGamesLeaderboards.showLeaderboardView(activity, str, kGTimeSpan);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGGoogleGamesLeaderboards.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/KGGoogleGamesLeaderboards$KGTimeSpan;", "", "span", "", "(Ljava/lang/String;II)V", "getSpan", "()I", "setSpan", "(I)V", "get", "NONE", "DAILY", "WEEKLY", "ALL_TIME", "Companion", "idp_googlegame_v2_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGTimeSpan {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGTimeSpan[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private int span;
        public static final KGTimeSpan NONE = new KGTimeSpan(y.ۮڭڭܬި(862123667), 0, -1);
        public static final KGTimeSpan DAILY = new KGTimeSpan(y.ٴسسݬߨ(1392578922), 1, 0);
        public static final KGTimeSpan WEEKLY = new KGTimeSpan(y.ٲٴݴ״ٰ(1781796472), 2, 1);
        public static final KGTimeSpan ALL_TIME = new KGTimeSpan(y.ٴسسݬߨ(1392579058), 3, 2);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGTimeSpan[] $values() {
            return new KGTimeSpan[]{NONE, DAILY, WEEKLY, ALL_TIME};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGTimeSpan> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGTimeSpan valueOf(String str) {
            return (KGTimeSpan) Enum.valueOf(KGTimeSpan.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGTimeSpan[] values() {
            return (KGTimeSpan[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGTimeSpan(String str, int i, int i2) {
            this.span = i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getSpan() {
            return this.span;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setSpan(int i) {
            this.span = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGTimeSpan[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int get() {
            return this.span;
        }

        /* compiled from: KGGoogleGamesLeaderboards.kt */
        @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/KGGoogleGamesLeaderboards$KGTimeSpan$Companion;", "", "()V", "get", "Lcom/kakaogame/KGGoogleGamesLeaderboards$KGTimeSpan;", "span", "", "(Ljava/lang/Integer;)Lcom/kakaogame/KGGoogleGamesLeaderboards$KGTimeSpan;", "idp_googlegame_v2_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGTimeSpan get(Integer span) {
                if (span == null) {
                    return KGTimeSpan.NONE;
                }
                return span.intValue() == 0 ? KGTimeSpan.DAILY : span.intValue() == 1 ? KGTimeSpan.WEEKLY : span.intValue() == 2 ? KGTimeSpan.ALL_TIME : KGTimeSpan.NONE;
            }
        }
    }
}
