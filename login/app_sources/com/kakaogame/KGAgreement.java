package com.kakaogame;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.kakaogame.auth.agreement.AgreementService;
import com.kakaogame.core.CoreManager;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGAgreement.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J \u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\u0012\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0018\u0010\u0014\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m839d2 = {"Lcom/kakaogame/KGAgreement;", "", "()V", "PREF_AGREEMENT_NAME", "", "PREF_SEND_NAME", "SEND_FLAG_KEY", "TAG", "clearPreference", "", "context", "Landroid/content/Context;", "getAgreement", "", "", "Landroid/app/Activity;", "getSendFlag", "makeAgreement", "setAgreement", "agreementDic", "setSendFlag", "bool", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGAgreement {
    public static final KGAgreement INSTANCE = new KGAgreement();
    private static final String PREF_AGREEMENT_NAME = "AgreementData";
    private static final String PREF_SEND_NAME = "SendFlag";
    private static final String SEND_FLAG_KEY = "alreadySend";
    private static final String TAG = "KGAgreement";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGAgreement() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setAgreement(final Activity context, Map<String, Boolean> agreementDic) {
        Intrinsics.checkNotNullParameter(agreementDic, y.ݬֲ֮ܲت(1512616727));
        Logger.INSTANCE.m704i(y.ݮڮֲڭܩ(-628774332), y.٬ݯح׭٩(575823054) + agreementDic);
        if (context != null) {
            CoreManager.INSTANCE.getInstance().setActivityHolder(new Function0<Activity>() { // from class: com.kakaogame.KGAgreement$setAgreement$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Activity invoke() {
                    return context;
                }
            });
            for (Map.Entry<String, Boolean> entry : agreementDic.entrySet()) {
                PreferenceUtil.setBoolean(context, y.ٴسسݬߨ(1392615090), entry.getKey(), entry.getValue().booleanValue());
            }
            INSTANCE.setSendFlag(context, false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Map<String, Boolean> getAgreement(final Activity context) {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051578893);
        String str2 = y.ݮڮֲڭܩ(-628774332);
        logger.m704i(str2, str);
        if (context != null) {
            CoreManager.INSTANCE.getInstance().setActivityHolder(new Function0<Activity>() { // from class: com.kakaogame.KGAgreement$getAgreement$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Activity invoke() {
                    return context;
                }
            });
            SharedPreferences sharedPreferences = context.getSharedPreferences(y.ٴسسݬߨ(1392615090), 0);
            if (sharedPreferences == null) {
                Logger.INSTANCE.m708w(str2, y.ۮڭڭܬި(862320211));
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                Map<String, ?> all = sharedPreferences.getAll();
                if (all == null) {
                    return null;
                }
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Intrinsics.checkNotNull(key);
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                    linkedHashMap.put(key, (Boolean) value);
                }
                if (linkedHashMap.isEmpty()) {
                    return null;
                }
                return linkedHashMap;
            } catch (Exception e) {
                Log.e(str2, y.֬ڱܱײٮ(-1159609039) + e);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> makeAgreement(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051578093);
        String str2 = y.ݮڮֲڭܩ(-628774332);
        logger.m704i(str2, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SharedPreferences sharedPreferences = context.getSharedPreferences(y.ٴسسݬߨ(1392615090), 0);
        if (sharedPreferences == null) {
            Logger.INSTANCE.m708w(str2, y.ۮڭڭܬި(862320211));
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        try {
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                    if (((Boolean) value).booleanValue()) {
                        Intrinsics.checkNotNull(key);
                        linkedHashMap2.put(key, AgreementService.VALUE_YES);
                    } else {
                        Intrinsics.checkNotNull(key);
                        linkedHashMap2.put(key, AgreementService.VALUE_NO);
                    }
                }
            }
            linkedHashMap.put(y.ݬֲ֮ܲت(1512616079), new JSONObject(linkedHashMap2));
            return linkedHashMap;
        } catch (Exception e) {
            Log.e(str2, y.֬ڱܱײٮ(-1159609039) + e);
            return linkedHashMap;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setSendFlag(Context context, boolean bool) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512616183) + bool;
        String str2 = y.ݮڮֲڭܩ(-628774332);
        logger.m699d(str2, str);
        try {
            PreferenceUtil.setBoolean(context, PREF_SEND_NAME, SEND_FLAG_KEY, bool);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getSendFlag(Context context) {
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628774332), y.ٲٴݴ״ٰ(1781827176));
        return PreferenceUtil.getBoolean(context, y.ۮڭڭܬި(862319483), y.ݬֲ֮ܲت(1512616575), false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void clearPreference(Context context) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159610191);
        String str2 = y.ݮڮֲڭܩ(-628774332);
        logger.m699d(str2, str);
        try {
            PreferenceUtil.remove(context, PREF_AGREEMENT_NAME);
            PreferenceUtil.remove(context, PREF_SEND_NAME);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }
}
