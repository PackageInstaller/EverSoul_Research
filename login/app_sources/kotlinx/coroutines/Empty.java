package kotlinx.coroutines;

import com.kakao.sdk.template.Constants;
import kotlin.Metadata;

/* compiled from: JobSupport.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, m839d2 = {"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", "", "(Z)V", "()Z", Constants.TYPE_LIST, "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
final class Empty implements Incomplete {
    private final boolean isActive;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Empty(boolean z) {
        this.isActive = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return this.isActive;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Empty{" + (isActive() ? "Active" : "New") + '}';
    }
}
