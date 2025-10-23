package com.facebook.appevents.integrity;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.kakaogame.game.StringSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MACARuleMatchingManager.kt */
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, m839d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "()V", "MACARules", "Lorg/json/JSONArray;", StringSet.enabled, "", UserMetadata.KEYDATA_FILENAME, "", "", "[Ljava/lang/String;", "enable", "", "generateInfo", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", NotificationCompat.CATEGORY_EVENT, "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", "variable", "values", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {NotificationCompat.CATEGORY_EVENT, "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MACARuleMatchingManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings == null) {
                return;
            }
            MACARules = queryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> keys2 = logic.keys();
            if (keys2.hasNext()) {
                return keys2.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02bc A[Catch: all -> 0x03f9, TryCatch #0 {all -> 0x03f9, blocks: (B:6:0x000a, B:9:0x001b, B:13:0x003f, B:15:0x0037, B:24:0x0065, B:25:0x006d, B:28:0x007a, B:32:0x0084, B:34:0x008a, B:36:0x0095, B:38:0x00a4, B:39:0x00a9, B:40:0x00aa, B:41:0x00af, B:42:0x00b0, B:46:0x00ba, B:52:0x00ca, B:58:0x0260, B:60:0x0266, B:63:0x0270, B:64:0x0274, B:66:0x027a, B:68:0x0282, B:70:0x0291, B:77:0x02a3, B:78:0x02a8, B:80:0x02a9, B:81:0x02ae, B:83:0x00d4, B:87:0x00de, B:89:0x00e4, B:91:0x00f1, B:93:0x0102, B:94:0x0107, B:95:0x0108, B:96:0x010d, B:97:0x010e, B:103:0x02bc, B:105:0x02c2, B:109:0x02cd, B:110:0x02d1, B:112:0x02d7, B:114:0x02df, B:116:0x02ee, B:122:0x02ff, B:123:0x0304, B:125:0x0305, B:126:0x030a, B:129:0x0118, B:133:0x0122, B:135:0x0128, B:137:0x0133, B:139:0x0142, B:140:0x0147, B:141:0x0148, B:142:0x014d, B:143:0x014e, B:147:0x01fc, B:150:0x0158, B:154:0x01e1, B:158:0x0162, B:162:0x01bc, B:166:0x016c, B:170:0x0176, B:174:0x0242, B:178:0x0180, B:182:0x018a, B:188:0x03b4, B:190:0x0194, B:194:0x0213, B:198:0x019e, B:202:0x01a8, B:206:0x022e, B:208:0x01b2, B:212:0x01cd, B:216:0x01d7, B:220:0x01f2, B:224:0x0209, B:228:0x0224, B:232:0x0238, B:236:0x0253, B:240:0x02af, B:244:0x030b, B:248:0x0315, B:250:0x031b, B:252:0x0326, B:256:0x0337, B:257:0x033c, B:258:0x033d, B:259:0x0342, B:260:0x0343, B:264:0x034d, B:266:0x035b, B:272:0x039f, B:274:0x0365, B:278:0x036f, B:280:0x0380, B:284:0x038a, B:286:0x0393, B:290:0x03a8, B:294:0x03bd, B:298:0x03c6, B:300:0x03cc, B:302:0x03d9, B:306:0x03ec, B:307:0x03f1, B:308:0x03f2, B:309:0x03f7, B:311:0x0052), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03b4 A[Catch: all -> 0x03f9, TryCatch #0 {all -> 0x03f9, blocks: (B:6:0x000a, B:9:0x001b, B:13:0x003f, B:15:0x0037, B:24:0x0065, B:25:0x006d, B:28:0x007a, B:32:0x0084, B:34:0x008a, B:36:0x0095, B:38:0x00a4, B:39:0x00a9, B:40:0x00aa, B:41:0x00af, B:42:0x00b0, B:46:0x00ba, B:52:0x00ca, B:58:0x0260, B:60:0x0266, B:63:0x0270, B:64:0x0274, B:66:0x027a, B:68:0x0282, B:70:0x0291, B:77:0x02a3, B:78:0x02a8, B:80:0x02a9, B:81:0x02ae, B:83:0x00d4, B:87:0x00de, B:89:0x00e4, B:91:0x00f1, B:93:0x0102, B:94:0x0107, B:95:0x0108, B:96:0x010d, B:97:0x010e, B:103:0x02bc, B:105:0x02c2, B:109:0x02cd, B:110:0x02d1, B:112:0x02d7, B:114:0x02df, B:116:0x02ee, B:122:0x02ff, B:123:0x0304, B:125:0x0305, B:126:0x030a, B:129:0x0118, B:133:0x0122, B:135:0x0128, B:137:0x0133, B:139:0x0142, B:140:0x0147, B:141:0x0148, B:142:0x014d, B:143:0x014e, B:147:0x01fc, B:150:0x0158, B:154:0x01e1, B:158:0x0162, B:162:0x01bc, B:166:0x016c, B:170:0x0176, B:174:0x0242, B:178:0x0180, B:182:0x018a, B:188:0x03b4, B:190:0x0194, B:194:0x0213, B:198:0x019e, B:202:0x01a8, B:206:0x022e, B:208:0x01b2, B:212:0x01cd, B:216:0x01d7, B:220:0x01f2, B:224:0x0209, B:228:0x0224, B:232:0x0238, B:236:0x0253, B:240:0x02af, B:244:0x030b, B:248:0x0315, B:250:0x031b, B:252:0x0326, B:256:0x0337, B:257:0x033c, B:258:0x033d, B:259:0x0342, B:260:0x0343, B:264:0x034d, B:266:0x035b, B:272:0x039f, B:274:0x0365, B:278:0x036f, B:280:0x0380, B:284:0x038a, B:286:0x0393, B:290:0x03a8, B:294:0x03bd, B:298:0x03c6, B:300:0x03cc, B:302:0x03d9, B:306:0x03ec, B:307:0x03f1, B:308:0x03f2, B:309:0x03f7, B:311:0x0052), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x039e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x039f A[Catch: all -> 0x03f9, TryCatch #0 {all -> 0x03f9, blocks: (B:6:0x000a, B:9:0x001b, B:13:0x003f, B:15:0x0037, B:24:0x0065, B:25:0x006d, B:28:0x007a, B:32:0x0084, B:34:0x008a, B:36:0x0095, B:38:0x00a4, B:39:0x00a9, B:40:0x00aa, B:41:0x00af, B:42:0x00b0, B:46:0x00ba, B:52:0x00ca, B:58:0x0260, B:60:0x0266, B:63:0x0270, B:64:0x0274, B:66:0x027a, B:68:0x0282, B:70:0x0291, B:77:0x02a3, B:78:0x02a8, B:80:0x02a9, B:81:0x02ae, B:83:0x00d4, B:87:0x00de, B:89:0x00e4, B:91:0x00f1, B:93:0x0102, B:94:0x0107, B:95:0x0108, B:96:0x010d, B:97:0x010e, B:103:0x02bc, B:105:0x02c2, B:109:0x02cd, B:110:0x02d1, B:112:0x02d7, B:114:0x02df, B:116:0x02ee, B:122:0x02ff, B:123:0x0304, B:125:0x0305, B:126:0x030a, B:129:0x0118, B:133:0x0122, B:135:0x0128, B:137:0x0133, B:139:0x0142, B:140:0x0147, B:141:0x0148, B:142:0x014d, B:143:0x014e, B:147:0x01fc, B:150:0x0158, B:154:0x01e1, B:158:0x0162, B:162:0x01bc, B:166:0x016c, B:170:0x0176, B:174:0x0242, B:178:0x0180, B:182:0x018a, B:188:0x03b4, B:190:0x0194, B:194:0x0213, B:198:0x019e, B:202:0x01a8, B:206:0x022e, B:208:0x01b2, B:212:0x01cd, B:216:0x01d7, B:220:0x01f2, B:224:0x0209, B:228:0x0224, B:232:0x0238, B:236:0x0253, B:240:0x02af, B:244:0x030b, B:248:0x0315, B:250:0x031b, B:252:0x0326, B:256:0x0337, B:257:0x033c, B:258:0x033d, B:259:0x0342, B:260:0x0343, B:264:0x034d, B:266:0x035b, B:272:0x039f, B:274:0x0365, B:278:0x036f, B:280:0x0380, B:284:0x038a, B:286:0x0393, B:290:0x03a8, B:294:0x03bd, B:298:0x03c6, B:300:0x03cc, B:302:0x03d9, B:306:0x03ec, B:307:0x03f1, B:308:0x03f2, B:309:0x03f7, B:311:0x0052), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x025f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0260 A[Catch: all -> 0x03f9, TryCatch #0 {all -> 0x03f9, blocks: (B:6:0x000a, B:9:0x001b, B:13:0x003f, B:15:0x0037, B:24:0x0065, B:25:0x006d, B:28:0x007a, B:32:0x0084, B:34:0x008a, B:36:0x0095, B:38:0x00a4, B:39:0x00a9, B:40:0x00aa, B:41:0x00af, B:42:0x00b0, B:46:0x00ba, B:52:0x00ca, B:58:0x0260, B:60:0x0266, B:63:0x0270, B:64:0x0274, B:66:0x027a, B:68:0x0282, B:70:0x0291, B:77:0x02a3, B:78:0x02a8, B:80:0x02a9, B:81:0x02ae, B:83:0x00d4, B:87:0x00de, B:89:0x00e4, B:91:0x00f1, B:93:0x0102, B:94:0x0107, B:95:0x0108, B:96:0x010d, B:97:0x010e, B:103:0x02bc, B:105:0x02c2, B:109:0x02cd, B:110:0x02d1, B:112:0x02d7, B:114:0x02df, B:116:0x02ee, B:122:0x02ff, B:123:0x0304, B:125:0x0305, B:126:0x030a, B:129:0x0118, B:133:0x0122, B:135:0x0128, B:137:0x0133, B:139:0x0142, B:140:0x0147, B:141:0x0148, B:142:0x014d, B:143:0x014e, B:147:0x01fc, B:150:0x0158, B:154:0x01e1, B:158:0x0162, B:162:0x01bc, B:166:0x016c, B:170:0x0176, B:174:0x0242, B:178:0x0180, B:182:0x018a, B:188:0x03b4, B:190:0x0194, B:194:0x0213, B:198:0x019e, B:202:0x01a8, B:206:0x022e, B:208:0x01b2, B:212:0x01cd, B:216:0x01d7, B:220:0x01f2, B:224:0x0209, B:228:0x0224, B:232:0x0238, B:236:0x0253, B:240:0x02af, B:244:0x030b, B:248:0x0315, B:250:0x031b, B:252:0x0326, B:256:0x0337, B:257:0x033c, B:258:0x033d, B:259:0x0342, B:260:0x0343, B:264:0x034d, B:266:0x035b, B:272:0x039f, B:274:0x0365, B:278:0x036f, B:280:0x0380, B:284:0x038a, B:286:0x0393, B:290:0x03a8, B:294:0x03bd, B:298:0x03c6, B:300:0x03cc, B:302:0x03d9, B:306:0x03ec, B:307:0x03f1, B:308:0x03f2, B:309:0x03f7, B:311:0x0052), top: B:5:0x000a }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean stringComparison(java.lang.String r9, org.json.JSONObject r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.integrity.MACARuleMatchingManager.stringComparison(java.lang.String, org.json.JSONObject, android.os.Bundle):boolean");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ArrayList<String> getStringArrayList(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jsonArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(jsonArray.get(i).toString());
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isMatchCCRule(String ruleString, Bundle data) {
        int length;
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && ruleString != null && data != null) {
            try {
                JSONObject jSONObject = new JSONObject(ruleString);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int hashCode = key.hashCode();
                if (hashCode != 3555) {
                    if (hashCode != 96727) {
                        if (hashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), data);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length2 = jSONArray.length();
                        if (length2 > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                if (!isMatchCCRule(jSONArray.get(i).toString(), data)) {
                                    return false;
                                }
                                if (i2 >= length2) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 != null && (length = jSONArray2.length()) > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            if (isMatchCCRule(jSONArray2.get(i3).toString(), data)) {
                                return true;
                            }
                            if (i4 >= length) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, data);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getMatchPropertyIDs(Bundle params) {
        String optString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            Integer valueOf = jSONArray == null ? null : Integer.valueOf(jSONArray.length());
            if (valueOf != null && valueOf.intValue() == 0) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            JSONArray jSONArray2 = MACARules;
            if (jSONArray2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String optString2 = jSONArray2.optString(i);
                    if (optString2 != null) {
                        JSONObject jSONObject = new JSONObject(optString2);
                        long optLong = jSONObject.optLong("id");
                        if (optLong != 0 && (optString = jSONObject.optString("rule")) != null && isMatchCCRule(optString, params)) {
                            arrayList.add(Long.valueOf(optLong));
                        }
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            String jSONArray3 = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray3, "JSONArray(res).toString()");
            return jSONArray3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void processParameters(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || params == null) {
                return;
            }
            try {
                generateInfo(params, event);
                params.putString("_audiencePropertyIds", getMatchPropertyIDs(params));
                params.putString("cs_maca", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                removeGeneratedInfo(params);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:6:0x000d, B:10:0x0032, B:13:0x004d, B:16:0x0063, B:19:0x0079, B:22:0x0093, B:26:0x0046, B:29:0x002b), top: B:5:0x000d }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void generateInfo(android.os.Bundle r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "ANDROID"
            java.lang.String r1 = "event"
            java.lang.Class<com.facebook.appevents.integrity.MACARuleMatchingManager> r2 = com.facebook.appevents.integrity.MACARuleMatchingManager.class
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)
            if (r3 == 0) goto Ld
            return
        Ld:
            java.lang.String r3 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)     // Catch: java.lang.Throwable -> Lc4
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)     // Catch: java.lang.Throwable -> Lc4
            r5.putString(r1, r6)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_locale"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4
            r1.<init>()     // Catch: java.lang.Throwable -> Lc4
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> Lc4
            java.util.Locale r3 = r3.getLocale()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r4 = ""
            if (r3 != 0) goto L2b
        L29:
            r3 = r4
            goto L32
        L2b:
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> Lc4
            if (r3 != 0) goto L32
            goto L29
        L32:
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lc4
            r3 = 95
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lc4
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> Lc4
            java.util.Locale r3 = r3.getLocale()     // Catch: java.lang.Throwable -> Lc4
            if (r3 != 0) goto L46
        L44:
            r3 = r4
            goto L4d
        L46:
            java.lang.String r3 = r3.getCountry()     // Catch: java.lang.Throwable -> Lc4
            if (r3 != 0) goto L4d
            goto L44
        L4d:
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc4
            r5.putString(r6, r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_appVersion"
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r1 = r1.getVersionName()     // Catch: java.lang.Throwable -> Lc4
            if (r1 != 0) goto L63
            r1 = r4
        L63:
            r5.putString(r6, r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_deviceOS"
            r5.putString(r6, r0)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_platform"
            java.lang.String r1 = "mobile"
            r5.putString(r6, r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_deviceModel"
            java.lang.String r1 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> Lc4
            if (r1 != 0) goto L79
            r1 = r4
        L79:
            r5.putString(r6, r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_nativeAppID"
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch: java.lang.Throwable -> Lc4
            r5.putString(r6, r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_nativeAppShortVersion"
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r1 = r1.getVersionName()     // Catch: java.lang.Throwable -> Lc4
            if (r1 != 0) goto L92
            goto L93
        L92:
            r4 = r1
        L93:
            r5.putString(r6, r4)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_timezone"
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r1 = r1.getDeviceTimeZoneName()     // Catch: java.lang.Throwable -> Lc4
            r5.putString(r6, r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_carrier"
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r1 = r1.getCarrierName()     // Catch: java.lang.Throwable -> Lc4
            r5.putString(r6, r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_deviceOSTypeName"
            r5.putString(r6, r0)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_deviceOSVersion"
            java.lang.String r0 = android.os.Build.VERSION.RELEASE     // Catch: java.lang.Throwable -> Lc4
            r5.putString(r6, r0)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r6 = "_remainingDiskGB"
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> Lc4
            long r0 = r0.getAvailableExternalStorageGB()     // Catch: java.lang.Throwable -> Lc4
            r5.putLong(r6, r0)     // Catch: java.lang.Throwable -> Lc4
            return
        Lc4:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r2)
            return
            fill-array 0x00ca: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.integrity.MACARuleMatchingManager.generateInfo(android.os.Bundle, java.lang.String):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            String[] strArr = keys;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                i++;
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }
}
