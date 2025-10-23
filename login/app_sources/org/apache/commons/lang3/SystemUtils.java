package org.apache.commons.lang3;

import com.liapp.y;
import java.io.File;

/* loaded from: classes2.dex */
public class SystemUtils {
    public static final boolean IS_JAVA_10;
    public static final boolean IS_JAVA_11;
    public static final boolean IS_JAVA_1_1;
    public static final boolean IS_JAVA_1_2;
    public static final boolean IS_JAVA_1_3;
    public static final boolean IS_JAVA_1_4;
    public static final boolean IS_JAVA_1_5;
    public static final boolean IS_JAVA_1_6;
    public static final boolean IS_JAVA_1_7;
    public static final boolean IS_JAVA_1_8;

    @Deprecated
    public static final boolean IS_JAVA_1_9;
    public static final boolean IS_JAVA_9;
    public static final boolean IS_OS_400;
    public static final boolean IS_OS_AIX;
    public static final boolean IS_OS_FREE_BSD;
    public static final boolean IS_OS_HP_UX;
    public static final boolean IS_OS_IRIX;
    public static final boolean IS_OS_LINUX;
    public static final boolean IS_OS_MAC;
    public static final boolean IS_OS_MAC_OSX;
    public static final boolean IS_OS_MAC_OSX_CHEETAH;
    public static final boolean IS_OS_MAC_OSX_EL_CAPITAN;
    public static final boolean IS_OS_MAC_OSX_JAGUAR;
    public static final boolean IS_OS_MAC_OSX_LEOPARD;
    public static final boolean IS_OS_MAC_OSX_LION;
    public static final boolean IS_OS_MAC_OSX_MAVERICKS;
    public static final boolean IS_OS_MAC_OSX_MOUNTAIN_LION;
    public static final boolean IS_OS_MAC_OSX_PANTHER;
    public static final boolean IS_OS_MAC_OSX_PUMA;
    public static final boolean IS_OS_MAC_OSX_SNOW_LEOPARD;
    public static final boolean IS_OS_MAC_OSX_TIGER;
    public static final boolean IS_OS_MAC_OSX_YOSEMITE;
    public static final boolean IS_OS_NET_BSD;
    public static final boolean IS_OS_OPEN_BSD;
    public static final boolean IS_OS_OS2;
    public static final boolean IS_OS_SOLARIS;
    public static final boolean IS_OS_SUN_OS;
    public static final boolean IS_OS_UNIX;
    public static final boolean IS_OS_WINDOWS;
    public static final boolean IS_OS_WINDOWS_10;
    public static final boolean IS_OS_WINDOWS_2000;
    public static final boolean IS_OS_WINDOWS_2003;
    public static final boolean IS_OS_WINDOWS_2008;
    public static final boolean IS_OS_WINDOWS_2012;
    public static final boolean IS_OS_WINDOWS_7;
    public static final boolean IS_OS_WINDOWS_8;
    public static final boolean IS_OS_WINDOWS_95;
    public static final boolean IS_OS_WINDOWS_98;
    public static final boolean IS_OS_WINDOWS_ME;
    public static final boolean IS_OS_WINDOWS_NT;
    public static final boolean IS_OS_WINDOWS_VISTA;
    public static final boolean IS_OS_WINDOWS_XP;
    public static final boolean IS_OS_ZOS;
    private static final String JAVA_HOME_KEY = "java.home";
    private static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
    public static final String JAVA_SPECIFICATION_VERSION;
    private static final JavaVersion JAVA_SPECIFICATION_VERSION_AS_ENUM;
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY;
    public static final String JAVA_VENDOR;
    public static final String JAVA_VENDOR_URL;
    public static final String JAVA_VERSION;
    public static final String JAVA_VM_INFO;
    public static final String JAVA_VM_NAME;
    public static final String JAVA_VM_SPECIFICATION_NAME;
    public static final String JAVA_VM_SPECIFICATION_VENDOR;
    public static final String JAVA_VM_SPECIFICATION_VERSION;
    public static final String JAVA_VM_VENDOR;
    public static final String JAVA_VM_VERSION;

    @Deprecated
    public static final String LINE_SEPARATOR;
    public static final String OS_ARCH;
    public static final String OS_NAME;
    private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
    public static final String OS_VERSION;

    @Deprecated
    public static final String PATH_SEPARATOR;
    public static final String USER_COUNTRY;
    public static final String USER_DIR;
    private static final String USER_DIR_KEY = "user.dir";
    public static final String USER_HOME;
    private static final String USER_HOME_KEY = "user.home";
    public static final String USER_LANGUAGE;
    public static final String USER_NAME;
    public static final String USER_TIMEZONE;
    public static final String AWT_TOOLKIT = getSystemProperty(y.دײܮڳܯ(2051948741));
    public static final String FILE_ENCODING = getSystemProperty(y.ٲٴݴ״ٰ(1781685256));

    @Deprecated
    public static final String FILE_SEPARATOR = getSystemProperty(y.ۮڭڭܬި(862136995));
    public static final String JAVA_AWT_FONTS = getSystemProperty(y.دײܮڳܯ(2051956325));
    public static final String JAVA_AWT_GRAPHICSENV = getSystemProperty(y.֬ڱܱײٮ(-1159265879));
    public static final String JAVA_AWT_HEADLESS = getSystemProperty(y.ٴسسݬߨ(1392991514));
    public static final String JAVA_AWT_PRINTERJOB = getSystemProperty(y.ݬֲ֮ܲت(1512994375));
    public static final String JAVA_CLASS_PATH = getSystemProperty(y.ٲٴݴ״ٰ(1781678480));
    public static final String JAVA_CLASS_VERSION = getSystemProperty(y.֬ڱܱײٮ(-1159265743));
    public static final String JAVA_COMPILER = getSystemProperty(y.دײܮڳܯ(2051956189));
    public static final String JAVA_ENDORSED_DIRS = getSystemProperty(y.֬ڱܱײٮ(-1159264999));
    public static final String JAVA_EXT_DIRS = getSystemProperty(y.ۮڭڭܬި(862138867));
    public static final String JAVA_HOME = getSystemProperty(y.֬ڱܱײٮ(-1159265279));
    public static final String JAVA_IO_TMPDIR = getSystemProperty(y.ٴسسݬߨ(1392990666));
    public static final String JAVA_LIBRARY_PATH = getSystemProperty(y.ۮڭڭܬި(862139171));
    public static final String JAVA_RUNTIME_NAME = getSystemProperty(y.دײܮڳܯ(2051910029));
    public static final String JAVA_RUNTIME_VERSION = getSystemProperty(y.٬ݯح׭٩(575970974));
    public static final String JAVA_SPECIFICATION_NAME = getSystemProperty(y.ٴسسݬߨ(1392990978));
    public static final String JAVA_SPECIFICATION_VENDOR = getSystemProperty(y.ٲٴݴ״ٰ(1781680944));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String systemProperty = getSystemProperty(y.ݮڮֲڭܩ(-628930364));
        JAVA_SPECIFICATION_VERSION = systemProperty;
        JAVA_SPECIFICATION_VERSION_AS_ENUM = JavaVersion.get(systemProperty);
        JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty(y.ٲٴݴ״ٰ(1781681128));
        JAVA_VENDOR = getSystemProperty(y.ݬֲ֮ܲت(1512996231));
        JAVA_VENDOR_URL = getSystemProperty(y.ݮڮֲڭܩ(-628923692));
        JAVA_VERSION = getSystemProperty(y.ݮڮֲڭܩ(-628923556));
        JAVA_VM_INFO = getSystemProperty(y.֬ڱܱײٮ(-1159263679));
        JAVA_VM_NAME = getSystemProperty(y.֬ڱܱײٮ(-1159263535));
        JAVA_VM_SPECIFICATION_NAME = getSystemProperty(y.ۮڭڭܬި(862140779));
        JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty(y.֬ڱܱײٮ(-1159263231));
        JAVA_VM_SPECIFICATION_VERSION = getSystemProperty(y.ݮڮֲڭܩ(-628922756));
        JAVA_VM_VENDOR = getSystemProperty(y.ٲٴݴ״ٰ(1781681200));
        JAVA_VM_VERSION = getSystemProperty(y.ݬֲ֮ܲت(1512994879));
        LINE_SEPARATOR = getSystemProperty(y.ۮڭڭܬި(862242075));
        OS_ARCH = getSystemProperty(y.ٲٴݴ״ٰ(1781904312));
        OS_NAME = getSystemProperty(y.دײܮڳܯ(2051649157));
        OS_VERSION = getSystemProperty(y.ۮڭڭܬި(862241803));
        PATH_SEPARATOR = getSystemProperty(y.ۮڭڭܬި(862241963));
        String str = y.ٴسسݬߨ(1392553538);
        if (getSystemProperty(str) == null) {
            str = y.دײܮڳܯ(2051648765);
        }
        USER_COUNTRY = getSystemProperty(str);
        USER_DIR = getSystemProperty(y.٬ݯح׭٩(575892166));
        USER_HOME = getSystemProperty(y.֬ڱܱײٮ(-1159662983));
        USER_LANGUAGE = getSystemProperty(y.دײܮڳܯ(2051649005));
        USER_NAME = getSystemProperty(y.ݬֲ֮ܲت(1512670095));
        USER_TIMEZONE = getSystemProperty(y.٬ݯح׭٩(575892574));
        IS_JAVA_1_1 = getJavaVersionMatches(y.ݬֲ֮ܲت(1512983919));
        IS_JAVA_1_2 = getJavaVersionMatches(y.֬ڱܱײٮ(-1159251375));
        IS_JAVA_1_3 = getJavaVersionMatches(y.֬ڱܱײٮ(-1159251239));
        IS_JAVA_1_4 = getJavaVersionMatches(y.֬ڱܱײٮ(-1159250591));
        IS_JAVA_1_5 = getJavaVersionMatches(y.ٴسسݬߨ(1392992394));
        IS_JAVA_1_6 = getJavaVersionMatches(y.ݬֲ֮ܲت(1512983255));
        IS_JAVA_1_7 = getJavaVersionMatches(y.ٴسسݬߨ(1392992666));
        IS_JAVA_1_8 = getJavaVersionMatches(y.٬ݯح׭٩(575972878));
        String str2 = y.֬ڱܱײٮ(-1159250375);
        IS_JAVA_1_9 = getJavaVersionMatches(str2);
        IS_JAVA_9 = getJavaVersionMatches(str2);
        IS_JAVA_10 = getJavaVersionMatches(y.ݮڮֲڭܩ(-628926708));
        IS_JAVA_11 = getJavaVersionMatches(y.دײܮڳܯ(2051957173));
        boolean osMatchesName = getOsMatchesName(y.ݬֲ֮ܲت(1512670079));
        IS_OS_AIX = osMatchesName;
        boolean osMatchesName2 = getOsMatchesName(y.ٴسسݬߨ(1392552274));
        IS_OS_HP_UX = osMatchesName2;
        IS_OS_400 = getOsMatchesName(y.ݬֲ֮ܲت(1512669919));
        boolean osMatchesName3 = getOsMatchesName(y.֬ڱܱײٮ(-1159662407));
        IS_OS_IRIX = osMatchesName3;
        boolean z = getOsMatchesName(y.دײܮڳܯ(2051648453)) || getOsMatchesName(y.دײܮڳܯ(2051648413));
        IS_OS_LINUX = z;
        IS_OS_MAC = getOsMatchesName(y.ۮڭڭܬި(862241555));
        String str3 = y.٬ݯح׭٩(575893118);
        boolean osMatchesName4 = getOsMatchesName(str3);
        IS_OS_MAC_OSX = osMatchesName4;
        IS_OS_MAC_OSX_CHEETAH = getOsMatches(str3, y.دײܮڳܯ(2051647725));
        IS_OS_MAC_OSX_PUMA = getOsMatches(str3, y.ٴسسݬߨ(1392552594));
        IS_OS_MAC_OSX_JAGUAR = getOsMatches(str3, y.ٴسسݬߨ(1392552610));
        IS_OS_MAC_OSX_PANTHER = getOsMatches(str3, y.֬ڱܱײٮ(-1159662063));
        IS_OS_MAC_OSX_TIGER = getOsMatches(str3, y.ݮڮֲڭܩ(-628842740));
        IS_OS_MAC_OSX_LEOPARD = getOsMatches(str3, y.ݮڮֲڭܩ(-628842532));
        IS_OS_MAC_OSX_SNOW_LEOPARD = getOsMatches(str3, y.دײܮڳܯ(2051647949));
        IS_OS_MAC_OSX_LION = getOsMatches(str3, y.دײܮڳܯ(2051647901));
        IS_OS_MAC_OSX_MOUNTAIN_LION = getOsMatches(str3, y.ٲٴݴ״ٰ(1781906184));
        IS_OS_MAC_OSX_MAVERICKS = getOsMatches(str3, y.دײܮڳܯ(2051647037));
        IS_OS_MAC_OSX_YOSEMITE = getOsMatches(str3, y.دײܮڳܯ(2051646989));
        IS_OS_MAC_OSX_EL_CAPITAN = getOsMatches(str3, y.ۮڭڭܬި(862244227));
        boolean osMatchesName5 = getOsMatchesName(y.دײܮڳܯ(2051647133));
        IS_OS_FREE_BSD = osMatchesName5;
        boolean osMatchesName6 = getOsMatchesName(y.ٴسسݬߨ(1392551274));
        IS_OS_OPEN_BSD = osMatchesName6;
        boolean osMatchesName7 = getOsMatchesName(y.ݬֲ֮ܲت(1512672999));
        IS_OS_NET_BSD = osMatchesName7;
        IS_OS_OS2 = getOsMatchesName(y.֬ڱܱײٮ(-1159661439));
        boolean osMatchesName8 = getOsMatchesName(y.ݮڮֲڭܩ(-628846148));
        IS_OS_SOLARIS = osMatchesName8;
        boolean osMatchesName9 = getOsMatchesName(y.ݮڮֲڭܩ(-628845980));
        IS_OS_SUN_OS = osMatchesName9;
        IS_OS_UNIX = osMatchesName || osMatchesName2 || osMatchesName3 || z || osMatchesName4 || osMatchesName8 || osMatchesName9 || osMatchesName5 || osMatchesName6 || osMatchesName7;
        IS_OS_WINDOWS = getOsMatchesName(y.ݬֲ֮ܲت(1512672759));
        IS_OS_WINDOWS_2000 = getOsMatchesName(y.دײܮڳܯ(2051646661));
        IS_OS_WINDOWS_2003 = getOsMatchesName(y.֬ڱܱײٮ(-1159661031));
        IS_OS_WINDOWS_2008 = getOsMatchesName(y.٬ݯح׭٩(575890342));
        IS_OS_WINDOWS_2012 = getOsMatchesName(y.ۮڭڭܬި(862243083));
        IS_OS_WINDOWS_95 = getOsMatchesName(y.ٲٴݴ״ٰ(1781907440));
        IS_OS_WINDOWS_98 = getOsMatchesName(y.ٲٴݴ״ٰ(1781907024));
        IS_OS_WINDOWS_ME = getOsMatchesName(y.ٴسسݬߨ(1392550394));
        IS_OS_WINDOWS_NT = getOsMatchesName(y.֬ڱܱײٮ(-1159659719));
        IS_OS_WINDOWS_XP = getOsMatchesName(y.دײܮڳܯ(2051645461));
        IS_OS_WINDOWS_VISTA = getOsMatchesName(y.ݬֲ֮ܲت(1512671583));
        IS_OS_WINDOWS_7 = getOsMatchesName(y.ݮڮֲڭܩ(-628844692));
        IS_OS_WINDOWS_8 = getOsMatchesName(y.ۮڭڭܬި(862243491));
        IS_OS_WINDOWS_10 = getOsMatchesName(y.ݮڮֲڭܩ(-628844612));
        IS_OS_ZOS = getOsMatchesName(y.ݬֲ֮ܲت(1512675287));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getJavaHome() {
        return new File(System.getProperty(y.֬ڱܱײٮ(-1159265279)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getHostName() {
        return System.getenv(IS_OS_WINDOWS ? y.٬ݯح׭٩(575895630) : y.٬ݯح׭٩(575895774));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getJavaIoTmpDir() {
        return new File(System.getProperty(y.ٴسسݬߨ(1392990666)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean getJavaVersionMatches(String str) {
        return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean getOsMatches(String str, String str2) {
        return isOSMatch(OS_NAME, OS_VERSION, str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean getOsMatchesName(String str) {
        return isOSNameMatch(OS_NAME, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getSystemProperty(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getEnvironmentVariable(String str, String str2) {
        try {
            String str3 = System.getenv(str);
            return str3 == null ? str2 : str3;
        } catch (SecurityException unused) {
            return str2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getUserDir() {
        return new File(System.getProperty(y.٬ݯح׭٩(575892166)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static File getUserHome() {
        return new File(System.getProperty(y.֬ڱܱײٮ(-1159662983)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isJavaAwtHeadless() {
        return Boolean.TRUE.toString().equals(JAVA_AWT_HEADLESS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isJavaVersionAtLeast(JavaVersion javaVersion) {
        return JAVA_SPECIFICATION_VERSION_AS_ENUM.atLeast(javaVersion);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isJavaVersionMatch(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isOSMatch(String str, String str2, String str3, String str4) {
        return str != null && str2 != null && isOSNameMatch(str, str3) && isOSVersionMatch(str2, str4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isOSNameMatch(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isOSVersionMatch(String str, String str2) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        String str3 = y.ݮڮֲڭܩ(-628930060);
        String[] split = str2.split(str3);
        String[] split2 = str.split(str3);
        for (int i = 0; i < Math.min(split.length, split2.length); i++) {
            if (!split[i].equals(split2[i])) {
                return false;
            }
        }
        return true;
    }
}
