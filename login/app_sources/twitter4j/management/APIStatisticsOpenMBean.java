package twitter4j.management;

import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.management.openmbean.OpenMBeanInfoSupport;
import javax.management.openmbean.OpenMBeanOperationInfoSupport;
import javax.management.openmbean.OpenMBeanParameterInfoSupport;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

/* loaded from: classes4.dex */
public class APIStatisticsOpenMBean implements DynamicMBean {
    private final APIStatisticsMBean API_STATISTICS;
    private final TabularType API_STATISTICS_TYPE;
    private final CompositeType METHOD_STATS_TYPE;
    private static final String[] ITEM_NAMES = {y.ۮڭڭܬި(863067091), y.٬ݯح׭٩(575076214), y.دײܮڳܯ(2052862445), y.ٴسسݬߨ(1393898010), y.ݬֲ֮ܲت(1513888007)};
    private static final OpenType[] ITEM_TYPES = {SimpleType.STRING, SimpleType.LONG, SimpleType.LONG, SimpleType.LONG, SimpleType.LONG};
    private static final String[] ITEM_DESCRIPTIONS = {y.٬ݯح׭٩(575065198), y.ٴسسݬߨ(1393887418), y.֬ڱܱײٮ(-1158326447), y.ݬֲ֮ܲت(1513887847), y.֬ڱܱײٮ(-1158327527)};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public APIStatisticsOpenMBean(APIStatistics aPIStatistics) {
        this.API_STATISTICS = aPIStatistics;
        try {
            CompositeType compositeType = new CompositeType("method statistics", "method statistics", ITEM_NAMES, ITEM_DESCRIPTIONS, ITEM_TYPES);
            this.METHOD_STATS_TYPE = compositeType;
            this.API_STATISTICS_TYPE = new TabularType("API statistics", "list of methods", compositeType, new String[]{"methodName"});
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MBeanInfo getMBeanInfo() {
        return new OpenMBeanInfoSupport(getClass().getName(), y.دײܮڳܯ(2052850157), new OpenMBeanAttributeInfoSupport[]{new OpenMBeanAttributeInfoSupport(y.٬ݯح׭٩(575076214), y.ٴسسݬߨ(1393886562), SimpleType.LONG, true, false, false), new OpenMBeanAttributeInfoSupport("errorCount", "The number of failed API calls", SimpleType.LONG, true, false, false), new OpenMBeanAttributeInfoSupport(y.ݮڮֲڭܩ(-628015188), y.ٴسسݬߨ(1393886794), SimpleType.LONG, true, false, false), new OpenMBeanAttributeInfoSupport(y.ٴسسݬߨ(1393898010), y.ٴسسݬߨ(1393886794), SimpleType.LONG, true, false, false), new OpenMBeanAttributeInfoSupport(y.ݮڮֲڭܩ(-628015324), y.ۮڭڭܬި(863071811), this.API_STATISTICS_TYPE, true, false, false)}, new OpenMBeanConstructorInfoSupport[]{new OpenMBeanConstructorInfoSupport(y.ٴسسݬߨ(1393885810), y.֬ڱܱײٮ(-1158324855), new OpenMBeanParameterInfoSupport[0])}, new OpenMBeanOperationInfoSupport[]{new OpenMBeanOperationInfoSupport(y.٬ݯح׭٩(576442950), y.֬ڱܱײٮ(-1158324271), new OpenMBeanParameterInfoSupport[0], SimpleType.VOID, 0)}, new MBeanNotificationInfo[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized TabularDataSupport getStatistics() {
        TabularDataSupport tabularDataSupport;
        tabularDataSupport = new TabularDataSupport(this.API_STATISTICS_TYPE);
        for (InvocationStatistics invocationStatistics : this.API_STATISTICS.getInvocationStatistics()) {
            try {
                tabularDataSupport.put(new CompositeDataSupport(this.METHOD_STATS_TYPE, ITEM_NAMES, new Object[]{invocationStatistics.getName(), Long.valueOf(invocationStatistics.getCallCount()), Long.valueOf(invocationStatistics.getErrorCount()), Long.valueOf(invocationStatistics.getTotalTime()), Long.valueOf(invocationStatistics.getAverageTime())}));
            } catch (OpenDataException e) {
                throw new RuntimeException((Throwable) e);
            }
        }
        return tabularDataSupport;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset() {
        this.API_STATISTICS.reset();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getAttribute(String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (str.equals(y.ݮڮֲڭܩ(-628015324))) {
            return getStatistics();
        }
        if (str.equals(y.٬ݯح׭٩(575076214))) {
            return Long.valueOf(this.API_STATISTICS.getCallCount());
        }
        if (str.equals(y.دײܮڳܯ(2052862445))) {
            return Long.valueOf(this.API_STATISTICS.getErrorCount());
        }
        if (str.equals(y.ٴسسݬߨ(1393898010))) {
            return Long.valueOf(this.API_STATISTICS.getTotalTime());
        }
        if (str.equals(y.ݮڮֲڭܩ(-628015188))) {
            return Long.valueOf(this.API_STATISTICS.getAverageTime());
        }
        throw new AttributeNotFoundException(y.ٴسسݬߨ(1393886266) + str + y.ٲٴݴ״ٰ(1780489152));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AttributeList getAttributes(String[] strArr) {
        AttributeList attributeList = new AttributeList();
        if (strArr.length == 0) {
            return attributeList;
        }
        for (String str : strArr) {
            try {
                attributeList.add(new Attribute(str, getAttribute(str)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return attributeList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object invoke(String str, Object[] objArr, String[] strArr) throws MBeanException, ReflectionException {
        if (str.equals(Base2ndPWViewData.KEY_RESET)) {
            reset();
            return "Statistics reset";
        }
        throw new ReflectionException(new NoSuchMethodException(str), y.ۮڭڭܬި(863073603) + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        throw new AttributeNotFoundException(y.٬ݯح׭٩(575068518));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AttributeList setAttributes(AttributeList attributeList) {
        return new AttributeList();
    }
}
