package org.apache.commons.lang3.exception;

import com.liapp.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: classes2.dex */
public class DefaultExceptionContext implements ExceptionContext, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List<Pair<String, Object>> contextValues = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.contextValues.add(new ImmutablePair(str, obj));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext setContextValue(String str, Object obj) {
        Iterator<Pair<String, Object>> it = this.contextValues.iterator();
        while (it.hasNext()) {
            if (StringUtils.equals(str, it.next().getKey())) {
                it.remove();
            }
        }
        addContextValue(str, obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Pair<String, Object> pair : this.contextValues) {
            if (StringUtils.equals(str, pair.getKey())) {
                arrayList.add(pair.getValue());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(String str) {
        for (Pair<String, Object> pair : this.contextValues) {
            if (StringUtils.equals(str, pair.getKey())) {
                return pair.getValue();
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        HashSet hashSet = new HashSet();
        Iterator<Pair<String, Object>> it = this.contextValues.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getKey());
        }
        return hashSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        if (!this.contextValues.isEmpty()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append("Exception Context:\n");
            int i = 0;
            for (Pair<String, Object> pair : this.contextValues) {
                sb.append(y.دײܮڳܯ(2051669437));
                i++;
                sb.append(i);
                sb.append(':');
                sb.append(pair.getKey());
                sb.append(y.ۮڭڭܬި(862004339));
                Object value = pair.getValue();
                if (value == null) {
                    sb.append(y.ݮڮֲڭܩ(-628841308));
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e) {
                        str2 = y.دײܮڳܯ(2051669405) + ExceptionUtils.getStackTrace(e);
                    }
                    sb.append(str2);
                }
                sb.append(y.ݬֲ֮ܲت(1512690535));
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }
}
