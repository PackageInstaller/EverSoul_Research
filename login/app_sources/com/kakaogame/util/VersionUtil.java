package com.kakaogame.util;

import android.os.Build;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: VersionUtil.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/util/VersionUtil;", "", "()V", "TAG", "", "aPIVersion", "", "getAPIVersion", "()I", "oSMajorVersion", "getOSMajorVersion", "()Ljava/lang/String;", "oSVersion", "getOSVersion$annotations", "getOSVersion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class VersionUtil {
    public static final VersionUtil INSTANCE = new VersionUtil();
    private static final String TAG = "VersionUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getOSVersion$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private VersionUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getOSVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, y.ٲٴݴ״ٰ(1782549112));
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getOSMajorVersion() {
        String oSVersion = getOSVersion();
        int indexOf$default = StringsKt.indexOf$default((CharSequence) oSVersion, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, false, 6, (Object) null);
        if (indexOf$default <= 0) {
            return oSVersion;
        }
        String substring = oSVersion.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getAPIVersion() {
        return Build.VERSION.SDK_INT;
    }
}
