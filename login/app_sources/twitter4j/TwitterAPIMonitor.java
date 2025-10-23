package twitter4j;

import com.liapp.y;
import java.lang.management.ManagementFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import twitter4j.management.APIStatistics;
import twitter4j.management.APIStatisticsMBean;
import twitter4j.management.APIStatisticsOpenMBean;

/* loaded from: classes4.dex */
public class TwitterAPIMonitor {
    private static final APIStatistics STATISTICS;
    private static final Logger logger = Logger.getLogger(TwitterAPIMonitor.class);
    private static final Pattern pattern = Pattern.compile(y.٬ݯح׭٩(575110142));
    private static final TwitterAPIMonitor SINGLETON = new TwitterAPIMonitor();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        APIStatistics aPIStatistics = new APIStatistics(100);
        STATISTICS = aPIStatistics;
        try {
            ManagementFactory.getPlatformMBeanServer().registerMBean(new APIStatisticsOpenMBean(aPIStatistics), new ObjectName("twitter4j.mbean:type=APIStatisticsOpenMBean"));
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (MalformedObjectNameException e2) {
            e2.printStackTrace();
            logger.error(e2.getMessage());
        } catch (MBeanRegistrationException e3) {
            e3.printStackTrace();
            logger.error(e3.getMessage());
        } catch (NotCompliantMBeanException e4) {
            e4.printStackTrace();
            logger.error(e4.getMessage());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TwitterAPIMonitor() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TwitterAPIMonitor getInstance() {
        return SINGLETON;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public APIStatisticsMBean getStatistics() {
        return STATISTICS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void methodCalled(String str, long j, boolean z) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches() || matcher.groupCount() <= 0) {
            return;
        }
        STATISTICS.methodCalled(matcher.group(1), j, z);
    }
}
