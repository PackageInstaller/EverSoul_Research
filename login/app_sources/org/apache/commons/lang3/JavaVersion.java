package org.apache.commons.lang3;

import com.liapp.y;
import org.apache.commons.lang3.math.NumberUtils;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'JAVA_1_9' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class JavaVersion {
    private static final /* synthetic */ JavaVersion[] $VALUES;
    public static final JavaVersion JAVA_0_9;
    public static final JavaVersion JAVA_10;
    public static final JavaVersion JAVA_11;
    public static final JavaVersion JAVA_1_1;
    public static final JavaVersion JAVA_1_2;
    public static final JavaVersion JAVA_1_3;
    public static final JavaVersion JAVA_1_4;
    public static final JavaVersion JAVA_1_5;
    public static final JavaVersion JAVA_1_6;
    public static final JavaVersion JAVA_1_7;
    public static final JavaVersion JAVA_1_8;

    @Deprecated
    public static final JavaVersion JAVA_1_9;
    public static final JavaVersion JAVA_9;
    public static final JavaVersion JAVA_RECENT;
    private final String name;
    private final float value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JavaVersion valueOf(String str) {
        return (JavaVersion) Enum.valueOf(JavaVersion.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JavaVersion[] values() {
        return (JavaVersion[]) $VALUES.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        JavaVersion javaVersion = new JavaVersion(y.ٲٴݴ״ٰ(1781692848), 0, 1.5f, y.֬ڱܱײٮ(-1159251135));
        JAVA_0_9 = javaVersion;
        JavaVersion javaVersion2 = new JavaVersion(y.دײܮڳܯ(2051958125), 1, 1.1f, y.ݬֲ֮ܲت(1512983919));
        JAVA_1_1 = javaVersion2;
        JavaVersion javaVersion3 = new JavaVersion(y.ۮڭڭܬި(862129827), 2, 1.2f, y.֬ڱܱײٮ(-1159251375));
        JAVA_1_2 = javaVersion3;
        JavaVersion javaVersion4 = new JavaVersion(y.ٲٴݴ״ٰ(1781694232), 3, 1.3f, y.֬ڱܱײٮ(-1159251239));
        JAVA_1_3 = javaVersion4;
        JavaVersion javaVersion5 = new JavaVersion(y.ۮڭڭܬި(862128563), 4, 1.4f, y.֬ڱܱײٮ(-1159250591));
        JAVA_1_4 = javaVersion5;
        JavaVersion javaVersion6 = new JavaVersion(y.دײܮڳܯ(2051957389), 5, 1.5f, y.ٴسسݬߨ(1392992394));
        JAVA_1_5 = javaVersion6;
        JavaVersion javaVersion7 = new JavaVersion(y.ݮڮֲڭܩ(-628927196), 6, 1.6f, y.ݬֲ֮ܲت(1512983255));
        JAVA_1_6 = javaVersion7;
        JavaVersion javaVersion8 = new JavaVersion(y.ۮڭڭܬި(862128347), 7, 1.7f, y.ٴسسݬߨ(1392992666));
        JAVA_1_7 = javaVersion8;
        JavaVersion javaVersion9 = new JavaVersion(y.ݬֲ֮ܲت(1512983039), 8, 1.8f, y.٬ݯح׭٩(575972878));
        JAVA_1_8 = javaVersion9;
        String str = y.٬ݯح׭٩(575972998);
        String str2 = y.֬ڱܱײٮ(-1159250375);
        JavaVersion javaVersion10 = new JavaVersion(str, 9, 9.0f, str2);
        JAVA_1_9 = javaVersion10;
        JavaVersion javaVersion11 = new JavaVersion(y.ݬֲ֮ܲت(1512982663), 10, 9.0f, str2);
        JAVA_9 = javaVersion11;
        JavaVersion javaVersion12 = new JavaVersion(y.دײܮڳܯ(2051957005), 11, 10.0f, y.ݮڮֲڭܩ(-628926708));
        JAVA_10 = javaVersion12;
        JavaVersion javaVersion13 = new JavaVersion(y.ݬֲ֮ܲت(1512982655), 12, 11.0f, y.دײܮڳܯ(2051957173));
        JAVA_11 = javaVersion13;
        JavaVersion javaVersion14 = new JavaVersion(y.֬ڱܱײٮ(-1159257839), 13, maxVersion(), Float.toString(maxVersion()));
        JAVA_RECENT = javaVersion14;
        $VALUES = new JavaVersion[]{javaVersion, javaVersion2, javaVersion3, javaVersion4, javaVersion5, javaVersion6, javaVersion7, javaVersion8, javaVersion9, javaVersion10, javaVersion11, javaVersion12, javaVersion13, javaVersion14};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private JavaVersion(String str, int i, float f, String str2) {
        this.value = f;
        this.name = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean atLeast(JavaVersion javaVersion) {
        return this.value >= javaVersion.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static JavaVersion getJavaVersion(String str) {
        return get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static JavaVersion get(String str) {
        if (y.֬ڱܱײٮ(-1159251135).equals(str)) {
            return JAVA_0_9;
        }
        if (y.ݬֲ֮ܲت(1512983919).equals(str)) {
            return JAVA_1_1;
        }
        if (y.֬ڱܱײٮ(-1159251375).equals(str)) {
            return JAVA_1_2;
        }
        if (y.֬ڱܱײٮ(-1159251239).equals(str)) {
            return JAVA_1_3;
        }
        if (y.֬ڱܱײٮ(-1159250591).equals(str)) {
            return JAVA_1_4;
        }
        if (y.ٴسسݬߨ(1392992394).equals(str)) {
            return JAVA_1_5;
        }
        if (y.ݬֲ֮ܲت(1512983255).equals(str)) {
            return JAVA_1_6;
        }
        if (y.ٴسسݬߨ(1392992666).equals(str)) {
            return JAVA_1_7;
        }
        if (y.٬ݯح׭٩(575972878).equals(str)) {
            return JAVA_1_8;
        }
        if (y.֬ڱܱײٮ(-1159250375).equals(str)) {
            return JAVA_9;
        }
        if (y.ݮڮֲڭܩ(-628926708).equals(str)) {
            return JAVA_10;
        }
        if (y.دײܮڳܯ(2051957173).equals(str)) {
            return JAVA_11;
        }
        if (str == null) {
            return null;
        }
        float floatVersion = toFloatVersion(str);
        if (floatVersion - 1.0d < 1.0d) {
            int max = Math.max(str.indexOf(46), str.indexOf(44));
            if (Float.parseFloat(str.substring(max + 1, Math.max(str.length(), str.indexOf(44, max)))) > 0.9f) {
                return JAVA_RECENT;
            }
        } else if (floatVersion > 10.0f) {
            return JAVA_RECENT;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static float maxVersion() {
        float floatVersion = toFloatVersion(System.getProperty(y.ݮڮֲڭܩ(-628930364), y.֬ڱܱײٮ(-1159258039)));
        if (floatVersion > 0.0f) {
            return floatVersion;
        }
        return 99.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static float toFloatVersion(String str) {
        if (str.contains(y.ݮڮֲڭܩ(-629059348))) {
            String[] split = str.split(y.ݮڮֲڭܩ(-628930060));
            if (split.length >= 2) {
                return NumberUtils.toFloat(split[0] + ClassUtils.PACKAGE_SEPARATOR_CHAR + split[1], -1.0f);
            }
            return -1.0f;
        }
        return NumberUtils.toFloat(str, -1.0f);
    }
}
