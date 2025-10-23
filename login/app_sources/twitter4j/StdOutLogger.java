package twitter4j;

import com.liapp.y;
import java.util.Date;
import twitter4j.conf.ConfigurationContext;

/* loaded from: classes4.dex */
final class StdOutLogger extends Logger {
    private static final boolean DEBUG = ConfigurationContext.getInstance().isDebugEnabled();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isErrorEnabled() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isInfoEnabled() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isWarnEnabled() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StdOutLogger() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public boolean isDebugEnabled() {
        return DEBUG;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void debug(String str) {
        if (DEBUG) {
            System.out.println(y.ٴسسݬߨ(1392956562) + new Date() + y.ۮڭڭܬި(862078387) + str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void debug(String str, String str2) {
        if (DEBUG) {
            debug(str + str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void info(String str) {
        System.out.println(y.ٴسسݬߨ(1392956562) + new Date() + y.ۮڭڭܬި(862078387) + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void info(String str, String str2) {
        info(str + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void warn(String str) {
        System.out.println(y.ٴسسݬߨ(1392956562) + new Date() + y.ۮڭڭܬި(862078387) + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void warn(String str, String str2) {
        warn(str + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void warn(String str, Throwable th) {
        System.out.println(str);
        th.printStackTrace(System.err);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void error(String str) {
        System.out.println(y.ٴسسݬߨ(1392956562) + new Date() + y.ۮڭڭܬި(862078387) + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Logger
    public void error(String str, Throwable th) {
        System.out.println(str);
        th.printStackTrace(System.err);
    }
}
