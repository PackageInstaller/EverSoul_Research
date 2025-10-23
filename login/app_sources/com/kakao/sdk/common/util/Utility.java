package com.kakao.sdk.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.kakao.sdk.common.Constants;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.SdkIdentifier;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.server.ServerConstants;
import java.io.File;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p031io.FilesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: Utility.kt */
@Metadata(m838d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001c\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bJ\"\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\bJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\bJ\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b¨\u0006\""}, m839d2 = {"Lcom/kakao/sdk/common/util/Utility;", "", "()V", ServerConstants.ANDROID_ID, "", "context", "Landroid/content/Context;", "buildQuery", "", NativeProtocol.WEB_DIALOG_PARAMS, "", "getExtras", "Lcom/google/gson/JsonObject;", "sdkType", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "getJson", Base2ndPWViewData.KEY_PATH, "getJsonArray", "Lcom/google/gson/JsonArray;", "getJsonObject", "getKAHeader", "sdkIdentifier", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "getKeyHash", "getKeyHashDeprecated", "getMetadata", "key", "hasAndNotNull", "", "jsonObject", "parseQuery", "queries", "uriPathToFilePath", "uri", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Utility {
    public static final Utility INSTANCE = new Utility();

    /* compiled from: Utility.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[KakaoSdk.Type.values().length];
            iArr[KakaoSdk.Type.RX_KOTLIN.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Utility() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKeyHash(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getKeyHashDeprecated(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKeyHashDeprecated(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        Intrinsics.checkNotNullExpressionValue(signatureArr, "packageInfo.signatures");
        if (signatureArr.length > 0) {
            Signature signature = signatureArr[0];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(signature.toByteArray());
            String encodeToString = Base64.encodeToString(messageDigest.digest(), 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(md.digest(), Base64.NO_WRAP)");
            return encodeToString;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ String getKAHeader$default(Utility utility, Context context, KakaoSdk.Type type, SdkIdentifier sdkIdentifier, int i, Object obj) {
        if ((i & 4) != 0) {
            sdkIdentifier = null;
        }
        return utility.getKAHeader(context, type, sdkIdentifier);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKAHeader(Context context, KakaoSdk.Type sdkType, SdkIdentifier sdkIdentifier) {
        String str;
        String identifiers;
        String stringPlus;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        if (Build.VERSION.SDK_INT >= 33) {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L)).versionName;
        } else {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[17];
        objArr[0] = "sdk";
        objArr[1] = "2.17.0";
        objArr[2] = Constants.SDK_TYPE;
        objArr[3] = WhenMappings.$EnumSwitchMapping$0[sdkType.ordinal()] == 1 ? Constants.SDK_TYPE_RX_KOTLIN : Constants.SDK_TYPE_KOTLIN;
        objArr[4] = "os";
        objArr[5] = Integer.valueOf(Build.VERSION.SDK_INT);
        objArr[6] = "lang";
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
        String lowerCase = language.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        objArr[7] = lowerCase;
        String country = Locale.getDefault().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getDefault().country");
        String upperCase = country.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        objArr[8] = upperCase;
        objArr[9] = "origin";
        objArr[10] = getKeyHash(context);
        objArr[11] = "device";
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase2 = MODEL.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(locale)");
        objArr[12] = new Regex("\\s").replace(new Regex("[^\\p{ASCII}]").replace(upperCase2, "*"), "-");
        objArr[13] = Constants.ANDROID_PKG;
        objArr[14] = context.getPackageName();
        objArr[15] = Constants.APP_VER;
        objArr[16] = str;
        String format = String.format("%s/%s %s/%s %s/android-%s %s/%s-%s %s/%s %s/%s %s/%s %s/%s", Arrays.copyOf(objArr, 17));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return (sdkIdentifier == null || (identifiers = sdkIdentifier.getIdentifiers()) == null || (stringPlus = Intrinsics.stringPlus(format, identifiers)) == null) ? format : stringPlus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getExtras(Context context, KakaoSdk.Type sdkType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(Constants.APP_PACKAGE, context.getPackageName());
        jsonObject.addProperty(Constants.APP_KEY_HASH, getKeyHash(context));
        jsonObject.addProperty(Constants.KA, getKAHeader$default(this, context, sdkType, null, 4, null));
        return jsonObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMetadata(Context context, String key) {
        ApplicationInfo applicationInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L));
        } else {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        }
        Intrinsics.checkNotNullExpressionValue(applicationInfo, "if (Build.VERSION.SDK_IN…A\n            )\n        }");
        return applicationInfo.metaData.getString(key);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] androidId(Context context) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String androidId = Settings.Secure.getString(context.getContentResolver(), "android_id");
            Intrinsics.checkNotNullExpressionValue(androidId, "androidId");
            String replace = new Regex("[0\\s]").replace(androidId, "");
            MessageDigest messageDigest = MessageDigest.getInstance(com.kakao.sdk.auth.Constants.CODE_CHALLENGE_ALGORITHM);
            messageDigest.reset();
            byte[] bytes = Intrinsics.stringPlus("SDK-", replace).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "{\n            val androi…    md.digest()\n        }");
            return digest;
        } catch (Exception unused) {
            byte[] bytes2 = ("xxxx" + ((Object) Build.PRODUCT) + "a23456789012345bcdefg").getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            return bytes2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> parseQuery(String queries) {
        if (queries == null) {
            return MapsKt.emptyMap();
        }
        List split$default = StringsKt.split$default((CharSequence) queries, new String[]{"&"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((List) next).size() > 1) {
                arrayList2.add(next);
            }
        }
        ArrayList<List> arrayList3 = arrayList2;
        ArrayList<Pair> arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (List list : arrayList3) {
            arrayList4.add(new Pair(list.get(0), list.get(1)));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList4) {
            Object first = pair.getFirst();
            String decode = URLDecoder.decode((String) pair.getSecond(), "UTF-8");
            Intrinsics.checkNotNullExpressionValue(decode, "decode(pair.second, \"UTF-8\")");
            linkedHashMap.put(first, decode);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String buildQuery(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList(params.size());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            arrayList.add(entry.getKey() + '=' + entry.getValue());
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = ((String) next) + Typography.amp + ((String) it.next());
        }
        return (String) next;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getJson(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ClassLoader classLoader = getClass().getClassLoader();
        classLoader.getClass();
        return new String(FilesKt.readBytes(new File(classLoader.getResource(path).getPath())), Charsets.UTF_8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonObject getJsonObject(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return (JsonObject) KakaoJson.INSTANCE.fromJson(getJson(path), JsonObject.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JsonArray getJsonArray(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return (JsonArray) KakaoJson.INSTANCE.fromJson(getJson(path), JsonArray.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasAndNotNull(JsonObject jsonObject, String key) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        return jsonObject.has(key) && !(jsonObject.get(key) instanceof JsonNull);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String uriPathToFilePath(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return StringsKt.replace$default(StringsKt.removePrefix(uri, (CharSequence) RemoteSettings.FORWARD_SLASH_STRING), RemoteSettings.FORWARD_SLASH_STRING, "_", false, 4, (Object) null);
    }
}
