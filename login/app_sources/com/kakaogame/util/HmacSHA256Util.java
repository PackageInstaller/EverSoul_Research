package com.kakaogame.util;

import com.kakaogame.Logger;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: HmacSHA256Util.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/util/HmacSHA256Util;", "", "()V", "ALGORITHM", "", "TAG", "infodeskSecret", "", "[Ljava/lang/String;", "secrets", "encode", "", Base2ndPWViewData.KEY_INPUT, "secret", "getDLS", "bodyString", "verifySignature", "", "signature", "requestBody", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class HmacSHA256Util {
    private static final String ALGORITHM = "HmacSHA256";
    private static final String TAG = "HmacSHA256Util";
    public static final HmacSHA256Util INSTANCE = new HmacSHA256Util();
    private static final String[] secrets = {y.٬ݯح׭٩(576286222), y.ٴسسݬߨ(1393208002), y.ٲٴݴ״ٰ(1782560232), y.ݮڮֲڭܩ(-628187380), y.٬ݯح׭٩(576286606), y.دײܮڳܯ(2051253869), y.ٴسسݬߨ(1393206306), y.ݬֲ֮ܲت(1512279879), y.ۮڭڭܬި(862899211), y.֬ڱܱײٮ(-1159006047)};
    private static final String[] infodeskSecret = {y.ٲٴݴ״ٰ(1782561512), y.ݬֲ֮ܲت(1512279495), y.֬ڱܱײٮ(-1159005311), y.ٲٴݴ״ٰ(1782560776), y.ۮڭڭܬި(862899787), y.٬ݯح׭٩(576283630), y.٬ݯح׭٩(576283662), y.ݬֲ֮ܲت(1512278791), y.ݮڮֲڭܩ(-628190036), y.ٴسسݬߨ(1393205506)};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HmacSHA256Util() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] encode(String input, String secret) {
        String str = y.ٴسسݬߨ(1393128306);
        String str2 = y.دײܮڳܯ(2051253197);
        try {
            if (input.length() == 0) {
                return null;
            }
            Mac mac = Mac.getInstance(str2);
            byte[] bytes = secret.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, str);
            mac.init(new SecretKeySpec(bytes, str2));
            byte[] bytes2 = input.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, str);
            return mac.doFinal(bytes2);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512278471), y.ٲٴݴ״ٰ(1782562056), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getDLS(String bodyString) {
        Intrinsics.checkNotNullParameter(bodyString, y.ٲٴݴ״ٰ(1782562248));
        Random random = new Random();
        String[] strArr = secrets;
        int nextInt = random.nextInt(strArr.length);
        String base64encodeFromData = Base64Util.getBase64encodeFromData(INSTANCE.encode(StringsKt.replace$default(StringsKt.replace$default(bodyString, y.دײܮڳܯ(2051829469), "", false, 4, (Object) null), y.ٲٴݴ״ٰ(1781641888), "", false, 4, (Object) null), strArr[nextInt]), 0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, y.٬ݯح׭٩(576284430), Arrays.copyOf(new Object[]{Integer.valueOf(nextInt), base64encodeFromData}, 2));
        Intrinsics.checkNotNullExpressionValue(format, y.دײܮڳܯ(2051252485));
        return format;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean verifySignature(String signature, String requestBody) {
        int parseInt;
        String str;
        Intrinsics.checkNotNullParameter(signature, y.ٲٴݴ״ٰ(1782555512));
        try {
            String[] strArr = (String[]) new Regex(";").split(signature, 0).toArray(new String[0]);
            parseInt = Integer.parseInt(strArr[0]);
            str = strArr[1];
            Intrinsics.checkNotNull(requestBody);
        } catch (Exception e) {
            Logger.INSTANCE.m701e(y.ݬֲ֮ܲت(1512278471), y.ݬֲ֮ܲت(1512281951) + e);
        }
        return Intrinsics.areEqual(Base64Util.getBase64encodeFromData(encode(requestBody, infodeskSecret[parseInt]), 2), str);
    }
}
