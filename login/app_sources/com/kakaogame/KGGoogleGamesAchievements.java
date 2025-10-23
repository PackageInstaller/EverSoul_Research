package com.kakaogame;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGGoogleGamesAchievements.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0007J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/KGGoogleGamesAchievements;", "", "()V", "CLASS_NAME_KEY", "", "RC_ACHIEVEMENT_UI", "", "REQUEST_ACHIEVEMENTS", "TAG", "increment", "", "id", "numSteps", "initInterfaceBroker", "initialize", "reveal", "setSteps", "showAchievementView", "activity", "Landroid/app/Activity;", "unlock", "idp_googlegame_v2_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGGoogleGamesAchievements {
    private static final String CLASS_NAME_KEY = "KGGoogleGamesAchievements";
    public static final KGGoogleGamesAchievements INSTANCE = new KGGoogleGamesAchievements();
    private static final int RC_ACHIEVEMENT_UI = 9003;
    private static final int REQUEST_ACHIEVEMENTS = 111;
    private static final String TAG = "KGGoogleGamesAchievements";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGGoogleGamesAchievements() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void unlock(String id) {
        Intrinsics.checkNotNullParameter(id, y.ٲٴݴ״ٰ(1781792816));
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575853782) + id;
        String str2 = y.دײܮڳܯ(2051546589);
        logger.m704i(str2, str);
        try {
            if (KGSession.isLoggedIn()) {
                PlayGames.getAchievementsClient(CoreManager.INSTANCE.getInstance().getActivity()).unlock(id);
                FirebaseEvent.INSTANCE.sendEvent(str2, "unlock", KGResult.INSTANCE.getSuccessResult());
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void reveal(String id) {
        Intrinsics.checkNotNullParameter(id, y.ٲٴݴ״ٰ(1781792816));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1781794880) + id;
        String str2 = y.دײܮڳܯ(2051546589);
        logger.m704i(str2, str);
        try {
            if (KGSession.isLoggedIn()) {
                PlayGames.getAchievementsClient(CoreManager.INSTANCE.getInstance().getActivity()).reveal(id);
                FirebaseEvent.INSTANCE.sendEvent(str2, "reveal", KGResult.INSTANCE.getSuccessResult());
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void increment(String id, int numSteps) {
        Intrinsics.checkNotNullParameter(id, y.ٲٴݴ״ٰ(1781792816));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159642503) + id + y.ݮڮֲڭܩ(-628756788) + numSteps;
        String str2 = y.دײܮڳܯ(2051546589);
        logger.m704i(str2, str);
        try {
            if (KGSession.isLoggedIn()) {
                PlayGames.getAchievementsClient(CoreManager.INSTANCE.getInstance().getActivity()).increment(id, numSteps);
                FirebaseEvent.INSTANCE.sendEvent(str2, "increment", KGResult.INSTANCE.getSuccessResult());
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setSteps(String id, int numSteps) {
        Intrinsics.checkNotNullParameter(id, y.ٲٴݴ״ٰ(1781792816));
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392580602) + id + y.ݮڮֲڭܩ(-628756788) + numSteps;
        String str2 = y.دײܮڳܯ(2051546589);
        logger.m704i(str2, str);
        try {
            if (KGSession.isLoggedIn()) {
                PlayGames.getAchievementsClient(CoreManager.INSTANCE.getInstance().getActivity()).setSteps(id, numSteps);
                FirebaseEvent.INSTANCE.sendEvent(str2, "setSteps", KGResult.INSTANCE.getSuccessResult());
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showAchievementView(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051546589);
        String str2 = y.ۮڭڭܬި(862288179);
        logger.m704i(str, str2);
        try {
            if (KGSession.isLoggedIn()) {
                Task<Intent> achievementsIntent = PlayGames.getAchievementsClient(activity).getAchievementsIntent();
                final Function1<Intent, Unit> function1 = new Function1<Intent, Unit>() { // from class: com.kakaogame.KGGoogleGamesAchievements$showAchievementView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                        invoke2(intent);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Intent intent) {
                        activity.startActivityForResult(intent, 9003);
                    }
                };
                achievementsIntent.addOnSuccessListener(new OnSuccessListener() { // from class: com.kakaogame.KGGoogleGamesAchievements$$ExternalSyntheticLambda0
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        KGGoogleGamesAchievements.showAchievementView$lambda$0(Function1.this, obj);
                    }
                });
                FirebaseEvent.INSTANCE.sendEvent(str, str2, KGResult.INSTANCE.getSuccessResult());
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAchievementView$lambda$0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, y.ٲٴݴ״ٰ(1781796792));
        function1.invoke(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628806444), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGamesAchievements$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("id");
                if (str != null) {
                    KGGoogleGamesAchievements.unlock(str);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392581018), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGamesAchievements$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("id");
                if (str != null) {
                    KGGoogleGamesAchievements.reveal(str);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862286387), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGamesAchievements$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("id");
                Number number = (Number) request.getParameter(y.٬ݯح׭٩(575855334));
                Integer valueOf = number != null ? Integer.valueOf(number.intValue()) : null;
                if (str != null && valueOf != null) {
                    KGGoogleGamesAchievements.increment(str, valueOf.intValue());
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512587207), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGamesAchievements$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("id");
                Number number = (Number) request.getParameter(y.٬ݯح׭٩(575855334));
                Integer valueOf = number != null ? Integer.valueOf(number.intValue()) : null;
                if (str != null && valueOf != null) {
                    KGGoogleGamesAchievements.setSteps(str, valueOf.intValue());
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512586807), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGamesAchievements$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGGoogleGamesAchievements.showAchievementView(activity);
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
    }
}
