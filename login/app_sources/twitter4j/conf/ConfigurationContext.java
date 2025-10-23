package twitter4j.conf;

import com.liapp.y;

/* loaded from: classes4.dex */
public final class ConfigurationContext {
    private static final String CONFIGURATION_IMPL = "twitter4j.configurationFactory";
    private static final String DEFAULT_CONFIGURATION_FACTORY = "twitter4j.conf.PropertyConfigurationFactory";
    private static final ConfigurationFactory factory;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String str = y.٬ݯح׭٩(575018086);
        try {
            str = System.getProperty(CONFIGURATION_IMPL, str);
        } catch (SecurityException unused) {
        }
        try {
            factory = (ConfigurationFactory) Class.forName(str).newInstance();
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InstantiationException e3) {
            throw new AssertionError(e3);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Configuration getInstance() {
        return factory.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Configuration getInstance(String str) {
        return factory.getInstance(str);
    }
}
