package com.kakaogame.core;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.geo.GeoService;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.TelephonyUtil;
import com.liapp.y;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: LocaleManager.kt */
@Metadata(m838d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J&\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"J(\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0012\u0010'\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0007J\b\u0010)\u001a\u00020\u0004H\u0002J\"\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040+2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0018\u0010-\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J \u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0+2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J*\u0010.\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u000101R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0011\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048\u0006@BX\u0087.¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u00062"}, m839d2 = {"Lcom/kakaogame/core/LocaleManager;", "", "()V", "KOREA_COUNTRY_CODE", "", "PREF_NAME", "TAG", "UNKNOWN_COUNTRY_CODE", "<set-?>", "countryCode", "getCountryCode", "()Ljava/lang/String;", "geoCountryCode", "getGeoCountryCode$annotations", "getGeoCountryCode", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "getLanguageCode", "prefName", "systemLanguageCode", "getSystemLanguageCode$annotations", "getSystemLanguageCode", "timeZoneOffset", "", "getTimeZoneOffset", "()J", "changeLocale", "", "context", "Landroid/content/Context;", "langCode", "playerId", "noDeviceLocale", "", "config", "Lcom/kakaogame/config/Configuration;", "getCountryImpl", "getFormattedLanguageCode", "getLanguageTag", "getSDKLanguageCode", "getValidCountryCode", "initialize", "loadSystemLanguageCode", "requestGeoCountryCode", "Lcom/kakaogame/KGResult;", "setLanguageCode", "setSystemLocale", "updateLanguageCode", "Ljava/lang/Void;", "callback", "Lcom/kakaogame/KGResultCallback;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LocaleManager {
    public static final LocaleManager INSTANCE = new LocaleManager();
    public static final String KOREA_COUNTRY_CODE = "kr";
    private static final String PREF_NAME = "Locale";
    private static final String TAG = "LocaleManager";
    public static final String UNKNOWN_COUNTRY_CODE = "zz";
    private static String countryCode;
    private static String geoCountryCode;
    private static String languageCode;
    private static String prefName;
    private static String systemLanguageCode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getGeoCountryCode$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getSystemLanguageCode$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LocaleManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getSystemLanguageCode() {
        String str = systemLanguageCode;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(y.ݬֲ֮ܲت(1512327871));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLanguageCode() {
        String str = languageCode;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(y.ݬֲ֮ܲت(1512397151));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCountryCode() {
        return countryCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getGeoCountryCode() {
        return geoCountryCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(final Context context, Configuration config) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        LocaleManager localeManager = INSTANCE;
        systemLanguageCode = localeManager.loadSystemLanguageCode();
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576628294) + getSystemLanguageCode();
        String str2 = y.ٴسسݬߨ(1393386834);
        logger.m704i(str2, str);
        String playerId = AuthDataManager.INSTANCE.getPlayerId();
        Logger.INSTANCE.m704i(str2, y.٬ݯح׭٩(576628502) + playerId);
        String str3 = y.دײܮڳܯ(2051301813) + config.getAppId() + '-' + config.getServerType();
        prefName = str3;
        String str4 = null;
        String str5 = y.ٲٴݴ״ٰ(1782086288);
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str5);
            str3 = null;
        }
        if (PreferenceUtil.contains(context, str3, playerId)) {
            String str6 = prefName;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str5);
            } else {
                str4 = str6;
            }
            String string = PreferenceUtil.getString(context, str4, playerId);
            if (string == null) {
                string = getSystemLanguageCode();
            }
            languageCode = string;
            localeManager.changeLocale(context, localeManager.getLanguageCode(), playerId);
        } else {
            languageCode = getSystemLanguageCode();
        }
        Logger.INSTANCE.m704i(str2, y.٬ݯح׭٩(576632894) + localeManager.getLanguageCode());
        CoreManager.INSTANCE.getInstance().addCoreStateListener(new CoreManager.CoreStateListener() { // from class: com.kakaogame.core.LocaleManager$initialize$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onConnect(String playerId2) {
                Intrinsics.checkNotNullParameter(playerId2, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogout(String playerId2) {
                Intrinsics.checkNotNullParameter(playerId2, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onPause() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onUnregister(String playerId2) {
                String str7;
                Intrinsics.checkNotNullParameter(playerId2, y.ݬֲ֮ܲت(1512589743));
                Context context2 = context;
                str7 = LocaleManager.prefName;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(y.ٲٴݴ״ٰ(1782086288));
                    str7 = null;
                }
                PreferenceUtil.removeKey(context2, str7, playerId2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogin(String playerId2) {
                String str7;
                Intrinsics.checkNotNullParameter(playerId2, y.ݬֲ֮ܲت(1512589743));
                Context context2 = context;
                str7 = LocaleManager.prefName;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(y.ٲٴݴ״ٰ(1782086288));
                    str7 = null;
                }
                String string2 = PreferenceUtil.getString(context2, str7, playerId2);
                String str8 = string2;
                if ((str8 == null || str8.length() == 0) || StringsKt.equals(string2, LocaleManager.INSTANCE.getLanguageCode(), true)) {
                    return;
                }
                LocaleManager.INSTANCE.updateLanguageCode(context, string2, new KGResultCallback<Void>() { // from class: com.kakaogame.core.LocaleManager$initialize$1$onLogin$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        Logger.INSTANCE.m704i(y.ٴسسݬߨ(1393386834), y.ݮڮֲڭܩ(-628535284) + result);
                    }
                });
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSDKLanguageCode() {
        if (languageCode != null) {
            return getLanguageCode();
        }
        return loadSystemLanguageCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setLanguageCode(Context context, String langCode) {
        String formattedLanguageCode;
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393386834), y.دײܮڳܯ(2051308805) + langCode);
        String str = langCode;
        if (str == null || str.length() == 0) {
            formattedLanguageCode = getSystemLanguageCode();
        } else {
            formattedLanguageCode = getFormattedLanguageCode(langCode);
        }
        languageCode = formattedLanguageCode;
        changeLocale(context, getLanguageCode(), CoreManager.INSTANCE.getInstance().getPlayerId());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLanguageTag() {
        String languageTag = Locale.getDefault().toLanguageTag();
        Logger.INSTANCE.m706v(y.ٴسسݬߨ(1393386834), y.دײܮڳܯ(2051309541) + languageTag);
        Intrinsics.checkNotNull(languageTag);
        return languageTag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String loadSystemLanguageCode() {
        String language = Locale.getDefault().getLanguage();
        Logger.INSTANCE.m706v(y.ٴسسݬߨ(1393386834), y.ݬֲ֮ܲت(1512331239) + language);
        return getFormattedLanguageCode(language);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getFormattedLanguageCode(String langCode) {
        if (TextUtils.isEmpty(langCode)) {
            return "";
        }
        Intrinsics.checkNotNull(langCode);
        String lowerCase = langCode.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
        if (Intrinsics.areEqual(lowerCase, y.ٲٴݴ״ٰ(1782148128)) || Intrinsics.areEqual(lowerCase, y.دײܮڳܯ(2051371469))) {
            return lowerCase;
        }
        if (lowerCase.length() > 2) {
            lowerCase = lowerCase.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(lowerCase, y.٬ݯح׭٩(576592158));
        }
        if (StringsKt.equals(y.֬ڱܱײٮ(-1158857455), lowerCase, true)) {
            lowerCase = "id";
        }
        if (StringsKt.equals(Locale.CHINESE.getLanguage(), lowerCase, true)) {
            return lowerCase + (StringsKt.equals(Locale.TRADITIONAL_CHINESE.getCountry(), Locale.getDefault().getCountry(), true) ? y.ݬֲ֮ܲت(1512328151) : y.دײܮڳܯ(2051302133));
        }
        return lowerCase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void changeLocale(Context context, String langCode, String playerId) {
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393386834), y.ٴسسݬߨ(1393386890) + langCode);
        String str = langCode;
        if (str == null || str.length() == 0) {
            return;
        }
        setSystemLocale(context, langCode);
        String str2 = prefName;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(y.ٲٴݴ״ٰ(1782086288));
            str2 = null;
        }
        PreferenceUtil.setString(context, str2, playerId, langCode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setSystemLocale(Context context, String langCode) {
        Locale locale = new Locale(langCode);
        boolean areEqual = Intrinsics.areEqual(langCode, y.ٲٴݴ״ٰ(1782148128));
        String str = y.٬ݯح׭٩(576698190);
        if (areEqual) {
            locale = new Locale(str, y.ٲٴݴ״ٰ(1782148232));
        }
        if (Intrinsics.areEqual(langCode, y.دײܮڳܯ(2051371469))) {
            locale = new Locale(str, "CN");
        }
        Locale.setDefault(locale);
        android.content.res.Configuration configuration = new android.content.res.Configuration();
        configuration.locale = locale;
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049 A[Catch: all -> 0x008d, Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:4:0x0038, B:6:0x003d, B:11:0x0049, B:12:0x004f, B:14:0x0065, B:18:0x007c), top: B:3:0x0038, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065 A[Catch: all -> 0x008d, Exception -> 0x008f, TRY_LEAVE, TryCatch #0 {Exception -> 0x008f, blocks: (B:4:0x0038, B:6:0x003d, B:11:0x0049, B:12:0x004f, B:14:0x0065, B:18:0x007c), top: B:3:0x0038, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c A[Catch: all -> 0x008d, Exception -> 0x008f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x008f, blocks: (B:4:0x0038, B:6:0x003d, B:11:0x0049, B:12:0x004f, B:14:0x0065, B:18:0x007c), top: B:3:0x0038, outer: #1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Void> updateLanguageCode(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 1512979991(0x5a2e3e17, float:1.2261229E16)
            java.lang.String r0 = com.liapp.y.ݬֲ֮ܲت(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = -1158863567(0xffffffffbaed2531, float:-0.0018092749)
            java.lang.String r2 = com.liapp.y.֬ڱܱײٮ(r2)
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r1 = r1.toString()
            r2 = 1393386834(0x530d6552, float:6.0729026E11)
            java.lang.String r2 = com.liapp.y.ٴسسݬߨ(r2)
            r0.m699d(r2, r1)
            com.kakaogame.util.Stopwatch$Companion r0 = com.kakaogame.util.Stopwatch.INSTANCE
            r1 = 862523779(0x33691183, float:5.4265467E-8)
            java.lang.String r1 = com.liapp.y.ۮڭڭܬި(r1)
            com.kakaogame.util.Stopwatch r0 = r0.start(r1)
            r1 = 0
            r3 = r7
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            if (r3 == 0) goto L46
            int r3 = r3.length()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            if (r3 != 0) goto L44
            goto L46
        L44:
            r3 = 0
            goto L47
        L46:
            r3 = 1
        L47:
            if (r3 == 0) goto L4f
            com.kakaogame.KGResult$Companion r3 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            com.kakaogame.KGResult r1 = r3.getSuccessResult()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
        L4f:
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3.<init>()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            java.util.Map r3 = (java.util.Map) r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            java.lang.String r4 = "lang"
            r3.put(r4, r7)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            com.kakaogame.KGResult r3 = com.kakaogame.player.LocalPlayerService.updatePlayer(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            boolean r4 = r3.isNotSuccess()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            if (r4 == 0) goto L7c
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            java.util.Map r3 = (java.util.Map) r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            com.kakaogame.KGResult r6 = r6.getResult(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r0.stop()
            java.lang.String r7 = r0.getName()
            long r0 = r0.getDurationMs()
            com.kakaogame.log.APILogManager.writeClientApiCall(r7, r6, r0)
            return r6
        L7c:
            r5.setLanguageCode(r6, r7)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            com.kakaogame.KGResult r6 = r6.getSuccessResult()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r0.stop()
            java.lang.String r7 = r0.getName()
            goto Lb2
        L8d:
            r6 = move-exception
            goto Lba
        L8f:
            r6 = move-exception
            com.kakaogame.Logger r7 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L8d
            r4 = r6
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch: java.lang.Throwable -> L8d
            r7.m702e(r2, r3, r4)     // Catch: java.lang.Throwable -> L8d
            com.kakaogame.KGResult$Companion r7 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L8d
            r2 = 4001(0xfa1, float:5.607E-42)
            com.kakaogame.KGResult r6 = r7.getResult(r2, r6)     // Catch: java.lang.Throwable -> L8d
            r0.stop()
            java.lang.String r7 = r0.getName()
            r1 = r6
            com.kakaogame.KGResult r1 = (com.kakaogame.KGResult) r1
        Lb2:
            long r0 = r0.getDurationMs()
            com.kakaogame.log.APILogManager.writeClientApiCall(r7, r6, r0)
            return r6
        Lba:
            r0.stop()
            java.lang.String r7 = r0.getName()
            r2 = r1
            com.kakaogame.KGResult r2 = (com.kakaogame.KGResult) r2
            long r2 = r0.getDurationMs()
            com.kakaogame.log.APILogManager.writeClientApiCall(r7, r1, r2)
            throw r6
            fill-array 0x00cc: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.core.LocaleManager.updateLanguageCode(android.content.Context, java.lang.String):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void updateLanguageCode(Context context, String languageCode2, KGResultCallback<Void> callback) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LocaleManager$updateLanguageCode$5(context, languageCode2, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getGeoCountryCode(Context context) {
        String str = geoCountryCode;
        if (str == null || str.length() == 0) {
            geoCountryCode = PreferenceUtil.getString(context, y.دײܮڳܯ(2051362333), y.ٲٴݴ״ٰ(1782087592));
        }
        return geoCountryCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> requestGeoCountryCode(Context context, Configuration config) {
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        KGResult<String> requestGeoCountry = GeoService.requestGeoCountry(config);
        if (requestGeoCountry.isSuccess()) {
            String validCountryCode = INSTANCE.getValidCountryCode(requestGeoCountry.getContent());
            geoCountryCode = validCountryCode;
            String str = validCountryCode;
            if (!(str == null || str.length() == 0)) {
                String str2 = geoCountryCode;
                Intrinsics.checkNotNull(str2);
                PreferenceUtil.setString(context, y.دײܮڳܯ(2051362333), y.ٲٴݴ״ٰ(1782087592), str2);
            }
        }
        return requestGeoCountry;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ String getCountryCode$default(LocaleManager localeManager, Context context, boolean z, Configuration configuration, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            configuration = null;
        }
        return localeManager.getCountryCode(context, z, configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCountryCode(Context context, boolean noDeviceLocale, Configuration config) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        String str = y.دײܮڳܯ(2051362333);
        String str2 = y.دײܮڳܯ(2051393733);
        String string = PreferenceUtil.getString(context, str, str2);
        String str3 = string;
        if (!(str3 == null || str3.length() == 0)) {
            countryCode = string;
            return string;
        }
        String countryImpl = getCountryImpl(context, noDeviceLocale, config);
        if (countryImpl == null) {
            return null;
        }
        countryCode = countryImpl;
        PreferenceUtil.setString(context, str, str2, countryImpl);
        return countryCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getValidCountryCode(String countryCode2) {
        String str = countryCode2;
        boolean z = false;
        boolean z2 = str == null || str.length() == 0;
        String str2 = y.ٴسسݬߨ(1393410370);
        if (!z2) {
            String[] iSOCountries = Locale.getISOCountries();
            Intrinsics.checkNotNullExpressionValue(iSOCountries, y.٬ݯح׭٩(576628214));
            String[] strArr = iSOCountries;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (StringsKt.equals(strArr[i], countryCode2, true)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return countryCode2;
            }
        }
        return str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ String getCountryImpl$default(LocaleManager localeManager, Context context, boolean z, Configuration configuration, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return localeManager.getCountryImpl(context, z, configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getCountryImpl(Context context, boolean noDeviceLocale, Configuration config) {
        String validCountryCode = getValidCountryCode(TelephonyUtil.getSimCountryIso(context));
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512328655) + validCountryCode;
        String str2 = y.ٴسسݬߨ(1393386834);
        logger.m699d(str2, str);
        String str3 = y.ٴسسݬߨ(1393410370);
        boolean z = true;
        boolean equals = StringsKt.equals(str3, validCountryCode, true);
        String str4 = y.ݮڮֲڭܩ(-628797244);
        if (equals) {
            String str5 = geoCountryCode;
            if (str5 != null && !StringsKt.equals(str5, str3, true)) {
                return geoCountryCode;
            }
            KGResult<String> requestCountry = config == null ? GeoService.requestCountry() : GeoService.requestGeoCountry(config);
            if (requestCountry.isSuccess()) {
                String content = requestCountry.getContent();
                String str6 = content;
                if (!(str6 == null || str6.length() == 0) && !StringsKt.equals(getValidCountryCode(content), str3, true)) {
                    String lowerCase = content.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, str4);
                    Logger.INSTANCE.m699d(str2, y.ٲٴݴ״ٰ(1782086128) + lowerCase);
                    return lowerCase;
                }
            }
            if (noDeviceLocale && (requestCountry.getCode() == 1001 || requestCountry.getCode() == 2001)) {
                return null;
            }
            String country = Resources.getSystem().getConfiguration().getLocales().get(0).getCountry();
            Logger.INSTANCE.m699d(str2, y.ݬֲ֮ܲت(1512328223) + country);
            String str7 = country;
            if (str7 != null && str7.length() != 0) {
                z = false;
            }
            if (z) {
                return str3;
            }
            Intrinsics.checkNotNull(country);
            String lowerCase2 = country.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, str4);
            return lowerCase2;
        }
        String lowerCase3 = validCountryCode.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, str4);
        return lowerCase3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getTimeZoneOffset() {
        if (TimeZone.getDefault() == null) {
            return 0L;
        }
        long rawOffset = TimeZone.getDefault().getRawOffset();
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393386834), y.֬ڱܱײٮ(-1158863887) + rawOffset);
        return rawOffset;
    }
}
