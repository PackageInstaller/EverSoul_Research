package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class Paging implements Serializable {
    static final String COUNT = "count";
    static final String PER_PAGE = "per_page";
    private static final long serialVersionUID = -7226113618341047983L;
    private int count;
    private long maxId;
    private int page;
    private long sinceId;

    /* renamed from: S */
    static final char[] f1567S = {'s'};
    static final char[] SMCP = {'s', 'm', 'c', 'p'};
    private static final HttpParameter[] NULL_PARAMETER_ARRAY = new HttpParameter[0];
    private static final List<HttpParameter> NULL_PARAMETER_LIST = new ArrayList(0);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    List<HttpParameter> asPostParameterList() {
        return asPostParameterList(SMCP, y.٬ݯح׭٩(575838374));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpParameter[] asPostParameterArray() {
        List<HttpParameter> asPostParameterList = asPostParameterList(SMCP, y.٬ݯح׭٩(575838374));
        if (asPostParameterList.size() == 0) {
            return NULL_PARAMETER_ARRAY;
        }
        return (HttpParameter[]) asPostParameterList.toArray(new HttpParameter[asPostParameterList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    List<HttpParameter> asPostParameterList(char[] cArr) {
        return asPostParameterList(cArr, y.٬ݯح׭٩(575838374));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    List<HttpParameter> asPostParameterList(char[] cArr, String str) {
        ArrayList arrayList = new ArrayList(cArr.length);
        addPostParameter(cArr, 's', arrayList, y.دײܮڳܯ(2051152541), getSinceId());
        addPostParameter(cArr, 'm', arrayList, y.֬ڱܱײٮ(-1158986751), getMaxId());
        addPostParameter(cArr, 'c', arrayList, str, getCount());
        addPostParameter(cArr, 'p', arrayList, y.ٲٴݴ״ٰ(1782449768), getPage());
        return arrayList.size() == 0 ? NULL_PARAMETER_LIST : arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpParameter[] asPostParameterArray(char[] cArr, String str) {
        ArrayList arrayList = new ArrayList(cArr.length);
        addPostParameter(cArr, 's', arrayList, y.دײܮڳܯ(2051152541), getSinceId());
        addPostParameter(cArr, 'm', arrayList, y.֬ڱܱײٮ(-1158986751), getMaxId());
        addPostParameter(cArr, 'c', arrayList, str, getCount());
        addPostParameter(cArr, 'p', arrayList, y.ٲٴݴ״ٰ(1782449768), getPage());
        if (arrayList.size() == 0) {
            return NULL_PARAMETER_ARRAY;
        }
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addPostParameter(char[] cArr, char c, List<HttpParameter> list, String str, long j) {
        int length = cArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (cArr[i] == c) {
                z = true;
                break;
            }
            i++;
        }
        if (!z && -1 != j) {
            throw new IllegalStateException("Paging parameter [" + str + "] is not supported with this operation.");
        }
        if (-1 != j) {
            list.add(new HttpParameter(str, String.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging() {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1L;
        this.maxId = -1L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging(int i) {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1L;
        this.maxId = -1L;
        setPage(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging(long j) {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1L;
        this.maxId = -1L;
        setSinceId(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging(int i, int i2) {
        this(i);
        setCount(i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging(int i, long j) {
        this(i);
        setSinceId(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging(int i, int i2, long j) {
        this(i, i2);
        setSinceId(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging(int i, int i2, long j, long j2) {
        this(i, i2, j);
        setMaxId(j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPage() {
        return this.page;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPage(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1393235002) + i);
        }
        this.page = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCount() {
        return this.count;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCount(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1782449848) + i);
        }
        this.count = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging count(int i) {
        setCount(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getSinceId() {
        return this.sinceId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSinceId(long j) {
        if (j < 1) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1782450848) + j);
        }
        this.sinceId = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging sinceId(long j) {
        setSinceId(j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getMaxId() {
        return this.maxId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxId(long j) {
        if (j < 1) {
            throw new IllegalArgumentException(y.ۮڭڭܬި(862941747) + j);
        }
        this.maxId = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paging maxId(long j) {
        setMaxId(j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paging)) {
            return false;
        }
        Paging paging = (Paging) obj;
        return this.count == paging.count && this.maxId == paging.maxId && this.page == paging.page && this.sinceId == paging.sinceId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int i = ((this.page * 31) + this.count) * 31;
        long j = this.sinceId;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.maxId;
        return i2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1158985191) + this.page + y.ݮڮֲڭܩ(-628153404) + this.count + y.֬ڱܱײٮ(-1158984999) + this.sinceId + y.دײܮڳܯ(2051150389) + this.maxId + '}';
    }
}
