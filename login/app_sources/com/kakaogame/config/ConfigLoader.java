package com.kakaogame.config;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;
import com.kakaogame.KGResult;
import com.kakaogame.server.ServerInfo;
import com.liapp.y;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConfigLoader.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/config/ConfigLoader;", "", "()V", "CONFIG_FILENAME", "", "TAG", "checkMandatoryItems", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "config", "Lcom/kakaogame/config/Configuration;", "getServerInfo", "Lcom/kakaogame/server/ServerInfo;", Configuration.KEY_SERVER_TYPE, "loadConfiguration", "activity", "Landroid/app/Activity;", "appId", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ConfigLoader {
    private static final String CONFIG_FILENAME = "kakao_game_sdk_configuration.xml";
    public static final ConfigLoader INSTANCE = new ConfigLoader();
    private static final String TAG = "ConfigLoader";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConfigLoader() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.kakaogame.KGResult] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.kakaogame.KGResult<com.kakaogame.config.Configuration>] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<com.kakaogame.config.Configuration> loadConfiguration(final android.app.Activity r16, java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.config.ConfigLoader.loadConfiguration(android.app.Activity, java.lang.String):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loadConfiguration$lambda$0(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576589622));
        Toast makeText = Toast.makeText(activity, y.֬ڱܱײٮ(-1158834591) + str, 1);
        makeText.setGravity(49, 0, 0);
        y.٬خݮ۳ݯ();
        makeText.show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerInfo getServerInfo(String serverType) {
        String str = y.֬ڱܱײٮ(-1158820255);
        if (StringsKt.equals(str, serverType, true)) {
            return new ServerInfo(str, y.ٲٴݴ״ٰ(1782116672), y.دײܮڳܯ(2051314149), y.ٴسسݬߨ(1393421490));
        }
        String str2 = y.ݬֲ֮ܲت(1512359007);
        if (StringsKt.equals(str2, serverType, true)) {
            return new ServerInfo(str2, y.ۮڭڭܬި(862553003), y.دײܮڳܯ(2051336829), y.٬ݯح׭٩(576597374));
        }
        String str3 = y.دײܮڳܯ(2051336581);
        if (StringsKt.equals(str3, serverType, true)) {
            return new ServerInfo(str3, y.ٲٴݴ״ٰ(1782120088), y.ݬֲ֮ܲت(1512361967), y.ٲٴݴ״ٰ(1782118888));
        }
        String str4 = y.دײܮڳܯ(2051341917);
        if (StringsKt.equals(str4, serverType, true)) {
            return new ServerInfo(str4, y.ٴسسݬߨ(1393426234), y.ٴسسݬߨ(1393425610), y.ۮڭڭܬި(862557379));
        }
        String str5 = y.ݮڮֲڭܩ(-628503412);
        if (StringsKt.equals(str5, serverType, true)) {
            return new ServerInfo(str5, y.ݬֲ֮ܲت(1512362095), y.֬ڱܱײٮ(-1158831095), y.ݬֲ֮ܲت(1512362263));
        }
        String str6 = y.ݬֲ֮ܲت(1512365823);
        if (StringsKt.equals(str6, serverType, true)) {
            return new ServerInfo(str6, y.ݬֲ֮ܲت(1512364999), y.ۮڭڭܬި(862559483), y.ۮڭڭܬި(862559803));
        }
        if (serverType != null) {
            String lowerCase = serverType.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
            String str7 = y.ٴسسݬߨ(1393422826);
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str7, false, 2, (Object) null)) {
                return new ServerInfo(str7, y.٬ݯح׭٩(576587862), y.ٲٴݴ״ٰ(1782116032), y.֬ڱܱײٮ(-1158828503));
            }
        }
        return new ServerInfo(y.ٴسسݬߨ(1393412162), y.ݬֲ֮ܲت(1512367063), y.٬ݯح׭٩(576588174), y.ٴسسݬߨ(1393413818));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> checkMandatoryItems(Configuration config) {
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{y.ۮڭڭܬި(862411867), y.ۮڭڭܬި(862506555), y.٬ݯح׭٩(576607038), y.دײܮڳܯ(2051758173)});
        for (String str : listOf) {
            if (!config.containsKey(str)) {
                return KGResult.INSTANCE.getResult(4000, listOf + y.֬ڱܱײٮ(-1158821295));
            }
            if (TextUtils.isEmpty((String) config.get(str))) {
                return KGResult.INSTANCE.getResult(4000, listOf + y.ۮڭڭܬި(862582907));
            }
        }
        return KGResult.INSTANCE.getSuccessResult();
    }
}
