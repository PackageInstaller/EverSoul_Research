package twitter4j;

import com.liapp.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

/* loaded from: classes4.dex */
public abstract class Logger {
    private static final LoggerFactory LOGGER_FACTORY;
    private static final String LOGGER_FACTORY_IMPLEMENTATION = "twitter4j.loggerFactory";
    private static final String LOGGER_FACTORY_IMPLEMENTATION_ENV = "twitter4j_loggerFactory";

    public abstract void debug(String str);

    public abstract void debug(String str, String str2);

    public abstract void error(String str);

    public abstract void error(String str, Throwable th);

    public abstract void info(String str);

    public abstract void info(String str, String str2);

    public abstract boolean isDebugEnabled();

    public abstract boolean isErrorEnabled();

    public abstract boolean isInfoEnabled();

    public abstract boolean isWarnEnabled();

    public abstract void warn(String str);

    public abstract void warn(String str, String str2);

    public abstract void warn(String str, Throwable th);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String property = System.getProperty(y.ݬֲ֮ܲت(1512182895));
        if (property == null) {
            property = System.getenv(y.ݬֲ֮ܲت(1512182567));
        }
        LoggerFactory loggerFactoryIfAvailable = property != null ? getLoggerFactoryIfAvailable(property, property) : null;
        Configuration configurationContext = ConfigurationContext.getInstance();
        String loggerFactory = configurationContext.getLoggerFactory();
        if (loggerFactory != null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable(loggerFactory, loggerFactory);
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable(y.֬ڱܱײٮ(-1158978375), y.٬ݯح׭٩(576257710));
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable(y.ݬֲ֮ܲت(1512181783), y.ۮڭڭܬި(862936507));
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable(y.ۮڭڭܬި(862936307), y.ݬֲ֮ܲت(1512185111));
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = getLoggerFactoryIfAvailable(y.ݮڮֲڭܩ(-628161748), y.ݮڮֲڭܩ(-628161212));
        }
        if (loggerFactoryIfAvailable == null) {
            loggerFactoryIfAvailable = new StdOutLoggerFactory();
        }
        LOGGER_FACTORY = loggerFactoryIfAvailable;
        try {
            Method method = configurationContext.getClass().getMethod("dumpConfiguration", new Class[0]);
            method.setAccessible(true);
            method.invoke(configurationContext, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static LoggerFactory getLoggerFactoryIfAvailable(String str, String str2) {
        try {
            Class.forName(str);
            return (LoggerFactory) Class.forName(str2).newInstance();
        } catch (ClassNotFoundException | SecurityException unused) {
            return null;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logger getLogger(Class<?> cls) {
        return LOGGER_FACTORY.getLogger(cls);
    }
}
